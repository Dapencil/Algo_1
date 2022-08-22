package com.disorn;

import java.util.ArrayList;
import java.util.Arrays;

public class Sieve {
    boolean[] isPrime;

    public Sieve() {
        int n = Integer.MAX_VALUE / 2;
        isPrime = new boolean[n+1];
        isPrime[0] = isPrime[1] = false;
        //init array
        for(int i = 2; i<=n;i++){
            isPrime[i] = true;
        }

        //mark composite number
        for(int number = 2; number*number <= n;number++){
            if(isPrime[number]){
                for(int j = number*number; j<=n ;j+=number){
                    isPrime[j] = false;
                }
            }
        }
    }

    public boolean[] getIsPrime() {
        return isPrime;
    }

    public static int findGCD(int[] numberArr){
        Sieve sieve = new Sieve();
        int[] preparedArr = Arrays.stream(numberArr).map(a -> Math.abs(a)).toArray();
        int gcd = 0;
        for (int i=0; i<preparedArr.length; i++){
            gcd = findGCD(gcd,preparedArr[i],sieve.getIsPrime());
        }
        return gcd;
    }

    public static int findGCD(int m,int n,boolean[] primeTable){
        boolean flag = m <= n;
        int smallNumber = flag? m:n;
        int largeNumber = flag? n:m;

        if (smallNumber == 0) return largeNumber;
        else if (largeNumber == 0) return smallNumber;

        int gcd;
        ArrayList<Integer> primeFactorSmall = Sieve.factorizationWithSieve(smallNumber,primeTable);
        ArrayList<Integer> primeFactorLarge = Sieve.factorizationWithSieve(largeNumber,primeTable);
        gcd = commonFacMulti(primeFactorSmall,primeFactorLarge);
        return gcd;
    }

    public static ArrayList<Integer> factorizationWithSieve(int number, boolean[] primeTable){
        ArrayList<Integer> factorList = new ArrayList<>();
        int tempFactor = 2;

        while(tempFactor*tempFactor <= number){
            if(primeTable[tempFactor] && number % tempFactor == 0){
                factorList.add(tempFactor);
                number = number / tempFactor;
            }else{
                tempFactor++;
            }
        }
        return factorList;
    }

    private static int commonFacMulti(ArrayList<Integer> firstPrimeFac,ArrayList<Integer> secondPrimeFac){
        ArrayList<Integer> smallArr,largeArr;
        int gcd = 1;
        int indexOfSmall = 0,indexOfLarge = 0;
        int passCounter = 0,oldValue = 0;

        if(firstPrimeFac.size() <= secondPrimeFac.size()){
            smallArr = firstPrimeFac;
            largeArr = secondPrimeFac;
        }else{
            smallArr = secondPrimeFac;
            largeArr = firstPrimeFac;
        }
        //end prepare

        while( indexOfSmall < smallArr.size() ){
            //new value same as old eg. 2 2
            if(oldValue == smallArr.get(indexOfSmall)){
                indexOfSmall++;
                continue;
            }
            //if found common factor
            if(smallArr.get(indexOfSmall).compareTo(largeArr.get(indexOfLarge))==0){
                gcd *= smallArr.get(indexOfSmall);
                indexOfSmall++;
                passCounter = indexOfLarge;
                indexOfLarge = (1 + indexOfLarge) % (largeArr.size());
                continue;
            }
            //if not found any common factor
            else if(indexOfLarge == largeArr.size() - 1){
                oldValue = smallArr.get(indexOfSmall);
                indexOfSmall++;
                indexOfLarge = passCounter;
                continue;
            }
            indexOfLarge = (indexOfLarge + 1 ) % (largeArr.size());
        }
        return gcd;
    }
}
