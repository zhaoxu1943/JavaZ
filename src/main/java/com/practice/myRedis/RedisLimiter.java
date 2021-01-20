package com.practice.myRedis;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * Redis限速器 如防爬虫,对IP进行访问次数限制 防暴力破解,密码输入次数限制 如此类限制性的机制,可以使用redis限速器进行
 *
 * @author zhaoxu
 * @className RedisLimiter
 * @projectName JavaConcentration
 * @date 2021/1/20 9:57
 */
public class RedisLimiter {

  private static final Jedis jedis;

  private static final String limitKey = "limiter";

  static {
    // 静态初始化
    jedis = JedisUtil.getInstance();
  }

  public static void main(String[] args) throws InterruptedException {
    RedisLimiter redisLimiter = new RedisLimiter();
    System.out.println("----限速器初始化");
    // 60秒访问5测
    redisLimiter.init(60, "5");

    Thread.sleep(1000);
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                System.out.println(Thread.currentThread().getName() + "进行访问");
                redisLimiter.decrease();
              }
            })
        .start();

    for (int i = 0; i < 10; i++) {
      Thread.sleep(1000);
      new Thread(
              () -> {
                if (redisLimiter.get() > 0) {
                  System.out.println(Thread.currentThread().getName() + "进行访问");
                  redisLimiter.decrease();
                } else {
                  System.out.println("该操作已被限制!");
                }
              })
          .start();
    }
  }

  /**
   * 限速器的初始化 时间,次数
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private void init(int sec, String times) {
    jedis.setex(limitKey, sec, times);
  }

  /**
   * 限速器减少
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private void decrease() {
    jedis.decr(limitKey);
  }

  /**
   * 得到当前限速器,若为空则返回0,也不能访问
   *
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private Long get() {
    String limiter = jedis.get(limitKey);
    if (StringUtils.isNotBlank(limiter)) {
      return Long.parseLong(limiter);
    } else {
      return 0L;
    }
  }
}
