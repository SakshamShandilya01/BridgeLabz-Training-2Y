import java.util.Scanner;

class StringToCharArray {
    static char[] getChars(String s) {
        char[] a = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i);
        }

        return a;
    }

    static boolean cmp(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        char[] a = getChars(s);
        char[] b = s.toCharArray();

        System.out.println("Using method:");

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println("Using toCharArray():");

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        System.out.println();
        System.out.println("Both arrays are same: " + cmp(a, b));

        sc.close();
    }
}
