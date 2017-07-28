package com.futmem.app.response;

import lombok.Data;

public class TeamResponse {
  @Data
  public static class Basic {
    private int teamId;
    private String teamName;
  }
}
