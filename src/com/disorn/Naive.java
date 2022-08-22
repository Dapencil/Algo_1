package com.disorn;

import java.util.Arrays;

public class Naive {
    static final int MAXFACTORS = 1024 ;
    static class Factorization{
        int size;
        int factor[] = new int[MAXFACTORS + 1];
        int exponent[] = new int[MAXFACTORS + 1];
    }
    // Function to find the
    // factorization of M and N
    static void FindFactorization(int x, Factorization factorization){
        int i, j = 1;
        int n = x, c = 0;
        int k = 1;
        factorization.factor[0] = 1;
        factorization.exponent[0] = 1;
        for (i=2; i*i<=n;i++){
            c = 0;
            while (n%i==0){
                c++;
                // factorization.factor[j]=i;
                n = n / i;
                // j++;
            }
            if (c > 0)
            {
                factorization.exponent[k] = c;
                factorization.factor[k] = i;
                k++;
            }
        }
        factorization.size = k - 1;
    }
    static void DisplayFactorization(int x, Factorization factorization){
        int i;
        System.out.print("Prime factor of " + x + " = ");
        if(x==0)System.out.print("0\n");
        for (i = 1; i<=factorization.size;i++){
            System.out.print(factorization.factor[i]);
            if (factorization.exponent[i] > 1)System.out.print( "^" +factorization.exponent[i]);
            if (i < factorization.size)System.out.print("*");
            else System.out.println( );
        }
    }
    // function to find the gcd
    // using Middle School procedure
    static int gcdMiddleSchoolProcedure(int m, int n){
        Factorization mFactorization = new Factorization();
        Factorization nFactorization = new Factorization();
        int r, mi, ni, i, k, x = 1, j;
        // Step 1.
        FindFactorization(m, mFactorization);
//        DisplayFactorization(m, mFactorization);
        // Step 2.
        FindFactorization(n, nFactorization);
//        DisplayFactorization(n, nFactorization);
        // Steps 3 and 4.
        // Procedure algorithm for computing the
        // greatest common divisor.
        int min;
        i = 1;
        j = 1;
        int y=1;
        if(m==0)x=n;
        else if(n==0)x=m;
        while (i <= mFactorization.size &&j <= nFactorization.size){
            if (mFactorization.factor[i] <nFactorization.factor[j])i++;
            else if (nFactorization.factor[j] <mFactorization.factor[i])j++;
            else /*if arr1[i] == arr2[j]*/ {
                min = mFactorization.exponent[i] >nFactorization.exponent[j] ?nFactorization.exponent[j] :mFactorization.exponent[i];

                for(k=0;k<min;k++) y *= mFactorization.factor[i];

                x = x *y;
                i++;
                j++;
                y=1;
            }
        }
        return x;

    }

    static int findGCD(int[] numberArr){
        int[] preparedArr = Arrays.stream(numberArr).map(a -> Math.abs(a)).toArray();
        int gcd = 0;
        for (int i=0; i<preparedArr.length; i++){
            gcd = gcdMiddleSchoolProcedure(gcd,preparedArr[i]);
        }
        return gcd;
    }

}

