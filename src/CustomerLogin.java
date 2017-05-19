import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JDialog;
import org.omg.CORBA.PUBLIC_MEMBER;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.sound.sampled.AudioInputStream;
import java.applet.AudioClip;


public class CustomerLogin implements ActionListener {
    private JFrame Customer;
    private JTextField txtTypeName; 
    private JPasswordField passwordFiled;
    private JDialog Dialog;
    
    String[] choics = { "win.wav","lost.wav" }; 
	URL file1 = getClass().getResource(choics[0]); 
	URL file2 = getClass().getResource(choics[1]); 
	AudioClip soundWin = java.applet.Applet.newAudioClip(file1);
	AudioClip soundLost = java.applet.Applet.newAudioClip(file2);
	public void winVoice(){
		   soundWin.play();
	  }
	public void lostVoice(){
		   soundLost.play();
	  }
	
    public void setVisible(boolean visible) {
        if (Customer != null) {
        	Customer.setVisible(visible);
        }
    }
    


public CustomerLogin() {
        initialize();
    }

    private void initialize() {
        Customer = new JFrame("OrderRestaurant");
        Customer.getContentPane().setBackground(SystemColor.window);
        Customer.getContentPane().setForeground(Color.BLACK);
        Customer.setTitle("New Asian Restaurant Ordering System");
        Customer.setBounds(100, 100, 450, 300);
        Customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Customer.getContentPane().setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome To New Asian Restaurant");
        lblWelcome.setForeground(Color.ORANGE);
        lblWelcome.setBounds(108, 21, 229, 39);
        Customer.getContentPane().add(lblWelcome);

        JLabel lblUser = new JLabel("User Name");
        lblUser.setForeground(Color.BLUE);
        lblUser.setBounds(93, 72, 96, 29);
        Customer.getContentPane().add(lblUser);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLUE);
        lblPassword.setBounds(93, 121, 96, 29);
        Customer.getContentPane().add(lblPassword);

        txtTypeName = new JTextField();
        txtTypeName.setText("Enter Name");
        txtTypeName.setBounds(227, 73, 130, 26);
        Customer.getContentPane().add(txtTypeName);
        txtTypeName.setColumns(10);

        passwordFiled = new JPasswordField();
        passwordFiled.setBounds(227, 122, 130, 26);
        Customer.getContentPane().add(passwordFiled);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);
        btnLogin.setBounds(72, 186, 117, 29);
        Customer.getContentPane().add(btnLogin);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer.dispose();
	            new Register().setVisible(true);
			}
		});
        btnSignUp.setBounds(260, 186, 117, 29);
        Customer.getContentPane().add(btnSignUp);
        
        

        JLabel lblLobby = new JLabel("lobby");
        lblLobby.setIcon(new ImageIcon("src/Pictures/lobby.jpg"));
        lblLobby.setBounds(0, 0, 450, 278);
        Customer.getContentPane().add(lblLobby);

    }

    public void actionPerformed(ActionEvent e){
        
        Connection myConn=null;
    	PreparedStatement myPst=null;
    	ResultSet myRs=null;
    	
    	String url="jdbc:mysql://localhost:3306/Restaurant";
		String user="root";
		String password="root";
		String cmd=e.getActionCommand();
        if(cmd.equals("Login")) {
        	
            	try {
                myConn = DriverManager.getConnection(url, user, password);
                
                String sql= "SELECT *FROM `Restaurant`.`Register`" 
    					+"WHERE `UserName`=? AND `Password`=?";
                
                myPst =myConn.prepareStatement(sql);
                myPst.setString(1,txtTypeName.getText());
                myPst.setString(2,passwordFiled.getText());
                myRs=myPst.executeQuery();
               
                if(myRs.next()){
                	try{
		                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
		                
		                String sql1= "INSERT INTO `Restaurant`.`OrderFood`" 
	        					+"(`UserName`)"
	        					+"VALUES (?)";
	                    
	                    PreparedStatement Pst =Conn.prepareStatement(sql1);
	                    Pst.setString(1,txtTypeName.getText());
	                  
	               
	                    Pst.executeUpdate();
                	}catch(Exception ex){
		                ex.printStackTrace();
		            }
                	winVoice();
                	JOptionPane.showMessageDialog(Dialog, "Welcome Back!", "",JOptionPane.INFORMATION_MESSAGE);
                	Customer.dispose();
                    new FoodMenu().setVisible(true);
                    myPst.close();
                    myConn.close();
                    
                }
                else{
                	lostVoice();
                	JOptionPane.showMessageDialog(Dialog, "The User Name or Password is incorrect. Please try again.", "",JOptionPane.WARNING_MESSAGE);
                }
               
        }catch (Exception exc) {
        	exc.printStackTrace();
        }
        	
           
        

	}
 
}	
}
 
