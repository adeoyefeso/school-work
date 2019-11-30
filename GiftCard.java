public class GiftCard extends Item{

    //declaring variables label and manufacturer both with string return type
    private String label;
    private String manufacturer;

    @Override
    public void display() { //abstract method from item
        System.out.println("Title: " + title + "\nItem_Id: " + item_id + "\nQuantity: " + quantity + "\nPrice: " + price
                + "\nLabel: " + label + "\nManufacturer: " + manufacturer); //added on label and manufacturer
    }

    //get and set methods for label and manufacturer
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}