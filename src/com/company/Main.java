package com.company;


public class Main {

    /**
     * De main methode is de runable methode van ons project.
     * We maken hier de array aan en starten de threads.
     * @param args
     */
    public static void main(String[] args) {
//      aantal getallen in de array
        int aantal = 200000;
        int[] klaar;

        int lijst1[] = new int[aantal];

//      Vullen van de array
        for (int j = 0; j < aantal; j++) {
            lijst1[j] = (int) (Math.random() * aantal) + 1;

        }

//      Omdat we 10 keer de tijd willen meten.
        for (int i = 0; i < 10; i++) {


//          Hier maken we een thread die de SortThread gaat uitvoeren.

            SortThread s1 = new SortThread(lijst1);
            Thread t1 = new Thread(s1);

//          Starten tijd en starten thread.
            long startTime = System.nanoTime();
            t1.start();


//           Proberen threaed uit te voeren
            try {
                t1.join();

            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

//          Array vullen met gesorteerde lijst en tijd stoppen.
            klaar = s1.getKlaar();
            long endTime = System.nanoTime();

//          Berekenen totale tijd en uitprinten van deze tijd.
            long duration = endTime - startTime;
            System.out.println("Eindtijd: " + duration / 1000000+ " ms" );



        }

    }

    /**
     * Deze methode gebruikten we als we wouden kijken of onze arrays ook daadwerkelijik gesorteerd waren.
     * Hiermee printen we namelijk de arrays uit.
      * @param lijst de array die je wilt printen op het scherm.
     * @param woord het woord wat je er voor wilt zetten, bijvoorbeeld "lijst 1:".

     */
    public void print(int[] lijst, String woord) {

        System.out.println(woord);
        for (int i : lijst) {

            System.out.print(i);
            System.out.print(", ");
        }
    }


}

