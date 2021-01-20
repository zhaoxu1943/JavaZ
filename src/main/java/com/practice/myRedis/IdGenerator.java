package com.practice.myRedis;

import redis.clients.jedis.Jedis;

/**
 * @author zhaoxu
 * @className IdGenerator
 * @projectName JavaConcentration
 * @date 2021/1/20 9:06
 */
public class IdGenerator {

    private static final Jedis jedis;

    private static final String idKey = "id";

    static{
        //静态初始化
        jedis = JedisUtil.getInstance();
    }


  public static void main(String[] args) {
    //先进行一个id的保留,也就是id起始值设定
      IdGenerator generator = new IdGenerator();
      //若返回true,就是保留成功!可以进一步生产
      if (generator.reserve("100000")){
             System.out.println(generator.producer());
      }

  }



  /**
   * id预留
   * @author zhaoxu
   * @param
   * @return
   * @throws
   */
  private boolean reserve(String reserveId){
       return jedis.setnx(idKey,reserveId)==0?false:true;
  }


    /**
     * id生产
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    private Long producer(){
        return jedis.incr(idKey);
    }
}
