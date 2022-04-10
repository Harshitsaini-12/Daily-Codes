class Solution {
public:
    int calPoints(vector<string>& ops) {
        stack<int>st;
        int sum=0;
        
        for(string s:ops){
            if(s=="C"){
                st.pop();
            }else if(s=="D"){
                st.push(2*st.top());
            }else if(s=="+"){
                int val1=st.top();
                st.pop();
                
                int val2=st.top();
                st.push(val1);
                st.push(val1+val2);
            }else{
                st.push(stoi(s));
            }
        }
        
        while(st.size()!=0){
            sum+=st.top();
            st.pop();
        }
        
        return sum;
    }
};