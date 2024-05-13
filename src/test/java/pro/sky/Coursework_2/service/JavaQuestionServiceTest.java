package pro.sky.Coursework_2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.Coursework_2.service.ExamTestConstants.*;
import static org.assertj.core.api.Assertions.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();
    @BeforeEach
    public void beforeEach() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
        questionService.add(QUESTION_4);
    }
    private final int MOCK_QUESTIONS_SIZE = 4;
    @Test
    public void shouldAddQuestion() {
        int beforeCount = questionService.getAll().size();
        assertThat(questionService.add(QUESTION_5))
                .isEqualTo(QUESTION_5)
                .isIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }
    @Test
    public void shouldRemoveQuestion() {
        int beforeCount = questionService.getAll().size();
        assertThat(questionService.remove(QUESTION_2))
                .isEqualTo(QUESTION_2)
                .isNotIn(questionService.getAll());
        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }
    @Test
    public void shouldGetAllQuestions() {
        assertThat(questionService.getAll())
                .hasSize(MOCK_QUESTIONS_SIZE)
                .containsExactlyInAnyOrder(QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4);
    }
    @Test
    public void shouldGetRandomQuestion() {
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }
}