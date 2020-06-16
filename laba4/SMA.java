import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class SMA {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String csvFile = "D:\\Programms\\test\\test.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        try {

            ArrayList<Double> numbers3=new ArrayList<Double>();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(cvsSplitBy);
                ArrayList<Double> numbers2=new ArrayList<Double>();
                for (int i = 0; i < numbers.length; i++) {
                    numbers2.add(Double.parseDouble(numbers[i]));
                }
                numbers3=numbers2;
            }

            System.out.println("Введите размер окна:");
            int window;
            if (scanner.hasNextInt()) {
                window = scanner.nextInt();
            } else {
                System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
                scanner.next();//рекурсия
                window = Calculator.getInt();
            }

            numbers3=calculate(numbers3,window);
            FileWriter csvWriter = new FileWriter("output.csv");
            Iterator<Double> foreach_out = numbers3.iterator();
            while(foreach_out.hasNext()) {
                csvWriter.append(foreach_out.next().toString());
                csvWriter.append(",");
            }
            csvWriter.flush();
            csvWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static ArrayList<Double> calculate(ArrayList<Double> data, int window){
        ArrayList<Double> out = new ArrayList<Double>();

        Double[] arr = data.toArray(new Double[data.size()]);

        for (int i = 0; i < arr.length - window - 1; i++) {
            double val = arr[i];

            for (int j = i + 1; j < i + window; j++)
                val += arr[j];
            val /= window;

            out.add(val);
        }
        return out;
    }
}