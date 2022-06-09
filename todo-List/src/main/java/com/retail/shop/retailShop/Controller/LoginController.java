package com.retail.shop.retailShop.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.retail.shop.retailShop.service.TodoService;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	TodoService service;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showform(ModelMap Map){
		return "demo";
	}
	

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showdemo(ModelMap model,@RequestParam String name , @RequestParam String password ){
		                           
		boolean isValid = service.valid(name, password);
		
		if(!isValid) {
			model.put("err","wrong cred ");
			return "demo";
		}
		          //(get,jsp) 
		model.put("name", name);  //available to jsp
		model.put("password", password);
		
		return "welcome";
	}
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String todoPage(ModelMap model){
		String name = (String) model.get("name");
		model.put("todos",service.retrieveTodos(name));  //take data with same name and show on jsp
		return "list-todos";
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showaddtodo(ModelMap model){	
		return "todo";
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deletetodo(@RequestParam int id){	
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addtodo(ModelMap model , @RequestParam String desc){	
		service.addTodo((String)model.get("name"), desc, new Date(), false);
		return "redirect:/list-todos";
	}
	
	
	
	

		
}
