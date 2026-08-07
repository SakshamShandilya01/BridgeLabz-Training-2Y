import java.util.Scanner;
public class Calculate_Simple_Interest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Principal: ");
        double P = sc.nextDouble();
        System.out.print("Enter the Rate: ");
        double R = sc.nextDouble();
        System.out.print("Enter the Time: ");
        double T = sc.nextDouble();
        double SI = (P*R*T) / 100;
        System.out.printf("Simple Interest = %.2f", SI);
    }
}
