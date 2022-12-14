package com.catalog.service;

import java.util.List;

import com.catalog.dto.CatalogDTO;

public interface ICatalogService {
	public CatalogDTO saveCatalog(CatalogDTO catalog);
	public CatalogDTO updateCatalog(CatalogDTO catalog);
	public CatalogDTO editCatalog(Integer id);
	public void deleteCatalog(Integer id);
	public List<CatalogDTO> getAllCatalogs();

}
