package sakshi.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class circlee implements shape
{
private point center;
	@Override
	public void draw() {
		System.out.println("circle drawn");
		System.out.print("center point is:("+center.getX()+","+ center.getY()+")");
		
	}
	public point getCenter() {
		return center;
	}
	@Autowired
	@Qualifier("circlerelated")
	public void setCenter(point center) {
		this.center = center;
	}

}
