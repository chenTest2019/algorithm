package course.a01;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
假设一个固定大小为k的窗口
 依次划过nums数组
 返回每一次划出状况的最大值
 */
public class RunningMeans {
    public static void main(String[] args) {
        RunningMeans runningMeans = new RunningMeans();
        int[] nums = {1, 2, 5, 7, 9};
        int[] ans = runningMeans.handel(nums, 2);
        System.out.println(Arrays.toString(ans));

    }
    int[] handel(int[] nums, int k) {
        int[] ans;
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        if (k < 1) {
            return new int[0];
        }
        int length = nums.length;
        k= Math.min(k, length);
        int len=length-k+1;

        ans=new int[len];
        //从大到小
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()){
                if(nums[i]>=deque.peekLast()){
                    deque.removeLast();
                }else{
                    deque.addLast(nums[i]);
                    break;
                }
            }
            if(deque.isEmpty()){
                deque.addLast(nums[i]);
            }
            if(i>=k-1){
                ans[i-k+1]=deque.peekFirst();
                deque.removeFirst();
            }
        }
        return ans;
    }

}