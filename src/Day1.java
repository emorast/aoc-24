import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {

    public static int countOccurences(int x, ArrayList<Integer> arrayList) {
        int occurences = 0;
        for (int y : arrayList) {
            if (y == x) {
                occurences += 1;
            }
        }

        return occurences;
    }

    public static void main(String[] args) {

        String fileName = "C:\\dev\\exercises\\aoc\\AdventOfCode2024\\src\\input.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedFileReader = new BufferedReader(fileReader);
            String line;

            ArrayList<Integer> firstList = new ArrayList<Integer>();
            ArrayList<Integer> secondList = new ArrayList<Integer>();
            while ((line = bufferedFileReader.readLine()) != null) {

                String[] numbers = line.split("   ");

                int firstValue = Integer.parseInt(numbers[0]);
                int secondValue = Integer.parseInt(numbers[1]);

                firstList.add(firstValue);
                secondList.add(secondValue);
            }

            firstList.sort(null);
            secondList.sort(null);

            int sum = 0;
            int similarityScore = 0;
            for (int i = 0; i < firstList.size(); i++) {
                int firstValue = firstList.get(i);
                int secondValue = secondList.get(i);

                int occurences = countOccurences(firstValue, secondList);

                int delta = Math.abs(firstValue - secondValue);

                sum += delta;
                similarityScore += occurences * firstValue;

            }

            System.out.printf("Sum: %d SimilarityScore: %d", sum, similarityScore);

            bufferedFileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}