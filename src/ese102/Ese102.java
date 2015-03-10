package ese102;

import complexnumber.*;
import manageinput.*;

import java.io.*;

public class Ese102
{
    public static void main(String[] args) throws IOException
    {
    	ComplexNumber.setInitializeRectangular(0, 0);
    	ComplexNumber.setInitializePolar(0, 0);
    	ComplexNumber coordinates1 = new ComplexNumber(), coordinates2 = new ComplexNumber();
    	boolean correctValue = false, exit = false;
    	byte inputFormat = 0, inputOperations = 0;
    	while(!exit)
    	{
    		ManageInput.inputFormatMenu();
    		inputFormat = 0;
        	correctValue = false;
        	while(!correctValue)
        	{
        		try
        		{
    	        	inputFormat = (byte)ManageInput.readInput("Choice: ", "You entered an illegal number.");
    	        	if(inputFormat < 1 || inputFormat > 2 && inputFormat != 9)
    	        		throw new IllegalArgumentException("You made a wrong choice.");
    	        	correctValue = true;
        		}
        		catch (IllegalArgumentException exception)
                {
                    System.out.println(exception.getMessage());
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
        	}
        	System.out.println();
        	correctValue = false;
        	switch(inputFormat)
        	{
        		case 1:
        			coordinates1.setRectangular(ManageInput.readInput("Enter Re: ", "You entered an illegal number."), ManageInput.readInput("Enter Im: ", "You entered an illegal number."));
    	            System.out.println("Argument: " + coordinates1.getArgument());
    	            System.out.println("Modulus: " + coordinates1.getModulus());
    	            break;
        		case 2:
        			ManageInput.readModulus(coordinates1);
        			System.out.println(coordinates1.formatComplexNumber());
    	        	break;
        		case 9:
        			System.out.println("Thanks for using this software." + "\n" + "See you soon.");
        			exit = true;
        			break;
        	}
        	System.out.println();
        	ManageInput.operationsMenu();
        	inputOperations = 0;
        	correctValue = false;
        	while(!correctValue)
        	{
        		try
        		{
    	        	inputOperations = (byte)ManageInput.readInput("Choice: ", "You entered an illegal number.");
    	        	if(inputOperations < 1 || inputOperations > 5 && inputOperations != 9)
    	        		throw new IllegalArgumentException("You made a wrong choice.");
    	        	correctValue = true;
        		}
        		catch (IllegalArgumentException exception)
                {
                    System.out.println(exception.getMessage());
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
        	}
        	System.out.println();
        	correctValue = false;
        	switch(inputOperations)
        	{
        		case 1:
        			if(inputFormat == 1)
        				coordinates2.setRectangular(ManageInput.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), ManageInput.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        				ManageInput.readModulus(coordinates2);
        			System.out.println("Sum: " + ComplexNumber.add(coordinates1, coordinates2).formatComplexNumber());
    	            break;
        		case 2:
        			if(inputFormat == 1)
        				coordinates2.setRectangular(ManageInput.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), ManageInput.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        				ManageInput.readModulus(coordinates2);
        			System.out.println("Subtraction: " + ComplexNumber.sub(coordinates1, coordinates2).formatComplexNumber());
    	        	break;
        		case 3:
        			if(inputFormat == 1)
        				coordinates2.setRectangular(ManageInput.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), ManageInput.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        				ManageInput.readModulus(coordinates2);
        			System.out.println("Multiplication: " + ComplexNumber.multiply(coordinates1, coordinates2).formatComplexNumber());
    	        	break;
        		case 4:
        			if(inputFormat == 1)
        				coordinates2.setRectangular(ManageInput.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), ManageInput.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        				ManageInput.readModulus(coordinates2);
        			System.out.println("Division: " + ComplexNumber.divide(coordinates1, coordinates2).formatComplexNumber());
    	        	break;
        		case 5:
        			System.out.println("Conjugate: " + ComplexNumber.getConjugate(coordinates1).formatComplexNumber());
        			break;
        		case 9:
        			System.out.println("Thanks for using this software." + "\n" + "See you soon.");
        			exit = true;
        			break;
        	}
	        System.out.println();
    	}
    }
}