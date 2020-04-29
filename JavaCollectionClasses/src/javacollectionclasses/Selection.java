package javacollectionclasses;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * A program that simulates a lottery ticket and lottery ticket checker machine.
 * Use interfaces, rather than inheritance, to make polymorphic calls.
 * model a set of specified number of unique integers selected randomly from a specified range.
 * Assignment 3
 * Date : 2017-04-3
 * @author Jasen Ratnam
 */

//Selection s = new Selection(....)
//Comparable<Selection> cs = new Selection(....)


public class Selection implements java.lang.Comparable<Selection>
{
    private int size; //Stores the size of this selection.
    
    private int low;  //Stores the lowest possible random integer.
    
    private int high; //Stores the highest possible random integer.
    
    private Set<Integer> selection = new TreeSet<Integer>();
    
    /**
     * Constructor method that constructs this new object, initializing it according to the supplied parameters.
     * @param size the size of the selection to be created.
     * @param low the minimum value of the range.
     * @param high the maximum value of the range.
     */
    public Selection(int size, int low, int high)
    {
        this.size = size;
        this.low = low;
        this.high = high;    
        generate();
    }
    
    // int x = (int) 2.45;
    //implements the Comparable interface.
    //Compares the contents of this and other selection sets.
    @Override
    public int compareTo(Selection other)//(Object obj)
    {
        //Selection other = (Selection) obj;
        if(this.size < other.size)
        {
            return -1;
        }
        
        else if(this.size > other.size)
        {
            return 1;
        }
        
        Iterator<Integer> other_it = other.selection.iterator();
        Iterator<Integer> this_it = selection.iterator();
        
        while(this_it.hasNext())
        {
            int lhs = this_it.next();
            int rhs = other_it.next();
            if(lhs < rhs)
            {
                return -1;
            }
            
            else if(lhs > rhs)
            {
                return 1;
            }
        }
        return 0;
    }
    
    //generate size unique random integers in the range low through high.
    // store them in the selection set.
    private void generate()
    {
        Random randomNumber = new Random();
        //int firstNum = randomNumber.nextInt(high - low) + low;
        //for(int x = 0; x < size; x++)
        while(selection.size() != size)
        {
            int y = randomNumber.nextInt(high - low) + low;
            selection.add(y);
        }
    }
    
    /**
     * get the lowest range.
     * @return the lowest value of range.
     */
    public int getLow()
    {
        return low;
    }
    
    /**
     * get the highest range.
     * @return the highest value of range.
     */
    public int getHigh()
    {
        return high;
    }
    
    /**
     * get the size of the selection.
     * @return the size of the selection.
     */
    public int getSize()
    {
        return size;
    }
    
    /**
     * find the size of the intersection of this and winner's selection sets.
     * @param winner the winning selection to be compared.
     * @return the size of the intersection.
     */
    public int match(Selection winner)
    {
        Set<Integer> intersection = new TreeSet<> (selection);
        intersection.retainAll(winner.selection);
        return intersection.size();
    }
    
    @Override
    public String toString()
    {
        String display = "";
        Iterator<Integer> this_it = selection.iterator();
        
        while(this_it.hasNext())
        {
            display += String.format("%02d ", this_it.next());
        }     
        return display;
    }
    
    /**
     * test this class.
     * @param args
     */
    public static void main(String[]args)
    {
        //testing warning.
        System.out.println("testing");
        
        // a selection set of 9 unique random integers in the range 1 through 67.
        Selection lotto967 = new Selection(9,1,67);
        System.out.println(lotto967);
        
        // a selection set of 6 unique random integers in the range 1 through 49.
        Selection lotto649 = new Selection(6,1,49);
        System.out.println(lotto649);
    }
}
    
    
    

   
    

