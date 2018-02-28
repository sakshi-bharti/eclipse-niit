package sakshi.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class drawingapp {

	public static void main(String[] args) {
		//BeanFactory fact=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		//triangle tri =(triangle) context.getBean("triangle");
		//square sq=(square) context.getBean("square");
		//rectangle rect=(rectangle) context.getBean("rectangle1");
		//sq.draw();
		//circle cir=(circle) context.getBean("circle");
		//newsquare nws=(newsquare) context.getBean("newsquare2");
		//rect.draw();
		//AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		//context.registerShutdownHook();
		//lyfcyle lyf=(lyfcyle) context.getBean("lyfcyle");
		//lyf.draw();
		shape shap=(shape) context.getBean("circlee");
		shap.draw();
	} 

}
