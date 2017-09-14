package com.company;

public class Sort {


    public static void sorteren(int[] ongesorteerd) {

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

    }
}
