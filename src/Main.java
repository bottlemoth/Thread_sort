import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int drugi_wymiar = 5;
        int[] numbers = new int[20];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }


        int len = numbers.length;
        int pierwszy_wymiar = (int) Math.ceil((double) len / drugi_wymiar);

        int[][] result = zamien2D.zamien(numbers, pierwszy_wymiar, drugi_wymiar);
        System.out.println((Arrays.deepToString(result)));

        for (int[] chunk : result) {
            Wateksortujacy watek = new Wateksortujacy(chunk);
            watek.start();
            int[] wynik = watek.getposortowanaTablica();

            }

        }



    }


