import java.util.Scanner;

class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = n * (i + 1);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(n + " * " + (i + 1) + " = " + a[i]);
        }
        sc.close();
    }
}
