package com.luoxiaobatman.assignment.blackbox;

public class LaungaugeDispatcher {
    static class Fruit {

    }
    static class Apple extends Fruit {}

    static class People {
        void eat(Fruit fruit) {
            System.out.println("people eat fruit");
        }

        void eat(Apple apple) {
            System.out.println("people eat apple");
        }
    }

    static class Boy extends People {
        @Override
        void eat(Fruit fruit) {
            System.out.println("boy eat fruit");
        }

        @Override
        void eat(Apple apple) {
            System.out.println("boy eat apple");
        }
    }
    public static void main(String[] args) {

        Fruit fruit = new Fruit();
        Fruit apple = new Apple();
        People people = new People();
        People boy = new Boy();
        boy.eat(fruit);
        boy.eat(apple);
    }
}
