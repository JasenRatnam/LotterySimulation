/*
 * Jasen Ratnam
 * Program for Computer Science with Maths.
 * In Vanier College.
 */
package javacollectionclasses;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A program that simulates a lottery ticket and lottery ticket checker machine.
 * Use interfaces, rather than inheritance, to make polymorphic calls.
 * Model a ticket that has a specified number of selection sets.
 * Assignment 3
 * Date : 2017-04-3
 * @author Jasen Ratnam
 */
public class Ticket 
{
    private int selection_size;  // stores the size of a selection set.
    
    private int low;             // stores the lowest possible random integer.
    
    private int high;            // stores the highest possible random integer.
    
    private int ticket_size;     // stores the number of selection sets on this ticket.
    
    private List<Selection> selection_list = new LinkedList<>(); // List to hold selection_sets in this ticket.
    
    /**
     * Constructor method to constructs this new Ticket object, initializing it according to the supplied parameters.
     * @param ticket_size the number of selections in this ticket.
     * @param selection_size the number of integers in one selection.
     * @param low the lowest value possible in the range.
     * @param high the highest value possible in the range.
     */
    public Ticket (int ticket_size, int selection_size, int low, int high)
    {
        this.ticket_size = ticket_size;
        this.selection_size = selection_size;
        this.low = low;
        this.high = high;
        
        //generate the selections, ticket size times.
        for(int x = 0; x < this.ticket_size; x++)
        {
            selection_list.add(new Selection(this.selection_size, this.low, this.high)); 
        }
    }
    
    /**
     * make an iterator of the selection_list to scan it.
     * @return an iterator to scan the selection_list on this ticket.
     */
    public Iterator<Selection> getListIterator()
    {
        Iterator<Selection> this_it = selection_list.iterator();
        return this_it;
    }
    
    /**
     * get the lowest value of the range.
     * @return the lowest value of the range.
     */
    public int getLow()
    {
        return low;
    }
    
    /**
     * get the highest value of the range.
     * @return the highest value of the range.
     */
    public int getHigh()
    {
        return high;
    }
    
    /**
     * get the size of each selection.
     * @return the size of each selection.
     */
    public int getSelectionSize()
    {
        return selection_size;
    }
    
    /**
     * get the number of selection in this ticket.
     * @return the number of selections in this ticket.
     */
    public int getTicketSize()
    {
        return ticket_size;
    }
    
    /**
     * get the cost of one selection.
     * @return the cost of one selection
     */
    public double getSelectionCost()
    {
        double price = 3.00;
        return price;
    }
    
    /**
     * get the cost of the entire ticket.
     * @return the cost of the ticket.
     */
    public double getTicketCost()
    {
        double ticketCost = (getSelectionCost() * ticket_size);
        return ticketCost;
    }
    
    @Override
    public String toString()
    {
        Date date = new Date();
        String display = date.toString() + "\n" +
                         "selection size  : " + selection_size + "\n" +
                         "selection Range : [" + low + ", " + high +"]\n" +
                         "ticket size     : " + ticket_size + "\n" +
                         "ticket cost     : $" + String.format("%.1f", getTicketCost()) + "\n" +
                         "==================\n";
        
            for(Selection i : selection_list)
            {
                display += i.toString() + "\n";
            }
        display += "==================";
        return display;
    }
    
    /**
     * creates a toString with sorted selections.
     * @return a sorted String.
     */
    public String toStringSorted()
    {
        Date date = new Date();
        String display = date.toString() + "\n" +
                         "selection size  : " + selection_size + "\n" +
                         "selection Range : [" + low + " ," + high +"]\n" +
                         "ticket size     : " + ticket_size + "\n" +
                         "ticket cost     : $" + String.format("%.1f", getTicketCost()) + "\n" +
                         "==================\n";
       
        
//        Selection lowest = selection_list.get(0);
//        for(Selection first : selection_list)
//        {
//            if(lowest != first)
//            {
//                if(first.compareTo(lowest) == -1)
//                {
//                    lowest = first;
//                }
//            }
//        }
//        display += lowest.toString() + "\n";
        Collections.sort(selection_list);
        
        for(Selection i : selection_list)
            {
                display += i.toString() + "\n";
            }
        
//        for(int x = 0; x < (ticket_size - 1); x++)
//        {
//            Selection list = selection_list.get(x);
//            for(Selection other : selection_list)
//            {
//                if(other != lowest)
//                {
//                    if(other.compareTo(lowest) == -1)
//                    {
//                        list = other;
//                    }
//                }
//            }
//            display += list.toString() + "\n";    
//        }
        
        display += "==================";
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
        
       //Create a new ticket and print it ordered.
       Ticket lucky = new Ticket(5, 6, 1, 49);
       System.out.println("Ticket with ordered selections:");
       System.out.println(lucky);
       
       System.out.println();
        //print it sorted.
       System.out.println("Tickets with sorted slections:");
       System.out.println(lucky.toStringSorted());
       System.out.println();
    }
           
}
