package at.ghazarian.others;

import java.util.ArrayList;
import java.util.List;

public class PartialInitialization {
    static A a = null;

    public static void main(String[] args) {

        List<A> aList = new ArrayList<>();
        try {
            a = new A(aList);
        } catch (Exception e) {
            //
        }
        System.out.println(a);
        System.out.println(aList.size());
        System.out.println(aList.get(0));
    }

    static class A {
        private String s = null;
        public A(List<A> aList) {
            this.s = "hello";
            aList.add(this);
            throw new RuntimeException();
        }

        @Override
        public String toString() {
            return "A{" +
                    "s='" + s + '\'' +
                    '}';
        }
    }
}
