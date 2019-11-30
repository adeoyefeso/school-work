/*
Adeoluwa Oyefeso
105114057
Sunday 17th November 2019
 */

public abstract class Item {
    //all variables in this class are protected so they can be accessed outside the class by any class that extends item

    protected int item_id; //declaring variable item id with return type int
    protected double price; //declaring variable price with return type double
    protected int quantity; //declaring variable quantity with return type int
    protected String title; //declaring variable title with return type String

    public abstract void display(); //abstract method to be implemented in every class that extends item

    public void purchase() {
        quantity--; //When the user makes the purchase of an item, the quantity is reduced by one
    }

    //get and set methods for item id, price, quantity and title
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}