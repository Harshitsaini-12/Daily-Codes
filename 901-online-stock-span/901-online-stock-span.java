class StockSpanner {
        static class Pair{
            int price;
            int index;
        }
    
        Stack<Pair>st;
        int time=0;
    
    public StockSpanner() {
            st=new Stack<>();
            Pair base=new Pair();
            base.price=10000001;
            base.index=-1;
            st.push(base);
      }
    
    public int next(int price) {
          Pair p=new Pair();
          p.price=price;
          p.index=time;
        
          time++;
        
        while(st.size()>0 && st.peek().price<=p.price)st.pop();
        
        int ans=p.index-st.peek().index;
        st.push(p);
       return ans; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */