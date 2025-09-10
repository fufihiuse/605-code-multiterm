package intro.HelloWorld;

/**
 * Display "Hello, world!" and end the program. 
 * @author: Matthew Fluet
 * @author: Ben K Steele
 */
public class HelloWorld {

    //constructors cant explicitly return an instance
//    public HelloWorld() {
//        return new HelloWorld();
//    }
   /**
    * @param args Command line arguments. These are not used.
    */
   public static void main( String[] args ) {
       System.out.println( "Hello, world!" );
       String a = new String("a");
       String b = a;
       System.out.println(a==b);
   }

} // end class
