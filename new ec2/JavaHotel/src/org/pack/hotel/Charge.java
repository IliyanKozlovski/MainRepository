package org.pack.hotel;

public class Charge {
	Guest guest;
	Service service;

	public Guest getGuest() {
		return guest;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
		
		
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Charge(Guest guest, Service service) {
		super();
		this.service = service;
		this.guest = guest;
		
	}

	public double calculateVAT(){
		double x;
		x = this.service.getStandartCharge();
		
		if(this.service.getVatrate() == VATRate.ZERO)
			return 0;
		if(this.service.getVatrate() == VATRate.LOW)
		return 5*x/100;
		return 20*x/100;
	}

}
