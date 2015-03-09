package ese102;

import complexnumber.*;

import java.io.*;

public class Ese102
{
    public static void main(String[] args) throws IOException
    {
    	ComplexNumber.setInitializeRectangular(0, 0);
    	ComplexNumber.setInitializePolar(0, 0);
    	ComplexNumber coordinates1 = new ComplexNumber(), coordinates2 = new ComplexNumber();
    	boolean correctValue = false, exit = false;
    	byte choiceFormat = 0, choiceOperation = 0;
    	while(!exit)
    	{
    		Ese102.formatMenu();
    		choiceFormat = 0;
        	correctValue = false;
        	while(!correctValue)
        	{
        		try
        		{
    	        	choiceFormat = (byte)Ese102.readInput("Choice: ", "You entered an illegal number.");
    	        	if(choiceFormat < 1 || choiceFormat > 2 && choiceFormat != 9)
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
        	switch(choiceFormat)
        	{
        		case 1:
        			coordinates1.setRectangular(Ese102.readInput("Enter Re: ", "You entered an illegal number."), Ese102.readInput("Enter Im: ", "You entered an illegal number."));
    	            System.out.println("Argument: " + coordinates1.getArgument());
    	            System.out.println("Modulus: " + coordinates1.getModulus());
    	            break;
        		case 2:
    	        	while(!correctValue)
    	        	{
    	        		try
    		        	{
    		        		coordinates1.setPolar(Ese102.readInput("Enter the argument: ", "You entered an illegal number."), Ese102.readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number."));
    		        		correctValue = true;
    		        	}
    	        		catch (IllegalArgumentException exception)
    	                {
    	                    System.out.println(exception.getMessage());
    	                    java.awt.Toolkit.getDefaultToolkit().beep();
    	                }
    	        	}
    	        	System.out.println(coordinates1.formatComplexNumber());
    	        	break;
        		case 9:
        			System.out.println("Thanks for using this software." + "\n" + "See you soon.");
        			exit = true;
        			break;
        	}
        	System.out.println();
        	Ese102.operationsMenu();
        	choiceOperation = 0;
        	correctValue = false;
        	while(!correctValue)
        	{
        		try
        		{
    	        	choiceOperation = (byte)Ese102.readInput("Choice: ", "You entered an illegal number.");
    	        	if(choiceOperation < 1 || choiceOperation > 5 && choiceOperation != 9)
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
        	switch(choiceOperation)
        	{
        		case 1:
        			if(choiceFormat == 1)
        				coordinates2.setRectangular(Ese102.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), Ese102.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        			{
        				while(!correctValue)
        	        	{
        	        		try
        		        	{
        		        		coordinates2.setPolar(Ese102.readInput("Enter the argument: ", "You entered an illegal number."), Ese102.readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number."));
        		        		correctValue = true;
        		        	}
        	        		catch (IllegalArgumentException exception)
        	                {
        	                    System.out.println(exception.getMessage());
        	                    java.awt.Toolkit.getDefaultToolkit().beep();
        	                }
        	        	}
        			}
        			System.out.println("Sum: " + ComplexNumber.add(coordinates1, coordinates2).formatComplexNumber());
    	            break;
        		case 2:
        			if(choiceFormat == 1)
        				coordinates2.setRectangular(Ese102.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), Ese102.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        			{
        				while(!correctValue)
        	        	{
        	        		try
        		        	{
        		        		coordinates2.setPolar(Ese102.readInput("Enter the argument: ", "You entered an illegal number."), Ese102.readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number."));
        		        		correctValue = true;
        		        	}
        	        		catch (IllegalArgumentException exception)
        	                {
        	                    System.out.println(exception.getMessage());
        	                    java.awt.Toolkit.getDefaultToolkit().beep();
        	                }
        	        	}
        			}
        			System.out.println("Subtraction: " + ComplexNumber.sub(coordinates1, coordinates2).formatComplexNumber());
    	        	break;
        		case 3:
        			if(choiceFormat == 1)
        				coordinates2.setRectangular(Ese102.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), Ese102.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        			{
        				while(!correctValue)
        	        	{
        	        		try
        		        	{
        		        		coordinates2.setPolar(Ese102.readInput("Enter the argument: ", "You entered an illegal number."), Ese102.readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number."));
        		        		correctValue = true;
        		        	}
        	        		catch (IllegalArgumentException exception)
        	                {
        	                    System.out.println(exception.getMessage());
        	                    java.awt.Toolkit.getDefaultToolkit().beep();
        	                }
        	        	}
        			}
        			System.out.println("Multiplication: " + ComplexNumber.multiply(coordinates1, coordinates2).formatComplexNumber());
    	        	break;
        		case 4:
        			if(choiceFormat == 1)
        				coordinates2.setRectangular(Ese102.readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number."), Ese102.readInput("Enter IM: ", "You entered an illegal number."));
        			else
        			{
        				while(!correctValue)
        	        	{
        	        		try
        		        	{
        		        		coordinates2.setPolar(Ese102.readInput("Enter the argument: ", "You entered an illegal number."), Ese102.readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number."));
        		        		correctValue = true;
        		        	}
        	        		catch (IllegalArgumentException exception)
        	                {
        	                    System.out.println(exception.getMessage());
        	                    java.awt.Toolkit.getDefaultToolkit().beep();
        	                }
        	        	}
        			}
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
    
    private static double readInput(String output, String error) throws IOException
    {
    	InputStreamReader input = new InputStreamReader(System.in);
    	BufferedReader keyboard = new BufferedReader(input);
    	String readInput;
    	boolean correctValue = false;
    	double readNumber = 0;
        while(!correctValue)
        {
        	System.out.print(output);
            readInput = keyboard.readLine();
            try
            {
            	readNumber = Double.valueOf(readInput).doubleValue();
                correctValue = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(error);
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
        }
        return readNumber;
    }
    
    private static void formatMenu()
    {
    	System.out.println("Make your choice");
    	System.out.println("[1] From rectangular to polar");
    	System.out.println("[2] From polar to rectangular");
    	System.out.println("[9] Exit");
    }
    
    private static void operationsMenu()
    {
    	System.out.println("Make your choice");
    	System.out.println("[1] Adds two complex numbers");
    	System.out.println("[2] Subs two complex numbers");
    	System.out.println("[3] Multiplies two complex numbers");
    	System.out.println("[4] Divides two complex numbers");
    	System.out.println("[5] Conjugate of the complex numbers");
    	System.out.println("[9] Exit");
    }
}