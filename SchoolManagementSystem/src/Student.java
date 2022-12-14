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
    private double Tuition = 0;
    private double APTuition = 2500;
    private double RegTuition = 1500;

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
     * Adds course to student's schedule if there is space, checks if the student is eligible to take the course 
     * and notifies the user if the student already has 6 courses
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
            System.out.println(name+" cannot register for "+course+" as AP Classes are only offered to upperclassmen");
            System.out.println();
        }
        if (addedCourse){
            if (isAPCourse)
                Tuition += APTuition;
            else{
                Tuition += RegTuition;
            }
        }   
    }

    public void addCourse(String[] courses){
        int numCoursesAdded = 0;
            while (numCoursesAdded <= numNullCourses(courses)){
                OUTER_LOOP: for (int j = 0; j < courses.length; j++){
                    boolean isAPCourse = courses[j].contains("AP");
                    if ((isAPCourse && (grade > 10 && grade <= 12)) || !isAPCourse){
                        INNER_LOOP: for (int i = 0;i < this.courses.length;i++){
                            if (this.courses[i] == null){
                                this.courses[i] = courses[j];
                                System.out.println(courses[j]+" successfully added to "+ name+ "'s schedule");
                                System.out.println();
                                numCoursesAdded++;
                                continue OUTER_LOOP;
                            }
                        } 
                    } else
                        System.out.println(name+ " can not add "+courses[j]+" to their schedule because it is an AP Class and they are not an upperclassman");  
                        System.out.println();       
                continue;
                }
            }
        
            if (numCoursesAdded < courses.length){
                for (int k = numCoursesAdded; k < courses.length;k++){
                    System.out.println("Unable to add "+courses[k]+" to "+name+"'s schedule because of inadequate space");
                    System.out.println();
                }
            }
            Tuition = numAPCourses(courses)*APTuition;
            Tuition = numRegCourses(courses)*RegTuition;

    }

    public int numNullCourses(String[] coursesLocal){
        int numNull = 0;
        for (String j : coursesLocal){
            if (j == null){
                numNull++;
            }
        }
        return numNull;
    }

    public int numAPCourses(String[] coursesLocal){
        int numAP = 0;
        for (String i : coursesLocal){
            if (i.contains("AP"))
                numAP++;
        }
        return numAP;
    }

    public int numRegCourses(String[] coursesLocal){
        return coursesLocal.length - numAPCourses(coursesLocal);
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

    public void printSummary(){
        System.out.println("Name: "+getName());
        System.out.println();
        System.out.println("Grade: "+getGrade());
        System.out.println();
        System.out.println("Id Number: "+getIdNum());
        System.out.println();
        System.out.println("Total tuition: "+getTuitionFormat());
        System.out.println();
        showSchedule();

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

    public int getNumCourses() {
        return numCourses;
    }

    public double getTuition() {
        return Tuition;
    }

    public String getTuitionFormat() {
        return "$"+Tuition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
