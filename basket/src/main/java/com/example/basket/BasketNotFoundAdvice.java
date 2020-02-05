package basket;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class BasketNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(BasketNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String basketNotFoundHandler(BasketNotFoundException ex) {
    return ex.getMessage();
  }
}