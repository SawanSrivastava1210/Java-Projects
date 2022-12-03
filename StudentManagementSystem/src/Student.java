/**
 * @author Sawan Srivastava
 * 
 * Class for creating and managing students
*/
public class Student {
    private String name;
    private int grade;
    public int idNum;
    private String[] courses = new String[6];
    private int numCourses = 0;

    public Student(String name, int grade){
        this.name = name;
        this.grade = grade;
        this.generateID();
    }

    private void generateID(){
        String tempID = "0000";
        int randomNum;
        idNum = 0;
        while (idNum < 10000){
            for (int i = 0; i < 5; i++){
                randomNum = (int)(Math.random()*10);
                tempID += randomNum;
            }
            idNum = Integer.parseInt(tempID);
        }
    }

    /**
     * @param course
     * Adds
     */
    public void addCourse(String course){
        boolean addedCourse = false;
        boolean isAPCourse = course.contains("AP");
        if ((isAPCourse && (grade > 10 && grade <= 12)) || !isAPCourse){
            for (int i = 0; i < courses.length; i++){
                if (!addedCourse){
                    if (courses[i] == null){
                        courses[i] = course;
                        addedCourse = true;
                        numCourses++;
                        System.out.println(course+" was successfully added to " + name + "'s schedule");
                        System.out.println();
                    }
                }
            }
            if (!addedCourse){
                System.out.println(name+"'s schedule is full");
                System.out.println("Please remove a class to add a course");
                System.out.println();
            }
        } else{
            System.out.println("AP Classes are only offered to upperclassmen");
            System.out.println();
        }   
    }

    public void removeCourse(String course){
        boolean removedCourse = false;
        for (int i = 0; i < courses.length; i++){
            if (courses[i] == course){
                courses[i] = null;
                removedCourse = true;
                numCourses--;
            }
        }
        if(removedCourse){
            System.out.println(course+" successfully removed from "+name+"'s schedule");
            System.out.println();
        } else{
            System.out.println("Unable to find "+course+" in "+name+"'s schedule");
            System.out.println();
        }
    }

    public void showSchedule(){
        System.out.println(name+"'s schedule:");
        for (int i = 0; i < courses.length; i++){
            System.out.print("Period "+(i+1)+": ");
            System.out.println(courses[i]);
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getIdNum() {
        return idNum;
    }

    public String[] getCourses() {
        return courses;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
