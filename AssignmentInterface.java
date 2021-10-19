// Shivam Patel
import java.time.LocalDate;

public interface AssignmentInterface {

	public int getScore();
	public char getLetter();
	public String getName();
	public LocalDate getDueDate();
	public String getType();

	public void setScore(int s);
	public void setLetter(char l);
	public void setName(String n);
	public void setDueDate(LocalDate d);
	
	public String toString();

}
