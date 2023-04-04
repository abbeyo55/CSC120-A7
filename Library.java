import java.util.Hashtable; // import hashtable for java

  /** 
   *  This class is representing a library 
   *  The library serves as a place that books can be checked in and out of
   */
public class Library extends Building { // Library class extends from the original Building class
  private Hashtable<String, Boolean> collection; // Hashtable to keep track of books and availability status of all the books within the library 
  private Boolean hasElevator;

  /**
   * Overloaded constructor for library with only the name
   * @param name
   */
  public Library(String name) {
    super(name);
    this.collection = new Hashtable<String,Boolean>();
  }

    /**
     * doesn't include system.out.println because it prints weird in building class
     * public class for all components of library class, an extension of the building class
     * @param name
     * @param address
     * @param nFloors
     * @param hasElevator
     */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors); 
    this.collection = new Hashtable<String, Boolean>(); //initialize specific books to a new Hashtable
    this.hasElevator = hasElevator;
    //System.out.println("You have built a library: 📖");

  }

  /** 
     *  Shows options available for library class
     * adds in all components of books with titles along with what's included in the building class
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle() \n + removeTitle() \n + checkOut() \n + checkIn() \n + containsTitle() \n + isAvailable()");
      }

  // methods to update the `Hashtable` containing the `collection` every time we add/remove a title:
  
  /** 
   *  Adds a new specified book to the collection
   *  @param title title of the new book that's being added 
   *  @return updated collection hashtable with new book 
   */
  public void addTitle(String title){
    collection.put(title, true);
    System.out.println(title + " has been added to the collection at the library");
    //return title;
  }
  
   /** 
    *  Removes a specified book from the collection
    *  @param title title of the specified book to be removed
     * @return updated collection hashtable without specific book 
    */
   public String removeTitle(String title){
     collection.remove(title, true);
     System.out.println(title + " has been removed from the collection at the library");
     return title;
  }
  
  /** 
   *  Checks out a book by setting availability value to "false"
   *  @param title title of the book that's being checked out
   */
   public void checkOut(String title){
    collection.replace(title, false);
    System.out.println(title + " has been checked out at the library");
   }
  
  /** 
   *  Returns a book to the collection by setting availability value to "true"
    *  @param title title of the book that's being returned by someone 
    */
   public void returnBook(String title){
    collection.replace(title, true);
    System.out.println(title + " has been returned at the library");
   }

   //couple of methods to support browsing the collection:

   /** 
    *  Checks to see if the specified book exists in the collection
    *  @param title title of the specified book
    *  @return true or false if the book is in the collection or not
    */
   public boolean containsTitle(String title){ // returns true if the title appears in the Libary's original collection, otherwise false
    if (collection.contains(title)) {
      return true;
    }
    else{
      return false;
    }
  }
  
   /** 
   *  Checks to see if the book is available to check out, and to ensure someone else hasn't taken it
   *  @param title title of the specified book
   *  @return true or false if the book is available to be checked out or not
   */
   public boolean isAvailable(String title){ // returns true if the title is currently available at specified library, otherwise false
     if (collection.contains(title)) {
       return collection.get(title);
     }
     else{
      throw new RuntimeException("This book is not in this library collection");
    }
  }
  
   /** 
   *  Prints the collection
   */
  public void printCollection(){
    System.out.println(this.collection);
   }


   /**
     * Moves user to a new selected floor or lets them climb up or down if there is no elevator
     * @param floorNum number of the floor user wants to go to
     */
    public void goToFloor(int floorNum) {
        if (this.hasElevator == false) {
          throw new RuntimeException("This library has no elevator you must move floor by floor");
        }
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this library. Must call enter() before navigating between floors to first enter the building.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this library is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
  
  public static void main(String[] args) {
    Library neilsonLibrary = new Library("Neilson Library", "7 Neilson Drive, Northampton MA", 5, true);
    neilsonLibrary.addTitle("One Fish, Two Fish, Red Fish, Blue Fish");
    neilsonLibrary.addTitle("The Cat in the Hat");
    neilsonLibrary.addTitle("Oh, the Places You'll Go!");
    neilsonLibrary.addTitle("Fox in Socks");

    neilsonLibrary.checkOut("Oh, the Places You'll Go!");
    neilsonLibrary.checkOut("One Fish, Two Fish, Red Fish, Blue Fish");
    neilsonLibrary.removeTitle("The Cat in the Hat");
    neilsonLibrary.returnBook("One Fish, Two Fish, Red Fish, Blue Fish");
    
    neilsonLibrary.printCollection();
    neilsonLibrary.showOptions();
    neilsonLibrary.enter();
    neilsonLibrary.goToFloor(2);
    //System.out.println(neilsonLibrary);
   }
    
}