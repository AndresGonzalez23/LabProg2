public class frequentClient extends Client {
	private int frequentNum;

	public int getFrequentNum() {
		return frequentNum;
	}

	public frequentClient(String name, String dni, long creditCard, int license, boolean frequent, Request[] request, int numberRequest) {
		super(name, dni, creditCard, license, frequent, request, numberRequest);
		this.frequentNum = frequentNum;
	}
	
	public double calculateDiscount(int license, boolean frequent) {
		double discount = 0;
		if (license >= 10) {
			discount = 0.05;
			if (frequent == true) {
				discount = discount + 0.2;
			}
		}
		if (license >= 10 && frequent == true) {
			discount = 0.3;
		}
		return discount;
	}

	public String toString() {
		return "frequentClient" + super.toString() + "frequentNum=" + frequentNum;
	}

}
