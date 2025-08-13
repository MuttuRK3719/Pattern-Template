class Main {
    public static void main(String[] args) {
        System.out.println(firstNeg(new int[]{12, -1, -7, 8, -15, 30, 16, 28},3));
    }
    static List<Integer>firstNeg(int []arr,int k){
        List<Integer> result=new ArrayList<>();
        if(k>arr.length) return result;
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0) que.add(i);
            if(!que.isEmpty()&&i-k+1>que.peek()){
                que.poll();
            }
            if(i>=k-1){
            if(!que.isEmpty()){
                result.add(arr[que.peek()]);
            }
            else  result.add(0);
        }
        return result;
    }
        static int longestSubString(String s, int k) {
        int maxLength = 0;
        Map<Character, Integer> fre = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            fre.put(ch, fre.getOrDefault(ch, 0) + 1);

            while (fre.size() > k) {
                char ch1 = s.charAt(left);
                fre.put(ch1, fre.get(ch1) - 1);
                if (fre.get(ch1) == 0) {
                    fre.remove(ch1);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }


System.out.println(firstNeg(new int[]{1,3,-1,-3,5,3,6,7},3));-------------->>>>>>>>>>>[3, 3, 5, 5, 6, 7]

static List<Integer>firstNeg(int []arr,int k){
        List<Integer> result=new ArrayList<>();
        if(k>arr.length) return result;
        Deque<Integer> que=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
        while(!que.isEmpty()&&que.peek()<=i-k){
            que.poll();
        }
        while(!que.isEmpty()&&arr[que.peekLast()]<arr[i]){
            que.pollLast();
        }
        que.offer(i);
        if(i>=k-1)result.add(arr[que.peek()]);
        }
        return result;
    }

int []arr={2, 1, 5, 2, 3, 2};
        System.out.println(maxSubArray(arr,7));--------------------------->>>>>>>>>>>>>>>>>>>>>>>  2
static int maxSubArray(int []arr,int k){
        int sum=0,left=0,right=0,maxLength=Integer.MAX_VALUE;
        while(right<arr.length){
            sum+=arr[right];
            if(sum>=k)
            maxLength=Math.min(maxLength,right-left+1);
            while(sum>=k){
                maxLength=Math.min(maxLength,right-left+1);
                sum-=arr[left++];
            }
            right++;
        }
        return (maxLength==Integer.MAX_VALUE)?0:maxLength;
    }

bruate force approch
static int longestSubString(String s,int k){
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            Map<Character,Integer> fre=new HashMap<>();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                fre.put(ch,fre.getOrDefault(ch,0)+1);
                if(fre.size()<=k){
                    maxLength=Math.max(maxLength,j-i+1);
                }
                else {
                    break;
                }
            }
        }
        return maxLength;
    }
Optimized Solution
        static int longestSubString(String s,int k){
        int maxLength=-1;
        int left=0;
        Map<Character,Integer> fre=new HashMap<>();
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            fre.put(ch,fre.getOrDefault(ch,0)+1);
            if(fre.size()>k){
                ch=s.charAt(left);
                fre.put(ch,fre.get(ch)-1);
                if(fre.get(ch)==0) fre.remove(ch);
                left++;
            }
            if(fre.size()<=k)
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

https://leetcode.com/problems/binary-subarrays-with-sum/

    public int numSubarraysWithSum1(int[] nums, int goal) {
        return getInit(nums, goal) - getInit(nums, goal - 1);
    }

    int getInit(int[] nums, int goal) {
        if(goal<0) return 0;
        int count = 0;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

            Using Map 21ms
            
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int sum=0;
        Map<Integer,Integer> fre=new HashMap<>();
        fre.put(0,1);
        for(int num:nums){
            sum+=num;
            count+=fre.getOrDefault(sum-goal,0);
            fre.put(sum,fre.getOrDefault(sum,0)+1);
        }
        return count;
    }

https://leetcode.com/problems/count-number-of-nice-subarrays/
    public int numberOfSubarrays(int[] nums, int k) {
        return getPosibleSubArray(nums, k) - getPosibleSubArray(nums, k - 1);
    }

    public int getPosibleSubArray(int[] nums, int k) {
        if (k < 0) return 0;
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right] % 2;
            while (sum > k) {
                sum -= nums[left++] % 2;
            }
            count += right - left + 1;
        }
        return count;
    }
      ------------------------2ms------------------------------
      public int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int oddSum = 0;
        int[] count = new int[nums.length + 1];
        count[0] = 1;
        for (int num : nums) {
            oddSum += num & 1;
            if (oddSum >= k) {
                result += count[oddSum - k];
            }
            count[oddSum]++;
        }
        return result;
    }
    https://leetcode.com/problems/subarrays-with-k-different-integers/
    public int subarraysWithKDistinct(int[] nums, int k) {
     return generateSubArray(nums,k)-generateSubArray(nums,k-1);  
    }
    int generateSubArray(int []nums,int k){
        if(k<0) return 0;
        int left=0,count=0;
        Map<Integer,Integer> fre=new HashMap<>();
        for(int right=0;right<nums.length;right++){
            fre.put(nums[right],fre.getOrDefault(nums[right],0)+1);
            while(fre.size()>k){
                fre.put(nums[left],fre.get(nums[left])-1);
                if(fre.get(nums[left])==0)fre.remove(nums[left]);
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }

        public static int subarraysWithKDistinct(int[] nums, int k) {
        int len = nums.length;
        int freq[] = new int[len + 1];
        int elementCount = 0;
        int result = 0;
        int left = 0;
        int mid = 0;

        for(int right = 0; right < len; right++){
            if(++freq[nums[right]] == 1) elementCount++;

            while(elementCount > k){
                if(--freq[nums[mid++]] == 0){
                    elementCount--;
                    left = mid;
                }
            }

            while(freq[nums[mid]] > 1){
                freq[nums[mid++]]--;
            }

            if(elementCount == k){
                result += mid - left + 1;
            }
        }
        return result;
    }
