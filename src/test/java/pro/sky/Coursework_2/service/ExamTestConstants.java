package pro.sky.Coursework_2.service;

import pro.sky.Coursework_2.model.Question;

import java.util.Collection;
import java.util.Set;

public class ExamTestConstants {
    public static final Question QUESTION_1 = new Question("question1", "answer1");
    public static final Question QUESTION_2 = new Question("question2", "answer2");
    public static final Question QUESTION_3 = new Question("question3", "answer3");
    public static final Question QUESTION_4 = new Question("question4", "answer4");
    public static final Question QUESTION_5 = new Question("question5", "answer5");
    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4,
            QUESTION_5
    );
}