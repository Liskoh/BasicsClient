package net.minecraft.client.gui;

import me.liskoh.client.api.uis.UI;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

public class ScaledResolution
{
    private int scaledWidth;
    private int scaledHeight;
    private double scaledWidthD;
    private double scaledHeightD;
    private int scaleFactor;
    private static final String __OBFID = "CL_00000666";

    public ScaledResolution(Minecraft p_i46324_1_, int p_i46324_2_, int p_i46324_3_)
    {
        this.scaledWidth = p_i46324_2_;
        this.scaledHeight = p_i46324_3_;
        this.scaleFactor = 1;
        boolean var4 = p_i46324_1_.func_152349_b();
        int var5 = p_i46324_1_.gameSettings.guiScale;

        GuiScreen current = p_i46324_1_.currentScreen;

        if (current instanceof UI)
            var5 = 2;

        if (var5 == 0)
        {
            var5 = 1000;
        }

        while (this.scaleFactor < var5 && this.scaledWidth / (this.scaleFactor + 1) > 320 && this.scaledHeight / (this.scaleFactor + 1) > 240)
        {
            ++this.scaleFactor;
        }

        while(this.scaleFactor > var5 && this.scaledWidth / (this.scaleFactor + 1) <= 320 && this.scaledHeight / (this.scaleFactor + 1) <= 240) {
            var5 = 2;
        }

        this.scaledWidthD = (double)this.scaledWidth / (double)this.scaleFactor;
        this.scaledHeightD = (double)this.scaledHeight / (double)this.scaleFactor;
        this.scaledWidth = MathHelper.ceiling_double_int(this.scaledWidthD);
        this.scaledHeight = MathHelper.ceiling_double_int(this.scaledHeightD);
    }

    public int getScaledWidth()
    {
        return this.scaledWidth;
    }

    public int getScaledHeight()
    {
        return this.scaledHeight;
    }

    public double getScaledWidth_double()
    {
        return this.scaledWidthD;
    }

    public double getScaledHeight_double()
    {
        return this.scaledHeightD;
    }

    public int getScaleFactor()
    {
        return this.scaleFactor;
    }
}
