package me.liskoh.client.api.components;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.actions.Action;
import me.liskoh.client.api.components.overlays.Overlay;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public abstract class Component {

    private int x;
    private int y;
    private int height;
    private int width;
    private boolean visible;
    private List<Action> actions;
    private List<Overlay> overlays;
    private ResourceLocation resource;
    private ComponentPriority priority;

    public Component(int x, int y){
        this.x = x;
        this.y = y;
        this.visible = true;
        this.priority = ComponentPriority.DEFAULT;
        this.actions = new ArrayList<>();
        this.overlays = new ArrayList<>();
    }

    public Component setResource(ResourcePath path) {
        this.resource = path.getResource();
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
        if(!this.actions.contains(action))
            this.actions.add(action);
        return this;
    }

    public Component addOverlay(Overlay overlay) {
        if(!this.overlays.contains(overlay))
            this.overlays.add(overlay);
        return this;
    }

    public Component setVisible(boolean b, List<Component> list) {
        this.visible = b;
        if(!list.contains(this))
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
