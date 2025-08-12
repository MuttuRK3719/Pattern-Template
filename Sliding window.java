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
