// Tsampiras Konstantinos, AM 4508, cse84508

class ComplexNumber
{
	private double real = 0;
	private double img = 0;

	public ComplexNumber(double real, double img) 
	{
		this.real = real;
		this.img = img;
	}

	public ComplexNumber addComp(ComplexNumber num) 
	{
		this.real += num.real;
		this.img += num.img;
		return this;
	}

	public ComplexNumber subtractComp(ComplexNumber num) 
	{
		this.real -= num.real;
		this.img -= num.img;
		return this;
	}

	public ComplexNumber multiplyComp(ComplexNumber num) 
	{
		ComplexNumber temp = new ComplexNumber(this.real, this.img);
		temp.real = this.real * num.real - this.img * num.img;
		temp.img = this.real * num.img + this.img * num.real;
		this.real = temp.real;
		this.img = temp.img;
		return this;
	}

	public String toString() 
	{
		if (img >= 0) 
		{
			return String.format("%.2f", real) + " + " + String.format("%.2f", img) + "i" ;
		} 
		else 
		{
			return String.format("%.2f", real) + " - " + String.format("%.2f", -img) + "i";
		}
	}

	public boolean equals(ComplexNumber num) 
	{
		if (this.real == num.real && this.img == num.img) 
		{
			return true;
		}
		return false;
	}

	public double getReal() 
	{
		return real;
	}

	public double getImg() 
	{
		return img;
	}

	public void setReal(double real) 
	{
		this.real = real;
	}

	public void setImg(double img) 
	{
		this.img = img;
	}
}