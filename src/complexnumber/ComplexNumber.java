package complexnumber;

public class ComplexNumber
{
	private static double initRe;
	private static double initIm;
	private static StringFormat initFormat;
	private double re;
	private double im;
	private StringFormat format;
	
	/**
	 * Initializes the instance.
	 */
	public ComplexNumber()
	{
		this.re = ComplexNumber.initRe;
		this.im = ComplexNumber.initIm;
		this.format = ComplexNumber.initFormat;
	}
	
	/**
	 * The format of the string that will be printed.
	 */
	public static enum StringFormat
	{
		RECTANGULAR,
		POLAR
	}
	
	/**
	 * Sets default value for any new instance, given rectangular coordinates.
	 * Works only with rectangular coordinates.
	 * @param re
	 * @param im
	 */
	public static void setInitRectangular(double re, double im)
    {
		initRe = re;
        initIm = im;
        initFormat = StringFormat.RECTANGULAR;
	}
    
	/**
	 * Sets default value for any new instance, given polar coordinates.
	 * Works only with polar coordinates.
	 * @param modulus
	 * @param argument
	 */
	public static void setInitPolar(double modulus, double argument)
	{
		if(modulus < 0)
			throw new IllegalArgumentException("Modulus must be greater or equal to 0");
		initRe = Math.cos(argument*Math.PI/180)*modulus;
		initIm = Math.sin(argument*Math.PI/180)*modulus;
		initFormat = StringFormat.POLAR;
	}

	/**
	 * Given two complex numbers, sums them. 
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public static ComplexNumber add(ComplexNumber addend1, ComplexNumber addend2)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(addend1.getRe()+addend2.getRe(), addend1.getIm()+addend2.getIm());
		return result;
	}

	/**
	 * Given two complex numbers, subtracts them.
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public static ComplexNumber sub(ComplexNumber minuend, ComplexNumber subtrahend)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(minuend.getRe()-subtrahend.getRe(), minuend.getIm()-subtrahend.getIm());
		return result;
	}

	/**
	 * Given two complex numbers, multiplies them.
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public static ComplexNumber multiply(ComplexNumber factor1, ComplexNumber factor2)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(factor1.getModulus()*factor2.getModulus(), factor1.getArgument()+factor2.getArgument());
		return result;
	}

	/**
	 * Given two complex numbers, divides them.
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public static ComplexNumber divide(ComplexNumber dividend, ComplexNumber divisor)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(dividend.getModulus()/divisor.getModulus(), dividend.getArgument()-divisor.getArgument());
		return result;
	}

	/**
	 * Given a complex number, returns the complex conjugate.
	 * Works either with rectangular and with polar coordinates.
	 * @return
	 */
	public static ComplexNumber getConjugate(ComplexNumber number)
	{
		ComplexNumber result = new ComplexNumber();
		result.setRectangular(number.getRe(), -number.getIm());
		return result;
	}

	/**
     * Sets the format of the string that will be printed.
     * @param format
     */
    public void setStringFormat(StringFormat format)
    {
		this.format = format;
	}
    
    /**
     * Sets the complex number given rectangular coordinates.
     * Works only with rectangular coordinates.
     * @param re
     * @param im
     */
    public void setRectangular(double re, double im)
    {
    	this.re = re;
    	this.im = im;
    }
    
    /**
     * Sets the complex number given polar coordinates.
     * Works only with polar coordinates.
     * @param modulus
     * @param argument
     */
    public void setPolar(double modulus, double argument)
    {
        if(modulus < 0)
        	throw new IllegalArgumentException("The value of modulus must be equal or bigger than 0.");        	
        this.re = Math.cos(argument*Math.PI/180)*modulus;
	    this.im = Math.sin(argument*Math.PI/180)*modulus;
    }
    
    /**
     * Returns the value of re.
     * @return
     */
    public double getRe()
    {
        return re;
    }

    /**
     * Returns the value of im.
     * @return
     */
    public double getIm()
    {
        return im;
    }
    
    /**
     * Returns the value of argument.
     * @return
     */
    public double getArgument()
    {
    	short bugFix = 0;
    	if(this.re < 0)
    		bugFix = 180;
    	return((Math.atan(this.im/this.re)*180)/Math.PI+bugFix);
    }
    
    /**
     * Returns the value of modulus.
     * @return
     */
    public double getModulus()
    {
        return(Math.sqrt(Math.pow(this.re, 2)+Math.pow(this.im, 2)));
    }
    
    /**
	 * Given a complex number, sums them. 
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public ComplexNumber add(ComplexNumber addend)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(this.getRe()+addend.getRe(), this.getIm()+addend.getIm());
		return result;
	}

	/**
	 * Given a complex number, subtracts them.
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public ComplexNumber sub(ComplexNumber subtrahend)
	{
		ComplexNumber result = new ComplexNumber();
	    result.setRectangular(this.getRe()-subtrahend.getRe(), this.getIm()-subtrahend.getIm());
		return result;
	}

	/**
	 * Given a complex number, multiplies them.
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public ComplexNumber multiply(ComplexNumber factor)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(this.getModulus()*factor.getModulus(), this.getArgument()+factor.getArgument());
		return result;
	}

	/**
	 * Given a complex number, divides them.
	 * Works either with rectangular and with polar coordinates.
	 * @param operand
	 * @return
	 */
	public ComplexNumber divide(ComplexNumber divisor)
	{
		ComplexNumber result = new ComplexNumber();
		result.setPolar(this.getModulus()/divisor.getModulus(), this.getArgument()-divisor.getArgument());
		return result;
	}

	/**
	 * Given a complex number, returns the complex conjugate.
	 * Works either with rectangular and with polar coordinates.
	 * @return
	 */
	public ComplexNumber getConjugate()
	{
		ComplexNumber result = new ComplexNumber();
		result.setRectangular(this.getRe(), -this.getIm());
		return result;
	}
    
	/**
	 * Override of toString method.
	 */
    @Override public String toString()
    {
		return toString(this.format);
	}
   
    /**
     * Returns a string according to format.
     * @param format
     * @return
     */
    public String toString(StringFormat format)
    {
		String risult = new String();
		switch(format)
		{
			case RECTANGULAR:
				risult = this.getRe() + "+(" + this.getIm() + ")i";
				break;
			case POLAR:
				risult = this.getModulus() + "*exp(i*" + this.getArgument() +")";
				break;
		}
		return risult;
	}
    
    /**
     * Override of equals method.
     */
	@Override public boolean equals(Object object)
	{
		boolean equal = false;
		if(object instanceof ComplexNumber)
		{
			ComplexNumber pointer = (ComplexNumber)object;
			if(this.re == pointer.getRe() && this.im == pointer.getIm())
				equal = true;
		}
		return equal;
	}
}