package me.liskoh.client.api.components.overlays;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;

import static me.liskoh.client.api.others.Render2DUtils.*;

@Getter @Setter
public  class ClassicOverlay extends Overlay {



    public ClassicOverlay(int x, int y) {
        super(x, y);
    }



    @Override
    public void draw(int mouseX, int mouseY) {
            mouseX += 10;
            mouseY -= 10;
            int max = 0;

            for(String str : this.getArray())
                if(Minecraft.getMinecraft().fontRenderer.getStringWidth(str) >= max)
                    max = Minecraft.getMinecraft().fontRenderer.getStringWidth(str);

            drawRect(mouseX, mouseY - 3, mouseX + max + 10, mouseY - 1 + (10 * this.getArray().size()), 0xFF111111);

            for(int i = 0; i < this.getArray().size(); i++)
                Minecraft.getMinecraft().fontRenderer.drawString(this.getArray().get(i), mouseX + 5, mouseY + 1 + (10 * i), 0xFFFFFFFF);
        }
}
