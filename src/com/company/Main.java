package com.company;


import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
//
        int aantal = 800000;


        int lijst1[] = new int[aantal / 2];
        int lijst2[] = new int[aantal / 2];
        int rondje = 0;
        while (rondje < 10) {
            ArrayList<Integer> klaar = new ArrayList<>();
            for (int i = 0; i < 10; i++) {

//            int ongesorteerd[] = new int[aantal];


                for (int j = 0; j < lijst1.length; j++) {
                    lijst1[j] = (int) (Math.random() * aantal) + 1;
                    lijst2[j] = (int) (Math.random() * aantal) + 1;
                }
            }

//            new Main().print(lijst1, "lijst 1 ongesorteerd: ");
//            System.out.println("\n");
//            new Main().print(lijst2, "lijst 2 ongesorteerd: ");
//            System.out.println("\n");

            SortThread s1 = new SortThread(lijst1);
            SortThread s2 = new SortThread(lijst2);

            Thread t1 = new Thread(s1);
            Thread t2 = new Thread(s2);

            long startTime = System.nanoTime();
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            int[] gesorteerd1 = s1.getTeSorteren();
//            new Main().print(gesorteerd1, "lijst 1 gesorteerd: ");
//            System.out.println("\n");
//
//            int[] gesorteerd2 = s2.getTeSorteren();
//            new Main().print(gesorteerd2, "lijst 2 gesorteerd: ");
//            System.out.println("\n");

            //samenvoegen
//        for (int i = 0; i <lijst1.length; i++) {
//            for (int j = 0; j < lijst1.length; j++) {
//
//
//                if (lijst1[i] <= lijst2[i]) {
//                    klaar.add(lijst1[i]);
//
//                } else {
//                    klaar.add(lijst2[i]);
//                }
//
//            }
//        }

            int i = 0;
            int j = 0;
            int a = 0;

            while (a < aantal) {

                if (i == aantal / 2) {
                    klaar.add(lijst2[j]);
                    j++;
                } else if (j == aantal / 2) {
                    klaar.add(lijst1[i]);
                    i++;
                } else if (lijst1[i] <= lijst2[j]) {
                    klaar.add(lijst1[i]);
                    i++;

                } else {
                    klaar.add(lijst2[j]);
                    j++;
                }


                a++;


            }
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
//            System.out.println(klaar.toString());
            rondje++;
            System.out.println(duration / 1000000);
//            System.out.println("looptijd "+rondje+ " :"+duration / 1000000 + "ms");
        }
        System.out.println(aantal);
        //sorteren
//            new Main().print(ongesorteerd);
//            System.out.println("\n");


//            System.out.println("\n");
//            long startTime = System.nanoTime();
////            Sort.sorteren(ongesorteerd);
//
//            long endTime = System.nanoTime();
////            new Main().print(ongesorteerd);
//
//            long duration = endTime - startTime;
//            System.out.println("\n");
//            System.out.println("looptijd " + (i + 1) + ": " + duration / 1000000 + "ms");
////            totaal[i] = (int) (duration / 1000000);
    }


    public void print(int[] lijst, String woord) {

        System.out.println(woord);
        for (int i : lijst) {

            System.out.print(i);
            System.out.print(", ");
        }
    }


}

