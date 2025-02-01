package MazeGame;

public class player {
    private int xPos = 1;
    private int yPos = 1;
    int level = 1;

    public int getX(){
        return xPos;
    }
    public void setX(int x){
        this.xPos = x;
    }

    public int getY(){
        return yPos;
    }
    public void setY(int y){
        this.yPos = y;
    }
}
