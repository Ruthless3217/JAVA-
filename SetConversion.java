import java.util.*;

public class SetConversion {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(15);

        Set<Integer> treeSet = new TreeSet<>(hashSet);

        System.out.println("Converted TreeSet: " + treeSet);
    }
}
