package RacingCar;
import javax.swing.*;

public class play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     JFrame obj=new JFrame();
	     working work=new working();
		obj.setSize(500,720);
	    obj.setTitle("CAR RACING");
	    obj.setResizable(false);
	    obj.setVisible(true);
	    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    obj.add(work);

	}

}
