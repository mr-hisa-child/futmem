package com.futmem.util;

import java.util.Date;

public class DateUtil {
  public static long getTimestamp() {
    return new Date().getTime();
  }
}
