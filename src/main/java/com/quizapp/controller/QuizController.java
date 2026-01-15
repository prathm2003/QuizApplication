package com.quizapp.controller;

import com.quizapp.dto.QuizQuestionResponseDto;
import com.quizapp.dto.QuizResultResponseDto;
import com.quizapp.dto.QuizSubmitRequestDto;
import com.quizapp.model.QuizQuestion;
import com.quizapp.service.QuizService;
import com.quizapp.service.QuizServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizServiceInterface service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/getquestions")
    public ResponseEntity<List<QuizQuestionResponseDto>> getQuestions() {
        return ResponseEntity.ok(service.getQuestions());
    }

    @PostMapping("/submit")
    public ResponseEntity<QuizResultResponseDto> submitQuiz( @RequestBody QuizSubmitRequestDto request) {
        return ResponseEntity.ok(service.submitQuiz(request));
    }

    @PostMapping("/addquestion")
    public ResponseEntity<Void> addQuestion( @RequestBody QuizQuestion question ) {
        service.addQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
