public class kAscendingPermutation{
	static m = [:]
	static def f(n, k) {
		if(m[n*999+k]) return m[n*999+k]
		n == 0 || k == 0 ? n >= k ? 1g : 0g : (m[n*999+k] = (n-k) * f(n-1, k-1) + (k+1) * f(n-1, k))
	}

	public static void main(def args){
		println(f(1000, 99) % (10**9+7))
	}
}