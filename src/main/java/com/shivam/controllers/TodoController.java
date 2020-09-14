package com.shivam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shivam.dao.TodoDao;
import com.shivam.entities.Todo;

@Controller
@SessionAttributes("userEmail")
public class TodoController {

	@Autowired
	TodoDao todoDao;
	
	@GetMapping("/todos")
	public String listTodos(Model model) 
	{	
		List<Todo> todoByEmail = todoDao.getTodoByEmail((String) model.getAttribute("userEmail"));
		model.addAttribute("todos", todoByEmail);
		return "todos";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.GET)
	public String addTodoPage(@ModelAttribute Todo todo)
	{	
		return "todo";
	}
	
	@RequestMapping(value = "/add-todo",method = RequestMethod.POST)
	public String addTodoToDB(@ModelAttribute Todo todo,Model model,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Error in adding todo");
			return "todos";
		}
		
		String userEmail = (String) model.getAttribute("userEmail");
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
	public String updateTodoInDB(Todo todo,Model model,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()) {
			return "todo";
		}
		todo.setUserEmail((String) model.getAttribute("userEmail"));
		todoDao.updateTodo(todo);
		System.out.println(todo);
		
		return "redirect:/todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoFromDB(@RequestParam int id,Todo todo)
	{		
		todoDao.deleteTodo(todo);
		return "redirect:/todos";
	}
}

