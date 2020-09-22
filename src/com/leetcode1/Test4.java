package com.leetcode1;

import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        Test4 test =new Test4();
        int[] nums1={1,3};
        int[] nums2={2};
        System.out.println(test.findMedianSortedArrays(nums1,nums2));
    }
    //执行用时：4 ms,在所有 Java 提交中击败了17.73%的用户
    //内存消耗：39.8 MB, 在所有 Java 提交中击败了63.05%的用户
    //不满足时间复杂度 O(log(m + n))  这种复杂度提示为2分法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]nums3=new int[nums1.length+nums2.length];
        //数组的复制
        //nums1 原数组，0：从源数据的起始位置，nums3:目标数组，3：目标数组开始的起始位置，3：要copy的数组长度
        System.arraycopy(nums1,0,nums3,0,nums1.length);
        System.arraycopy(nums2,0,nums3,nums1.length,nums2.length);
        //数组的排序
        Arrays.sort(nums3);
        if(nums3.length%2==0){
            return (nums3[nums3.length/2]+nums3[nums3.length/2-1])/2.0;
        }else{
            return  nums3[(nums3.length-1)/2];
        }
    }
}
