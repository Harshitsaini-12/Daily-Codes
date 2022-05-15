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
    int sum=0;
    int deepestlevel=1;
    
    void ans(TreeNode*root,int level){
        if(!root)return;
        
        if(level==deepestlevel){
            sum+=root->val;
        }
        
        if(level>deepestlevel){
            deepestlevel=level;
            sum=root->val;
        }
        
        ans(root->left,level+1);
        ans(root->right,level+1);
        
    }
    
    int deepestLeavesSum(TreeNode* root) {
        if(!root)return 0;
        ans(root,1);
        return sum;
    }
};