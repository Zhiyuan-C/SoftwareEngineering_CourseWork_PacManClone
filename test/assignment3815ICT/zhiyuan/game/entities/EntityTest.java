package assignment3815ICT.zhiyuan.game.entities;

import assignment3815ICT.zhiyuan.game.Game;
import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.item.FlowerLarge;
import assignment3815ICT.zhiyuan.game.entities.item.Item;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class EntityTest {
    Game game = new Game("testing", 100, 100);
    GameHandler gameHandler = new GameHandler(game);


    @Test
    public void itemCollisions() {
        gameHandler.setPlayState();
        ArrayList<Item> items = new ArrayList<>();
        FlowerLarge flowerLarge = new FlowerLarge(gameHandler, 50, 50);
        items.add(flowerLarge);

        gameHandler.getMap().getEntityManager().getPacMan().setxPos(50);
        gameHandler.getMap().getEntityManager().getPacMan().setyPos(50);
        gameHandler.getMap().getEntityManager().setItems(items);
        // before collide active should be true
        assertTrue(flowerLarge.active);
        // same position should collide
        gameHandler.getMap().getEntityManager().getPacMan().itemCollisions(0, 0);
        // item active should be false
        assertFalse(flowerLarge.active);
    }

    @Test
    public void mobCollisions() {
        // set position pacman and blinky same so they will collide
        gameHandler.setPlayState();
        gameHandler.getMap().getEntityManager().getPacMan().setxPos(50);
        gameHandler.getMap().getEntityManager().getPacMan().setyPos(60);
        gameHandler.getMap().getEntityManager().getGhosts().get(0).setxPos(50);
        gameHandler.getMap().getEntityManager().getGhosts().get(0).setxPos(60);

    }

    @Test
    public void isWallCollide() {
    }
}