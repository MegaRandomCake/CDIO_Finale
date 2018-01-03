import controller.Controller;

public class Main {

	public static void main(String[] args) {
		System.out.println(Math.random() + " main launched");
		new Controller().runGame();
	}

}
