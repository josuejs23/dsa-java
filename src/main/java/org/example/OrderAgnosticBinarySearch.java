package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
//        System.out.println(findIndexAgnosticOrder(new int[]{5,4,3,2,1},5));
//        System.out.println(findIndexAgnosticOrder(new int[]{1,2,3,4,5},4));
//        System.out.println(findRootSquare(142));
//        System.out.println(findCeilingOfTarget(new int[]{0,20,30,40,50,60,70,80,90},10));
//        System.out.println(findCeilingOfTarget(new int[]{0,10,20,30,40,50,60,70,80,90},40));
//        System.out.println(findFloorOfTarget(new int[]{0,1,20,30,40,50,60,70,80,90},10));
//        System.out.println(findSmallestCharGreaterThanTarget( new char[]{'a','b','c','d'}, 'e'));
//        System.out.println(Arrays.toString(firstAndLastAppearence(new int[]{1,1,1,2,2}, 2)));
        System.out.println(Arrays.toString(firstAndLastAppearence(new int[]{1,2,2,2,3,3,3},3)));
    }

    static int findIndexAgnosticOrder(int[] arr, int target){
        int interatio = 1;
        int start = 0;
        int end = arr.length -1;

        boolean asc = arr[0] < arr[arr.length-1];
        while(start < end){
            System.out.println("Iteration: "+interatio++);
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

    static int findRootSquare(int number){
        int start = 0;
        int end = number;
        while(start <= end){
            int mid = (start + end) / 2;
            if(mid * mid == number){
                return mid;
            } else if(mid * mid < number){
                start += 1;
            } else {
                end -= 1;
            }
        }
        return -1;
    }

    static int findCeilingOfTarget(int[] arr, int target){

        int start = 0;
        int end = arr.length-1;
        while( start <= end){
            int middle = start + (end - start) /2;
            if(target > arr[middle]){
                start = middle + 1;
            } else if(target < arr[middle]) {
                end = middle - 1;
            } else {
                return arr[middle];
            }
        }
        return arr[start];
    }

    static int findFloorOfTarget(int[] arr, int target){

        int start = 0;
        int end = arr.length-1;
        while( start <= end){
            int middle = start + (end - start) /2;
            if(target > arr[middle]){
                start = middle + 1;
            } else if(target < arr[middle]) {
                end = middle - 1;
            } else {
                return arr[middle];
            }
        }
        return arr[end];
    }

    static char findSmallestCharGreaterThanTarget(char[] letters, char target){
        int start = 0;
        int end = letters.length - 1;
        while( start <= end ){
            int middle = start + (end - start)/ 2;
            if(target > letters[middle]){
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        // This line is to cover also when the start is equal to arr.length
        // This is for wrapped arrays
        return letters[start % letters.length];
    }

    private static int findIndex(int[] arr, int target, boolean findStartIndex) {
        int ans = -1;
        int iterate = 1;
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            int middle = start + (end - start) / 2;
            if(target > arr[middle]){
                start = middle + 1;
            } else if (target < arr[middle]){
                end = middle - 1;
            }
            else{
                ans = middle;
                if(findStartIndex){
                    end = middle - 1;
                } else{
                    start = middle + 1;
                }
            }

        }

        return ans;
    }
    static int[] firstAndLastAppearence(int[] arr, int target){
        int[] ans = new int[]{-1,-1};
        ans[0] = findIndex(arr,target,true);
        if(ans[0] != -1){
            ans[1] = findIndex(arr, target, false);
        }
        return  ans;
    }


}
