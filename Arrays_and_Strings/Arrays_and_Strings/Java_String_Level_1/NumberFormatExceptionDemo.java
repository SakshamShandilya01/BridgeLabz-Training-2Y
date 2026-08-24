import java.util.Scanner;

class NumberFormatExceptionDemo {
    static void generate(String s) {
        int n = Integer.parseInt(s);
        System.out.println(n);
    }

    static void handle(String s) {
        try {
            generate(s);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        handle(s);

        sc.close();
    }
}
