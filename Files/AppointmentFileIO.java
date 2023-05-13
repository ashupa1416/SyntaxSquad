package Files;
import java.io.*;
import java.util.Scanner;
import Entity.*;
import EntityList.AppointmentList;

public class AppointmentFileIO{
	
	public static void readFromFile(String fname,AppointmentList appointmentList){
		try{
			Scanner sc=new Scanner(new File(fname)); 
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");

				Double id = Double.parseDouble(data[0]);
				String name = data[1];
				Double age = Double.parseDouble(data[2]);
				String gender = data[3];
				String recommendedDoctor = data[4];
                String appointmentTime = data[5];

				Entity.Appointment d = new Entity.Appointment(id,name,age,gender,recommendedDoctor,appointmentTime);
				appointmentList.insertAppointment(d);
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("Cannot Read the File");
		}
	}
	
	public static void writeInFile(String line, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		writer.write(line+"\n");
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
	public static void saveAppointmentListInFile(AppointmentList appointmentList, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		Appointment appointments[] = appointmentList.getAllAppointment();
		
		for(int i=0;i<appointments.length;i++){
			if(appointments[i]!=null){
				String line = appointments[i].getId()+";"+
							  appointments[i].getName()+";"+
							  appointments[i].getAge()+";"+
							  appointments[i].getGender()+";"+
                              appointments[i].getRecommendedDoctor()+";"+
							  appointments[i].getAppointmentTime();
							  
				writer.write(line+"\n");
			}
		}
		
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
}
