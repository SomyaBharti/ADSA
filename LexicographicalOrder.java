//440
public class LexicographicalOrder {
    public static void main(String[] args) {
        int n = 13;
        int k = 2;
        Solution solution = new Solution();
        int result = solution.findKthNumber(n, k);
        System.out.println("The " + k + "th lexicographically smallest number in the range [1, " + n + "] is: " + result);
    }
}

class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1;
        int remaining = k - 1;  // We've 'used' one slot for curr = 1
        
        while (remaining > 0) {
            long count = countSubtree(curr, curr + 1, n);
            if (remaining >= count) {
                // Skip this entire subtree
                curr += 1;
                remaining -= count;
            } else {
                // Dive into this subtree
                curr *= 10;
                remaining -= 1;
            }
        }
        
        return (int) curr;
    }

    // Count how many numbers are between prefixes 'a' (inclusive) and 'b' (exclusive) up to n
    private long countSubtree(long a, long b, long n) {
        long count = 0;
        while (a <= n) {
            count += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return count;
    }
}
