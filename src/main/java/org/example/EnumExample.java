package org.example;

import lombok.Getter;


enum Seasons {
    SUMMER(1),
    WINTER(2),
    AUTUMN(3),
    SPRING(4);
    @Getter
    private int code;

    Seasons(int val) {
        this.code = val;
    }

}

public class EnumExample {
    public static void main(String[] args) {
        Seasons season = Seasons.AUTUMN;
        System.out.println(season.ordinal());
        System.out.println("value of constant 'SUMMER' in Seasons: "+Seasons.valueOf("SUMMER"));
        for (Seasons x : Seasons.values()) {
            System.out.println(x + " " + x.getCode());
        }
    }
}

