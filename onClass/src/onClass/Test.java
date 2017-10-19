package onClass;
public class Test {
    public int countBattleships(char[][] board) {
        int sum=0;
        if(board==null)
        return 0;
        
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(
                    ((i>=1&&j>=1)&&board[i][j]=='x'&&(board[i-1][j]!='x'&&board[i][j-1]!='x'))
                ||(i>=1&&j==0&&board[i][j]=='x'&&(board[i-1][j]!='x'))
                ||(i==0&&j>0&&board[i][j]=='x'&&board[i][j-1]!='x')
                ||(i==0&j==0&&board[i][j]=='x')
                )
                sum++;
            }
        }
        return sum;
    }
   
}