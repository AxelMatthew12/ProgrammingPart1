package JAVA.CODEWARS;

public class Katapast {
    public class CountBy {

        public static int[] countBy(int x, int n) {
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++) {
                sequence[i] = x * (i + 1);
            }
            return sequence;
        }
    
        public static void main(String[] args) {
            // Example usage:
            int[] result1 = countBy(1, 10);
            for (int number : result1) {
                System.out.print(number + " ");  // Output: 1 2 3 4 5 6 7 8 9 10
            }
            System.out.println();  // Just for new line
    
            int[] result2 = countBy(2, 5);
            for (int number : result2) {
                System.out.print(number + " ");  // Output: 2 4 6 8 10
            }
            System.out.println();  // Just for new line
        }
    }
}
