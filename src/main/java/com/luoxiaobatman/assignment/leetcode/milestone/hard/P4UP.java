package com.luoxiaobatman.assignment.leetcode.milestone.hard;

import com.luoxiaobatman.assignment.support.solution.AbstractSolution;
import com.luoxiaobatman.assignment.support.solution.GenericSolution;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

@AllArgsConstructor
public class P4UP
        extends AbstractSolution<Double> implements GenericSolution<Double> {
    private final int[] nums1;
    private final int[] nums2;

    @Override
    public Double doSolve() {
        return findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = nums1.length + nums2.length;
        int k = (nums1.length + nums2.length) / 2 - 1;
        if (l % 2 != 0) {
            k = (nums1.length + nums2.length) / 2;
        }
        if (nums1.length == 0) {
            return trivial(nums2, 0, k, nums2.length);
        }
        if (nums2.length == 0) {
            return trivial(nums1, 0, k, nums1.length);
        }
        int nums1Start = 0;
        int nums2Start = 0;
        while (k > 1) {
            if (nums1Start >= nums1.length) {
                return trivial(nums2, nums2Start, k, l);
            }
            if (nums2Start >= nums2.length) {
                return trivial(nums1, nums1Start, k, l);
            }
            int kHalf = k / 2;
            int nums1StartNext = Math.min(nums1.length - 1, nums1Start + kHalf);
            int nums2StartNext = Math.min(nums2.length - 1, nums2Start + kHalf);
            if (nums1[nums1StartNext] <= nums2[nums2StartNext]) {
                k = k - Math.min(kHalf, nums1.length - nums1Start);
                nums1Start = nums1Start + kHalf;
            } else {
                k = k - Math.min(kHalf, nums2.length - nums2Start);
                nums2Start = nums2Start + kHalf;
            }
        }
        Queue<Integer> q = new PriorityQueue<>();
        try {
            q.offer(nums1[nums1Start]);
            q.offer(nums1[nums1Start + 1]);
            q.offer(nums1[nums1Start + 2]);
        } catch (Exception ignored) {}
        try {
            q.offer(nums2[nums2Start]);
            q.offer(nums2[nums2Start + 1]);
            q.offer(nums2[nums2Start + 2]);
        } catch (Exception ignored) {}
        if (k == 1) q.poll();
        if (l % 2 == 0) {
            return (q.poll() + q.poll()) / 2.0;
        } else {
            return q.poll();
        }
    }

    private double trivial(int[] nums, int start, int k, int l) {
        if (l % 2 == 0) {
            return (nums[start + k] + nums[start + k + 1]) / 2.0;
        } else {
            return nums[start+ k];
        }
    }
}
