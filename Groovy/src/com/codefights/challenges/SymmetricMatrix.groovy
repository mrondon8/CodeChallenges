package com.codefights.challenges
/*
Given a square matrix of integers, your task is to determine whether or not it's symmetric along its main diagonal.

Example

For n = 3 and

inputMatrix = [[0,1,2], 
               [1,5,3], 
               [2,3,4]]
the output should be symmetricalMatrix(n, inputMatrix) = true.

example 1

This matrix is symmetric along the main diagonal!

For n = 3 and

inputMatrix = [[0,0,0], 
               [0,0,0], 
               [1,0,0]]
the output should be symmetricalMatrix(n, inputMatrix) = false.

example 2

This matrix is not symmetric (the 0 and 1 don't match up).
 */
def symmetricalMatrix(n, m){
	m == m.transpose()
  }
  