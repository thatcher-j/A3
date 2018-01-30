// **********************************************************************
// Programmer:	Rob Sveinson
// Class:		CS20S
//
// Assignment:	aX qy
//
// Description:	a brief description of the program goes here
//
//
//	Input:		describe any input from keyboard or file
//
//  Output:		describe the result of your program
// ***********************************************************************
package a3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Josephus
{  // begin class
	public static void main(String args[]) throws IOException
	{  // begin main
	// ***** declaration of constants *****
	
	// ***** declaration of variables *****
            int n, m;
            String strin;
            String delim = "[ ]+";
            String[] tokens = new String[2];
	
	// ***** create objects *****
		
		
	// ***** create input stream *****
            BufferedReader fin = new BufferedReader (new FileReader (new File ("JosephusData")));
            
	// ***** Print Banner *****
	
		System.out.println("**********************************");
		System.out.println("NAME:        Your Name Here");
		System.out.println("Class:       CS30S");
		System.out.println("Assignment:  Ax Qy");
		System.out.println("**********************************");
		
	// ***** get input *****
            strin = fin.readLine();
	
	while (strin != null)
        {
            tokens = strin.split (delim);
            m = Integer.parseInt (tokens[0]);
            n = Integer.parseInt (tokens[1]);
            
            System.out.println ("Jospehus " + strin);
            
            Queue q = new Queue ();

            for (int i = 1; i <= n; i++)
            {
                q.enqueue(i);
            }

            System.out.print ("Order of Elimination: ");

            while (!q.isEmpty())
            {
                for (int i = 0; i < m - 1; i++)
                {
                    Object o = q.peek ();
                    q.dequeue();
                    q.enqueue(o); 
                }

                System.out.print (q.peek() + " ");

                q.dequeue ();
            }
                
            System.out.println ("\n");
                
            strin = fin.readLine();
        }
            System.out.println ("\n");
            
	// ***** output *****
        
	// ***** closing message *****
	
		System.out.println("end of processing");
	
	}  // end main	
}  // end class
