package com.shivam.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivam.dao.TodoDao;
import com.shivam.entities.Todo;

@Controller
//@SessionAttributes("userEmail")
public class TodoController {

	@Autowired
	TodoDao todoDao;
	@Autowired
	HttpSession session;
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		// dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/todos")
	public String listTodos(Model model) 
	{	
		List<Todo> todoByEmail = todoDao.getTodoByEmail((String) session.getAttribute("userEmail"));
		model.addAttribute("todos", todoByEmail);
		return "todos";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.GET)
	public String addTodoPage(@ModelAttribute Todo todo)
	{	
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.POST)
	public String addTodoToDB(@ModelAttribute Todo todo,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Error in adding todo");
			return "todos";
		}
		
		String userEmail = (String) session.getAttribute("userEmail");
		todoDao.saveTodo(todo.getDescription(), todo.getTargetDate(), userEmail);
	
		return "redirect:/todos";
	}
	
	@RequestMapping(value = "/update-todo",method = RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id,Model model) 
	{
		Todo todoById = todoDao.getTodoById(id);
		model.addAttribute("todo", todoById);
		
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodoInDB(Todo todo,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		todo.setUserEmail((String) session.getAttribute("userEmail"));
		todoDao.updateTodo(todo);
		System.out.println(todo);
		
		return "redirect:/todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoFromDB(@RequestParam int id)
	{		
		Todo todoById = todoDao.getTodoById(id);
		todoDao.deleteTodo(todoById);
		return "redirect:/todos";
	}
}

