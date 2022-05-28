class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[]tree=new ArrayList[n];
        
        for(int i=0;i<n;i++)tree[i]=new ArrayList<>();
        
        for(int[]e:edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        
        boolean[]vis=new boolean[n];
        
        int ans=dfs(tree,0,hasApple,vis);
        
        return ans != 0 ? ans-2 : ans;
        
    }
    
    public int dfs(ArrayList<Integer>[]tree,int root,List<Boolean>hasApple,boolean[]vis){
        int time=0;
        vis[root]=true;
        
        for(int child:tree[root]){
            if(!vis[child]){
                time+=dfs(tree,child,hasApple,vis);
            }
        }
        
        if(time!=0)return time+2;
        else if(hasApple.get(root))return 2;
        else return 0;
    }
}