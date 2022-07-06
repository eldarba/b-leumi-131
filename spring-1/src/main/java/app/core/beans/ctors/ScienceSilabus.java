package app.core.beans.ctors;

import org.springframework.stereotype.Component;

@Component
public class ScienceSilabus implements Silabus {

	@Override
	public String getPlan() {
		return "teach the scince of Java Programming";
	}

}
