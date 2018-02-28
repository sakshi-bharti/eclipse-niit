package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;



@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping( value="/product")
	public String showProductPage(Model m) {
		
		Product product=new Product();
		m.addAttribute(product);
		List<Product> listproducts=productDAO.listproducts();
	    m.addAttribute("listProducts",listproducts);
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	 public String addProduct(@ModelAttribute("product")Product product,Model m) {
		
		productDAO.addProduct(product);
		
	Product product1=new Product();
	m.addAttribute(product1);
		
		
	List<Product> listproducts=productDAO.listproducts();
    m.addAttribute("listProducts",listproducts);
	return "Product";
	}
	
//	@RequestMapping("/deleteProduct/{productId}")
//	public String deleteProduct(@PathVariable("productId")int productId, Model m ) {
//		Product product=(Product)productDAO.getProduct(productId);
//		productDAO.deleteProduct(product);
//		List<Product> listproducts=productDAO.listproducts();
//	    m.addAttribute("productList",listproducts);
//		return "Product";
//}
//	
//	
//	@RequestMapping("/editProduct/{productId}")
//	public String editProduct(@PathVariable("productId")int productId, Model m ) {
//		Product product=(Product)productDAO.getProduct(productId);
//		
//		List<Product> listproducts=productDAO.listproducts();
//	    m.addAttribute("productList",listproducts);
//		m.addAttribute("ProductInfo",product);
//		return "UpdateProduct";
//	
//}
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
//	    m.addAttribute("productList",listproducts);
//		
//		
//		return"Product";
//	}
//	

}
