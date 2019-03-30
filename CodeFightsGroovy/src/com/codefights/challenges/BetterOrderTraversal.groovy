package com.codefights.challenges
/*
There are several ways to traverse a binary tree. Let's talk about some of the most popular ways!

In-order traversal involves looking at the left subtree, then the current node, then the right subtree. This will visit the values of a binary search tree in ascending order.

Pre-order traversal involves looking at the current node, then the left subtree, then the right subtree. This type of traversal is often used for copying a tree.

Post-order traversal involves looking at the left subtree, then the right subtree, then the current node. This type of traversal is often used for deleting a tree.

Given a binary tree, your task is to test each of these traversals - store the values in an array (in the order in which they're visited), and return the one that's lexicographically smallest.
*/
//
// Definition for binary tree:
// class Tree<T> {
//   T value;
//   Tree<T> left;
//   Tree<T> right;
//
//   Tree(T x) {
//     this.value = x;
//     this.left = null;
//     this.right = null;
//   }
// }
/*T betterOrderTraversal(r) {
	T a,b,c
	a = {n-> n ? a(n.left) + n.value + a(n.right) : []}
	b = {n-> n ? [n.value] + b(n.left) + b(n.right) : []}
	c = {n-> n ? c(n.left) + c(n.right) + n.value : []}
	
	[a(r), b(r), c(r)].min{"$it"}
}*/
/*T betterOrderTraversal(r) {
	T a,c
	a = {n-> n ? a(n.left) + n.value + a(n.right) : []}
	c = {n-> n ? c(n.left) + c(n.right) + n.value : []}
	[a(r), (toJson(r) =~ /-?\d+/)*.toLong(), c(r)].min{"$it"}
}
*/
def betterOrderTraversal(r) {
	def f
	f = {n,i->
		def v = n?.value
		n ? (i==0 ? [v] : []) + f(n.left,i) + (i==1 ? v : []) + f(n.right,i) + (i==2 ? v : []) : []
	}
	[f(r,0), f(r,1), f(r,2)].min{"$it"}
}
