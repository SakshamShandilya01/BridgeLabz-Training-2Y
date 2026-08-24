import java.util.Scanner;

class StringIndexOutOfBoundsDemo {
    static void generate(String s) {
        System.out.println(s.charAt(s.length()));
    }

    static void handle(String s) {
        try {
            System.out.println(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled.");
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
