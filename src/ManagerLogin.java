import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerLogin implements ActionListener{

	private JFrame Manager;
	private JTextField textFieldName;
	private JPasswordField passwordField;
	private JDialog Dialog;

	public void setVisible(boolean visible) {
        if (Manager != null) {
        	Manager.setVisible(visible);
        }
    }
    
	/**
	 * Create the application.
	 */
	public ManagerLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Manager = new JFrame("Manager Login");
		Manager.setBounds(100, 100, 450, 300);
		Manager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Manager.getContentPane().setLayout(null);
		
		JLabel lblPicture = new JLabel("");
		int widthPicture=79,heightPicture=86;
		ImageIcon imagePicture = new ImageIcon("src/Pictures/manager.png");
        imagePicture.setImage(imagePicture.getImage().getScaledInstance(widthPicture,heightPicture,Image.SCALE_DEFAULT));
        lblPicture.setIcon(imagePicture);
        lblPicture.setSize(widthPicture,heightPicture);
		lblPicture.setBounds(166, 21, 79, 86);
		Manager.getContentPane().add(lblPicture);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(90, 132, 57, 22);
		Manager.getContentPane().add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(181, 130, 130, 26);
		Manager.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(90, 166, 69, 22);
		Manager.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 168, 130, 22);
		Manager.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(64, 218, 117, 29);
		Manager.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(232, 218, 117, 29);
		Manager.getContentPane().add(btnCancel);
		
		JLabel lblBackground = new JLabel("");
		int widthBG=450,heightBG=278;
		ImageIcon imageBG = new ImageIcon("src/Pictures/DarkBlue.jpg");
        imageBG.setImage(imageBG.getImage().getScaledInstance(widthBG,heightBG,Image.SCALE_DEFAULT));
        lblBackground.setIcon(imageBG);
        lblBackground.setSize(widthBG,heightBG);
		lblBackground.setBounds(0, 0, 450, 278);
		Manager.getContentPane().add(lblBackground);
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
                
                String sql= "SELECT *FROM `Restaurant`.`Manager`" 
    					+"WHERE `ManagerName`=? AND `ManagerPassword`=?";
                
                myPst =myConn.prepareStatement(sql);
                myPst.setString(1,textFieldName.getText());
                myPst.setString(2,passwordField.getText());
                myRs=myPst.executeQuery();
                
                if(myRs.next()){
                	JOptionPane.showMessageDialog(Dialog, "Welcome Back!", "",JOptionPane.INFORMATION_MESSAGE);
                	Manager.dispose();
                    new ManagerAccess().setVisible(true);
                    myPst.close();
                    myConn.close();
               
                }
                else{
                	JOptionPane.showMessageDialog(Dialog, "Please try again!", "",JOptionPane.WARNING_MESSAGE);
                }
               
        }catch (Exception exc) {
        	exc.printStackTrace();
        }
        	}
        
        if (cmd.equals("Cancel")) {
        	Manager.dispose();
            new StartPage().setVisible(true);
       }

	}
}

