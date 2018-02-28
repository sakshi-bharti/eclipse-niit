package sakshi.spring;

import java.util.List;

public class rectangle {
private List<point> points;


public List<point> getPoints() {
	return points;
}


public void setPoints(List<point> points) {
	this.points = points;
}


public void draw() {
	for(point point: points) {
		System.out.println("point=("+point.getX()+","+point.getY()+")");
	}
	
}
}
