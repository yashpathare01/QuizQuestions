package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Questions;
import com.yash.service.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionsController 
{
	
	@Autowired
	private QuestionsService service;
	
	
	//create 
	@PostMapping
	public Questions createQues(@RequestBody Questions q)
	{
		return service.createQues(q);
	}
	
	//get all
	@GetMapping
	public List<Questions> getALl()
	{
		return service.showAll();
	}
	
	//get one
	@GetMapping("/{qid}")
	public Questions getOne(@PathVariable long qid)
	{
		return service.showOne(qid);
	}
	
	//getQuesByquizId
	@GetMapping("/quiz/{quizId}")
	public List<Questions> getQuesByquizId(@PathVariable long quizId)
	{
		return service.getQuesByquizId(quizId);
	}
	
}
