package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class P4
        extends AbstractSolution<Double> implements GenericSolution<Double> {
    private final int[] nums1;
    private final int[] nums2;

    @Override
    public Double doSolve() {
        return findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            // 退化为二分
            return findMiddle(nums2, nums2.length, 0, 0, null);
        }
        if (nums2.length == 0) {
            return findMiddle(nums1, nums1.length, 0, 0, null);
        }

        int halfCount = 0;
        int halfCountTarget = (nums1.length + nums2.length) / 2;
        int nums1Start = 0;
        int nums1End = nums1.length;
        int nums2Start = 0;
        int nums2End = nums2.length;
        int nums1MiddleIndex = 0;
        int nums2MiddleIndex = 0;
        int extra = 0;
        while (halfCount < halfCountTarget) {
            if (nums1End == nums1Start) {
                return findMiddle(nums2, nums1.length + nums2.length,
                        nums2Start, halfCount, extra);
            }
            if (nums2End == nums2Start) {
                return findMiddle(nums1, nums1.length + nums2.length,
                        nums1Start, halfCount, extra);
            }

            double[] nums1MiddlePair = middle(nums1, nums1Start, nums1End);
            double[] nums2MiddlePair = middle(nums2, nums2Start, nums2End);
            double nums1Middle = nums1MiddlePair[0];
            nums1MiddleIndex = (int) nums1MiddlePair[1];
            double nums2Middle = nums2MiddlePair[0];
            nums2MiddleIndex = (int) nums2MiddlePair[1];
            if (nums1Middle == nums2Middle) {
                return resolve(nums1, nums2, nums1MiddleIndex, nums2MiddleIndex);
            } else if (nums1Middle < nums2Middle) {
                extra = nums1[nums1MiddleIndex];
                halfCount += (nums1MiddleIndex - nums1Start) + 1;
                nums1Start = nums1MiddleIndex + 1;
//                nums2End = nums2MiddleIndex + 1;
            } else {
                extra = nums2[nums2MiddleIndex];
                halfCount += (nums2MiddleIndex - nums2Start) + 1;
                nums2Start = nums2MiddleIndex + 1;
//                nums1End = nums1MiddleIndex + 1;
            }
        }
        return resolve(nums1, nums2, nums1MiddleIndex, nums2MiddleIndex);
    }

    private double resolve(int[] nums1, int[] nums2, int nums1MiddleIndex, int nums2MiddleIndex) {
        int nums1Middle = nums1[nums1MiddleIndex];
        int nums2Middle = nums2[nums2MiddleIndex];
        int total = nums1.length + nums2.length;
        int realHalf = total / 2;
        int half = nums1MiddleIndex + nums2MiddleIndex;
        Integer[] arr = new Integer[10];

        try {
            arr[0] = nums1[nums1MiddleIndex - 2];
        } catch (IndexOutOfBoundsException ignored) {
            arr[0] = Integer.MIN_VALUE;
        }
        try {
            arr[1] = nums2[nums2MiddleIndex - 2];
        } catch (IndexOutOfBoundsException ignored) {
            arr[1] = Integer.MIN_VALUE;
        }
        try {
            arr[2] = nums1[nums1MiddleIndex - 1];
        } catch (IndexOutOfBoundsException ignored) {
            arr[2] = Integer.MIN_VALUE;
        }
        try {
            arr[3] = nums2[nums2MiddleIndex - 1];
        } catch (IndexOutOfBoundsException ignored) {
            arr[3] = Integer.MIN_VALUE;
        }
        arr[4] = nums1[nums1MiddleIndex];
        arr[5] = nums2[nums2MiddleIndex];
        try {
            arr[6] = nums1[nums1MiddleIndex + 1];
        } catch (IndexOutOfBoundsException ignored) {
            arr[6] = Integer.MAX_VALUE;
        }
        try {
            arr[7] = nums2[nums2MiddleIndex + 1];
        } catch (IndexOutOfBoundsException ignored) {
            arr[7] = Integer.MAX_VALUE;
        }
        try {
            arr[8] = nums1[nums1MiddleIndex + 2];
        } catch (IndexOutOfBoundsException ignored) {
            arr[8] = Integer.MAX_VALUE;
        }
        try {
            arr[9] = nums2[nums2MiddleIndex + 2];
        } catch (IndexOutOfBoundsException ignored) {
            arr[9] = Integer.MAX_VALUE;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a));


        if (total % 2 == 0) {
            int p1 = 4 + (realHalf - half - 1);
            int p2 = 5 + (realHalf - half - 1);
            return (arr[p1] + arr[p2]) / 2.0;
        } else {
            int p = 4 + (realHalf - half);
            return arr[p];
        }
    }

    private double[] middle(int[] nums, int start, int end) {
        int middleIndex = (end - start) / 2 + start;
        if ((end - start) % 2 == 0) {
            return new double[]{(nums[middleIndex - 1] + nums[middleIndex]) / 2.0, middleIndex - 1};
        } else {
            return new double[]{nums[middleIndex], middleIndex};
        }
    }

    private double findMiddle(int[] nums, int l, int start, int half, Integer extra) {
        int realHalf = l / 2;
        int delta = realHalf - half;
        if (extra == null) {
            if (l % 2 == 0) {
                return (nums[start + delta - 1] + nums[start + delta]) / 2.0;
            } else {
                return nums[start + delta];
            }
        } else {
            if (l % 2 == 0) {
                if (extra > nums[start + delta - 1]) {
                    return (extra + nums[start + delta]) / 2.0;
                } else {
                    return (nums[start + delta - 1] + nums[start + delta]) / 2.0;
                }
            } else {
                if (nums[start + delta] < extra) {
                    return extra;
                }
                return nums[start + delta];
            }
        }
    }
}
