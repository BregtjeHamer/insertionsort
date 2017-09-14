package com.company;


public class Main {


    public static void main(String[] args) {
//
        int aantal = 10;


        for (int i = 0; i < 10; i++) {

//            int ongesorteerd[] = new int[aantal];

            int lijst1[] = new int[aantal / 2];
            int lijst2[] = new int[aantal / 2];

            for (int j = 0; j < lijst1.length; j++) {
                lijst1[j] = (int) (Math.random() * aantal) + 1;
                lijst2[j] = (int) (Math.random() * aantal) + 1;
            }


            SortThread s1 = new SortThread(lijst1);
            SortThread s2 = new SortThread(lijst2);

            Thread t1 = new Thread(s1);
            Thread t2 = new Thread(s2);

            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            int[] gesorteerd1 = s1.getTeSorteren();
            int[] ongesorteerd2 = s2.getTeSorteren();

            //sorteren
//            new Main().print(ongesorteerd);
//            System.out.println("\n");


            System.out.println("\n");
            long startTime = System.nanoTime();
//            Sort.sorteren(ongesorteerd);

            long endTime = System.nanoTime();
//            new Main().print(ongesorteerd);

            long duration = endTime - startTime;
            System.out.println("\n");
            System.out.println("looptijd " + (i + 1) + ": " + duration / 1000000 + "ms");
//            totaal[i] = (int) (duration / 1000000);
        }

    }


    public void print(int[] lijst) {

        for (int i : lijst) {

            System.out.print(i);
            System.out.print(", ");
        }
    }


}

