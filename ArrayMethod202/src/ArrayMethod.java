
public class ArrayMethod {
    public static void main(String[] args) {
        double[] list = new double[]{22, 30, 25, 35, -16, 60, -100};
        double average = Array(list);

        System.out.println("Average value of the array elements is : " + average);

    }

    public static double Array(double[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum = sum + i;
        double average = sum / numbers.length;
        return numbers.length;

    }

}
