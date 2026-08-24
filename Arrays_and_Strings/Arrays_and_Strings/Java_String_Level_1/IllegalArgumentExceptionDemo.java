import java.util.Scanner;

class IllegalArgumentExceptionDemo {
    static void generate(String s, int st, int en) {
        if (st > en) {
            throw new IllegalArgumentException("Start index is greater than end index.");
        }

        System.out.println(s.substring(st, en));
    }

    static void handle(String s, int st, int en) {
        try {
            generate(s, st, en);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int st = sc.nextInt();
        int en = sc.nextInt();

        handle(s, st, en);

        sc.close();
    }
}
