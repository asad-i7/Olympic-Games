
/*******************************************
Created by Asad Ishfaq

This is a program that allows users to repeatedly choose an event from the olympics, choose winning countries from gold
to bronze and then be given an output showing what countries were chosen and what they won. The user can do this as many
times as they like up until they decide to quit. Once quit the program will display the winning medalist from top to bottom in the form of table, which is then saved into a text file.

*******************************************/

import javax.swing.*; // imports java library for input/output
import java.io.*; // import java file input and output

class olympic // class name
{
	public static void main (String param[])
	{
		olympic(); // main method to be used
		System.exit(0); // exits after main method is run

	} // ends main

	public static void olympic() // this method outputs the result and asks the user if they would like to quit.
	{
		// declare variables

		String quit = ""; 
		String event = "";
		String table = "";
		int [] totalpoints = {0,0,0,0,0,0,0,0}; // array for total points
		int [] goldarray = {0,0,0,0,0,0,0,0};   // this is the gold array which holds five values
		int [] silverarray = {0,0,0,0,0,0,0,0}; // this is the silver array which holds five values
		int [] bronzearray = {0,0,0,0,0,0,0,0}; // this is the bronze array which holds five values
		String [] countryarray = {"England", "Spain", "France", "Germany", "Italy", "Wales", "Brazil", "USA"}; // array for country names

		JOptionPane.showMessageDialog(null, "Welcome to the Olympic Championships");

		JOptionPane.showMessageDialog(null, "The countries in this years olympics are: \n" + // showing user which countries are in the olympics
		"England \n" +
		"Spain \n" + 
		"Germany \n" +
		"France \n" +
		"Italy \n" +
		"Wales \n" +
		"Brazil \n" +
		"USA");

		while (!quit.equalsIgnoreCase("yes")) // starts a loop
		{

			String textinput;               // declares variable for user input
			int eventnumber = eventtype();  // declares a variable for eventnumber which is gained from another method
			event = event(eventnumber); // declares variable for event name

			if (event.equalsIgnoreCase("quit")) // if the event returned is the String "quit" then the program will return and exit
			{
				return;
			}

			String goldcountry = gold(goldarray);	// declares a variable for goldcountry which is given in another method 
			String silvercountry = silver(silverarray); // declares a variable for silvercountry which is given in another method 
			String bronzecountry = bronze(bronzearray); // declares a variable for bronzecountry which is given in another method 

			JOptionPane.showMessageDialog(null,"In the " + event + " event. " + goldcountry + " got Gold, " + silvercountry + " got Silver and " +        				bronzecountry + " got Bronze."); // outputs the user with the event results

			quit=JOptionPane.showInputDialog("Would you like to quit? (yes/no) "); // asks if user would like to quit.
		}

		getpoints(totalpoints, goldarray, silverarray, bronzearray);
		sort(totalpoints, goldarray, silverarray, bronzearray, countryarray);

		table = JOptionPane.showInputDialog("Would you like to view the table? (yes/no)");

		if (table.equalsIgnoreCase("yes"))
		{

		JOptionPane.showMessageDialog(null, "The table is sorted in total points order \n" +
		"Gold gives 3 points \n" +
		"Silver gives 2 points \n" +
		"Bronze gives 1 point \n" +
		"Here are the Results"); // shows the user the total medals won in each event
                
                      String tableOutput =
         "<html><table>" +
      "<tr><td>Country</td><td>Gold</td><td>Silver</td><td>Bronze</td><td>Total Points</td></tr>" +
      "<tr><td>" + countryarray[0] + "</td><td>" + goldarray[0] + "</td><td>" + silverarray[0] + "</td><td>" + bronzearray[0] + "</td><td>" + totalpoints[0] + "</td><tr>" +  
       "<tr><td>" + countryarray[1] + "</td><td>" + goldarray[1] + "</td><td>" + silverarray[1] + "</td><td>" + bronzearray[1] + "</td><td>" + totalpoints[1] + "</td><tr>" +               
       "<tr><td>" + countryarray[2] + "</td><td>" + goldarray[2] + "</td><td>" + silverarray[2] + "</td><td>" + bronzearray[2] + "</td><td>" + totalpoints[2] + "</td><tr>" +               
       "<tr><td>" + countryarray[3] + "</td><td>" + goldarray[3] + "</td><td>" + silverarray[3] + "</td><td>" + bronzearray[3] + "</td><td>" + totalpoints[3] + "</td><tr>" +               
       "<tr><td>" + countryarray[4] + "</td><td>" + goldarray[4] + "</td><td>" + silverarray[4] + "</td><td>" + bronzearray[4] + "</td><td>" + totalpoints[4] + "</td><tr>" +              
       "<tr><td>" + countryarray[5] + "</td><td>" + goldarray[5] + "</td><td>" + silverarray[5] + "</td><td>" + bronzearray[5] + "</td><td>" + totalpoints[5] + "</td><tr>" +    
        "<tr><td>" + countryarray[6] + "</td><td>" + goldarray[6] + "</td><td>" + silverarray[6] + "</td><td>" + bronzearray[6] + "</td><td>" + totalpoints[6] + "</td><tr>" +                   
         "<tr><td>" + countryarray[7] + "</td><td>" + goldarray[7] + "</td><td>" + silverarray[7] + "</td><td>" + bronzearray[7] + "</td><td>" + totalpoints[7] + "</td><tr>";               
           
      JOptionPane.showMessageDialog(
         null, tableOutput);
		}
                
          

	} // ends olympic


	public static int eventtype() // this method gains an event type an returns it the variable in the main method
	{

		String chooseevent = ""; // for chosen event
		String confirm = "";
		int eventnumber = 0;   // used for event number
		String newline = System.getProperty("line.separator"); // separates each lin in output dialog box.

		while(!confirm.equalsIgnoreCase("yes"))
		{
			chooseevent = JOptionPane.showInputDialog("1: 100m Sprint" +
			newline + "2: Football" +
			newline + "3: Canoe Sprint" +
			newline + "4: Boxing" +
			newline + "5: Table Tennis" +
			newline + "Please choose an event (1-5):"); // asks user to type in an event number.
			
			confirm = JOptionPane.showInputDialog("Are you sure? (yes/no)");
		}
	
		eventnumber = Integer.parseInt(chooseevent); // declares as an integer
             
		return eventnumber; // returns event number to previous method
             
	} // ends eventtype


	public static String event(int eventnumber) // this method gains an event name and returns it to the main method
	{
		String event = " ";

		if ( eventnumber == 1) // if statment used to get event name.
		{
			event="100m Sprint";
		}

		else if ( eventnumber == 2 ) // if statment used to get event name.
		{
			event="Football";
		}

		else if ( eventnumber == 3 ) // if statment used to get event name.
		{
			event="Canoe Sprint";
		}

		else if ( eventnumber == 4 ) // if statment used to get event name.
		{
			event="Boxing";
		}

		else if ( eventnumber == 5 ) // if statment used to get event name.
		{
			event="Table Tennis";
		}

		else    // if user failed to choose an event, program would automtically close as an event was not chosen.
		{
			JOptionPane.showMessageDialog(null,"Invalid Entry");
			event="quit";
			return event;
		}

		return event; // returns event name

	} // ends event method


	public static String gold(int [] goldarray) // this method gains the gold winning country, the array is also passed through
	{
		String confirm = " ";
		String goldcountry = " ";
		final int addtoarray=1;

		while (!confirm.equalsIgnoreCase("yes")) // while loop to confirm if correct country was typed in.
		{
             		goldcountry=JOptionPane.showInputDialog("Please enter the Gold winning country: "); // asks for the gold winning country.
			
			if (goldcountry.equalsIgnoreCase("England")) // if user types in england
			{
				goldarray [0] = goldarray [0] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (goldcountry.equalsIgnoreCase("Spain"))
			{
				goldarray [1] = goldarray [1] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (goldcountry.equalsIgnoreCase("France"))
			{
				goldarray [2] = goldarray [2] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (goldcountry.equalsIgnoreCase("Germany"))
			{
				goldarray [3] = goldarray [3] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (goldcountry.equalsIgnoreCase("Italy"))
			{
				goldarray [4] = goldarray [4] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (goldcountry.equalsIgnoreCase("Wales"))
			{
				goldarray [5] = goldarray [5] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (goldcountry.equalsIgnoreCase("Brazil"))
			{
				goldarray [6] = goldarray [6] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (goldcountry.equalsIgnoreCase("USA"))
			{
				goldarray [7] = goldarray [7] + addtoarray; // the array would add one value to the alocated position for that country
			}

			confirm = JOptionPane.showInputDialog(" Are you sure? (yes/no)"); // asks user to confirm country.
		}

		return goldcountry; // returns the String for goldcountry and returns the String

	} // ends gold method


	public static String silver(int [] silverarray) // this method gains the silver winning country and returns the String, the array is also passed through
	{
		String confirm = " ";
		String silvercountry = " ";
		final int addtoarray=1;

	    	while (!confirm.equalsIgnoreCase("yes")) // while loop to confirm if correct country was typed in.
		{
             		silvercountry=JOptionPane.showInputDialog("Please enter the Silver winning country: "); // asks for the silver winning country.
			
			if (silvercountry.equalsIgnoreCase("England"))
			{
				silverarray [0] = silverarray [0] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (silvercountry.equalsIgnoreCase("Spain"))
			{
				silverarray [1] = silverarray [1] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (silvercountry.equalsIgnoreCase("France"))
			{
				silverarray [2] = silverarray [2] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (silvercountry.equalsIgnoreCase("Germany"))
			{
				silverarray [3] = silverarray [3] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (silvercountry.equalsIgnoreCase("Italy"))
			{
				silverarray [4] = silverarray [4] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (silvercountry.equalsIgnoreCase("Wales"))
			{
				silverarray [5] = silverarray [5] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (silvercountry.equalsIgnoreCase("Brazil"))
			{
				silverarray [6] = silverarray [6] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (silvercountry.equalsIgnoreCase("USA"))
			{
				silverarray [7] = silverarray [7] + addtoarray; // the array would add one value to the alocated position for that country
			}

			confirm = JOptionPane.showInputDialog(" Are you sure? (yes/no)"); // asks user to confirm country.
		}

		return silvercountry; // returns the String for goldcountry 

	   } // ends silver method


	   public static String bronze(int [] bronzearray) // this method gains the bronze winning country and returns the String, the array is also passed through
	   {
		String confirm = " ";
		String bronzecountry = " ";
		final int addtoarray=1;

	        while (!confirm.equalsIgnoreCase("yes")) // while loop to confirm if correct country was typed in.
		{
             		bronzecountry=JOptionPane.showInputDialog("Please enter the Bronze winning country: "); // asks for the bronze winning country.

			if (bronzecountry.equalsIgnoreCase("England"))
			{
				bronzearray [0] = bronzearray [0] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (bronzecountry.equalsIgnoreCase("Spain"))
			{
				bronzearray [1] = bronzearray [1] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (bronzecountry.equalsIgnoreCase("France"))
			{
				bronzearray [2] = bronzearray [2] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (bronzecountry.equalsIgnoreCase("Germany"))
			{
				bronzearray [3] = bronzearray [3] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (bronzecountry.equalsIgnoreCase("Italy"))
			{
				bronzearray [4] = bronzearray [4] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (bronzecountry.equalsIgnoreCase("Wales"))
			{
				bronzearray [5] = bronzearray [5] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (bronzecountry.equalsIgnoreCase("Brazil"))
			{
				bronzearray [6] = bronzearray [6] + addtoarray; // the array would add one value to the alocated position for that country
			}

			else if (bronzecountry.equalsIgnoreCase("USA"))
			{
				bronzearray [7] = bronzearray [7] + addtoarray; // the array would add one value to the alocated position for that country
			}

			confirm = JOptionPane.showInputDialog(" Are you sure? (yes/no)"); // asks user to confirm country.
		}

		return bronzecountry; // returns the String for goldcountry

	   } // ends bronze method

	
	public static void getpoints(int [] totalpoints, int [] goldarray, int [] silverarray, int [] bronzearray) // this method totals up all points
	{
		
		for (int i=0; i<8; i++) // uses a loop to total up points for each country
		{
		int gold = goldarray[i] * 3; // gold medals gives 3 points
		int silver = silverarray[i] * 2; // silver medals gives 2 points
		int bronze = bronzearray[i]; // bronze medals only give one point
		totalpoints[i] = gold + silver + bronze; // total points
		} // ends for loops	
	
	} // ends getpoints
	
	public static void sort (int[] totalpoints, int [] goldarray, int [] silverarray, int [] bronzearray, String [] countryarray) // this is the sort method.
	{

		boolean sorted=false; // making a boolean with false

		while (!sorted)
		{

			String [] temp = new String [8]; // makes a temporary array
			sorted = true; 
            
			for (int i=0; i < totalpoints.length-1; i++) // uses a for loop to bubble sort the array.
			{

				if (totalpoints[i] < totalpoints [i+1])
				{

				int tmp1 = totalpoints[i+1]; // this sorts the points array
				totalpoints[i+1] = totalpoints[i];
				totalpoints[i] = tmp1;

				int tmp2 = goldarray[i+1]; // this sorts the gold country arrays
				goldarray[i+1] = goldarray[i];
				goldarray[i] = tmp2;

				int tmp3 = silverarray[i+1]; // this sorts the silver country arrays
				silverarray[i+1] = silverarray[i];
				silverarray[i] = tmp3;

				int tmp4 = bronzearray[i+1]; // this sorts the bronze country arrays
				bronzearray[i+1] = bronzearray[i];
				bronzearray[i] = tmp4;	

				temp[i] = countryarray [i + 1]; // this sorts the country names
				countryarray [i+1] = countryarray[i];
				countryarray[i] = temp[i];			
					   
				sorted = false;

			        } // if statement

		       } // end for loop

		} // end while loop

	} // ends sortgold

} // ends class
