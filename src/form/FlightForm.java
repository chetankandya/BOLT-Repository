package form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FlightForm {

	@NotNull(message="Flight number cannot be null") @Size(min=4, max=15, message="Invalid Range of flight Number")
	private String flightNo;
	
	private String carrier;
	private String from;
	private String to;
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Flight No = "+flightNo+", Carrier = "+carrier+", From = "+from+", To = "+to;
	}
	
}
