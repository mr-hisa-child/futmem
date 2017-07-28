package com.futmem.app.error;

import java.util.Date;

import lombok.Getter;

public class ApiException extends RuntimeException {

  @Getter
  private final int status;

  @Getter
  private final long timestamp;

  public ApiException(int status, String message) {
    super(message);
    this.status = status;
    this.timestamp = new Date().getTime();
  }

  public ApiException(int status, String message, Throwable cause) {
    super(message, cause);
    this.status = status;
    this.timestamp = new Date().getTime();
  }
}
