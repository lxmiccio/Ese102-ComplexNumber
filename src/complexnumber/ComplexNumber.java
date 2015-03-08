package complexnumber;

public class ComplexNumber
{
    private double re;
    private double im;
        
    /**
     * SetRectangular initializes the variables re and im.
     * @param re
     * @param im
     */
    public void setRectangular(double re, double im)
    {
    	this.re = re;
    	this.im = im;
    }
    
    /**
     * SetPolar initializes the variables argument and modulus. 
     * The modulus can't be less than 0.
     * @param modulus
     * @param argument
     */
    public void setPolar(double argument, double modulus)
    {
        if(modulus >= 0)
        {
        	this.re = Math.cos(argument*Math.PI/180)*modulus;
	        this.im = Math.sin(argument*Math.PI/180)*modulus;
        	if(argument == 90)
        		this.re = 0;
        	else if(argument == 180)
	        	this.im = 0;
        	else if(argument == 270)
        		this.re = 0;
        }
        else
        	throw new IllegalArgumentException("The value of modulus must be equal or bigger than 0.");
    }
    
    /**
     * Given two complex numbers, sums them. 
     * Works only with rectangular coordinates.
     * @param operand
     * @return
     */
    public ComplexNumber add(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
        result.setRectangular(this.re+operand.re, this.im+operand.im);
    	return result;
    }
    
    /**
     * Given two complex numbers, subtracts them.
     * Works only with rectangular coordinates.
     * @param operand
     * @return
     */
    public ComplexNumber sub(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setRectangular(this.re-operand.re, this.im-operand.im);
    	return result;
    }
    
    /**
     * Given two complex numbers, multiply them.
     * Works only with rectangular coordinates.
     * @param operand
     * @return
     */
    public ComplexNumber multiply(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setPolar(this.getArgument()+operand.getArgument(), this.getModulus()*operand.getModulus());
    	return result;
    }
    
    /**
     * Given two complex numbers, divides them.
     * @param operand
     * @return
     */
    public ComplexNumber divide(ComplexNumber operand)
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setPolar(this.getArgument()-operand.getArgument(), this.getModulus()/operand.getModulus());
    	return result;
    }
        
    /**
     * Given a complex number, returns the complex conjugate.
     * Works only with rectangular coordinates.
     * @return
     */
    public ComplexNumber getConjugate()
    {
    	ComplexNumber result = new ComplexNumber();
    	result.setRectangular(this.re, -this.im);
    	return result;
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
    
    /**
     * Returns the modulus.
     * @return
     */
    public double getModulus()
    {
        return(Math.sqrt(Math.pow(this.re, 2)+Math.pow(this.im, 2)));
    }
        
    /**
     * Returns the argument. If re < 0 and im == 0 it returns 180.
     * @return
     */
    public double getArgument()
    {
    	int bugFix = 0;
    	if(this.re < 0)
    		bugFix = 180;
    	return((Math.atan(this.im/this.re)*180)/Math.PI+bugFix);
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