package com.company;

import java.util.ArrayList;

public class SortThread implements Runnable {
    private int[] teSorteren;
    private int lijst1[];
    private int lijst2[];
    private int[] gesorteerd;
    private int[] klaar;

    public SortThread(int[] ongesorteerd) {
        teSorteren = ongesorteerd;
    }

    @Override
    public void run() {
// telkens  +100
        if (teSorteren.length  >1110) {

            if (teSorteren.length % 2 != 0) {
                lijst1 = new int[teSorteren.length / 2 + 1];
                lijst2 = new int[teSorteren.length / 2];
            } else if (teSorteren.length % 2 == 0) {
                lijst1 = new int[teSorteren.length / 2];
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


            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            int[] gesorteerd1 = s1.getKlaar();
//

            int[] gesorteerd2 = s2.getKlaar();
//

            klaar = Sort.mergen(gesorteerd1, gesorteerd2);



        } else {

          klaar =  Sort.sorteren(teSorteren);


        }

    }

    public int[] getKlaar() {
        return klaar;
    }
}
