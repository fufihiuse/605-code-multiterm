package generics.generics2;

// inheritance: area ->  square -> cube -> brick

import java.util.LinkedList;
import java.util.List;
public class VariablesUpperBound<T extends Cube> {

    T theThing;

    public VariablesUpperBound(T theThing)  {
	this.theThing = theThing;
    }
    public static void main(String[] args)	{
	    // UpperBoundExample<Square> aSquare = new UpperBoundExample<Square>(new Square());
	    VariablesUpperBound<Cube> aCube   = new VariablesUpperBound<Cube>(new Cube());
	    VariablesUpperBound<Brick> aBrick  = new VariablesUpperBound<Brick>(new Brick());
						// linked list op UpperBoundExample->Brick
	    List<VariablesUpperBound<Brick>> aList = new LinkedList<>();
						// linked list op UpperBoundExample->Square
	    List<VariablesUpperBound<Cube>> bList = new LinkedList<VariablesUpperBound<Cube>>();
	    List<VariablesUpperBound<? extends Cube>> cList = new LinkedList<>();
	    aList.add( new VariablesUpperBound<Brick>(new Brick() ) );
	    bList.add( new VariablesUpperBound<Cube>(new Cube() ) );
//	    					 cList.add( new UpperBoundExample<Square>(new Square() ) );
	    cList.add( new VariablesUpperBound<Brick>(new Brick() ) );

//	    cList.add( new UpperBoundExample<Square>(new Square() ) );
//UpperBoundExample.java:26: error: incompatible types: UpperBoundExample<Square> cannot be converted to UpperBoundExample<? extends Cube>
//	    cList.add( new UpperBoundExample<Square>(new Square() ) );
//	               ^


    }
}
