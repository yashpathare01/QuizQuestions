package com.yash.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long>
{

}
