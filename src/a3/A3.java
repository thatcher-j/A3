// **********************************************************************
// Programmer:	Joshua R. Thatcher
// Class:		CS40S
//
// Assignment:	A3
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
import java.util.ArrayList;

public class A3
{  // begin class
	public static void main(String args[]) throws IOException
	{  // begin main
	// ***** declaration of constants *****
	
	// ***** declaration of variables *****
	
	// ***** create objects *****
            int lParen;
            int rParen;
            int lSquare;
            int rSquare;
            int lCurly;
            int rCurly;
            Stack s = new Stack ();
            
            String strin;
            
            boolean ordered;
            
            ArrayList<String> order = new ArrayList ();
		
	// ***** create input stream *****
		BufferedReader fin = new BufferedReader (new FileReader (new File ("PolynomialData")));
		
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
                lParen = 0;
                rParen = 0;
                lSquare = 0;
                rSquare = 0;
                lCurly = 0;
                rCurly = 0;
                
                ordered = true;
            
                int n = strin.length ();

                for (int i = 0; i < n; i++)
                {
                    //s.push(strin.charAt(i));
                    switch (strin.charAt(i)) 
                    {
                        case '(':
                            lParen++;
                            s.push ("(");
                            break;
                        case ')':
                            rParen++;
                            if (s.pop () != "(")
                            {
                                ordered = false;
                            }   break;
                        case '[':
                            lSquare++;
                            s.push ("[");
                            break;
                        case ']':
                            rSquare++;
                            if (s.pop () != "[")
                            {
                                ordered = false;
                            }   break;
                        case '{':
                            lCurly++;
                            s.push ("{");
                            break;
                        case '}':
                            rCurly++;
                            if (s.pop () != "{")
                            {
                                ordered = false;
                            }   break;
                        default:
                            break;
                    }
                }
                
            // ***** output *****
            if ((lParen == rParen) && (lSquare == rSquare) && (lCurly == rCurly) && ordered)
            {
                System.out.println (strin + " is balanced");
            }
            else
            {
                System.out.println (strin + " is not balanced");
            }
            
            strin = fin.readLine();
        }
        
	// ***** closing message *****
	
		System.out.println("end of processing");
	
	}  // end main	
}  // end class
