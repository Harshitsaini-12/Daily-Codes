/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    // void ans(Node* root,vector<int>&result){
    //     if(root==NULL){
    //         return;
    //     }
    //     result.push_back(root->val);
    //     for(Node* child:root->children){
    //         ans(child,result);
    //     }
    // return;
    // }
    
    vector<int> preorder(Node* root) {
        vector<int>ans;
       //  vector<int>result;
       // ans(root,result);
       //  return result;
        if(root){
            stack<Node*> st;
        
            st.push(root);
            
            while(!st.empty()){
                ans.push_back(st.top()->val);
                Node *temp = st.top();
                st.pop();
                
                if((temp -> children).size()) {
                    auto it = (temp -> children).rbegin();
                    while (it != (temp -> children).rend()) {
                        st.push(*it);
                        it++;
                    };
                }
            }
        }
        
        
        return ans;
    }

};