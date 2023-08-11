package org.example;

import org.example.thrift.Seasons;

public class EnumExp {
    public static void main(String[] args) {
        Seasons seasons= Seasons.RAINY;
        if(seasons.equals(Seasons.RAINY)){
            System.out.printf("Rainy season");
        }
        else {
            System.out.printf("Not a rainy season");
        }
    }
}
