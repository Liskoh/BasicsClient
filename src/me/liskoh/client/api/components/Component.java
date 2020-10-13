package me.liskoh.client.api.components;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.actions.Action;
import me.liskoh.client.api.components.overlays.Overlay;
import me.liskoh.client.api.resources.ResourcePath;
import net.minecraft.util.ResourceLocation;

import static me.liskoh.client.api.colors.HexaColor.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Component {

    private int x;
    private int y;
    private int height;
    private int width;
    private int color;
    private boolean visible;
    private List<Action> actions;
    private List<Overlay> overlays;
    private ResourceLocation resource;
    private ResourceLocation hoverResource;
    private ComponentPriority priority;
    private boolean pagination;
    private int page;

    public Component(int x, int y) {
        this.x = x;
        this.y = y;
        this.visible = true;
        this.color = GREY;
        this.priority = ComponentPriority.DEFAULT;
        this.actions = new ArrayList<>();
        this.overlays = new ArrayList<>();
        this.pagination = false;
        this.page = 1;
    }

    public Component setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public Component setPagination(boolean pagination) {
        this.pagination = pagination;
        return this;
    }

    public Component setResource(ResourcePath path) {
        this.resource = path.getResource();
        return this;
    }

    public Component setHoverResource(ResourcePath path) {
        this.hoverResource = path.getResource();
        return this;
    }

    public Component setResources(ResourcePath path, ResourcePath hoverPath) {
        this.setResource(path);
        this.setHoverResource(hoverPath);
        return this;
    }

    public Component setSize(int width, int height) {
        this.height = height;
        this.width = width;
        return this;
    }

    public Component setPriority(ComponentPriority priority) {
        this.priority = priority;
        return this;
    }

    public Component addAction(Action action) {
        if (!this.actions.contains(action))
            this.actions.add(action);
        return this;
    }

    public Component addOverlay(Overlay overlay) {
        if (!this.overlays.contains(overlay))
            this.overlays.add(overlay);
        return this;
    }

    public Component setVisible(boolean b, List<Component> list) {
        this.visible = b;
        if (!list.contains(this))
            list.add(this);
        return this;
    }

    public Component setVisible(boolean b) {
        this.visible = b;
        return this;
    }

    public abstract void draw(int mouseX, int mouseY);

    public boolean isWithin(int mouseX, int mouseY) {
        return mouseX > this.x && mouseX < this.x + this.width && mouseY > this.y && mouseY < this.y + this.height;
    }

}
