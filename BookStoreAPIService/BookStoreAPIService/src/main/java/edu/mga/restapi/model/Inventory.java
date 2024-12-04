package edu.mga.restapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="inventory")
public class Inventory {
	
	@Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 1322120000551624359L;
        
        @Column(name = "book_id")
        protected Long bookId;        
        
        @Column(name = "branch_id")
        protected Long branchId;
        
        public Id() { }

        public Id(Long bookId, Long branchId) {
            this.bookId = bookId;
            this.branchId = branchId;
        }
               
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

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hash(bookId, branchId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			 
	        if (obj == null || getClass() != obj.getClass()) 
	            return false;
	 
	        Id that = (Id) obj;
	        return Objects.equals(bookId, that.bookId) && 
	               Objects.equals(branchId, that.branchId);
		}    
    }
	
	@EmbeddedId
    Id id = new Id();
    
    public void setId(Id id) {
		this.id = id;
	}
	public Id getId() {
		return id;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("branchId")
    private Branch branch;

	@Column(name="quantity")
	private int quantity;

    private Inventory() {}
    
    public Inventory(Book book, Branch branch) {
    	this.book = book;
    	this.branch = branch;
    	this.id = new Id(book.getId(), branch.getId());
    }
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Inventory that = (Inventory) o;
        return Objects.equals(book, that.book) &&
               Objects.equals(branch, that.branch);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(book, branch);
    }
	
}
