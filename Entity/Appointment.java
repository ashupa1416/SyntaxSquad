package Entity;
public final class Appointment extends Person{
    private String appointmentTime;
    private String recommendedDoctor;

    public Appointment(double id,String name, double age, String gender, String recommendedDoctor, String appointmentTime) {
       super(id,name,age,gender);
        this.recommendedDoctor = recommendedDoctor;
        this.appointmentTime = appointmentTime;
        
    }	

	public void setrRcommendedDoctor(String recommendedDoctor) {
        this.recommendedDoctor = recommendedDoctor;
    }
    public String getRecommendedDoctor() {return recommendedDoctor;}

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public String getAppointmentTime() {return appointmentTime;}
    
    

public void showInfo() {
            System.out.println("Appointment ID: " + id);
            System.out.println("Appointment Name: " + name);
            System.out.println("Appointment Age: " + age);
            System.out.println("Appointment Gender: " + gender);
            System.out.println("Recommended Doctor: " + recommendedDoctor);
			System.out.println("Appointment Time: " + appointmentTime);
            
    }

}
