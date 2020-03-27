import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private int score = 0;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 5);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(width - 2) + 1;
                int y = random.nextInt(height - 2) + 1;
                boolean collides = false;
                for (Coin coin : coins) {
                    if (x == coin.getPosition().getX() && y == coin.getPosition().getY() ||
                        x == hero.getPosition().getX() && y == coin.getPosition().getY()) {
                        collides = true;
                        break;
                    }
                }
                if (!collides) {
                    coins.add(new Coin(x, y));
                    placed = true;
                }
            }
        }

        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(width - 2) + 1;
                int y = random.nextInt(height - 2) + 1;
                boolean collides = false;
                for (Monster monster : monsters) {
                    if (x == monster.getPosition().getX() && y == monster.getPosition().getY() ||
                        x == hero.getPosition().getX() && y == hero.getPosition().getY()) {
                        collides = true;
                        break;
                    }
                }
                if (!collides) {
                    monsters.add(new Monster(x, y));
                    placed = true;
                }
            }
        }

        return monsters;
    }

    private boolean retrieveCoins() {
        for (int i = 0; i < coins.size(); i++) {
            if (coins.get(i).getPosition().getX() == hero.getPosition().getX() &&
                coins.get(i).getPosition().getY() == hero.getPosition().getY()) {
                coins.remove(i);
                return true;
            }
        }
        return false;
    }

    private int verifyMonsterCollisions() {
        int collisions = 0;
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(hero.getPosition())) {
                collisions++;
            }
        }
        return collisions;
    }


    private boolean canElementMove(Position position) {
        if (position.getX() >= 0 && position.getX() < width && position.getY() >= 0 && position.getY() < height) {
            for (Wall wall : walls) {
                if (wall.getPosition().equals(position))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    private void moveHero(Position position) {
        if (canElementMove(position))
            hero.setPosition(position);
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            Position position = monster.move();
            if (canElementMove(position))
                monster.setPosition(position);
        }
    }

    public void processKey(KeyStroke key) throws IOException {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
        retrieveCoins();
        moveMonsters();
        score += verifyMonsterCollisions();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#202030"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin coin : coins) {
            coin.draw(graphics);
        }
        for (Monster monster : monsters) {
            monster.draw(graphics);
        }
        hero.draw(graphics);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(new TerminalPosition(0, 20), "Score: " + Integer.toString(score));
    }
}
