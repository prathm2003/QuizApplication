package com.quizapp.dto;

import java.util.Map;

public class QuizSubmitRequestDto {
    private Map<Integer, String> answers;

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }
}
