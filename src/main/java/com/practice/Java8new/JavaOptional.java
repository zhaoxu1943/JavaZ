package com.practice.Java8new;

import java.util.Optional;

/**
 * @author zhaoxu
 * @className JavaOptional
 * @projectName JavaConcentration
 * @date 2020/8/11 13:31
 */
public class JavaOptional {

  public static void main(String[] args) {
      // 创建一个空的optional
      Optional<Object> empty = Optional.empty();
        // 此方式不可为null
      Optional<String> optional = Optional.of("Happyjava");
        // 此方式可以为null
      Optional<Object> optional1 = Optional.ofNullable(null);


  }
}
