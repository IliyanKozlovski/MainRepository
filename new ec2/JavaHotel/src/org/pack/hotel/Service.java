package org.pack.hotel;

public class Service {
	private String code;
	private String name;
	private VATRate vatrate;
	private double standartCharge;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if ((code.charAt(0) > 'A' && code.charAt(0) < 'Z')
				&& (code.charAt(1) > 'A' && code.charAt(1) < 'Z')
				&& (code.charAt(2) > 'A' && code.charAt(2) < 'Z')
				&& (code.charAt(3) > 'A' && code.charAt(3) < 'Z')
				&& (code.charAt(4) > '0' && code.charAt(4) < '9')
				&& (code.charAt(5) > '0' && code.charAt(5) < '9')
				&& (code.charAt(6) > '0' && code.charAt(6) < '9')
				&& (code.charAt(7) > '0' && code.charAt(7) < '9'))
			
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VATRate getVatrate() {
		return vatrate;
	}

	public void setVatrate(VATRate vatrate) {
		this.vatrate = vatrate;
	}

	public double getStandartCharge() {
		return standartCharge;
	}

	public void setStandartCharge(double standartCharge) {
		this.standartCharge = standartCharge;
	}

	public Service(String code, String name, VATRate vatrate, double standartCharge) {
		super();
		setCode(code);
		setName(name);
		setVatrate(vatrate);
		setStandartCharge(standartCharge);
	}
	
	

}
