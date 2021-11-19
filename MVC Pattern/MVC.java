/*

The Model View Controller(MVC) design pattern specifies that an application consist of a data model, view information, 
and control information. The pattern requires that each of these be separated into different objects.
MVC is more of an architectural pattern, but not for complete application. MVC mostly relates to the UI / interaction 
layer of an application.

Here the Model contains only the pure application data, it contains no logic describing how to present the data to a user.The database
part is managed there.
The View presents the model’s data to the user. The view knows how to access the model’s data, but it does not know what this data
means or what the user can do to manipulate it.
The Controller exists between the view and the model. It listens to events triggered by the view (or another external source) and 
executes the appropriate reaction to these events. In most cases, the reaction is to call a method on the model.

To understand this pattern see the code below.

*/
class Student {
    private String rollNo;
    private String name;
     
    public String getRollNo() {
        return rollNo;
    }
     
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
     
    public String getName() {
        return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }
}
class StudentView {
    public void printStudentDetails(String studentName, String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}
class StudentController {
    private Student model;
    private StudentView view;
  
    public StudentController(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }
  
    public void setStudentName(String name){
        model.setName(name);        
    }
  
    public String getStudentName(){
        return model.getName();        
    }
  
    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);        
    }
  
    public String getStudentRollNo(){
        return model.getRollNo();        
    }
    public void updateView(){                
        view.printStudentDetails(model.getName(), model.getRollNo());
    }    
}
public class MVC {
    public static void main(String args[]){

        Student model  = retriveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);  

        controller.updateView();
        controller.setStudentName("Unique");
        controller.updateView();
    }
    private static Student retriveStudentFromDatabase(){
        Student student = new Student();
        student.setName("Prime");
        student.setRollNo("2357");
        return student;
    }
    
}
