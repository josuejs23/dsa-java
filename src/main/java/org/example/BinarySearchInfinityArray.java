package org.example;

public class BinarySearchInfinityArray {
    public static void main(String[] args) {
        System.out.println(ans(new int[]{1,2,3,4,5,6},0));
    }

    /************************************
     *  TO STUDY - IMPORTANT SECTION   *
     ************************************/

// Algoritms to search for a value in a infinity array
    static int ans(int[] arr, int target){
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int newStart = end + 1;
            // Double the size of box
            // end = previous end + sizeOfBox * 2
            end = end + (end - start + 1) *2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int middle = start + (end - start) / 2;
            if(target > arr[middle]){
                start = middle + 1;
            } else if(target < arr[middle]){
                end = middle -1;
            } else{
                return middle;
            }
        }
        return -1;
    }
}
