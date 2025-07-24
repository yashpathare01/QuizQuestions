package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entities.Questions;
import com.yash.repository.QuestionsRepo;

@Service
public class QuestionsService 
{
	@Autowired
	private QuestionsRepo repo;
	
	
	//create
	public Questions createQues(Questions q)
	{
		return repo.save(q);
	}
	
	//show all
	public List<Questions> showAll()
	{
		return repo.findAll();
	}
	
	//show one
	public Questions showOne(long qid)
	{
		return repo.findById(qid).orElseThrow(()-> new RuntimeException("not found"));
	}
	
	//getByQuizId
	public List<Questions> getQuesByquizId(long quizId)
	{
		return repo.findByQuizId(quizId);
	}
}
