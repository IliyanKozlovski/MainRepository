package org.pack.hotel;

public class Raiting {
	private String name;
	private int stars;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		if(stars>0 && stars<6)
		this.stars = stars;
	}

}
