package com.in28minutes.springboot.myfirstwebapp.Todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class TodoController {
		
	@Autowired 
	private TodoService todoService;
	
		@RequestMapping("list-todos")
		public String listAllTodos(ModelMap model) {
			List<Todo> todos = todoService.FindByUsername("in28minutes");
			model.addAttribute("todos", todos);
			return "listTodos";
		}
		
		@RequestMapping(value="add-todo", method= RequestMethod.GET)
		public String showNewTodoPage(ModelMap model) {
			Todo todo = new Todo(); //默認值id=0, boolean為false
			model.put("todo", todo);
			return "todo";
		}
		
		@RequestMapping(value="add-todo", method= RequestMethod.POST)
		public String addNewTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		    if(result.hasErrors()) {
		        return "todo";
		    }
		    todoService.addTodo(todo.getUsername(), todo.getDescription(), LocalDate.now().plusYears(1), false);
		    return "redirect:list-todos";
		}
		
		@RequestMapping("delete-todo")
		public String deleteTodo(@RequestParam int id) {
		    todoService.deleteById(id);
		    return "redirect:list-todos";
		}

}
