import java.util.ArrayList; // import array list for java

/**
 * this class is representing a house
 * houses contain dining rooms and certain residents
 */
public class House extends Building { // Library class extends the Building class

  private ArrayList<String> residents; // <String> tells Java what kind of data we plan to store within ArrayList
  private boolean hasDiningRoom; //boolean for true/false if house has a dining room 
  private Boolean hasElevator; //boolean for if house has an elevator

  /**
   * * Overloaded constructor with address and list of residents only 
   * Overload definition: define multiple “versions” of the same method to accommodate different type / number of parameters
   * @param address
   * @param residents
  */
  public House(String address) {
    super(address);
    this.residents = new ArrayList<String>();
  }

    /** 
     * constructor for the House class
     * @param String name = building name, String address = building address, int nFloors = number of floors of house, boolean hasDiningRoom = true/false if house has a dining room
    */
    public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
      super(name, address, nFloors);
      this.hasDiningRoom = hasDiningRoom;
      this.hasElevator = hasElevator;
      this.residents = new ArrayList<String>();
    }
  
    /** 
     *  Shows options available for house class with residents with proper numbers accosiated with all aspects of house
     */
    public void showOptions() {
        super.showOptions();
        System.out.print(" + getnResidents() \n + moveIn(name) \n + moveOut(name) \n + getHasDiningRoom \n + isResident(name) \n + getnResidents() \n");
        if (this.hasElevator == true) {
            System.out.println(" + goToFloor(n)");
        }
      }


     /**
      * accessor for dining room status which is either true or false
      * @return boolean = whether or not the House has a dining room
      */
    public boolean hasDiningRoom(){
      if (hasDiningRoom == true){
        return true;
      } else{
        return false;
      }
    }
  
     /** accessor for the number of House residents
      * @return int size = the number of residents currently in the House when prompted
      */
    public int nResidents(){
      return this.residents.size();
    }
  
    /** adds a resident to the residents arrayList by specified name
     * @param String name = the name of a resident to be added to the house arrayList
     */
    public void moveIn(String name){
      residents.add(name);
    }
  
    /** removes a specified resident from the residents arrayList by name
     * @param String name = the name of a resident to be removed from the house arrayList
     * @return String = the name of the resident that was removed
     */
    public String moveOut(String name){ // returns the name of the person who moved out
      residents.remove(name);
      return name;
    } 

    /** return the location in the array that the person was removed from
   * @param spot the place to be removed
   * @return int the spot in the actual array
   */
    public int moveOut(int spot){
      residents.remove(spot);
      return spot;
    } 
  
    /** checks if a specific name is in list residents
     * @param String person = the name of a person whose residency is being questioned at specific house
     * @return boolean = whether or not that person is in the house
     */
    public boolean isResident(String person){
      if (residents.contains(person)){
        System.out.println("Yes, " + person + " is a resident");
        return true;
      } else{
        System.out.println("No, " + person + " is not a resident");
        return false;
      }
  
    }


    /**
     * Moves user to a new selected floor or lets them climb up or down if there is no elevator
     * @param floorNum number of the floor user wants to go to
     */
    public void goToFloor(int floorNum) {
        if (this.hasElevator == false) {
          throw new RuntimeException("This house has no elevator you must move floor by floor");
        }
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this house. Must call enter() before navigating between floors to first enter the building.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this house is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
  
    public static void main(String[] args) {
      House jordan = new House("Jordan House", "1 Mandelle Road", 4, true, true);
      //System.out.println(jordan);
      jordan.moveIn("Abbey");
      jordan.moveIn("Mia");
      jordan.moveIn("Phoebe");
      jordan.moveIn("Lizzie");
      jordan.moveOut("Mia");
      jordan.moveOut("Elli"); //doesn't produce anything, not in house
      System.out.println(jordan);
      // jordan.moveOut("Abbey");
      jordan.isResident("Abbey");
      System.out.println(jordan + " in which the current residents are " + jordan.residents);
      jordan.enter();
      jordan.goToFloor(2);
      jordan.showOptions();
    }

}