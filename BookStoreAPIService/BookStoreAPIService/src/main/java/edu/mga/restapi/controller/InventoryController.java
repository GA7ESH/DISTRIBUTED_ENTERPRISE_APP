package edu.mga.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mga.restapi.model.Book;
import edu.mga.restapi.model.Branch;
import edu.mga.restapi.model.Inventory;
import edu.mga.restapi.model.InventoryViewModel;
import edu.mga.restapi.service.BookService;
import edu.mga.restapi.service.BranchService;
import edu.mga.restapi.service.InventoryService;

@RestController
@RequestMapping(value = {
		 "/api"
		})
public class InventoryController {

	private static Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BranchService branchService;
	
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/inventory/create
	 * @Method Post
	 * @param   {
	 *				"bookId": 1,
	 * 				"branchId": 1,
	 * 				"quantity": 10
     * 			}
	 * @return
	 */		
	@RequestMapping(method=RequestMethod.POST, value="/inventory/create")
	public ResponseEntity addInventory(@Valid @RequestBody InventoryViewModel model) {
		logger.info("Branch: "+model);
		
		Book book = bookService.findBook(model.getBookId());
		Branch branch = branchService.findBranch(model.getBranchId());
		if (book != null && branch!=null) {
			Inventory inventory = inventoryService.addInventory(book, branch, model.getQuantity());		
			
			return new ResponseEntity<Object>("Successfully created!", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Cannot find book or branch", HttpStatus.BAD_REQUEST); 
		}	
		
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/inventory/{bookId}/{branchId}
	 * @Method GET
	 * @param   
	 * @return {
	 *				"bookId": 1,
	 * 				"branchId": 1,
	 * 				"quantity": 10
     * 			}
	 */		
	@RequestMapping(method=RequestMethod.GET, value="/inventory/{bookId}/{branchId}")
	public InventoryViewModel getInventory(@PathVariable Long bookId, @PathVariable Long branchId) {
		logger.info("bookid: "+bookId);
		logger.info("branchid: "+branchId);
		
		Book book = bookService.findBook(bookId);
		Branch branch = branchService.findBranch(branchId);
		
		Inventory inventory = inventoryService.findOne(book, branch);
		return new InventoryViewModel(inventory.getId().getBookId(), inventory.getId().getBranchId(), inventory.getQuantity());	
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/inventory/get
	 * @Method GET
	 * @param   
	 * @return [{
	 *				"bookId": 1,
	 * 				"branchId": 1,
	 * 				"quantity": 10
     * 			},
     * 			...
     * 		   ]
	 */
	@RequestMapping(method=RequestMethod.GET, value="/inventory/get")
	public List<InventoryViewModel> getAllInventory() {
		
		List<InventoryViewModel> model = new ArrayList<InventoryViewModel>();
				
		List<Inventory> inventory = inventoryService.getAllInventory();
		for(Inventory inv : inventory) {
			InventoryViewModel invModel = new InventoryViewModel(inv.getId().getBookId(), inv.getId().getBranchId(), inv.getQuantity());	
			model.add(invModel);
		}
		return model;
	}
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/inventory/update
	 * @Method PUT
	 * @param  {
	 *				"bookId": 1,
	 * 				"branchId": 1,
	 * 				"quantity": 10
     * 			} 
	 * @return "message"
	 * If bookId and branchId exists already, quantity will be updated.  
	 */	
	// Mark's Update
	// updated version
	@RequestMapping(method=RequestMethod.PUT, value="/inventory/update")
	public ResponseEntity<Object> updateInventory(@Valid @RequestBody InventoryViewModel model) {
        
		logger.info("bookid: "+model.getBookId());
		logger.info("branchid: "+model.getBranchId());
		logger.info("branchid: "+model.getQuantity());
		
		//Book book = bookService.findBook(bookId);
		//Branch branch = branchService.findBranch(branchId);		
		Inventory inv = inventoryService.findOne(model.getBookId(), model.getBranchId());
        
        //System.out.println("sd");

		if (inv != null && model.getQuantity() > 0) {
			//Inventory inventory = inventoryService.findOne(book, branch);
			inv.setQuantity(model.getQuantity());
			inventoryService.updateInventory(inv);
			
			return new ResponseEntity<Object>("Successfully updated!", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Cannot find book or branch or quantity is 0!", HttpStatus.BAD_REQUEST); 
		}
    }
	// Mark's Update
	
	/**
	 * @URL http://xxx.xxx.xxx.xxx:8080/inventory/{bookId}/{branchId}
	 * @Method DELETE
	 * @param   
	 * @return "message"
	 */		
	@RequestMapping(method=RequestMethod.DELETE, value="/inventory/{bookId}/{branchId}")
	public ResponseEntity<Object> deleteInventory(@PathVariable Long bookId, @PathVariable Long branchId) {
		
		logger.info("bookid: "+bookId);
		logger.info("branchid: "+branchId);
		
		Book book = bookService.findBook(bookId);
		Branch branch = branchService.findBranch(branchId);		

		if (book != null && branch!=null) {
			Inventory inventory = inventoryService.findOne(book, branch);
			inventoryService.deleteInventory(inventory);	
			
			return new ResponseEntity<Object>("Successfully created!", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Cannot find book or branch", HttpStatus.BAD_REQUEST); 
		}	
	}
}
