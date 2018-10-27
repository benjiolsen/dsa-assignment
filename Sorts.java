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
    private static void mergeSortRecurse(Candidate[] inArray,
                                         int leftIdx,
                                         int rightIdx,
                                         String sortBy){
        if(leftIdx<rightIdx){
            // This splits the array in half over and over until its 1 element
            int midIdx = (leftIdx+rightIdx)/2;
            // recursion recursion recursion
            mergeSortRecurse(inArray,leftIdx,midIdx,sortBy);
            mergeSortRecurse(inArray,midIdx+1,rightIdx,sortBy);

            mergeCandidate(inArray,leftIdx,midIdx,rightIdx,sortBy);
        }
    }
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
                        if(inArray[ii].getSName().compareTo(inArray[jj].getSName())>0){
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
                        if(inArray[ii].getFName().compareTo(inArray[jj].getFName())>0){
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
                        if(inArray[ii].getState().compareTo(inArray[jj].getState())>0){
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
                        if(inArray[ii].getLongParty().compareTo(inArray[jj].getLongParty())>0){
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
                        if(inArray[ii].getDivision().compareTo(inArray[jj].getDivision())>0){
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

     public static LinkedList<Candidate> filter(Candidate[] candidates,
                                                String filterBy,String filter){
        LinkedList<Candidate> list = new LinkedList<Candidate>();
        boolean failed = false;

        for(Candidate can: candidates){
            switch(filterBy){
                case "State":
                    if(can.getState().equalsIgnoreCase(filter)){
                        list.insertLast(can);
                    }
                    else{
                        failed = true;
                    }
                break;
                case "Party":
                    if(can.getLongParty().equalsIgnoreCase(filter)||
                       can.getShortParty().equalsIgnoreCase(filter)){
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
        if(failed==true&&list.isEmpty()==true){
            System.out.println("Failed to filter based upon input");
            System.out.println("All data being shown");
            for(Candidate can2: candidates){
                list.insertLast(can2);
            }
        }
        return list;
     }
}
