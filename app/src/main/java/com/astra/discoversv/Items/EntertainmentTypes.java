package com.astra.discoversv.Items;

public class EntertainmentTypes {
 public static final int HIKING = 1;
 public static final int BEACH = 2;
 public static final int EXPLORATION = 3;
 public static final int HISTORICAL = 4;
 public static final int FUN = 5;
 public static final int FALLS = 6;
 public static final int RELAXATION = 7;

 public static int[] returnEnterTypes() {

  int[] types = new int[]{
          HIKING,
          BEACH,
          EXPLORATION,
          HISTORICAL,
          FUN,
          FALLS,
          RELAXATION
  };
  return types;
 }
}
