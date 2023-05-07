package com.axsos.ProductsAndCategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.axsos.ProductsAndCategories.models.Category;

import com.axsos.ProductsAndCategories.models.Product;
import com.axsos.ProductsAndCategories.services.AppService;

import jakarta.validation.Valid;

@Controller
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
        this.appService= appService;
    }
	
	@GetMapping("/")
    public String index(Model model) {
		List<Product> allProducts=appService.allProducts();
      	 model.addAttribute("allproducts",allProducts);
      	 
      	List<Category> allCategories=appService.allCategories();
     	 model.addAttribute("allcategories",allCategories);
     	 
        return "index.jsp";
    }
	
	@GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "createProduct.jsp";
    }
	
	@GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "createCategory.jsp";
    }
	
	@PostMapping("/newproduct")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
            if (result.hasErrors()) {
                return "createProduct.jsp";
            }
            else {
                appService.createProduct(product);
                return "redirect:/";
            }
        }
	
	@PostMapping("/newcategory")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
            if (result.hasErrors()) {
                return "createCategory.jsp";
            }
            else {
                appService.createCategory(category);
                return "redirect:/";
            }
        }
	
	@GetMapping("/products/{id}")
    public String viewProduct(@PathVariable("id") Long id,Model model,@ModelAttribute("product") Product product) {
	 Product product1 = appService.findProduct(id);
     model.addAttribute("product",product1);
     List<Category> missingCategories=appService.findCategoriesNotContains(product1);
 	 model.addAttribute("missingcategories",missingCategories);
 	List<Category> existingCategories=appService.findCategoriesByProduct(product1);
	 model.addAttribute("existingcategories",existingCategories);
        return "viewProduct.jsp";
    }
	
	@GetMapping("/categories/{id}")
    public String viewCategory(@PathVariable("id") Long id,Model model,@ModelAttribute("category") Category category) {
	 Category category1 = appService.findCategory(id);
     model.addAttribute("category",category1);
     List<Product> missingProducts=appService.findProductsNotContains(category1);
 	 model.addAttribute("missingproducts",missingProducts);
 	List<Product> existingProducts=appService.findProductssByCategory(category1);
	 model.addAttribute("existingproducts",existingProducts);
        return "viewCategory.jsp";
    }
	
//	@PostMapping("/addproduct")
//    public String addProduct(  @RequestParam(value = "prodid") Long prodId, @RequestParam(value = "catid") Long catId) {
//		Product product1 = appService.findProduct(prodId);
//		Category category1 = appService.findCategory(catId);
//		List<CategoryProduct> catprods = category1.getProducts();
//		catprods.
//		
//        }
	
	
	
}
