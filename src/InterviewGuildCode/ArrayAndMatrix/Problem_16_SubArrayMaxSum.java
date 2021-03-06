package InterviewGuildCode.ArrayAndMatrix;

/**
 * 子数组的最大累加和问题
 * 给定一个数组，返回子数组的最大累加和
 * 要求：时间复杂度O(N)，额外空间复杂度O(1)
 * 思路1：
 * 1：数组中没有正数，则最大的数是最大和
 * 1：数组中有正数，从左到右遍历，用cur记录累加和，cur<0，说明左边部分肯定
 * 不能作为产生最大累加和的子数组的左边部分，于是令cur=0,cur>0，每次累加都
 * 可能是最大的累加和
 * <p>
 * 思路2：
 * 1：从左到右遍历，记录每个元素对应的累加和，同时记录左边累加和最小的数，两个相减
 * 就是该元素结尾的子数组最大累加和
 */
public class Problem_16_SubArrayMaxSum {
    public static int maxSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < arr.length; ++i) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

    public static int maxSum2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = arr[0];
        int sum = arr[0];
        int minSum = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            sum += arr[i];
            if(minSum>0){
                max = Math.max(max, sum );
            }else{
                max = Math.max(max, sum - minSum);
            }
            minSum = Math.min(minSum, sum);
        }
        return max;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, -3, -5, 40, -10, -10, 100, 1};
        System.out.println(maxSum(arr1));
        System.out.println(maxSum2(arr1));

        int[] arr2 = {-2, -3, -5, 0, 1, 2, -1};
        System.out.println(maxSum(arr2));
        System.out.println(maxSum2(arr2));

        int[] arr3 = {2, 3, 5, 1};
        System.out.println(maxSum(arr3));
        System.out.println(maxSum2(arr3));

    }

}
