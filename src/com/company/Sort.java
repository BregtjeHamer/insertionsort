package com.company;

import java.util.ArrayList;

public class Sort {

    /**
     * De sorteren methode gaat via insertionsort de meegegeven lijst sorteren.
     * @param ongesorteerd de meegegeven lijst.
     * @return de gesorteerde lijst.
     */
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

    /**
     * De mergen methode gaat de twee meegegeven lijsten samen voegen d.m.v. mergen.
     * @param lijst1 meegegeven lijst 1.
     * @param lijst2 meegegeven lijst 2.
     * @return de samengevoegte lijst.
     */
    public static int[] mergen(int[] lijst1, int[] lijst2) {

//      Nieuwe array aanmaken zo groot als ijst 1 en 2 samen.
        int[] klaar = new int[lijst1.length + lijst2.length];

        int i = 0, j = 0, k = 0;

 //     Zolang i kleiner is dan de lengte van lijst 1 en lijst 2.
        while (i < lijst1.length && j < lijst2.length) {

 //         Dan gaan we kijken of het getal in lijst 1 op plek i,
 //         kleiner is dan het getal in lijst 2 op plek j.
 //         Als dat zo is, voegen we het kleinste getal, dus het getal uit lijst1, toe aan klaar.
            if (lijst1[i] < lijst2[j]) {
                klaar[k] = lijst1[i];

                i++;
            }
 //         Anders voegen we het getal uit lijst2 toe aan klaar.
            else {
                klaar[k] = lijst2[j];

                j++;
            }
            k++;
        }

//       Als een van de twee lijsten leeg is, dan voegen we het overgebleven getal/getallen toe aan klaar.
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
