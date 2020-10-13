package me.liskoh.client.api.uis;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.ExampleClient;
import me.liskoh.client.api.actions.pagination.BackPageAction;
import me.liskoh.client.api.actions.pagination.NextPageAction;
import me.liskoh.client.api.actions.types.ClickAction;
import me.liskoh.client.api.components.Component;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class UI extends GuiScreen {

    private List<Component> components;
    private ExampleClient client;

    public UI() {
        this.components = new ArrayList<>();
        this.client = ExampleClient.getInstance();
        this.client.resetResolution();
    }

    public abstract void createUI();

    public abstract void drawUI(int mouseX, int mouseY, float tick);

    protected abstract void onClick(int mouseX, int mouseY, int mouseButton);

    protected abstract void onKeyTyped(char c, int key);

    @Override
    public void initGui() {
        this.client.resetResolution();
        this.components.clear();
        this.createUI();
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float tick) {

        this.drawDefaultBackground();

        this.components.forEach(component -> {
            if (component.isVisible() && !component.isPagination())
                component.draw(mouseX, mouseY);
            else if (component.isVisible() && !component.getOverlays().isEmpty())
                component.getOverlays().forEach(overlay -> {
                    if (overlay.isVisible() && overlay.isWithin(mouseX, mouseY))
                        overlay.draw(mouseX, mouseY);
                });
        });

        this.drawUI(mouseX, mouseY, tick);

        if (this instanceof PaginationUI) {
            PaginationUI page = (PaginationUI) this;
            page.getCurrentPageComponents().forEach(component -> {
                page.setCurrentComponentPosition();
                page.setCurrentIndex(page.getCurrentIndex() + 1);
            });
            page.setCurrentIndex(0);
            page.drawPage(mouseX, mouseY);
        }

        super.drawScreen(mouseX, mouseY, tick);
    }

    public List<Component> getPaginationComponents() {
        List<Component> comps = new ArrayList<>();

        for (Component component : this.components)
            if (component.isPagination())
                comps.add(component);
        return comps;
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        this.components.forEach(component -> {
            if (component.isVisible() && component.isWithin(mouseX, mouseY) && !component.getActions().isEmpty())
                component.getActions().forEach(action -> {
                    if (action instanceof ClickAction)
                        action.call();
                });
        });

        this.onClick(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char c, int key) {
        this.onKeyTyped(c, key);
        if (!(this instanceof Uncloseable))
            super.keyTyped(c, key);
    }

    @Override
    public void handleMouseInput() {

        if (!(this instanceof PaginationUI))
            return;

        PaginationUI page = (PaginationUI) this;
        int direction = Integer.signum(Mouse.getEventDWheel());

        if (direction == 1)
            new NextPageAction(page).call();
        else if (direction == -1)
            new BackPageAction(page).call();

        super.handleMouseInput();
    }

    public int getDividedWidth() {
        return this.client.getResolution().getScaledWidth() / 2;
    }

    public int getDividedHeight() {
        return this.client.getResolution().getScaledHeight() / 2;
    }

    public void drawComponents(int mouseX, int mouseY) {
        this.components.forEach(component -> component.draw(mouseX, mouseY));
    }

    public void addComponent(Component component) {
        if (!this.components.contains(component))
            this.components.add(component);
    }

    public ResourceLocation getResourceLocation(String path) {
        return new ResourceLocation(path);
    }

}
