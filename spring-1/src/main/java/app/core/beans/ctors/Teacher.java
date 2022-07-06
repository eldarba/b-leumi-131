package app.core.beans.ctors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teacher {

	private ClassRoom classRoom;
	@Autowired
	private Silabus silabus;

//	public Teacher() {
//	}

	public Teacher(ClassRoom classRoom, Silabus silabus) {
		super();
		this.classRoom = classRoom;
		this.silabus = silabus;
	}

	
	public Teacher(Silabus silabus) {
		super();
		this.silabus = silabus;
	}

	@Autowired
	public Teacher(ClassRoom classRoom) {
		super();
		this.classRoom = classRoom;
	}

	public void teach() {
		System.out.println("hello class " + classRoom.getId() + " silabus: " + silabus.getPlan());
	}

}
