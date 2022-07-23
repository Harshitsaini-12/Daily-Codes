class NumberContainers {
public:
    map<int,int> temp;
    
    NumberContainers() {
        map<int,int> ans=temp;
    }
    
    void change(int index, int number) {
        auto it=temp.find(index);
        if(it!=temp.end())
            it->second=number;
        else
            temp.insert({index,number});
    }
    
    int find(int number) {
        for(auto x:temp){
            if(x.second==number)
                return x.first;
        }
        return -1;
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */