package gameobjects;

import util.Transform;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Boomerang extends Weapon {

    private float spin; // Separate from rotation to animate spinning sprite


    public Boomerang(BufferedImage sprite, int damage, Tank shooter) {
        this.transform = new Transform();
        this.construct(sprite);
        this.shooter = shooter;

        Random rand = new Random();
        this.spin = rand.nextInt(360);

        this.damage += damage;
        this.init();
    }


    @Override
    protected void init() {
        this.velocity = 12.0f;
        this.hitPoints = 1;
    }


    @Override
    public void update() {
        this.collider.setRect(this.transform.getPositionX(), this.transform.getPositionY(), this.width, this.height);
        // Decrease velocity so that boomerang eventually flies backwards
        this.transform.move(this.velocity);
        this.velocity = Math.max(-16.0f, this.velocity - 0.2f);
        this.spin += 20;
    }


    @Override
    public void drawImage(Graphics g) {
        AffineTransform rotation = AffineTransform.getTranslateInstance(this.transform.getPositionX(), this.transform.getPositionY());
        rotation.rotate(Math.toRadians(this.spin), this.sprite.getWidth() / 2.0, this.sprite.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.sprite, rotation, null);
    }

}
