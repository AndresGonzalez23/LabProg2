public class frequentClient extends Client {
	private int frequentNum;

	public int getFrequentNum() {
		return frequentNum;
	}

	public frequentClient(String name, String dni, long creditCard, int license, boolean frequent, Request[] request, int numberRequest) {
		super(name, dni, creditCard, license, frequent, request, numberRequest);
		this.frequentNum = frequentNum;
	}
	
	public String toString() {
		return "frequentClient" + super.toString() + "frequentNum=" + frequentNum;
	}

}
