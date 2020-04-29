/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacollectionclasses;

import java.util.Iterator;


/**
 * A program that simulates a lottery ticket and lottery ticket checker machine.
 * Use interfaces, rather than inheritance, to make polymorphic calls.
 * Models a ticket extracting all the selection sets on it, and finally displays a message telling the ticket owner their prize amount.
 * Assignment 3
 * Date : 2017-04-3
 * @author Jasen Ratnam
 */
public class TicketChecker
{
    private static Selection winning_selection = null;  // the winning_selection.
    
    /**
     * intersect the winning selection set with each of the selection sets on this ticket.
     * Displaying information about the number of matches and prize amount.
     * @param ticket the ticket to be compared.
     * @return the total prize.
     */
    public static double PrintPrize(Ticket ticket)
    {
        //initialize the winning selection.
        if(winning_selection == null)
        {
            winning_selection = new Selection(ticket.getSelectionSize(), ticket.getLow(), ticket.getHigh());
        }
        int[] matchCount = new int[ticket.getTicketSize()];
        
        double[] selectionPrize = new double[ticket.getTicketSize()];
        
        double totalPrize = 0;

        //find the match count
        //find the selection prize.
        Iterator<Selection> iter1 = ticket.getListIterator();
        while(iter1.hasNext())
        {
            for(int x = 0; x < ticket.getTicketSize(); x++)
            {        
                matchCount[x] = iter1.next().match(winning_selection);
                
                if(matchCount[x] > 0)
                {
                    selectionPrize[x] = Math.pow(10,(matchCount[x]));
                }
                else
                {
                    selectionPrize[x] = 0;
                }
                // total prize winned.
                totalPrize += selectionPrize[x];
            }
        } 
        
        Iterator<Selection> iter2 = ticket.getListIterator();
        // create the display/
        String display = "winning selection: " + winning_selection + "\n";
        while(iter2.hasNext())
        {
            for(int x = 0; x < ticket.getTicketSize(); x++)
            {
                display += "selection: " + iter2.next().toString() + 
                           "   matches: " + matchCount[x] + "  prize: $" + 
                           String.format("%.2f",selectionPrize[x]) + "\n";
            }
        }
        
        display += String.format("%1$56s", "Total prize: $" + totalPrize);
        System.out.println(display);
        return totalPrize;
    }
    
    /**
     * test this class.
     * @param args
     */
    public static void main(String[]args)
    {
        //testing warning.
        System.out.println("testing");
       
        Ticket lucky = new Ticket(5, 6, 1, 49);
        TicketChecker.PrintPrize(lucky); 
        System.out.println("Thank you for playing and for keeping us rich!");
    }

}

        

        
    
