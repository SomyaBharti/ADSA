//724 leetcode
public class pivot {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        int rightSum = total;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];           // compute new rightSum
            if (leftSum == rightSum) {
                return i;                  // pivot found
            }
            leftSum += nums[i];           // update leftSum
        }

        return -1;
    }
}

