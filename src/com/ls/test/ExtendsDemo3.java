package com.ls.test;

/**
 * Created by LS on 2017/9/25 20:15.
 * To Be or Not to Be
 */
class Teacher {
    String name;

    int age;

    //private 只能在本类中使用
    private char gender;


    public void sleep() {
        System.out.println("老师正在睡觉");
    }


    public void setGender(char gender) {
        this.gender = gender;
    }


    public char getGender() {
        return gender;
    }

}


/*
 * 子类的创建
 * class子类 extends 父类 ｛子类的属性｝
 */


class JavaTeacher extends Teacher {

    boolean isGlass;

    public void teachJava() {
        System.out.println(this.name+"老师在教Java" + "年龄是"+ this.age+"\t性别:\t"+getGender());

    }




}



class PHPTeacher extends Teacher {
    public void teacherPHP() {
        System.out.println(name+"老师正在教PHP"+"年龄是"+ age+"\t性别:\t"+getGender());
    }
    public void playBall() {
        System.out.println(name+"老师在打球");
    }
}



public class ExtendsDemo3 {
    public static void main(String[] args) {
        JavaTeacher jt = new JavaTeacher();
        jt.name = "张三";
        jt.age = 10;
        jt.setGender('男');
        jt.teachJava();

        PHPTeacher pt = new PHPTeacher();
        pt.name = "李四";
        pt.age = 20;
        pt.setGender('女');
        pt.teacherPHP();
        pt.playBall();
    }
}

