package com.simplilearn.KitchenStory.entities;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property= "pid")
public class Product {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="pid")
		private Long pid;
		
		@Column(name = "sku")
		private String sku;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "price")
		private BigDecimal price;
		
		@Column(name = "image_url")
		private String imageUrl;
		
		@Column(name = "is_available")
		private boolean isAvailable;
		
		@Column(name = "units_in_stock")
		private int unitsInStock;
		
		@Column(name = "date_created")
		@CreationTimestamp
		private Date dateCreated;
		
		@Column(name = "last_updated")
		@UpdateTimestamp
		private Date lastUpdated;
		
		@ManyToOne
		@JoinColumn(name="category_id")
		
		private ProductCategory category;

		public Product() {
			
		}


		public Product(Long pid, String sku, String name, String description, BigDecimal price, String imageUrl,
				boolean isAvailable, int unitsInStock, Date dateCreated, Date lastUpdated, ProductCategory category) {
			super();
			this.pid = pid;
			this.sku = sku;
			this.name = name;
			this.description = description;
			this.price = price;
			this.imageUrl = imageUrl;
			this.isAvailable = isAvailable;
			this.unitsInStock = unitsInStock;
			this.dateCreated = dateCreated;
			this.lastUpdated = lastUpdated;
			this.category = category;
		}

		public Long getPid() {
			return pid;
		}

		public void setPid(Long pid) {
			this.pid = pid;
		}

		public String getSku() {
			return sku;
		}

		public void setSku(String sku) {
			this.sku = sku;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public boolean isAvailable() {
			return isAvailable;
		}

		public void setAvailable(boolean isAvailable) {
			this.isAvailable = isAvailable;
		}

		public int getUnitsInStock() {
			return unitsInStock;
		}

		public void setUnitsInStock(int unitsInStock) {
			this.unitsInStock = unitsInStock;
		}

		public Date getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
		}

		public Date getLastUpdated() {
			return lastUpdated;
		}

		public void setLastUpdated(Date lastUpdated) {
			this.lastUpdated = lastUpdated;
		}
		
		public ProductCategory getCategory() {
			return category;
		}

		public void setCategory(ProductCategory category) {
			this.category = category;
		}
		
		
		
		
		
		

}
