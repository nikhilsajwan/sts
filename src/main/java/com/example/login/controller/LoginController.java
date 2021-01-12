package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.User;
import com.example.login.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/user")
	public List<User> get(){
		return loginService.get();
	}
	
	@PostMapping("/usersignup")
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody User userObj) {
		
		if(userObj.getUsername()==null||userObj.getPassword()==null)
		{
			return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
		}
		User db=loginService.get(userObj.getUsername());
		if(db!=null) {
			return new ResponseEntity<>("user already exists",HttpStatus.BAD_REQUEST);
		}
		
		loginService.save(userObj);
		return new ResponseEntity<>(userObj,HttpStatus.OK);
		
	}
	@PostMapping("/userauth")
	@ResponseBody
	public ResponseEntity<?> get(@RequestBody User userObj) {
		if(userObj.getUsername()==null||userObj.getPassword()==null)
		{
			return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
		}
		User db=loginService.get(userObj.getUsername());
		if(db==null) {
			return new ResponseEntity<>("user does not exist",HttpStatus.BAD_REQUEST);
		}
		if(db.getPassword().equals(userObj.getPassword())) {
			return new ResponseEntity<>(userObj,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>("unauthorised",HttpStatus.UNAUTHORIZED);
		}
	}
	

	
	
}
