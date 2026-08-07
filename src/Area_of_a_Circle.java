import java.util.Scanner;
public class Area_of_a_Circle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        float r = sc.nextFloat();
        float Area = (float) (Math.PI * (r*r));
        System.out.printf("Area = %.2f", Area);

    }
}
