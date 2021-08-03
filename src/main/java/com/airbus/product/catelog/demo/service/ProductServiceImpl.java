package com.airbus.product.catelog.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airbus.product.catelog.demo.exceptions.ProductManipulationException;
import com.airbus.product.catelog.demo.exceptions.TokenExpiresException;
import com.airbus.product.catelog.demo.exceptions.UserNotFoundException;
import com.airbus.product.catelog.demo.models.Product;
import com.airbus.product.catelog.demo.models.ProductDTO;
import com.airbus.product.catelog.demo.models.UpdateProductDTO;
import com.airbus.product.catelog.demo.models.User;
import com.airbus.product.catelog.demo.repositories.ProductRepository;
import com.airbus.product.catelog.demo.repositories.UserRepository;

import io.jsonwebtoken.Claims;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	JWTTokenService jwtTokenService;
	
	
	public ProductServiceImpl() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	
	/**
	 * Method to list all existing products in the inventory
	 * @param token
	 * @throws UserNotFoundException
	 * @throws TokenExpiresException
	 *
	 */
	public List<ProductDTO> viewAllProduct() throws UserNotFoundException, TokenExpiresException {
		List<Product> productList=  productRepository.findAll();
		return productList.stream().map(list -> (modelMapper.map(list, ProductDTO.class))).collect(Collectors.toList());	
	}

	
	
	
	
	/**
	 * Method to list product of certain category
	 * @param category
	 * @param token 
	 *
	 */
	public List<ProductDTO> viewProduct(String category, String token) throws UserNotFoundException, TokenExpiresException {
		validateUser(token);
		
		List<Product> productListWithCategory = productRepository.findAllByProductCategory(category);
		return productListWithCategory.stream().map(list -> (modelMapper.map(list, ProductDTO.class))).collect(Collectors.toList());
		
		
	}
	
	/**
	 * Method to add a new product
	 * @param productDTO
	 * @param token
	 *
	 */
	public ProductDTO addProduct(ProductDTO productDTO, String token) throws UserNotFoundException, TokenExpiresException, ProductManipulationException {
		
		//validateUser(token);
		Product productToSave= modelMapper.map(productDTO, Product.class);
		
		Product product =  productRepository.save(productToSave);
		if(product==null) {
			throw new ProductManipulationException("Error encountered while saving product");
		}
		return modelMapper.map(product, ProductDTO.class);
	
	}

	
	
	


	/**
	 *Method to update an existing product
	 *@param productId
	 *@param updateProductDTO
	 *@param token
	 */
	public ProductDTO updateProduct(ProductDTO updateProductDTO, String token) throws UserNotFoundException, TokenExpiresException, ProductManipulationException {
	//	validateUser(token);
		System.out.println("delete proceed" + updateProductDTO.getProductId());
	    productRepository.deleteByProductId(updateProductDTO.getProductId());
	    Product product = productRepository.save(modelMapper.map(updateProductDTO, Product.class));
	    return modelMapper.map(product, ProductDTO.class);
	}

	
	public ProductDTO viewProductById(String productId) {
		System.out.println("Product Id" + productId);
		Optional<Product> optionalProduct= productRepository.findAllByProductId(productId);
	
		return modelMapper.map(optionalProduct.get(), ProductDTO.class);
	}
	
	
	/**
	 * Method to validate user's session using JWT token
	 * @param token
	 * @throws UserNotFoundException
	 * @throws TokenExpiresException
	 */
	public void validateUser(String token) throws UserNotFoundException, TokenExpiresException {
		System.out.println("token :" + token);
		if(jwtTokenService.isTokenExpired(token)) {
			throw new TokenExpiresException("Token is expired and is no longer valid");
		}
		Claims claims = jwtTokenService.parseJwt(token);
		Optional<User> optionalUser = userRepository.findById(claims.getId());
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		
	}



	
	
}
