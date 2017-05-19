import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.sql.* ;


public  class Register {
    private JFrame AccountRegister = null;
    private JDialog Dialog;
    private JTextField textFieldName=new JTextField();
    private JTextField textFieldBirthday=new JTextField();
    private JTextField textFieldEmail=new JTextField();
    private JPasswordField passwordField=new JPasswordField();
    private JTextField textFieldAddress=new JTextField();
    private JTextField textFieldCellPhone=new JTextField();
    


    public void setVisible(boolean visible) {
        if (AccountRegister != null) {
            AccountRegister.setVisible(visible);
        }
    }

    public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        AccountRegister = new JFrame("Account Register");
        AccountRegister.setBounds(100, 100, 450, 300);
        AccountRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AccountRegister.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("User Name");
        lblName.setForeground(Color.BLUE);
        lblName.setBounds(33, 9, 75, 21);
        AccountRegister.getContentPane().add(lblName);

        textFieldName = new JTextField();
        textFieldName.setBounds(116, 6, 130, 26);
        AccountRegister.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);

        JLabel lblBirthday = new JLabel("Birthday");
        lblBirthday.setForeground(Color.BLUE);
        lblBirthday.setBounds(33, 42, 61, 23);
        AccountRegister.getContentPane().add(lblBirthday);

        textFieldBirthday = new JTextField();
        textFieldBirthday.setBounds(116, 40, 130, 26);
        AccountRegister.getContentPane().add(textFieldBirthday);
        textFieldBirthday.setColumns(10);
        
        JLabel lblDateFormat = new JLabel("(yyyy-mm-dd)");
        lblDateFormat.setForeground(Color.BLUE);
        lblDateFormat.setBounds(268, 43, 92, 21);
        AccountRegister.getContentPane().add(lblDateFormat);
        
        JLabel lblCellPhone = new JLabel("Cell Phone");
        lblCellPhone.setForeground(Color.BLUE);
        lblCellPhone.setBounds(33, 77, 75, 21);
        AccountRegister.getContentPane().add(lblCellPhone);
        
        textFieldCellPhone = new JTextField();
        textFieldCellPhone.setBounds(116, 75, 130, 26);
        AccountRegister.getContentPane().add(textFieldCellPhone);
        textFieldCellPhone.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.BLUE);
        lblEmail.setBounds(33, 118, 61, 16);
        AccountRegister.getContentPane().add(lblEmail);
        
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(116, 113, 130, 26);
        AccountRegister.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLUE);
        lblPassword.setBounds(33, 156, 61, 16);
        AccountRegister.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(116, 151, 130, 26);
        AccountRegister.getContentPane().add(passwordField);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(Color.BLUE);
        lblAddress.setBounds(33, 193, 61, 16);
        AccountRegister.getContentPane().add(lblAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(115, 185, 310, 33);
        AccountRegister.getContentPane().add(textFieldAddress);
        textFieldAddress.setColumns(10);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(new ActionListener() {
      
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
        		String url="jdbc:mysql://localhost:3306/Restaurant";
        		String user="root";
        		String password="root";
            		 
                	try {
                    Connection myConn = DriverManager.getConnection(url, user, password);
                    
                    String sql= "INSERT INTO `Restaurant`.`Register`" 
        					+"(`UserName`, `Birthday`,`CellPhone`, `Email`, `Password`,`Address`)"
        					+"VALUES (?,?,?,?,?,?)";
                    
                    PreparedStatement myPst =myConn.prepareStatement(sql);
                    myPst.setString(1,textFieldName.getText());
                    myPst.setString(2,textFieldBirthday.getText());
                    myPst.setString(3,textFieldCellPhone.getText());
                    myPst.setString(4,textFieldEmail.getText());
                    myPst.setString(5,passwordField.getText());
                    myPst.setString(6,textFieldAddress.getText());
                    myPst.executeUpdate();
                    myPst.close();
                    myConn.close();
                    JOptionPane.showMessageDialog(Dialog, "Congratulations! You have now successfully registered！", "",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception exc) {
                	JOptionPane.showMessageDialog(Dialog, "Please Fill Out This Form Completely And Accurately！", "",JOptionPane.WARNING_MESSAGE);
                	exc.printStackTrace();
                }
			}
        	
        });
        btnConfirm.setBounds(67, 232, 117, 29);
        AccountRegister.getContentPane().add(btnConfirm);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AccountRegister.dispose();
        		new StartPage().setVisible(true);
      
        	}
        });
        btnCancel.setBounds(243, 232, 117, 29);
        AccountRegister.getContentPane().add(btnCancel);

        JLabel lblBackground = new JLabel("Background");
        lblBackground.setIcon(new ImageIcon("src/Pictures/background.png"));
        lblBackground.setBounds(0, 0, 450, 278);
        AccountRegister.getContentPane().add(lblBackground);
        
        
    }

}
