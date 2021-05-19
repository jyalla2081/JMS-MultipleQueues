package com.jyalla.reciever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserQueueListenerApplication {

    private static Logger logger = LoggerFactory.getLogger(UserQueueListenerApplication.class);

    public static void main(String[] args) {
        logger.info("UserQueueListenerApplication Started");
        SpringApplication.run(UserQueueListenerApplication.class, args);
    }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    // Map<String, String> errors = new HashMap<>();
    // ex.getBindingResult()
    // .getAllErrors()
    // .forEach((error) -> {
    // String fieldName = ((FieldError) error).getField();
    // String errorMessage = error.getDefaultMessage();
    // errors.put(fieldName, errorMessage);
    // });
    // return errors;
    // }

}
