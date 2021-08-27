package com.proyecto.proyecto.rest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dao.ContactsDAO;
import com.proyecto.proyecto.entidades.Contacts;

@RestController
@RequestMapping("products")
public class ContactsREST {
	
	
	@Autowired
	private  ContactsDAO productDao;
	
	
	
	
	//@GetMapping
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping
	public ResponseEntity<List<Contacts>> getContacts() {
		
		
		List<Contacts> contacts = productDao.findAll();
		
		
		return ResponseEntity.ok(contacts);
		
		
	}
	
	
	
	
	//@GetMapping
	@RequestMapping(value= "{contactId}")
	public ResponseEntity<Contacts> getProductById(@PathVariable("contactId") Long productId) {
	
	
	
		
	Optional<Contacts> optionalContact = productDao.findById(productId);
			
			
	if (optionalContact.isPresent()) {
		
		
		return ResponseEntity.ok(optionalContact.get());
		
		
	} else  {
		
		
		return ResponseEntity.noContent().build();
		
	}
		
  }
	
	     @PostMapping
         public ResponseEntity<Contacts> createProduct(@RequestBody Contacts contact) {
		
	
        	 
        	 Contacts newProduct = productDao.save(contact);
		
		
		return ResponseEntity.ok(newProduct);
		
		
	  }
	
	     
	    @DeleteMapping (value ="{contactId}")
        public ResponseEntity<Void> deleteProduct(@PathVariable("contactId") Long contactId) {
		
	
        	 
        	 productDao.deleteById(contactId);
		
		
		return ResponseEntity.ok(null);
		
		
	  }
	    
	    @PutMapping
	    public ResponseEntity<Contacts> updateContact (@RequestBody Contacts contact){
	    	
	    	Optional<Contacts> optionalContact = productDao.findById(contact.getId());
	    	
	    	 if (optionalContact.isPresent()) {
	    		 
	    		 
	    		 Contacts updateContact = optionalContact.get();
	    		 
	    		 updateContact.getName();
	    		 
	    		 productDao.save(updateContact);
	    		 
	    		 return ResponseEntity.ok(updateContact);
	    		 
	    	 } else {
	    		 
	    		 
	    		 return ResponseEntity.notFound().build();
	    	 }
	    	
	    	 
	    	
	    }
	
}
