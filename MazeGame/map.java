package MazeGame;

public class map {
    int size;
    generateMap newMap = new generateMap(5);
    player player1;

    map(player player1, int size){
        this.size = size;
        this.player1 = player1;
        this.newMap = new generateMap(size);

    }

    //перестановка элементов
    public void refreshMap(int tempX, int tempY){
        char temp = this.newMap.maze[tempY][tempX];
        int x = this.player1.getX();
        int y = this.player1.getY();

        this.newMap.maze[tempY][tempX] = this.newMap.maze[y][x];
        this.newMap.maze[y][x] = temp;
    }

    //новая карта
    public void newMap(int size){
        generateMap newMap = new generateMap(size);
        this.size++;
    }

    //вывод карты
    public void showMap() {
        for (char[] mas : this.newMap.maze) {
            for (char symb : mas) {
                System.out.print(symb + " ");
            }
            System.out.println();
        }
    }
}
