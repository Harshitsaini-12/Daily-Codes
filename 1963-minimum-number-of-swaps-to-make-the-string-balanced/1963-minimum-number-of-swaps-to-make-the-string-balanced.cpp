class Solution {
public:
    int minSwaps(string s) {
        stack<int>helper;
        
        for(int ch:s){
            if(ch=='[')helper.push(ch);
            else if(!helper.empty())helper.pop();
        }
        
        
        return (helper.size()+1)/2;
    }
};