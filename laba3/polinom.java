public class polinom {

    public static void main(String[] args) {
        System.out.println("Введеные аргументы:");
        double[] numbers = new double[100];
        double[] fraction = new double[100];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Double.parseDouble(args[i]);
            //System.out.println(args[i]);
            System.out.print("1/" + numbers[i] + " ");
        }
        double sum = 0;
        for (int i = 0; i < args.length; i++) {
            fraction[i] = 1 / numbers[i];
            sum = sum + fraction[i];
        }
        System.out.println();
        System.out.println("Сумма чисел равна: " + sum);
    }
}

