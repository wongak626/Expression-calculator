//package problem_1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowDestroyer extends WindowAdapter
{
	public void windowClosing(WindowEvent e) 
	{
		System.exit(0);
	}
}
