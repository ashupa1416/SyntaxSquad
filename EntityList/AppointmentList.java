package EntityList;
import Entity.Appointment;
public class AppointmentList{
	private Appointment appointments[];
	
	public AppointmentList(){
		appointments = new Appointment[5];
	}
	public AppointmentList(int size){
		appointments = new Appointment[size];
	}
	
	//show all appointments
	public void showAllAppointments(){
		for(int i=0;i<appointments.length;i++){
			if(appointments[i] != null){
				appointments[i].showInfo();
			}
		}
	}
	
	//insert Appointment into Array
	public void insertAppointment(Appointment a){
		boolean flag = false;
		for(int i=0;i<appointments.length;i++){
			
			if(appointments[i] == null){
				appointments[i] = a;
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("Appointment added");
		}
		else{
			System.out.println("Appointment List is Fulll ! Failed to add");
		}
	}
	
	public void removeAppointmentById(double id){
		boolean flag = false; 
		for(int i=0;i<appointments.length;i++){
			if(appointments[i] != null){
				if(appointments[i].getId() == id){
					appointments[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Appointment Deleted Successfully");
		}
		else{
			System.out.println("Appointment is not Found");			
		}
	}

	public Appointment getAppointmentById(double id) {
		for (int i = 0; i < appointments.length; i++) {
			if (appointments[i] != null && appointments[i].getId() == id) {
				return appointments[i];
			}
		}
		return null; // Appointment with the given ID is not found
	}
	
	public Appointment[] getAllAppointment(){return appointments;} 
	
	public void setAllAppointments(Appointment[] appointments ){
		this.appointments = appointments;
	}
}
