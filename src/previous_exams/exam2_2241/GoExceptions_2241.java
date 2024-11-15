package exam2_2241;

public class GoExceptions_2241 {
	public static void runAndThrows() throws RuntimeException {
		int[] intArray = {2};
		try {
			try {
				intArray[0] = 1;
				System.out.println("2nd-try");
				try {
					intArray[1] = 0;
					System.out.println("3rd-try");
				}
				catch (ArrayIndexOutOfBoundsException e) {
					intArray[1] = 1;
					System.out.println("3rd-catch");
				}
			}
			catch (ArithmeticException e) { System.out.println("2nd-catch"); }
			finally {
				System.out.println("2nd-finally");
				intArray[1] = 1;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) { System.out.println("1st-catch"); }
	}

	public static void main (String[] args) {
		try {new GoExceptions_2241().runAndThrows();}
		catch (ArrayIndexOutOfBoundsException e) { System.out.println("Will I print?"); }
    }
}

// 1. What will be the output of this program?

//2nd-try
//2nd-finally
//1st-catch

//2. Will this program print the stack trace to the stderr? Explain.

//No. All exceptions are caught.