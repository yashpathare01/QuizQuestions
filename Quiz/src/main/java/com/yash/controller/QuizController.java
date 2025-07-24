package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.entities.Quiz;
import com.yash.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController 
{
	@Autowired
	private QuizService service;
	
	//create
	@PostMapping
	public Quiz createQuiz(@RequestBody Quiz q)
	{
		return service.createQuiz(q);
	}
	
	//show all
	@GetMapping
	public List<Quiz> showAll()
	{
		return service.showAll();
	}
	
	//show one
	@GetMapping("/{id}")
	public Quiz showOne(@PathVariable long id)
	{
		return service.showOne(id);
	}
}
