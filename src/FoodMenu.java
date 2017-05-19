import java.awt.Checkbox;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.sound.sampled.AudioInputStream;
import java.applet.AudioClip;

public class FoodMenu implements ItemListener {

	private JFrame FoodMenu;
	private JDialog Dialog;
	private JTextField txtEnterUsername;
	double totalFood;
	double foodSSP=0;
	double foodMPTF=0;
	double foodSSM=0;
	double foodSS=0;
	double foodPD=0;
	double foodBBB=0;
	double foodNM=0;
	double foodSF=0;
	double foodSBS=0;
	double foodHS=0;
	double foodBWB=0;
	double foodKPC=0;
	double foodJR=0;
	double foodHSMBS=0;
	double foodWN=0;
	int QtySSP=0;
	int QtyMPTF=0;
	int QtySSM=0;
	int QtySS=0;
	int QtyPD=0;
	int QtyBBB=0;
	int QtyNM=0;
	int QtySF=0;
	int QtySBS=0;
	int QtyHS=0;
	int QtyBWB=0;
	int QtyKPC=0;
	int QtyJR=0;
	int QtyHSMBS=0;
	int QtyWN=0;
	String totalOrder;
	String strSSP="";
	String strMPTF="";
	String strSSM="";
	String strSS="";
	String strPD="";
	String strBBB="";
	String strNM="";
	String strSF="";
	String strSBS="";
	String strHS="";
	String strBWB="";
	String strKPC="";
	String strJR="";
	String strHSMBS="";
	String strWN="";
	int PreQtySSP = 1;
	int PreQtyMPTF = 1;
	int PreQtySSM = 1;
	int PreQtySS = 1;
	int PreQtyPD = 1;
	int PreQtyBBB = 1;
	int PreQtyNM = 1;
	int PreQtySF = 1;
	int PreQtySBS = 1;
	int PreQtyHS = 1;
	int PreQtyBWB = 1;
	int PreQtyKPC = 1;
	int PreQtyJR = 1;
	int PreQtyHSMBS = 1;
	int PreQtyWN = 1;
	
	 String[] choics = { "SoftMusic.wav" }; 
		URL file1 = getClass().getResource(choics[0]); 
		AudioClip SoftMusic = java.applet.Applet.newAudioClip(file1);
		
		public void SoftMusic(){
			   SoftMusic.play();
		  }
	
	public void setVisible(boolean visible) {
        if (FoodMenu != null) {
        	FoodMenu.setVisible(visible);
        }
    }
	
	/**
	 * Create the application.
	 */
	public FoodMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		FoodMenu = new JFrame("New Asian Restaurant Ordering System");
		FoodMenu.setBounds(700, 700, 1500, 1500);
		FoodMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FoodMenu.getContentPane().setLayout(null);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodMenu.dispose();
				new StartPage().setVisible(true);
			    SoftMusic.stop();
			}
		});
		btnReturn.setBounds(0, 0, 117, 29);
		FoodMenu.getContentPane().add(btnReturn);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(1060, 484, 81, 27);
		FoodMenu.getContentPane().add(lblBalance);
		
		JLabel lbltotalFood = new JLabel("");
		lbltotalFood.setBounds(1121, 474, 81, 37);
		FoodMenu.getContentPane().add(lbltotalFood);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setText("Enter UserName");
		txtEnterUsername.setBounds(1060, 540, 117, 27);
		FoodMenu.getContentPane().add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		JLabel lblOrder = new JLabel("");
		lblOrder.setBounds(6, 630, 1258, 45);
		FoodMenu.getContentPane().add(lblOrder);
		
		JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodMenu.dispose();
	            new Deposit().setVisible(true);
			}
		});
		btnDeposit.setBounds(139, 0, 117, 29);
		FoodMenu.getContentPane().add(btnDeposit);
		
		JButton btnMusic = new JButton("Music");
		btnMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoftMusic();
			}
		});
		btnMusic.setBounds(286, 0, 117, 29);
		FoodMenu.getContentPane().add(btnMusic);
		
		JButton btnPayBalance = new JButton("Pay Balance");
		btnPayBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try{
		                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
		                Statement mySt =myConn.createStatement();
		                String sql= "UPDATE `Restaurant`.`OrderFood` "
		                		+ "SET `Order`='"+(lblOrder.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
	        			
	                    mySt.executeUpdate(sql);
	                    try{
			                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
			                Statement St =Conn.createStatement();
			                String sql1= "UPDATE `Restaurant`.`Register` "
			                		+ "SET `Deposit`=`Deposit`-'"+(lbltotalFood.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
		        			
		                    St.executeUpdate(sql1);
		                    try{
				                Connection SpentConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Restaurant","root","root");
				                Statement SpentSt =SpentConn.createStatement();
				                String SpentSql= "UPDATE `Restaurant`.`Register` "
				                		+ "SET `Spent`=`Spent`+'"+(lbltotalFood.getText())+"' WHERE `UserName`= '"+txtEnterUsername.getText()+"'";
			        			
			                    SpentSt.executeUpdate(SpentSql);
			                 
			                    SpentSt.close();
			                    SpentConn.close();
				                
	   
				            }catch(Exception ex){
				            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
				                ex.printStackTrace();
				            }
		                    
		                    St.close();
		                    Conn.close();
			                
   
			            }catch(Exception ex){
			            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
			                ex.printStackTrace();
			            }
	                    JOptionPane.showMessageDialog(Dialog, "Successfully Ordered Food!", "",JOptionPane.INFORMATION_MESSAGE);
	                    mySt.close();
	                    myConn.close();
		                
		                
		                
		            }catch(Exception ex){
		            	JOptionPane.showMessageDialog(Dialog, "Failed To Order!", "",JOptionPane.WARNING_MESSAGE);
		                ex.printStackTrace();
		            }
		        
			
			}
		});
		btnPayBalance.setBounds(1060, 578, 117, 29);
		FoodMenu.getContentPane().add(btnPayBalance);
		
		
		
			
		//Food: Sweet Sour Pork 
				JLabel lblSweetSourPork = new JLabel("");
				int widthSSP=68,heightSSP=51;
				ImageIcon imageSSP = new ImageIcon("src/FoodList/SweetSourPork.jpg");
		        imageSSP.setImage(imageSSP.getImage().getScaledInstance(widthSSP,heightSSP,Image.SCALE_DEFAULT));
		        lblSweetSourPork.setIcon(imageSSP);
		        lblSweetSourPork.setSize(widthSSP,heightSSP);
		        lblSweetSourPork.setBounds(46, 83, 81, 65);
		        FoodMenu.getContentPane().add(lblSweetSourPork);
				
		        JSpinner spinnerSSP = new JSpinner();
				spinnerSSP.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerSSP.setEnabled(false);
				spinnerSSP.setBounds(78, 184, 56, 23);
				FoodMenu.getContentPane().add(spinnerSSP);
			
				
				JCheckBox chckbxSSP = new JCheckBox(" ");
				chckbxSSP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxSSP.isSelected()){
							spinnerSSP.setEnabled(true);
							foodSSP=foodSSP+13;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSSP="Sweet Sour Pork" + "("+String.valueOf(PreQtySSP)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							
							spinnerSSP.setEnabled(false);
							spinnerSSP.setValue(1);
							foodSSP=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSSP=" ";
							PreQtySSP = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
							
						}
					}
				});
				chckbxSSP.setBounds(6, 110, 128, 23);
				FoodMenu.getContentPane().add(chckbxSSP);
				
			
				spinnerSSP.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSSP=13;
						 
						 if(chckbxSSP.isSelected()){
							 PreQtySSP=(Integer)spinnerSSP.getValue();
						 if(PreQtySSP>QtySSP){
							 QtySSP = PreQtySSP;
					         foodSSP = RateSSP * PreQtySSP;
					         strSSP="Sweet Sour Pork" + "("+String.valueOf(PreQtySSP)+")";
							 totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							 
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					         }else if(PreQtySSP<=QtySSP){
							 QtySSP = PreQtySSP;
					         foodSSP = RateSSP * PreQtySSP;
					         strSSP="Sweet Sour Pork" + "("+String.valueOf(PreQtySSP)+")";
							 totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							 
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lblOrder.setText(String.valueOf(totalOrder));
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				
				JLabel lblSSP = new JLabel("Sweet Sour Pork ($13)");
				lblSSP.setBounds(21, 160, 137, 12);
				FoodMenu.getContentPane().add(lblSSP);
				
				JLabel lblQtySSP = new JLabel("Qty:");
				lblQtySSP.setBounds(44, 187, 31, 19);
				FoodMenu.getContentPane().add(lblQtySSP);
				
				
				//FoodL: Ma Po Tofu
				JLabel lblMaPoToFu = new JLabel("");
				int widthMPTF=81,heightMPTF=65;
				ImageIcon imageMPTF = new ImageIcon("src/FoodList/MapoTofu.jpg");
		        imageMPTF.setImage(imageMPTF.getImage().getScaledInstance(widthMPTF,heightMPTF,Image.SCALE_DEFAULT));
		        lblMaPoToFu.setIcon(imageMPTF);
		        lblMaPoToFu.setSize(widthMPTF,heightMPTF);
		        lblMaPoToFu.setBounds(263, 83, 81, 65);
				FoodMenu.getContentPane().add(lblMaPoToFu);
				
				JSpinner spinnerMPTF = new JSpinner();
				spinnerMPTF.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerMPTF.setEnabled(false);
				spinnerMPTF.setBounds(286, 184, 58, 23);
				FoodMenu.getContentPane().add(spinnerMPTF);
				
				JCheckBox chckbxMPTF = new JCheckBox("");
				chckbxMPTF.addItemListener(this);
				chckbxMPTF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxMPTF.isSelected()){
							spinnerMPTF.setEnabled(true);
							foodMPTF=foodMPTF+11;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strMPTF="Ma Po Tofu"+ "("+String.valueOf(PreQtyMPTF)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							lblOrder.setText(null);
							spinnerMPTF.setEnabled(false);
							spinnerMPTF.setValue(1);
							foodMPTF=0;
							PreQtyMPTF = 1;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strMPTF=" ";
							PreQtySSP = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));				}
					}
				});
				chckbxMPTF.setBounds(216, 110, 128, 23);
				FoodMenu.getContentPane().add(chckbxMPTF);
				
				spinnerMPTF.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateMPTF=11;
						 if(chckbxMPTF.isSelected()){
							 PreQtyMPTF=(Integer)spinnerMPTF.getValue();
						 if(PreQtyMPTF>QtyMPTF){
							 QtyMPTF = PreQtyMPTF;
					         foodMPTF = RateMPTF * PreQtyMPTF;
								strMPTF="Ma Po Tofu"+ "("+String.valueOf(PreQtyMPTF)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyMPTF<=QtyMPTF){
							 QtyMPTF = PreQtyMPTF;
					         foodMPTF = RateMPTF * PreQtyMPTF;
								strMPTF="Ma Po Tofu"+ "("+String.valueOf(PreQtyMPTF)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblMPTF = new JLabel("Ma Po Tofu ($11)");
				lblMPTF.setBounds(245, 160, 115, 14);
				FoodMenu.getContentPane().add(lblMPTF);
				
				JLabel lblQtyMPTF = new JLabel("Qty:");
				lblQtyMPTF.setBounds(253, 187, 36, 19);
				FoodMenu.getContentPane().add(lblQtyMPTF);
				
				
				//Food: Sashimi
				JLabel lblSashimi = new JLabel("");
				int widthSSM=81,heightSSM=65;
				ImageIcon imageSSM = new ImageIcon("src/FoodList/Sashimi.jpg");
		        imageSSM.setImage(imageSSM.getImage().getScaledInstance(widthSSM,heightSSM,Image.SCALE_DEFAULT));
		        lblSashimi.setIcon(imageSSM);
		        lblSashimi.setSize(widthSSM,heightSSM);
				lblSashimi.setBounds(493, 83, 81, 65);
				FoodMenu.getContentPane().add(lblSashimi);
				
				JSpinner spinnerSSM = new JSpinner();
				spinnerSSM.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerSSM.setEnabled(false);
				spinnerSSM.setBounds(514, 183, 56, 23);
				FoodMenu.getContentPane().add(spinnerSSM);
				
				JCheckBox chckbxSSM = new JCheckBox("");
				chckbxSSM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxSSM.isSelected()){
							spinnerSSM.setEnabled(true);
							foodSSM=foodSSM+12;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSSM="Sashimi"+ "("+String.valueOf(PreQtySSM)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerSSM.setEnabled(false);
							spinnerSSM.setValue(1);
							foodSSM=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSSM=" ";
							PreQtySSM = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxSSM.setBounds(433, 110, 128, 23);
				FoodMenu.getContentPane().add(chckbxSSM);
				
				spinnerSSM.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSSM=12;
						 if(chckbxSSM.isSelected()){
							 PreQtySSM=(Integer)spinnerSSM.getValue();
						 if(PreQtySSM>QtySSM){
							 QtySSM = PreQtySSM;
					         foodSSM = RateSSM * PreQtySSM;
					         strSSM="Sashimi"+ "("+String.valueOf(PreQtySSM)+")";
					         totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							 lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtySSM<=QtySSM){
							 QtySSM = PreQtySSM;
					         foodSSM = RateSSM * PreQtySSM;
					         strSSM="Sashimi"+ "("+String.valueOf(PreQtySSM)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblSSM = new JLabel("Sashimi ($12)");
				lblSSM.setBounds(482, 160, 92, 12);
				FoodMenu.getContentPane().add(lblSSM);
				
				JLabel lblQtySSM = new JLabel("Qty:");
				lblQtySSM.setBounds(483, 184, 31, 20);
				FoodMenu.getContentPane().add(lblQtySSM);
				
				
				//Food: Sushi
				JLabel lblSushi = new JLabel("");
				int widthSS=81,heightSS=65;
				ImageIcon imageSS = new ImageIcon("src/FoodList/Sushi.jpg");
		        imageSS.setImage(imageSS.getImage().getScaledInstance(widthSS,heightSS,Image.SCALE_DEFAULT));
		        lblSushi.setIcon(imageSS);
		        lblSushi.setSize(widthSS,heightSS);
				lblSushi.setBounds(699, 83, 81, 65);
				FoodMenu.getContentPane().add(lblSushi);
				
				JSpinner spinnerSS = new JSpinner();
				spinnerSS.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerSS.setEnabled(false);
				spinnerSS.setBounds(711, 184, 56, 23);
				FoodMenu.getContentPane().add(spinnerSS);
				
				JCheckBox chckbxSS = new JCheckBox("");
				chckbxSS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxSS.isSelected()){
							spinnerSS.setEnabled(true);
							foodSS=foodSS+7;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strSS="Sushi" + "("+String.valueOf(PreQtySS)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerSS.setEnabled(false);
							spinnerSS.setValue(1);
							foodSS=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSS=" ";
							PreQtySS = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxSS.setBounds(625, 110, 128, 23);
				FoodMenu.getContentPane().add(chckbxSS);
				
				spinnerSS.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSS=7;
						 if(chckbxSS.isSelected()){
							 PreQtySS=(Integer)spinnerSS.getValue();
						 if(PreQtySS>QtySS){
							 QtySS = PreQtySS;
					         foodSS = RateSS * PreQtySS;
								strSS="Sushi" + "("+String.valueOf(PreQtySS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtySS<=QtySS){
							 QtySS = PreQtySS;
					         foodSS = RateSS * PreQtySS;
								strSS="Sushi" + "("+String.valueOf(PreQtySS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblSS = new JLabel("Sushi ($7)");
				lblSS.setBounds(699, 158, 68, 14);
				FoodMenu.getContentPane().add(lblSS);
				
				JLabel lblQtySS = new JLabel("Qty:");
				lblQtySS.setBounds(680, 188, 61, 16);
				FoodMenu.getContentPane().add(lblQtySS);
				
				
				//Food:Peking Duck
				JLabel lblPekingDuck = new JLabel("");
				int widthPD=81,heightPD=65;
				ImageIcon imagePD = new ImageIcon("src/FoodList/PekingDuck.jpg");
		        imagePD.setImage(imagePD.getImage().getScaledInstance(widthPD,heightPD,Image.SCALE_DEFAULT));
		        lblPekingDuck.setIcon(imagePD);
		        lblPekingDuck.setSize(widthPD,heightPD);
				lblPekingDuck.setBounds(898, 83, 81, 65);
				FoodMenu.getContentPane().add(lblPekingDuck);
				
				JSpinner spinnerPD = new JSpinner();
				spinnerPD.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerPD.setEnabled(false);
				spinnerPD.setBounds(910, 183, 56, 22);
				FoodMenu.getContentPane().add(spinnerPD);
				
				JCheckBox chckbxPD = new JCheckBox(" ");
				chckbxPD.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxPD.isSelected()){
							spinnerPD.setEnabled(true);
							foodPD=foodPD+38;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPD="Peking Duck" + "("+String.valueOf(PreQtyPD)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerPD.setEnabled(false);
							spinnerPD.setValue(1);
							foodPD=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strPD=" ";
							PreQtyPD = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxPD.setBounds(828, 110, 128, 23);
				FoodMenu.getContentPane().add(chckbxPD);
				
				spinnerPD.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RatePD=38;
						 if(chckbxPD.isSelected()){
							 PreQtyPD=(Integer)spinnerPD.getValue();
						 if(PreQtyPD>QtyPD){
							 QtyPD = PreQtyPD;
					         foodPD = RatePD * PreQtyPD;
								strPD="Peking Duck" + "("+String.valueOf(PreQtyPD)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyPD<=QtyPD){
							 QtyPD = PreQtyPD;
					         foodPD = RatePD * PreQtyPD;
								strPD="Peking Duck" + "("+String.valueOf(PreQtyPD)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblPD = new JLabel("Peking Duck ($38)");
				lblPD.setBounds(867, 157, 115, 18);
				FoodMenu.getContentPane().add(lblPD);
				
				JLabel lblQtyPd = new JLabel("Qty:");
				lblQtyPd.setBounds(875, 185, 45, 19);
				FoodMenu.getContentPane().add(lblQtyPd);
				
				
				//Food: Bibimbap
				JLabel lblBibimbap = new JLabel("");
				int widthBBB=81,heightBBB=65;
				ImageIcon imageBBB = new ImageIcon("src/FoodList/Bibimbap.jpg");
		        imageBBB.setImage(imageBBB.getImage().getScaledInstance(widthBBB,heightBBB,Image.SCALE_DEFAULT));
		        lblBibimbap.setIcon(imageBBB);
		        lblBibimbap.setSize(widthBBB,heightBBB);
				lblBibimbap.setBounds(46, 255, 81, 65);
				FoodMenu.getContentPane().add(lblBibimbap);
				
				JSpinner spinnerBBB = new JSpinner();
				spinnerBBB.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerBBB.setEnabled(false);
				spinnerBBB.setBounds(78, 350, 56, 23);
				FoodMenu.getContentPane().add(spinnerBBB);
				
				JCheckBox chckbxBBB = new JCheckBox("");
				chckbxBBB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxBBB.isSelected()){
							spinnerBBB.setEnabled(true);
							foodBBB=foodBBB+23;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strBBB="Bibimbap" + "("+String.valueOf(PreQtyBBB)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerBBB.setEnabled(false);
							spinnerBBB.setValue(1);
							foodBBB=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strBBB=" ";
							PreQtyBBB = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxBBB.setBounds(6, 284, 128, 23);
				FoodMenu.getContentPane().add(chckbxBBB);
				
				spinnerBBB.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateBBB=23;
						 if(chckbxBBB.isSelected()){
							 PreQtyBBB=(Integer)spinnerBBB.getValue();
						 if(PreQtyBBB>QtyBBB){
							 QtyBBB = PreQtyBBB;
					         foodBBB = RateBBB * PreQtyBBB;
								strBBB="Bibimbap" + "("+String.valueOf(PreQtyBBB)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyBBB<=QtyBBB){
							 QtyBBB = PreQtyBBB;
					         foodBBB = RateBBB * PreQtyBBB;
								strBBB="Bibimbap" + "("+String.valueOf(PreQtyBBB)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblBBB = new JLabel("Bibimbap ($23)");
				lblBBB.setBounds(37, 328, 97, 19);
				FoodMenu.getContentPane().add(lblBBB);
				
				JLabel lblQtyBBB = new JLabel("Qty:");
				lblQtyBBB.setBounds(44, 352, 38, 20);
				FoodMenu.getContentPane().add(lblQtyBBB);
				
				
				//Food: Naengmyeon
				JLabel lblNaengmyeon = new JLabel("");
				int widthNM=81,heightNM=65;
				ImageIcon imageNM = new ImageIcon("src/FoodList/Naengmyeon.jpg");
		        imageNM.setImage(imageNM.getImage().getScaledInstance(widthNM,heightNM,Image.SCALE_DEFAULT));
		        lblNaengmyeon.setIcon(imageNM);
		        lblNaengmyeon.setSize(widthNM,heightNM);
				lblNaengmyeon.setBounds(263, 255, 81, 65);
				FoodMenu.getContentPane().add(lblNaengmyeon);
				
				JSpinner spinnerNM = new JSpinner();
				spinnerNM.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerNM.setEnabled(false);
				spinnerNM.setBounds(286, 350, 57, 23);
				FoodMenu.getContentPane().add(spinnerNM);
				
				JCheckBox chckbxNM = new JCheckBox("");
				chckbxNM.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxNM.isSelected()){
							spinnerNM.setEnabled(true);
							foodNM=foodNM+12;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strNM="Naengmyeon" + "("+String.valueOf(PreQtyNM)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerNM.setEnabled(false);
							spinnerNM.setValue(1);
							foodBBB=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strNM=" ";
							PreQtyNM = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxNM.setBounds(216, 284, 128, 23);
				FoodMenu.getContentPane().add(chckbxNM);
				
				spinnerNM.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateNM=12;
						 if(chckbxNM.isSelected()){
							 PreQtyNM=(Integer)spinnerNM.getValue();
						 if(PreQtyNM>QtyNM){
							 QtyNM = PreQtyNM;
					         foodNM = RateNM * PreQtyNM;
								strNM="Naengmyeon" + "("+String.valueOf(PreQtyNM)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyNM<=QtyNM){
							 QtyNM = PreQtyNM;
					         foodNM = RateNM * PreQtyNM;
								strNM="Naengmyeon" + "("+String.valueOf(PreQtyNM)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblNM = new JLabel("Naengmyeon ($12)");
				lblNM.setBounds(245, 324, 118, 23);
				FoodMenu.getContentPane().add(lblNM);
				
				JLabel lblQtyNM = new JLabel("Qty:");
				lblQtyNM.setBounds(255, 354, 36, 19);
				FoodMenu.getContentPane().add(lblQtyNM);
				
				
				//Food: Steamed Flounder
				JLabel lblSteamedFlounder = new JLabel("");
				int widthSF=81,heightSF=65;
				ImageIcon imageSF = new ImageIcon("src/FoodList/SteamedFlounder.jpg");
		        imageSF.setImage(imageSF.getImage().getScaledInstance(widthSF,heightSF,Image.SCALE_DEFAULT));
		        lblSteamedFlounder.setIcon(imageSF);
		        lblSteamedFlounder.setSize(widthSF,heightSF);
				lblSteamedFlounder.setBounds(493, 255, 81, 65);
				FoodMenu.getContentPane().add(lblSteamedFlounder);
				
				JSpinner spinnerSF = new JSpinner();
				spinnerSF.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerSF.setEnabled(false);
				spinnerSF.setBounds(526, 349, 56, 23);
				FoodMenu.getContentPane().add(spinnerSF);
				
				JCheckBox chckbxSF = new JCheckBox("");
				chckbxSF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxSF.isSelected()){
							spinnerSF.setEnabled(true);
							foodSF=foodSF+28;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSF="Steamed Flounder" + "("+String.valueOf(PreQtySF)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerSF.setEnabled(false);
							spinnerSF.setValue(1);
							foodSF=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSF=" ";
							PreQtySF = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));;
						}
					}
				});
				chckbxSF.setBounds(442, 284, 128, 23);
				FoodMenu.getContentPane().add(chckbxSF);
				
				spinnerSF.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSF=28;
						 if(chckbxSF.isSelected()){
							 PreQtySF=(Integer)spinnerSF.getValue();
						 if(PreQtySF>QtySF){
							 QtySF = PreQtySF;
					         foodSF = RateSF * PreQtySF;
								strSF="Steamed Flounder" + "("+String.valueOf(PreQtySF)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtySF<=QtySF){
							 QtySF = PreQtySF;
					         foodSF = RateSF * PreQtySF;
								strSF="Steamed Flounder" + "("+String.valueOf(PreQtySF)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblSF = new JLabel("Steamed Flounder ($28)");
				lblSF.setBounds(463, 324, 153, 23);
				FoodMenu.getContentPane().add(lblSF);
				
				JLabel lblQtySF = new JLabel("Qty:");
				lblQtySF.setBounds(491, 353, 36, 19);
				FoodMenu.getContentPane().add(lblQtySF);
				
				
				//Food: Salt Baked Squid
				JLabel lblSaltBakedSquid = new JLabel("");
				int widthSBS=81,heightSBS=65;
				ImageIcon imageSBS = new ImageIcon("src/FoodList/SaltBakedSquid.jpg");
		        imageSBS.setImage(imageSBS.getImage().getScaledInstance(widthSBS,heightSBS,Image.SCALE_DEFAULT));
		        lblSaltBakedSquid.setIcon(imageSBS);
		        lblSaltBakedSquid.setSize(widthSBS,heightSBS);
				lblSaltBakedSquid.setBounds(699, 255, 81, 65);
				FoodMenu.getContentPane().add(lblSaltBakedSquid);
				
				JSpinner spinnerSBS = new JSpinner();
				spinnerSBS.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerSBS.setEnabled(false);
				spinnerSBS.setBounds(711, 349, 56, 23);
				FoodMenu.getContentPane().add(spinnerSBS);
				
				JCheckBox chckbxSBS = new JCheckBox("");
				chckbxSBS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxSBS.isSelected()){
							spinnerSBS.setEnabled(true);
							foodSBS=foodSBS+15;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSBS="Salt Baked Squid" + "("+String.valueOf(PreQtySBS)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerSBS.setEnabled(false);
							spinnerSBS.setValue(1);
							foodSBS=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strSBS=" ";
							PreQtySBS = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxSBS.setBounds(625, 284, 128, 23);
				FoodMenu.getContentPane().add(chckbxSBS);
				
				spinnerSBS.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateSBS=15;
						 if(chckbxSBS.isSelected()){
							 PreQtySBS=(Integer)spinnerSBS.getValue();
						 if(PreQtySBS>QtySBS){
							 QtySBS = PreQtySBS;
					         foodSBS = RateSBS * PreQtySBS;
								strSBS="Salt Baked Squid" + "("+String.valueOf(PreQtySBS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtySBS<=QtySBS){
							 QtySBS = PreQtySBS;
					         foodSBS = RateSBS * PreQtySBS;
								strSBS="Salt Baked Squid" + "("+String.valueOf(PreQtySBS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblSBS = new JLabel("Salt Baked Squid ($15)");
				lblSBS.setBounds(668, 324, 153, 23);
				FoodMenu.getContentPane().add(lblSBS);
				
				JLabel lblQtySBS = new JLabel("Qty:");
				lblQtySBS.setBounds(680, 354, 61, 16);
				FoodMenu.getContentPane().add(lblQtySBS);
				
				
				//Food: Hibachi Steak
				JLabel lblHibachiSteak = new JLabel("");
				int widthHS=81,heightHS=65;
				ImageIcon imageHS = new ImageIcon("src/FoodList/HibachiSteak.jpg");
		        imageHS.setImage(imageHS.getImage().getScaledInstance(widthHS,heightHS,Image.SCALE_DEFAULT));
		        lblHibachiSteak.setIcon(imageHS);
		        lblHibachiSteak.setSize(widthHS,heightHS);
				lblHibachiSteak.setBounds(898, 255, 81, 65);
				FoodMenu.getContentPane().add(lblHibachiSteak);
				
				JSpinner spinnerHS = new JSpinner();
				spinnerHS.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerHS.setEnabled(false);
				spinnerHS.setBounds(910, 349, 56, 24);
				FoodMenu.getContentPane().add(spinnerHS);
				
				JCheckBox chckbxHS = new JCheckBox("");
				chckbxHS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxHS.isSelected()){
							spinnerHS.setEnabled(true);
							foodHS=foodHS+9;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strHS="Hibachi Steak"+ "("+String.valueOf(PreQtyHS)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerHS.setEnabled(false);
							spinnerHS.setValue(1);
							foodHS=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strHS=" ";
							PreQtyHS = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxHS.setBounds(828, 284, 128, 23);
				FoodMenu.getContentPane().add(chckbxHS);
				
				spinnerHS.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateHS=9;
						 if(chckbxHS.isSelected()){
							 PreQtyHS=(Integer)spinnerHS.getValue();
						 if(PreQtyHS>QtyHS){
							 QtyHS = PreQtyHS;
					         foodHS = RateHS * PreQtyHS;
								strHS="Hibachi Steak"+ "("+String.valueOf(PreQtyHS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyHS<=QtyHS){
							 QtyHS = PreQtyHS;
					         foodHS = RateHS * PreQtyHS;
								strHS="Hibachi Steak"+ "("+String.valueOf(PreQtyHS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblHS = new JLabel("Hibachi Steak ($9)");
				lblHS.setBounds(867, 328, 128, 19);
				FoodMenu.getContentPane().add(lblHS);
				
				JLabel lblQtyHS = new JLabel("Qty:");
				lblQtyHS.setBounds(877, 354, 61, 16);
				FoodMenu.getContentPane().add(lblQtyHS);
				
				
				//Food: Beef With Broccoli
				JLabel lblBeefWithBroccoli = new JLabel("");
				int widthBWB=81,heightBWB=65;
				ImageIcon imageBWB = new ImageIcon("src/FoodList/BeefWithBroccoli.jpg");
		        imageBWB.setImage(imageBWB.getImage().getScaledInstance(widthBWB,heightBWB,Image.SCALE_DEFAULT));
		        lblBeefWithBroccoli.setIcon(imageBWB);
		        lblBeefWithBroccoli.setSize(widthBWB,heightBWB);
				lblBeefWithBroccoli.setBounds(46, 423, 81, 65);
				FoodMenu.getContentPane().add(lblBeefWithBroccoli);
				
				JSpinner spinnerBWB = new JSpinner();
				spinnerBWB.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerBWB.setEnabled(false);
				spinnerBWB.setBounds(71, 524, 56, 21);
				FoodMenu.getContentPane().add(spinnerBWB);
				
				JCheckBox chckbxBWB = new JCheckBox("");
				chckbxBWB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxBWB.isSelected()){
							spinnerBWB.setEnabled(true);
							foodBWB=foodBWB+15;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strBWB="Beef With Broccoli"+ "("+String.valueOf(PreQtyBWB)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerBWB.setEnabled(false);
							spinnerBWB.setValue(1);
							foodBWB=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strBWB=" ";
							PreQtyBWB = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxBWB.setBounds(6, 452, 128, 23);
				FoodMenu.getContentPane().add(chckbxBWB);
				
				spinnerBWB.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateBWB=15;
						 if(chckbxBWB.isSelected()){
							 PreQtyBWB=(Integer)spinnerBWB.getValue();
						 if(PreQtyBWB>QtyBWB){
							 QtyBWB = PreQtyBWB;
					         foodBWB = RateBWB * PreQtyBWB;
								strBWB="Beef With Broccoli"+ "("+String.valueOf(PreQtyBWB)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyBWB<=QtyBWB){
							 QtyBWB = PreQtyBWB;
					         foodBWB = RateBWB * PreQtyBWB;
								strBWB="Beef With Broccoli"+ "("+String.valueOf(PreQtyBWB)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblBWB = new JLabel("Beef With Broccoli ($15)");
				lblBWB.setBounds(16, 498, 153, 18);
				FoodMenu.getContentPane().add(lblBWB);
				
				JLabel lblQtyBWB = new JLabel("Qty:");
				lblQtyBWB.setBounds(37, 528, 61, 16);
				FoodMenu.getContentPane().add(lblQtyBWB);
				
				
				//Food: Kung Pao Chicken
				JLabel lblKungPaoChicken = new JLabel("");
				int widthKPC=81,heightKPC=65;
				ImageIcon imageKPC = new ImageIcon("src/FoodList/KungPaoChicken.jpg");
		        imageKPC.setImage(imageKPC.getImage().getScaledInstance(widthKPC,heightKPC,Image.SCALE_DEFAULT));
		        lblKungPaoChicken.setIcon(imageKPC);
		        lblKungPaoChicken.setSize(widthKPC,heightKPC);
				lblKungPaoChicken.setBounds(263, 423, 81, 65);
				FoodMenu.getContentPane().add(lblKungPaoChicken);
				
				JSpinner spinnerKPC = new JSpinner();
				spinnerKPC.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerKPC.setEnabled(false);
				spinnerKPC.setBounds(286, 523, 56, 23);
				FoodMenu.getContentPane().add(spinnerKPC);
				
				JCheckBox chckbxKPC = new JCheckBox("");
				chckbxKPC.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxKPC.isSelected()){
							spinnerKPC.setEnabled(true);
							foodKPC=foodKPC+16;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strKPC="Kung Pao Chicken"+ "("+String.valueOf(PreQtyKPC)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerKPC.setEnabled(false);
							spinnerKPC.setValue(1);
							foodKPC=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strKPC=" ";
							PreQtyKPC = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxKPC.setBounds(216, 452, 128, 23);
				FoodMenu.getContentPane().add(chckbxKPC);
				
				spinnerKPC.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateKPC=16;
						 if(chckbxKPC.isSelected()){
							 PreQtyKPC=(Integer)spinnerKPC.getValue();
						 if(PreQtyKPC>QtyKPC){
							 QtyKPC = PreQtyKPC;
					         foodKPC = RateKPC * PreQtyKPC;
								strKPC="Kung Pao Chicken"+ "("+String.valueOf(PreQtyKPC)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyKPC<=QtyKPC){
							 QtyKPC = PreQtyKPC;
					         foodKPC = RateKPC * PreQtyKPC;
								strKPC="Kung Pao Chicken"+ "("+String.valueOf(PreQtyKPC)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblKPC = new JLabel("Kung Pao Chicken ($16)");
				lblKPC.setBounds(237, 498, 153, 19);
				FoodMenu.getContentPane().add(lblKPC);
				
				JLabel lblQtyKPC = new JLabel("Qty:");
				lblQtyKPC.setBounds(255, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyKPC);
				
				
				//Food: Japanese Ramen
				JLabel lblJapaneseRamen = new JLabel("");
				int widthJR=81,heightJR=65;
				ImageIcon imageJR = new ImageIcon("src/FoodList/JapaneseRamen.jpg");
		        imageJR.setImage(imageJR.getImage().getScaledInstance(widthJR,heightJR,Image.SCALE_DEFAULT));
		        lblJapaneseRamen.setIcon(imageJR);
		        lblJapaneseRamen.setSize(widthJR,heightJR);
				lblJapaneseRamen.setBounds(493, 423, 81, 65);
				FoodMenu.getContentPane().add(lblJapaneseRamen);
				
				JSpinner spinnerJR = new JSpinner();
				spinnerJR.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerJR.setEnabled(false);
				spinnerJR.setBounds(526, 523, 56, 23);
				FoodMenu.getContentPane().add(spinnerJR);
				
				JCheckBox chckbxJR = new JCheckBox("");
				chckbxJR.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxJR.isSelected()){
							spinnerJR.setEnabled(true);
							foodJR=foodJR+25;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strJR="Japanese Ramen" + "("+String.valueOf(PreQtyJR)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerJR.setEnabled(false);
							spinnerJR.setValue(1);
							foodJR=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strJR=" ";
							PreQtyJR = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxJR.setBounds(442, 452, 128, 23);
				FoodMenu.getContentPane().add(chckbxJR);
				
				spinnerJR.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateJR=25;
						 if(chckbxJR.isSelected()){
							 PreQtyJR=(Integer)spinnerJR.getValue();
						 if(PreQtyJR>QtyJR){
							 QtyJR= PreQtyJR;
					         foodJR = RateJR * PreQtyJR;
								strJR="Japanese Ramen" + "("+String.valueOf(PreQtyJR)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyJR<=QtyJR){
							 QtyJR = PreQtyJR;
					         foodJR = RateJR * PreQtyJR;
								strJR="Japanese Ramen" + "("+String.valueOf(PreQtyJR)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblJR = new JLabel("Japanese Ramen ($25)");
				lblJR.setBounds(473, 498, 137, 18);
				FoodMenu.getContentPane().add(lblJR);
				
				JLabel lblQtyJR = new JLabel("Qty:");
				lblQtyJR.setBounds(493, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyJR);
				
				
				//Food: Hitsumabushi
				JLabel lblHitsumabushi = new JLabel("");
				int widthHSMBS=81,heightHSMBS=65;
				ImageIcon imageHSMBS = new ImageIcon("src/FoodList/Hitsumabushi.jpg");
		        imageHSMBS.setImage(imageHSMBS.getImage().getScaledInstance(widthHSMBS,heightHSMBS,Image.SCALE_DEFAULT));
		        lblHitsumabushi.setIcon(imageHSMBS);
		        lblHitsumabushi.setSize(widthHSMBS,heightHSMBS);
				lblHitsumabushi.setBounds(699, 423, 81, 65);
				FoodMenu.getContentPane().add(lblHitsumabushi);
				
				JSpinner spinnerHSMBS = new JSpinner();
				spinnerHSMBS.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerHSMBS.setEnabled(false);
				spinnerHSMBS.setBounds(711, 522, 56, 26);
				FoodMenu.getContentPane().add(spinnerHSMBS);
				
				JCheckBox chckbxHSMBS = new JCheckBox("");
				chckbxHSMBS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxHSMBS.isSelected()){
							spinnerHSMBS.setEnabled(true);
							foodHSMBS=foodHSMBS+17;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));	
							strHSMBS="Hitsumabushi" + "("+String.valueOf(PreQtyHSMBS)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerHSMBS.setEnabled(false);
							spinnerHSMBS.setValue(1);
							foodHSMBS=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strHSMBS=" ";
							PreQtyHSMBS = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxHSMBS.setBounds(625, 452, 128, 23);
				FoodMenu.getContentPane().add(chckbxHSMBS);
				
				spinnerHSMBS.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateHSMBS=17;
						 if(chckbxHSMBS.isSelected()){
							 PreQtyHSMBS=(Integer)spinnerHSMBS.getValue();
						 if(PreQtyHSMBS>QtyHSMBS){
							 QtyHSMBS= PreQtyHSMBS;
					         foodHSMBS = RateHSMBS * PreQtyHSMBS;
								strHSMBS="Hitsumabushi" + "("+String.valueOf(PreQtyHSMBS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyHSMBS<=QtyHSMBS){
							 QtyHSMBS = PreQtyHSMBS;
					         foodHSMBS = RateHSMBS * PreQtyHSMBS;
								strHSMBS="Hitsumabushi" + "("+String.valueOf(PreQtyHSMBS)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblHSMBS = new JLabel("Hitsumabushi ($17)");
				lblHSMBS.setBounds(680, 497, 134, 19);
				FoodMenu.getContentPane().add(lblHSMBS);
				
				JLabel lblQtyHSMBS = new JLabel("Qty:");
				lblQtyHSMBS.setBounds(680, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyHSMBS);
				
				
				//Food: Wonton Noodle
				JLabel lblWontonNoodle = new JLabel("");
				int widthWN=81,heightWN=65;
				ImageIcon imageWN = new ImageIcon("src/FoodList/WontonNoodle.jpg");
		        imageWN.setImage(imageWN.getImage().getScaledInstance(widthWN,heightWN,Image.SCALE_DEFAULT));
		        lblWontonNoodle.setIcon(imageWN);
		        lblWontonNoodle.setSize(widthWN,heightWN);
				lblWontonNoodle.setBounds(898, 423, 81, 65);
				FoodMenu.getContentPane().add(lblWontonNoodle);
				
				JSpinner spinnerWN = new JSpinner();
				spinnerWN.setModel(new SpinnerNumberModel(1,1,null,1));
				spinnerWN.setEnabled(false);
				spinnerWN.setBounds(910, 522, 56, 23);
				FoodMenu.getContentPane().add(spinnerWN);
				
				JCheckBox chckbxWN = new JCheckBox("");
				chckbxWN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(chckbxWN.isSelected()){
							spinnerWN.setEnabled(true);
							foodWN=foodWN+11;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strWN="Wonton Noodle" + "("+String.valueOf(PreQtyWN)+")";
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}else{
							spinnerWN.setEnabled(false);
							spinnerWN.setValue(1);
							foodWN=0;
							totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
							lbltotalFood.setText(String.valueOf(totalFood));
							strWN=" ";
							PreQtyWN = 1;
							totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
							lblOrder.setText(String.valueOf(totalOrder));
						}
					}
				});
				chckbxWN.setBounds(828, 452, 128, 23);
				FoodMenu.getContentPane().add(chckbxWN);
				
				spinnerWN.addChangeListener(new ChangeListener(){
					public void stateChanged(ChangeEvent e){
						 double RateWN=11;
						 if(chckbxWN.isSelected()){
							 PreQtyWN=(Integer)spinnerWN.getValue();
						 if(PreQtyWN>QtyWN){
							 QtyWN= PreQtyWN;
					         foodWN = RateWN * PreQtyWN;
								strWN="Wonton Noodle" + "("+String.valueOf(PreQtyWN)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					     }else if(PreQtyWN<=QtyWN){
							 QtyWN = PreQtyWN;
					         foodWN = RateWN * PreQtyWN;
								strWN="Wonton Noodle" + "("+String.valueOf(PreQtyWN)+")";
								totalOrder=strSSP+" "+strMPTF+" "+strSSM+" "+strSS+" "+strPD+" "+strBBB+" "+strNM+" "+strSF+" "+strSBS+" "+strHS+" "+strBWB+" "+strKPC+" "+strJR+" "+strHSMBS+" "+strWN;
								lblOrder.setText(String.valueOf(totalOrder));
					         totalFood=foodSSP+foodMPTF+foodSSM+foodSS+foodPD+foodBBB+foodNM+foodSF+foodSBS+foodHS+foodBWB+foodKPC+foodJR+foodHSMBS+foodWN;
					          }
						 lbltotalFood.setText(String.valueOf(totalFood));
						 }
					}
				});
				
				JLabel lblWN = new JLabel("Wonton Noodle ($11)");
				lblWN.setBounds(860, 498, 134, 18);
				FoodMenu.getContentPane().add(lblWN);
				
				JLabel lblQtyWN = new JLabel("Qty:");
				lblQtyWN.setBounds(877, 527, 61, 16);
				FoodMenu.getContentPane().add(lblQtyWN);
				
				
				JLabel lblLogo = new JLabel("");
				int widthLG=204,heightLG=125;
				ImageIcon imageLG = new ImageIcon("src/Pictures/AsianFlavors.png");
		        imageLG.setImage(imageLG.getImage().getScaledInstance(widthLG,heightLG,Image.SCALE_DEFAULT));
		        lblLogo.setIcon(imageLG);
		        lblLogo.setSize(widthLG,heightLG);
				lblLogo.setBounds(1060, 110, 204, 125);
				FoodMenu.getContentPane().add(lblLogo);
				
				JLabel lblLogo1 = new JLabel("");
				int widthLG1=204,heightLG1=125;
				ImageIcon imageLG1 = new ImageIcon("src/Pictures/NewAsia.jpg");
		        imageLG1.setImage(imageLG1.getImage().getScaledInstance(widthLG1,heightLG1,Image.SCALE_DEFAULT));
		        lblLogo1.setIcon(imageLG1);
		        lblLogo1.setSize(widthLG1,heightLG1);
				lblLogo1.setBounds(1060, 300, 204, 125);
				FoodMenu.getContentPane().add(lblLogo1);

				
				JLabel lblBackground = new JLabel("Enter Your UserName");
				int widthBG=1500,heightBG=1500;
				ImageIcon imageBG = new ImageIcon("src/Pictures/blue.jpg");
		        imageBG.setImage(imageBG.getImage().getScaledInstance(widthBG,heightBG,Image.SCALE_DEFAULT));
		        lblBackground.setIcon(imageBG);
		        lblBackground.setSize(widthBG,heightBG);
				lblBackground.setBounds(0, 0, 1500, 1500);
				FoodMenu.getContentPane().add(lblBackground);
				
						
				
			}

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
		}
		}
