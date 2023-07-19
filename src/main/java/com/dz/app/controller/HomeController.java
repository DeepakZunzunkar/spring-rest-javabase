package com.dz.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(value="/")
	public String isalive() {
		return "i am alive...!";
	}
	
	@RequestMapping(value="/test1")
	public ResponseEntity<String> test1() {
		return new ResponseEntity<String>("testiing..",HttpStatus.OK);
	}
	
	@RequestMapping(value="/test2",method=RequestMethod.GET)
	public ResponseEntity<List<String>> test2() {
		
		List<String> list=new ArrayList<String>();
		list.add("tes1");
		list.add("tes2");
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
}
