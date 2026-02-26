package boardgame;

public class Board {

    private int rows;
    private int collumns;
    private Piece[][] pieces;

    public Board(int rows, int collumns) {
        if (rows < 1 || collumns < 1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.collumns = collumns;
        pieces = new Piece[rows][collumns];
    }

    public int getRows() {
        return rows;
    }

    public int getCollumns() {
        return collumns;
    }

    public Piece piece(int row, int collumns) {
        if (!positionExists(row, collumns)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][collumns];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && row < rows && column >= 0 && column < collumns;
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }







}
