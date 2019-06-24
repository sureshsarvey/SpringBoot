package com.boot.database.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.database.service.UserService;
import com.boot.database.test.model.Employee;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String getWelcomePage()
	{
		return "login";
	}
	
	@PostMapping("/processLogin")
	public String checkUser(HttpServletRequest request)
	{
		String userId = request.getParameter("username");
		String password = request.getParameter("password");
		try
		{
			boolean flag = userService.processLogin(userId, password);
			if(flag)
			{
				return "details";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "login";
	}
	
	@GetMapping("/getDetails")
	@ResponseBody
	public Employee getDetails()
	{
		try
		{
			return userService.getEmployee();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping("/register")
	@ResponseBody
	public String registerEmployee()
	{
		try
		{
			 Employee emp = new Employee();
             emp.setEmployeeId(477);
             emp.setEmployeeName("suresh");
             userService.registerEmployee(emp);
             return "success";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "failed";
			
		}
	}

}
