/*
The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)

 */
class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int l=0,h=arr.length-1;
        int count=0;
        while(l<=h){
            ++count;
            if(arr[l]+arr[h]<=limit){
                ++l;
            }
            --h;
        }
        return count;
    }
}