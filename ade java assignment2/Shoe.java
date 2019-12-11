public class Shoe extends Item {

    private double size; //declaring variable size with return type double
    private Colour colour; //declaring variable colour

    @Override
    public void display() { //abstract method from item
        System.out.println("Title: " + title + "\nItem_Id: " + item_id + "\nQuantity: " + quantity + "\nPrice: " + price
                + "\nSize: " + size + "\nColour: " + colour);
    }

    //get and set methods for size and colour
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

}