package com.wms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.enums.SecurityError;
import com.wms.api.exception.ApplicationCustomException;
import com.wms.api.response.BaseResponse;
import com.wms.api.service.ProductCategoryService;

/**
 * This is the controller class with have all the functionality of the product
 * related
 * 
 * @author arifk2
 *
 */
@RestController
@RequestMapping("/product-category")
public class ProductController {

	@Autowired
	private ProductCategoryService productService;

	@Autowired
	private MessageSource messageSource;

	/**
	 * This api is created to save the product with the category
	 * 
	 * @param productCategoryDTO holds the information of the product and category
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO)
			throws NoSuchMessageException, ApplicationCustomException {
		final ProductCategoryDTO productCategoryResponseDTO = productService.saveProductCategory(productCategoryDTO);
		if (productCategoryResponseDTO != null) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					messageSource.getMessage("product.save.with.category", null, null), productCategoryResponseDTO),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.OPERATION_FAILED.getDescription(), null), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This api is created to get the product category information
	 * 
	 * @param productCategoryDTO
	 * @return
	 * @throws NoSuchMessageException
	 * @throws ApplicationCustomException
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/get-product-category-info", method = RequestMethod.POST)
	public ResponseEntity<?> getProductCategory(@RequestBody ProductCategoryDTO productCategoryDTO)
			throws NoSuchMessageException, ApplicationCustomException {
		final ProductCategoryDTO productCategoryResponseDTO = productService.getProductCategory(productCategoryDTO);
		if (productCategoryResponseDTO != null) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					messageSource.getMessage("product.category.information", null, null), productCategoryResponseDTO),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.OPERATION_FAILED.getDescription(), null), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<?> getProductCategories() {
		final List<ProductCategoryDTO> productCategoryResponseDTO = productService.getProductCategory();
		if (productCategoryResponseDTO != null) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					messageSource.getMessage("product.category.list", null, null), productCategoryResponseDTO),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.OPERATION_FAILED.getDescription(), null), HttpStatus.BAD_REQUEST);
		}
	}
}
