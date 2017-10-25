package com.company;

import java.util.ArrayList;

public class Sort {


    public static int[] sorteren(int[] ongesorteerd) {

        int tijdelijk;
        for (int i = 1; i < ongesorteerd.length; i++) {
            for (int j = i; j > 0; j--) {
                //als het voorste getal kleiner is dan die daarvoor

                if (ongesorteerd[j] < ongesorteerd[j - 1]) {
                    // sla voorste op in tijdelijke variabele
                    tijdelijk = ongesorteerd[j];
                    // neem de voorste en plaats daar de achterste op,
                    ongesorteerd[j] = ongesorteerd[j - 1];
                    // zet dan op de achterste, de voorste (Tijdelijke)
                    //kortom wissel de plek om.
                    ongesorteerd[j - 1] = tijdelijk;
                }

            }

        }
        return ongesorteerd;


    }

    public static int[] mergen(int[] lijst1, int[] lijst2) {
        int[] klaar = new int[lijst1.length + lijst2.length];

        int i = 0, j = 0, k = 0;
        while (i < lijst1.length && j < lijst2.length) {
            if (lijst1[i] < lijst2[j]) {
                klaar[k] = lijst1[i];

                i++;
            } else {
                klaar[k] = lijst2[j];

                j++;
            }
            k++;
        }

        while (i < lijst1.length) {
            klaar[k] = lijst1[i];
            i++;
            k++;
        }

        while (j < lijst2.length) {
            klaar[k] = lijst2[j];
            j++;
            k++;
        }

        return klaar;
    }


}
