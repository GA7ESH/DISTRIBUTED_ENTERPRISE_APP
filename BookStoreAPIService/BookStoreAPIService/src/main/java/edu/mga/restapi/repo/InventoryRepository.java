package edu.mga.restapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mga.restapi.model.Inventory;

//import edu.mga.restapi.repo.Inventory;



public interface InventoryRepository extends JpaRepository<Inventory, Long> {

	
	@Query("select i from Inventory i where i.id.bookId = :bookId and i.id.branchId = :branchId")
    public List<Inventory> findByBookIdAndBranchId(@Param("bookId") Long bookId, @Param("branchId") Long branchId); 
	
	// this is not needed
	// Mark's Update	
	//@Query("select i from Inventory i where i.id.bookId = :bookId and i.id.branchId = :branchId")
	//public Inventory updateByBookIdAndBranchId(@Param("bookId") Long bookId, @Param("branchId") Long branchId); 	
	// Mark's Update
	
	@Query("delete from Inventory i where i.id.bookId = :bookId and i.id.branchId = :branchId")
    public void deleteByBookIdAndBranchId(@Param("bookId") Long bookId, @Param("branchId") Long branchId); 
}
