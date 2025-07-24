package com.yash.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entities.Quiz;
import com.yash.repo.QuizRepo;

@Service
public class QuizService 
{
	@Autowired
	private QuizRepo repo;
	
	@Autowired
	private QuestionsClient client;
	
	//create
	public Quiz createQuiz(Quiz q)
	{
		return repo.save(q);
	}
	
	//show all
	public List<Quiz> showAll()
	{
		List<Quiz> quizes = repo.findAll();
		
		List<Quiz> newQuizes = quizes.stream().map(quiz->{
			quiz.setQuestionss(client.getQuesByquizId(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizes;
	}
	
	//show one
	public Quiz showOne(long id)
	{
		Quiz q = repo.findById(id).orElseThrow(()-> new RuntimeException("not found"));
		q.setQuestionss(client.getQuesByquizId(q.getId()));
		return q;
	}
}
