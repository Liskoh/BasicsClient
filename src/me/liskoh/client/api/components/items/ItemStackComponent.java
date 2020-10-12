package me.liskoh.client.api.components.items;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.overlays.MouseOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

import static org.lwjgl.opengl.GL11.*;

@Getter
public  class ItemStackComponent extends Component {

    private float scale;
    private ItemStack stack;
    private RenderItem renderer;

    public ItemStackComponent(int x, int y) {
        super( x, y);
        this.renderer = new RenderItem();
    }

    public ItemStackComponent setItem(ItemStack stack) {
        this.stack = stack;
        return  this;
    }

    public ItemStackComponent setScale(float scale) {
        this.scale = scale;
        this.setX((int) (this.getX() / scale));
        this.setY((int) (this.getY() / scale));
        return this;
    }

    @Override
    public void draw(int mouseX, int mouseY) {

        glPushMatrix();
        glEnable(GL_DEPTH_TEST);
        glScaled(scale, scale, scale);
        this.renderer.renderItemAndEffectIntoGUI(Minecraft.getMinecraft().fontRenderer, Minecraft.getMinecraft().getTextureManager(), this.stack, this.getX(), this.getY());
        glScaled(1.0F, 1.0F, 1.0F);
        glDisable(GL_LIGHTING);
        glDisable(GL_DEPTH_TEST);
        glPopMatrix();
    }

}
