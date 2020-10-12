package me.liskoh.client.api.uis;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.texts.Text;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class PageUI extends UI {

    private int currentPage;
    private int maxPage;
    private int componentsPerPage;
    private int currentIndex;


    public PageUI(int componentsPerPage) {
        ;
        this.currentPage = 1;
        this.componentsPerPage = componentsPerPage;
        this.currentIndex = 0;
    }

    public abstract void setCurrentComponentPosition();

    public void drawPage(int mouseX, int mouseY) {
        this.getCurrentPageComponents().forEach(component -> {
            component.draw(mouseX, mouseY);
            Text text = new Text(component.getX(), component.getY(), "Hey " + component.getIndex() + " page " + component.getPage());
            text.draw(mouseX, mouseY);
        });

    }

    public void rangePage() {
        int index = 0;
        int page = 1;
        for (Component paginationComponent : this.getPaginationComponents()) {
            paginationComponent.setIndex(index);
            paginationComponent.setPage(page);
            if (index >= this.componentsPerPage - 1) {
                page++;
                index = 0;
            }
            index++;
        }
        this.maxPage = page;
        System.out.println("max " + maxPage);
    }

    public Text getPageInformationText(int x, int y) {
        return new Text(x, y, "Page (" + this.currentPage + "/" + this.maxPage + ")");
    }

    public List<Component> getCurrentPageComponents() {
        List<Component> comp = new ArrayList<>();

        for (Component component : this.getComponents())
            if (component.getPage() == this.getCurrentPage())
                comp.add(component);

        return comp;
    }


}


/*



 */