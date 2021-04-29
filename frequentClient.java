public class frequentClient extends Client {
	private int frequentNum;

	public int getFrequentNum() {
		return frequentNum;
	}

	public frequentClient(String name, String dni, long creditCard, int license, boolean frequent, int frequentNum) {
		super(name, dni, creditCard, license, frequent);
		this.frequentNum = frequentNum;
	}

	public String toString() {
		return "frequentClient" + super.toString() + "frequentNum=" + frequentNum;
	}

}