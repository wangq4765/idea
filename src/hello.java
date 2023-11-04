public class hello {
    public static void main(String[] args) {
        System.out.println("100");
        System.out.println("200");

        int i=99;
        method1(i);

    }

    private static void method1(int i) {
         System.out.println("method1:"+i);
        method2(i);
    }

    private static void method2(int j) {
        j++;
        System.out.println("method2:"+j);
    }
}

