package hw6;

import java.util.Arrays;

public class Course 
{
	// data fields
	private String name;
	private String id;
	private String department;
	private int max_cap;
	private int min_cap;
	private Student[] students;
	private double[] scores;
	private int studentNo;
	private static int course_number;
	
	// constructor
	public Course(String name, String id, String department)
	{
		this.name = name;
		this.id = id;
		this.department = department;
		this.max_cap = 60;
		this.min_cap = 1;
		course_number++;
		students = new Student[this.max_cap];
		this.studentNo = 0;
		scores = new double[this.max_cap];
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public String getDept()
	{
		return this.department;
	}
	
	public int getMinCap()
	{
		return this.min_cap;
	}
	
	public int getMaxCap()
	{
		return this.max_cap;
	}
	
	public Student[] getStudents()
	{
		Student[] Studentcopy = Arrays.copyOf(students, this.studentNo);
		return Studentcopy;
	}
	
	public int getStudentNo()
	{
		return 1;
	}
	
	public void addStudent(Student s)
	{
		if( this.studentNo < this.max_cap)
		{
			students[this.studentNo++] = s;
		}
		else
		{
			System.out.println("Course is at its max Capacity!");
		}
	}
	
	public void dropStudent(Student s)
	{
		if(this.studentNo <= 0)
		{
			System.out.println("There is no student in this class");
		}
		else
		{
			// to find the student's name.
			int i = 0;
			do
			{
				if(students[i].equals(s.getName()))
				{
					break;
				}
				i++;
			}while( i < this.studentNo);
			//shifting to the left 
			for(int j = i+1 ; j < this.studentNo; j++)
			{
				students[j-1] = students[j];
			}
			// each time this method is called, there is 1 less student in the class.
			this.studentNo--;
		}
	}
	
	public double getScore(String id)
	{
		int i = 0;
		for(; i < this.students.length;i++)
		{
			if(this.students[i].getID() == id )
			{
				break;
			}
		}
		return this.scores[i];
	}
	
	public void setScore(Student s , double score)
	{

		int i = 0;
		for(; i < this.students.length;i++)
		{
			if(this.students[i] == s)
			{
				break;
			}
			
		}
		this.scores[i] = score;
	}
	
	public double getAverage()
	{
		double average=  0;
		for(int i = 0 ;i < this.scores.length;i++)
		{
			average+=this.scores[i];
		}
		return average/this.scores.length;
	}
	
	public int getCourseNo()
	{
		return Course.course_number;
	}
}
