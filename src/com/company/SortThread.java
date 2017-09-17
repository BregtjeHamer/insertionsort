package com.company;

import java.util.ArrayList;

public class SortThread implements Runnable {
    private int[] teSorteren;
    private int lijst1[];
    private int lijst2[];
    private ArrayList<Integer> klaar;

    public SortThread(int[] ongesorteerd) {
        teSorteren = ongesorteerd;
    }

    @Override
    public void run() {

        if (teSorteren.length > 10) {

            if (teSorteren.length % 2 != 0) {
                lijst1 = new int[teSorteren.length / 2 + 1];
                lijst2 = new int[teSorteren.length / 2 - 1];
            } else {
                lijst1= new int[teSorteren.length / 2];
                lijst2 = new int[teSorteren.length / 2];
            }

            int a = 0;
            int b = 0;

            for (int i = 0; i < teSorteren.length; i++) {
                if (a == lijst1.length) {
                    lijst2[b] = teSorteren[i];
                    b++;
                } else {
                    lijst1[a] = teSorteren[i];
                    a++;
                }

            }

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
            new Main().print(gesorteerd1, "lijst 1 gesorteerd: ");
            System.out.println("\n");

            int[] gesorteerd2 = s2.getTeSorteren();
            new Main().print(gesorteerd2, "lijst 2 gesorteerd: ");
            System.out.println("\n");

            klaar = Sort.mergen(gesorteerd1, gesorteerd2);


            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println(klaar.toString());
            System.out.println(duration / 1000000 + "ms" );
        } else {

            Sort.sorteren(teSorteren);
        }

    }

    public int[] getTeSorteren() {
        return teSorteren;
    }
}
