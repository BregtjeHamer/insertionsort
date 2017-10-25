package com.company;


public class Main {


    public static void main(String[] args) {
//
        int aantal = 200000;
        int[] klaar;

        int lijst1[] = new int[aantal];


        for (int j = 0; j < aantal; j++) {
            lijst1[j] = (int) (Math.random() * aantal) + 1;

        }

        for (int i = 0; i < 10; i++) {
//        new Main().print(lijst1, "lijst 1 ongesorteerd: " , lijst1.length );
//        System.out.println("\n");


            SortThread s1 = new SortThread(lijst1);
            Thread t1 = new Thread(s1);


            long startTime = System.nanoTime();
            t1.start();

            try {
                t1.join();

            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            klaar = s1.getKlaar();
            long endTime = System.nanoTime();
//        new Main().print(klaar, "lijst gesorteerd MAIN: ", lijst1.length);
//        System.out.println("\n");


            long duration = endTime - startTime;
            System.out.println(duration / 1000000 );
//"Eindtijd: " +
//+ " ms"

        }

    }

    public void print(int[] lijst, String woord, int lenght) {

        System.out.println(woord + lenght);
        for (int i : lijst) {

            System.out.print(i);
            System.out.print(", ");
        }
    }


}

