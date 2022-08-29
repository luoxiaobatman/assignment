package com.luoxiaobatman.assignment.interview.coding.huawei.autumn2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jack {
    public static class Card {
        /**
         * 1    2    3     4
         * 黑   红   樱    方
         */
        public int type;
        /**
         * 1 2 ...9, 10, 11, 12, 13, 14
         * ..............J , Q , K , A
         */
        public int value;

        public Card(int type, int value) {
            this.type = type;
            this.value = value;
        }
    }

    public static class Hand {
        private Card[] cards;

        public Hand(Card[] cards) {
            this.cards = cards;
        }

        /**
         * @return 1 同花顺, 2 四条, 3 葫芦, 4 同花, 5 顺子, 6 三条, 7 其他
         */
        public int hit() {
            if (isConnect()) {
                if (isSameType()) {
                    return 1;
                }
                return 5;
            }
            Integer[] integers = sameCardNum();
            Integer max = integers[0];
            if (max == 4) {
                return 2;
            } else if (max == 3) {
                if (integers[1] == 2) {
                    return 3;
                }
                return 6;
            }
            return 7;
        }

        /**
         * @return 是否是同花
         */
        private boolean isSameType() {
            boolean sameType = true;
            for (int i = 0; i < cards.length - 1; i++) {
                sameType = sameType && (cards[i].type == cards[i + 1].type);
            }
            return sameType;
        }

        /**
         * @return 是否是顺子
         */
        private boolean isConnect() {
            boolean connect = true;
            for (int i = 0; i < cards.length - 1; i++) {
                connect = connect && (cards[i].value + 1 == cards[i + 1].value);
            }

            boolean connectA = true;
            for (int i = 0; i < cards.length - 1; i++) {
                int index = (i + 4) % 5;
                connectA = connectA && ((cards[index % 5].value + 1) % 13 == cards[(index + 1) % 5].value % 13);
            }

            return connect || connectA;
        }

        private Integer[] sameCardNum() {
            Integer[] ints = new Integer[14];
            Arrays.fill(ints, 0);
            for (Card card : cards) {
                ints[card.value]++;
            }
            Arrays.sort(ints, (a, b) -> b - a);
            return ints;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> types = new HashMap<>();
        types.put("S", 1);
        types.put("H", 2);
        types.put("C", 3);
        types.put("D", 4);
        Map<String, Integer> values = new HashMap<>();
        values.put("2", 2);
        values.put("3", 3);
        values.put("4", 4);
        values.put("5", 5);
        values.put("6", 6);
        values.put("7", 7);
        values.put("8", 8);
        values.put("9", 9);
        values.put("10", 10);
        values.put("J", 11);
        values.put("Q", 12);
        values.put("K", 13);
        values.put("A", 14);

        Card[] cards = new Card[5];

//        for (int i = 0; i < 5; i++) {
//            Integer value = values.get(scanner.next());
//            Integer type = types.get(scanner.next());
//            Card card = new Card(type, value);
//            cards[i] = card;
//        }

        String[][] strings = {
                {"2", "S"},
                {"3", "S"},
                {"4", "H"},
                {"5", "C"},
                {"6", "S"}
        };
        for (int i = 0; i < strings.length; i++) {
            String[] ss = strings[i];
            Integer value = values.get(ss[0]);
            Integer type = types.get(ss[1]);
            Card card = new Card(type, value);
            cards[i] = card;
        }
        Arrays.sort(cards, (a, b) -> a.value - b.value);
        System.out.println(new Hand(cards).hit());
    }
}
