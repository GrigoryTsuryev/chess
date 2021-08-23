import board.ChessBoard;
import coordinates.Coordinate;
import pieces.Pieces;

public class MainApp {

    public static void main(String[] args) throws Exception {

        ChessBoard chessBoard =  new ChessBoard();
        chessBoard.initializeBoard();
        Coordinate initialCoordinate = new Coordinate(2, 0);
        chessBoard.putPiece(Pieces.BISHOP, initialCoordinate);
        Coordinate endCoordinate = new Coordinate(0, 2);
        chessBoard.movePiece(Pieces.BISHOP, initialCoordinate, endCoordinate);





    }
}

