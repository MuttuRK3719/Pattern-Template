class Main {
    public static void main(String[] args) {
        int []arr={2,5,1,3,2,10,1,1,1,1,1,1,1,3,6};
        System.out.println(maxSubArray(arr,14));
    }
static int maxSubArray(int []arr,int k){
        int sum=0,left=0,right=0,maxLength=0;
        while(right<arr.length){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum<=k)maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
// optimized instead of while we check only one time we not need to decrease the size of the window bcz already i have bigger window size
   static int maxSubArray(int []arr,int k){
        int sum=0,left=0,right=0,maxLength=0;
        while(right<arr.length){
            sum+=arr[right];
            if(sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum<=k)maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength;
    }
}
class Solution {
    static {
        int[]arr1=new int[2];
        for(int i=0;i<500;i++){
            maxScore(arr1,1);
        }
    }
https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
    public static int maxScore(int[] cardPoints, int k) {
     int LeftSum=0,RightSum=0,maxSum=0;
     for(int i=0;i<k;i++){
        LeftSum+=cardPoints[i];
     }   
     maxSum=LeftSum;
     int n=cardPoints.length-1;
     for(int i=k-1;i>=0;i--){
        LeftSum-=cardPoints[i];
        RightSum+=cardPoints[n--];
        maxSum=Math.max(maxSum,LeftSum+RightSum);
     }
     return maxSum;
    }
}
static int maxdub(String st){
    int l=0,r=0,n=st.length();
    int mx=0;
    int []hash=new int[256];
    while(r<n){
        char ch=st.charAt(r);
        if(hash[ch]!=0){
            l=hash[ch];      // ← PROBLEM HERE
        }
        int len=r-l+1;
        mx=Math.max(mx,len);
        hash[ch]=r+1;
        r++;
    }
    return mx-1;
}

https://leetcode.com/problems/max-consecutive-ones-iii/
public int longestOnes(int[] nums, int k) {
      int left=0,right=0,zeros=0;
        int maxLength=0;
        while(right<nums.length){
            if(nums[right]==0) zeros++;
            while(zeros>k){
                if(nums[left++]==0)zeros--;
            }
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength; 
    }
 public int longestOnes1(int[] nums, int k) {
     int left=0,right=0,zeros=0;
        int maxLength=0;
        while(right<nums.length){
            if(nums[right]==0) zeros++;
            if(zeros>k){
                if(nums[left++]==0)zeros--;
            }
            maxLength=Math.max(maxLength,right-left+1);
            right++;
        }
        return maxLength; 
}
https://leetcode.com/problems/remove-element/?envType=problem-list-v2&envId=two-pointers
 public static  int removeElement(int[] nums, int val) {
        int left=0;
        for(int i=0;i<nums.length;i++){
        if(nums[i]!=val)nums[left++]=nums[i];
        }
        return left;
    }
https://leetcode.com/problems/backspace-string-compare/?envType=problem-list-v2&envId=two-pointers  using stack
public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack=new Stack<>();
        Stack<Character> stack1=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!stack.isEmpty()&&ch=='#'){
                stack.pop();
            }
            else if(ch!='#') stack.push(ch);
        }

        for(char ch:t.toCharArray()){
            if(!stack1.isEmpty()&&ch=='#') stack1.pop();
            else if(ch!='#') stack1.push(ch);
        }
        if(stack.size()!=stack1.size()) return false;
        int n=stack.size();
        for(int i=0;i<n;i++){
            if(stack.pop()!=stack1.pop()) return false;
        }
        return true;
    }
     public boolean backspaceCompare(String s, String t) {
        char[]ch1=s.toCharArray();
        char[]ch2=t.toCharArray();

     int i=processString(ch1);
     int j=processString(ch2);
     if(j!=i) return false;
     for(int k=0;k<i;k++){
        if(ch1[k]!=ch2[k]) return false;
     }
     return true;
    }
    static int processString(char[]ch){
        int k=0;
        for(char c:ch){
            if(c!='#')ch[k++]=c;
            else if(k>0)k--;
        }
        return k;
    }
