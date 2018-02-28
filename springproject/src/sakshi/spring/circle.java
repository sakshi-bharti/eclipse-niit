package sakshi.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class circle implements  ApplicationContextAware,BeanNameAware{
	private point pointA;
	private point pointB;
	private point pointC;
	private point pointD;
	private ApplicationContext context;
	
	
	
	
	public point getPointA() {
		return pointA;
	}



	public void setPointA(point pointA) {
		this.pointA = pointA;
	}



	public point getPointB() {
		return pointB;
	}



	public void setPointB(point pointB) {
		this.pointB = pointB;
	}



	public point getPointC() {
		return pointC;
	}



	public void setPointC(point pointC) {
		this.pointC = pointC;
	}



	public point getPointD() {
		return pointD;
	}



	public void setPointD(point pointD) {
		this.pointD = pointD;
	}



	public void draw() {
		System.out.println("pointA=("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("pointB=("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("pointC=("+getPointC().getX()+","+getPointC().getY()+")");
		System.out.println("pointD=("+getPointD().getX()+","+getPointD().getY()+")");
	}



	@Override
	public void setBeanName(String beanName) {
		System.out.println("this is bean" +beanName);
	}
		
	



	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;


}
}
