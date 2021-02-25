# comparator-vehicle-sort
Demonstration of recursive input methods and comparator classes used to sort a vehicle by miles-per-gallon, in ascending order

Vehicle.java

 * Project Purpose: Demonstrate knowledge of comparators, sort method,
  LinkedLists, user input loops, file output, and error handling
 
 * Algorithm Used: Created a Vehicle class with make, model, and MPG
  attributes. Overrode the default toString() method to
  customize display output for the vehicles. Implemented a comparator
  class to sort vehicles by ascending MPG
 
 * Program Inputs: The make, model, and MPG parameters need to
  be passed in the instantiation of a Vehicle object. The comparator
  class requires two Vehicle objects to be passed as parameters
  to effectively order them.
 
 * Program Outputs: The comparator class compare() method returns
  one of three potential values to aid in the selection sort process:
  -1, 0, or 1. -1 indicates the first object is less than the second
  object based on the desired sorting method (ascending double).
  0 indicates they are equivalent. 1 indicates the first object is
  greater than the second object being compared. The toString()
  method is used to format the output of all vehicle object attributes.
 
 Main.java

 * Project Purpose: Demonstrate knowledge of comparators, sort method,
  LinkedLists, user input loops, file output, and error handling
 
 * Algorithm Used: A selection sort method is used in conjunction with
  a comparator class method to sort the user input vehicles. A
  ListIterator is used in conjunction with the toString() to print
  vehicles stored in the passed LinkedList. A FileOutputStream
  and PrintWriter class are leveraged with the display method to
  print the output of the vehicles to the desired file location.
  To avoid forcing the user to start from scratch in the
  instance of an invalid MPG input, a validation method is used to
  a) parse the user input string as a double, b) determine whether it
  is positive, and c) determine whether it is a valid double; if
  it isn't a positive, valid, double then the program requests a
  valid input that is subsequently used to instantiate a Vehicle
  object. A for-loop is used to gather user input to instantiate the
  number of vehicles dictated by the number of vehicles requested
  by the user (1-10). A larger do-while loop is used to run the
  program and allow for further user input in the event of an error.
 
 * Program Inputs: The program asks for user input to determine 1)
  the number of vehicles to be entered, 2) the make, model, and
  MPG for each vehicle, 3) the option to retry/start-over in the
  event of an error, 4) the ability to exit the program and output
  the sorted vehicles to a text file.
 
 * Program Outputs: There are a number of error handling outputs.
  The program also outputs 1) an unsorted display of the vehicles
  input, 2) a list of the vehicles sorted by ascending MPG, and
  3) a confirmation of the output to the .txt file location
