package com.disorn;

public class Sieve {
    boolean[] isPrime;
    public Sieve(int n) {
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
}
