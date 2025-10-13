//1539 leetcode
public class missing {
  
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        // If the first element is greater than k, then the k-th missing is just k
        if (arr[0] > k) {
            return k;
        }

        int left = 0, right = n;  // search space is [0, n]
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missingUpToMid = arr[mid] - (mid + 1);  // number of missing positives before arr[mid]
            if (missingUpToMid >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Now left is the smallest index where missingUpToMid >= k, 
        // or left == n if even by the last element we have fewer than k missing

        // The element just before `left`
        int prevIndex = left - 1;
        int missingBeforePrev = arr[prevIndex] - (prevIndex + 1);

        // The k-th missing number is after arr[prevIndex]
        return arr[prevIndex] + (k - missingBeforePrev);
    }
}
