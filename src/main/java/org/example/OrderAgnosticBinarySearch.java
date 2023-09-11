package org.example;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        System.out.println(findIndexAgnosticOrder(new int[]{5,4,3,2,1},5));
        System.out.println(findIndexAgnosticOrder(new int[]{1,2,3,4,5},4));
    }

    static int findIndexAgnosticOrder(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;

        boolean asc = arr[0] < arr[arr.length-1];
        while(start <= end){
            int middle = start + (end - start) / 2;
            if(arr[middle] == target){
                return middle;
            }
            if(asc){
                if(target < arr[middle]){
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if(target > arr[middle]){
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return -1;
    }
}
