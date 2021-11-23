package cinema.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SeatOccupiedException.class)
    public ResponseEntity<RestException> handleSeatOccupiedException(SeatOccupiedException ex, WebRequest request) {

    return new ResponseEntity<>(new RestException(ex.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(InvalidSeatException.class)
    public ResponseEntity<RestException> handleInvalidSeatException(InvalidSeatException ex, WebRequest request) {

        return new ResponseEntity<>(new RestException(ex.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(WrongTokenException.class)
    public ResponseEntity<RestException> handleWrongTokenException(WrongTokenException ex, WebRequest request) {
        return new ResponseEntity<>(new RestException(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<RestException> handleWrongPasswordException(WrongPasswordException ex, WebRequest request) {
        return new ResponseEntity<>(new RestException(ex.getMessage()), HttpStatus.valueOf(401));
    }
}

