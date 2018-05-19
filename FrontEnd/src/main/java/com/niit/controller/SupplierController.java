package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;



@Controller
public class SupplierController {
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/Supplier")
	public String showSupplier(Model m) {
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	    m.addAttribute("supplierList",listSuppliers);
		return "Supplier";
	}
	
	@RequestMapping(value="/InsertSupplier",method=RequestMethod.POST)
	 public String addSupplier(@RequestParam("supname")String supname,@RequestParam("supaddr")String supaddr,Model m) {
		
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supname);
		supplier.setSupplierAddrs(supaddr);
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	    m.addAttribute("supplierList",listSuppliers);
		return "Supplier";
	}
	
	@RequestMapping("/deleteSupplier/{supplierId}")
	public String deletesupplier(@PathVariable("supplierId")int supplierId, Model m ) {
		Supplier supplier=(Supplier)supplierDAO.getSupplier(supplierId);
		supplierDAO.deleteSupplier(supplier);
		
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	    m.addAttribute("supplierList",listSuppliers);
		return "Supplier";
		
}
	
	
	@RequestMapping("/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")int supplierId, Model m ) {
		Supplier supplier=(Supplier)supplierDAO.getSupplier(supplierId);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	    m.addAttribute("supplierList",listSuppliers);
		
		m.addAttribute("supplierInfo",supplier);
		return "UpdateSupplier";
	
}
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("supid")String supplierId,@RequestParam("supname")String supname,@RequestParam("supaddr")String supaddr,Model m) {
		
		int supplierid=Integer.parseInt(supplierId);
		Supplier supplier=(Supplier)supplierDAO.getSupplier(supplierid);
		
		

		supplier.setSupplierName(supname);
		supplier.setSupplierAddrs(supaddr);
		supplierDAO.updateSupplier(supplier);
		
	
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
	    m.addAttribute("supplierList",listSuppliers);
	
		
		return"Supplier";
	}
	


}
