package com.wut.learn.base.ArraysClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/06/11/10:20
 * @Description:
 */
public class BinarySearch {
    /**
     * 直接寻找指定目标，找不到则返回-1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return -1;

    }

    /**
     * 寻找最左侧边界
     * @param nums
     * @param target
     * @return
     */
    int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 寻找最右侧边界
     * @param nums
     * @param target
     * @return
     */
    int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target)
            return -1;
        return right;

    }

    /**
     * 区间左开右闭
     * @param nums
     * @param target
     * @return
     */
    int searchRightOpen(int [] nums,int target){
        int left=0,right=nums.length;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid;
            } else if (nums[mid]<target) {
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
