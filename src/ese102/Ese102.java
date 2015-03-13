package ese102;

import complexnumber.*;
import complexnumber.ComplexNumber.StringFormat;

public class Ese102
{
	public static void main(String[] args)
	{
		ComplexNumber.setInitRectangular(1,1);
		ComplexNumber c1 = new ComplexNumber();
		ComplexNumber.setInitRectangular(-1, 2);
		ComplexNumber c2 = new ComplexNumber();
		System.out.println("c1: " + c1);
		System.out.println("c1 (polar): " + c1.toString(StringFormat.POLAR));
		System.out.println("c2: " + c2);
		System.out.println("c2 (polar): " + c2.toString(StringFormat.POLAR));
		System.out.println("Addiction: " + c1.add(c2).toString(StringFormat.RECTANGULAR));
		System.out.println("Addiction: (polar): " + (c1.add(c2)).toString(StringFormat.POLAR));
		System.out.println("Addiction: (class method): " + ComplexNumber.add(c1, c2).toString(StringFormat.RECTANGULAR));
		System.out.println("Addiction: (class method) (polar): " + ComplexNumber.add(c1, c2).toString(StringFormat.POLAR));
		System.out.println("Addiction: (polar): " + (c1.add(c2)).toString(StringFormat.POLAR));
		System.out.println("Subtraction: " + c1.sub(c2));
		/* Domanda: come posso controllare il formato della
		 * rappresentazione a stringa del risultato dell'operazione, senza dover assegnare
		 * il risultato ad una variabile?
		 */
		System.out.println("Subtraction: (polar): " + (c1.sub(c2)).toString(StringFormat.POLAR));
		System.out.println("Subtraction: (class method): " + ComplexNumber.sub(c1, c2).toString(StringFormat.RECTANGULAR));
		System.out.println("Subtraction: (class method) (polar): " + ComplexNumber.sub(c1, c2).toString(StringFormat.POLAR));
		System.out.println("Multiplication: " + (c1.multiply(c2)).toString(StringFormat.RECTANGULAR));
		System.out.println("Multiplication (polar): " + (c1.multiply(c2)).toString(StringFormat.POLAR));
		System.out.println("Multiplication: (class method): " + ComplexNumber.multiply(c1, c2).toString(StringFormat.RECTANGULAR));
		System.out.println("Multiplication: (class method) (polar): " + ComplexNumber.multiply(c1, c2).toString(StringFormat.POLAR));
		System.out.println("Division: " + (c1.divide(c2)).toString(StringFormat.RECTANGULAR));
		System.out.println("Division (polar): " + (c1.divide(c2)).toString(StringFormat.POLAR));
		System.out.println("Division: (class method): " + ComplexNumber.divide(c1, c2).toString(StringFormat.RECTANGULAR));
		System.out.println("Division: (class method) (polar): " + ComplexNumber.divide(c1, c2).toString(StringFormat.POLAR));
		System.out.println("Complex Conjugate 1: " + (c1.getConjugate()).toString(StringFormat.RECTANGULAR));
		System.out.println("Complex Conjugate 1 (polar): " + (c1.getConjugate()).toString(StringFormat.POLAR));
		System.out.println("Complex Conjugate 1 (class method): " + ComplexNumber.getConjugate(c1).toString(StringFormat.RECTANGULAR));
		System.out.println("Complex Conjugate 1 (class method) (polar): " + ComplexNumber.getConjugate(c1).toString(StringFormat.POLAR));
		System.out.println("Complex Conjugate 2: " + (c2.getConjugate()).toString(StringFormat.RECTANGULAR));
		System.out.println("Complex Conjugate 2 (polar): " + (c2.getConjugate()).toString(StringFormat.POLAR));
		System.out.println("Complex Conjugate 2 (class method): " + ComplexNumber.getConjugate(c2).toString(StringFormat.RECTANGULAR));
		System.out.println("Complex Conjugate 2 (class method) (polar): " + ComplexNumber.getConjugate(c2).toString(StringFormat.POLAR));
		//----- Uguaglianza tra oggetti
		ComplexNumber numeri[] = new ComplexNumber[4];
		ComplexNumber.setInitRectangular(1, -2);
		numeri[0] = new ComplexNumber();
		numeri[1] = new ComplexNumber();
		numeri[2] = numeri[1];
		numeri[3] = new ComplexNumber();
		numeri[3].setRectangular(-3, 2);
		int i=0;
		for(i=1; i<numeri.length; i++)
		{
			if(numeri[i-1] == numeri[i])
				System.out.println("numeri[" + (i-1) + "] e numeri[" + i + "] si riferiscono alla medesima istanza");
			else
				System.out.println("numeri[" + (i-1) + "] e numeri[" + i + "] si riferiscono a due istanze differenti");		
			if(numeri[i-1].equals(numeri[i]))
				System.out.println("numeri[" + (i-1) + "] e numeri[" + i + "] contengono il medesimo numero complesso");
			else
				System.out.println("numeri[" + (i-1) + "] e numeri[" + i + "] contengono numeri complessi diversi");
		}
	}
}