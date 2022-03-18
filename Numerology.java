
public class Numerology {
	public int month = 0;
	public int date = 0;
	public int year = 0;
	public int result = 0;
	public String prediction = null;
	
	//Object being created by Driver
	public Numerology(int mm, int dd, int yyyy, int result, String prediction) {
		this.month = mm;
		this.date = dd;
		this.year = yyyy;
		this.result = result;
		this.prediction = prediction;
	}
	
	//Returns the string representation of Numerology 
	public String toString() {
		return (month + "/" + date + "/" + year + " " + prediction);
	}
	
	//Returns only the prediction to be printed in predict.txt
	public String getPrediction() {
		return prediction;
	}
	
}
