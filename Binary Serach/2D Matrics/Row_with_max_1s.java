//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int cnt_1 = arr[0].length;
        int maxIdx = -1;
        
        for(int i = 0;i < arr.length;i++){
            
            int l = 0;
            int r = arr[i].length - 1;
            int idx_1 = arr[0].length;
            
            while(l <= r){
                int mid = (l + r)/2;
                
                if(arr[i][mid] >= 1){
                    idx_1 = mid;
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            
            if(idx_1 < cnt_1){
                cnt_1 = idx_1;
                maxIdx = i;
            }
        }
        
        return maxIdx;
    }
}