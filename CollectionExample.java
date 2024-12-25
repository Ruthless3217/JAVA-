import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }

        System.out.println("Sorted integers: " + set);

        System.out.print("Enter number to search: ");
        int search = scanner.nextInt();

        if (set.contains(search)) {
            System.out.println("Element " + search + " found.");
        } else {
            System.out.println("Element " + search + " not found.");
        }

        scanner.close();
    }
}
