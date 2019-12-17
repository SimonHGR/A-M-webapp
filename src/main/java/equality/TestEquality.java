package equality;

import java.util.Objects;

class MyCustomer {
    private String custId;
    private String name;
    private long creditLimit;

    public MyCustomer(String custId, String name, long creditLimit) {
        this.custId = custId;
        this.name = name;
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyCustomer)) return false;
        MyCustomer that = (MyCustomer) o;
        return Objects.equals(custId, that.custId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId);
    }
}

public class TestEquality {
    public static void main(String[] args) {
//        int x = 99;
//        int y = 100;
//        int z = 99;
//
//        System.out.println("x == y " + (x == y));
//        System.out.println("x == z " + (x == z));

        String s1 = new String("Hello");
        String s2 = new String("Hello World");
        String s3 = new String("Hello");

//        String s1 = "Hello";
//        String s2 = "Hello World";
//        String s3 = "Hello";
        s1 = s1.intern();
        s3 = s3.intern();

        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s1 == s3 " + (s1 == s3));

        System.out.println("s1.equals(s2) " + (s1.equals(s2)));
        System.out.println("s1.equals(s3) " + (s1.equals(s3)));

        System.out.println("--------------------------------");
//
//        StringBuilder sb1 = new StringBuilder("Hello");
//        StringBuilder sb2 = new StringBuilder("Hello World");
//        StringBuilder sb3 = new StringBuilder("Hello");
//
//        System.out.println("sb1 == sb2 " + (sb1 == sb2));
//        System.out.println("sb1 == sb3 " + (sb1 == sb3));
//
//        System.out.println("sb1.equals(sb2) " + (sb1.equals(sb2)));
//        System.out.println("sb1.equals(sb3) " + (sb1.equals(sb3)));
//
//        sb2 = sb1;
//        System.out.println("sb1 == sb2 " + (sb1 == sb2));
//        System.out.println("sb1 == sb3 " + (sb1 == sb3));
//
//        System.out.println("sb1.equals(sb2) " + (sb1.equals(sb2)));
//        System.out.println("sb1.equals(sb3) " + (sb1.equals(sb3)));
//
//
//        MyCustomer mc1 = new MyCustomer("12345", "Fred", 1000);
//        MyCustomer mc2 = new MyCustomer("12345", "Fred", 1000);
//
//        System.out.println("mc1 == mc2 " + (mc1 == mc2));
//        System.out.println("mc1.equals(mc2) " + mc1.equals(mc2));

    }
}
