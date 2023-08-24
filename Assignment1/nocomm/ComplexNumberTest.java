public class ComplexNumberTest 
{
	public static void main(String [] args) 
	{
		ComplexNumber num1 = new ComplexNumber(2.33, 4.567);
		ComplexNumber num2 = new ComplexNumber(3.289, -1.23);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println("\n##\n");
		System.out.println(num1.addComp(num2));
		System.out.println("\n##\n");
		System.out.println(num2.addComp(num1));
		System.out.println("\n##\n");
		System.out.println(num1.subtractComp(num2));
		System.out.println("\n##\n");
		System.out.println(num2.subtractComp(num1));
		System.out.println("\n##\n");
		System.out.println(num1.multiplyComp(num2));
		System.out.println("\n##\n");
		System.out.println(num2.multiplyComp(num1));
		System.out.println("\n##\n");
		System.out.println("Are numbers equal? " + num1.equals(num2));
		System.out.println("\n##\n");
		for(int i=1; i<5; i++) 
		{
			ComplexMatrix m1 = new ComplexMatrix(i+1, i);
			ComplexMatrix m2 = new ComplexMatrix(i+1, i);
			ComplexMatrix m3 = new ComplexMatrix(i, i+1);
			ComplexMatrix m4 = new ComplexMatrix(m3);
			System.out.println(m1.CompAdd(m2));
			System.out.println("\n##\n");
			System.out.println(m1);
			System.out.println("\n##\n");
			System.out.println(m2.CompSubtract(m1));
			System.out.println("\n##\n");
			System.out.println(m2);
			System.out.println("\n##\n");
			System.out.println(m1.CompAdd(m3));
			System.out.println("\n##\n");
			System.out.println(m2);
			System.out.println("\n##\n");
			System.out.println(m2.CompSubtract(m3));
			System.out.println("\n##\n");
			System.out.println(m2);
			System.out.println("\n##\n");
			System.out.println(m4.CompAdd(m3));
			System.out.println("\n##\n");
			System.out.println(m4);
			System.out.println("\n##\n");
			System.out.println(m4.CompSubtract(m3));
			System.out.println("\n##\n");
			System.out.println(m4);
			System.out.println("\n##\n");
		}
	}
}
