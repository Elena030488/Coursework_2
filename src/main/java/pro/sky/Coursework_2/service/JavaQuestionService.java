package pro.sky.Coursework_2.service;

import org.springframework.stereotype.Service;
import pro.sky.Coursework_2.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomQuestion = new Random().nextInt(questions.size());
        List<Question> questionList = new ArrayList<>(questions);
        return questionList.get(randomQuestion);
    }
}