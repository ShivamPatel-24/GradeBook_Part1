// Shivam Patel
import java.time.LocalDate;

public class Program implements AssignmentInterface {

	private int score;
	private char letter;
	private String name;
	private LocalDate dueDate;
	private String concept;
	
	// Getters
	public int getScore() {
        return score;
    }
	public char getLetter() {
        return letter;
    }
	public String getName() {
        return name;
    }
	public LocalDate getDueDate() {
        return dueDate;
    }
	public String getConcept() {
        return concept;
    }
	public String getType() {
		return "Program";
	}
	
	// setters
	public void setScore(int s) {
		score = s;
    }
	public void setLetter(char l) {
		letter = l;
    }
	public void setName(String n) {
		name = n;
    }
	public void setDueDate(LocalDate d) {
        dueDate = d;
    }
	public void setConcept(String con) {
		concept = con;
    }
	public String toString() {
		return ("Name: " + getName() + " Score: " + getScore() + " Letter Grade: " + getLetter() 
					+ " Due Date: " + getDueDate() + " Concept: " + getConcept());
	}
	
}
