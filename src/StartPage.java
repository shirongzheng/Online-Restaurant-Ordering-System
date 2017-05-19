import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StartPage{

	private JFrame Status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.Status.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setVisible(boolean visible) {
        if (Status != null) {
            Status.setVisible(visible);
        }
    }
	/**
	 * Create the application.
	 */
	public StartPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Status = new JFrame();
		Status.setBounds(100, 100, 450, 350);
		Status.setTitle("New Asian Restaurant Ordering System");
		Status.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Status.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To New Asian Restaurant");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setBounds(78, 35, 306, 29);
		Status.getContentPane().add(lblNewLabel);
		
		JButton btnRegister = new JButton("Registered Customer");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
	            new CustomerLogin().setVisible(true);
			}
		});
		btnRegister.setBounds(133, 88, 170, 29);
		Status.getContentPane().add(btnRegister);
		
		JButton btnManager = new JButton("Manager");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
	            new ManagerLogin().setVisible(true);
			}
		});
		btnManager.setBounds(133, 141, 170, 29);
		Status.getContentPane().add(btnManager);
		
		JButton btnSurfer = new JButton("Surfer");
		btnSurfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
				new Retrieve().setVisible(true);
			}
		});
		btnSurfer.setBounds(133, 195, 170, 23);
		Status.getContentPane().add(btnSurfer);
		
		JButton btnReview = new JButton("Review");
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Status.dispose();
				new Review().setVisible(true);
			}
		});
		btnReview.setBounds(133, 249, 172, 29);
		Status.getContentPane().add(btnReview);
		
		JLabel lblLobby = new JLabel();
		lblLobby.setIcon(new ImageIcon("src/Pictures/lobby1.jpg"));
		lblLobby.setBounds(0, 0, 450, 328);
		Status.getContentPane().add(lblLobby);
		
		
	}
}
