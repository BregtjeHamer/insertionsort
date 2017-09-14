package com.company;

public class SortThread implements Runnable {
    private int[] teSorteren;

    public SortThread(int[] ongesorteerd) {
        teSorteren = ongesorteerd;
    }

    @Override
    public void run() {

        Sort.sorteren(teSorteren);

    }

    public int[] getTeSorteren() {
        return teSorteren;
    }
}
