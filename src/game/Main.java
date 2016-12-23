package game;

public class Main {

	public static void main(String[] args) {
		ProgramaImpl pr = new ProgramaImpl();
		DbImpl db = new DbImpl();
		boolean outGame = true;

		while (outGame) {
			ProgramaImpl.endGdame = true;
			DbImpl.matrix = new char[3][3];
			db.printMatrix(DbImpl.matrix);
			System.out.println("Choose symbol for game x or 0");
			pr.determineSymbol();

			System.out.println("Do you want start first? Y/N ");
			boolean playUser = pr.userIsFirst();
			System.out.println("We are starting game !!!!");

			while (ProgramaImpl.endGdame) {
				if (playUser) {
					db.printMatrix(DbImpl.matrix);
					System.out.println("Enter coordinate x and y ");
					pr.playUser();
					pr.checkWon(pr.user.getSymbol());
					pr.checkTie();
					playUser = false;
				} else {
					pr.playProgram();
					pr.checkWon(pr.comp.getSymbol());
					pr.checkTie();
					playUser = true;
				}
			}
			db.printMatrix(DbImpl.matrix);
			System.out.print(" Win of comp : " + ProgramaImpl.countCompWin);
			System.out.print(" Win of user : " + ProgramaImpl.countUserWin);
			System.out.println(" TIE : " + ProgramaImpl.countTie);
			System.out.println(" If you want try again press : 0 ");

			int parametr = Integer.parseInt(pr.inputNumber());
			if (parametr == 0) {
				outGame = true;
			} else {
				outGame = false;
				System.out.println("Thank you for your game");
			}
		}
	}

}
