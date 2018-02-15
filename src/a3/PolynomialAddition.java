// **********************************************************************
// Programmer:	Joshua R. Thatcher
// Class:		CS40S
//
// Assignment:	A3.2
//
// Description:	Client code for the addition of sparse representation polynomials
//
//
//	Input:		Requires input file "polyData.txt"
//
//  Output:		Outputs polynomials received and the result of addition between each other
// ***********************************************************************
package a3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PolynomialAddition
{  // begin class
	public static void main(String args[]) throws IOException
	{  // begin main
	// ***** declaration of constants *****
	
	// ***** declaration of variables *****
            String strin;
            String commaDelim = "[,]+";
            String delim = "[ ]+";
            String[] tokens;
            
            int count = 0;
            
            ArrayList<Polynomial> p = new ArrayList ();
	
	// ***** create objects *****
		
	// ***** create input stream *****
            BufferedReader fin = new BufferedReader (new FileReader (new File ("polyData.txt")));
            
	// ***** Print Banner *****
	
		System.out.println("**********************************");
		System.out.println("NAME:        Joshua R. Thatcher");
		System.out.println("Class:       CS40S");
		System.out.println("Assignment:  A3.2");
		System.out.println("**********************************");
		
	// ***** get input *****
        strin = fin.readLine ();
        
        while (strin != null) //eof loop to load arraylist of polynomials from text file
        {
        p.add (new Polynomial ());    
        
        tokens = strin.split (delim);
        
        for (int i = 0; i < tokens.length; i++)
        {
           String[] s = tokens[i].split(commaDelim);
           
           p.get(count).addTerm (new Term (Integer.parseInt(s[0]), (Integer.parseInt(s[1]))));
        }
        
        count++;
        strin = fin.readLine ();
        }
	
	// ***** processing *****
        
        for (int i = 0; i < p.size(); i += 2) //loop to output polynomials received and the result of addition between each other
        {
            System.out.println ("(" + p.get(i).toString() + ")");
            System.out.println (" + ");
            System.out.println ("(" + p.get(i+1).toString() + ")");
            
            Polynomial result = p.get(i).addWith(p.get(i+1));
            
            System.out.println (" = ");
            System.out.println ("(" + result.toString() + ")");
            
            System.out.println ("*********************");
        }
	// ***** output *****
	
	// ***** closing message *****
	
		System.out.println("end of processing");
	
	}  // end main	
}  // end class