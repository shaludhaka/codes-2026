package com.java.codes.ds;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    void bruteForce(int[] nums) {

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    prod = prod * nums[j];
                }
            }
            output[i] = prod;
        }
        System.out.println("product of array except self : brute force: " + Arrays.toString(output));
    }

    void division(int[] nums) {

        int[] output = new int[nums.length];
        int prod = 1;
        int zero_count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero_count++;
                continue;
            }
            prod = prod * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero_count > 0) {
                output[i] = nums[i] == 0 ? prod : 0;
            } else
                output[i] = prod / nums[i];
        }


        System.out.println("product of array except self : division: " + Arrays.toString(output));
    }

    void suffixPrefix(int[] nums) {

        int[] output = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            suffix[j] = suffix[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = suffix[i] * prefix[i];
        }

        System.out.println("product of array except self : suffixPrefix: " + Arrays.toString(output));
    }


    void suffixPrefixOptimal(int[] nums) {

        int[] output = new int[nums.length];
        int prod = 1;
        int suf_prod = 1;
        output[0] = prod;

        for (int i = 1; i < nums.length; i++) {
            prod = prod * nums[i - 1];
            output[i] = prod;
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            suf_prod = suf_prod * nums[j + 1];
            output[j] = suf_prod * output[j];
        }

        System.out.println("product of array except self : suffixPrefix optimal: " + Arrays.toString(output));
    }


    public static void main(String[] args) {

        int[] nums = {-1, 1, 0, -3, 3};        //{1, 2, 4, 6};      // [-1,0,1,2,3]


        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();

        product.bruteForce(nums);
        product.division(nums);
        product.suffixPrefix(nums);
        product.suffixPrefixOptimal(nums);
    }
}
