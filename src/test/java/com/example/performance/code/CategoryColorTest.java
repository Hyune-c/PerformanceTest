package com.example.performance.code;

import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

@DisplayName("enum 조회 테스트")
class CategoryColorTest {

  private static StopWatch stopWatch;
  private static String result = "";

  @BeforeAll
  public static void beforeAll() {
    stopWatch = new StopWatch("enum 조회 테스트");
  }

  @AfterEach
  public void afterEach() {
    TaskInfo taskInfo = stopWatch.getLastTaskInfo();
    result += String.format("Elapsed Time %s : %s s%n", taskInfo.getTaskName(), taskInfo.getTimeSeconds());
  }

  @AfterAll
  public static void afterAll() {
    System.out.println(stopWatch.prettyPrint());
    System.out.println(result);
  }

  @Test
  void byStream() {
    stopWatch.start("byStream");
    IntStream.range(0, 100000000).forEach(CategoryColor::getColorByStream);
    stopWatch.stop();
  }

  @Test
  void byArray() {
    stopWatch.start("byArray");
    IntStream.range(0, 100000000).forEach(CategoryColor::getColorByArray);
    stopWatch.stop();
  }

  @Test
  void byHashMap() {
    stopWatch.start("byHashMap");
    IntStream.range(0, 100000000).forEach(CategoryColor::getColorByHashMap);
    stopWatch.stop();
  }
}
