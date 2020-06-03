import java.util.Scanner;

public class game {
    
    private board board;
	private boolean isPlayersTurn = true;
	private boolean gameFinished = false;
	private int minimaxDepth = 3;
	private boolean aiStarts = false; // AI makes the first move
	private minimax ai;
    private int winner; // 0: There is no winner yet, 1: AI Wins, 2: Human Wins
    public Scanner input;
   

    public void playerMove(){
        input = new Scanner(System.in);
        String in = input.nextLine();
        int posX = in.charAt(0) - 'A';
        int posY = Integer.parseInt(in.substring(1)) - 1;
        if(playMove(posX, posY, !aiStarts)){
            isPlayersTurn = false;
        }

    }

    public void compMove(){
        //board.print();
        int[] aiMove = ai.calculateNextMove(minimaxDepth);

        if(aiMove == null) {
            System.out.println("No possible moves left. Game Over.");
            gameFinished = true;
            return;
        }

        playMove(aiMove[1], aiMove[0], aiStarts);
        isPlayersTurn = true;

    }

    public game(boolean computerStarts, board board) {
        this.board = board;
        this.aiStarts = computerStarts;
		ai = new minimax(board);
		
		winner = 0;
    }
    
    public void start(){
        

        if(aiStarts) playMove(board.getBoardSize()/2, board.getBoardSize()/2, false);

        while(gameFinished == false){
            playerMove();
            
            winner = checkWinner();

            if(winner == 2){
                System.out.println("Player WON!");
				gameFinished = true;
				return;
            }


            compMove();

            winner = checkWinner();
			
			if(winner == 1) {
				System.out.println("AI WON!");
				gameFinished = true;
				return;
            }
            
            if(board.generateMoves().size() == 0) {
				System.out.println("No possible moves left. Game Over.");
				gameFinished = true;
				return;
				
            }
            
           

        }
    }

    private int checkWinner() {
		 if(minimax.getScore(board, true, false) >= minimax.getWinScore()) return 2;
		 if(minimax.getScore(board, false, true) >= minimax.getWinScore()) return 1;
		return 0;
	}
    private boolean playMove(int posX, int posY, boolean black) {

        int a = posX + 'A';
        int p = posY + 1;
        System.out.println("played: " + (char)a + "," + p);
        return board.addStoneNoGUI(posX, posY, black);
	}
}