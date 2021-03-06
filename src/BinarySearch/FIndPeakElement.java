package BinarySearch;

/**
 * Created by xuanwang on 1/1/17.
 */

/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
 */
public class FIndPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid - 1]){
                right = mid;
            }else if( nums[mid] < nums[mid + 1]){
                left = mid;
            }else{
                left = mid;
            }
        }
        if(nums[left] < nums[right])  return right;
        return left;
    }
}
