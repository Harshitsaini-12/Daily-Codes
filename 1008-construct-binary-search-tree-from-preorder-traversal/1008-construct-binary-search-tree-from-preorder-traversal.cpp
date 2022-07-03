/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    TreeNode* bstFromPreorder_(vector<int>&preorder,int lr,int rr,vector<int>&idx){
        int i=idx[0];
        
        if(i>=preorder.size() || preorder[i]<lr || preorder[i]>rr)return NULL;
        
        TreeNode*root=new TreeNode(preorder[i]);
        idx[0]++;
        
        root->left=bstFromPreorder_(preorder,lr,root->val,idx);
        root->right=bstFromPreorder_(preorder,root->val,rr,idx);
        
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
      vector<int>idx(1,0);
        return bstFromPreorder_(preorder,INT_MIN,INT_MAX,idx);
    }
};