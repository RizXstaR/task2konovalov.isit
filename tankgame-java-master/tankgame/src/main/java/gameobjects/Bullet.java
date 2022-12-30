package gameobjects;

import util.Transform;

import java.awt.image.BufferedImage;


public class Bullet extends Weapon {


    public Bullet(BufferedImage sprite, int damage, Tank shooter) {
        this.transform = new Transform();
        this.construct(sprite);
        this.shooter = shooter;

        this.damage += damage;
        this.init();
    }

    @Override
    protected void init() {
        this.velocity = 12.0f;
        this.hitPoints = 1;
    }

}
