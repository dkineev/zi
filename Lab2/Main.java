package com.company;

import java.io.PrintWriter;

public class Main {
    private static int A;
    private static int P;

    public static void main(String[] args) throws Exception{
        PrintWriter writer = new PrintWriter("dialog.txt", "UTF-8");


        int[] SimpleNum = {3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

        P = (SimpleNum[(int)(Math.random() * SimpleNum.length)]);
        A = (int) (Math.random() * (P - 1) + 1);


        User Alica = new User(A, P);
        writer.println("Алиса: Получаю значения A и P.");
        writer.println();
        writer.println("Алиса: A = " + A + " P = " + P);
        writer.println();

        User Bob = new User(A, P);
        writer.println("Боб: Получаю значения A и P.");
        writer.println();
        writer.println("Боб: A = " + A + " P = " + P);
        writer.println();

        Alica.setY();
        int Y1 = Alica.getY();
        writer.println("Алиса: Вычисляю Y.");
        writer.println();
        writer.println("Алиса: Y = " + Y1);
        writer.println();

        Bob.setY();
        int Y2 = Bob.getY();
        writer.println("Боб: Вычисляю Y.");
        writer.println();
        writer.println("Боб: Y = " + Y2);
        writer.println();

        Alica.setZ(Y2);
        int Z1 = Alica.getZ();
        writer.println("Алиса: Вычисляю Z.");
        writer.println();
        writer.println("Алиса: Z = " + Z1);
        writer.println();

        Bob.setZ(Y1);
        int Z2 = Bob.getZ();
        writer.println("Боб: Вычисляю Z.");
        writer.println();
        writer.println("Боб: Z = " + Z2);
        writer.println();

        if (Z1 == Z2) {
            writer.println("Общий ключ найден.");
        } else {
            writer.println("Общий ключ не найден.");
        }
        System.out.println("Z1 = " + Z1);
        System.out.println("Z2 = " + Z2);

        writer.close();
    }
}
