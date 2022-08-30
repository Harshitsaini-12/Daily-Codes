class Solution {
public:
    
    void helper(string out,int open,int close,vector<string>&s){
        if(open==0 && close==0){
            s.push_back(out);
            return;   
        }
        
        // open bracket call
        if(open!=0){
            string out1=out;
            out1.push_back('(');
            
            helper(out1,open-1,close,s);
        }
        
        //close bracket call
        if(close>open){
            string out2=out;
            out2.push_back(')');
            
            helper(out2,open,close-1,s);
        }
        
    }
    
    vector<string> generateParenthesis(int n) {
        vector<string>s;
        
        int open=n,close=n;
        string output="";
        
        helper(output,open,close,s);
        return s;
    }
};