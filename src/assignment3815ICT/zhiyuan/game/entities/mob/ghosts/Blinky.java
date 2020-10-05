package assignment3815ICT.zhiyuan.game.entities.mob.ghosts;

import assignment3815ICT.zhiyuan.game.GameHandler;
import assignment3815ICT.zhiyuan.game.entities.mob.movement.Movement;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Blinky extends Ghost {

    private ArrayList<BufferedImage> blinkyImages;

    public Blinky(GameHandler gameHandler, float xPos, float yPos) {
        super(gameHandler, xPos, yPos);
        blinkyImages = getIndividualImages(0);
        setAnimationFrame(blinkyImages);
        inBase = true;
//        direction = getDirection();
        speed = 1.5f;
    }

    @Override
    public void update() {
        frightenedMode();
        setTargetPosition();
        setMove();
        direction = getDirection();
        movingDir = direction;
//        System.out.println(direction);
        move();


    }

    @Override
    public void setTargetPosition() {
        targetPosX = gameHandler.getEntityManager().getPacMan().getxPos() + (gameHandler.getEntityManager().getPacMan().getWidth() / 2 - (targetWidth / 2));
        targetPosY = gameHandler.getEntityManager().getPacMan().getyPos() + (gameHandler.getEntityManager().getPacMan().getHeight() / 2 - (targetHeight / 2));
    }



}
