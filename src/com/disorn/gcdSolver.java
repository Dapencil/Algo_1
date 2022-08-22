package com.disorn;

import java.util.ArrayList;

public class gcdSolver {

    int smallNumber;
    int largeNumber;
    Sieve sieve = new Sieve();

    public gcdSolver() {

    }

    public void setValue(int m,int n) {
        assertValue(smallNumber,largeNumber);
        //(a,b) = ( -a,b) = (-a,-b) = (|a|,|b|)
        int abM = Math.abs(m);
        int abN = Math.abs(n);
        boolean flag = abM <= abN;
        this.smallNumber = flag? abM:abN;
        this.largeNumber = flag? abN:abM;
    }

    public long FindGCD1(){
        long startTime = System.nanoTime();
        int gcd = Naive.gcdMiddleSchoolProcedure(smallNumber,largeNumber);
        long endTime = System.nanoTime();
        return endTime - startTime;
//        System.out.println("FindGCD1 (ns) : "+(endTime - startTime));
//        return gcd;
    }

    public long FindGCD2(){
        long startTime = System.nanoTime();
        int gcd = Sieve.findGCD(smallNumber,largeNumber, sieve.getIsPrime());
        long endTime = System.nanoTime();
        return endTime - startTime;
//        System.out.println("FindGCD2 (ns) : "+(endTime - startTime));
//        return gcd;
    }

    public long FindGCD3(){
        long startTime = System.nanoTime();
        int gcd = Euclid.findGCD(smallNumber,largeNumber);
        long endTime = System.nanoTime();
        return endTime - startTime;
//        System.out.println("FindGCD3 (ns) : "+(endTime - startTime));
//        return gcd;
    }

    private static void assertValue(int a, int b){
        if(a < 0 || b < 0) throw new IllegalArgumentException("Arguments must be positive");
    }




}


