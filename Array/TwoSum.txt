int twoSumDistinctPairs(int[] arr,int target){
    int count=0;
    int l=0,h=arr.length-1;
    while(l<h){
        int sum=arr[l]+arr[h];
        if(l>0 && arr[l-1]==arr[l]){
            ++l;
        }else if(h<arr.length-1 && arr[h]==arr[h+1]){
            --h;
        }else if(sum==target){
            ++count;
            ++l;
            --h;
        }else if(sum>target){
            h--;
        }else{
            l++;
        }
        return count;
    }
}

{1,1,2,4,5,4} 5
{1,1,2,4,4,5}

l          h 
l         h       +1
  l     h
    l   h
    l h
    h l