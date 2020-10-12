package me.liskoh.client.api.components.texts;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.items.ItemStackComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;

@Getter
@Setter
public class Text extends Component {

    private float scale;
    private String text;
    private String hoverText;
    private FontRenderer renderer;
    private int color;

    public Text(int x, int y, String text) {
        super(x, y);
        this.text = text;
        this.scale = 1.0F;
        this.renderer = Minecraft.getMinecraft().fontRenderer;
        this.color = 0xFFFFFFFF;
    }

    public Text(int x, int y, float scale, String text, int color) {
        super(x, y);
        this.text = text;
        this.scale = scale;
        this.renderer = Minecraft.getMinecraft().fontRenderer;
        this.color = color;
    }

    public Text setScale(float scale) {
        this.scale = scale;
        this.setX((int) (this.getX() / scale));
        this.setY((int) (this.getY() / scale));
        return this;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        GL11.glPushMatrix();
        GL11.glScalef(this.scale, this.scale, this.scale);
        renderer.drawStringWithShadow(this.text, (int) (this.getX() / scale), (int)(this.getY() / scale), this.color);
        GL11.glPopMatrix();
    }

    public void drawHover(int mouseX, int mouseY) {
        GL11.glPushMatrix();
        GL11.glScalef(this.scale, this.scale, this.scale);
        renderer.drawStringWithShadow(this.hoverText, (int) (this.getX() / scale), (int)(this.getY() / scale), this.color);
        GL11.glPopMatrix();
    }
}
