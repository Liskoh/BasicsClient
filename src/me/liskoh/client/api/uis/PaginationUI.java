package me.liskoh.client.api.uis;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.texts.Text;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class PaginationUI extends UI {

    private int currentPage;
    private int maxPage;
    private int componentsPerPage;
    private int currentIndex;


    public PaginationUI() {
        this.currentPage = 1;
        this.currentIndex = 0;
    }

    public abstract void setCurrentComponentPosition();

    public void drawPage(int mouseX, int mouseY) {
        this.getCurrentPageComponents().forEach(component -> {
            component.draw(mouseX, mouseY);
        });
    }


    public void rangePage() {
        int index = 0;
        int page = 1;
        for (Component paginationComponent : this.getPaginationComponents()) {
            paginationComponent.setPage(page);
            if (index >= this.componentsPerPage - 1) {
                page++;
                index = -1;
            }
            index++;
        }
        this.maxPage = page;
    }

    public void drawPageInformations(int x, int y) {
        String title = "(" + this.currentPage + "/" + this.maxPage + ")";
        new Text(x - (Minecraft.getMinecraft().fontRenderer.getStringWidth(title) / 2), y, title).draw(0,0);
    }

    public List<Component> getCurrentPageComponents() {
        List<Component> comp = new ArrayList<>();

        for (Component component : this.getComponents())
            if (component.getPage() == this.getCurrentPage())
                comp.add(component);

        return comp;
    }

}
