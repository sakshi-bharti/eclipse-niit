

package com.niit.controller;

import java.util.List;
import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;




@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/Category")
	public String showCategory(Model m) {
		List<Category> listCategories=categoryDAO.listCategories();
	    m.addAttribute("categoryList",listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	 public String addCategory(@RequestParam("catname")String catname,@RequestParam("catdesc")String catdesc,Model m) {
		
		
		Category category=new Category();
		category.setCategoryname(catname);
		category.setCategorydesc(catdesc); 
		categoryDAO.addCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
	    m.addAttribute("categoryList",listCategories);
		
		return "Category";
	}
	
	@RequestMapping("/deleteCategory/{categoryid}")
	public String deleteCategory(@PathVariable("categoryid")int categoryid, Model m ) {
		Category category=(Category)categoryDAO.getCategory(categoryid);
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		return "Category";
	
}
	
	
	@RequestMapping("/editCategory/{categoryid}")
	public String editCategory(@PathVariable("categoryid")int categoryid, Model m ) {
		Category category=(Category)categoryDAO.getCategory(categoryid);
		
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		m.addAttribute("categoryInfo",category);
		return "UpdateCategory";
	
}
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catid")String categoryId,@RequestParam("catname")String catname,@RequestParam("catdesc")String catdesc,Model m)
	{
		
		int categoryid=Integer.parseInt(categoryId);
		Category category=(Category)categoryDAO.getCategory(categoryid);
		category.setCategoryname(catname);
		category.setCategorydesc(catdesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList",listCategories);
		
		
		return"Category";
	}
	
}	




