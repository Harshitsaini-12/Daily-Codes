class Solution {
public:
    
    class TrieNode{
      public:
        TrieNode*children[2];
        
        TrieNode(){
            children[0]=nullptr;
            children[1]=nullptr;
        }
    };
    
    int findMaximumXOR(vector<int>& nums) {
        TrieNode* root=new TrieNode();
       
        
        //insert
        for(int elem:nums){
            TrieNode* curr=root;
            
            for(int i=31;i>=0;i--){
                int bit=(elem>>i & 1);
                
                if(curr->children[bit]==nullptr){
                    curr->children[bit]=new TrieNode();
                }
                    curr=curr->children[bit];
            }
        }
        
        int ans=0;
         for(int elem:nums){
             TrieNode* curr=root;
             int curr_ans=0;
            
            for(int i=31;i>=0;i--){
                int bit=(elem>>i & 1);
                
                int search_bit=bit==1?0:1;
                
                if(curr->children[search_bit]!=nullptr){
                    curr=curr->children[search_bit];
                    
                    curr_ans+=(int)pow(2,i);
                }else{
                     curr=curr->children[bit];
                }
            }
             
             ans=max(ans,curr_ans);
        }
      return ans;
        
    }
};