package com.catalog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.Entity.CatalogEntity;
import com.catalog.dto.CatalogDTO;
import com.catalog.exceptions.CatalogClassAllExceptions;
import com.catalog.repo.CatalogRepository;

@Service
public class CatalogServiceImpl implements ICatalogService {
	Logger loger= LoggerFactory.getLogger(CatalogServiceImpl.class);
	
	@Autowired
	public CatalogRepository repo;

	@Override
	public CatalogDTO saveCatalog(CatalogDTO catalog) {
		CatalogDTO dto=null;
		CatalogEntity entity=null;
		try {
			entity=new CatalogEntity();
			BeanUtils.copyProperties(catalog, entity);
			entity=repo.save(entity);
			dto=new CatalogDTO();
			BeanUtils.copyProperties(entity, dto);
		}catch (Exception e) {
			loger.info("Unable to Sava Catalog Details >>>",e);
			throw new CatalogClassAllExceptions(com.catalog.util.Constants.UNABLE_TO_SAVE);
		}
		return dto;
	
	}

	@Override
	public CatalogDTO updateCatalog(CatalogDTO catalog) {
		CatalogDTO dto=null;
		CatalogEntity entity=null;
		try {
			entity=new CatalogEntity();
			BeanUtils.copyProperties(catalog, entity);
			entity=repo.save(entity);
			dto=new CatalogDTO();
			BeanUtils.copyProperties(entity, dto);
		}catch (Exception e) {
			loger.info("Unable to Update Catalog Details >>>",e);
			throw new CatalogClassAllExceptions(com.catalog.util.Constants.UNABLE_TO_UPDATE);
		}
		return dto;
	}

	@Override
	public CatalogDTO editCatalog(Integer id) {
		CatalogDTO dto=null;
		CatalogEntity entity=null;
		try {
			entity=repo.getById(id);
			dto=new CatalogDTO();
			BeanUtils.copyProperties(entity, dto);
		}catch (Exception e) {
			loger.info("Unable to find catalog >>>",e);
		}
		return dto;
	}

	@Override
	public void deleteCatalog(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public List<CatalogDTO> getAllCatalogs() {
		List<CatalogDTO> lstCtlDto=null;
		List<CatalogEntity> lstCtlEntity=null;
		try {
			lstCtlEntity=repo.findAll();
			lstCtlDto=lstCtlEntity.stream().map(data->{
				CatalogDTO cDto=new CatalogDTO();
				BeanUtils.copyProperties(data, cDto);
				return cDto;
			}).collect(Collectors.toList());
		}catch (Exception e) {
			loger.info("Unable to featch Catalog Details >>>",e);
		}
		return lstCtlDto;
	}
	

	
}



























