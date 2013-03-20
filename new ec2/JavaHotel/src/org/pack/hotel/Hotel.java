package org.pack.hotel;

import java.util.ArrayList;

public class Hotel {
	private Raiting raiting;
	private ArrayList<IGuest> guest;
	
	public Hotel(Raiting raiting) {
		super();
		guest = new ArrayList<>();
		this.raiting = raiting;
	}

	public Raiting getRaiting() {
		return raiting;
	}

	public ArrayList<IGuest> getGuest() {
		return guest;
	}
	
	void addGuest(Guest newGuest){
		guest.add(newGuest);
	}
	
	void printall(){
		for (int i = 0; i < guest.size(); i++) {
			System.out.println(guest.get(i).getForname()+ " " +
					guest.get(i).getSurname());
		}
	}
}
