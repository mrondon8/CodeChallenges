package com.nano.avl;

import java.util.HashMap;
import java.util.Map;

public class AVLTree {

	Node root;
	long total;
	int size;
	Map<Integer, Integer> counts = new HashMap<>();

	public int getSize() {
		// System.out.println("root: " + root + " size is: " + size);
		return size;
	}

	public int closest(int value) {
		if (root == null)
			return 0;
		if (counts.containsKey(value))
			return 0;
		int a = closest(root, value, Integer.MAX_VALUE);
		return a;
	}

	public int closest(Node node, int value, int diff) {
		int currentDiff = Math.abs(value - node.key);
		diff = diff > currentDiff ? currentDiff : diff;
		return value < node.key && node.left != null ? closest(node.left, value, diff)
				: value > node.key && node.right != null ? closest(node.right, value, diff) : diff;
	}

	public int average() {
		// System.out.println("root: " + root + " average: " + total / (size +
		// 1e-9));
		if (root == null)
			return 0;

		return (int) (total / size);
	}

	public int min() {
		if (root == null)
			return 0;
		return min(root);
	}

	public int min(Node node) {
		return node.left == null ? node.key : min(node.left);
	}

	public int max() {
		if (root == null)
			return 0;
		return max(root);
	}

	public int max(Node node) {
		return node.right == null ? node.key : max(node.right);
	}

	public boolean insert(int key) {

		if (counts.containsKey(key)) {
			// System.out.println("root: " + root + " increasing key count: " +
			// key);
			int e = counts.get(key);
			counts.put(key, e + 1);
			total += key;
			size++;
			return true;
		}
		counts.put(key, 1);
		// System.out.println("root: " + root + " inserting: " + key);
		if (root == null) {
			root = new Node(key, null);
			total += key;
			size++;
			return true;
		}

		Node n = root;
		while (true) {
			Node parent = n;

			boolean goLeft = n.key > key;
			n = goLeft ? n.left : n.right;

			if (n == null) {
				if (goLeft) {
					parent.left = new Node(key, parent);
				} else {
					parent.right = new Node(key, parent);
				}
				rebalance(parent);
				break;
			}
		}
		total += key;
		size++;
		return true;
	}

	public void delete(Node node) {
		if (node.left == null && node.right == null) {
			if (node.parent == null) {
				root = null;
			} else {
				Node parent = node.parent;
				if (parent.left == node) {
					parent.left = null;
				} else {
					parent.right = null;
				}
				rebalance(parent);
			}
			return;
		}

		if (node.left != null) {
			Node child = node.left;
			while (child.right != null)
				child = child.right;
			node.key = child.key;
			delete(child);
		} else {
			Node child = node.right;
			while (child.left != null)
				child = child.left;
			node.key = child.key;
			delete(child);
		}
	}

	public void delete(int delKey) {
		if (counts.containsKey(delKey)) {
			total -= delKey;
			size--;

			if (counts.get(delKey) > 1) {
				// System.out.println("root: " + root + " deleting count: " +
				// delKey);
				int e = counts.get(delKey);
				counts.put(delKey, e - 1);

				return;
			} else {
				counts.remove(delKey);
				// System.out.println("root: " + root + " deleting: " + delKey);
				if (root == null)
					return;

				Node child = root;
				while (child != null) {
					Node node = child;
					child = delKey >= node.key ? node.right : node.left;
					if (delKey == node.key) {
						delete(node);
						return;
					}
				}
			}
		}
	}

	public void rebalance(Node n) {
		setBalance(n);

		if (n.balance == -2) {
			if (height(n.left.left) >= height(n.left.right))
				n = rotateRight(n);
			else
				n = rotateLeftThenRight(n);

		} else if (n.balance == 2) {
			if (height(n.right.right) >= height(n.right.left))
				n = rotateLeft(n);
			else
				n = rotateRightThenLeft(n);
		}

		if (n.parent != null) {
			rebalance(n.parent);
		} else {
			root = n;
		}
	}

	public Node rotateLeft(Node a) {

		Node b = a.right;
		b.parent = a.parent;

		a.right = b.left;

		if (a.right != null)
			a.right.parent = a;

		b.left = a;
		a.parent = b;

		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} else {
				b.parent.left = b;
			}
		}

		setBalance(a, b);

		return b;
	}

	public Node rotateRight(Node a) {

		Node b = a.left;
		b.parent = a.parent;

		a.left = b.right;

		if (a.left != null)
			a.left.parent = a;

		b.right = a;
		a.parent = b;

		if (b.parent != null) {
			if (b.parent.right == a) {
				b.parent.right = b;
			} else {
				b.parent.left = b;
			}
		}

		setBalance(a, b);

		return b;
	}

	public Node rotateLeftThenRight(Node n) {
		n.left = rotateLeft(n.left);
		return rotateRight(n);
	}

	public Node rotateRightThenLeft(Node n) {
		n.right = rotateRight(n.right);
		return rotateLeft(n);
	}

	public int height(Node n) {
		if (n == null)
			return -1;
		return n.height;
	}

	public void setBalance(Node... nodes) {
		for (Node n : nodes) {
			reheight(n);
			n.balance = height(n.right) - height(n.left);
		}
	}

	public void printBalance() {
		printBalance(root);
	}

	public void printBalance(Node n) {
		if (n != null) {
			printBalance(n.left);
			System.out.printf("%s ", n.balance);
			printBalance(n.right);
		}
	}

	public void reheight(Node node) {
		if (node != null) {
			node.height = 1 + Math.max(height(node.left), height(node.right));
		}
	}

}
