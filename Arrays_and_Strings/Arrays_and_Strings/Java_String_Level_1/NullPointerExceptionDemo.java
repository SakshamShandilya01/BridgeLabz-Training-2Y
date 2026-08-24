class NullPointerExceptionDemo {
    static void generate() {
        String s = null;
        System.out.println(s.length());
    }

    static void handle() {
        String s = null;

        try {
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled.");
        }
    }

    public static void main(String[] args) {
        handle();
    }
}
