import java.io.*;

class BotTraverse {

	private boolean traverse(int x1, int y1, int x2, int y2) {
		if (x1 > x2 || y1 > y2)
			return false;
		if (x1 == x2 && y1 == y2) {
			System.out.println(x1 + x2 + y1 + y2);
			return true;
		}
		return traverse(x1 + y1, y1, x2, y2) || traverse(x1, x1 + y1, x2, y2);
	}

	public static void main(String args[]) {
		BotTraverse bot = new BotTraverse();
		int x1 = 1, y1 = 4, x2 = 5, y2 = 9;
		System.out.println("Ans: " + bot.traverse(x1, y1, x2, y2));
	}
}