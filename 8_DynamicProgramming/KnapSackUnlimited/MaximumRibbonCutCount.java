/*
n: 7
Ribbon Lengths: {2,3}
Output: 3
Explanation: Ribbon pieces will be {2,2,3}.
*/

int maxRibbonPieceCutCount(int[] valid,int length){
    int count=helper(valid,length,valid.length-1);
    if(count<0) return -1;
    return count;
}

int helper(int[] valid,int length,int index){
     if(length==0) return 0; 
     if(index==-1 || length<0) return -1;
     int count1=-1;
     if(valid[index]<=length){
         int temp=1+helper(valid,length-valid[index],index);
         if(temp>=0){
             count1=1+temp;
         }
     }
     int count2=helper(valid,length,index-1);
     return Math.max(count1,count2);
}

                            
