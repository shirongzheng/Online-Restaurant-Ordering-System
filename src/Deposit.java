import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;


public class Deposit {

	private JFrame Deposit;
	private JTextField textFieldUserName;
	private JTextField textFieldAmount;
	private JTextField textFieldCreditCard;
	private JTextField textFieldExpiration;
	private JTextField textFieldCVS;
	private JDialog Dialog;

	public void setVisible(boolean visible) {
        if (Deposit != null) {
        	Deposit.setVisible(visible);
        }
    }

	/**
	 * Create the application.
	 */
	public Deposit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Deposit = new JFrame("Deposit Money");
		Deposit.setBounds(100, 100, 650, 600);
		Deposit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Deposit.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(181, 86, 97, 33);
		Deposit.getContentPane().add(lblUserName);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(326, 89, 130, 26);
		Deposit.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount($):");
		lblAmount.setBounds(181, 146, 97, 33);
		Deposit.getContentPane().add(lblAmount);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(326, 149, 130, 26);
		Deposit.getContentPane().add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JLabel lblLogo = new JLabel("");
		int widthLG=450,heightLG=74;
		ImageIcon imageLG = new ImageIcon("src/Pictures/CreditCard.jpeg");
        imageLG.setImage(imageLG.getImage().getScaledInstance(widthLG,heightLG,Image.SCALE_DEFAULT));
        lblLogo.setIcon(imageLG);
        lblLogo.setSize(widthLG,heightLG);
		lblLogo.setBounds(96, 208, 450, 74);
		Deposit.getContentPane().add(lblLogo);
		
		JLabel lblCreditCard = new JLabel("Credit Card Number:");
		lblCreditCard.setBounds(165, 305, 130, 33);
		Deposit.getContentPane().add(lblCreditCard);
		
		textFieldCreditCard = new JTextField();
		textFieldCreditCard.setBounds(326, 308, 130, 26);
		Deposit.getContentPane().add(textFieldCreditCard);
		textFieldCreditCard.setColumns(10);
		
		JLabel lblExpiration = new JLabel("Expiration Date:");
		lblExpiration.setBounds(165, 371, 130, 33);
		Deposit.getContentPane().add(lblExpiration);
		
		textFieldExpiration = new JTextField();
		textFieldExpiration.setBounds(326, 374, 130, 26);
		Deposit.getContentPane().add(textFieldExpiration);
		textFieldExpiration.setColumns(10);
		
		JLabel lblCVS = new JLabel("CVS:");
		lblCVS.setBounds(165, 441, 130, 33);
		Deposit.getContentPane().add(lblCVS);
		
		textFieldCVS = new JTextField();
		textFieldCVS.setBounds(326, 444, 130, 26);
		Deposit.getContentPane().add(textFieldCVS);
		textFieldCVS.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql= "UPDATE `Restaurant`.`Register` "
	                		+ "SET `Deposit`=`Deposit`+'"+(textFieldAmount.getText())+"' WHERE `UserName`= '"+textFieldUserName.getText()+"'";
        			
                    mySt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Deposit!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                    
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Deposit!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		btnConfirm.setBounds(149, 528, 117, 29);
		Deposit.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit.dispose();
				new StartPage().setVisible(true);
			}
		});
		btnCancel.setBounds(360, 528, 117, 29);
		Deposit.getContentPane().add(btnCancel);
		
		JLabel lblBackground = new JLabel("");
		int widthBG=650,heightBG=678;
		ImageIcon imageBG = new ImageIcon("src/Pictures/DarkBlue.jpg");
        imageBG.setImage(imageBG.getImage().getScaledInstance(widthBG,heightBG,Image.SCALE_DEFAULT));
        lblBackground.setIcon(imageBG);
        lblBackground.setSize(widthBG,heightBG);
		lblBackground.setBounds(0, 0, 650, 578);
		Deposit.getContentPane().add(lblBackground);
	}
}
