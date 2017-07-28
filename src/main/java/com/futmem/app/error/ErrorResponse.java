package com.futmem.app.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

public class ErrorResponse {
  @Getter
  private int status;
  @Getter
  private long timestamp;
  @Getter
  private String Message;

  public ErrorResponse(int status, long timestamp, String message) {
    this.status = status;
    this.timestamp = timestamp;
    this.Message = message;
  }

  public ResponseEntity<ErrorResponse> createResponse(HttpStatus status) {
    return new ResponseEntity<ErrorResponse>(this, status);
  }

  public static ResponseEntity<ErrorResponse> createResponse(ApiException e) {
    return new ResponseEntity<ErrorResponse>(
        new ErrorResponse(e.getStatus(), e.getTimestamp(), e.getMessage()), HttpStatus.BAD_REQUEST);
  }
}
