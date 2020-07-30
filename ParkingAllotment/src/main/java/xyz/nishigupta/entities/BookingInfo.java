package xyz.nishigupta.entities;

public class BookingInfo {
	private String arrivalDate;
	private String departureDate;
	private String arrivalTime;
	private String departureTime;
	private final String coordX;
	private final String coordY;
	private final String parkingName;
	
	private boolean isAvailable;
	private Integer availability;
	
	
	public BookingInfo(String coordX, String coordY, String parkingName) {
		int endIndex = coordX.length();
		final int afterPoint = 5;
		
		// Coordinate X
		for(int i = 0; i < coordX.length(); i++) {
			if(coordX.charAt(i) == '.') {
				endIndex = i+afterPoint;
				break;
			}
		}
		this.coordX = coordX.substring(0, endIndex);
		
		// Coordinate Y
		endIndex = coordY.length();
		for(int i = 0; i < coordY.length(); i++) {
			if(coordY.charAt(i) == '.') {
				endIndex = i+afterPoint;
				break;
			}
		}
		this.coordY = coordY.substring(0, endIndex);
		this.parkingName = parkingName;
	}
	
	// Validating inputs
	public boolean isValid() {
		if(getParkingName().isBlank()) return false;
		
		if(getCoordX().isBlank() || getCoordY().isBlank()) {
			return false;
		}
		if(getArrivalDate().isBlank() || getArrivalTime().isBlank() || getDepartureDate().isBlank() || getDepartureTime().isBlank() ) {
			return false;
		}
		
		// Validate date
		System.out.println("Date Validation");
		final String arriveD[] = getArrivalDate().split("-");
		final String departD[] = getDepartureDate().split("-");
		if(Integer.parseInt(arriveD[0]) > Integer.parseInt(departD[0]) || Integer.parseInt(arriveD[1]) > Integer.parseInt(departD[1]) || Integer.parseInt(arriveD[2]) > Integer.parseInt(departD[2])) {
			return false;
		}
		
		// Validate time
		System.out.println("Time Validation");
		final String arriveT[] = getArrivalTime().split("-");
		final String departT[] = getDepartureTime().split("-");
		if(Integer.parseInt(arriveT[0]) > Integer.parseInt(departT[0])) {
			int increaseDate = Integer.parseInt(departD[0])+1;
			String newDepartureDate = "";
			if(increaseDate < 10) newDepartureDate+="0";
			newDepartureDate += increaseDate+"-"+departD[1]+"-"+departD[2];			
			setDepartureDate(newDepartureDate);
		}
		System.out.println("Time Validation success");
		
		return true;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Integer getAvailability() {
		if(!this.isAvailable) return 0;
		
		return availability;
	}

	public void setAvailability(Integer availability) {
		if(!this.isAvailable) return;
		this.availability = availability;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getCoordX() {
		return coordX;
	}

	public String getCoordY() {
		return coordY;
	}

	public String getParkingName() {
		return parkingName;
	}

	@Override
	public String toString() {
		return "BookingInfo [arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", arrivalTime="
				+ arrivalTime + ", departureTime=" + departureTime + ", coordX=" + coordX + ", coordY=" + coordY
				+ ", parkingName=" + parkingName + "]";
	}

	
}