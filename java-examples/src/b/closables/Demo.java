package b.closables;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		// ARM - Auto Resource Management
		try (

				Scanner sc = new Scanner("aaa bbb ccc");

				Window window = new Window();

		) {
			System.out.println(sc.next());
			if (Math.random() < 0.5) {
				throw new RuntimeException("error");
			}
			System.out.println(sc.next());
			System.out.println(sc.next());
		}

	}

}

class Window implements AutoCloseable {
	{
		System.out.println("open the window");
	}

	@Override
	public void close() {
		System.out.println("close the window");

	}

}