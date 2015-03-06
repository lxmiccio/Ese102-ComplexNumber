package ese102;

import complexnumber.*;

import java.io.*;

public class Ese102
{
    public static void main(String[] args) throws IOException
    {
    	ComplexNumber coordinates = new ComplexNumber();
    	short choice = 0;
        while(choice != 1 && choice != 2)
        {
        	choice = (short)readInput("Rectangular/Polar [1/2]", "You entered an illegal number");
        }
        if(choice == 1)
        {
        	coordinates.setRectangular(readInput("Enter the rectangular coordinate X: ", "You entered an illegal number"), readInput("Enter the rectangular coordinate Y: ", "You entered an illegal number"));
        	System.out.println("\n" + "Modulus: " + coordinates.getModulus());
            System.out.println("Argument: " + coordinates.getArgument());       
        }
        else if(choice == 2)
        {
        	coordinates.setRectangular(readInput("Enter the argument: ", "You entered an illegal number"), readInput("Enter the modulus (Equal or bigger than 0): ", "You entered an illegal number"));
        	System.out.println("\n" + "Real: " + coordinates.getRe());
        	System.out.println("Immaginary: " + coordinates.getIm());
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
            System.out.println(output);
            readInput = keyboard.readLine();
            try
            {
            	readNumber = Double.valueOf(readInput).doubleValue();
                correctValue = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println(error);
            }
        }
        return readNumber;
    }
}