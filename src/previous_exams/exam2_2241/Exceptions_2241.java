package exam2_2241;

public class Exceptions_2241 {
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
			catch (ArithmeticException e) { System.out.println("2nd-catch"); }
			finally {
				System.out.println("2nd-finally");
				intArray[1] = 1;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) { System.out.println("1st-catch"); }
	}

	public static void main (String[] args) throws Exception {
		new Exceptions_2241().runAndThrows();
	}
}

// 1. What will be the output of this program?

//2nd-finally
//1st-catch

//2. Will this program print the stack trace to the stderr? Explain.

//No. main is throwing Exception object.