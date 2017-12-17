package br.com.contaazul.Exception;

import org.springframework.http.HttpStatus;

public class RobotBadRequestException extends RuntimeException {

    public RobotBadRequestException() {
    super(HttpStatus.BAD_REQUEST.value()+" "+ HttpStatus.BAD_REQUEST.getReasonPhrase());
}

    public RobotBadRequestException(Throwable cause) {
        super(HttpStatus.BAD_REQUEST.value()+" "+ HttpStatus.BAD_REQUEST.getReasonPhrase(), cause);
    }
}
