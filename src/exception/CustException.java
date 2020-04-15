package exception;

public class CustException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	
	
	public CustException(String message)
	{
		
		super(message);
	 
	}
	
	public CustException(String arg0, Throwable arg1)
	{
		
		super(arg0, arg1);
	}
	

}
