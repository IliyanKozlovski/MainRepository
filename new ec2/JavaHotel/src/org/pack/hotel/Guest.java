package org.pack.hotel;

import java.util.ArrayList;

public class Guest implements IGuest {
	public String forname;
	public String surname;
	public String adress;
	public String telnumber;
	public VATRate vatRate;
	public ArrayList<Charge> arrayCharge;
	public String getForname() {
		return forname;
	}
	public VATRate getVatRate(){
		return vatRate;
	};
	
	public void setForname(String forname) {
		this.forname = forname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTelnumber() {
		return telnumber;
	}
	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}
	
	public Guest(String forname, String surname) {
		super();
		arrayCharge = new ArrayList<Charge>();
		this.forname = forname;
		this.surname = surname;
	}

	public void addCharge(Charge charge){
		arrayCharge.add(charge);
	}
	public double calculateTotalChargeWithoutVAT(){
		double sum = 0;
		for (int i = 0; i < arrayCharge.size(); i++) {
			sum += arrayCharge.get(i).getService().getStandartCharge();
		}
		return sum;
	}
	public double calculateVATChargeAtRate(){
		double sum = 0;
		for (int i = 0; i < arrayCharge.size(); i++) {
			sum += arrayCharge.get(i).calculateVAT();
			//sum += arrayCharge.get(i).getService().getStandartCharge();
		}
		return sum;
	}
	
	
	
}
