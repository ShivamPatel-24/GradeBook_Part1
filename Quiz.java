// Shivam Patel
import java.time.LocalDate;

public class Quiz implements AssignmentInterface {

	private int score;
	private char letter;
	private String name;
	private LocalDate dueDate;
	private int numQuestion;
	
	// Getters
	public String getType() {
		return "Quiz";
	}
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
	public int getNumQuestion() {
        return numQuestion;
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
	public void setNumQuestion(int num) {
        numQuestion = num;
    }
	
	public String toString() {
		return ("Name: " + getName() + " Score: " + getScore() + " Letter Grade: " + getLetter() 
					+ " Due Date: " + getDueDate() + " Number of Questions: " + getNumQuestion());
	}
}
