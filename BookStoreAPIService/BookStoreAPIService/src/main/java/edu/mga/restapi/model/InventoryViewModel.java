package edu.mga.restapi.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InventoryViewModel {
	
	@NotNull(message="bookId is missing!")
	@Min(value = 1)
	private Long bookId;        
    
	@NotNull(message="branchId is missing!")
	@Min(value = 1)
    private Long branchId;
    
	@NotNull(message="quantity is missing!")
	@Min(value = 1)
    private Integer quantity;

	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
       
	public InventoryViewModel() {}
	public InventoryViewModel(@NotNull(message = "bookId is missing!") @Min(1) Long bookId,
			@NotNull(message = "branchId is missing!") @Min(1) Long branchId,
			@NotNull(message = "quantity is missing!") @Min(1) Integer quantity) {
		super();
		this.bookId = bookId;
		this.branchId = branchId;
		this.quantity = quantity;
	}
	    
}
