package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="SupplierDetail")

public class Supplier {
	
		@Id
		@GeneratedValue
		int supplierId;
		String supplierName;
		String supplierAddrs;
		public int getSupplierId() {
			return supplierId;
		}
		public void setSupplierId(int supplierId) {
			this.supplierId = supplierId;
		}
		public String getSupplierName() {
			return supplierName;
		}
		public void setSupplierName(String supplierName) {
			this.supplierName = supplierName;
		}
		public String getSupplierAddrs() {
			return supplierAddrs;
		}
		public void setSupplierAddrs(String supplierAddrs) {
			this.supplierAddrs = supplierAddrs;
		}
		

}
