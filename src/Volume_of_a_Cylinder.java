import java.util.Scanner;
public class Volume_of_a_Cylinder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius: ");
        float r = sc.nextFloat();
        System.out.println("Enter the height");
        float h = sc.nextFloat();
        double Volume = Math.PI * (r*r) * h;
        System.out.printf("Volume = %.2f", Volume);
    }
}
