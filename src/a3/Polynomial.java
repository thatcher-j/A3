/* **********************************************************
 * Programmer:	Joshua R. Thatcher
 * Class:		CS40S
 * 
 * Assignment: Term project
 *
 * Description:	Class for sparse represented polynomials using LinkedList
 *
 * 
 * *************************************************************
 */
package a3;

 public class Polynomial
 {  // begin class
 	
 	// *********** class constants **********
 	
 	// ********** instance variable **********
        LinkedList terms;
 	
 	// ********** constructors ***********
        public Polynomial ()
        {
            terms = new LinkedList ();
        }
        
        public Polynomial (LinkedList t)
        {
            terms = t;
        }
 	
 	// ********** accessors **********
        public LinkedList getTerms () //return linkedList of the polynomial's terms
        {
            return terms;
            
        }
        
        public Polynomial addWith (Polynomial p) //add with another polynomial
        {
            LinkedList turms = p.getTerms();
            
            terms.reset();
            turms.reset();
            
            LinkedList temps = new LinkedList ();
            
            LinkedList n = new LinkedList ();
            
            while ((!turms.isEmpty()) || (!terms.isEmpty())) //while at least one polynomial has terms left to be computed
            {
                if ((!turms.isEmpty()) && (!terms.isEmpty())) //if both still have terms
                {
                    if (((Term) turms.get()).getOrder() > ((Term) terms.get()).getOrder()) //if one has a larger order than the other
                    {
                    n.insert (turms.get());
                    
                    turms.deleteFirst ();
                    }
                    else if (((Term) turms.get()).getOrder() < ((Term) terms.get()).getOrder()) //if one has a larger order than the other
                    {
                    n.insert (terms.get());
                    
                    temps.insert (terms.get());
                    terms.deleteFirst ();
                    }
                    else if (((Term) turms.get()).getOrder() == ((Term) terms.get()).getOrder()) //if their orders are equal
                    {
                    Term t = new Term (((Term) turms.get()).getCoefficient() + ((Term) terms.get()).getCoefficient(), ((Term) turms.get()).getOrder());
                    n.insert (t);
                    
                    temps.insert (terms.get());
                    terms.deleteFirst();
                    turms.deleteFirst(); 
                    }
                }
                else if (turms.isEmpty ()) //if one is empty
                {
                    n.insert (terms.get());
                    
                    temps.insert (terms.get());
                    terms.deleteFirst();
                }

                else if (terms.isEmpty ()) //if the other is empty
                {
                    n.insert (turms.get());

                    turms.deleteFirst ();
                }
            }
            
            terms = temps;
            
            return new Polynomial (n);
        }
        
        public void printOut () //print the polynomial unformatted to console
        {
            terms.reset ();
            
            System.out.println (((Term) terms.get()).getCoefficient() + "," + ((Term) terms.get()).getOrder());
            
            while (!terms.isAtEnd())
            {
                terms.next ();
                System.out.println (((Term) terms.get()).getCoefficient() + "," + ((Term) terms.get()).getOrder());
            }
        }
        
        @Override
        public String toString () //convert polynomial to a properly formatted string
        {
            terms.reset ();
            
            String result = "";
            LinkedList temps = new LinkedList ();
            
            while (!terms.isEmpty()) //while there remain terms to be read
            {
                if (((Term) terms.get()).getOrder() > 1) //if the term has an order greater than one
                {
                    if ((result != "") && ((Term) terms.get()).getCoefficient() > 0) //if the term is positive and not the first to be read
                    {
                        result += " + ";
                        
                        if (((Term) terms.get()).getCoefficient() != 1) //if the term has a non-one coefficient
                        {
                            result += (((Term) terms.get()).getCoefficient() + "x^" + ((Term) terms.get()).getOrder());
                        }
                        else //if the term's coefficient is one
                        {
                            result += ("x^" + ((Term) terms.get()).getOrder());
                        }
                    }
                    else if ((result != "") && ((Term) terms.get()).getCoefficient() < 0)  //if the term is negative and not the first to be read
                    {
                        result += " - ";
                        
                        if (Math.abs(((Term) terms.get()).getCoefficient()) != 1) //if the term has a non-one coefficient
                        {
                            result += (Math.abs(((Term) terms.get()).getCoefficient()) + "x^" + ((Term) terms.get()).getOrder());
                        }
                        else //if the term's coefficient is one
                        {
                            result += ("x^" + ((Term) terms.get()).getOrder());
                        }
                    }
                    else //if the term is the first to be read
                    {
                        if (Math.abs(((Term) terms.get()).getCoefficient()) != 1) //if the term has a non-one coefficient
                        {
                            result += (((Term) terms.get()).getCoefficient() + "x^" + ((Term) terms.get()).getOrder());
                        }
                        else if (((Term) terms.get()).getCoefficient() > 0) //if the term has a coefficient of +1
                        {
                            result += ("x^" + ((Term) terms.get()).getOrder());
                        }
                        else //if the term has a coefficient of -1
                        {
                            result += ("-x^" + ((Term) terms.get()).getOrder());
                        }
                    }
                }
                else if (((Term) terms.get()).getOrder() == 1) //if the term has an order of one
                {
                    if ((result != "") && ((Term) terms.get()).getCoefficient() > 0) //if the term is positive and not the first to be read
                    {
                        result += " + ";
                        
                        if (((Term) terms.get()).getCoefficient() != 1) //if the term has a non-one coefficient
                        {
                            result += (((Term) terms.get()).getCoefficient() + "x");
                        }
                        else //if the term has a coefficient of one
                        {
                            result += ("x");
                        }
                    }
                    else if ((result != "") && ((Term) terms.get()).getCoefficient() < 0) //if the term is negative and not the first to be read
                    {
                        result += " - ";
                        
                        if (((Term) terms.get()).getCoefficient() != 1) //if the term has a non-one coefficient
                        {
                            result += (Math.abs(((Term) terms.get()).getCoefficient()) + "x");
                        }
                        else //if the term has a coefficient of one
                        {
                            result += ("x");
                        }
                    }
                    else //if the term is the first to be read
                    {
                        if (((Term) terms.get()).getCoefficient() != 1) //if the term has a non-one coefficient
                        {
                            result += (((Term) terms.get()).getCoefficient() + "x");
                        }
                        else if (((Term) terms.get()).getCoefficient() > 0) //if the term has a coefficient of +1
                        {
                            result += ("x");
                        }
                        else //if the term has a coefficient of -1
                        {
                            result += ("-x");
                        }
                    }
                }
                else //if the term has an order of zero (constant)
                {
                    if ((result != "") && ((Term) terms.get()).getCoefficient() > 0) //if the term is positive and not the first to be read
                    {
                        result += " + ";
                        result += ((((Term) terms.get()).getCoefficient()));
                    }
                    else if ((result != "") && ((Term) terms.get()).getCoefficient() < 0) //if the term is negative and not the first to be read
                    {
                        result += " - ";
                        result += (Math.abs((((Term) terms.get()).getCoefficient())));
                    }
                    else if ((((Term) terms.get()).getCoefficient()) != 0) //if the term is the first to be read and is not zero
                    {
                        result += ((((Term) terms.get()).getCoefficient()));
                    }
                }
                
                temps.insert (terms.get());
                terms.deleteFirst();
            }
            
            terms = temps;
            
            return result;
        }
 	
 	// ********** mutators **********
        public void addTerm (Term t)
        {
            terms.insert(t);
        }
 
 }  // end class