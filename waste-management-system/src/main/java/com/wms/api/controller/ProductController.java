package com.wms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.api.dto.ProductCategoryDTO;
import com.wms.api.enums.SecurityError;
import com.wms.api.exception.ApplicationCustomException;
import com.wms.api.response.BaseResponse;
import com.wms.api.service.ProductService;

/**
 * This is the controller class with have all the functionality of the product
 * related
 * 
 * @author arifk2
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

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
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> getbalanceResponse(@RequestBody ProductCategoryDTO productCategoryDTO)
			throws NoSuchMessageException, ApplicationCustomException {
		final ProductCategoryDTO productCategoryResponseDTO = productService
				.saveProductWithCategory(productCategoryDTO);
		if (productCategoryResponseDTO != null) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					messageSource.getMessage("product.save.with.category", null, null), productCategoryResponseDTO),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.BAD_REQUEST.value(),
					SecurityError.OPERATION_FAILED.getDescription(), null), HttpStatus.BAD_REQUEST);
		}
	}
}
