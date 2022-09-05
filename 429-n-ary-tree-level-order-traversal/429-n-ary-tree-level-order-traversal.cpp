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
    vector<vector<int>> levelOrder(Node* root) {
              vector<vector<int>>ans;
        if(root==NULL)return ans;
      
        queue<Node*>q;
        q.push(root);

        while(q.size()>0){
            vector<int>level;
            int size=q.size();
            
            for(int i=0;i<size;i++){
                Node*top=q.front();
                q.pop();
                
              for(Node* child:top->children){
                  q.push(child);
              }
                
                level.push_back(top->val);
            }
            ans.push_back(level);
        }
   
        return ans;
    }
};