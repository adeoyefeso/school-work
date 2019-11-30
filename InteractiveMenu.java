import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InteractiveMenu { //main class where the user can add items, display items, delete items or purchase items

    //add static item method that contains a switch statement which allows the user to enter what item they want to add to the list
    private static List<Item> addItems(int count, List<Item> items) {
        Scanner scan = new Scanner(System.in); //creating object called scan, takes user input
        System.out.println("1. Add a Book\n 2. Add a Gift Card\n 3. Add a Shoe\n"); //user selects what item they want to add to the list
        String Input = scan.nextLine(); //scans user input

        //switch statement which takes the users input as its parameter and depending on what the user enters, an action is performed and the 'break' statement terminates the loop
        switch(Input) {
            case "1": //if the user selects 1, they are sent to the addBook method
                items.add(addBooks(count));
                break;
            case "2": //if the user selects 2, they are sent to the addGiftCard method
                items.add(addGiftCards(count));
                break;
            case "3": //if the user selects 3, they are sent to the addShoe method
                items.add(addShoes(count));
                break;
        }

        return items; //returns the item added by the user

    }

    //static add book method
    private static Item addBooks(int count) {
        Scanner scan = new Scanner(System.in); //scan object that takes user input
        Book book = new Book(); //book object created

        //User is asked to enter title, price, quantity, author and year the book was created
        System.out.println("\nEnter the title: \n");
        book.setTitle(scan.nextLine());
        System.out.println("Enter the Price: \n");
        book.setPrice(scan.nextDouble());
        System.out.println("Enter the Quantity: \n");
        book.setQuantity(scan.nextInt());
        System.out.println("Enter name of Author: \n");
        book.setAuthor(scan.next());
        System.out.println("Enter Year created: \n");
        book.setYear(scan.next());
        book.setItem_id(count);

        return book; //after all the data has been stored, the book created is returned

    }

    //static add gift card method
    private static Item addGiftCards(int count) {
        Scanner scan = new Scanner(System.in); //scan object that takes user input
        GiftCard giftCard = new GiftCard(); //gift card object created

        //User is asked to enter title, price, quantity, label and manufacturer
        System.out.println("\nEnter the title: \n");
        giftCard.setTitle(scan.nextLine());
        System.out.println("Enter the Price: \n");
        giftCard.setPrice(scan.nextDouble());
        System.out.println("Enter the Quantity: \n");
        giftCard.setQuantity(scan.nextInt());
        System.out.println("Enter the Label: \n");
        giftCard.setLabel(scan.next());
        System.out.println("Enter name of Manufacturer: \n");
        giftCard.setManufacturer(scan.next());
        giftCard.setItem_id(count);

        return giftCard; //after all the data is stored, the gift card created is returned

    }

    //static add shoe method
    private static Item addShoes(int count) {
        Scanner scan = new Scanner(System.in); //scan object that takes user input
        Shoe shoe = new Shoe(); //shoe object created

        //User is asked to enter title, price, quantity, colour and size
        System.out.println("\nEnter the title: \n");
        shoe.setTitle(scan.nextLine());
        System.out.println("Enter the Price: \n");
        shoe.setPrice(scan.nextDouble());
        System.out.println("Enter the Quantity: \n");
        shoe.setQuantity(scan.nextInt());
        System.out.println("Enter Colour of the shoe: \n");
        String colour = scan.next();
        shoe.setColour(Colour.valueOf(colour));
        System.out.println("Enter the Size of the shoe: \n");
        shoe.setSize(scan.nextDouble());
        shoe.setItem_id(count);

        return shoe; //after all the data entered is stored, the shoe created is returned

    }

    //static method to display all the items in the list
    private static void displayAllItems(List<Item> items) {
        for(Item item:items) {
            item.display(); //calling the display method in item class
        }

    }

    //static method to display only books
    private static void displayOnlyBooks(List<Item> items) {
        for(Object item:items) {
            if(item instanceof Book) {
                ((Book) item).display(); //calling the display item from book class
            }
        }
    }

    //static method to display only gifts
    private static void displayOnlyGiftCards(List<Item> items) {
        for(Object item:items) {
            if(item instanceof GiftCard) {
                ((GiftCard) item).display(); //calling the display method from gift card class
            }
        }
    }

    //static method to display only shoes
    private static void displayOnlyShoes(List<Item> items) {
        for(Object item:items) {
            if(item instanceof Shoe) {
                ((Shoe) item).display(); //calling the display method from shoe class
            }
        }
    }

    //static method that allows the user to delete an item from the list
    private static void deleteItem(int itemId, List<Item> items) {
        for(Item item: items) {
            if(item.getItem_id() == itemId) {
                items.remove(item);
            }
        }
    }

    //static method to purchase an item
    private static void purchaseItem(int itemId, List<Item> items) {
        for(Item item: items) {
            if(item.getItem_id() == itemId) {
                item.purchase();
            }
        }
    }

    public static void main(String[] args) {

        LinkedList items = new LinkedList(); //creating an object called items, creates a linked list
        Scanner scan = new Scanner(System.in); //creating object called scan, takes user input

        int itemCounter = 0; //Counts the number of items that are added by the user

        while (true) {
            System.out.println("\n1. Add an Item \n2. Display All Items" + " \n3. Display only Books \n4. Display only Gifts"
                    + " \n5. Display Only Shoes \n6. Delete an Item \n7. Purchase an Item"); //Interactive Menu options for the user to choose from
            String Input = scan.nextLine(); //scans user input to determine what the user wants to do

            //switch statement which takes the users input as its parameter and depending on what the user enters, an action is performed and the 'break' statement terminates the loop
            switch (Input) {
                case "1": //if the user chooses 1, the item counter is incremented and the user adds an item to the list
                    ++itemCounter;
                    items = (LinkedList) addItems(itemCounter,items);
                    break;
                case "2":
                    displayAllItems(items); //if the user chooses 2, all items are displayed
                    break;
                case "3":
                    displayOnlyBooks(items); //if the user chooses 3, only books are displayed
                    break;
                case "4":
                    displayOnlyGiftCards(items); //if the user chooses 4, only gift cards are displayed
                    break;
                case "5":
                    displayOnlyShoes(items); //if the user chooses 5, only shoes are displayed
                    break;
                case "6": //if the user chooses 6, they enter the item id they want to delete
                    System.out.println("\nPlease enter item id to delete: ");
                    int itemId = scan.nextInt();
                    deleteItem(itemId,items);
                    break;
                case "7": //if the user chooses 7, they enter the item id of what they would like to purchase
                    System.out.println("\nPlease enter item id to purchase: ");
                    int item_Id = scan.nextInt();
                    purchaseItem(item_Id,items);
                    break;
            }

        }

    }
}