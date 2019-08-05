README
Creator: Benjamin Olsen, 19481681
Purpose: To explain the functionality of the DSA Assignment for 2018 Semester 2

HOW TO RUN THIS PROGRAM:
    The CSV files need to be present in the file this program runs out of. They are to remained named EXACTLY how they are when downloaded,
    i.e. "HouseStateFirstPrefsByPollingPlaceDownload-20499-WA.csv"
    Otherwise, this program will not run correctly.
    Please ensure everything is compiled with the command
        "javac *.java"
    Then run the Main class using
        "java Main"
    From there you will be prompted with a menu and options to run the program.
    If you wish to exit the program from the main menu, 0 should be entered, otherwise, select the other relevant menu options.

File Explanations
    Candidate.Java -
        Container class for the information for each candidate in the csv file
    CandidateTest.Java -
        A test for the aforementioned container class
    FileIO.Java -
        A class that handles the file input and output operations using linked lists and the buffered reader
    FileIOTest.java -
        The test harness for the aforementioned class
    Graph.java -
        The class to act as a graph ADT, storing data and connections between (Not implemented)
    IteratorTest.java -
        The class used as a test harness for the linked list iterator
    LinkedList.java -
        The class that is used to be the abstract data type linked list, storing information in a connected linking manner.
        (doubly ended doubly linked)
    LinkedListTest.java -
        The test harness for the aforementioned ADT
    Main.java -
        This program runs the entire show, by calling the run function in the menu class
    Menu.java -
        This is where each menu item is called, and where some of the processing occurs, i.e. the marginal seat calculations
    readme.txt -
        meta
    Seats.java -
        This is a container class for the marginal seats section of the Assignment, whereby it stores the data pertaining to the divison and its margin for a party
    SeatsTest.java -
        This runs a test harness for the container class aforementioned
    Sorts.java -
        This is the code which drives parts 1 and 2 of the Assignment, implementing mergesort and the filtering of the candidate information based upon user choice
    UserInput.java -
        This class handles the input of integers, doubles, and strings, as needed for the assignment

DEPENDENCIES
    Main calls: Menu
    Menu calls: UserInput, Sorts, FileIO
    Menu uses: LinkedList, Seats, Candidate
    Sorts uses: LinkedList, Seats, Candidate
    FileIO uses: LinkedList
DISCLAMER:
    This project isnt 100% complete, and requires csv files from the ATO on previous election data. There are known bugs and issues.
