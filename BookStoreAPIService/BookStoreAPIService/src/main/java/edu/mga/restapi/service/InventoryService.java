package edu.mga.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mga.restapi.model.Book;
import edu.mga.restapi.model.Branch;
import edu.mga.restapi.model.Inventory;
import edu.mga.restapi.repo.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	protected InventoryRepository inventoryRepository;
	
	public Inventory addInventory(Book book, Branch branch, Integer quantity) {		
		Inventory inventory = new Inventory(book, branch);
		inventory.setQuantity(quantity);
		return inventoryRepository.saveAndFlush(inventory);
	}
	
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();
	}
	
	public Inventory findOne(Book book, Branch branch){
		List<Inventory> result = inventoryRepository.findByBookIdAndBranchId(book.getId(), branch.getId());		
		return result.size() > 0 ? result.get(0) : null;
	}
	
	// added method
	public Inventory findOne(Long bookId, Long branchId){
		List<Inventory> result = inventoryRepository.findByBookIdAndBranchId(bookId, branchId);		
		return result.size() > 0 ? result.get(0) : null;
	}
	
	// Mark's Update
	
	public Inventory updateInventory(Inventory inventory) {
		return	inventoryRepository.saveAndFlush(inventory);
	}	
	
	// Mark's Update
	
	public void deleteInventory(Inventory inventory) {
		inventoryRepository.delete(inventory);
	}
}
