class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[]colors=new int[graph.length];
        Arrays.fill(colors,-1);
        
        for(int i=0;i<graph.length;i++){
           
            if(colors[i]!=-1)continue;
            
            if(hasEvenLenCycle(graph,i,colors,0)==false)return false;
        }
        return true;
    }
    
    
    private boolean hasEvenLenCycle(int[][] graph,int currV,int[]colors,int color){
        
        if(colors[currV]!=-1)return colors[currV]==color;
        
        colors[currV]=color;
        
        for(int neig:graph[currV]){
            if(hasEvenLenCycle(graph,neig,colors,1-color)==false){
                return false;
            }
        }
        return true;
    }
}