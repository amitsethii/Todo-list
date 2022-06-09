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
	
	//from browser localhost:8080 we get req and send the form
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showform(ModelMap Map){
		return "demo";
	}
	
	//from form we get post req & data saved in @Reqparam form URL
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showdemo(ModelMap model,@RequestParam String name , @RequestParam String password ){
		                              //url to this @RequestParam String name
		boolean isValid = service.valid(name, password);
		//validating username & passwprd that we get
		if(!isValid) {
			model.put("err","wrong cred ");
			return "demo";
		}
		 // putting that data on jsp (jsp,get from service or GET ) 
		model.put("name", name);  //available to jsp
		model.put("password", password);
		
		return "welcome";
	}
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String todoPage(ModelMap model){
		String name = (String) model.get("name");
		// putting that data on jsp{todos} (jsp,get from service or GET ) 
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
