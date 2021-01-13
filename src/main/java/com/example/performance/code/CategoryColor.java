package com.example.performance.code;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryColor {

  YELLOW(0, "#FEDE00"),
  BLUE(1, "#85C4E7"),
  ORANGE(2, "#F3AC13"),
  RED(3, "#EC4557"),
  GREEN(4, "#8EEB12"),
  PINK(5, "#FFA78E");

  private final int order;
  private final String code;

  public static final Map<Integer, CategoryColor> categoryColorMap = new HashMap<>();

  static {
    for (CategoryColor color : CategoryColor.values()) {
      categoryColorMap.put(color.getOrder(), color);
    }
  }

  /**
   * 입력된 order 보다 큰 경우 나머지 값을 이용해 색깔을 찾습니다.
   *
   * @param order
   * @return
   */
  public static String getColorByHashMap(int order) {
    return categoryColorMap.get(order).code;
  }

  public static String getColorByArray(int order) {
    return CategoryColor.values()[order].code;
  }

  public static String getColorByStream(int order) {
    return Arrays.stream(CategoryColor.values())
        .filter(categoryColor -> categoryColor.order == order)
        .findAny()
        .map(CategoryColor::getCode)
        .orElse(CategoryColor.YELLOW.code);
  }
}
