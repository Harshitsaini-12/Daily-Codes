class UndergroundSystem {
public:
    unordered_map<int,pair<string,int>>checkInm; //uid--(stationName,Time)
    unordered_map<string,pair<int,int>>path; // routeName--(totaltime,count)
    
    UndergroundSystem() {}
    
    void checkIn(int id, string stationName, int t) {
        checkInm[id]={stationName,t};
    }
    
    void checkOut(int id, string stationName, int t) {
        auto checkinm=checkInm[id];
        checkInm.erase(id);
        
        string pathname=checkinm.first +"_"+stationName;
        path[pathname].first+=t-checkinm.second;
        path[pathname].second+=1;
        
    }
    
    double getAverageTime(string startStation, string endStation) {
        string routename=startStation+"_"+endStation;
        auto&route=path[routename];
        
        return (double)route.first/route.second;
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */