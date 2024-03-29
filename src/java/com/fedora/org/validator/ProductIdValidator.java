package com.fedora.org.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fedora.org.domain.Product;
import com.fedora.org.exception.ProductNotFoundException;
import com.fedora.org.service.ProductService;
import org.springframework.stereotype.Component;


@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String>{
	
	@Autowired
	private ProductService productService;

	public void initialize(ProductId constraintAnnotation) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Product product;
		try {
			product = productService.getProductById(value);
			
		} catch (ProductNotFoundException e) {
			return true;
		}
		
		if(product!= null) {
			return false;
		}
		
		return true;
	}
	
}
