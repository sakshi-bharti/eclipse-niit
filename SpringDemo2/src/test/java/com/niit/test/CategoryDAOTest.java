package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;



public class CategoryDAOTest {
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void preExecution(){
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest() {
		Category category=new Category();
		category.setCategoryname("samsung");
		category.setCategorydesc("samsung mobile");
		assertTrue("problem in adding",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest() {
		Category category=categoryDAO.getCategory(2);
		category.setCategoryname("samsung grand galaxy");
		assertTrue("problem in updating",categoryDAO.updateCategory(category));

	}
	
@Test
public void deleteCategoryTest() {
	Category category=categoryDAO.getCategory(68);
	
	assertTrue("problem in delerting",categoryDAO.deleteCategory(category));
}
	
@Ignore	
@Test
public void listCategories() {
	List<Category> listCategories=categoryDAO.listCategories();
	
	assertNotNull("problem in retriving",listCategories);
}

}
