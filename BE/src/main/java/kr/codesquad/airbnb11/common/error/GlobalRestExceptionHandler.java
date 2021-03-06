package kr.codesquad.airbnb11.common.error;

import kr.codesquad.airbnb11.common.error.exception.BusinessException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

  private static final Logger log = org.slf4j.LoggerFactory
      .getLogger(GlobalRestExceptionHandler.class);

  /**
   * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
   * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
   * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    log.error("handleMethodArgumentNotValidException", e);
    final ApiError response = ApiError.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  /**
   * 지원하지 않은 HTTP method 호출 할 경우 발생
   */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  protected ResponseEntity<ApiError> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
    log.info("handleHttpRequestMethodNotSupportedException", e);
    final ApiError response = ApiError.of(ErrorCode.METHOD_NOT_ALLOWED);
    return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
  }

  /**
   * 비즈니스 로직상의 에러
   */
  @ExceptionHandler(BusinessException.class)
  protected ResponseEntity<ApiError> handleBusinessException(final BusinessException e) {
    log.error("handleEntityNotFoundException", e);
    final ErrorCode errorCode = e.getErrorCode();
    final ApiError response = ApiError.of(errorCode);
    return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
  }

  /**
   * 처리되지 않은 에러
   */
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handleException(Exception e) {
    log.error("handleException", e);
    final ApiError response = ApiError.of(ErrorCode.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
