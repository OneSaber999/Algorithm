package com.company;

import java.util.Arrays;

//《算法设计》
public class QuickSort {


    public static void quick_sort(int q[], int l, int r) {
        if (l >= r) {
            return;
        }
        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {

            while(q[++i] < x && i < r);
            while(q[--j] > x);
            if (i < j) {
                swap(q,i, j);
            }
        }
        System.out.println(l+".."+r+"..,x = "+x+" ");
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }

    public static void swap(int[] list, int j, int k) {
        int temp = list[j];
        list[j] = list[k];
        list[k] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {6,1,3,2,8,9,4};
        int k = 4;
        quick_sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[k-1]);


    }
}