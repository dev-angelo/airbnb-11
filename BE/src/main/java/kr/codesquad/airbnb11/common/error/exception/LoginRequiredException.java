package kr.codesquad.airbnb11.common.error.exception;

import kr.codesquad.airbnb11.common.error.ErrorCode;

public class LoginRequiredException extends BusinessException {

  public LoginRequiredException() {
    super(ErrorCode.LOGIN_REQUIRED);
  }

  public LoginRequiredException(String message) {
    super(message, ErrorCode.LOGIN_REQUIRED);
  }
}
