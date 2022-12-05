package com.catalog.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Setter
@Getter
@ToString
@Table(name = "CD_CATALOG")
public class CatalogEntity {
   @Id
   @GeneratedValue
	
   @Column(name="ID")
   private Integer id;
   @Column(name="TITLE")
   private String title;
   @Column(name="ARTIST")
   private String artist;
   @Column(name="COMPANY")
   private String company;
   @Column(name="COUNTRY")
	private String contry;
   @Column(name="YEAR")
   private String year;
   @Column(name="PRICE")
   private Double price;
	
}
