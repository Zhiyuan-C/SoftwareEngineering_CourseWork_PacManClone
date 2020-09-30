package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.item.Item;
import assignment3815ICT.zhiyuan.game.entities.mob.PacMan;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private GameHandler gameHandler;
    private PacMan pacMan;
    private ArrayList<Item> items;
    private ArrayList<Entity> mob;

    public EntityManager(GameHandler gameHandler) {
        this.gameHandler = gameHandler;
        pacMan = new PacMan(gameHandler);
        items = new ArrayList<>();
        mob = new ArrayList<>();
        addMob(pacMan);
    }

    public void update() {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            item.update();
        }
        pacMan.update();
    }
    public void render(Graphics graphics) {
//        for (Entity item : items) {
//            item.render(graphics);
//        }
//        items.forEach(item -> item.render(graphics));
        pacMan.render(graphics);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
    public void addMob(Entity entity) { mob.add(entity); }

    public PacMan getPacMan() {
        return pacMan;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
