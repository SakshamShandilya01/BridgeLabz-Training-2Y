import java.util.Scanner;

class FirstNegative {
    static int search(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(search(a));

        sc.close();
    }
}
