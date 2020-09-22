package course.a01;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
假设一个固定大小为k的窗口
 依次划过nums数组
 返回每一次划出状况的最大值
 * @author jack
 */
public class RunningMeans {
    public static void main(String[] args) {
        RunningMeans runningMeans = new RunningMeans();
        int[] nums = {4,3,5,4,3,3,6,7};
        int[] ans = runningMeans.handel(nums, 3);
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
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()){
                if(nums[i]>=nums[deque.peekLast()]){
                    deque.removeLast();
                }else{
                    deque.addLast(i);
                    break;
                }
            }
            if(deque.isEmpty()){
                deque.addLast(i);
            }
            //队列的头部过期
            if(i-k==deque.peekFirst()){
                deque.removeFirst();
            }
            //此时滑动窗口已达到长度为k
            if(i>=k-1){
                ans[index++]=nums[deque.peekFirst()];
            }
        }


        return ans;
    }

}
