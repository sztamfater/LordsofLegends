package hw6;

public class Student 
{
	// data fields
	private String name;
	private String id;
	private String major;
	private Course[] courses;
	private static int courseNo;
	private static int student_number;
	private static int CAPACITY;
	
	// constructor
	public Student(String name, String ID, String major)
	{
		this.name = name;
		this.id = ID;
		this.major = major;
		Student.CAPACITY = 50;
		student_number++;
		Student.courseNo = 0;
		courses = new Course[Student.CAPACITY];
	}
	
	// methods
	public String getName()
	{
		return this.name;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public String getMajor()
	{
		return this.major;
	}
	
	public String getCourses()
	{
		String s = "";
		for(Course c: this.courses)
		{
//			s+=c.getName() + " " + c.getID() + " " + c.getScore(this.id);
			s+= c.getName() + " " + c.getScore(this.id);
			s+="\n";
		}
		return s;
	}
	
	public int getCourseNo()
	{
		return Student.courseNo;
	}
	
	public void addCourse(Course c)
	{
		for(int i = 0; i < this.courses.length; i++)
		{
			if(this.courses[i] == c)
			{
				System.out.println("Student Already taking this course");
				break;
			}
		}
		this.courses[Student.courseNo++] = c;
	}
	
	public void dropCourse(Course c)
	{
		if(Student.courseNo <= 0)
		{
			System.out.println("This student is not taking any courses yet.");
		}
		else
		{
			// to find the course's name.
			int i = 0;
			do
			{
				if(this.courses[i] == c )
				{
					break;
				}
				i++;
			}while( i < Student.courseNo);
			//shifting to the left 
			for(int j = i+1 ; j < Student.courseNo; j++)
			{
				courses[j-1] = courses[j];
			}
			// each time this method is called, there is 1 less course this student is taking.
			Student.courseNo--;
		}
	}
	
	public double getGPA()
	{
		double gpa = 0;
		for(Course c: this.courses) 
		{
			gpa+=c.getScore(this.id);
		}
		return gpa/this.getCourseNo();
	}
	
	public int getStudentNo()
	{
		return student_number;
	}
	
	public boolean isTaking(Course c)
	{
		for(Course course: this.courses) 
		{
			if(course == c)
			{
				return true;
			}
		}
		return false;
	}
	
}
