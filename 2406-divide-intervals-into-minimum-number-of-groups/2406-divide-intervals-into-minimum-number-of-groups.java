class Solution {
    public int minGroups(int[][] intervals) {
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                return a[0]-b[0];
            }
        });
        
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        pq.offer(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>pq.peek()){
                pq.poll();
            }
            
            pq.offer(intervals[i][1]);
        }
        
        return pq.size();
    }
}