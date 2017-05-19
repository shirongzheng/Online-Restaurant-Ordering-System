import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Review {

	private JFrame ReviewWindow;
	private JTextField textFieldName;
	private JTextField textFieldChef;
	private JDialog Dialog;
	private JTextField textFieldComment;

	public void setVisible(boolean visible) {
        if (ReviewWindow != null) {
        	ReviewWindow.setVisible(visible);
        }
    }
	
	/**
	 * Create the application.
	 */
	public Review() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ReviewWindow = new JFrame("Review And Rate");
		ReviewWindow.setBounds(300, 300, 700, 700);
		ReviewWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ReviewWindow.getContentPane().setLayout(null);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(111, 51, 551, 244);
		ReviewWindow.getContentPane().add(lblImage);
		
		textFieldChef = new JTextField();
		textFieldChef.setText("Show Chef's Name");
		textFieldChef.setBounds(496, 307, 130, 29);
		ReviewWindow.getContentPane().add(textFieldChef);
		textFieldChef.setColumns(10);
		
		Label lblStar = new Label("Rate Food From 1-5 Stars:");
		lblStar.setBounds(28, 362, 180, 26);
		ReviewWindow.getContentPane().add(lblStar);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	            try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt = myConn.createStatement();
	                ResultSet myRs = mySt.executeQuery("select * from Menu where FoodName = '"+textFieldName.getText()+"'");
	                if(myRs.next()){
	                    byte[] img = myRs.getBytes("FoodImage");
	                    ImageIcon image = new ImageIcon(img);
	                    Image im = image.getImage();
	                    Image myImg = im.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_SMOOTH);
	                    ImageIcon newImage = new ImageIcon(myImg);
	                    lblImage.setIcon(newImage);
	                    
	                    textFieldChef.setText(myRs.getString("ChefName"));
	                    textFieldChef.setForeground(Color.blue);
	                    
	                    
	                    
	                    
	                }
	                
	                else{
	                    JOptionPane.showMessageDialog(Dialog, "Please Enter Correct Food Name!", "",JOptionPane.WARNING_MESSAGE);
	                }
	            }catch(Exception ex){
	                ex.printStackTrace();
	            }
	        
			}
		});
		btnRetrieve.setBounds(111, 307, 117, 29);
		ReviewWindow.getContentPane().add(btnRetrieve);
		
		textFieldName = new JTextField();
		textFieldName.setText("Enter Food Name");
		textFieldName.setBounds(294, 307, 130, 26);
		ReviewWindow.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
	
		
		JButton btnReturnButton = new JButton("Return");
		btnReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewWindow.dispose();
				new StartPage().setVisible(true);
			}
		});
		btnReturnButton.setBounds(396, 617, 139, 29);
		ReviewWindow.getContentPane().add(btnReturnButton);
		
		JButton btnStar1 = new JButton("1 Star");
		btnStar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql1= "UPDATE `Restaurant`.`Menu` "
	                		+ "SET `1Star`=`1Star`+1 WHERE `FoodName`= '"+textFieldName.getText()+"'";
        			
                    mySt.executeUpdate(sql1);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Rating!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                    
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Rating!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		btnStar1.setBounds(229, 362, 71, 26);
		ReviewWindow.getContentPane().add(btnStar1);
		
		JButton btnStar2 = new JButton("2 Stars");
		btnStar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql2= "UPDATE `Restaurant`.`Menu` "
	                		+ "SET `2Star`=`2Star`+1 WHERE `FoodName`= '"+textFieldName.getText()+"'";
        			
                    mySt.executeUpdate(sql2);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Rating!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                       
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Rating!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		btnStar2.setBounds(323, 362, 71, 26);
		ReviewWindow.getContentPane().add(btnStar2);
		
		JButton btnStar3 = new JButton("3 Stars");
		btnStar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql3= "UPDATE `Restaurant`.`Menu` "
	                		+ "SET `3Star`=`3Star`+1 WHERE `FoodName`= '"+textFieldName.getText()+"'";
        			
                    mySt.executeUpdate(sql3);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Rating!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                       
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Rating!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		btnStar3.setBounds(420, 362, 71, 26);
		ReviewWindow.getContentPane().add(btnStar3);
		
		JButton btnStar4 = new JButton("4 Stars");
		btnStar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql4= "UPDATE `Restaurant`.`Menu` "
	                		+ "SET `4Star`=`4Star`+1 WHERE `FoodName`= '"+textFieldName.getText()+"'";
        			
                    mySt.executeUpdate(sql4);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Rating!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                       
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Rating!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		btnStar4.setBounds(520, 362, 71, 26);
		ReviewWindow.getContentPane().add(btnStar4);
		
		
		JButton btnStar5 = new JButton("5 Stars");
		btnStar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql5= "UPDATE `Restaurant`.`Menu` "
	                		+ "SET `5Star`=`5Star`+1 WHERE `FoodName`= '"+textFieldName.getText()+"'";
        			
                    mySt.executeUpdate(sql5);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Rating!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                       
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Rating!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		btnStar5.setBounds(496, 376, 71, 26);
		ReviewWindow.getContentPane().add(btnStar5);
		
		textFieldComment = new JTextField();
		textFieldComment.setBounds(111, 459, 506, 127);
		ReviewWindow.getContentPane().add(textFieldComment);
		textFieldComment.setColumns(10);
		
		JButton btnComment = new JButton("Submit Comment");
		btnComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
	                Statement mySt =myConn.createStatement();
	                String sql6= "UPDATE `Restaurant`.`Menu` "
	                		+ "SET `Comment`='"+(textFieldComment.getText())+"' WHERE `FoodName`= '"+textFieldName.getText()+"'";
        			
                    mySt.executeUpdate(sql6);
                    JOptionPane.showMessageDialog(Dialog, "Successfully Rating!", "",JOptionPane.INFORMATION_MESSAGE);
                    mySt.close();
                    myConn.close();
	                       
	            }catch(Exception ex){
	            	JOptionPane.showMessageDialog(Dialog, "Failed To Rating!", "",JOptionPane.WARNING_MESSAGE);
	                ex.printStackTrace();
	            }
			}
		});
		btnStar5.setBounds(618, 362, 71, 26);
		ReviewWindow.getContentPane().add(btnStar5);
		btnComment.setBounds(161, 617, 139, 29);
		ReviewWindow.getContentPane().add(btnComment);
		
		JLabel lblStarImage = new JLabel("");
		int widthSI=316,heightSI=63;
		ImageIcon imageSI = new ImageIcon("src/Pictures/RateStar.jpg");
        imageSI.setImage(imageSI.getImage().getScaledInstance(widthSI,heightSI,Image.SCALE_DEFAULT));
        lblStarImage.setIcon(imageSI);
        lblStarImage.setSize(widthSI,heightSI);
		lblStarImage.setBounds(206, 394, 316, 63);
		ReviewWindow.getContentPane().add(lblStarImage);
		
		
		JLabel lblWallpaper = new JLabel(" ");
		int widthBG=750,heightBG=678;
		ImageIcon imageBG = new ImageIcon("src/Pictures/lobby2.jpg");
        imageBG.setImage(imageBG.getImage().getScaledInstance(widthBG,heightBG,Image.SCALE_DEFAULT));
        lblWallpaper.setIcon(imageBG);
        lblWallpaper.setSize(widthBG,heightBG);
		lblWallpaper.setBounds(0, 0, 750, 678);
		ReviewWindow.getContentPane().add(lblWallpaper);
		
		
		
		
		
		
		
		
		
	
		
		
		
	}
}
