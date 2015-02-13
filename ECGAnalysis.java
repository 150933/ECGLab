import java.util.ArrayList;

public class ECGAnalysis {
	
	public static int SAMPLING_RATE = 300;
	public static int Delta = SAMPLING_RATE/10;
	
	public static boolean isRpeak(double[] v, int r)
	{
//		boolean checked = true;
		if (v[r]<=1.0)
		{
			return false;
		}
		
		if (max(v, r-Delta, r+Delta)>v[r])		//if the max is less than the target element, returns false 
		{
			return false;
		}
		
		if (min(v, r-Delta, r)>0)			//if the min is greater than 0, returns false
		{
			return false;
		}
		
		if (min(v, r, r+Delta)>0)			// if the min is greater than 0, returns false (different position)
		{
			return false;
		}
		
		return true;
	}
	
	public static ArrayList<Integer> allRpeaks (double[] v)		//returns an array with all the position values of the peaks
	{

		ArrayList<Integer> template = new ArrayList<Integer>();
		
		for (int x=0; x>v.length; x+=Delta)
		{
		if (isRpeak(v,x)==true)
		{
			template.add(x);
		}
		
		else
		{
			x++;
		}
		
		}
		
		return template;
		
	}
	
	public static int heartRate (ArrayList<Integer> rPeaks)		//calcualates the heartrate 
	{
		int firstpeak = rPeaks.get(0);
		int lastpeak = rPeaks.get(rPeaks.size()-1);
		
		double rrInterval = (lastpeak-firstpeak)/(rPeaks.size()-1);		//measures the average length of the R-R intervals by array size
		
		return (int)(60/(rrInterval/SAMPLING_RATE));	//converts the intervals into real time (beats per minute)
	}
	
	private static double max(double[] v, int i, int j)	
	{
		
	}
	
	private static double min(double[] v, int i, int j)
	{
		
	}

}
