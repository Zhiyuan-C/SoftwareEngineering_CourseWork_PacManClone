package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.item.FlowerLarge;
import assignment3815ICT.zhiyuan.game.entities.item.FlowerSmall;
import assignment3815ICT.zhiyuan.game.entities.item.Fruit;
import assignment3815ICT.zhiyuan.game.entities.item.Item;
import assignment3815ICT.zhiyuan.game.entities.mob.ghosts.*;
import assignment3815ICT.zhiyuan.game.entities.mob.Mob;
import assignment3815ICT.zhiyuan.game.entities.mob.PacMan;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private GameHandler gameHandler;
    private PacMan pacMan;
    private Blinky blinky;
    private Pinky pinky;
    private Inky inky;
    private Clyde clyde;
    private ArrayList<Item> items;
    private Item[] experiment;
    private ArrayList<Ghost> ghosts;
    private final int TILE_SIZE = 32;

    public EntityManager(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
        pacMan = new PacMan(gameHandler);
        items = new ArrayList<>();
        ghosts = new ArrayList<>();
        blinky = new Blinky(gameHandler, 640, 320);
        setDefaultPos(blinky, 2 * TILE_SIZE, 3 * TILE_SIZE);
        pinky = new Pinky(gameHandler, 37 * TILE_SIZE, 3 * TILE_SIZE);
        setDefaultPos(pinky, 37 * TILE_SIZE, 3 * TILE_SIZE);
        inky = new Inky(gameHandler, 2 * TILE_SIZE, 19 * TILE_SIZE);
        setDefaultPos(inky,2 * TILE_SIZE, 19 * TILE_SIZE);
        clyde = new Clyde(gameHandler, 37 * TILE_SIZE, 19 * TILE_SIZE);
        setDefaultPos(clyde, 37 * TILE_SIZE, 19 * TILE_SIZE);
        addGhost(blinky);
        addGhost(pinky);
        addGhost(inky);
        addGhost(clyde);
    }

    public void update() {
        pacMan.update();
        for (Ghost ghost: ghosts) {
            ghost.update();
            if(!ghost.isAlive()) {
                System.out.println("died");
                ghost.setxPos(ghost.getDefaultXpos());
                ghost.setyPos(ghost.getDefaultYpos());
                pacMan.setScore(pacMan.getScore() + 1000);
                ghost.setAlive(true);
                // spawn back to base
            }
        }
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            item.update();
            if (!item.isActive()) {
                pacMan.setScore(pacMan.getScore() + item.getValue());
                if(item.isEnergyBooster()) {
                    for (Ghost ghost: ghosts){
                        ghost.setFrightenedMode(true);
                        ghost.setStartTimeFrightened(System.currentTimeMillis());
                    }
                }
                items.remove(item);
            }
        }



    }

    public void render(Graphics graphics) {
        for (Item item : items) {
            item.render(graphics);
        }
        for (Ghost ghost: ghosts) {
            ghost.render(graphics);
        }
        pacMan.render(graphics);
    }

    public void addFlowerSmall(float xPos, float yPos){
        items.add(new FlowerSmall(gameHandler, xPos, yPos));
    }
    public void addFlowerLarge(float xPos, float yPos) {
        items.add(new FlowerLarge(gameHandler, xPos,yPos));
    }
    public void addFruit(float xPos, float yPos){
        items.add(new Fruit(gameHandler, xPos, yPos));
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    public void addGhost(Ghost ghost) { ghosts.add(ghost); }

    public PacMan getPacMan() {
        return pacMan;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setDefaultPos(Mob mob, float xPos, float yPos){
        mob.setDefaultXpos(xPos);
        mob.setDefaultYpos(yPos);
    }
}
