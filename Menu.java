/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: Menu
    PURPOSE: Used to run and call the needed functions for the running of
             the DSA Assignment for 2018 Semester 2. Using switch statements
             and the UserInput class to handle the main menu function.
*/
import java.util.*;
public class Menu{

    // run
    // This is the function that loops constantly to print the main menu out
    // in the CLI. This function shows the user their choices, and calls the
    // function responsible to allow them to chose, then the function call
    // to the select method, which is one big switch statement based upon the
    // users choice on what they would like to do.
    public static void run()
    {
        int choice = 1;
        Candidate[] candidates = null;
        candidates = readCandidates();
        System.out.println("\033\143");
        while(choice > 0 && choice <= 4)
        {
            // Janky print to clear a linux terminal
            // Asks the user to choose which operation they want
            System.out.println("Please enter a number as your selection");
            System.out.println("[1] List Nominees\n[2] Nominee Search\n"+
                               "[3] List by Margin\n[4] Itenerary by Margin"+
                               "\n[0] Exit");
            // Uses the UserInput class to get the integer input
            choice = UserInput.intPut(0,4);
            select(choice,candidates);
        }
        System.out.println("Bye!");
    }

    // select
    // Contains the big switch statement that runs what the user wants to
    // select. This switch runs on the integer choice the user makes, and then
    // if the user selected 0, it breaks from the switch and then out of the
    // main loop, ending the program
    private static void select(int choice,Candidate[] candidates)
    {
        switch(choice)
        {
            case 1: choice = 1;
                listNominees(candidates);
            break;
            case 2: choice = 2;
                searchNominees(candidates);
            break;
            case 3: choice = 3;
                listMargin();
            break;
            case 4: choice = 4;
                itinerary();
            break;
            default:
            break;
        }
    }

    // listNominees
    // The function to list out the nominees based upon what the user decides
    // to filter and order by. Through the use of mergeSort and some string
    // searching to filter out what the user wants. User input also selects
    // if the candidates should be sorted/filtered or not, and what the filter
    // /sort should be on. Finally, the option is provided to save the list to
    // a file
    private static void listNominees(Candidate[] candidates){
        // These integers are used to switch on for the users choice
        int sort,filter,sortChoice=0,filterChoice=0;
        String filterString = null,fileChoice = null;
        LinkedList<Candidate> list = new LinkedList<Candidate>();
        // Incase the user wants to save to file
        LinkedList<String> output = new LinkedList<String>();

        // This section handles if the user wants to sort, and what on
        System.out.println("Do you wish to sort the candidates?");
        System.out.println("[1] Sorted\n[2] Unsorted");
        sort = UserInput.intPut(1,2);
        if(sort==1){
            System.out.println("How do you wish to sort the candidates?");
            System.out.println("By: First Name? Last Name? State? Party?"+
                               " Divison?");
            System.out.println("[1] First Name\n[2] Last Name\n"+
                               "[3] State\n[4] Party\n[5] Division");
            sortChoice = UserInput.intPut(1,5);
        }

        // This section handles if the user wants to filter and what on
        System.out.println("Do you wish to filter the candidates?");
        System.out.println("[1] Filtered\n[2] Unfiltered");
        filter = UserInput.intPut(1,2);
        if(filter==1){
            System.out.println("How do you wish to filter the candidates?");
            System.out.println("By: State? Party? Divison?");
            System.out.println("[1] State\n[2] Party\n[3] Division");
            filterChoice = UserInput.intPut(1,3);
            System.out.println("Please enter the filter");
            filterString = UserInput.stringPut();
        }

        // Switches on what the user wanted to sort by
        switch(sortChoice){
            case 1:
                Sorts.mergeSort(candidates,"First");
            break;
            case 2:
                Sorts.mergeSort(candidates,"Last");
            break;
            case 3:
                Sorts.mergeSort(candidates,"State");
            break;
            case 4:
                Sorts.mergeSort(candidates,"Party");
            break;
            case 5:
                Sorts.mergeSort(candidates,"Division");
            break;
            default:
            break;
        }
        if(filter==1){
            // Switches on what the user wants to filter by, and the string they
            // wanted to filter by
            switch(filterChoice){
                case 1:
                list = Sorts.filter(candidates,"State",filterString);
                break;
                case 2:
                list = Sorts.filter(candidates,"Party",filterString);
                break;
                case 3:
                list = Sorts.filter(candidates,"Division",filterString);
                break;
                default:
                break;
            }
        }
        else{
            for(Candidate c: candidates){
                list.insertLast(c);
            }
        }
        // Runs through each candidate in the linked list and then outputs
        // their first and last names.
        for(Candidate can: list){
            System.out.println(can.getFName() +" "+ can.getSName());
        }

        // This section asks the user if they want to save the report to a
        // file
        System.out.println("Save these candidates to file?\n[Y]/[N]");
        fileChoice = UserInput.stringPut();
        switch(fileChoice){
            case "y":
            case "Y":
                for(Candidate can2: list){
                    output.insertLast(can2.toString());
                }// This loop ads the toString for the candidate to a ll
                // This string at the start is the format of the data from the
                // scraped csv
                output.insertFirst("StateAb,DivisionID,DivisionNm,PartyAb,"+
                "PartyNm,CandidateID,Surname,GivenNm,Elected,HistoricElected");
                // This function saves information to the csv
                FileIO.write("Nominees-Filtered.csv",output);
                System.out.println("Saved file!\nNominees-Filtered.csv");
            break;
            default:
                // This here is empty as if the user says anything other than
                // yes its not needed
            break;
        }

    }

    // searchNominees
    // This funciton acts to search the list of candidates, and then output
    // the results of the users search. Utilising linked lists for storage of
    // the results, as there is an unknown amount of results, and an array
    // for all candidates, as that was previously used in the program. Prompts
    // for users choice allows the user to sort and search, and then depending
    // if there were any results, save them to a file.
    private static void searchNominees(Candidate[] candidates){
        // These integers are used to switch on for the users choice
        int sort,sortChoice=0;
        String searchString = null,fileChoice = null;
        LinkedList<Candidate> list = new LinkedList<Candidate>();
        // Incase the user wants to save to file
        LinkedList<String> output = new LinkedList<String>();

        // This section handles if the user wants to sort, and what on
        System.out.println("Do you wish to sort the candidates?");
        System.out.println("[1] Sorted\n[2] Unsorted");
        sort = UserInput.intPut(1,2);
        if(sort==1){
            System.out.println("How do you wish to sort the candidates?");
            System.out.println("By: First Name? Last Name? State? Party?"+
                               " Divison?");
            System.out.println("[1] First Name\n[2] Last Name\n"+
                               "[3] State\n[4] Party\n[5] Division");
            sortChoice = UserInput.intPut(1,5);
        }
        // This section prompts the user for the surname search that they
        // need to perform.
        System.out.println("Please enter the surnname, or part-thereof for"+
                           " your search.");
        searchString = UserInput.stringPut();
        // Switches on what the user wanted to sort by
        switch(sortChoice){
            case 1:
            Sorts.mergeSort(candidates,"First");
            break;
            case 2:
            Sorts.mergeSort(candidates,"Last");
            break;
            case 3:
            Sorts.mergeSort(candidates,"State");
            break;
            case 4:
            Sorts.mergeSort(candidates,"Party");
            break;
            case 5:
            Sorts.mergeSort(candidates,"Division");
            break;
            default:
            break;
        }
        // Uses the find function in the Sorts class to search for the users
        // inputted search.
        list = Sorts.find(candidates,searchString);
        if(list.isEmpty()==false){
            for(Candidate can:list){
                System.out.println(can.toString());
            }
            // This section asks the user if they want to save the report to a
            // file
            System.out.println("Save these candidates to file?\n[Y]/[N]");
            fileChoice = UserInput.stringPut();
            switch(fileChoice){
                case "y":
                case "Y":
                    for(Candidate can2: list){
                        output.insertLast(can2.toString());
                    }// This loop ads the toString for the candidate to a ll
                    // This string at the start is the format of the data from
                    // the scraped csv
                    output.insertFirst("StateAb,DivisionID,DivisionNm,PartyAb,"+
                    "PartyNm,CandidateID,Surname,GivenNm,Elected,HistoricElected");
                    // This function saves information to the csv
                    FileIO.write("Search-Results.csv",output);
                    System.out.println("Saved file!\nSearch-Results.csv");
                break;
                default:
                    // This here is empty as if the user says anything other
                    // than yes its not needed
                break;
            }
        }
    }

    // listMargin
    // This method is responsible for the listing out of marginal seats for
    // the users choice party and their possible threshold limit. I used a
    // fair amount of linked lists, which, may be overboard, but it lets me
    // deal with a large amount of dynamic sizing of information. Plus, the
    // speed and ability to iterate with a linked list is useful, however
    // this does come at a memory overhead, but due to its small memory
    // overhead it should be fine.
    private static void listMargin(){
        double threshold = 6.0;
        String party = new String();
        String fileChoice = new String();
        String thresholdChoice = new String();
        // Incase the user wants to save to file
        LinkedList<String> output = new LinkedList<String>();
        // Contains the margins and the divisions
        LinkedList<Seats> margins = new LinkedList<Seats>();
        LinkedList<Seats> matching = new LinkedList<Seats>();
        // Contains the files informations from the csv files
        LinkedList<String> WA = new LinkedList<String>();
        LinkedList<String> NSW = new LinkedList<String>();
        LinkedList<String> VIC = new LinkedList<String>();
        LinkedList<String> QLD = new LinkedList<String>();
        LinkedList<String> SA = new LinkedList<String>();
        LinkedList<String> TAS = new LinkedList<String>();
        LinkedList<String> ACT = new LinkedList<String>();
        LinkedList<String> NT = new LinkedList<String>();
        // Removing the first two gets rid of the data that isnt needed, such
        // as the format and the information about the file
        WA = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-WA.csv");
        WA.removeFirst();
        WA.removeFirst();
        NSW = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-NSW.csv");
        NSW.removeFirst();
        NSW.removeFirst();
        VIC = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-VIC.csv");
        VIC.removeFirst();
        VIC.removeFirst();
        QLD = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-QLD.csv");
        QLD.removeFirst();
        QLD.removeFirst();
        SA = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-SA.csv");
        SA.removeFirst();
        SA.removeFirst();
        TAS = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-TAS.csv");
        TAS.removeFirst();
        TAS.removeFirst();
        ACT = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-ACT.csv");
        ACT.removeFirst();
        ACT.removeFirst();
        NT = FileIO.read("HouseStateFirstPrefsByPollingPlaceDownload-20499-NT.csv");
        NT.removeFirst();
        NT.removeFirst();

        System.out.println("Please enter the party name, or part thereof");
        System.out.println("(Full name or abbreviation accepted)");
        party = UserInput.stringPut();
        // Repeatedly adds to the margins list after reading from each file
        // and adding them to the marginal calculations
        margins = marginCalc(WA,margins,party);
        margins = marginCalc(NSW,margins,party);
        margins = marginCalc(VIC,margins,party);
        margins = marginCalc(ACT,margins,party);
        margins = marginCalc(QLD,margins,party);
        margins = marginCalc(TAS,margins,party);
        margins = marginCalc(NT,margins,party);
        margins = marginCalc(QLD,margins,party);

        // If the list was populated, then you can run through, otherwise,
        // an error will be printed on the screen.
        if(margins.isEmpty()==false){
            System.out.println("Do you wish to have a threshold?");
            System.out.println("[Y] Yes [N] No, use the default +/-6%");
            thresholdChoice = UserInput.stringPut();
            switch(thresholdChoice){
                case "y":
                case "Y":
                    threshold = UserInput.doublePut(-100.0,100.0);
                break;
                default:
                break;
            }
            for(Seats seat:margins){
                // Only puts the information on the screen or in the list
                // if it is between the threshold limits
                if(seat.getMargin()>-threshold&&seat.getMargin()<threshold){
                    System.out.println(seat);
                    matching.insertLast(seat);
                }
            }
            System.out.println("Save this output to file?\n[Y]/[N]");
            fileChoice = UserInput.stringPut();

            switch(fileChoice){
                case "y":
                case "Y":
                    for(Seats seats: matching){
                        output.insertLast(seats.toString());
                    }// This loop adds the toString for the candidate to a ll
                    // This string at the start is the format of the data from
                    // the scraped csv
                    // This function saves information to the csv
                    FileIO.write("Marginal-Seats.txt",output);
                    System.out.println("Saved file!\nMarginal-Seats.txt");
                break;
                default:
                // This here is empty as if the user says anything other
                // than yes its not needed
                break;
            }
        }
        else{
            System.out.println("The party was not found\n");
        }


    }
    public static void itinerary(){
        System.out.println("Check bacc later xx");
    }

    // readCandidates
    // This method reads in the candidates into an array. This runs at the
    // beginning of the program to ensure it starts with this information
    // already accessible. The array was chosen for its sorting ability.
    private static Candidate[] readCandidates(){
        // This is the array to be returned. The array is being used, over
        // the list, for its O(1) access time, and the ease it allows for
        // sorting elements throughout the array, rather than using a linked
        // list
        Candidate[] candidates = null;
        // Each line is read into this list, using the FileIO class to handle
        // the input.
        LinkedList<String> list = new LinkedList<String>();
        // The candidates are read into a list firstly, so that if there
        // is an errornous candidate, it wont make it into the array, and
        // therefore the array isnt wasting space with any overhead, and is
        // the exact needed size.
        LinkedList<Candidate> candidateList = new LinkedList<Candidate>();
        int ii = 0;
        // Boolean value to ensure that if the line is faulty, it doesnt make
        // it into the list.
        boolean good = true;
        try{
            // csv should always have this name!
            list = FileIO.read("HouseCandidatesDownload-20499.csv");
            // First two lines in the csv are non-needed for this program
            list.removeFirst();
            list.removeFirst();

            // A foreach loop that goes through the list of lines and splits
            // them and then puts that into the candidate list
            for(String line: list){
                // Screw the shooters fishers and farmers >:(
                // This big regex takes away any commas, excluding those in
                // quotation marks, preserving the name of the shooters and
                // fishers party.
                // RegEx recieved from Stack Overflow, UserName: MarkusQ
                String[] splits = line.split("(,)(?=(?:[^\"]|\"[^\"]*\")*$)");
                for(String splitLine:splits){
                    // Runs through the splits to ensure none of them are
                    // empty strings, otherwise that would be errornous data
                    if(splitLine.equals("")){
                        good = false;
                    }
                }
                if(good == true){
                    candidateList.insertLast(new Candidate(splits));
                }
                good = true;
            }
            // This makes the array the perfect size, with no empty space
            // saves memory overhead when already using so many linked lists
            candidates = new Candidate[candidateList.getLength()];
            for(Candidate can:candidateList){
                candidates[ii] = can;
                ii++;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        // Clears the memory of these objects just to be nice for gc
        list = null;
        candidateList = null;
        return candidates;
    }

    // marginCalc
    // This is the method which calculates the marginal values for the
    // users party of choice, unless there is no match, and therefore the
    // list is not populated at all. The linked list was chose as there is
    // going to be an indeterminate amount of entrys, and to save array
    // copying and extending, a simple linked list could suffice. Plus, its
    // O(1) insert times are good and array like, so reading into them is
    // fine.
    private static LinkedList<Seats> marginCalc(LinkedList<String> lines,
                                               LinkedList<Seats> margins,
                                               String party){
        int vF=0,vA=0,num=0;
        double margin=0.0;
        String name=null;
        String[] splits = null;
        // This allows the system to ensure that only votes for and against
        // a party will exist if the party is present in that area.
        boolean matched = false;

        for(String line:lines){
            // A dirty regex to ensure that the commas inside quotes are
            // preserved
            // RegEx recieved from Stack Overflow, UserName: MarkusQ
            splits = line.split("(,)(?=(?:[^\"]|\"[^\"]*\")*$)");
            if(num==0||num!=Integer.parseInt(splits[1])){
                    if(num==0){
                        // If this is the first rodeo, then it will pass the
                        // first if statement and therefore will need to be
                        // handled
                        name = splits[2];
                        num = Integer.parseInt(splits[1]);
                    }
                    else{
                        if(matched == true){
                            // Ensures that there was a match in the search
                            margin = ((double)vF/((double)vF+(double)vA))*100-50;
                            margins.insertLast(new Seats(margin,name,num));
                        }
                        // Initialises all the values
                        name = splits[2];
                        num = Integer.parseInt(splits[1]);
                        vF = 0;
                        vA = 0;
                        matched = false;
                    }
            }
            else{
                if(splits[11].toLowerCase().contains(party.toLowerCase())||
                   splits[12].toLowerCase().contains(party.toLowerCase())){
                   // If the users string matches or partly matches the input
                   // party names
                   vF+=Integer.parseInt(splits[13]);
                   matched = true;
                }
                else{
                    vA+=Integer.parseInt(splits[13]);
                }
            }
        }
        return margins;
    }
}
