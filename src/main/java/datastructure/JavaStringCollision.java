package datastructure;

import java.util.Objects;

public class JavaStringCollision {

    public static void main(String ars[]) {
        String a = "Siblings";
        String b = "Teheran";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(Objects.equals(a.intern(), b.intern()));
    }
}
