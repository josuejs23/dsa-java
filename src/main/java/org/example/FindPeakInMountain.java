package org.example;

public class FindPeakInMountain {
    public static void main(String[] args) {
//        System.out.println(peakOfMountain(new int[]{0,1,2,4,3,0}));
//        System.out.println(binarySearch(new int[]{0,1,2,3,4},4));
        System.out.println(findInMountainArray(new int[]{1,2,3,4,1,0}, 3));
    }

    /************************************
     *  TO STUDY - IMPORTANT SECTION   *
     ************************************/
    static int peakOfMountain(int[] arr){

        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int middle = start + ( end - start ) / 2;
            if(arr[middle] > arr[middle + 1]){
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid -1
                end = middle;
            } else {
                // you are in asc part of array
                start = middle + 1; // because we know that mid + 1 element > mid element
            }
        }
        // in the end, start == end are pointing to the largest number
        // start and end are always trying to find the max element in the above 2 checks
        return arr[start];
    }

    static int binarySearch(int[] arr, int target, int start, int end){

//        int start = 0;
//        int end = arr.length -1 ;
        while(start <= end){
            int mid = start + ( end - start) /2;
            if(target > arr[mid]){
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int findIndexAgnosticOrder(int[] arr, int target, int start, int end){
//        int start = 0;
//        int end = arr.length -1;

        boolean asc = arr[0] < arr[arr.length-1];
        while(start < end){
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


    static int findInMountainArray( int[] arr, int target){
        int maxIndex = peakOfMountain(arr);
        if(maxIndex != -1 && target < arr[maxIndex] ){
            return findIndexAgnosticOrder(arr, target, 0, maxIndex);
        }
        return -1;
    }
}
