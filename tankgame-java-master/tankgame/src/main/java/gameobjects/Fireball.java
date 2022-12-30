package gameobjects;

import util.Transform;

import java.awt.image.BufferedImage;

public class Fireball extends Weapon {


    public Fireball(BufferedImage sprite, int damage, Tank shooter) {
        this.transform = new Transform();
        this.construct(sprite);
        this.shooter = shooter;

        this.damage += damage;
        this.init();
    }


    @Override
    protected void init() {
        this.velocity = 16.0f;
        this.hitPoints = 5;
    }

    @Override
    public void handleCollision(Tank collidingTank) {
        // Prevents weapon from hitting its own shooter that fires it
        if (collidingTank != this.shooter) {
            collidingTank.takeDamage(this.damage);
            this.destroy();
        }
    }


    @Override
    public void handleCollision(Wall collidingWall) {
        if (collidingWall.isBreakable()) {
            collidingWall.takeDamage(this.damage);
            this.takeDamage();
        } else {
            this.destroy();
        }
    }

}
