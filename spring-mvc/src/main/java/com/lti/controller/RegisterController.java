package com.lti.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.entity.User;
import com.lti.entity.UserDTO;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterInf dao;
	
		@RequestMapping(path = "/register.lti",method = RequestMethod.POST)
	public String register(UserDTO userDTO) {
			
				//code for processing the uploaded file
		String path="d:/uploads/";
		String filename=userDTO.getName() + "-" + userDTO.getProfilePic().getOriginalFilename();
		String finalpath= path+filename;
		try {
		userDTO.getProfilePic().transferTo(new File(finalpath));
		} catch (IOException e)  {
			e.printStackTrace();
		}
 	
		//now the code to store data in the database
		User user=new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setAge(userDTO.getAge());
		user.setProfilePicFilename(filename);
		dao.addNewUser(user);
		//System.out.println(user);
		
		return "register.jsp";
		
	}


@RequestMapping(path = "/searchUser.lti" , method = RequestMethod.POST)
public String search(@RequestParam("email") String email,
		Map<String,Object> model) {
	
	User user  = dao.fetch(email);
	model.put("userData",user);
	
	return "searchResult.jsp";
}

}

