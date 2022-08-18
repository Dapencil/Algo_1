package com.disorn;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 7966496,tempNum = 2;
        ArrayList<Integer> primeFactor = new ArrayList<>();
        Sieve sieve = new Sieve(n);
        boolean[] temp = sieve.getIsPrime();

        while(tempNum <= n){
            if(temp[tempNum] && n % tempNum == 0){
                primeFactor.add(tempNum);
                n = n / tempNum;
            }else{
                tempNum++;
            }
        }
        System.out.println(Arrays.toString(primeFactor.toArray()));
    }

    public static int commonFacMulti(int[] firstPrimeFac,int[] secondPrimeFac){
        int[] smallArr,largeArr;
        int gcd =1;
        int indexOfSmall = 0,indexOfLarge = 0;
        int passCounter = 0,oldValue = 0;

        if(firstPrimeFac.length <= secondPrimeFac.length){
            smallArr = firstPrimeFac;
            largeArr = secondPrimeFac;
        }else{
            smallArr = secondPrimeFac;
            largeArr = firstPrimeFac;
        }
        //end prepare

        while( indexOfSmall < smallArr.length ){
            //new value same as old eg. 2 2
            if(oldValue == smallArr[indexOfSmall]){
                indexOfSmall++;
                continue;
            }
            //if found common factor
            if(smallArr[indexOfSmall] == largeArr[indexOfLarge]){
                gcd *= smallArr[indexOfSmall];
                indexOfSmall++;
                passCounter++;
            }
            //if not found any common factor
            else if(indexOfLarge == largeArr.length - 1){
                oldValue = smallArr[indexOfSmall];
                indexOfSmall++;
                indexOfLarge = passCounter;
                continue;
            }
            indexOfLarge = (passCounter + indexOfLarge + 1 ) % (largeArr.length);
        }
        return gcd;
    }
}

//    int[] arrayS = {2,2,5,5};
//        int[] arrayL = {2,2,2,5,5,5};
//        int gcd = 1;
//        int i = 0,j = 0,passCounter=0,oldValue=0;
//        while( i < arrayS.length ){
//
//            //new value same as old eg. 2 2
//            if(oldValue == arrayS[i]){
//                i++;
//                continue;
//            }
//
//            //if found common
//            if(arrayS[i] == arrayL[j]){
//                gcd *= arrayS[i];
//                i++;
//                passCounter++;
//            }
//
//            //if not found common
//            else if(j == arrayL.length - 1){
//                oldValue = arrayS[i];
//                i++;
//                j = passCounter;
//                continue;
//            }
//            j = (passCounter + j + 1 ) % (arrayL.length);
//        }
//        System.out.println(gcd);

//        int[] factorOf100 = {2,2,3};
//        int[] factorOf1000 = {3,3,3,3};
//        HashMap<Integer, Stack<Integer>> bucket = new HashMap<>();
//        Integer value=0;
//        Integer key=;
//        for(int i = 0;i<size;i++){
//            if(!key.equals(array[i])){
//                if(bucket.containsKey(key)){
//                    bucket.get(key).push(value);
//                }else bucket.put(key,new Stack<>());
//                key = array[i];
//            }else value++;
//        }
