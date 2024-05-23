package com.geek.algorithm.sort;

import java.util.Arrays;

/**
 * @Author zhaojingchao
 * @Date 2024/05/23 10:01
 * @Email zhaojingchao@joysuch.com
 * @Desc 更容易理解的快速排序
 */
public class QuickSort1 {

    public static void main(String[] args) {
        int[] nums = new int[] {6, 5, 4, 3, 2, 1};
        QuickSort1 sort1 = new QuickSort1();
        System.out.println(Arrays.toString(sort1.sortArray(nums)));
    }
    //利用快速排序解决
    public int[] sortArray(int[] nums) {
        //定义一个左指针，指向数组元素的第一个元素
        int lo = 0;
        //定义一个右指针，指向数组元素的最后一个
        int hi = nums.length-1;
        //定义一个快速排序的方法
        return quickSort(nums,lo,hi);
    }
    public int[] quickSort(int[] nums, int lo,int hi){
        //如果左指针大于右指针，退出循环
        if(lo > hi){
            return null;
        }
        //定一个基数，指向数组的最左边的元素
        int key = nums[lo];
        //定义一个左指针，指向数组元素的第一个元素
        int left = lo;
        //定义一个右指针，指向数组元素的最后一个
        int right = hi;
        //当左右指针不相等时，就继续移动左右指针
        while(left != right){
            //从右往左遍历，当右指针指向的元素大于等于基数时，right--。右指针持续向左移动
            while(nums[right]>=key && left < right){
                right--;
            }
            //从左往右遍历，当左指针指向的元素小于等于基数时，left++。左指针持续向右移动
            while(nums[left]<=key && left < right){
                left++;
            }
            //当左右两个指针停下来时，交换两个元素
            swap(nums, left, right);

        }
        //当左右指针相遇时，将左右指针同时指向的元素和基数进行交换。
        swap(nums,left,lo);//这个看着可能会变扭，等同于小面两行代码。
        //不过这下面的两行的代码的顺序不能相反，否则导致结果，都为第一个基数。
        //首先把基数要填入的位置空出来，然后在将基数填入。
        // nums[lo] = nums[left];
        // nums[left] = key;
        quickSort(nums,lo, left-1);
        quickSort(nums,left+1,hi);
        return nums;
    }
    public void swap(int[] nums,int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
