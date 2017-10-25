package com.company;

import java.util.ArrayList;

public class SortThread implements Runnable {
    private int[] teSorteren;
    private int lijst1[];
    private int lijst2[];
    private int[] gesorteerd;
    private int[] klaar;

    /**
     * De SortThread word gebruikt om de gestarte thread in de main.java weer onder te veredelen in nog twee threads.
     * Dit gebeurd zolang de array groter is dan de drempelwaarde.
     *
     * @param ongesorteerd de lijst die gesorteerd moet worden.
     */
    public SortThread(int[] ongesorteerd) {
        teSorteren = ongesorteerd;
    }


    @Override
    public void run() {

//      als de lijst langer is de de drempelwaarde worden er twee nieuwe lijsten gemaakt. (array's)
        if (teSorteren.length > 1110) {

            if (teSorteren.length % 2 != 0) {
                lijst1 = new int[teSorteren.length / 2 + 1];
                lijst2 = new int[teSorteren.length / 2];
            } else if (teSorteren.length % 2 == 0) {
                lijst1 = new int[teSorteren.length / 2];
                lijst2 = new int[teSorteren.length / 2];
            }

            int a = 0;
            int b = 0;

            // lijsten vullen.
            for (int i = 0; i < teSorteren.length; i++) {
                if (a == lijst1.length) {
                    lijst2[b] = teSorteren[i];
                    b++;
                } else {
                    lijst1[a] = teSorteren[i];
                    a++;
                }

            }

//          Hier maken we twee nieuwe sorthreads aan die we meegegven aan twee nieuewe threads.
            SortThread s1 = new SortThread(lijst1);
            SortThread s2 = new SortThread(lijst2);

            Thread t1 = new Thread(s1);
            Thread t2 = new Thread(s2);

//          Hier starten we de twee nieuwe threads en proberen we deze uit te voeren.
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

//          De nieuwe gesorteerde lijst 1.
            int[] gesorteerd1 = s1.getKlaar();

//          De nieuwe gesorteerde lijst 2.
            int[] gesorteerd2 = s2.getKlaar();

//         We geven de lijst 1 en lijst 2 mee aan de Sort.mergen, hier worden deze twee samengevoegd,
//         Die we vervolgens toewijzen aan 'klaar'.
            klaar = Sort.mergen(gesorteerd1, gesorteerd2);


        } else {
//        Als de array kleiner is dan de drempelwaarde, hoeft deze dus niet meer te worden verveeld.
//        We geven deze mee aan de sorteer methode van Sort, en deze word daar gesorteerd.
            klaar = Sort.sorteren(teSorteren);


        }

    }

    public int[] getKlaar() {
        return klaar;
    }
}
