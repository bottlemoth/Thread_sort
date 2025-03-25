import java.util.Arrays;

public class Wateksortujacy extends Thread {
    private int[] tab;
    private long startTime;
    private long endTime;

    public Wateksortujacy(int[] tab) {
        this.tab = Arrays.copyOf(tab, tab.length); //kopiuje tablice
    }

    @Override
    public void run() {
        startTime = System.nanoTime();

        sortuj(tab);
        System.out.println(getName()+Arrays.toString(tab));
        endTime = System.nanoTime();
        System.out.println(getName() + " czas sortowania: " + (endTime - startTime)/1000 + " µs");
    }

    private void sortuj(int[] tab) {
        int n = tab.length-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tab[j] > tab[j+1]) {
                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                    //System.out.println(i + " " + j);
                }
            }
        }


    }


}