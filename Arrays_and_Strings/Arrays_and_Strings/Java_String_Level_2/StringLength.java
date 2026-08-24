import java.util.Scanner;

class StringLength {
    static int len(String s) {
        int n = 0;

        while (true) {
            try {
                s.charAt(n);
                n++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int a = len(s);
        int b = s.length();

        System.out.println("Length using charAt(): " + a);
        System.out.println("Length using length(): " + b);

        sc.close();
    }
}
