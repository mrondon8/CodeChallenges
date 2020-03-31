package com.codefights.chess;

public class PawnMarch {

	public static void main(String[] args) {
		char[][] input = new char[][]{
				new char[]{'b', 'b'},
				new char[]{' ', ' '},
				new char[]{'w', 'w'}
		};
		Board board = new Board(input, input.length, input[0].length);
		System.out.println("Initial board:\n" + board);
		
		
	}

}

class Board {

	// instance variables

	final static char WHITE = 'w';
	final static char BLACK = 'b';
	final static char SPACE = ' ';
	
	char[][] board;
	int height;
	int width;

	// constructor
	Board(char[][] board, int height, int width) {
		this.height = height;
		this.width = width;
		this.board = new char[this.height][this.width];
		for (int i = 0; i < this.height; i++)
			for (int j = 0; j < this.width; j++)
				this.board[i][j] = board[i][j];
		
	}

	@Override
	public boolean equals(Object obj) {
		Board other = (Board) obj;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				if (this.board[i][j] != other.board[i][j])
					return false;
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				hash += board[i][j] * height;
		return hash;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		char row = 'a';
		for (int i = 0; i < height; i++, str.append("\n")){
			str.append("" + row++ +": ");
			for (int j = 0; j < width; j++) {
				str.append(this.board[i][j]);
			}
		}
		str.append("   ");
		for(int i = 0; i < width; i++)
			str.append(i);
		return str.toString();
	}
}