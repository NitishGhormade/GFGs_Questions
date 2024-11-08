//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        int k = 0;
        int len = 0;
        
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        
        int sum = 0;
        for(int i = 0;i < n;i++){
            sum += arr[i];
            
            if(mp.get(sum) == null){
                mp.put(sum, i);
            }
            
            if(mp.get(sum - k) != null){
                len = Math.max(len, i - mp.get(sum - k));
            }
        }
        
        return len;
    }
}