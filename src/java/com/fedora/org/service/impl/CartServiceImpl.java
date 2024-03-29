package com.fedora.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedora.org.domain.Cart;
import com.fedora.org.exception.InvalidCartException;
import com.fedora.org.repository.CartRepository;
import com.fedora.org.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	public Cart create(Cart cart) {
		return cartRepository.create(cart);
	}

	public Cart read(String cartId) {
		return cartRepository.read(cartId);
	}

	public void update(String cartId, Cart cart) {
		cartRepository.update(cartId, cart);
	}

	public void delete(String cartId) {
		cartRepository.delete(cartId);
		
	}
	
	public Cart validate(String cartId) {
		Cart cart = cartRepository.read(cartId);
		if(cart==null || cart.getCartItems().size()==0) {
			throw new InvalidCartException(cartId);
		} 
		
		return cart;
	}

}
