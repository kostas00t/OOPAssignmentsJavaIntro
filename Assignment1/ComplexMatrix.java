// Tsampiras Konstantinos, AM 4508, cse84508

import java.util.Random;

class ComplexMatrix
{
	//// Fields

	private ComplexNumber[][] compNum2DArray;
	private Random rand = new Random();
	
	//// Private Method
	private double computeRandom() {
		int randomNum = (int)((rand.nextDouble()-0.5)*rand.nextInt(20)*100);
		return randomNum/100.0;
	}

	//// Constructor Methods

	// Default Constructor
	public ComplexMatrix() {}

	// Matrix Copier (Deep Copy Implementation)
	public ComplexMatrix(ComplexMatrix original) {
		this.compNum2DArray = new ComplexNumber[original.compNum2DArray.length][original.compNum2DArray[0].length];
		for (int r = 0; r < original.compNum2DArray.length; r++) {
			for (int c = 0; c < original.compNum2DArray[r].length; c++) {
				double real = original.compNum2DArray[r][c].getReal();
				double img = original.compNum2DArray[r][c].getImg();
				ComplexNumber num = new ComplexNumber(real, img);
				this.compNum2DArray[r][c] = num;
			}
		}
	}

	// Matrix Creator 
	public ComplexMatrix(int rows, int cols) {
		compNum2DArray = new ComplexNumber[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				ComplexNumber num = new ComplexNumber(computeRandom(), computeRandom());
				compNum2DArray[r][c] = num;
			}
		}
	}

	//// Methods

	// toString Method
	/* Returns a String representation of 
	 * the object that called the method with
	 * the format :			[CN11, CN12, CN13;
	 * (e.g. for a 3x3 		CN21, CN22, CN23;
	 * ComplexNumberRowCol)	CN31, CN32, CN33;]	
	 */

	public String toString() {
		String x = "[";
		for (int r = 0; r < compNum2DArray.length; r++) {
			for (int c = 0; c < compNum2DArray[r].length; c++) {
				x += compNum2DArray[r][c] + ", " ;
			}
			if (r == compNum2DArray.length-1) {
				x += "\b\b;]";
			} else { 
				x += "\b\b;\n";
			}
		}
		return x;
	}

	// CompAdd Method 
	/* Checks if the 2 matrices have the same number of rows and columns
	 * if they don't, returns nothing (null), if they do, it iterates
	 * the values of each row and column and calculates the sum of the 2 
	 * Complex Numbers (objects) with the instructions described in the 
	 * ComplexNumber.java file, and puts these values to a temporary matrix
	 */

	public ComplexMatrix CompAdd(ComplexMatrix matrix) {
		if (this.compNum2DArray.length != matrix.compNum2DArray.length || 
			this.compNum2DArray[0].length != matrix.compNum2DArray[0].length) {
			return null;
		} else {
			ComplexMatrix temp = new ComplexMatrix(this);
			for (int r = 0; r < compNum2DArray.length; r++) {
				for (int c = 0; c < compNum2DArray[r].length; c++) {
					temp.compNum2DArray[r][c] = temp.compNum2DArray[r][c].addComp(matrix.compNum2DArray[r][c]);
				}
			}
			return temp;
		}
	}

	// CompSubtract Method
	/* Checks if the 2 matrices have the same number of rows and columns
	 * if they don't, returns nothing (null), if they do, it iterates
	 * the values of each row and column and calculates the difference of 
	 * the 2 Complex Numbers (objects) with the instructions described in 
	 * the ComplexNumber.java, and puts these values to a temporary matrix
	 */

	public ComplexMatrix CompSubtract(ComplexMatrix matrix) {
		if (this.compNum2DArray.length != matrix.compNum2DArray.length ||
			this.compNum2DArray[0].length != matrix.compNum2DArray[0].length) {
			return null;
		} else {
			ComplexMatrix temp = new ComplexMatrix(this);
			for (int r = 0; r < compNum2DArray.length; r++) {
				for (int c = 0; c < compNum2DArray[r].length; c++) {
					temp.compNum2DArray[r][c] = temp.compNum2DArray[r][c].subtractComp(matrix.compNum2DArray[r][c]);
				}
			}
			return temp;
		}
	}
}