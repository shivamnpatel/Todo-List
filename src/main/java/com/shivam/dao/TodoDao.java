package com.shivam.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.shivam.entities.Todo;
import com.shivam.helper.FactoryProvider;

@Component
public class TodoDao {

	// save todo with userEmail in database for add-todo page
	public void saveTodo(String desc,Date targetDate, String userEmail) 
	{
		Session session = FactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();
		Todo todo = new Todo(userEmail,desc,targetDate);
		session.save(todo);
		session.getTransaction().commit();
		session.close();
	}

	// retrieve todo by userEmail
	public List<Todo> getTodoByEmail(String userEmail)
	{
		List<Todo> todoByEmail = null;
		Session session = FactoryProvider.getSessionFactory().openSession();
		Query query = session.createQuery("From Todo where userEmail=:e");
		query.setParameter("e", userEmail);
		todoByEmail = (List<Todo>) query.getResultList();
		
		session.close();
		return todoByEmail;
	}
	
	// retrieve todo by id
	public Todo getTodoById(int id)
	{
		Todo todoById = null;
		Session session = FactoryProvider.getSessionFactory().openSession();
		Query query = session.createQuery("From Todo where id=:i");
		query.setParameter("i", id);
		todoById = (Todo) query.uniqueResult();
		
		session.close();
		return todoById;
	}
	
	// update todo
	public void updateTodo(Todo todo)
	{
		Session session = FactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(todo);
		session.getTransaction().commit();
		session.close();
	}
	
	// delete todo
	public void deleteTodo(Todo todo)
	{
		Session session = FactoryProvider.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(todo);
		session.getTransaction().commit();
		session.close();
	}
}
