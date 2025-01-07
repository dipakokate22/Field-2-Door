/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class Product {
    private int id;
    private String Name;
    private String detail;
    private String category;
    private Double price;
    private String Quantity;
    private String discount;
    private String image;
    
    public Product()
    {
        
    }
    
    public Product(int id ,String detail,String Name, String category,Double price,String Quantity,String discount,String image)          
    {
        
        this.id= id;
        this.Name= Name;
        this.detail=detail;
        this.category=category;
        this.price=price;
        this.Quantity=Quantity;
        this.discount=discount;
        this.image=image;
    }    

 
    
   

    /**
     * @return the Name
     */
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
        
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the Quantity
     */
    public String getQuantity() {
        return Quantity;
    }

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    
     

    /**
     * @return the id
     */
    
    
     public String toString()
   {
       return "Product[Name="+Name+", detail="+detail+" , category="+category+",price="+price+",Quantity="+Quantity+",discount="+discount+", image="+image+",id ="+id+"]";
    }
    
    
}
