
public class Find_The_Maze_1 {
    private static int N = 8;
    private static int [][] maze = {
        {0, 0, 0, 0, 0, 0, 0, 1},
        {0, 1, 1, 0, 1, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 0, 1, 1, 0, 0},
        {0, 1, 1, 1, 0, 0, 1, 1},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 1, 1, 0, 1, 0, 0},
    };

    private static final int PATHWAY_COLOUR = 0; // white
    private static final int WALL_COLOUR = 1; // blue
    private static final int BLOCKED_COLOUR = 2; // red
    private static final int PATH_COLOUR = 3; // green

    // 북 -> 동 -> 남 -> 서
    public static boolean findMazePath(int x, int y){
        if(x< 0 || y < 0 || x >= N || y >= N)
            return false;
        else if(maze[x][y] != PATHWAY_COLOUR)
            return false;
        else if(x == N-1 && y == N-1){
            maze[x][y] = PATH_COLOUR;
            return true;
        }
        else{
            maze[x][y] = PATH_COLOUR;
            if(findMazePath(x - 1, y) || findMazePath(x, y + 1) 
              || findMazePath(x + 1, y) || findMazePath(x , y - 1)){
                return true;
            }
            maze[x][y] = BLOCKED_COLOUR; // dead end
            return false;
        }           
    }
    public static void main(String[] args) {
        printMaze();
        findMazePath(0,0);
        printMaze();
    }

    /*
    미로 찾기(Decision Problem)
    
    boolean findPath(int x,int y){
        if(x,y) is the exit
            return true;
        else{
            for each neighbouring cell (x', y') of (x,y) do
                if(x', y') is on the pathway
                    if findPath(x', y')
                        return true;
            return false;
        }
    }
    
    boolean findPath(x, y){
        if(x,y) is the exit
            return true;
        else{
            이미 가본 위치로 체크
            mark (x,y) as a visited cell;
            for each neighbouring cell (x', y') of (x,y) do
                이미 방문된 위치가 아닌 경우에서만
                if(x', y') is on the pathway and not visited
                    if findPath(x', y')
                        return true;
            return false;
        }
    }
    
    boolean findPath(x, y){
        if(x, y) is either on the wall or a visited cell
            return false;
        else if(x,y) is the exit
            return true;
        else{
            mark (x,y) as a visited cell;
            for each neighbouring cell (x', y') of (x,y) do                                
                    if findPath(x', y')
                        return true;            
            return false;
        }        
    }
    */
}