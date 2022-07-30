// Brute Force: Merge two sorted arrays by using extra space
// Time Complexity: O(NlogN) for sorting the two arrays initially and O(N) for putting total
// N elements in the new array

// Insertion Sort Method
// take two pointers i and j at the starting of two arrays.
// if a1[i]>a2[j], swap a1[i] and a2[j] , then i++ , then again sort a2.
// else, only i++
// 1  4  7  8  10
// 2  3  9
// step 1: i++  , step 2: swap 4 and 2 and then sort a2 (i++)  ,  step 3: swap 3 and 7 ...... 
// Time Complexity: O(n1 x m1)  n1 is for traversing elements of a1 and m1 is for
// sorting the values of a2


// GAP Method:
// initially take gap = N/2 and compare every next N/2th elements in pair and swap if not
// in  increasing order
// after one loop, change the gap by N/4 and then N/8 .... till gap>0
// if N is odd, take the ceil value (for 7/2 take 4)
// Time complexity : O(logN) where logN is of base 2 (we are dividing N by 2 again and again)  // and O(N) for traversing each element



class Solution {
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for(int i=m;i<n+m;i++){
            nums1[i]=nums2[j];
            j++;
        }
        int N=n+m;
        int M=n+m;
        while(N>0){
            int gap=N/2;
            if(N%2!=0)gap++;
            int s=0;
            while(s<M-gap){
                if(nums1[s]>nums1[s+gap])swap(nums1,s,s+gap);
                s++;
            }
            N=N/2;
            if(N!=1 && N%2!=0)N++;
        }
    }
}