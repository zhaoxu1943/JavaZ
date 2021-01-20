package com.practice.myRedis;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * redis计数器
 * 如网站访客数量
 * 用户执行某个操作的计数
 * 播放量
 * @author zhaoxu
 * @className RedisCounter
 * @projectName JavaConcentration
 * @date 2021/1/20 9:19
 */
public class RedisCounter {

    private static final Jedis jedis;

    private static final String countKey = "counter";

    static{
        //静态初始化
        jedis = JedisUtil.getInstance();
    }

  public static void main(String[] args) {
      Long increment = 2L;
        RedisCounter redisCounter = new RedisCounter();

      System.out.println("-----计数器的删除");
      System.out.println(redisCounter.del());
      System.out.println("-----计数器获取,获取不到返回0");
      System.out.println(redisCounter.get());


      System.out.println("-----计数器初始化,并返回之前的值");
      System.out.println(redisCounter.init());
      System.out.println("-----计数器递增");
      System.out.println( redisCounter.increase(increment));
      System.out.println( redisCounter.increase(increment));
      System.out.println( redisCounter.increase(increment));
      System.out.println( redisCounter.increase(increment));
      System.out.println( redisCounter.increase(increment));
      System.out.println( redisCounter.increase(increment));
      System.out.println("-----计数器初始化,并返回之前的值");
      System.out.println(redisCounter.init());
      System.out.println("-----计数器递减");
      System.out.println(redisCounter.decrease(increment));
      System.out.println(redisCounter.decrease(increment));
      System.out.println(redisCounter.decrease(increment));
      System.out.println(redisCounter.decrease(increment));
      System.out.println(redisCounter.decrease(increment));
      System.out.println("-----计数器获取");
      System.out.println( redisCounter.get());

  }






  /**
   * 增加
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
    private Long increase(Long increment){
        return jedis.incrBy(countKey,increment);
    }


    /**
     * 减少
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Long decrease(Long increment){
        return jedis.decrBy(countKey,increment);
    }


    /**
     * 初始化为0,并返回之前的值
     * 进行了非原子操作,一个功能,一条命令!
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Long init(){
        String oldValue = jedis.getSet(countKey,"0");
        if(StringUtils.isNotBlank(oldValue)){
            return Long.parseLong(oldValue);
        }else{
            return 0L;
        }
    }



    /**
     * 得到当前值
     * 不存在get为null
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Long get(){
        String count = jedis.get(countKey);
        if (StringUtils.isNotBlank(count)){
            return Long.parseLong(count);
        }else{
            return 0L;
        }
    }

    /**
     * 得到当前值
     * 不存在get为null
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Boolean del(){
        return jedis.del(countKey)>0?true:false;
    }
}
