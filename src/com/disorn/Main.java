package com.disorn;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final int ROUND = 10;
        ArrayList<Long> timeNaive = new ArrayList<>();
        ArrayList<Long> timeSieve = new ArrayList<>();
        ArrayList<Long> timeEuclid = new ArrayList<>();
        gcdSolver solver = new gcdSolver();
        for(int i = 0;i<35;i++){
            timeNaive.add(0L);
            timeSieve.add(0L);
            timeEuclid.add(0L);
        }
        for (int j=0;j<ROUND;j++){
            for(int i =0;i<Test.excase2X.length;i++){
                solver.setValue(Test.excase2X[i],Test.excase2Y[i]);
                timeNaive.set(i,timeNaive.get(i) + solver.FindGCD1());
                timeSieve.set(i,timeSieve.get(i) + solver.FindGCD2());
                timeEuclid.set(i,timeEuclid.get(i) + solver.FindGCD3());
//                timeSieve.add(solver.FindGCD2());
//                timeEuclid.add(solver.FindGCD3());
            }
        }
        for(int i =0;i<35;i++){
            timeNaive.set(i,timeNaive.get(i)/ROUND);
            timeSieve.set(i,timeSieve.get(i)/ROUND);
            timeEuclid.set(i,timeEuclid.get(i)/ROUND);
        }
        System.out.println(timeNaive);
        System.out.println(timeSieve);
        System.out.println(timeEuclid);


//        System.out.println("===Case1===");
//        for(int i =0;i<Test.case1X.length;i++){
//            solver.setValue(Test.case1X[i], Test.case1Y[i]);
//            System.out.println("Input :"+Test.case1X[i]+" "+Test.case1Y[i]);
//            System.out.println("1: "+solver.FindGCD1());
//            System.out.println(("2: "+solver.FindGCD2()));
//            System.out.println("3: "+solver.FindGCD3());
//        }
//        System.out.println("===Extra1===");
//        System.out.println("-Naive-");
//        System.out.println("1: "+Naive.findGCD(Test.excase11));
//        System.out.println("2: "+Naive.findGCD(Test.excase12));
//        System.out.println("-Sieve-");
//        System.out.println("1: "+Sieve.findGCD(Test.excase11));
//        System.out.println("2: "+Sieve.findGCD(Test.excase12));
//        System.out.println("-Euclid-");
//        System.out.println("1: "+Euclid.findMultipleGCD(Test.excase11));
//        System.out.println("2: "+Euclid.findMultipleGCD(Test.excase12));
//        try {
//            FileWriter writer = new FileWriter(result);
//            writer.write(myString);
//            writer.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        int[] multiTestCase = {33,122,249}; //1
//        int[] multiTestCase = {17,23,2,97}; //1
//        int[] multiTestCase = {29493,73827,1284,18}; //3
//        int[] multiTestCase = {90,45,30};
//        System.out.println(Euclid.findMultipleGCD(multiTestCase));
//        System.out.println(Euclid.findGCD(-58,30));

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
