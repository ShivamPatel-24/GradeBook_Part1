// Shivam Patel
import java.time.LocalDate;
import java.util.Scanner;

public class Gradebook {
	
	static int count = 0;
	static Scanner sc;

	public static void main(String args[]) throws GradebookEmptyException, GradebookFullException, InvalidGradebookException {
		
		System.out.println("Enter the number of Grades you want to enter in Gradebook (1-20)");
		System.out.println();
		sc = new Scanner(System.in);
		
		int numGrades = 0;
		
		numGrades = Integer.parseInt(sc.nextLine());
		
		AssignmentInterface[] array = new AssignmentInterface[numGrades];
		
		for (int i = 0; i < numGrades; i++) {
			array[i] = new Quiz();
			array[i] = new Program();
			array[i] = new Discussion();
		}
		int num = 0;
		// String msg = "Your gradebook is empty";
		
		while (true) {
			num = printMenu();
			
			if (num == 9) break;		
			if (num == 1) {
				if (count > numGrades) {
					try {
						throw new GradebookFullException();
					} catch (GradebookFullException e) {
						System.out.println("Exception occured: " + e);
						System.out.println("Grade book is full");
						
					}
					
				}
				add(array);
			}
			if (num == 2) {
				
				if (count == 0) {
					try {
						throw new GradebookEmptyException();
					} catch (GradebookEmptyException e){
						System.out.println("Exception occured: " + e);
						System.out.println("Your gradebook is empty");
					}
				} 
				else {
					remove(array);
				}
			}
			if (num == 3) {
				if (count == 0) {
					try {
						throw new GradebookEmptyException();
					} catch (GradebookEmptyException e){
						System.out.println("Exception occured: " + e);
						System.out.println("Your gradebook is empty");
					}
				}
				else print(array);
			}
			if (num == 4) {
				if (count == 0) {
					try {
						throw new GradebookEmptyException();
					} catch (GradebookEmptyException e){
						System.out.println("Exception occured: " + e);
						System.out.println("Your gradebook is empty");
					}
				}
				else average(array);
			}
			if (num == 5) {
				if (count == 0) {
					try {
						throw new GradebookEmptyException();
					} catch (GradebookEmptyException e){
						System.out.println("Exception occured: " + e);
						System.out.println("Your gradebook is empty");
					}
				}
				else minMax(array);
			}
			if (num == 6) {
				if (count == 0) {
					try {
						throw new GradebookEmptyException();
					} catch (GradebookEmptyException e){
						System.out.println("Exception occured: " + e);
						System.out.println("Your gradebook is empty");
					}
				}
				else quizQuesAvg(array);
			}
			if (num == 7) {
				if (count == 0) {
					try {
						throw new GradebookEmptyException();
					} catch (GradebookEmptyException e){
						System.out.println("Exception occured: " + e);
						System.out.println("Your gradebook is empty");
					}
				}
				else readings(array);
			}
			if (num == 8) {
				if (count == 0) {
					try {
						throw new GradebookEmptyException();
					} catch (GradebookEmptyException e){
						System.out.println("Exception occured: " + e);
						System.out.println("Your gradebook is empty");
					}
				}
				else concepts(array);
			}
			
		}
		
		sc.close();
		
	}
	
	
	public static void add(AssignmentInterface [] array) {
		
		sc = new Scanner(System.in);
		Boolean check = false;
		
		System.out.println("Enter the type of grades you want to add ('Quiz', 'Discussion', 'Program')");
		String userChoice = sc.nextLine();
		
		if (userChoice.equalsIgnoreCase("Quiz")){
			System.out.println("Adding Quiz grades\n");
			check = true;
			addQuizGrades(array);
		}
		if (userChoice.equalsIgnoreCase("Discussion")){
			System.out.println("Adding Discussion grades\n");
			check = true;
			addDiscussionGrades(array);
		}
		if (userChoice.equalsIgnoreCase("Program")){
			System.out.println("Adding Program grades\n");
			check = true;
			addProgramGrades(array);
		}
			
		if (!check) {
			try {
				throw new InvalidGradebookException();
			} catch (InvalidGradebookException e) {
				System.out.println("Exception occured: " + e);
				System.out.println("You entered an invalid grade type");
				// e.printStackTrace();
			}
			
		}
		
	}
	
	public static void remove(AssignmentInterface [] array) throws InvalidGradebookException {
		
		sc = new Scanner(System.in);
		Boolean check = false;
		System.out.println("Enter the grade you want to remove");
		String userChoice = sc.nextLine();
		
		
		for (int i = 0; i < array.length; i++) {
			if (userChoice.equals(array[i].getName())) {
				for (int j = i; j < array.length-1; j++) {
					array[j] = array[j+1];
				}
				check = true;
			}
		}
		
		if (!check) {
			try {
				throw new InvalidGradebookException();
			} catch (InvalidGradebookException e) {
				System.out.println("Exception occured: " + e);
				System.out.println("You are trying to remove invalid grade");
				// e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void print(AssignmentInterface [] array) {
		

		for (int i = 0; i < array.length; i++) {
			System.out.println("Gradebook " + i + ": " + array[i].toString());
		}	
		
	}
	
	public static void average(AssignmentInterface [] array) {
		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += array[i].getScore();
		}
		System.out.println("average: " + sum / count);
		
	}
	
	public static void minMax(AssignmentInterface [] array) {
		int min = array[0].getScore();
		int max = array[0].getScore();
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i].getScore() < min) {
				min = array[i].getScore();
			}
			if (array[i].getScore() > max) {
				max = array[i].getScore();
			}
		}
		if (count == 1) {
			System.out.println("Highest: " + max + " Lowest: " + max);
		}
		else System.out.println("Highest: " + max + " Lowest: " + min);
		
	}
	
	public static void readings(AssignmentInterface [] array) {

		int c = 0;
		
		for (int i = 0; i < array.length; i++) {
			
			if (array[i].getType().equals("Discussion")) {
				if (((Discussion) array[i]).getReading() != null) {
					System.out.println("Discussion reading: " + ((Discussion) array[i]).getReading());
					c++;
				}
			}
		}	
		
		if (c == 0) {
			try {
				throw new GradebookEmptyException();
			} catch (GradebookEmptyException e){
				System.out.println("Exception occured: " + e);
				System.out.println("Your gradebook is empty");
			}
		}
	}
	
	public static void concepts(AssignmentInterface [] array) {

		int c = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i].getType().equals("Program")) {
				System.out.println("Concept: " + ((Program) array[i]).getConcept());
			}
		}	
		if (c == 0) {
			try {
				throw new GradebookEmptyException();
			} catch (GradebookEmptyException e){
				System.out.println("Exception occured: " + e);
				System.out.println("Your gradebook is empty");
			}
		}
	}
	
	public static void quizQuesAvg(AssignmentInterface [] array) {
		double sum = 0;
		int iQuiz = 0;
		for (int i = 0; i < array.length; i++) {
			
			if (array[i].getType().equals("Quiz")) {
				sum += ((Quiz) array[i]).getNumQuestion();
				iQuiz++;
			}
		}
		
		if (iQuiz == 0) {
			try {
				System.out.println("Average of number of questions on quizzes: " + (sum / iQuiz));			
			} catch (ArithmeticException e) {
				System.out.println("No discussion reading entered.");
			}
		}
		else System.out.println("Average of number of questions on quizzes: " + (sum / iQuiz));
	}
	
	public static void addQuizGrades(AssignmentInterface [] array) {
		
		Quiz q = new Quiz();
		// sc = new Scanner(System.in);
		System.out.println("Enter the name of Quiz");
		q.setName(sc.nextLine());
		
		System.out.println("Enter the Score");
		q.setScore(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Enter the Letter Grade");
		q.setLetter(sc.nextLine().charAt(0));
		
		System.out.println("Enter the Due Date (YYYY-MM-DD)");
		q.setDueDate(LocalDate.parse(sc.nextLine()));
		
		System.out.println("Enter the number of questions");
		q.setNumQuestion(Integer.parseInt(sc.nextLine()));
		
		array[count] = q;
		count++;
		// sc.close();
	}
	
	public static void addDiscussionGrades(AssignmentInterface [] array) {
		
		Discussion d = new Discussion();
		sc = new Scanner(System.in);
		System.out.println("Enter the name of discussion");
		d.setName(sc.nextLine());
		
		System.out.println("Enter the Score");
		d.setScore(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Enter the Letter Grade");
		d.setLetter(sc.nextLine().charAt(0));
		
		System.out.println("Enter the Due Date");
		d.setDueDate(LocalDate.parse(sc.nextLine()));
		
		System.out.println("Enter the reading associated with the discussion");
		d.setReading(sc.nextLine());
		
		array[count] = d;
		count++;
		// sc.close();
	}

	public static void addProgramGrades(AssignmentInterface [] array) {

		Program p = new Program();
		sc = new Scanner(System.in);
		System.out.println("Enter the name of Program");
		p.setName(sc.nextLine());
		
		System.out.println("Enter the Score");
		p.setScore(Integer.parseInt(sc.nextLine()));
		
		System.out.println("Enter the Letter Grade");
		p.setLetter(sc.nextLine().charAt(0));
		
		System.out.println("Enter the Due Date");
		p.setDueDate(LocalDate.parse(sc.nextLine()));
		
		System.out.println("Enter the concept of the program");
		p.setConcept(sc.nextLine());
		
		array[count] = p;
		count++;
		// sc.close();
	}
	
	
	public static int printMenu() {
		int num = 0;
		
		
		System.out.println("1. Add Grades");
		System.out.println("2. Remove grades");
		System.out.println("3. Print grades");
		System.out.println("4. Print averages");
		System.out.println("5. Print highest/lowest score(s)");
		System.out.println("6. Print QuizQuestion Average");
		System.out.println("7. Print Discussion Associated Readings");
		System.out.println("8. Print Program Concepts");
		System.out.println("9. Quit");
		
		num = sc.nextInt();	
		// sc.close();
		return num;		
	}
	
	

	
	
}
