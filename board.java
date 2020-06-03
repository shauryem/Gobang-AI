import java.util.ArrayList;

public class board{

    private int[][] boardMatrix;

    public board(int boardSize) {
		boardMatrix = new int[boardSize][boardSize];
		
    }
    public board(board board) {
		int[][] matrixToCopy = board.getBoardMatrix();
		boardMatrix = new int[matrixToCopy.length][matrixToCopy.length];
		for(int i=0;i<matrixToCopy.length; i++) {
			for(int j=0; j<matrixToCopy.length; j++) {
				boardMatrix[i][j] = matrixToCopy[i][j];
			}
		}
	}
    
    public int getBoardSize() {
		return boardMatrix.length;
    }
    
    public boolean addStoneNoGUI(int posX, int posY, boolean black) {
        
        if(boardMatrix[posY][posX] != 0){
            return false;
        }
        boardMatrix[posY][posX] = black ? 2 : 1;
        return true;
    }
    
    public ArrayList<int[]> generateMoves() {
		ArrayList<int[]> moveList = new ArrayList<int[]>();
		
		int boardSize = boardMatrix.length;
		
		// Look for cells that has at least one stone in an adjacent cell.
		for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				
				if(boardMatrix[i][j] > 0) continue;
				
				if(i > 0) {
					if(j > 0) {
						if(boardMatrix[i-1][j-1] > 0 ||
						   boardMatrix[i][j-1] > 0) {
							int[] move = {i,j};
							moveList.add(move);
							continue;
						}
					}
					if(j < boardSize-1) {
						if(boardMatrix[i-1][j+1] > 0 ||
						   boardMatrix[i][j+1] > 0) {
							int[] move = {i,j};
							moveList.add(move);
							continue;
						}
					}
					if(boardMatrix[i-1][j] > 0) {
						int[] move = {i,j};
						moveList.add(move);
						continue;
					}
				}
				if( i < boardSize-1) {
					if(j > 0) {
						if(boardMatrix[i+1][j-1] > 0 ||
						   boardMatrix[i][j-1] > 0) {
							int[] move = {i,j};
							moveList.add(move);
							continue;
						}
					}
					if(j < boardSize-1) {
						if(boardMatrix[i+1][j+1] > 0 ||
						   boardMatrix[i][j+1] > 0) {
							int[] move = {i,j};
							moveList.add(move);
							continue;
						}
					}
					if(boardMatrix[i+1][j] > 0) {
						int[] move = {i,j};
						moveList.add(move);
						continue;
					}
				}
				
			}
		}

		return moveList;
		
    }
    
    public void print(){
        int boardSize = boardMatrix.length;

        for(int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
                System.out.print(boardMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
	public int[][] getBoardMatrix() {
		return boardMatrix;
	}
	
    
	

}