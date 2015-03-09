package complexnumber;

public class ComplexNumber
{
	private static double initializeRe;
    private static double initializeIm;
    private double re;
    private double im;
    
    /**
     * Static method, initialize the variables initializeRe and initializeIm to default value.
     * Works only with rectangular coordinates.
     * @param re
     * @param im
     */
    public static void setInitializeRectangular(double re, double im)
    {
        initializeRe = re;
        initializeIm = im;
    }
    
    /**
     * Static method, initialize the variables initializeRe and initializeIm to default value, given argument and modulus.
	 * Works only with polar coordinates.
     * @param modulus
     * @param argument
     */
    public static void setInitializePolar(double modulus, double argument)
    {
        if(modulus < 0)
        	throw new IllegalArgumentException("Modulus must be greater or equal to 0");
        initializeRe = Math.cos(argument*Math.PI/180)*modulus;
        initializeIm = Math.sin(argument*Math.PI/180)*modulus;
    }
    
    /**
     * SetRectangular initializes the variables re and im.
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
     * SetPolar initializes the variables re and im, given argument and modulus.
     * Works only with polar coordinates.
     * The modulus can't be less than 0.
     * @param modulus
     * @param argument
     */
    public void setPolar(double argument, double modulus)
    {
        if(modulus < 0)
        	throw new IllegalArgumentException("The value of modulus must be equal or bigger than 0.");        	
        this.re = Math.cos(argument*Math.PI/180)*modulus;
	    this.im = Math.sin(argument*Math.PI/180)*modulus;
        if(argument%90 == 0 && argument%180 != 0)
        	this.re = Math.floor(this.re);
        else if(argument%180 == 0)
        	this.im = Math.floor(this.im);
    }
    
    /**
     * Given two complex numbers, sums them. 
     * Works either with rectangular and with polar coordinates.
     * @param operand
     * @return
     */
    public static ComplexNumber add(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber result = new ComplexNumber();
        result.setRectangular(operand1.re+operand2.re, operand1.im+operand2.im);
    	return result;
    }
    
    /**
     * Given two complex numbers, subtracts them.
     * Works either with rectangular and with polar coordinates.
     * @param operand
     * @return
     */
    public static ComplexNumber sub(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setRectangular(operand1.re-operand2.re, operand1.im-operand2.im);
    	return result;
    }
    
    /**
     * Given two complex numbers, multiplies them.
     * Works either with rectangular and with polar coordinates.
     * @param operand
     * @return
     */
    public static ComplexNumber multiply(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setPolar(operand1.getArgument()+operand2.getArgument(), operand1.getModulus()*operand2.getModulus());
    	return result;
    }
    
    /**
     * Given two complex numbers, divides them.
     * Works either with rectangular and with polar coordinates.
     * @param operand
     * @return
     */
    public static ComplexNumber divide(ComplexNumber operand1, ComplexNumber operand2)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setPolar(operand1.getArgument()-operand2.getArgument(), operand1.getModulus()/operand2.getModulus());
    	return result;
    }
        
    /**
     * Given a complex number, returns the complex conjugate.
     * Works either with rectangular and with polar coordinates.
     * @return
     */
    public static ComplexNumber getConjugate(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setRectangular(operand.re, -operand.im);
    	return result;
    }
      
    /**
     * Returns re.
     * @return
     */
    public double getRe()
    {
        return re;
    }

    /**
     * Returns im.
     * @return
     */
    public double getIm()
    {
        return im;
    }
    
    /**
     * Returns the argument.
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
     * Returns the modulus.
     * @return
     */
    public double getModulus()
    {
        return(Math.sqrt(Math.pow(this.re, 2)+Math.pow(this.im, 2)));
    }
    
    /**
     * Prints the complex number.
     * Works only with rectangular coordinates.
     * @return
     */
    public String formatComplexNumber()
    {
        String result = this.getRe() + "+(" + this.getIm() + ")i";
        return result;
    }
    
    /*
	 *   1) Math.sqrt(Math.pow(this.re, 2)+Math.pow(this.im, 2))
	 *      Math.atan(this.im/this.re)*180)/Math.PI
	 *      Per re = 0 e im = 0 l'argomento deve essere NaN
	 *      this.re = Math.cos(argument*Math.PI/180)*modulus
	 *      this.im = Math.sin(argument*Math.PI/180)*modulus
	 *      
	 *   2) Non posso fornire quattro funzioni setter (setRe, setIm, setModulus, setArgument), ma lavorare 
	 *      con due (setRectangular, setPolar), poiché i parametri devo essere utilizzati in coppia.
	 *   
	 *	 3) Non sono quindi presenti costruttori poiché questa classe gestisce i numeri complessi in due modi, utilizzando
	 *      coordinate cartesiane e polari. Non è possibile fornire entrambi i metodi costruttori, poiché entrambi
	 *      richiedono come parametri due valori double. È stato quindi deciso di non utilizzare nessun metodo costruttore, 
	 *      perciò l'utente, per inizializzare i campi della classe, utilizzerà i metodi setRectangular e setPolar.
	 *	
	 *	 4) Devo necessariamente utilizzare quattro funzioni getter (getRe, getIm, getModulus, getArgument),
	 * 	    poiché, utilizzandone solamente due (getRectangular, getPolar), ciascun metodo dovrebbe ritornare due valori,
	 *	    cosa impossibile.
	 *
	 *	 5) Conosco come calcolare la somma/sottrazione tra due numeri complessi?
     *      x = a1+b1i 
     *      y = a2+b2i
     *      x+y = (a1+a2)+(b1+b2)i
     *      x-y = (a1-a2)+(b1-b2)i
     *      
     *   6) Conosco come calcolare la moltiplicazione/divisione tra due numeri complessi?
     *	    x = a1+b1i 
     *      y = a2+b2i
     *      Argomento = ArgomentoX+ArgomentoY
     *      Modulo = ModuloX*ModuloY
	 *	    Argomento = ArgomentoX-ArgomentoY
     *      Modulo = ModuloX/ModuloY
     *	
     *	 7) Conosco come calcolare il complesso coniugato di un numero complesso?
     *      x = a+bi 
     *      x = a-bi
     */
}