package com.practice.myRedis;
import com.alibaba.fastjson.JSON;
import com.concentration.entity.UserInfo;
import org.apache.commons.codec.binary.Base64;
import redis.clients.jedis.Jedis;

import javax.el.MethodNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Redis Key的命名规范
 * project.id.para
 * 如 article.21330.name
 *
 * @author zhaoxu
 * @version 1.0
 * @className UseJedis
 * @description 使用jedis原生操作redis
 * @date 2019/12/20 9:59
 **/
public class UseJedis {

    private static final Jedis jedis;

    static{
        //静态初始化
        jedis = new Jedis("localhost",6379);
    }

    /**
     * 测试方法
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        //test String
        testRedisString();
        //test save image
        System.out.println(testRedisStringSaveImages());
        //test list
        testRedisList();
        //test lock
        String lockClientKey = "business";
        // 加锁 true
         System.out.println(testRedisLockAcquire(lockClientKey));
        //再加锁 false
         System.out.println(testRedisLockAcquire(lockClientKey));
        //释放锁 true
        System.out.println(testRedisLockRelease(lockClientKey));
        //再加锁 true
        System.out.println(testRedisLockAcquire(lockClientKey));
        //释放锁 true
        System.out.println(testRedisLockRelease(lockClientKey));
        //释放锁 false
        System.out.println(testRedisLockRelease(lockClientKey));
        //test multi
        testRedisStringMSET();
        testRedisStringMGET();

    }

    /**
     * redis 字符串
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void testRedisString(){
            //见
            jedis.set("name","hello world");
            String age = jedis.get("age");
            System.out.println(age);
            String name = jedis.get("name");
            System.out.println(name);
            System.out.println(jedis.strlen("name"));
    }




    /**
     * redis 字符串,一次命令set多个--MSET
     * 使用MSET替代SET 减少网络通信次数
     * 可应用于批量的存储信息,如一次命令存储一篇文章信息
     * 其中的作者,文章标题,内容等信息一次存好
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void testRedisStringMSET(){
        //MSET进行文章的更新
        jedis.mset("name","hello world","mid","77");
        //if not exist 逐个判断,不存在则存,存在就不存
        jedis.msetnx("name","hello world","mid","77");

    }


    /**
     * redis 字符串,一次命令set多个--MSET
     * 使用MSET替代SET 减少网络通信次数
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void testRedisStringMGET(){
        //见
        List<String> stringList = jedis.mget("name","123","mid","77");
    }


    /**
     * redis 字符串以二进制保存图片
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static String testRedisStringSaveImages(){
        InputStream in = null;
        byte[] data = null;

        String imagePath = "C:/Users/zhaoxu/OneDrive/图片/老照片/5.15尧十三/132.jpg";
        File file = new File(imagePath);
        try
        {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        jedis.set("image",new String(Objects.requireNonNull(Base64.encodeBase64(data))));
        return new String(Objects.requireNonNull(Base64.encodeBase64(data)));
    }





    /**
     * redis 分布式锁获取
     * 使用NX 也就是说不存在时创建(占有),
     * 存在时返回FALSE
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static String testRedisLockAcquire(String key){
        String lockStr = "locking";
        // 1 if the key was set 0 if the key was not set
        return jedis.setnx(key,lockStr)==1?"TRUE":"FALSE";
    }




    /**
     * redis 分布式锁释放
     * 原理:redis 的del进行删除(释放)
     * 但有缺点
     * 1.锁的释放操作无法验证进程的身份,谁都能进行释放,如果说非持有线程释放了锁,会导致程序中出现多个锁,破坏锁的唯一性
     * 2.无法设置最大加锁时间 若故障超时,锁会一直处于已获取状态 导致其他进程永远无法获取锁
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static String testRedisLockRelease(String key){
        //Integer reply, specifically: an integer greater than 0 if one or more keys were removed
        //   *         0 if none of the specified key existed
        return jedis.del(key)==0?"FALSE":"TRUE";
    }


    /**
     * redis list使用
     * @author zhaoxu
     * @param
     * @return
     * @throws
     */
    public static void testRedisList() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<UserInfo> userInfoList = new ArrayList<>();
        //序列化一个对象为JSON字符串
        //先初始化一个对象
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserId("0001");
        userInfo1.setUserName("test1");
        userInfo1.setAge(3);
        userInfo1.setPhoneNumber("18888888888");
        userInfo1.setSex("male");
        userInfoList.add(userInfo1);
        //先初始化一个对象
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserId("0002");
        userInfo2.setUserName("test2");
        userInfo2.setAge(2);
        userInfo2.setPhoneNumber("16666666666");
        userInfo2.setSex("female");
        userInfoList.add(userInfo2);

        //----------------------------
        //使用String结构缓存用户信息,这时比如有n个用户

        //引入fastjson并使用

        //创建一个keys的list方便取
        List<String> keysList = new ArrayList<>();
        for (UserInfo userInfo:userInfoList) {
            String jsonString = JSON.toJSONString(userInfo);
            //存入
            String key = "userinfo:";
            key = key + userInfo.getUserId();
            keysList.add(key);
            jedis.set(key,jsonString);
        }

        for (String key:keysList) {
            //取出并反序列化为对象
            String objStr = JSON.parseObject(jedis.get(key),UserInfo.class).toString();
            System.out.println(objStr);
        }

        //----------------------------
        //使用hash结构缓存用户信息,这时比如有n个用户,那么就要创建n个hash
        for (UserInfo userInfo:userInfoList) {
            String key = "muserinfo:";
            key = key + userInfo.getUserId();
            Class clazz= UserInfo.class;
            Field[] fields = clazz.getDeclaredFields();
            Map<String, String> value = new HashMap();
            for (Field field:fields) {
                // 取属性名
                String fieldName = field.getName();
                // 获取get方法名
                String getter = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                // 得到get方法对象
                Method method = clazz.getMethod(getter);
                // 通过属性的get方法取到当前goods对象的属性值
                String fieldValue = method.invoke(userInfo)+"";
                value.put(fieldName, fieldValue);
            }
            jedis.hmset(key,value);
        }
    }
}
