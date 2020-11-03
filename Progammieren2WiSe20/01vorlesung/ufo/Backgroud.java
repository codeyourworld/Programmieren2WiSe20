package ufo;

import view.IBackground;

public class Backgroud implements IBackground {

	private String image;

	public Backgroud(String image) {
		super();
		this.image = image;
	}

	@Override
	public String getImagePath() {
		return image;
	}

}
