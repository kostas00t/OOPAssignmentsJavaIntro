// Tsampiras Konstantinos, AM 4508, cse84508

import java.util.Random;

class ComplexMatrix
{

	private ComplexNumber[][] compNum2DArray;
	private Random rand = new Random();
	private double computeRandom() 
	{
		int randomNum = (int)((rand.nextDouble()-0.5)*rand.nextInt(20)*100);
		return randomNum/100.0;
	}

	public ComplexMatrix() 
	{
		
	}

	public ComplexMatrix(ComplexMatrix original) 
	{
		this.compNum2DArray = new ComplexNumber[original.compNum2DArray.length][original.compNum2DArray[0].length];
		for (int r = 0; r < original.compNum2DArray.length; r++) 
		{
			for (int c = 0; c < original.compNum2DArray[r].length; c++) 
			{
				double real = original.compNum2DArray[r][c].getReal();
				double img = original.compNum2DArray[r][c].getImg();
				ComplexNumber num = new ComplexNumber(real, img);
				this.compNum2DArray[r][c] = num;
			}
		}
	}

	public ComplexMatrix(int rows, int cols) 
	{
		compNum2DArray = new ComplexNumber[rows][cols];
		for (int r = 0; r < rows; r++) 
		{
			for (int c = 0; c < cols; c++) 
			{
				ComplexNumber num = new ComplexNumber(computeRandom(), computeRandom());
				compNum2DArray[r][c] = num;
			}
		}
	}

	public String toString() 
	{
		String x = "[";
		for (int r = 0; r < compNum2DArray.length; r++) 
		{
			for (int c = 0; c < compNum2DArray[r].length; c++) 
			{
				x += compNum2DArray[r][c] + ", " ;
			}
			if (r == compNum2DArray.length-1) 
			{
				x += "\b\b;]";
			} 
			else 
			{ 
				x += "\b\b;\n";
			}
		}
		return x;
	}

	public ComplexMatrix CompAdd(ComplexMatrix matrix) 
	{
		if (this.compNum2DArray.length != matrix.compNum2DArray.length || this.compNum2DArray[0].length != matrix.compNum2DArray[0].length) 
		{
			return null;
		} 
		else 
		{
			for (int r = 0; r < compNum2DArray.length; r++) 
			{
				for (int c = 0; c < compNum2DArray[r].length; c++) 
				{
					this.compNum2DArray[r][c] = this.compNum2DArray[r][c].addComp(matrix.compNum2DArray[r][c]);
				}
			}
			return this;
		}
	}

	public ComplexMatrix CompSubtract(ComplexMatrix matrix) 
	{
		if (this.compNum2DArray.length != matrix.compNum2DArray.length || this.compNum2DArray[0].length != matrix.compNum2DArray[0].length) 
		{
			return null;
		} 
		else 
		{
			for (int r = 0; r < compNum2DArray.length; r++) 
			{
				for (int c = 0; c < compNum2DArray[r].length; c++) 
				{
					this.compNum2DArray[r][c] = this.compNum2DArray[r][c].subtractComp(matrix.compNum2DArray[r][c]);
				}
			}
			return this;
		}
	}
}