package app.core.beans.ctors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class ClassRoom {

	private static int nextId = 1;

	private int id = nextId++;

}
