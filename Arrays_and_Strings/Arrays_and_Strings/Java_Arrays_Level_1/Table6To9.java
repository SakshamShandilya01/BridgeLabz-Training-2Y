import java.util.Scanner;

class Table6To9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[4];

        for (int i = 0; i < a.length; i++) {
            a[i] = n * (i + 6);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(n + " * " + (i + 6) + " = " + a[i]);
        }
        sc.close();
    }
}
