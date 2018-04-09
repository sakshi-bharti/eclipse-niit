package com.niit.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/Product")
	public String showProductPage(Model m) {
		
		Product product=new Product();
		m.addAttribute(product);
		List<Product> listproducts=productDAO.listproducts();
	    m.addAttribute("listproducts",listproducts);
	    m.addAttribute("categoryList",this.getCategories());
	return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	 public String addProduct(@ModelAttribute("product")Product product,@RequestParam("pimage") MultipartFile filedet,Model m) {
		
		productDAO.addProduct(product);
		
	Product product1=new Product();
	m.addAttribute(product1);	
	List<Product> listproducts=productDAO.listproducts();
   m.addAttribute("listProducts",listproducts);
   m.addAttribute("categoryList",this.getCategories());
  
  // adding image
   String path="C:\\Users\\sakshi\\git\\niit\\SpringFrontend\\src\\main\\webapp\\resources\\images";
   path=path+String.valueOf(product.getProductId())+".jpg";
   File file =new File(path);
   if(!filedet.isEmpty())
   {
	   try {
		   byte[] buffer= filedet.getBytes();
		   FileOutputStream fos=new FileOutputStream(file);
		   BufferedOutputStream bs=new BufferedOutputStream(fos);
		   bs.write(buffer);
		   bs.close();
	   
		   
	   
	   }catch( Exception e) {
		   m.addAttribute("error info","exception arised"+e);
	   }
   }
   else
   {
	   
	   m.addAttribute("error info","system problem no image insert");
   }
   
		   return "Product";
	}
	
	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId, Model m ) {
		Product product=(Product)productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
		List<Product> listproducts=productDAO.listproducts();
	    m.addAttribute("listProducts",listproducts);
	    m.addAttribute("categoryList",this.getCategories());
		return "Product";
}
	
	
	@RequestMapping("/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId, Model m ) {
		
		Product product=(Product)productDAO.getProduct(productId);
		m.addAttribute(product);
		
		List<Product> listproducts=productDAO.listproducts();
	    m.addAttribute("listProducts",listproducts);
	    m.addAttribute("categoryList",this.getCategories());
	
		return "Product";

	
}
//	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
//	public String updateProduct(@RequestParam("proid")int productId,@RequestParam("proname")String proname,@RequestParam("prodesc")String prodesc,Model m) {
//		
//	
//		Product product=(Product)productDAO.getProduct(productId);
//		
//		product.setProductName(proname);
//		product.setProductDesc(prodesc);
//		
//		productDAO.updateProduct(product);
//		List<Product> listproducts=productDAO.listproducts();
//	    m.addAttribute("listProducts",listproducts);
//		
//		
//		return"Product";
//	}
	public LinkedHashMap<Integer,String>  getCategories()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
		for(Category category:listCategories) {
			categoryList.put(category.getCategoryid(),category.getCategoryname());
			
			
		}
		return categoryList;
		
	}
	

}
