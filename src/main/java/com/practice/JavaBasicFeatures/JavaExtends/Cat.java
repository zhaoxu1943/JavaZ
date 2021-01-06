package com.practice.JavaBasicFeatures.JavaExtends;

public class Cat extends Animal {

    //子类继承父类,继承父类的public/protected成员变量和方法,不继承构造函数
    //需要隐式或显式的使用super(),调用构造方法,来初始化子类


    //子类的成员变量
    public String animalType;
    public int animalAge;


    //首先关于继承,父类是有参构造,父类默认的无参构造将会失效,
    //而调用父类的有参构造,需要显式的写出super(参数),所以这里不写super()会报错
    //如果想不让它报错,那么可以在父类中补一个无参构造,那么隐式的super()将会生效
    //对于父类是无参构造,则会自动添加super()
    //父类Animal中定义了构造函数之后,原默认的无参构造函数就会消失
    //所以想用的话,可以把无参的构造函数补充回来(构造方法的重载)
    //补充之后,这里不加super,就是默认调用无参
    //加super,就是显式调用有参
    public Cat (String animalType, int animalAge) {
        super(animalType, animalAge);
        this.animalType = animalType;
        this.animalAge = animalAge;
    }

    public Cat() {

    }

    @Override
    public void eat() {



        System.out.println(animalType+"子类重写的eat");
    }

    @Override
    public void sleep() {
        System.out.println(animalType+"子类重写的sleep");
    }

    @Override
    public void introduce() {
        System.out.println(animalType+animalAge+"喵喵喵!");
    }



    public void callAtSameTime(){
        //调用子类方法用this
        this.eat();
        //调用父类方法用super
        super.eat();
    }

    public static void main(String[] args) {
        Animal cat = new Cat("cat",8);
        cat.eat();
        cat.sleep();
        cat.introduce();
        //子类独有方法,使用父类多态调用,编译器报错
        Animal catWhite = new Cat("catwhite",7);
       //catWhite.callAtSameTime();
        //子类中不能重写父类的静态方法,重写是动态的,static方法是静态的,跟任何实例都不相关
        Animal.staticTest();


        //instanceof方法输出对象属不属于后面的类

        boolean b  = cat instanceof Animal;
        boolean b1 = cat instanceof Cat;

        System.out.println(b);
        System.out.println(b1);

        //java多态的动态绑定
        Cat cat1 =new Cat();
        Animal animal=new Animal();
        //当我传入的是子类对象,执行子类重写的方法,传入父类对象,执行父类的方法
        //把子类看做父类,传入要求父类对象的方法,叫做向上转型,upcasting
        animal.hr(cat1);
        animal.hr(animal);

    }

}
