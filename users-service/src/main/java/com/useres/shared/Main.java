package com.useres.shared;

public class Main {
    public static void main(String[] args) {
//        A a1 = new A();
//        a1.printx(); // 10
//
//
//        A a2 = new B();
//        a2.printx(); // 20
//
//
////        B b1 = (B) new A();
////        b1.printx(); // 20
//
//
//        B b2 = new B();
//        b2.printx(); // 20

        String s1 = new String("zzz");
        String s2 = "zzz";
        String s3 = String.valueOf("zzz");

        System.out.println(s1  == s2); // false
        System.out.println(s1  == s3); // false
        System.out.println(s3  == s2); // true

    }
}

class A {
    private int x = 10;

    public void printx() {
        System.out.println(x);
    }
}

class B extends A {

    private int x = 20;

//    public void printx() {
//        System.out.println(x);
//    }
}




