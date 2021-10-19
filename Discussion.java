import java.time.LocalDate;

public class Discussion implements AssignmentInterface {

	private int score;
	private char letter;
	private String name;
	private LocalDate dueDate;
	private String reading;
	
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
	public String getReading() {
        return reading;
    }
	public String getType() {
		return "Discussion";
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
	public void setReading(String read) {
        reading = read;
    }
	public String toString() {
		return ("Name: " + getName() + " Score: " + getScore() + " Letter Grade: " + getLetter() 
					+ " Due Date: " + getDueDate() + " Associated Reading: " + getReading());
	}
	
	
}
