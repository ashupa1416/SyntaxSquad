package GUI;
import Files.*;
import Entity.*;
import EntityList.AppointmentList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.table.*;

	public class AppointmentManagerFrame extends JFrame implements ActionListener{
		Font font = new Font("Lucida Sans Unicode", Font.PLAIN, 16);
		Font font2 = new Font("Bookman Old Style", Font.BOLD, 40);
		JPanel panel;
		
		JLabel label;	
		
		JTextField TName, TAge, TId, TGender, TRecommendedDoctor, TAppointmentTime, TSearch;
		JButton add, remove, back, search, update;
		
		DefaultTableModel model;
		JTable table;
		AppointmentList appointmentList;
		Homepage home;
		public AppointmentManagerFrame(Homepage home, AppointmentList appointmentList){
			super("Appointment Manager");
			this.home = home;
			this.appointmentList = appointmentList;
			
			initializeFrame();	
			
			createTable();
			
			
			//Display the window after all initialization
			this.setVisible(true);
		}
		
		public void initializeFrame(){
			this.setSize(1000,700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocation(220,50);
			this.setLayout(null);
			
			//Creating a Panel Container
			panel = new JPanel();
			panel.setBounds(0,0,1000,700);
			panel.setOpaque(false);
			panel.setLayout(null);
			this.add(panel);
			
			//Window Icon
			ImageIcon icon = new ImageIcon("./GUI/Resource/Hospital.jpg"); 
			Image WImage = icon.getImage();
			this.setIconImage(WImage);

			//BackGround 
			ImageIcon image = new ImageIcon("./GUI/Resource/bg4.png");
			JLabel background = new JLabel();
			background.setBounds(0,0,1000,700);
			background.setIcon(image);
			this.add(background);
			
			//Crating Labels
			label = new JLabel("Manage Appointment");
			label.setBounds(300,10,450,50);
			label.setFont(font2);
			
			JLabel idLabel = new JLabel("ID");
			idLabel.setFont(font);
			idLabel.setBounds(40,60,100,40);

			JLabel nameLabel = new JLabel("Name");
			nameLabel.setFont(font);
			nameLabel.setBounds(160,60,100,40);

			JLabel ageLabel = new JLabel("Age");
			ageLabel.setFont(font);
			ageLabel.setBounds(280,60,100,40);
			
			JLabel genderLabel = new JLabel("Gender");
			genderLabel.setFont(font);
			genderLabel.setBounds(400,60,100,40);
			
			JLabel recommendedDoctorLabel = new JLabel("Rec. Doctor");
			recommendedDoctorLabel.setFont(font);
			recommendedDoctorLabel.setBounds(520,60,140,40);
			
            JLabel appointmentTimeLabel = new JLabel("Appoint Time");
			appointmentTimeLabel.setFont(font);
			appointmentTimeLabel.setBounds(640,60,110,40);
			//TextFields
			TId = new JTextField(" ");
			TId.setFont(font);
			TId.setBounds(40,100,100,40);

			TName = new JTextField(" ");
			TName.setFont(font);
			TName.setBounds(160,100,100,40);

			TAge = new JTextField(" ");
			TAge.setFont(font);
			TAge.setBounds(280,100,100,40);
			
			TGender = new JTextField(" ");
			TGender.setFont(font);
			TGender.setBounds(400,100,100,40);
			
			TRecommendedDoctor = new JTextField(" ");
			TRecommendedDoctor.setFont(font);
			TRecommendedDoctor.setBounds(520,100,100,40);
			
            TAppointmentTime = new JTextField(" ");
			TAppointmentTime.setFont(font);
			TAppointmentTime.setBounds(640,100,110,40);
			
			TSearch = new JTextField();
			TSearch.setFont(font);
			TSearch.setBounds(840, 100, 100, 40);

			/***===Creating Buttons===***/
			//Add Button
			add = new JButton("Add +");
			add.setFont(font);
			add.setBounds(815,210,140,40);
			add.setForeground(Color.WHITE);
			add.setBackground(new Color(36, 214, 42));
			add.addActionListener(this);
			
			//Remove Button
			remove = new JButton("Remove -");
			remove.setFont(font);
			remove.setBounds(815,260,140,40);
			remove.setForeground(Color.WHITE);
			remove.setBackground(new Color(214, 36, 36));
			remove.addActionListener(this);

			//Back Button
			back = new JButton("<Back");
			back.setBounds(770, 580, 100, 40);
			back.setFont(font);
			back.setForeground(Color.WHITE);
			back.setBackground(new Color(214, 36, 36));
			back.addActionListener(this);

			//Search Button
			search = new JButton("Search");
			search.setFont(font);
			search.setBounds(840, 145, 100, 40);
			search.setForeground(Color.WHITE);
			search.setBackground(new Color(76, 141, 245));
			search.addActionListener(this);
			
			//Update Button
			update = new JButton("Update");
			update.setFont(font);
			update.setBounds(815,310,140,40);
			update.setForeground(Color.WHITE);
			update.setBackground(new Color(76, 141, 245));
			update.addActionListener(this);
			
			//adding components to Panel
			panel.add(label);
			panel.add(idLabel);
			panel.add(nameLabel);
			panel.add(ageLabel);
			panel.add(genderLabel);
            panel.add(recommendedDoctorLabel);
			panel.add(appointmentTimeLabel);
			panel.add(TId);
			panel.add(TName);
			panel.add(TAge);
			panel.add(TGender);
			panel.add(TRecommendedDoctor);
            panel.add(TAppointmentTime);
			panel.add(add);
			panel.add(remove);
			panel.add(back);
			panel.add(search);
			panel.add(update);
			panel.add(TSearch);
			
		}
		
		public void createTable(){
			//Create Model For Table
			model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Name");
			model.addColumn("Age");
			model.addColumn("Gender");
			model.addColumn("Rec. Doctor");
            model.addColumn("AppointmentTime");
			
			//Create Table with model
			table = new JTable(model);
			table.setFont(font);
			table.setBackground(new Color(146, 211, 247));
			table.setBounds(0, 0, 750, 300);
			table.setRowHeight(30);
			table. getColumnModel(). getColumn(0). setPreferredWidth(30);
			table. getColumnModel(). getColumn(1). setPreferredWidth(30);
			table. getColumnModel(). getColumn(2). setPreferredWidth(20);
			table. getColumnModel(). getColumn(3). setPreferredWidth(30);
			table. getColumnModel(). getColumn(4). setPreferredWidth(50);
			table.setSelectionBackground(new Color(247, 146, 146));
			table.getTableHeader().setFont(font);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(40, 150, 750, 300);
			
			//copying data from patient list to Model
			Entity.Appointment appointments[];
			appointments = this.appointmentList.getAllAppointment();
			
			for(int i=0;i<appointments.length;i++){
				if(appointments[i]!=null){
					model.addRow(new Object[]{
						appointments[i].getId(),
						appointments[i].getName(),
						appointments[i].getAge(),
						appointments[i].getGender(),
						appointments[i].getRecommendedDoctor(),
                        appointments[i].getAppointmentTime()
					});
				}
			}
			
			//adding the scrollPane to panel
			panel.add(scrollPane);
		}
		
		public void actionPerformed(ActionEvent e){
			if(add == e.getSource()){
				try {
					Double id = Double.parseDouble(TId.getText());
					String name = TName.getText();
					Double age = Double.parseDouble(TAge.getText());
					String gender = TGender.getText();
					String recommendedDoctor = TRecommendedDoctor.getText();
                    String appointmentTime = TAppointmentTime.getText();
				
					Entity.Appointment a = new Entity.Appointment(id,name,age,gender,recommendedDoctor,appointmentTime);
					appointmentList.insertAppointment(a);
				
					model.addRow(new Object[]{
						a.getId(),
						a.getName(),
						a.getAge(),
						a.getGender(),
						a.getRecommendedDoctor(),
                        a.getAppointmentTime()
					});
					AppointmentFileIO.writeInFile(a.getId()+";"+a.getName()+";"+a.getAge()+";"+a.getGender()+";"+a.getRecommendedDoctor()+";"+a.getAppointmentTime(),
						"Files/AppointmentInfo.txt",
						true);
					TId.setText("");
					TName.setText("");
					TAge.setText("");
					TGender.setText("");
					TRecommendedDoctor.setText("");
                    TAppointmentTime.setText("");
				} 
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(this, "Please enter all details", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Error uccoured, Can't add", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(remove == e.getSource()) { 
				try {
					int option = JOptionPane.showConfirmDialog(this,"Are you sure you want to remove?");
					if(option == JOptionPane.YES_OPTION){
						int selectedRows[] = table.getSelectedRows();
						Arrays.sort(selectedRows);			
				
						if(selectedRows!=null){
							for(int i=selectedRows.length-1; i>= 0; i--){
								double id = Double.parseDouble(
									table.getModel().
									getValueAt(selectedRows[0], 0).
									toString());
							appointmentList.removeAppointmentById(id);
							model.removeRow(selectedRows[i]);
							}
							AppointmentFileIO.saveAppointmentListInFile(appointmentList,"Files/AppointmentInfo.txt",false);
							JOptionPane.showMessageDialog(this,"Removed Successfully");
						}
					}
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Invalid input! Enter Correctly ID", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Cannot find Appointment", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else if(search == e.getSource()){
            try{int i;
            for(i = 0;i<table.getRowCount();i++){
                if (Double.parseDouble(TSearch.getText()) == ((Double) table.getValueAt(i, 0)).doubleValue()) {
					table.setSelectionBackground(new Color(50, 240, 91));	 
                    break;
                     }
            }
            table.setRowSelectionInterval(i, i);
			JOptionPane.showMessageDialog(this, "Found at row: "+(i+1));
       		 }
				catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(this, "No Id detected, Please enter Id", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this, "Invalid input! Enter ID in number format", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Cannot find Appointment", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			else if (update == e.getSource()){
				tableModuleToList();
				AppointmentFileIO.saveAppointmentListInFile(appointmentList,"Files/AppointmentInfo.txt",false);
				JOptionPane.showMessageDialog(this,"Updated Successfully");
			}

			else if (back == e.getSource()) {
				home.setVisible(true);
				this.dispose();
			}
		}
		
		public void tableModuleToList(){
			int rows = table.getRowCount();
			AppointmentList updatedList = new AppointmentList(100);
			for(int i=0; i<rows; i++){
				double id = Double.parseDouble(table.getModel().getValueAt(i, 0).toString());
				String name =table.getModel().getValueAt(i, 1).toString();
				double age = Double.parseDouble(table.getModel().getValueAt(i, 2).toString());
				String gender =table.getModel().getValueAt(i, 3).toString();
				String recommendedDoctor =table.getModel().getValueAt(i, 4).toString();
                String appointmentTime =table.getModel().getValueAt(i, 5).toString();
				
				Appointment app = new Appointment(id,name,age,gender,recommendedDoctor,appointmentTime);
				updatedList.insertAppointment(app);
			}
			appointmentList.setAllAppointments(updatedList.getAllAppointment());
			
								
		}
		
	}