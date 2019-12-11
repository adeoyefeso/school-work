public class Book extends Item {

    private String author; //declaring variable author with a string return type
    private String year; //declaring variable year with a string return type

    @Override
    public void display() { //abstract method from item
        System.out.println("Title: " + title + "\nItem_Id: " + item_id + "\nQuantity: " + quantity + "\nPrice: " + price
                + "\nAuthor: " + author + "\nYear: " + year); //added on author and year
    }

    //get and set methods for author and year
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}