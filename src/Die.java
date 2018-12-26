import java.util.Random;

class Die
{
	//class variables
	private int dieValue_;
	public final static int MAX_DIE_VALUE = 6;
	public final static int MIN_DIE_VALUE = 1;
	private Random r;	
	
	//default constructor
	Die()
	{
		dieValue_ = MIN_DIE_VALUE;
		r = new Random();
	}
	
	//class methods
	public void roll()
	{
		dieValue_ = MIN_DIE_VALUE + r.nextInt(MAX_DIE_VALUE);
		//dieValue_ = (int)(MIN_DIE_VALUE + Math.random() * MAX_DIE_VALUE);
  	}
	
	public int getValue()
	{
		return dieValue_;
	}
	
	public String toString()
	{
		return "%d" + dieValue_;
	}
}

