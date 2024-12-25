import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumberArray {
    
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;  // 0 and 1 are not prime
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;  // If divisible, not prime
            }
        }
        return true;  // Prime number
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking user for the range of numbers to check
        System.out.print("Enter the number range to check for prime numbers (e.g., 1 to n): ");
        int n = scanner.nextInt();

        // ArrayList to store the prime numbers
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        // Check each number from 1 to n and add prime numbers to the array
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        // Displaying the prime numbers
        System.out.println("Prime numbers from 1 to " + n + " are: ");
        for (int prime : primeNumbers) {
            System.out.print(prime + " ");
        }

        scanner.close();
    }
}
