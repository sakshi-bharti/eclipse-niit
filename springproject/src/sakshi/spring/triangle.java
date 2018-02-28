package sakshi.spring;

public class triangle {
	private String type;
	private int height;
	public triangle(String type) {
		this.type=type;
		
		
	}
	public triangle(String type,int height) {
		this.type=type;
		this.height=height;
	}
	public int getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}
	/*public void setType(String type) {
		Type = type;
	}*/
	public void draw(){
		System.out.println(getType()+ "triangle drawn is of height" +getHeight());
		
	}


}

