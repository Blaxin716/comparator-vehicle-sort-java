# comparator-vehicle-sort
Demonstration of recursive input methods and comparator classes used to sort a vehicle by miles-per-gallon, in ascending order

Vehicle.java

/* Blake Barnes
 * Project Purpose: Demonstrate knowledge of comparators, sort method,
 * LinkedLists, user input loops, file output, and error handling
 *
 * Algorithm Used: Created a Vehicle class with make, model, and MPG
 * attributes. Overrode the default toString() method to
 * customize display output for the vehicles. Implemented a comparator
 * class to sort vehicles by ascending MPG
 *
 * Program Inputs: The make, model, and MPG parameters need to
 * be passed in the instantiation of a Vehicle object. The comparator
 * class requires two Vehicle objects to be passed as parameters
 * to effectively order them.
 *
 * Program Outputs: The comparator class compare() method returns
 * one of three potential values to aid in the selection sort process:
 * -1, 0, or 1. -1 indicates the first object is less than the second
 * object based on the desired sorting method (ascending double).
 * 0 indicates they are equivalent. 1 indicates the first object is
 * greater than the second object being compared. The toString()
 * method is used to format the output of all vehicle object attributes.
 *
 * Program Limitations: I believe these classes appropriately manages
 * all relevant procedures
 *
 * Program Errors: None that I'm aware of
 */
 
 Main.java
