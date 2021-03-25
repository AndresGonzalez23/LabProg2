public class request {
	private int hireTime;
	private String id;
	private Vehicle hireVehicle;

	public request(int hireTime, String id, Vehicle hireVehicle) {
		this.hireTime = hireTime;
		this.id = id;
		this.hireVehicle = hireVehicle;
	}

	public boolean is_Automatic(Vehicle hireVehicle) {
		boolean automatic = false;
		if (hireVehicle.isAutomatic()) {
			automatic = true;
		}
		return automatic;
	}
	
	public String toString() {
		return "request [hireTime=" + hireTime + ", id=" + id + ", hireVehicle=" + hireVehicle + "]";
	}
	

}
