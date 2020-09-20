class MedianFinder {
    PriorityQueue<Integer> minPq=new PriorityQueue<>();
    PriorityQueue<Integer> maxPq=new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer a,Integer b){
            return b-a;
        }
    });
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxPq.isEmpty()){
            maxPq.add(num);
        }
        else if(maxPq.size()==minPq.size()){
            if(minPq.peek()<num){
                maxPq.add(minPq.poll());
                minPq.add(num);
            }else{
                maxPq.add(num);
            }
        }else{
            if( maxPq.peek()>num){
                minPq.add(maxPq.poll());
                maxPq.add(num);
            }else{
                minPq.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(maxPq.size()==minPq.size()){
            return ((double)minPq.peek()+(double)maxPq.peek())/2;
        }else{
            return (double)maxPq.peek();
        }
    }

}
