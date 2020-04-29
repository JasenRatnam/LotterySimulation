/*
 * Jasen Ratnam
 * Program for Computer Science with Maths.
 * In Vanier College.
 */
package javacollectionclasses;

/**
 * A program that simulates a lottery ticket and lottery ticket checker machine.
 * Use interfaces, rather than inheritance, to make polymorphic calls.
 * Drives the classes to create a ticket and check if it wins. 
 * Assignment 3
 * Date : 2017-04-3
 * @author Jasen Ratnam
 */
public class LottoTestDriver 
{

    /**
     *
     * @param args
     */
    public static void main(String[]args)
    {
        Ticket lucky = new Ticket(5, 6, 1, 49); // 5 plays of lotto 6/49
        
        // print the selection sets in the order that they were generated
        System.out.println("Ticket with ordered selections:");
        System.out.println(lucky);
        System.out.println();
        
        // print the selection sets in ascending order of selection sets
        System.out.println("Ticket with sorted selections:");
        System.out.println(lucky.toStringSorted());
        System.out.println();
        
        TicketChecker.PrintPrize(lucky); // do we feel lucky!?
        System.out.println("Thank you for playing and for keeping us rich!");
    }
    
}
