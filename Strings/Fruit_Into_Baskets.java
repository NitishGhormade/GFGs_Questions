//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        int l = 0;
        int r = 0;
        
        int maxlen = 0;
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        while(r < arr.length){
            if(mp.get(arr[r]) == null){
                mp.put(arr[r], 1);
            }
            else{
                mp.put(arr[r], mp.get(arr[r]) + 1);
            }
            
            if(mp.size() <= 2){
                maxlen = r - l + 1;
            }
            else{
                mp.put(arr[l], mp.get(arr[l]) - 1);
                
                if(mp.get(arr[l]) == 0){
                    mp.remove(arr[l]);
                }
                
                l++;
            }
            
            r++;
        }
        
        return maxlen;
    }
}