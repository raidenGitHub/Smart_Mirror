import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import javax.swing.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Smart_Mirror {

																				    // CLOCK CODE GOT FROM HERE http://stackoverflow.com/questions/2959718/dynamic-clock-in-java
																					// First begin by declaring the major variables. THIS IS FOR THE CLOCK
	private final SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm");
    private int   currentSecond;
    private Calendar calendar;
    																				// Moved this JLabel declaration up here (and made it Private Final) so that the start() command from below can access it!
    private final JLabel time = new JLabel("Time");
    

    
	private JFrame frmSmartMirrorInterface;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					

					
					
					
					Smart_Mirror window = new Smart_Mirror();
					window.frmSmartMirrorInterface.setVisible(true);
					
					
					
					window.start();										// This command activates the clock and updates it every couple of seconds!
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Smart_Mirror() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSmartMirrorInterface = new JFrame();
		frmSmartMirrorInterface.setTitle("Smart Mirror Interface 1.0.0");
		frmSmartMirrorInterface.getContentPane().setBackground(Color.BLACK);
		frmSmartMirrorInterface.setBounds(100, 100, 1280, 720);
		frmSmartMirrorInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSmartMirrorInterface.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Welcome to the Smart Mirror");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(12, 13, 752, 78);
		frmSmartMirrorInterface.getContentPane().add(lblTitle);
		time.setFont(new Font("Tahoma", Font.ITALIC, 52));
		
		
		time.setForeground(Color.WHITE);
		time.setBounds(22, 85, 340, 71);
		frmSmartMirrorInterface.getContentPane().add(time);
		
		
		
		
		
		

	
		
		
		
		
		
		
	}
	
	
    private void reset(){
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }
    
    
    public void start(){
        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate( new TimerTask(){
            public void run(){
                if( currentSecond == 60 ) {
                    reset();
                }
                time.setText( String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond ));
                currentSecond++;
            }
        }, 0, 1000 );
    }

}
