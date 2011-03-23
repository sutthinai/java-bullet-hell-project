package bullethell.powerups;

import bullethell.game.Entity;
import bullethell.character.Character;
import bullethell.game.Game;
/**
 *
 * @author Kantee
 */
public class PowerUpDown extends Entity{
    private final int life;
    private final int addSpeed;
    private final boolean swapSize;

    public PowerUpDown(int x, int y, int life, int addSpeed, boolean swapSize) {
        super("sprites/Powerup.gif", x, y, false);
        this.addSpeed = addSpeed;
        this.swapSize = swapSize;
        this.life = life;
    }

    public void powerUp(Character character) {
            character.addLives(life);
            if (swapSize == true){
                if (character.isBig()==false)
                    character.swapSize();
        }
            character.setMaximalSpeed(addSpeed);

    }

    @Override
    public void collidedWith(Entity other) {
       if (other instanceof Character){
           powerUp((Character) other);
          Game.getInstance().removeEntity(this);
        }
    }

}