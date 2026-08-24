import java.util.Scanner;

class VowelConsonantCount {
    static String type(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char)(c + 32);
        }

        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            }

            return "Consonant";
        }

        return "Not a Letter";
    }

    static int[] count(String s) {
        int v = 0;
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            String t = type(s.charAt(i));

            if (t.equals("Vowel")) {
                v++;
            } else if (t.equals("Consonant")) {
                c++;
            }
        }

        return new int[]{v, c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int[] a = count(s);

        System.out.println("Vowels: " + a[0]);
        System.out.println("Consonants: " + a[1]);

        sc.close();
    }
}
