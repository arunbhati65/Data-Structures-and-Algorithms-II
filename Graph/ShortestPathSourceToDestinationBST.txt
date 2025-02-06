public void shortestPath(Integer a, Integer b,List<Integer>[] graph) {
    if (a == null || b == null) return null;
    if (a == b) return null;
        
    Queue<Integer> toVisit = new LinkedList<Integer>();
    HashMap<Integer, Integer> parents = new HashMap<Integer, Integer>();
        
    toVisit.add(a);
    parents.put(a, null);
        
    while (!toVisit.isEmpty()) {
        Integer curr = toVisit.remove();
        if (curr == b) break;
        for (Integer n : curr.children) {
            if (!parents.containsKey(n)) {
                toVisit.add(n);
                parents.put(n, curr);
            }
        }
    }
    if (parents.get(b) == null) return null;
    Integer n = b;
    while (n != null) {
        System.out.print(n+"<-");
        n = parents.get(n);
    }
        
    return ;
}