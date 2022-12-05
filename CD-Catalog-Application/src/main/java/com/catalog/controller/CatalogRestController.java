package com.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.dto.CatalogDTO;
import com.catalog.exceptions.CatalogClassAllExceptions;
import com.catalog.service.ICatalogService;
import com.catalog.util.Constants;

@RestController
@RequestMapping("api/v1")
public class CatalogRestController {
	@Autowired
	public ICatalogService service;

	@PostMapping("/save")
	public ResponseEntity<CatalogDTO> saveCatalog(@RequestBody CatalogDTO entity) throws CatalogClassAllExceptions {
		ResponseEntity<CatalogDTO> respEntity = null;
		CatalogDTO empEntity = service.saveCatalog(entity);
		if (empEntity != null) {
			respEntity = new ResponseEntity<CatalogDTO>(empEntity, HttpStatus.OK);
		} else {
			respEntity = new ResponseEntity<CatalogDTO>(empEntity, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<CatalogDTO> updateCatalog(@RequestBody CatalogDTO entity) {
		ResponseEntity<CatalogDTO> respEntity = null;
		CatalogDTO empEntity = service.updateCatalog(entity);
		if (empEntity != null) {
			respEntity = new ResponseEntity<CatalogDTO>(empEntity, HttpStatus.OK);
		} else {
			respEntity = new ResponseEntity<CatalogDTO>(empEntity, HttpStatus.NOT_MODIFIED);
		}
		return respEntity;
	}

	@GetMapping("/catalog/{id}")
	public ResponseEntity<CatalogDTO> findByCatalogId(@PathVariable Integer id) {
		ResponseEntity<CatalogDTO> respEntity = null;
		CatalogDTO entity = service.editCatalog(id);
		if (entity != null) {
			respEntity = new ResponseEntity<CatalogDTO>(entity, HttpStatus.OK);
		} else {
			respEntity = new ResponseEntity<CatalogDTO>(entity, HttpStatus.NOT_FOUND);
		}
		return respEntity;

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CatalogDTO>> getAllCatalogsDetails() {
		ResponseEntity<List<CatalogDTO>> respEntity = null;
		List<CatalogDTO> enity = service.getAllCatalogs();
		if (enity != null) {
			respEntity = new ResponseEntity<List<CatalogDTO>>(enity, HttpStatus.OK);
		} else {
			respEntity = new ResponseEntity<List<CatalogDTO>>(enity, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return respEntity;
	}

	@DeleteMapping("/deleteid/{id}")
	public ResponseEntity<String> deleteByCatalogId(@PathVariable Integer id) {
		ResponseEntity<String> respEntity = null;
		try {
			service.deleteCatalog(id);
			respEntity = new ResponseEntity<String>(Constants.SUCCESSFULLY_DELETED, HttpStatus.OK);
		} catch (Exception e) {
			respEntity = new ResponseEntity<String>(Constants.UNABLE_TO_DELETE, HttpStatus.BAD_REQUEST);
		}
		return respEntity;
	}

}
