//package com.ls.test;
//
///**
// * Created by LS on 2017/9/25 20:15.
// * To Be or Not to Be
// */
//class Teacher1 {
//    String name;
//
//    int age;
//
//    //private ֻ���ڱ�����ʹ��
//    private char gender;
//
//
//    public void sleep() {
//        System.out.println("��ʦ����˯��");
//    }
//
//
//    public void setGender(char gender) {
//        this.gender = gender;
//    }
//
//
//    public char getGender() {
//        return gender;
//    }
//
//}
//
//
///*
// * ����Ĵ���
// * class���� extends ���� ����������ԣ�
// */
//
//
//class JAVATeacher extends Teacher1 {
//
//    boolean isGlass;
//
//    public void teachJava() {
//        System.out.println(this.name+"��ʦ�ڽ�Java" + "������"+ this.age+"\t�Ա�:\t"+getGender());
//
//    }
//
//
//
//
//}
//
//
//
//class PhpTeacher extends Teacher1 {
//    public void teacherPHP() {
//        System.out.println(name+"��ʦ���ڽ�PHP"+"������"+ age+"\t�Ա�:\t"+getGender());
//    }
//    public void playBall() {
//        System.out.println(name+"��ʦ�ڴ���");
//    }
//}
//
//
//
//public class ExtendsDemo4 {
//    public static void main(String[] args) {
//        JAVATeacher jt = new JAVATeacher();
//        jt.name = "����";
//        jt.age = 10;
//        jt.setGender('��');
//        jt.teachJava();
//
//        PhpTeacher pt = new PhpTeacher();
//        pt.name = "����";
//        pt.age = 20;
//        pt.setGender('Ů');
//        pt.teacherPHP();
//        pt.playBall();
//    }
//
//
//
//
//}
