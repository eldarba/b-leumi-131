package app.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatisticsAspect {

	private int addCount;
	private int removeCount;
	private int totalCount;

	@Before("add()")
	public void countAdd() {
		addCount++;
	}

	@Before("remove()")
	public void countRemove() {
		removeCount++;

	}

	@Before("add() || remove()")
	public void countAddRemove() {
		totalCount++;
	}

	// pointcuts
	@Pointcut("execution(* add*(..))")
	public void add() {
	}

	@Pointcut("execution(* remove*(..))")
	public void remove() {
	}

	public int getAddCount() {
		return addCount;
	}

	public int getRemoveCount() {
		return removeCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

}
