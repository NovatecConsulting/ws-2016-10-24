package info.novatec.testit.livingdoc.training.exercises.call;

public class Call {
	
	private CallTypeEnum type;
	private int countMinutes;
	private double price;
	public int getCountMinutes() {
		return countMinutes;
	}
	public void setCountMinutes(int countMinutes) {
		this.countMinutes = countMinutes;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CallTypeEnum getType() {
		return type;
	}
	public void setType(CallTypeEnum type) {
		this.type = type;
	}
	
	
}
