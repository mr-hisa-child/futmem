package com.futmem.app.response;

import lombok.Data;

public class UserResponse {
  @Data
  public static class Basic {
    private int userId;
    private String userName;
    private String mailaddress;
  }
}
