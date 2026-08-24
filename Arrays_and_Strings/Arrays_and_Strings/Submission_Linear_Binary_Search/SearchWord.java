import java.util.Scanner;

class SearchWord {
    static String search(String[] a, String w) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].contains(w)) {
                return a[i];
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] a = new String[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextLine();
        }

        String w = sc.nextLine();

        System.out.println(search(a, w));

        sc.close();
    }
}
