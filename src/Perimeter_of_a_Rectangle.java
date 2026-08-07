import java.util.Scanner;
public class Perimeter_of_a_Rectangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double l = sc.nextDouble();
        double w = sc.nextDouble();
        double p = 2 * (l+w);
        System.out.printf("Perimeter = %.2f", p);


    }
}
