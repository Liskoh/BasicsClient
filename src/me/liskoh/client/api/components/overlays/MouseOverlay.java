package me.liskoh.client.api.components.overlays;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;

import java.util.List;

import static me.liskoh.client.api.uis.Render2DUtils.*;
import static org.lwjgl.opengl.GL11.*;

@Getter
@Setter
public class MouseOverlay {

    private List <String> array;

    public MouseOverlay(List<String> array){
        this.array = array;
    }

    public void draw(int mouseX, int mouseY) {

       // glDisable(GL_SCISSOR_TEST);

        mouseX += 10;
        mouseY -= 10;
        int max = 0;
        for(String str : this.array)
            if(Minecraft.getMinecraft().fontRenderer.getStringWidth(str) >= max)
                max = Minecraft.getMinecraft().fontRenderer.getStringWidth(str);

        drawRect(mouseX, mouseY - 3, mouseX + max + 10, mouseY - 1 + (10 * this.array.size()), 0xFF111111);

        for(int i = 0; i < this.array.size(); i++)
            Minecraft.getMinecraft().fontRenderer.drawString(this.array.get(i), mouseX + 5, mouseY + 1 + (10 * i), 0xFFFFFFFF);

      //  glEnable(GL_SCISSOR_TEST);

    }

}

