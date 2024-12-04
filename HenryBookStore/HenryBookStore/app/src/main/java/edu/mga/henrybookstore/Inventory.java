package edu.mga.henrybookstore;

import com.google.gson.annotations.SerializedName;

public class Inventory {

    @SerializedName("bookId")
    private String bookId;

    @SerializedName("branchId")
    private String branchId;

    @SerializedName("quantity")
    private String quantity;


    public Inventory(){
    }
    public Inventory(String bookId, String branchId,String quantity){
        this.bookId = bookId;
        this.branchId = branchId;
        this.quantity = quantity;
    }


    public String getBookId() {
        return bookId;
    }

    public String getBranchId() {
        return branchId;
    }
    public String getQuantity() {
        return quantity;
    }


    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "author=" + bookId +
                ", title='" + branchId + '\'' +
                ", description='" + quantity + '\'' +
                '}';
    }
}

