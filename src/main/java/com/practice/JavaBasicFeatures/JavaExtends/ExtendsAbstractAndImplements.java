package com.practice.JavaBasicFeatures.JavaExtends;

import com.practice.JavaBasicFeatures.JavaAbstract.People;
import com.practice.JavaBasicFeatures.JavaInterface.Alibaba;

//继承了抽象类,以及
public class ExtendsAbstractAndImplements extends People implements Alibaba {

    public String name = "zhaoxu";
    public String type = "learner";

    public ExtendsAbstractAndImplements(String name , String type) {
        super(name,type);
    }

     /**
     * @Author zhaoxu
     * @Description //继承自抽象类,体现了属性
     * @Date 13:30 2019/11/20
     * @Param
     * @return
     **/
    @Override
    public void LifeStyles() {
         System.out.println(Animal.animalType+"全新的生活方式!");
    }

     /**
     * @Author zhaoxu
     * @Description //抽象类中的普通方法,可以重写,也可以不重写
     * @Date 13:31 2019/11/20
     * @Param
     * @return
     **/
    @Override
    public void DrinkMilk() {
        super.DrinkMilk();
        System.out.println("自己重写");
    }


     /**
     * @Author zhaoxu
     * @Description //alibaba接口中的方法 必须重写
     * @Date 13:31 2019/11/20
     * @Param
     * @return
     **/
    @Override
    public void improve() {
        System.out.println("每天提高,进入大厂");
    }

//    @Override
//    public void codeMore() {
//        System.out.println("进入大厂,code more!");
//    }

    @Override
    public void learn() {
        System.out.printf("学习!");
    }

    public static void main(String[] args) {
        ExtendsAbstractAndImplements extendsAbstractAndImplements = new ExtendsAbstractAndImplements("zhaoxu","learner");
        extendsAbstractAndImplements.LifeStyles();
        extendsAbstractAndImplements.DrinkMilk();
        extendsAbstractAndImplements.learn();
        extendsAbstractAndImplements.improve();
        //这里可以直接调用接口的default实现,同样也可以重写!
        extendsAbstractAndImplements.codeMore();

        Animal animal= new Animal();
        animal.introduce();
        animal.sleep();
    }
}
