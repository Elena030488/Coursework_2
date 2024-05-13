package pro.sky.Coursework_2.service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework_2.exceptions.IncorrectSizeQuestionException;
import pro.sky.Coursework_2.model.Question;
import pro.sky.Coursework_2.service.ExaminerService;
import pro.sky.Coursework_2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new IncorrectSizeQuestionException("В сервисе хранится меньшее количество вопросов, чем запрошено");
        }
        Collection<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}