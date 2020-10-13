package me.liskoh.client.api.components.scrollbars;

import lombok.Getter;

import static me.liskoh.client.api.colors.HexaColor.GREY;
import static me.liskoh.client.api.others.Render2DUtils.drawRect;

@Getter
public class ColoredScrollBar extends Scrollbar {

    private int color;

    public ColoredScrollBar(int x, int y) {
        super(x, y);
        this.color = GREY;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        drawRect(this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), this.color);
    }

}
