package board;

import coordinates.Coordinate;
import pieces.Pieces;

public class ChessBoard {

    private int[][] board;


    public void initializeBoard() {
        board = new int[8][8];
    }

    public int[][] getBoard() {
        return board;
    }


    public int[][] getFilledBoard() {
        return board;
    }


    public void putPiece(Pieces piece, Coordinate coordinate) throws Exception {
         if (coordinate.getX() < 0 || coordinate.getX() > 7 || coordinate.getY()< 0 || coordinate.getY()>7 ) throw new Exception("Not able to put");
         board[coordinate.getX()][coordinate.getX()] = piece.getValue();
    }

    public void movePiece(Pieces bishop, Coordinate initialCoordinate, Coordinate endCoordinate) throws Exception {
        if(bishop.getValue() == Pieces.BISHOP.getValue()) {
            if (endCoordinate.getX() < 0 || endCoordinate.getX() > 7 || endCoordinate.getY()< 0 || endCoordinate.getY()>7 ) throw new Exception("Not able to move");
            if (initialCoordinate.getY() == endCoordinate.getY() || initialCoordinate.getX() == endCoordinate.getX()) throw new Exception("Not Able to move");
            int horizontalDirection  = endCoordinate.getX() - initialCoordinate.getX() ;
            int verticalDirection  = endCoordinate.getY() - initialCoordinate.getY() ;
            isOnTheSameLine(initialCoordinate, endCoordinate, horizontalDirection, verticalDirection);
            board[initialCoordinate.getX()][initialCoordinate.getX()] = 0;
            board[endCoordinate.getX()][endCoordinate.getX()] = Pieces.BISHOP.getValue();
        }


    }

    private void isOnTheSameLine(Coordinate initialCoordinate, Coordinate endCoordinate, int horizontalDirection, int verticalDirection) throws Exception {
        Coordinate lastInitialCoordinate = getLastCoordinate(initialCoordinate, horizontalDirection, verticalDirection);
        Coordinate lastEndCoordinate = getLastCoordinate(endCoordinate, horizontalDirection, verticalDirection);
        boolean sameLine = lastInitialCoordinate.equals(lastEndCoordinate);
        if (!sameLine) {
            throw new Exception("Not on the same line");
        }
    }

    private Coordinate getLastCoordinate(Coordinate coordinate, int horizontalDirection, int verticalDirection) {
        int lastPossibleXPointOfInitCoordinate;
        int lastPossibleYPointOfInitCoordinate;
        if(horizontalDirection>0) {
            lastPossibleXPointOfInitCoordinate = 7-coordinate.getX();
        } else  {
            lastPossibleXPointOfInitCoordinate = -coordinate.getX();
        }
        if(verticalDirection>0) {
            lastPossibleYPointOfInitCoordinate = 7-coordinate.getY();
        } else  {
            lastPossibleYPointOfInitCoordinate = -coordinate.getY();
        }
        int delta = Math.min(Math.abs(lastPossibleXPointOfInitCoordinate), Math.abs(lastPossibleYPointOfInitCoordinate));
        int lastXCoordinate;
        if(horizontalDirection>0) {
           lastXCoordinate = coordinate.getX() + delta;
        } else  {
            lastXCoordinate = coordinate.getX() - delta;
        }
        int lastYCoordinate;
        if(verticalDirection>0) {
            lastYCoordinate = coordinate.getY() + delta;
        } else  {
            lastYCoordinate = coordinate.getY() - delta;
        }
        return new Coordinate(lastXCoordinate, lastYCoordinate);
    }


}
