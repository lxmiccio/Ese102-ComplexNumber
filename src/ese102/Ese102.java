package ese102;

import complexnumber.*;

import java.io.*;

public class Ese102
{
    public static void main(String[] args) throws IOException
    {
    	menu();
    	ComplexNumber coordinates1 = new ComplexNumber(), coordinates2 = new ComplexNumber();
    	boolean correctValue = false, exit = false;
    	double readNumber = 0;
    	byte choice = 0;
    	while(!exit)
    	{
    		choice = 0;
    		try
    		{
	        	choice = (byte)readInput("Choice: ", "You entered an illegal number");
	        	if(choice < 1 || choice > 9 || choice == 8)
	        		throw new IllegalArgumentException("The value of choice is incorrect.");
    		}
    		catch (IllegalArgumentException exception)
            {
                System.out.println(exception.getMessage());
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
	        if(choice == 1)
	        {
	        	coordinates1.setRectangular(readInput("Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	System.out.println("\n" + "Modulus: " + coordinates1.getModulus());
	            System.out.println("Argument: " + coordinates1.getArgument());       
	        }
	        else if(choice == 2)
	        {
	        	readNumber = readInput("Enter the argument: ", "You entered an illegal number");
	        	while(!correctValue)
	        	{
	        		try
		        	{
		        		coordinates1.setPolar(readNumber, readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number"));
		        		correctValue = true;
		        	}
	        		catch (IllegalArgumentException exception)
	                {
	                    System.out.println(exception.getMessage());
	                    java.awt.Toolkit.getDefaultToolkit().beep();
	                }
	        	}
	        	correctValue = false;
	        	System.out.println("\n" + coordinates1.formatComplexNumber());
	        }
	        else if(choice == 3)
	        {
	        	coordinates1.setRectangular(readInput("First complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	coordinates2.setRectangular(readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	System.out.println(coordinates1.add(coordinates2).formatComplexNumber());
	        }
	        else if(choice == 4)
	        {
	        	coordinates1.setRectangular(readInput("First complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	coordinates2.setRectangular(readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	System.out.println(coordinates1.sub(coordinates2).formatComplexNumber());
	        }
	        else if(choice == 5)
	        {
	        	coordinates1.setRectangular(readInput("First complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	coordinates2.setRectangular(readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	System.out.println(coordinates1.multiply(coordinates2).formatComplexNumber());
	        }
	        else if(choice == 6)
	        {
	        	coordinates1.setRectangular(readInput("First complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	coordinates2.setRectangular(readInput("Second complex number: " + "\n" + "Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	System.out.println(coordinates1.divide(coordinates2).formatComplexNumber());
	        }
	        else if(choice == 7)
	        {
	        	coordinates1.setRectangular(readInput("Enter RE: ", "You entered an illegal number"), readInput("Enter IM: ", "You entered an illegal number"));
	        	System.out.println(coordinates1.getConjugate().formatComplexNumber());
	        }
	        else if(choice == 9)
	        {
	        	System.out.println("Thanks for using this software." + "\n" + "See you soon.");
	        	exit = true;
	        }
	        else
	        	System.out.println("You made a wrong choice");
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
    
    private static void menu()
    {
    	System.out.println("Make your choice");
    	System.out.println("[1] From rectangular to polar");
    	System.out.println("[2] From polar to rectangular");
    	System.out.println("[3] Adds two complex numbers");
    	System.out.println("[4] Subs two complex numbers");
    	System.out.println("[5] Multiplies two complex numbers");
    	System.out.println("[6] Divides two complex numbers");
    	System.out.println("[7] Conjugate of the complex numbers");
    	System.out.println("[9] Exit");
    }
}