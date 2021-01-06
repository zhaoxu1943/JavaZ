package com.practice.JavaBasicFeatures.JavaReflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @ClassName reflectTest
 * @Author zhaoxu
 * @Date 2019/9/6 23:39
 * @Version 1.0
 **/
public class JavaReflect {






    public static void main(String[] args) throws Exception {
        //2 ways get class object
//
//        //get class object;
//        Class fatherClass = FatherClass.class;
//        //dir
//       // Class<?> fatherClass1= Class.forName("com.practice.JavaBasicFeatures.JavaInnerClass");
//
//        //getConstructor and get class Object to use method
//        FatherClass fatherClassObj = (FatherClass) fatherClass.getConstructor().newInstance();
//
//        //get All Method and getName
//        Method[] methods =fatherClass.getDeclaredMethods();
//        for (Method method:methods) {
//            System.out.println(method.getName());
//        }
//        //method invoke
//        Method method = fatherClass.getMethod("printFatherMsg");
//
//        method.invoke(fatherClassObj);
//
//        //getMethod and call
//
//        Field[] fields=  fatherClass.getDeclaredFields();
//        for (Field field:fields) {
//            System.out.println(field);
//        }







        //获取类的所用变量
       // printFields();
        //获取类的所有方法
       // printMethods();
        //调用私有方法,和对象测试
        //diaoyongsiyou();
        //用反射调用私有方法
        //getPrivateMethod();
    }


    //get Class Object
    public static void getClazz() throws ClassNotFoundException {
        //get class object directly;
        Class superClass = ReflectSuperClass.class;
        //get by dir
        Class superClass1 =Class.forName("com.practice.JavaBasicFeatures.JavaReflect.ReflectSuperClass");
        //third Object.getClass
        Object object = new Object();
        object.getClass();
    }


    //get Fields
    public static void getClazzFields() throws ClassNotFoundException {
        //get class object directly;
        Class subClass = ReflectSubClass.class;
        System.out.println("className: " + subClass.getName());

        //get all public fields,return fields array
        Field[] fieldsPublic = subClass.getFields();

        //get all declared fields in subClass
        Field[] fieldsDeclared = subClass.getDeclaredFields();

        //print all public fields
        for (Field field:fieldsPublic) {
            int modifies = field.getModifiers();
            System.out.println(Modifier.toString(modifies)+" "+field.getType().getName()+" "+field.getName());
        }

        //print declared fields
        for (Field field:fieldsDeclared) {
            int modifies = field.getModifiers();
            System.out.println(Modifier.toString(modifies)+" "+field.getType().getName()+" "+field.getName());
        }





    }



    /**
     * 通过反射获取类的所有变量
     */
//    private static void printFields() throws NoSuchFieldException {
//        //1.获取并输出类的名称
//        Class mClass = ReflectSubClass.class;
//        System.out.println("类的名称：" + mClass.getName());
//
//        //2.1 获取所有 public 访问权限的变量
//        // 包括本类声明的和从父类继承的
//        Field[] fields = mClass.getFields();
//
//        //2.2 获取所有本类声明的变量（不问访问权限）
//        //Field[] fields = mClass.getDeclaredFields();
//
//        //3. 遍历变量并输出变量信息
//        for (Field field :
//                fields) {
//            //获取访问权限并输出,这一步先获取权限为int值
//            int modifiers = field.getModifiers();
//            //再翻译回去 对于本例子就是public
//            System.out.print(Modifier.toString(modifiers) + " ");
//            //输出变量的类型及变量名
//            System.out.println(field.getType().getName()
//                    + " " + field.getName());
//        }
//
//        Field field = mClass.getField("mSonBirthday");
//        field.set();
//    }

    /**
     * 通过反射获取类的所有方法
     */
    private static void printMethods(){
        //1.获取并输出类的名称
        Class mClass = ReflectSubClass.class;
        System.out.println("类的名称：" + mClass.getName());

        //2.1 获取所有 public 访问权限的方法
        //包括自己声明和从父类继承的
        Method[] mMethods = mClass.getMethods();

        //2.2 获取所有本类的的方法（不问访问权限）
        //Method[] mMethods = mClass.getDeclaredMethods();

        //3.遍历所有方法
        for (Method method :
                mMethods) {
            //获取并输出方法的访问权限（Modifiers：修饰符）
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " "
                    + method.getName() + "( ");
            //获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter:
                    parameters) {
                System.out.print(parameter.getType().getName()
                        + " " + parameter.getName() + ",");
            }
            //获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0){
                System.out.println(" )");
            }
            else {
                for (Class c : exceptionTypes) {
                    System.out.println(" ) throws "
                            + c.getName());
                }
            }
        }
    }

//
//    public static void diaoyongsiyou() {
//        JavaWrapper JavaWrapper = new JavaWrapper();
//       // siyoulei.dsa = "nihao";
//        String s = JavaWrapper.getMsg();
//        System.out.println(s);
//    }
//
//
//    /**
//     * 访问对象的私有方法
//     * 为简洁代码，在方法上抛出总的异常，实际开发别这样
//     */
//    private static void getPrivateMethod() throws Exception{
//        //1. 获取 Class 类实例
//        JavaWrapper testClass = new JavaWrapper();
//        Class mClass = testClass.getClass();
//
//        //2. 获取私有方法
//        //第一个参数为要获取的私有方法的名称
//        //第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
//        //方法参数也可这么写 ：new Class[]{String.class , int.class}
//        Method privateMethod =
//                mClass.getDeclaredMethod("privateMethod", String.class, int.class);
//
//        //3. 开始操作方法
//        if (privateMethod != null) {
//            //获取私有方法的访问权
//            //只是获取访问权，并不是修改实际权限
//            privateMethod.setAccessible(true);
//
//            //使用 invoke 反射调用私有方法
//            //privateMethod 是获取到的私有方法
//            //testClass 要操作的对象
//            //后面两个参数传实参
//            privateMethod.invoke(testClass, "Java Reflect ", 666);
//        }
//    }


//    /**
//     * 修改对象私有变量的值
//     * 为简洁代码，在方法上抛出总的异常
//     */
//    private static void modifyPrivateFiled() throws Exception {
//        //1. 获取 Class 类实例
//        JavaWrapper testClass = new JavaWrapper();
//        Class mClass = testClass.getClass();
//
//        //2. 获取私有变量
//        Field privateField = mClass.getDeclaredField("MSG");
//
//        //3. 操作私有变量
//        if (privateField != null) {
//            //获取私有变量的访问权
//            privateField.setAccessible(true);
//
//            //修改私有变量，并输出以测试
//            System.out.println("Before Modify：MSG = " + testClass.getMsg());
//
//            //调用 set(object , value) 修改变量的值
//            //privateField 是获取到的私有变量
//            //testClass 要操作的对象
//            //"Modified" 为要修改成的值
//            privateField.set(testClass, "Modified");
//            System.out.println("After Modify：MSG = " + testClass.getMsg());
//        }
//    }



}
