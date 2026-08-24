import java.util.Scanner;

class StudentVoting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                System.out.println("Invalid age: " + a[i]);
            } else if (a[i] >= 18) {
                System.out.println("The student with the age " + a[i] + " can vote.");
            } else {
                System.out.println("The student with the age " + a[i] + " cannot vote.");
            }
        }
        sc.close();
    }
}
