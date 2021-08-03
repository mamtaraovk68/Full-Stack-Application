package com.airbus.product.catelog.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.airbus.product.catelog.demo.exceptions.ProductManipulationException;
import com.airbus.product.catelog.demo.exceptions.TokenExpiresException;
import com.airbus.product.catelog.demo.exceptions.UserNotFoundException;
import com.airbus.product.catelog.demo.models.ProductDTO;
import com.airbus.product.catelog.demo.models.UpdateProductDTO;
import com.airbus.product.catelog.demo.service.ProductServiceImpl;

import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j;

/**
 * @author mamtarao9395@gmail.com
 *
 */
@Controller
@Log4j
public class ProductCatalogController {


	@Autowired
	ProductServiceImpl productService;

	/**
	 * Method to list all the products in the catalog
	 * @param request
	 * @return
	 * @throws UserNotFoundException 
	 * @throws TokenExpiresException 
	 */
	@GetMapping("/getAll")
	public String viewAllProducts(Model model,HttpServletRequest request) throws UserNotFoundException, TokenExpiresException{
		List<ProductDTO> productList =  productService.viewAllProduct();
		model.addAttribute("productList", productList);
		return "productList";
		
	}
	

	/**'Method to list all the product with a particular category
	 * @param category
	 * @param request
	 * @return
	 * @throws TokenExpiresException 
	 * @throws UserNotFoundException 
	 */
	@GetMapping("/get/{category}")
	public  Iterable<ProductDTO> viewProduct(@PathVariable String category, HttpServletRequest request ) throws UserNotFoundException, TokenExpiresException{
		
		return productService.viewProduct(category, request.getHeader("AUTH_HEADER_TOKEN"));
	
	}
	
	/**
	 * Method to add a new product in the catalog
	 * @param productDTO
	 * @param request
	 * @return
	 * @throws TokenExpiresException 
	 * @throws UserNotFoundException 
	 * @throws ProductManipulationException 
	 */
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("productDTO") ProductDTO productDTO, HttpServletRequest request) throws UserNotFoundException, TokenExpiresException, ProductManipulationException {

		productService.addProduct(productDTO, request.getHeader("AUTH_HEADER_TOKEN"));
		
		return "redirect:getAll";
		
	}
	
	/**
	 * Method to update the existing product in the catalog
	 * @param productId
	 * @param request
	 * @return
	 * @throws ProductManipulationException 
	 * @throws TokenExpiresException 
	 * @throws UserNotFoundException 
	 */
	@PostMapping("/update/{productId}")
	public RedirectView updateProduct(@PathVariable("productId") String productId, ProductDTO product,  HttpServletRequest request,RedirectAttributes redirectAttributes) throws UserNotFoundException, TokenExpiresException, ProductManipulationException {
		
		productService.updateProduct(product, request.getHeader("AUTH_HEADER_TOKEN"));
		RedirectView redirectView=new RedirectView("/getAll",true);
        redirectAttributes.addFlashAttribute("userMessage","product updated!!!");
        return redirectView;
	
	}

	
	
	 @GetMapping("/showFormForUpdate/{productId}")
	    public String showFormForUpdate(@PathVariable("productId") String productId, Model model) {
	        ProductDTO product = productService.viewProductById(productId);
	        // set product as a model attribute to pre-populate the form
	        model.addAttribute("product", product);
	        return "update_product";
	    }
	 
	@GetMapping("/showNewProductForm")
	 public String showNewEmployeeForm(Model model) {
	        // create model attribute to bind form data
	        ProductDTO productDTO = new ProductDTO();
	        model.addAttribute("productDTO", productDTO);
	        return "new_product";
	    }
	
	
}
