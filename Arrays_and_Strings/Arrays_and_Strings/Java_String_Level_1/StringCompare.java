import java.util.Scanner;

class StringCompare {
    static boolean cmp(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        boolean x = cmp(a, b);
        boolean y = a.equals(b);

        System.out.println("Using charAt(): " + x);
        System.out.println("Using equals(): " + y);
        System.out.println("Both results are same: " + (x == y));

        sc.close();
    }
}
