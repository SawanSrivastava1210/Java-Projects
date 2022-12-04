/**
 * @author Sawan Srivastava
 * 
 * Main Class
*/
public class App {
    public static void main(String[] args) throws Exception {
        Student Sawan = new Student("Sawan", 11);
        Sawan.addCourse("AP Computer Science");
        Sawan.addCourse("AP Psychology");
        Sawan.addCourse("AP Calculus AB");
        Sawan.addCourse("English 3");
        Sawan.addCourse("Interpersonal Communication");
        Sawan.addCourse("Python Programming");
        Sawan.addCourse("AP Physics 2");
        Sawan.removeCourse("AP Physics 2");
        Sawan.addCourse("Photography");
        Sawan.printSummary();
        
        Student John = new Student("John",10);
        John.addCourse("AP CS");
        John.addCourse("English 2");
        John.printSummary();
    }
}
