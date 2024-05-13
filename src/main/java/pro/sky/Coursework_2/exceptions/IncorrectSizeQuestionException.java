package pro.sky.Coursework_2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectSizeQuestionException extends RuntimeException {
    public IncorrectSizeQuestionException(String message) {
        super(message);
    }
}
