package com.quizapp.service;

import com.quizapp.dto.QuizQuestionResponseDto;
import com.quizapp.dto.QuizResultResponseDto;
import com.quizapp.dto.QuizSubmitRequestDto;
import com.quizapp.model.QuizQuestion;

import java.util.List;

public interface QuizServiceInterface {
    public List<QuizQuestionResponseDto> getQuestions();
    public QuizResultResponseDto submitQuiz(QuizSubmitRequestDto request);
    public void addQuestion(QuizQuestion question);
}
