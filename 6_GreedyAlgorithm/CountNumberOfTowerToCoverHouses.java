int numberOfTowers(int[] houses,int range){
    int count=1;
    int lastLoc=houses[0]+range;
    for(int i=1;i<houses.length;++i){
     if(Math.abs(houses[i]-lastLoc)>range){
         ++count;
         lastLoc=houses[i]+range;
     }
    }
    return count;
 }