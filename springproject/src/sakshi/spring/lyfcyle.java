package sakshi.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class lyfcyle implements InitializingBean,DisposableBean {
	private point pointA;
	private point pointB;
	private point pointC;
	private point pointD;
	
	
	
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
	public void afterPropertiesSet() throws Exception {
		System.out.println("initalize init method called for lyfcle");
		
	}



	@Override
	public void destroy() throws Exception {
		System.out.println("disposable destroy method called for lyfcle");
	}
		
	public void myInit() {
	
	System.out.println("my init method called for lfycle");
		
	}
	public void cleanup() {
		System.out.println("my destroy method called for lfycle");
		
	}
		
	}
		


