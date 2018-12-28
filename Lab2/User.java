package com.company;

public class User {
    private int A;
    private int P;
    private int X;
    private int Y;
    private int Z;

    User(int a,int p){
        this.A = a;
        this.P = p;
        this.X = (int) (Math.random() * 100) + 1;
    }

    public void setY(){
        int tmp = 1;
        for (int degree= 1; degree <= X; degree++){
            tmp = (tmp * A) % P;
        }

        Y = tmp;
    }

    public int getY(){
        return Y;
    }

    public void setZ(int Y) {
        int tmp = 1;
        for (int degree= 1; degree <= X; degree++){
            tmp = (tmp * Y) % P;
        }

        Z = tmp;
        System.out.println("X=" + X);
        System.out.println("A=" + A);
        System.out.println("P=" + P);
        System.out.println("Y=" + Y);
        System.out.println("Z=" + Z);
        System.out.println();
    }

    public int getZ(){
        return Z;
    }
}
