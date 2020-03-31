import groovy.transform.Memoized


/*
 * Given integers n and k, find the number of the ways to choose k objects out of n different ones modulo 109 + 7. Note that the order doesn't matter.
 */





def countWays(n, k, int m = 1e9+7){
    n >= k ? n==1 || k==0 ? 1 : (countWays(n-1, k-1)%m + countWays(n-1, k)%m) %m : 0
}


println(countWays(1000, 50))