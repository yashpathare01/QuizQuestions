package com.yash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entities.Questions;

public interface QuestionsRepo extends JpaRepository<Questions, Long>
{
	List<Questions> findByQuizId(long quizId);
}
