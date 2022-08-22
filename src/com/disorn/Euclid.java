package com.disorn;

import java.util.Arrays;

public class Euclid {

    public static int findGCD(int m,int n){
        boolean flag = m <= n;
        int smallNumber = flag? m:n;
        int largeNumber = flag? n:m;
        //gcd(a,0) = a

        if (smallNumber == 0) return largeNumber;
        else if (largeNumber == 0) return smallNumber;

//        if (smallNumber > largeNumber) {
//            int tmp = smallNumber;
//            smallNumber = largeNumber;
//            largeNumber = tmp;
//        }

        int r = largeNumber % smallNumber;

        while (r != 0) {
            largeNumber = smallNumber;
            smallNumber = r;
            r = largeNumber % smallNumber;
        }
        return smallNumber;
    }

    public static int findMultipleGCD(int[] intArr){
        int[] preparedArr = Arrays.stream(intArr).map(a -> Math.abs(a)).toArray();
        int gcd = 0;
        for (int i=0; i<preparedArr.length; i++){
            // need to change
            gcd = findGCD(gcd,intArr[i]);
        }
        return gcd;
    }
}
