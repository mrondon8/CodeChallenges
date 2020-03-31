package com.codefights.amazons;

public class Board {
	private int size;
	private Piece[][] board;
	
	public Board(int size){
		this.size = size;
		board = new Piece[size][size];
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Piece[][] getBoard() {
		return board;
	}
	
}
