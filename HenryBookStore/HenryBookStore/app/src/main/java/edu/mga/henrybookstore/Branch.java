package edu.mga.henrybookstore;

import com.google.gson.annotations.SerializedName;

public class Branch {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

    @SerializedName("state")
    private String state;

    @SerializedName("zip")
    private String zip;

    @SerializedName("phone")
    private String phone;

    public Branch(){
    }

    public Branch(Long id){
        this.id = id;
    }
    public Branch(String name, String address, String city,String state,String zip, String phone){
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    public String getZip() {
        return zip;
    }


    public String getPhone() {
        return phone;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name= name;
    }


    public void setAddress(String address) {
        this.address= address;
    }


    public void setCity(String city) {
        this.city= city;
    }

    public void setState(String state) {
        this.state= state;
    }

    public void setZip(String zip) {
        this.zip= zip;
    }


    public void setPhone(String phone) {
        this.phone= phone;
    }


    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

