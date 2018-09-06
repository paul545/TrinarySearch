/*
 * @author Paul Bosonetto
 * CSCI 333
 * 2018.08.26
 * Homework 1: Recursion
 *
 * This program implements a recursive'trinary search'. It divides an array into
 * 3 (roughly) equal parts, comparing the value in question, 'target', with each 
 * of the 2 dividers that seperate the 3 parts. Based on the comparisons, it invokes
 * a recursive call that repeats the process with the new bounds on the array. It
 * returns the index of the first occurrence of the 'target' number. 
 *
 */
package trinarysearch;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author PaulRoman
 */
public class TrinarySearch {
    
    public int trinarySearch(int arr[], int target){
        
        int length = arr.length;
        //create the left and right dividers to divide arry into 3 parts
        int left = 0 + length/3;
        int right = 0 + length/3 + length/3;
        
        int index = -1; //keep index at -1 until we find an occurrence of target
                
        if (target <= arr[left])
            return trinarySearch(arr, 0, left, target, index);
        
        if (target > arr[right])
            return trinarySearch(arr, right, length-1, target, index);
        
        else 
            return trinarySearch(arr, left, right, target, index);
    }
    
    
    public int trinarySearch(int arr[], int left, int right, int target, int index){
        
        int length = right-left;
        
        if (length <= 2){
            
            for (int i = left; i <= right; i++){
                if (arr[i] == target){
                    index = i;
                    return index;
                }      
            }
            
            return index;
        }
        
        int newLeft = left + length/3;
        int newRight = left + length/3 + length/3;
        
        if (target <= arr[newLeft])
            return trinarySearch(arr, left, newLeft, target, index);
        
        else if (target > arr[newRight])
            return trinarySearch(arr, newRight, right, target, index);
        
        else 
            return trinarySearch(arr, newLeft, newRight, target, index);
    }
    
    
    public static void main(String[] args) {
       
        int arr[]= {1,2,3,3,4,4,8,10,12,12};
        int arr2[] = {2, 3, 4, 5, 6, 7, 8, 10, 12, 13, 15, 17, 18, 19, 20, 21, 23, 26, 27,
            30, 31, 33, 34, 36, 38, 41, 42, 44, 45, 46, 48, 49, 50, 52, 54, 55, 59, 63, 66,
            68, 69, 70, 71, 73, 74, 75, 76, 77, 79, 80, 81, 82, 83, 85, 87, 94, 97, 98, 99, 100};
        
        TrinarySearch ts = new TrinarySearch();
        
        for (int i = 0; i < 10; i++){
            int j = ThreadLocalRandom.current().nextInt(0, 100);
            int index = ts.trinarySearch(arr2, j);
            if (index != -1)
                System.out.printf("The number %d was found at index %d\n", j, index);
            
            else
                System.out.printf("The number %d was not found\n", j);
        }
        
        System.out.println("--------\n-------------");

        for (int i = 0; i < 10; i++){
            int j = ThreadLocalRandom.current().nextInt(0, 15);
            int index = ts.trinarySearch(arr, j);
            if (index != -1)
                System.out.printf("The number %d was found at index %d\n", j, index);
            
            else
                System.out.printf("The number %d was not found\n", j);
        }

    }
    
}
