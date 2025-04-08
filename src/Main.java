import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int drugi_wymiar = 6;
        int[] numbers = new int[20];
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

        for (int i = 0; i <= result2.size()-1; i+=2) {
            //System.out.println(i);
            //System.out.println(Arrays.toString(result2.get(i)));
            wynik = Merge.merge(result2.get(i),result2.get(i+1));
            System.out.println(Arrays.toString(wynik));
        }

    }



}


