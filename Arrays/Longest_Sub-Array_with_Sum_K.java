//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int nums[], int n, int k) {
        // Complet0e the function
        int r = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        
        int maxLen = 0;
        
        int sum = 0;
        while(r < nums.length){
            sum += nums[r];
            
            if(mp.get(sum) == null){
                mp.put(sum, r);
            }
            
            if(mp.get(sum - k) != null){
                if(maxLen < r - mp.get(sum - k)){
                    maxLen = r - mp.get(sum - k);
                }
            }
            
            r++;
        }
        
        return maxLen;
    }
}
