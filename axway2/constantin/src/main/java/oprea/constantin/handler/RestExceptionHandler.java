package oprea.constantin.handler;

import oprea.constantin.exception.BadContentException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadContentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerForBadContent(BadContentException e){
        return e.getMessage();

    }
}
