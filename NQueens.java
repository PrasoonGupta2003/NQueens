package Backtracking;
public class NQueens {
    public static void main(String[] args) {
        int n = 8;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
    }
    private static void nQueens(char[][] boards, int row) {
        int n = boards.length;
        if (row == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(boards[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
            for (int j = 0; j < n; j++) {
                if (isSafe(boards, row, j)){
                    boards[row][j] = 'Q';
                nQueens(boards, row + 1);
                boards[row][j] = 'X';//backtracking
            }
        }
    }private static boolean isSafe(char[][] board, int row,int col){
        int n =board.length;
        //check row
        for (int j = 0; j <n ; j++) {
            if (board[row][j]=='Q')return false;
        }
        //check col
        for (int i = 0; i <n ; i++) {
            if(board[i][col]=='Q')return false;
        }
        //check north-east
        int i = row,j=col;
        while (i>=0&&j<n){
            if (board[i][j]=='Q')return false;
            i--;
            j++;
        } //check south-east
        i=row;
        j=col;
        while (i<n&&j<n){
            if (board[i][j]=='Q')return false;
            i++;
            j++;
        }
        //check south-west
        i=row;
        j=col;
        while (i<n&&j>=0){
            if (board[i][j]=='Q')return false;
            i++;
            j--;
        }
        //check north-west
        i=row;
        j=col;
        while (i>=0&&j>=0){
            if (board[i][j]=='Q')return false;
            i--;
            j--;
        }return true;
    }
}