package com.nano.avl;

public class Node {
	int key;
	int balance;
	int height;
	Node left;
	Node right;
	Node parent;

	Node(int key, Node parent) {
		this.key = key;
		this.parent = parent;
	}
}
