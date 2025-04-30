import javax.swing.*;
import java.util.Arrays;

public class Wateksortujacy extends Thread {
    private final int[] tab;
    private int[] posortowanaTablica;
    int res;
    private final JProgressBar progressBar;

    public Wateksortujacy(int[] tab, JProgressBar progressBar) {
        this.tab = Arrays.copyOf(tab, tab.length);
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        try {
            this.posortowanaTablica = sortuj(tab);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getName()+Arrays.toString(this.posortowanaTablica));
    }

    private synchronized int[] sortuj(int[] tab) throws InterruptedException {
        int n = tab.length-1;
        for (int i = 0; i < n; i++) {
            //Thread.sleep(500);

            for (int j = 0; j < n; j++) {
                if (tab[j] > tab[j+1]) {
                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;

                }
            }

            int percent = (int)(((double) i / (n - 1)) * 100);

            SwingUtilities.invokeLater(() -> progressBar.setValue(percent));

        }

        SwingUtilities.invokeLater(() -> progressBar.setValue(100));
        return tab;
    }

    public int[] getposortowanaTablica(){
        return this.posortowanaTablica;
    }


}