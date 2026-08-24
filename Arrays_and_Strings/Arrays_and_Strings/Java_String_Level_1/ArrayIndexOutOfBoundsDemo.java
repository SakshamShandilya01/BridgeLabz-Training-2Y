import java.util.Scanner;

class ArrayIndexOutOfBoundsDemo {
    static void generate(String[] a) {
        System.out.println(a[a.length]);
    }

    static void handle(String[] a) {
        try {
            System.out.println(a[a.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] a = new String[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.next();
        }

        handle(a);

        sc.close();
    }
}
