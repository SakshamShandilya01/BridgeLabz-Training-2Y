import java.util.Scanner;
public class Celsius_to_Fahrenheit_Conversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Temperature in celcius: ");
        float t = sc.nextInt();
        float F = (t*9.0f/5.0f) + 32;
        System.out.printf("Temperature in fahrenheit: %.2f" , F);


    }
}
