import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Progress Bars Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        frame.setLayout(new GridLayout(5, 1, 10, 10));

        int lwatki = 25;
        int[] numbers = new int[120001];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        int pierwszy_wymiar = (int) Math.ceil((double) numbers.length / lwatki);

        int[][] result = zamien2D.zamien(numbers, pierwszy_wymiar, lwatki);
        List<int[]> result2 = new ArrayList<>();


        List<JProgressBar> progressBary = new ArrayList<>();

        for (int i = 0; i < pierwszy_wymiar; i++) {
            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setStringPainted(true);
            frame.add(progressBar);
            progressBary.add(progressBar);
        }

        JButton startButton = new JButton("Start");
        frame.add(startButton);

        startButton.addActionListener((ActionEvent e) -> {
            List<Wateksortujacy> watki = new ArrayList<>();

            // Tworzymy i uruchamiamy wątki sortujące
            for (int i = 0; i < result.length; i++) {
                int[] chunk = result[i];
                JProgressBar progressBar = progressBary.get(i);
                Wateksortujacy watek = new Wateksortujacy(chunk, progressBar);
                watki.add(watek);
                watek.start();
            }

            new Thread(() -> {
                long startTime = System.currentTimeMillis();
                for (Wateksortujacy watek : watki) {

                    try {

                        watek.join();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    result2.add(watek.getposortowanaTablica());
                }

                int[] wynik = result2.getFirst();
                for (int i = 1; i < result2.size(); i++) {
                    wynik = Merge.merge(wynik, result2.get(i));
                }

                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                System.out.println("Wynik końcowy: " + Arrays.toString(wynik));

                System.out.println("Czas sortowania: " + duration + " ms"); //
            }).start();
        });
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        frame.setVisible(true);
    }
}


