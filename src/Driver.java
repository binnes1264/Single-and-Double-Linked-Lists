import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;


public class Driver {

	public static void main(String[] args) {
	
		try {
			//Attempts to create new file or throws exception
			File file = new File ("dates.txt");
			file.createNewFile();
			
			//Calls method to create 100 dates and passes new file
			createDate(file);
			
			//Creates linked list objects
			doubLL<Numerology> dll = new doubLL<>();
			singLL<Numerology> sll = new singLL<>();
		
			/*Calls method to calculate prediction, instantiate Numerology,
			 *  and add objects to linked lists, passes linked lists and file*/
			crunchDate(sll, dll, file);
		
			//Sets n1 equal to head to start printing forwards via SLL
			singLL.Node<Numerology> n1 = sll.getHead();
		
				//Creates new file to store predictions
				File file2 = new File("predict.txt");
				file2.createNewFile();
				
				//Allows program to write to precition.txt
				PrintWriter a = new PrintWriter (file2);
				
				/*Begins printing forwards to the console by utilizing a for 
				 * loop and printing forwards to predict.txt */
			System.out.println("Printing forward using SLL");
			for(int k = 0; k < 100; k++) {
					
				System.out.println(n1.element.toString());
				a.println(n1.element.getPrediction());
					
				//Gets next value for n1
				n1 = sll.next(n1);
			}
			System.out.println();
			
			//Sets n2 equal to tail to start printing backwards via DLL
			doubLL.Node<Numerology> n2 = dll.getTail();
		
			System.out.println("Printing backwards using DLL");
			for(int n = 0; n < 100; n++) {
				
				System.out.println(n2.element.toString());
				
				//Gets previous value for n2
				n2 = dll.prev(n2);
			}
			//Closes PrintWriter
			a.close();
			
		}catch(IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}
	
	//Randomly generates dates and stores them in dates.txt
	public static void createDate(File file) {
		int dd = 0;
		int mm = 0;
		int yyyy = 0;
		
		//Creates file and writer
		try{PrintWriter b = new PrintWriter(file);
			
			//Opens random number generator
			Random rand = new Random();
			
			//Creates 100 random dates and prints to file
			for(int i = 0; i < 100; i++) {
			
				mm = rand.nextInt(12)+1;
				yyyy = rand.nextInt(520)+1500;
			
				//Generates dates based on what month equals
				if(mm == 2) {
					dd = rand.nextInt(28)+1;
				}
				else if(mm == 4 || mm == 6 || mm == 9 || mm == 11){
					dd = rand.nextInt(30)+1;
				}
				else {
					dd = rand.nextInt(31)+1;
				}
				
				//Prints date to dates.txt
				b.println(mm + " " + dd + " " + yyyy);
				
			}	
			//Closes PrintWriter
			b.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*Reads lines from dates.txt and calculates result to determine 
	prediction and instantiates 100 numerology objects*/
	public static void crunchDate(singLL<Numerology> sll, doubLL<Numerology> dll, File file) {
		
		String line = null;
		int mm = 0;
		int dd = 0;
		int yyyy = 0;
		int addition = 0;
		int temp = 0;
		String p = null;
		
		//tries to open scanner to dates.txt or throws exception
		try(Scanner in = new Scanner(file)) {
		
			//Loops 100 times for each date stored in dates.txt
			for(int i = 0; i < 100; i++) {
				
				//Resets temp to 0 after reiterating
				temp = 0;
			
				//Reads in next line and splits based on spaces, then stores in an array
				line = in.nextLine();
				String a[] = line.split(" ");
				
				//Converts values from array to integers and stores them
				mm = Integer.parseInt(a[0], 10);
				dd = Integer.parseInt(a[1], 10);
				yyyy = Integer.parseInt(a[2], 10);
			
				
				addition = mm + dd + yyyy;
				//Crunches date until its a single digit
				while(addition >= 10) {
					while(temp > -1) {
						temp = temp + (addition % 10);
						addition = addition / 10;
					
						if(addition == 0 && temp > 9) {
							addition = temp;
							temp = 0;
						}
						else if(addition == 0 && temp < 10) {
							addition = temp;
							temp = -1;
						}
					}
				}
			
				//Sets prediction based on value of crunched number
				switch(addition) {
				case 1: p = "You will have a good day!";
						break;
				case 2: p = "You will make a new friend!";
						break;
				case 3: p = "You will get the job!";
						break;
				case 4: p = "You will win the lottery!";
						break;
				case 5: p = "You will reconnect with an old friend!";
						break;
				case 6: p = "You will find something you lost!";
						break;
				case 7: p = "You will recieve a compliment!";
						break;
				case 8: p = "You will get a raise!";
						break;
				case 9: p = "Your dreams will come true!";
						break;
				default: p= "Invalid";
						break;
				}
			
				//Creates numerology object
				Numerology num = new Numerology(mm, dd, yyyy, addition, p);
				
				//Adds numerology object to linked-lists
				sll.addNode(num);
				dll.addNode(num);
			}
			//Closes Scanner
			in.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
