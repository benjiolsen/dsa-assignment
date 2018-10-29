/*
    STUDENT NUMBER: 19481681
    NAME: Benjamin Olsen
    UNIT: COMP1002 Data Structures and Algorithms
    CLASS: Candidate
    PURPOSE: To handle all the sorting for the DSA Assignment.
*/
import java.util.*;
public class Sorts{

    // Merge sort algorithm adapted from Benjamin Olsen 194816781 Practical 2
    // submission for DSA semester 2 2018
    // Merge sort chosen for its stable nature and speed and ability to work
    // with large data

    // mergeSort
    // Splits the array into sorted (by def) single index arrays, then
    // compares and merges them with the next one, which then is compared and
    // merged with the next, etc.
    // BEST = AVG = WORST = O(NlogN)
    public static void mergeSort(Candidate[] inArray,String sortBy){
        // Calls to recursive call, therfore acting as the wrapper function
        mergeSortRecurse(inArray,0,(inArray.length-1),sortBy);
    }
    // mergeSortRecurse
    // This is the function that recursively calls itself until it is calling
    // an array of size 1, then it calls the merge function to merge it with
    // the sub array next to it, unwinding and performing a merge on each sub
    // array.
    private static void mergeSortRecurse(Candidate[] inArray,
                                         int leftIdx,
                                         int rightIdx,
                                         String sortBy){

        if(leftIdx<rightIdx){
            // This splits the array in half over and over until its 1 element
            int midIdx = (leftIdx+rightIdx)/2;
            // Recursion recursion recursion
            mergeSortRecurse(inArray,leftIdx,midIdx,sortBy);
            mergeSortRecurse(inArray,midIdx+1,rightIdx,sortBy);
            // Merges and switches on the users choice
            mergeCandidate(inArray,leftIdx,midIdx,rightIdx,sortBy);
        }
    }

    // mergeCandidate
    // This function merges the sub arrays from the recursive call from the
    // previous submodule. The same algorithm is used no matter what the user
    // chose to order by, the only difference is the comparison performed. it
    // is performed on the different candidate classfields as per the users
    // choice.
    public static void mergeCandidate(Candidate[] inArray,int leftIdx,
                                      int midIdx,int rightIdx,String sortBy){
        // Creates a new array this size of the amount of elements to merge
        Candidate[] tempArray = new Candidate[rightIdx-leftIdx+1];
        // ii is used to refer to the lowest indexed of the left sub array
        int ii = leftIdx;
        // jj is used to refer to the lowest indexed of the right sub array
        int jj = midIdx+1;
        // kk is used for the next free element in the temp array
        int kk = 0;
        switch(sortBy){
            // Swtiches on what the user wanted the string to be ordered by
            case "Last":
                while((ii <= midIdx)&&(jj <= rightIdx)){
                    // Merges the sub array into the temp array
                    if(inArray[ii].getSName()
                                  .compareTo(inArray[jj]
                                  .getSName())>0){
                        // Takes from the left sub array
                        tempArray[kk] = inArray[ii];
                        ii++;
                    }
                    else{
                        // takes from the right sub array
                        tempArray[kk] = inArray[jj];
                        jj++;
                    }
                    kk++;
                }
                for(ii=ii;ii<=midIdx;ii++){
                    // Flushes the remainder from the left sub array
                    tempArray[kk] = inArray[ii];
                    kk++;
                }
                for(jj=jj;jj<=rightIdx;jj++){
                    // Flushes the remainder from the right sub array
                    tempArray[kk] = inArray[jj];
                    kk++;
                }
                for(kk=leftIdx;kk<=rightIdx;kk++){
                    // Copies the sorted array back into the real array
                    // uses kk-leftIndex to align the temp array indexing to 0
                    inArray[kk] = tempArray[kk-leftIdx];
                }
            break;
            case "First":
                while((ii <= midIdx)&&(jj <= rightIdx)){
                    // Merges the sub array into the temp array
                    if(inArray[ii].getFName()
                                  .compareTo(inArray[jj]
                                  .getFName())>0){
                        // Takes from the left sub array
                        tempArray[kk] = inArray[ii];
                        ii++;
                    }
                    else{
                        // takes from the right sub array
                        tempArray[kk] = inArray[jj];
                        jj++;
                    }
                    kk++;
                }
                for(ii=ii;ii<=midIdx;ii++){
                    // Flushes the remainder from the left sub array
                    tempArray[kk] = inArray[ii];
                    kk++;
                }
                for(jj=jj;jj<=rightIdx;jj++){
                    // Flushes the remainder from the right sub array
                    tempArray[kk] = inArray[jj];
                    kk++;
                }
                for(kk=leftIdx;kk<=rightIdx;kk++){
                    // Copies the sorted array back into the real array
                    // uses kk-leftIndex to align the temp array indexing to 0
                    inArray[kk] = tempArray[kk-leftIdx];
                }
            break;
            case "State":
                while((ii <= midIdx)&&(jj <= rightIdx)){
                    // Merges the sub array into the temp array
                    if(inArray[ii].getState()
                                  .compareTo(inArray[jj]
                                  .getState())>0){
                        // Takes from the left sub array
                        tempArray[kk] = inArray[ii];
                        ii++;
                    }
                    else{
                        // takes from the right sub array
                        tempArray[kk] = inArray[jj];
                        jj++;
                    }
                    kk++;
                }
                for(ii=ii;ii<=midIdx;ii++){
                    // Flushes the remainder from the left sub array
                    tempArray[kk] = inArray[ii];
                    kk++;
                }
                for(jj=jj;jj<=rightIdx;jj++){
                    // Flushes the remainder from the right sub array
                    tempArray[kk] = inArray[jj];
                    kk++;
                }
                for(kk=leftIdx;kk<=rightIdx;kk++){
                    // Copies the sorted array back into the real array
                    // uses kk-leftIndex to align the temp array indexing to 0
                    inArray[kk] = tempArray[kk-leftIdx];
                }
            break;
            case "Party":
                while((ii <= midIdx)&&(jj <= rightIdx)){
                    // Merges the sub array into the temp array
                    if(inArray[ii].getLongParty()
                                  .compareTo(inArray[jj]
                                  .getLongParty())>0){
                        // Takes from the left sub array
                        tempArray[kk] = inArray[ii];
                        ii++;
                    }
                    else{
                        // takes from the right sub array
                        tempArray[kk] = inArray[jj];
                        jj++;
                    }
                    kk++;
                }
                for(ii=ii;ii<=midIdx;ii++){
                    // Flushes the remainder from the left sub array
                    tempArray[kk] = inArray[ii];
                    kk++;
                }
                for(jj=jj;jj<=rightIdx;jj++){
                    // Flushes the remainder from the right sub array
                    tempArray[kk] = inArray[jj];
                    kk++;
                }
                for(kk=leftIdx;kk<=rightIdx;kk++){
                    // Copies the sorted array back into the real array
                    // uses kk-leftIndex to align the temp array indexing to 0
                    inArray[kk] = tempArray[kk-leftIdx];
                }
            break;
            case "Division":
                while((ii <= midIdx)&&(jj <= rightIdx)){
                    // Merges the sub array into the temp array
                    if(inArray[ii].getDivision()
                                  .compareTo(inArray[jj]
                                  .getDivision())>0){
                        // Takes from the left sub array
                        tempArray[kk] = inArray[ii];
                        ii++;
                    }
                    else{
                        // takes from the right sub array
                        tempArray[kk] = inArray[jj];
                        jj++;
                    }
                    kk++;
                }
                for(ii=ii;ii<=midIdx;ii++){
                    // Flushes the remainder from the left sub array
                    tempArray[kk] = inArray[ii];
                    kk++;
                }
                for(jj=jj;jj<=rightIdx;jj++){
                    // Flushes the remainder from the right sub array
                    tempArray[kk] = inArray[jj];
                    kk++;
                }
                for(kk=leftIdx;kk<=rightIdx;kk++){
                    // Copies the sorted array back into the real array
                    // uses kk-leftIndex to align the temp array indexing to 0
                    inArray[kk] = tempArray[kk-leftIdx];
                }
                break;
            default:
                System.out.println("Invalid Sorting Type");
            break;
        }
     }

     // filter
     // Taking in the array, the filter provided from the user, and what
     // they want to filter on. Using a switch statement, the function decides
     // what to filter on, and then (ignoring case), tests for equality
     // between the filter and the candidates to be filtered. If there is
     // no match, the entire list of candidates is put into the list.
     // The linked list ADT is use as there is going to be an indeterminate
     // size, so the O(1) insert time at the end is as good as an array, and
     // can be used in a foreach loop, like an array as well. So the array
     // like access times and the ability to be an indeterminate size is my
     // reasoning for the linked list
     public static LinkedList<Candidate> filter(Candidate[] candidates,
                                                String filterBy,
                                                String filter){
        LinkedList<Candidate> list = new LinkedList<Candidate>();
        // The boolean value is used to show if there is no match between the
        // filter and anything in the candidates
        boolean failed = false;
        // Loops through each candidate in the file
        for(Candidate can: candidates){
            // Switches on what the user wanted to choose
            switch(filterBy){
                case "State":
                    if(can.getState().equalsIgnoreCase(filter)){
                        // Ignore case allows the user to search any case
                        list.insertLast(can);
                    }
                    else{
                        failed = true;
                    }
                break;
                case "Party":
                    if(can.getLongParty().equalsIgnoreCase(filter)||
                       can.getShortParty().equalsIgnoreCase(filter)){
                        // Searches both the short and long party to ensure
                        // that the user enters the correct type
                        list.insertLast(can);
                    }
                    else{
                        failed = true;
                    }
                break;
                case "Division":
                    if(can.getDivision().equalsIgnoreCase(filter)){
                        list.insertLast(can);
                    }
                    else{
                        failed = true;
                    }
                break;
                default:
                break;
            }
        }
        // Checks if the search has failed completely, meaning the list is
        // completely empty and the failed value is true, if so puts the
        // sorted/unsorted data
        if(failed==true&&list.isEmpty()==true){
            System.out.println("Failed to filter based upon input");
            System.out.println("All data being shown");
            for(Candidate can2: candidates){
                list.insertLast(can2);
            }
        }
        return list;
     }

     // find
     // This function searches through the array of candidates to see if the
     // last name contains the filter entered by the user, if so it is added
     // into a linked list with O(1) timing, and then returns that list to
     // the user. The linked list again, was used for the dynamic sizing to
     // allow for the unknown amount of candidates who match the search.
     public static LinkedList<Candidate> find(Candidate[] candidates,
                                              String lName){
         LinkedList<Candidate> list = new LinkedList<Candidate>();
         for(Candidate can: candidates){
             // to ensure that the user is searching for the correct string
             // no matter of case, the toLowerCase is called on both to ensure
             // that the strings are matching cases and wont return false if
             // one letter is the wrong case. Contains is called to match if
             // the last name contains the input name.
             // O(1) access time
             if(can.getSName().toLowerCase().matches(lName.toLowerCase()+".*")){
                 list.insertLast(can);
             }
         }
         if(list.isEmpty()==true){
             // If this list hasnt had anything put into it, then the search
             // wasnt successful.
             System.out.println("The search turned up empty");
         }
         return list;
     }
}
