package com.codefights.challenges
/*
While visiting the exquisite sacred forest Atsuta Jingu, you stumble upon a large stone under which you find a manuscript with some matrices. Since the matrices seem to resemble a Soroban (Japanese abacus), you suspect that these matrices may represent decimal numbers!

Given matrix as an 8-element array of arrays of strings, your task is to write a program which returns a decimal number as a result.

Example

For

matrix = [["o", "o", "o", "|", "|", "o"],
          ["|", "|", "|", "o", "o", "|"],
          ["-", "-", ".", "-", "-", "-"],
          ["|", "|", "o", "o", "o", "o"],
          ["o", "o", "|", "o", "|", "o"],
          ["o", "o", "o", "o", "o", "o"],
          ["o", "o", "o", "o", "o", "|"],
          ["o", "o", "o", "|", "o", "o"]]
the output should be matrixToDecimal = 1.963.

For

matrix = [["o", "o", "o", "|", "|"], 
          ["|", "|", "|", "o", "o"], 
          ["-", "-", ".", "-", "-"], 
          ["o", "|", "|", "o", "|"], 
          ["o", "o", "o", "|", "o"], 
          ["o", "o", "o", "o", "o"], 
          ["|", "o", "o", "o", "o"], 
          ["o", "o", "o", "o", "o"]]
the output should be matrixToDecimal = 300.65.
*/
def matrixToDecimal(m){
	m.transpose() sum{
		(it[0] - "o" ? 5 : 0) + it[3..-1].indexOf("|") + it[2] - "-"
	}
}