package kr.codesquad.airbnb11.common.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.BindingResult;

public class ApiError {
  private final int status;
  private final String message;
  private final String code;
  private final List<FieldError> errors;

  private ApiError(final ErrorCode code) {
    this.status = code.getStatus();
    this.message = code.getMessage();
    this.code = code.getCode();
    this.errors = new ArrayList<>();
  }

  private ApiError(final ErrorCode code, final List<FieldError> errors) {
    this.status = code.getStatus();
    this.message = code.getMessage();
    this.code = code.getCode();
    this.errors = errors;
  }

  public static ApiError of(final ErrorCode code) {
    return new ApiError(code);
  }

  public static ApiError of(final ErrorCode code, final BindingResult bindingResult) {
    return new ApiError(code, FieldError.of(bindingResult));
  }

  public static ApiError of(final ErrorCode code, final List<FieldError> errors) {
    return new ApiError(code, errors);
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

  public String getCode() {
    return code;
  }

  public List<FieldError> getErrors() {
    return errors;
  }

  public static class FieldError {

    private String field;
    private String value;
    private String reason;

    private FieldError(final String field, final Object value, final String reason) {
      this.field = field;
      this.value = value == null ? "" : value.toString();
      this.reason = reason;
    }

    public static List<FieldError> of(final String field, final String value, final String reason) {
      List<FieldError> fieldErrors = new ArrayList<>();
      fieldErrors.add(new FieldError(field, value, reason));
      return fieldErrors;
    }

    private static List<FieldError> of(final BindingResult bindingResult) {
      final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
      return fieldErrors.stream()
          .map(error -> new FieldError(
              error.getField(),
              error.getRejectedValue(),
              error.getDefaultMessage()))
          .collect(Collectors.toList());
    }

    public String getField() {
      return field;
    }

    public String getValue() {
      return value;
    }

    public String getReason() {
      return reason;
    }
  }
}
