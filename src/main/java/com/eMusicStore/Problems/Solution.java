package com.eMusicStore.Problems;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void problem(double payment) {
        // Write your code here.
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        Locale indian = new Locale("en", "IN");
        NumberFormat india = NumberFormat.getCurrencyInstance(indian);
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);


        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        problem(-150);
        int candidates = scan.nextInt();
        int everyCandy = scan.nextInt();

        int eat = 0;
        if (everyCandy == 1) {
            throw new RuntimeException("Illegal number");
        }
        while (candidates > 0) {

            if (candidates >= everyCandy) {
                eat += everyCandy;
                candidates -= everyCandy;
                candidates += 1;
            } else {
                eat += 1;
                candidates -= 1;
            }
        }
        System.out.println("eat = " + eat);
    }


}