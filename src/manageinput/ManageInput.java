package manageinput;

import complexnumber.*;

import java.io.*;


public class ManageInput
{
	/**
	 * 
	 * @param output
	 * @param error
	 * @return Returns the read number.
	 * @throws IOException
	 */
	public static double readInput(String output, String error) throws IOException
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
    
    public static void readModulus(ComplexNumber coordinates) throws IOException
    {
    	boolean correctValue = false;
    	while(!correctValue)
    	{
    		try
        	{
        		coordinates.setPolar(ManageInput.readInput("Enter the argument: ", "You entered an illegal number."), ManageInput.readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number."));
        		correctValue = true;
        	}
    		catch (IllegalArgumentException exception)
            {
                System.out.println(exception.getMessage());
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
    	}
    }
    
    public static void inputFormatMenu()
    {
    	System.out.println("Make your choice");
    	System.out.println("[1] From rectangular to polar");
    	System.out.println("[2] From polar to rectangular");
    	System.out.println("[9] Exit");
    }
    
    public static void operationsMenu()
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
