// Tsampiras Konstantinos, AM 4508, cse84508

class ComplexNumber
{
	//// Fields

	private double real = 0;
	private double img = 0;

	//// Constructor Method

	// Constructor Method with 2 parameters
	public ComplexNumber(double real, double img) {
		this.real = real;
		this.img = img;
	}

	//// Methods

	// addComp Method
	/* Calculates the sum of the real and 
	 * the imaginary part of the 2 Complex 
	 * Numbers and sets these values to 
	 * the object that called the method 
	 */

	public ComplexNumber addComp(ComplexNumber num) {
		this.real += num.real;
		this.img += num.img;
		return this;
	}

	// subtractComp Method
	/* Calculates the difference of the real 
	 * and the imaginary part of the 2 Complex 
	 * Numbers (objects) and sets these values 
	 * to the object that called the method
	 */

	public ComplexNumber subtractComp(ComplexNumber num) {
		this.real -= num.real;
		this.img -= num.img;
		return this;
	}

	// multiplyComp Method
	/* Creates a temporary object, calculates the product
	 * of 2 Complex Numbers (objects) based on the algorithm 
	 * (a+bi)*(c+di)=(ac-bd)+(ad+bc)i with Real=(ac-bd) and 
	 * Imaginary=(ad+bc) and sets these values to the object
	 * that called the method 
	 */

	public ComplexNumber multiplyComp(ComplexNumber num) {
		ComplexNumber temp = new ComplexNumber(this.real, this.img);
		temp.real = this.real * num.real - this.img * num.img;
		temp.img = this.real * num.img + this.img * num.real;
		this.real = temp.real;
		this.img = temp.img;
		return this;
	}

	// toString Method
	/* Returns a String representation 
	 * of the object that called the method 
	 * with the format "Real Symbol Image i"
	 * and truncates numbers to 2 decimal places 
	 */

	public String toString() {
		if (img >= 0) {
			return String.format("%.2f", real) + " + " + String.format("%.2f", img) + "i" ;
		} else {
			return String.format("%.2f", real) + " - " + String.format("%.2f", -img) + "i";
		}
	}

	// equals Method
	/* Checks if the 2 Complex Numbers (objects)
	 * are equal by checking the equality 
	 * of the real part and the imaginary 
	 * part of those 
	 */

	public boolean equals(ComplexNumber num) {
		if (this.real == num.real && this.img == num.img) {
			return true;
		}
		return false;
	}

	// Accessors
	/* Returns the values of the
	 * Fields Real and Imaginary 
	 */

	public double getReal() {
		return real;
	}

	public double getImg() {
		return img;
	}

	// Mutators
	/* Sets the values of the
	 * Fields Real and Imaginary 
	 */

	public void setReal(double real) {
		this.real = real;
	}

	public void setImg(double img) {
		this.img = img;
	}
}