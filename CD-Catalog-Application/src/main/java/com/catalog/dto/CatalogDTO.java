package com.catalog.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
public class CatalogDTO {
	private Integer id;
	private String title;
    private String company;
	private String artist;
	private String contry;
	private String year;
	private Double price;


}
