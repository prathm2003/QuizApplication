package com.quizapp.service;

import com.quizapp.dto.QuizQuestionResponseDto;
import com.quizapp.dto.QuizResultResponseDto;
import com.quizapp.dto.QuizSubmitRequestDto;
import com.quizapp.model.QuizQuestion;
import com.quizapp.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService implements QuizServiceInterface{

    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public List<QuizQuestionResponseDto> getQuestions() {
        List<QuizQuestion> questions = repository.findAll();
        List<QuizQuestionResponseDto> response = new ArrayList<>();

        for (QuizQuestion q : questions) {
            QuizQuestionResponseDto dto = new QuizQuestionResponseDto();
            dto.setId(q.getId());
            dto.setQuestion(q.getQuestion());
            dto.setOptions(List.of(
                    q.getOptionA(),
                    q.getOptionB(),
                    q.getOptionC(),
                    q.getOptionD()
            ));
            response.add(dto);
        }
        return response;
    }


    public QuizResultResponseDto submitQuiz(QuizSubmitRequestDto request) {
        int score = 0;

        for (var entry : request.getAnswers().entrySet()) {
            QuizQuestion q = repository.findById(entry.getKey());
            if (q.getCorrectOption().equalsIgnoreCase(entry.getValue())) {
                score++;
            }
        }
        return new QuizResultResponseDto(score, request.getAnswers().size());
    }

    public void addQuestion(QuizQuestion question) {
        repository.save(question);
    }
}
