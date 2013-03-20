package org.pack.hotel;

public class Main {
	
	static void raitingTest(){
		Raiting raiting = new Raiting();
		raiting.setStars(4);
		raiting.setName("Blalaton");
		System.out.println(raiting.getName());
		System.out.println(raiting.getStars());
	}
	
	static void hotelTest(){
		Raiting raiting = new Raiting();
		raiting.setStars(4);
		raiting.setName("Blalaton");
		Hotel hotel = new Hotel(raiting);
		Guest guest = new Guest("Niki" , "Iliev" );
		Guest guest1 = new Guest("Gala" , "Yovcheva");
		hotel.addGuest(guest);
		hotel.addGuest(guest1);
		hotel.printall();
	}
	
	static void chargeTest(){
		Service service = new Service("CODE1234","uslugi", VATRate.LOW , 1000);
		Guest guest = new Guest("Niki" , "Iliev" );
		Charge charge = new Charge(guest, service);

		System.out.println(charge.calculateVAT());
		
	}
	static void vatTest(){
		Guest guest = new Guest("Niki" , "Iliev" );
		Service service = new Service("CODE1234","uslugi", VATRate.LOW , 60);
		Service service1 = new Service("MODE1234","uslugi", VATRate.LOW , 90);
		Charge charge = new Charge(guest, service);
		Charge charge1 = new Charge(guest, service1);
		guest.addCharge(charge);
		guest.addCharge(charge1);
		System.out.println(guest.calculateTotalChargeWithoutVAT());
		System.out.println(guest.calculateVATChargeAtRate());
	}
	

	public static void main(String[] args) {
		//raitingTest();
		//hotelTest();
		//chargeTest();
		vatTest();

	}

}
