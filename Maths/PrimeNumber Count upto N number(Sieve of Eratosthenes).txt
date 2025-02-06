//The Sieve of Eratosthenes is one of the most efficient ways to find all prime numbers up to n.
class Solution {
    public int countPrimes(int n) {
        int count=0;
        boolean[] isPrime=new boolean[n];
        for(int i=2;i<n;++i){
            isPrime[i]=true;
        }
        for(int i=2;i*i<n;++i){
            if(!isPrime[i]) continue;
            markMultiplesAsNotPrime(i,n,isPrime);
        }
        for(int i=2;i<n;++i){
            if(isPrime[i]) count++;
        }
        return count;
    }
    
    void markMultiplesAsNotPrime(int i,int n,boolean [] isPrime){
        for(int j=i*i;j<n;j=j+i){
            isPrime[j]=false;
        }
    }
}