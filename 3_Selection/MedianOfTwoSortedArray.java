    public double findMedianSortedArrays(int[] nums1, int[] nums2) { //log(min(x,y))
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int length1=nums1.length;
        int length2=nums2.length;
        int l=0,h=length1;
        while(l<=h){
            int posX=(l+h)/2;
            int posY=(length1 + length2+1)/2-posX;
            
            int minX=(posX==0)?Integer.MIN_VALUE:nums1[posX-1];
            int maxX=(posX==length1)?Integer.MAX_VALUE:nums1[posX];
            int minY=(posY==0)?Integer.MIN_VALUE:nums2[posY-1];
            int maxY=(posY==length2)?Integer.MAX_VALUE:nums2[posY]; 
            if(minX<=maxY && minY<=maxX){
                double avg=(length1 + length2);
                avg=avg%2;
                if(avg==0.0){
                    return (double)(Math.max(minX,minY)+Math.min(maxX,maxY))/2;
                }else{
                    return Math.max(minX,minY);
                }
            }else if(maxY<minX){
                h=posX-1;
            }else if(minY>maxX){
                l=posX+1;
            }
        }
        throw new IllegalArgumentException();
    }
