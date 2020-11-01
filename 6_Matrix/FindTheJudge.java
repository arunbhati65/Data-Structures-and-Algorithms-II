/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
*/
class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length==0 && N==1){
            return 1;
        }    
        List<List<Integer>> graph=new LinkedList<>();
        List<Integer> possibleJudges=new LinkedList<>();
        Integer count[] =new Integer[N+1];
        for(int i=0;i<N;++i){
            graph.add(new LinkedList<Integer>());
        }
        
        for(int i=0;i<trust.length;++i){
            count[trust[i][1]]=count[trust[i][1]]==null?1:count[trust[i][1]]+1;
            if(count[trust[i][1]]==N-1){possibleJudges.add(trust[i][1]);}
            graph.get(trust[i][0]-1).add(trust[i][1]);
        }
        for(int i=0;i<possibleJudges.size();++i){
            if(graph.get(possibleJudges.get(i)-1).size()==0) return possibleJudges.get(i); 
        }
        return -1;
    }
}