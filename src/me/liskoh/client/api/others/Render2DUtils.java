package me.liskoh.client.api.others;

import me.liskoh.client.api.resources.ResourcePath;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Render2DUtils {

    public static void drawText(String text, int x, int y, float scale, int color) {
        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, scale);
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text, (int) (x / scale), (int) (y / scale), color);
        GL11.glPopMatrix();
    }

    public static void drawText(String text, int x, int y, float scale) {
        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text, (int) (x / scale), (int) (y / scale), 0xFFFFFFFF);
    }

    public static void drawRect(double x1, double y1, double d, double e, int p_73734_4_)
    {
        double var5;

        if (x1 < d)
        {
            var5 = x1;
            x1 = d;
            d = var5;
        }

        if (y1 < e)
        {
            var5 = y1;
            y1 = e;
            e = var5;
        }

        float var10 = (float)(p_73734_4_ >> 24 & 255) / 255.0F;
        float var6 = (float)(p_73734_4_ >> 16 & 255) / 255.0F;
        float var7 = (float)(p_73734_4_ >> 8 & 255) / 255.0F;
        float var8 = (float)(p_73734_4_ & 255) / 255.0F;
        Tessellator var9 = Tessellator.instance;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(var6, var7, var8, var10);
        var9.startDrawingQuads();
        var9.addVertex((double)x1, (double)e, 0.0D);
        var9.addVertex((double)d, (double)e, 0.0D);
        var9.addVertex((double)d, (double)y1, 0.0D);
        var9.addVertex((double)x1, (double)y1, 0.0D);
        var9.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public static void drawModalRectWithCustomSizedTexture(double x, double y, double u, double v, double width, double height, double textureWidth, double textureHeight) {
        double w = 1.0D / textureWidth;
        double h = 1.0D / textureHeight;
        Tessellator tes = Tessellator.instance;
        tes.startDrawingQuads();
        tes.addVertexWithUV(x, y + height, 0.0, u * w, (v + height) * h);
        tes.addVertexWithUV(x + width, y + height, 0.0, (u + width) * w, (v + height) * h);
        tes.addVertexWithUV(x + width, y, 0.0, (u + width) * w, v * h);
        tes.addVertexWithUV(x, y, 0.0, u * w, v * h);
        tes.draw();
    }

    public static void drawModalRect(float posX, float posY, int u, int v, float width, float height) {
        float scaledX = 1.0F / width;
        float scaledY = 1.0F / height;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(posX, posY + height, 0, u * scaledX, (v + height) * scaledY);
        tessellator.addVertexWithUV(posX + width, posY + height, 0, (u + width) * scaledX, (v + height) * scaledY);
        tessellator.addVertexWithUV(posX + width, posY, 0, (u + width) * scaledX, v * scaledY);
        tessellator.addVertexWithUV(posX, posY, 0, u * scaledX, v * scaledY);
        tessellator.draw();
    }



    public static void renderImage(ResourceLocation resource, int x, int y, int width, int height) {
        glColor4d(1, 1, 1, 1);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Minecraft.getMinecraft().getTextureManager().bindTexture(resource);
        drawModalRect(x, y, 0, 0, width, height);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public static void renderImage(ResourcePath resource, int x, int y, int width, int height) {
        glColor4d(1, 1, 1, 1);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Minecraft.getMinecraft().getTextureManager().bindTexture(resource.getResource());
        drawModalRect(x, y, 0, 0, width, height);
        GL11.glDisable(GL11.GL_BLEND);
    }

}
