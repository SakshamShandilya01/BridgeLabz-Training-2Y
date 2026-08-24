import java.util.Scanner;

class TwoDToOneD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (r <= 0 || c <= 0) {
            System.out.println("Invalid size.");
            sc.close();
            return;
        }

        int[][] a = new int[r][c];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[] b = new int[r * c];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[k++] = a[i][j];
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
