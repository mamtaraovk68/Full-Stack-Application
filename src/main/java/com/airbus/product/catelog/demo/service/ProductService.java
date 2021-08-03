package com.airbus.product.catelog.demo.service;

import java.util.List;

import com.airbus.product.catelog.demo.exceptions.ProductManipulationException;
import com.airbus.product.catelog.demo.exceptions.TokenExpiresException;
import com.airbus.product.catelog.demo.exceptions.UserNotFoundException;
import com.airbus.product.catelog.demo.models.ProductDTO;
import com.airbus.product.catelog.demo.models.UpdateProductDTO;

public interface ProductService {
	
	
	/**
	 * @param userid
	 * @return
	 * @throws UserNotFoundException 
	 * @throws TokenExpiresException 
	 */
	public List<ProductDTO> viewAllProduct() throws UserNotFoundException, TokenExpiresException;
	
	/**
	 * @param category
	 * @param userId
	 * @return
	 * @throws TokenExpiresException 
	 * @throws UserNotFoundException 
	 */
	public List<ProductDTO> viewProduct(String category, String userId) throws UserNotFoundException, TokenExpiresException;
	
	/**
	 * @param productDTO
	 * @param header
	 * @return
	 * @throws TokenExpiresException 
	 * @throws UserNotFoundException 
	 * @throws ProductManipulationException 
	 */
	public ProductDTO addProduct(ProductDTO productDTO, String header) throws UserNotFoundException, TokenExpiresException, ProductManipulationException;
	
	/**
	 * @param productId
	 * @param header
	 * @return
	 * @throws TokenExpiresException 
	 * @throws UserNotFoundException 
	 * @throws ProductManipulationException 
	 */
	public ProductDTO updateProduct(ProductDTO updateProductDTO, String token) throws UserNotFoundException, TokenExpiresException, ProductManipulationException;

}
