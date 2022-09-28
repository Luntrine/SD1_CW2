import java.util.Scanner;

/**
 * 
 * Software Development 1, Coursework 2.
 * 
 * Make sure you read the specification document on
 * Canvas in full before starting this assessment.
 * 
 */
public class CatRecogniser {

	public static void main(String[] args) {
		
		//The global variables listed at the beginning of the program are the integer arraySize and the boolean identify.
		
		boolean identify = true; //identify is set to true originally so that the question of continuing later can be asked.
		
		/*the next two lines declare the int arraySize as well as create a scanner 
		 to allow the arraySize variable to be initialized by a user input. */
		int arraySize;
		Scanner arraySizeScanner = new Scanner(System.in);
		
		/*The following do while loop makes it so that the program only moves on
		  when it has received a valid arraySize for the arrays "catName", "hairType", and "age". */
		do{
			
			System.out.println("How many cats do you have?");
			arraySize = arraySizeScanner.nextInt();
			
		}while(arraySize < 1);
		
		//The following code creates three arrays all with the length arraySize.
		String[] catName = new String[arraySize];
		String[] hairType = new String[arraySize];
		double[] age = new double[arraySize];
		
		//The following code replaces all null values with "" so that it works with error checking.
		
		for(int count = 0; count < arraySize; count++)
		{
			catName[count] = "";
			hairType[count] = "";
		}
		
		/*The following code fills the three arrays completely with information about cats.
		  It also makes sure the data is valid before entering it into the arrays. */
		for(int count = 0; count < arraySize; count++)
		{
			
			//This creates a scanner object that gathers a string inputed by the user.
			Scanner catNameScanner = new Scanner(System.in);

			/*The following while loop makes it so that the program only moves on
			  when it has received a valid name for a cat. */
			while(catName[count].equals("")){
				
				System.out.println("Please enter the name of cat #" + (count+1) + ":");
				catName[count] = catNameScanner.nextLine();
				
			}
			
			//This creates a scanner object that gathers a string inputed by the user.
			Scanner hairTypeScanner = new Scanner(System.in);

			/*The following while loop makes it so that the program only moves on
			  when it has received a valid hair type for a cat (either 'long' or 'short'). */
			while(!(hairType[count].equals("long")||hairType[count].equals("short"))){
				
				System.out.println("Does " + catName[count] + " have 'long' or 'short' hair?");
				hairType[count] = hairTypeScanner.nextLine();
				
			}
			
			//This creates a scanner object that gathers an integer inputed by the user.
			Scanner ageScanner = new Scanner(System.in);

			/*The following while loop makes it so that the program only moves on
			  when it has received a valid age for a cat. */
			while(age[count] <= 0){
				
				System.out.println("How old is " + catName[count] + "?");
				age[count] = catNameScanner.nextDouble();
				
			}
			
		}
		
		while(identify) {
			
			/*the next two lines declare the String identifyAsker as well as create a scanner 
			 to allow the identifyAsker variable to be changed by a user input. */
			String identifyAsker = "";
			Scanner identifyScanner = new Scanner(System.in);

			/*The following while loop makes it so that the program only moves on
			  when it has received a valid response (either 'yes' or 'no'). */
			while(!(identifyAsker.equals("yes")||identifyAsker.equals("no"))){
				
				System.out.println("Do you wish to identify a cat? Respond with 'yes' or 'no'.");
				identifyAsker = identifyScanner.nextLine();
				
			}
			
			
			//The following if statement asks if it is necessary to continue the program.
			if(identifyAsker.equals("yes"))
			{
				identify = true;
			}
			else //We don't need to specify "no". Because of the error checker, it's the only possible answer left.
			{
				identify = false;
			}
			
			
			//This code only runs if the user inputed that they wanted to identify a cat.
			if(identify) {
				
				/*the next two lines declare the String whatHair as well as create a scanner 
				 to allow the whatHair variable to be changed by a user input. */
				String whatHair = "";
				Scanner whatHairScanner = new Scanner(System.in);

				/*The following while loop makes it so that the program only moves on
				  when it has received a valid response (either 'long' or 'short'). */
				while(!(whatHair.equals("long")||whatHair.equals("short"))){
					
					System.out.println("Does it have 'long' or 'short' hair?");
					whatHair = whatHairScanner.nextLine();
					
				}
				
				/*the next two lines declare the String whatHair as well as create a scanner 
				 to allow the whatHair variable to be changed by a user input. */
				String howOld = "";
				Scanner howOldScanner = new Scanner(System.in);

				/*The following while loop makes it so that the program only moves on
				  when it has received a valid response (either 'young' or 'old'). */
				while(!(howOld.equals("young")||howOld.equals("old"))){
					
					System.out.println("Is it young or old? Old is 10 years old or more.");
					howOld = howOldScanner.nextLine();
					
				}
				
				System.out.println("The following cats meet this criteria:");
				
				/*The following code runs through the program until it has found and listed all of
				  the cats that meet the specifications. */
				
				for(int count = 0; count < catName.length; count++) 
				{
					if(hairType[count].equals(whatHair))
					{
						if(howOld.equals("young"))
						{
							if(age[count] < 10)
							{
								System.out.println("- " + catName[count] + " who is " + age[count]);
							}
						}
						else {
							if(age[count] >= 10)
							{
								System.out.println("- " + catName[count] + " who is " + age[count]);
							}
							
						}
						
					}
					
				}
				
			}
				
		}
		
		System.out.println("Program complete.");
		
	}

}