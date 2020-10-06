class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        ListNode last=head;
        while(last.next!=null){
            last=last.next;
        }
        return mergeSort(head,last);
    }
    
    ListNode mergeSort(ListNode l,ListNode h){
        if(l==h) return l;
        ListNode middle=findMiddle(l);
        ListNode next=middle.next;
        middle.next=null;
        ListNode left=mergeSort(l,middle);
        ListNode right=mergeSort(next,h);
        return sort(left,right);
    }
    
    ListNode sort(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                curr.next=list1;
                curr=curr.next;
                list1=list1.next;
            }else{
                curr.next=list2;
                curr=curr.next;
                list2=list2.next;                
            }
        }
        while(list1!=null){
                curr.next=list1;
                curr=curr.next;
                list1=list1.next;
        }
        while(list2!=null){
                curr.next=list2;
                curr=curr.next;
                list2=list2.next;
        }
        return dummy.next;
    }
    
    ListNode findMiddle(ListNode head){
        ListNode ptr1=head,ptr2=head;
        while(ptr2.next!=null && ptr2.next.next!=null){
            ptr1=ptr1.next;
            ptr2=ptr2.next.next;
        }
        return ptr1;
    }
}
public class MergeSort{
    static void doMergeSort(int [] arr,int l,int h){
	if(h>l){
        	int mid=(l+(h-l)/2);
		doMergeSort(arr,l,mid);
		doMergeSort(arr,mid+1,h);
		merge(arr,l,mid,h);
	}
    }
	
    static void merge(int[] arr,int l,int mid,int high){
	int[] left=new int[mid-l+1];
	int[] right=new int[high-(mid+1)+1];
	for(int i=l;i<=mid;++i){
		left[i-l]=arr[i];
	}
	for(int i=mid+1;i<=high;++i){
		right[i-(mid+1)]=arr[i];
	}
	int indexL=0; int indexR=0; int mainIndex=l;
	while(indexL<left.length && indexR<right.length){
		if(left[indexL]<right[indexR]){
			arr[mainIndex++]=left[indexL++];
		}else{
			arr[mainIndex++]=right[indexR++];
		}
	}
	while(indexL<left.length){
		arr[mainIndex++]=left[indexL++];
	}
	while(indexR<right.length){
		arr[mainIndex++]=right[indexR++];
	}

    }		

    static void printAll(int[] arr){
        System.out.print("\nAll Elements after partitioning are : ");
        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i]+"-");
        }
    }

    public static void main(String args[]){
        int [] arr={12,2132,12,3,1,32,53,1,212,42};
        doMergeSort(arr,0,arr.length-1);
        printAll(arr);
    }

}
