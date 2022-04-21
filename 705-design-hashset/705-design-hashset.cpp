class MyHashSet {
public:
    vector<int>hm;
    int size;
    
    MyHashSet() {
        size=1e6+1;
       hm.resize(size);    
    }
    
    void add(int key) {
        hm[key]=1;
    }
    
    void remove(int key) {
        hm[key]=0;
    }
    
    bool contains(int key) {
        return hm[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */