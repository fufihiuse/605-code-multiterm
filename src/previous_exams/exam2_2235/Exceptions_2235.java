package exam2.exam2_2235;

public class Exceptions_2235 {
	int[] intArray = {0};
	public void runAndThrows() throws RuntimeException {
		try {
			try {
				intArray[1] = 1;
				System.out.println("2nd-try");
				try {
					intArray[1] = 1;
					System.out.println("3rd-try");
				}
				catch (ArrayIndexOutOfBoundsException e) {
					intArray[1] = 1;
					System.out.println("3rd-catch");
				}
			}
			catch (ArrayIndexOutOfBoundsException e) { System.out.println("2nd-catch"); }
			finally {
				System.out.println("2nd-finally");
				intArray[1] = 1;
			}
		}
		catch (ArithmeticException e) { System.out.println("1st-catch"); }
	}

	public static void main (String[] args) {
		try{ new Exceptions_2235().runAndThrows(); }
		catch (Exception e) {} }
}

// 1. What will be the output of this program?

//2nd-catch
//2nd-finally

//2. Is there any uncaught exception in the execution of this program? If yes, which one(s)?

//No.

