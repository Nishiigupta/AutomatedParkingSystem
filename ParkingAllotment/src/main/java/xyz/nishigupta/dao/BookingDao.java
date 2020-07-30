package xyz.nishigupta.dao;

import xyz.nishigupta.entities.BookingInfo;

public class BookingDao {
	private BookingInfo bookingInfo;

	public BookingDao(BookingInfo bookingInfo) {
		this.bookingInfo = bookingInfo;
	}
	
	public boolean validate() {
		// Check in the database whether it is available or not
		
		// if available
		this.bookingInfo.setAvailable(false);
		this.bookingInfo.setAvailability(12);
		
		// if not available return false and set values accordingly
		
				
		return true;
	}
	
}