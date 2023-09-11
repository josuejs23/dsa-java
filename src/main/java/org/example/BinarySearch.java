package org.example;

public class BinarySearch {
    public static void main(String[] args) {

//        System.out.println(findIndex(new int[]{1,2,3,4}, 5));
//        System.out.println(findIndex(new int[]{1,2,3,4,12,40}, 4));
        System.out.println(findIndex(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, 100));
    }

    private static int findIndex(int[] arr, int target) {
        int iterate = 1;
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            System.out.println("Iteration "+ iterate++);
            int middle = start + (end - start) / 2;
            if(target > arr[middle]){
                start = middle + 1;
            } else if (target < arr[middle]){
                end = middle - 1;
            }
            else{
                return middle;
            }

        }

        return -1;
    }
}