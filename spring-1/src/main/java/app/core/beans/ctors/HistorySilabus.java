package app.core.beans.ctors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HistorySilabus implements Silabus {

	@Override
	public String getPlan() {
		return "teach the history of Java";
	}

}
