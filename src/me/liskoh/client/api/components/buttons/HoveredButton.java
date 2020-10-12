package me.liskoh.client.api.components.buttons;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.uis.Render2DUtils;
import net.minecraft.util.ResourceLocation;

@Getter
@Setter
public class HoveredButton extends Button {

    private ResourceLocation hoverLocation;

    public HoveredButton(int x, int y) {
        super(x, y);
    }



    @Override
    public void draw(int mouseX, int mouseY) {

        if(this.hoverLocation == null)
            this.hoverLocation = new ResourceLocation(this.getResource().getResourcePath().replace(".png", "_hover.png"));

        if(!isWithin(mouseX, mouseY))
            Render2DUtils.renderImage(this.getResource(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), 1);
        else
            Render2DUtils.renderImage(this.hoverLocation, this.getX(), this.getY(), this.getWidth(), this.getHeight(), 1);

        drawText(mouseX, mouseY);
    }
}
