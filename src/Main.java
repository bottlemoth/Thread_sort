import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
            int drugi_wymiar = 13;
        int[] numbers = new int[1000];
        Random random = new Random();
        System.out.println(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(numbers));

        int len = numbers.length;
        int pierwszy_wymiar = (int) Math.ceil((double) len / drugi_wymiar);

        int[][] result = zamien2D.zamien(numbers, pierwszy_wymiar, drugi_wymiar);
        System.out.println((Arrays.deepToString(result)));
        List<int[]> result2 = new ArrayList<>();
        int[] wynik;
        List<Integer> wynik2 = new ArrayList<>();
        for (int[] chunk : result) {
            Wateksortujacy watek = new Wateksortujacy(chunk);
            watek.start();
            try{
                watek.join();
                result2.add(watek.getposortowanaTablica());
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
        wynik = result2.getFirst();
        for (int[] ints : result2) {
            wynik = Merge.merge(wynik, ints);
        }
        System.out.println((Arrays.toString(wynik)));
    }



}


