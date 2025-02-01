package MazeGame;
//простейший алгоритм - генерация рандомных путей
public class generateMap {
    char[][] maze;
    private int sizeMap;

    public generateMap(int size) {
        // Убедимся, что размер карты нечётный
        this.sizeMap = (size % 2 == 0) ? size + 1 : size;

        maze = new char[this.sizeMap][this.sizeMap];

        // Инициализируем всю карту стенами
        for (int y = 0; y < this.sizeMap; y++) {
            for (int x = 0; x < this.sizeMap; x++) {
                maze[y][x] = '#';
            }
        }
        
        generateGraph(1, 1);
    }

    private void generateGraph(int x, int y) {
        int[][] dirs = {{0, -2}, {0, 2}, {-2, 0}, {2, 0}}; // куда мы можем идти, вверх вниз м итд

        // случайным образом выбираем направление движения
        for (int i = 0; i < 4; i++) {
            int j = randomModule.nextInt(0, 4);
            int[] tmp = dirs[i];
            dirs[i] = dirs[j];
            dirs[j] = tmp;
        }

        // очищаем клетки по рандому, сохряняя связанность клеток
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];

            if (nx > 0 && ny > 0 && nx < sizeMap - 1 && ny < sizeMap - 1 && maze[ny][nx] == '#') {
                maze[ny][nx] = '.';
                maze[ny - d[1] / 2][nx - d[0] / 2] = '.';
                generateGraph(nx, ny);

                maze[1][1] = 'X';
            }
        }
    }
}