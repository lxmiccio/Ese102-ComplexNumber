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
     * If the argument is 180, assigns 0 to im.
     * @param modulus
     * @param argument
     */
    public void setPolar(double argument, double modulus)
    {
    	System.out.println(modulus);
        if(modulus >= 0)
        {
        	this.re = Math.cos(argument*Math.PI/180)*modulus;
	        if(argument == 180)
	        	this.im = 0;
	        else
	        	this.im = Math.sin(argument*Math.PI/180)*modulus;
        }
        else
        	throw new IllegalArgumentException("The value of modulus must be equal or bigger than 0.");
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
    	if(this.re < 0 && this.im == 0)
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
     * Non sono presenti costruttori poiché questa classe gestisce i numeri complessi in due modi, utilizzando
     * coordinate cartesiane e polari. Non è possibile realizzare entrambi i metodi costruttori, poiché entrambi
     * richiedono due valori double. È stato quindi deciso di non utilizzare nessun metodo costruttore, perciò l'utente,
     * per inizializzare i campi della classe, utilizzerà il metodo setRectangular e setPolar.
     */
}