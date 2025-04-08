import java.util.Arrays;

public class Wateksortujacy extends Thread {
    private int[] tab;
    private int[] posortowanaTablica;

    public Wateksortujacy(int[] tab) {
        this.tab = Arrays.copyOf(tab, tab.length); //kopiuje tablice
    }

    @Override
    public void run() {

        this.posortowanaTablica = sortuj(tab);
        System.out.println(getName()+Arrays.toString(this.posortowanaTablica));
    }

    private int[] sortuj(int[] tab) {
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

    return tab;
    }
    public int[] getposortowanaTablica(){
        return this.posortowanaTablica;
    }


}