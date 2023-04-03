/**
 * this class is representing a cafe 
 * Cafe keeps count of an inventory of coffee as well as components which can be sold and restocked (coffee ounces, sugar packets, creamers and cups)
 */
public class Cafe extends Building {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructs a Cafe (an extension of the building class)
     * @param name String name of the specifici cafe being addressed 
     * @param address String street address of the cafe 
     * @param nFloors int equal to the number of floors in the cafe 
     * @param nCoffeeOunces int ounces of coffee remaining in the inventory 
     * @param nSugarPackets int number of sugar packets remaining in the inventory 
     * @param nCreams int number of creams remaining in the inventory 
     * @param nCups int number of coffee cups remaining in the inventory 
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces; //coffee ounces
        this.nSugarPackets = nSugarPackets; //sugar packets
        this.nCreams = nCreams; //creamers
        this.nCups = nCups; //cups 
        System.out.println("You have built a cafe");
    }


    /** overloaded constructor for a Cafe, if address if known but nothing else (such as a manager or someone in control of the cafe)
     * @param name
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

    }

    /** 
     *  Shows options available for cafe class
     */
    public void showOptions() {
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit()\n + sellCoffee(size, SugarPackets, Creams)\n + restock (CoffeeOunces, SugarPackets, Creams, Cups)");

    }


    /**
     * Sells a cup of coffee from cafe and subtracts the given amounts of cups as well as ingredients used from the inventory
     * It then restocks inventory items that run out (if equaling zero, which links to the restock method)
     * @param nCoffeeOunces int ounces of coffee sold when given certain parameters
     * @param nSugarPackets int number of sugar packets sold when given certain parameters
     * @param nCreams int number of creams sold when given certain parameters
     */
    public void sellCoffee(int nCoffeeOunces, int nSugarPackets, int nCreams) {
        this.nCoffeeOunces -= nCoffeeOunces; // use of -= to decrease from what is in the inventory originally, coffee ounces
        this.nSugarPackets -= nSugarPackets; // sugar packets
        this.nCreams -= nCreams; //creams
        this.nCups -= 1; // just to decrease cups by one since there is only one cup sold at a time - other ingredients can vary

        if (this.nCoffeeOunces <= 0) { 
            System.out.println("The cafe has run out of coffee, restocked 100 more");
            this.restock(100, 0, 0, 0); //placeholders run in order of coffee ounces, sugar packets, creams and then cups 
        }
        if (this.nSugarPackets <= 0) { 
            System.out.println("The cafe has run out of sugar packets, restock 100 more");
            this.restock(0, 100, 0, 0); //placeholders run in order of coffee ounces, sugar packets, creams and then cups 
        }
        if (this.nCreams <= 0) { 
            System.out.println("The cafe has run out of creams, restock 100 more");
            this.restock(0, 0, 100, 0); //placeholders run in order of coffee ounces, sugar packets, creams and then cups 
        }
        if (this.nCups <= 0) { 
            System.out.println("The cafe has run out of cups, restock 100 more");
            this.restock(0, 0, 0, 100); //placeholders run in order of coffee ounces, sugar packets, creams and then cups 
        }
    }

    /** Overloaded method for selling coffee to imput a size name rather than ounce amount
     * @param size
     * @param packetsUsed
     * @param creamsUsed
     */
    public void sellCoffee(String size, int packetsUsed, int creamsUsed){
        if (size.equals("small")){
            this.nCoffeeOunces = nCoffeeOunces - 10;
        }
        if (size.equals("medium")){
            this.nCoffeeOunces = nCoffeeOunces - 14;
        }
        if (size.equals("large")){
            this.nCoffeeOunces = nCoffeeOunces - 18;
        }
        this.nCups = nCups - 1;
        this.nSugarPackets = nSugarPackets - packetsUsed;
        this.nCreams = nCreams - creamsUsed;
    }

    /**
     * Restocks the cafe inventory by adding the given amounts specified above (which is equal to 100)
     * @param nCoffeeOunces int ounces of coffee to restock 
     * @param nSugarPackets int number of sugar packets to restock 
     * @param nCreams int number of creams to restock 
     * @param nCups int number of cups to restock 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces; //use of += to increase the amount plus what is in it originally when running low
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }


    
    /* Navigation methods */
    public Cafe enter() {
        super.enter();
        return this;
    }

    public Cafe exit() {
        super.exit();
        return null; // We're outside now, so the building is null
    }

    /**
     * Moves user to floor 1 and does nt allow them to move to an other floor
     * @param floorNum number of the floor user wants to go to
     */
    public void goToFloor(int floorNum){
        if (floorNum != 1){
          System.err.println("You can't move to any other floors!");
        }
        else{
            super.goToFloor(floorNum);
        }
      }


    public static void main(String[] args) {
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Elm Street, Northampton MA", 3, 128, 20, 30, 10);
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive, Northampton MA", 5, 10, 100, 100, 0);
        
        //Testing sell and auto restock
        campusCafe.sellCoffee(50, 50, 50);
        System.out.println("Cups in Campus Cafe: " + campusCafe.nCups);
        System.out.println("Coffee in Campus Cafe: " + campusCafe.nCoffeeOunces);
        System.out.println("Sugar packets in Campus Cafe:" + campusCafe.nSugarPackets);
        System.out.println("Creams in Campus Cafe:" + campusCafe.nCreams);
        campusCafe.enter();
        campusCafe.showOptions();
        
        //Test 2 for sell and auto restock
        compassCafe.sellCoffee(10, 10, 10);
        System.out.println("Cups in Compass Cafe: " + compassCafe.nCups);
        System.out.println("Coffee in Compass Cafe: " + compassCafe.nCoffeeOunces);
        System.out.println("Sugar packets in Compass Cafe:" + compassCafe.nSugarPackets);
        System.out.println("Creams in Compass Cafe:" + compassCafe.nCreams);
        compassCafe.enter();
        compassCafe.goToFloor(2);
        compassCafe.exit();

    }
}
