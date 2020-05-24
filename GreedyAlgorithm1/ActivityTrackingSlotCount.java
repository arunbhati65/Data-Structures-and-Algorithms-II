package main.java.Sorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Customer implements Comparable<Customer>{
    public int start;
    public int end;

    public Customer(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return start == customer.start &&
                end == customer.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Customer o) {
        return start-o.start;
    }
}

//Wissen 
public class ActivityTrackingSlotCount {
    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        List<Customer> list = new LinkedList<>();
        for(int i=0;i<parkingStartEndTimes.length;++i){
            list.add(new Customer(parkingStartEndTimes[i][0],parkingStartEndTimes[i][1]));
        }
        Collections.sort(list);
        int slotCount=0;
        while (!list.isEmpty()){
            ++slotCount;
            List<Customer> served=new LinkedList<>();
            Customer prev=list.get(0);
            served.add(prev);
            for(int i=1;i<list.size();++i){
                if(list.get(i).start>prev.end){
                    served.add(list.get(i));
                }
            }
            list.removeAll(served);
            served=new LinkedList<>();
        }

        return slotCount;
    }

    public static void main(String args[]) {
        int parkingStartEndTimes[][] = {{5, 10}, {0, 20}};
        System.out.println(minParkingSpaces(parkingStartEndTimes));

    }
}

