package app.core.beans.ctors;

public class Teacher {

	private ClassRoom classRoom;
	private Silabus silabus;

	public Teacher(ClassRoom classRoom, Silabus silabus) {
		super();
		this.classRoom = classRoom;
		this.silabus = silabus;
	}

	public void teach() {
		System.out.println("hello class " + classRoom.getId() + " to we learn: " + silabus.getPlan());
	}

}
