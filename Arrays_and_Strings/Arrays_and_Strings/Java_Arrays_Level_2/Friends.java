import java.util.Scanner;

class Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] name = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] h = new double[3];

        for (int i = 0; i < age.length; i++) {
            age[i] = sc.nextInt();
            h[i] = sc.nextDouble();
        }

        int yi = 0, hi = 0;
        for (int i = 1; i < age.length; i++) {
            if (age[i] < age[yi]) yi = i;
            if (h[i] > h[hi]) hi = i;
        }

        System.out.println("Youngest = " + name[yi]);
        System.out.println("Tallest = " + name[hi]);
        sc.close();
    }
}
