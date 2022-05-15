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
    int deepestLevel=1;
    int sum=0;
    
    void deepestLeavesSum_(TreeNode*root,int level){
        if(root==NULL)return;
        
        if(level==deepestLevel){
            sum+=root->val;
        }
        
        if(level>deepestLevel){
            deepestLevel=level;
            sum=root->val;
        }
        
        deepestLeavesSum_(root->left,level+1);
        deepestLeavesSum_(root->right,level+1);
    }
    
    int deepestLeavesSum(TreeNode* root) {
        if(root==NULL)return 0;
        
       deepestLeavesSum_(root,1);
        return sum;
    }
};