package MazeGame;
import java.util.Scanner;

public class game {
    public player player1 = new player();
    map labMap = new map(player1, 5);

    public void setPos(int x, int y, int tempX, int tempY) {
        if (this.labMap.newMap.maze[y][x] != '#') {
            this.player1.setX(x);
            this.player1.setY(y);
            labMap.refreshMap(tempX, tempY);
        }
    }

    // Движение
    public void movement(char move) {
        int x = player1.getX();
        int y = player1.getY();

        if (move == 'w')
            setPos(x, y - 1, x, y);
        else if (move == 's')
            setPos(x, y + 1, x, y);
        else if (move == 'a')
            setPos(x - 1, y, x, y);
        else if (move == 'd')
            setPos(x + 1, y, x, y);

        checkWin(false);
    }

    // Проверка выигрыша
    public void checkWin(Boolean skip) {
        int x = player1.getX();
        int y = player1.getY();

        if (skip || (x == labMap.size - 2 && y == labMap.size - 2)) {
            {
                System.out.println("Поздравляем! Вы прошли уровень " + player1.level + "!");

                this.labMap = new map(this.player1, labMap.size + 2);
                this.player1.setX(1);
                this.player1.setY(1);

                ++player1.level;
            }
        }
    }

    // Отображение меню
    public void showMenu() {
        System.out.println("Меню:");
        System.out.println("\nДвигаться (w/a/s/d)");
        System.out.println("Следующий уровень (n)");
        System.out.println("Правила игры (r)");
        System.out.println("Выход (q)");
    }

    // Правила игры
    public void showRules() {
        clearConsole();
        System.out.println("=== Правила игры ===");
        System.out.println("1. Вы играете за персонажа в лабиринте.");
        System.out.println("2. Ваша цель - добраться до выхода (правый нижний угол).");
        System.out.println("3. Для перемещения используйте клавиши:");
        System.out.println("   W - вверх");
        System.out.println("   A - влево");
        System.out.println("   S - вниз");
        System.out.println("   D - вправо");
        System.out.println("4. Каждое прохождение увеличивает размер лабиринта.");
        System.out.println("5. Для выхода из игры нажмите 'q'.");
        System.out.println("=====================");
        System.out.println("Нажмите Enter, чтобы вернуться в меню...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        game gamePlay = new game();

        while (true) {
            gamePlay.labMap.showMap();
            gamePlay.showMenu();
            char symb = sc.nextLine().charAt(0);
            if (symb == 'q') {
                System.out.println("Выход из игры...");
                break;
            } else if (symb == 'n') {
                gamePlay.checkWin(true);
            } else if (symb == 'r') {
                gamePlay.showRules();
            } else {
                clearConsole();
                gamePlay.movement(symb);
            }
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
