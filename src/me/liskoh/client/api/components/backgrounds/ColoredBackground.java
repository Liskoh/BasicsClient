package me.liskoh.client.api.components.backgrounds;

import static me.liskoh.client.api.others.Render2DUtils.*;
import static me.liskoh.client.api.colors.HexaColor.*;

public class ColoredBackground extends Background{

    public ColoredBackground(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        drawRect(this.getX(),  this.getY(),this.getX() + this.getWidth(),this.getY() + this.getHeight(), this.getColor());
    }
}
