package pro.sky.Coursework_2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Coursework_2.exceptions.IncorrectSizeQuestionException;
import pro.sky.Coursework_2.service.QuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.Coursework_2.service.ExamTestConstants.*;
import static pro.sky.Coursework_2.service.ExamTestConstants.MOCK_QUESTIONS;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Test
    public  void shouldThrowIncorrectSizeQuestionException() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        assertThatExceptionOfType(IncorrectSizeQuestionException.class)
                .isThrownBy(() -> examinerService.getQuestion(6));
        assertThatExceptionOfType(IncorrectSizeQuestionException.class)
                .isThrownBy(() -> examinerService.getQuestion(MOCK_QUESTIONS.size() + 1));
    }
    @Test
    public void shouldGetRandomQuestion() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4
        );
        int questionAmount = MOCK_QUESTIONS.size() - 2;
        assertThat(examinerService.getQuestion(questionAmount))
                .hasSize(questionAmount);
    }
}