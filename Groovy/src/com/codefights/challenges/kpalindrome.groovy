//A string is a k-palindrome if it can be transformed into a palindrome by removing any amount of characters from 0 to k. Your task is to determine whether the given string s is a k-palindrome.

def kpalindrome(s,  k)  
{ 
    def r = s.reverse()
    def m = s.size() + 1
    def dp = new int[m][m]; 

    for (int i = 0; i < m; i++)  
    { 
        for (int j = 0; j < m; j++)  
        { 
                dp[i][j] = i ? j ? s[i - 1] == r[j - 1] ? dp[i-1][j-1] : 1 + Math.min(dp[i - 1][j],  
                        dp[i][j - 1])  : i : j
        } 
    } 
    
    dp[m-1][m-1] <= k*2; 
} 



assert kpalindrome("abrarbra", 1) == true
assert kpalindrome("adbcdbacdb", 2) == false
assert kpalindrome("nwnk", 1) == true
assert kpalindrome("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco", 5) == false
