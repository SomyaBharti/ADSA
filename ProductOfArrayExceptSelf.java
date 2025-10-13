public class ProductOfArrayExceptSelf {

    // Function to calculate the product of all elements except the current element
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate prefix products and store in result array
        result[0] = 1; // No elements to the left of index 0
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products and multiply with prefix products
        int suffixProduct = 1; // No elements to the right of the last index
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

    // Helper function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(nums1));

        // Example 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Input: [-1, 1, 0, -3, 3]");
        System.out.print("Output: ");
        printArray(solution.productExceptSelf(nums2));
    }
}
