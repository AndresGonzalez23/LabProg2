public class Request {
	private int hireTime;
	private String id;
	private Vehicle hireVehicle;

	public String getId() {
		return id;
	}

	public Request(int hireTime, String id, Vehicle hireVehicle) {
		this.hireTime = hireTime;
		this.id = id;
		this.hireVehicle = hireVehicle;
	}

	public boolean is_Automatic() {
		boolean automatic = false;
		if (this.hireVehicle.isAutomatic()) {
			automatic = true;
		}
		return automatic;
	}

	public String toString() {
		return "request [hireTime=" + hireTime + ", id=" + id + ", hireVehicle=" + hireVehicle + "]";
	}

}