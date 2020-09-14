package com.shivam.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.shivam.entities.LoginUser;
import com.shivam.entities.RegisterUser;
import com.shivam.helper.FactoryProvider;

@Component
public class UserDao {

	//save user data for register page
	public void saveUserDetails(RegisterUser userDetails) 
	{
		Session session = FactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}
	
	// retrieve data for login page
	public RegisterUser getUserByEmailPassword(LoginUser loginUserDetails)
	{
		RegisterUser user = null;
		try 
		{
			Session session = FactoryProvider.getSessionFactory().openSession();
			String query = "from RegisterUser where email =:e and password =:p"; 
			Query q = session.createQuery(query);
			q.setParameter("e", loginUserDetails.getEmail());
			q.setParameter("p", loginUserDetails.getPassword());
			
			user = (RegisterUser) q.uniqueResult();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	
		return user;
	}
}
