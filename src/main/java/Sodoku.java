import java.util.Arrays;

public class Sodoku {
    /*Backtracking is a general algorithm for finding all (or some) solutions to some computational problems,
    notably constraint satisfaction problems, that incrementally builds candidates to the solutions,
    and abandons a candidate (“backtracks”) as soon as it determines that the candidate cannot possibly
    be completed to a valid solution.
     */

    public static void main(String a[]) {

        String [][] sodoku = {
            {"8","3",".",".","7",".",".",".","."},
            {"6",".",".","1","9","5",".",".","."},
            {".","9",".",".",".",".",".","6","."},
            {"8",".",".",".","6",".",".",".","3"},
            {"4",".",".","8",".","3",".",".","1"},
            {"7",".",".",".","2",".",".",".","6"},
            {".","6",".",".",".",".","2","8","."},
            {".",".",".","4","1","9",".",".","5"},
            {".",".",".",".","8",".",".","7","9"}
        };

        char [][] sodoku2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','.','.','.','.','.','6','.'},
                {'.','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char [][] sodoku3 = {
                {'6','3','8','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','8','.','.','.'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'7','.','4','.','.','.','.','.','.'}
        };

        char [] [] sodoku4 = {
                {'.', '1', '2', '7', '5', '.', '6', '.', '9'},
                {'9', '4', '.', '6', '8', '2', '1', '7', '5'},
                {'6', '7', '5', '4', '.', '1', '.', '8', '3'},
                {'1', '5', '4', '2', '3', '7', '8', '.', '.'},
                {'3', '6', '9', '8', '.', '.', '7', '2', '1'},
                {'2', '8', '7', '1', '6', '9', '5', '3', '4'},
                {'5', '2', '1', '9', '7', '4', '3', '6', '.'},
                {'4', '3', '8', '5', '2', '6', '9', '1', '7'},
                {'7', '.', '6', '.', '1', '8', '.', '5', '.'}
        };
        //String isValid = isSodokuValid(sodoku)?"valid":"not valid";
        //boolean isValid = isValidSudoku(sodoku2);
        boolean isValid = solveValidSodoku3(sodoku2);
        System.out.println("The soduku is " + isValid);
        printSodoku(sodoku4);
    }

    public static void printSodoku(char[][] board){
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.printf("\n");
        }
    }

    public static boolean solveValidSodoku3(char [][] board) {
        if(isSodokuFull(board))
            return true;
        else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (int n = 1; n <= 9; n++) {
                            board[i][j] = String.valueOf(n).charAt(0);
                            if (isValidRow(board, i) && isValidColumns(board, j) && isValidBlock(board, i / 3 * 3)) {
                                if (solveValidSodoku3(board)) {
                                    return true;
                                } else {
                                    board[i][j] = '.';
                                }
                            }
                        }
                        return false;
                    }
                }
            }
        }

        return true;

    }

    private static boolean isSodokuFull(char [][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    return false;
                }
            }
        }
        return true;
    }

    private static char findValidNumber(char [][] board,int i,int j, char n){
        if(n > '9'){
            return '.';
        }
        board[i][j] = n;
        if (isValidRow(board, i) && isValidColumns(board, j) && isValidBlock(board,i/3*3)) {
            return n;
        }

        int num= Character.getNumericValue(n)+1;
        return findValidNumber(board, i, j, String.valueOf(num).charAt(0));
    }

    private static boolean isValidRow(char[][] board, int i) {
        boolean [] rows = new boolean[9];
        for(int j=0;j<9;j++){
            if(board[i][j] != '.') {
                int val = Character.getNumericValue(board[i][j]);
                if (!rows[val - 1]) {
                    rows[val - 1] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidColumns(char[][] board, int column) {
        boolean[] columns = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][column] != '.') {
                int val = Character.getNumericValue(board[i][column]);
                if (!columns[val-1]) {
                    columns[val-1] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidBlock(char[][] board, int block) {
        boolean[] blocks = new boolean[9];
        for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
            for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]);
                    if (!blocks[val-1]) {
                        blocks[val-1] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private static boolean isValidBlock(char[][] board) {
        //check 3x3 blocks
        for (int block = 0; block < 9; block++) {
            boolean[] blocks = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        int val = Character.getNumericValue(board[i][j]);
                        if (!blocks[val-1]) {
                            blocks[val-1] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidColumns(char[][] board) {
        //check columns
        for (int j = 0; j < 9; j++) {
            boolean[] columns = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]);
                    if (!columns[val-1]) {
                        columns[val-1] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isValidRow(char[][] board) {
        //check rows
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = Character.getNumericValue(board[i][j]);
                    if (!row[val-1]) {
                        row[val-1] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void solveWholeSodoku(char[][] board){
        //if(isValidSodoku3(board)){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(board[i][j]=='.') {
                            findValidNumberForSoduku(board, i,j);

                        }
                    }
                }
    }

    public static void findValidNumberForSoduku(char[][] board, int i, int j){
        for(int n=0;n<9;n++) {
            board[i][j] = (char) (n+1);
            if(solveValidSodoku3(board)){
               return;
            }
        }
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        // check each column
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (m[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    m[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        //check each row
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (m[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    m[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (m[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        m[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }

        return true;
    }


    public static boolean isSodokuValid(String [][] input){
        String [][] columns = new String[9][9];
        String [] parts = new String[9];
        for(int i=0;i<input.length;i++) {
            if(!isValid(input[i])) {
                return false;
            }
            for(int j=0;j<input[0].length;j++) {
                columns[j][i] = input[i][j];
                parts[j] = input[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
        }

        for(int i=0;i<columns.length;i++) {
            if(!isValid(columns[i])) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValid(String [] array) {
        String[] arr1 = Arrays.stream(array).filter(row -> !row.equals(".")).toArray(String[]::new);
        long count1 = arr1.length;
        String[] arr2 = Arrays.stream(arr1).filter(row -> (Integer.valueOf(row) >= 1) && Integer.valueOf(row) <= 9).toArray(String[]::new);
        long count2 = arr2.length;
        long count3 = Arrays.stream(arr2).distinct().count();
        return count1 == count2 && count2 == count3;
    }
}

