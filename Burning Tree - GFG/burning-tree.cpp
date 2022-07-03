// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};


Node *buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current Node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current Node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
   map<Node*,Node*>par;
   map<Node*,int>vis;
   void mappingParent(Node *root,Node *parent){
       if(root==NULL)return;
       par[root]=parent;
       mappingParent(root->left,root);
       mappingParent(root->right,root);
       return;
   }
   Node *targetNode(Node *root,int target){
       if(root==NULL)return NULL;
       if(root->data==target)return root;
       Node *leftans=targetNode(root->left,target);
       Node *rightans=targetNode(root->right,target);
       if(leftans==NULL&&rightans==NULL)return NULL;
      else if(leftans)return leftans;
      else if(rightans)return rightans;
      else return NULL;
   }
   void burn(Node *root,int &ans,int curdist){
       if(root==NULL||vis[root])return;
       if(ans<curdist)ans=curdist;
       vis[root]=1;
       burn(root->left,ans,curdist+1);
       burn(root->right,ans,curdist+1);
       burn(par[root],ans,curdist+1);
       return;
       
   }
    int minTime(Node* root, int target) 
    {
      mappingParent(root,NULL);
     Node *tgt=targetNode(root,target);
     int ans=0;
     burn(tgt,ans,0);
     return ans;
      }
};

// { Driver Code Starts.

int main() 
{
    int tc;
    scanf("%d ", &tc);
    while (tc--) 
    {    
        string treeString;
        getline(cin, treeString);
        // cout<<treeString<<"\n";
        int target;
        cin>>target;
        // cout<<target<<"\n";

        Node *root = buildTree(treeString);
        Solution obj;
        cout<<obj.minTime(root, target)<<"\n"; 

        cin.ignore();

    }


    return 0;
}
  // } Driver Code Ends