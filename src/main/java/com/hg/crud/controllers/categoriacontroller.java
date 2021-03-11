package com.hg.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hg.crud.models.ProductDTO;
import com.hg.crud.models.categorias;
import com.hg.crud.repositories.CategoriaRepositoryDao;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api")
public class categoriacontroller {
	
	   @Autowired
	 
	     private CategoriaRepositoryDao repo;
	   
	   
	   
	   
	
	  @GetMapping("/categoria")
	    @ApiOperation(value = "Find an user", notes = "Return a user by Id" )

	    public List<categorias> getAllCategory(){

	        return repo.findAll();
	    }
	    
	    @PostMapping("/categoria")
	    public String saveCategory(@RequestBody categorias categoria){
	        repo.save(categoria);
	        return categoria.get_id();
	    }
	  /*  
		@PutMapping("/producto/{_id}")
		
		public categorias actualiza(@PathVariable String _id, @Validated @RequestBody categorias cate) {
			return repo.save(cate);
			
		}
	    */
	    
	    @GetMapping("/findcategorias/{_id}")
	    public Optional<categorias> getCategory(@PathVariable String _id) {
	        return repo.findById(_id);
	    }
	    @DeleteMapping("/delete/{id}")
	    public String deleteCategoria(@PathVariable String id){
	        repo.deleteById(id);
	        return "category deleted with id : " + id;
	    }

}
