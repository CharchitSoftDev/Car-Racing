package RacingCar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class working extends JPanel implements KeyListener ,ActionListener  {

	private int speed;
	private int space;
	private int WIDTH=500;
	private int HEIGHT=700;
	private int width=80;
	private int height=70;
	private Rectangle car;
	private int move=20;
	private int count=1;
	boolean linef=true;
	private ArrayList <Rectangle> ocars;
	private ArrayList <Rectangle> lines;

	private Random rand;
	 Timer timer;
	
	public working() {
		timer=new Timer(20,this);
	    rand=new Random();
		ocars=new ArrayList<Rectangle>();
		car=new Rectangle(WIDTH/2-90,HEIGHT-100,width,height);
		speed=2;
		space=300;
		lines=new ArrayList<Rectangle>();
		addKeyListener(this);
		setFocusable(true);
		addocars(true);
		addocars(true);
		addocars(true);
		addlines();
		addlines();
		addlines();
		timer.start();
	}
	public void addlines() {
		int x=WIDTH/2-2;
		int y=0;
		int width=4;
		int height=300;
		int space=20;
		if(linef)
		{
		  lines.add(new Rectangle(x,y-(lines.size()*20),width,height));
		}else {
			lines.add(new Rectangle(x,lines.get(lines.size()-1).y-space,width,height));
		}
	}
	public void addocars(boolean first)
	{
		int x=0;
		int y=0;
		int Height=height;
		int Width=width;
		int positionx=rand.nextInt()%2;
		if(positionx==0)
		{
			x=WIDTH/2-90;
		}else
		{
			x=WIDTH/2+10;
		}
		if(first)
		{
			ocars.add(new Rectangle(x,y-100-(ocars.size()*space),Width,Height));
		}else
		{
			ocars.add(new Rectangle(x,ocars.get(ocars.size()-1).y-500,Width,Height));
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(WIDTH/2-100, 0 , 200, HEIGHT);
		for(Rectangle r:lines)
		{
			g.fillRect(r.x, r.y, r.width, r.height);
		}
		
		g.setColor(Color.WHITE);
		g.drawLine(WIDTH/2,  0, WIDTH/2,HEIGHT );
		g.setColor(Color.RED);
		g.fillRect(car.x, car.y, car.width, car.height);
		g.setColor(Color.blue);
		g.drawLine(WIDTH/2,  0, WIDTH/2,HEIGHT );
		g.setColor(Color.MAGENTA);
		
		for(Rectangle r:ocars)
		{
			g.fillRect(r.x, r.y, r.width, r.height);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Rectangle rect;
		count++;
		for(int i=0;i<ocars.size();i++)
		{
			rect=ocars.get(i);
			if(count%1000==0) {
				speed++;
				if(move<50) {
					move+=10;
				}
			}
			rect.y+=speed;
		}
		//cars thrashing with opponent
		
		for(Rectangle r:ocars)
		{
			if(r.intersects(car))
			{
				car.y=r.y+height;
			
				
			}
			
		}
		for(int i=0;i<ocars.size();i++)
		{
			rect=ocars.get(i);
			if(rect.y+rect.height>HEIGHT)
			{
				ocars.remove(rect);
				addocars(false);
			}
		}
		for(int i=0;i<lines.size();i++)
		{
			rect=lines.get(i);
			if(rect.y+rect.height>HEIGHT)
			{
				lines.remove(rect);
				addlines();
			}
		}
		repaint();
	}
	public void moveup() {
		if(car.y-move<0)
		{
			
		}else
		{
			car.y-=move;
		}
	}
	public void movedown() {
		if(car.y+move+car.height>HEIGHT-1)
		{
			System.out.println("\b");
			
		}else
		{
			car.y+=move;
		}
	}
	public void moveleft() {
		if(car.x-move<WIDTH/2-90)
		{
			System.out.println("\b");
			
		}else
		{
			car.x-=move;
		}
	}
	public void moveright() {
		if(car.x+move>WIDTH/2+10)
		{
			System.out.println("\b");
			
		}else
		{
			car.x+=move;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		int key=e.getKeyCode();
		switch(key)
		{
		case KeyEvent.VK_UP:
			moveup();
			break;
		case KeyEvent.VK_DOWN:
			movedown();
			break;
		case KeyEvent.VK_RIGHT:
			moveright();
			break;
		case KeyEvent.VK_LEFT:
			moveleft();
			break;
			default:
				break;
			
		}
	}



}
