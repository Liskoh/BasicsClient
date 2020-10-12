package me.liskoh.client.api.uis;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;

@Getter
@Setter
public class PageComponent extends Component {

    private Component component;
    private int index;
    private int page;

    public PageComponent(Component component) {
        super(0, 0);
        this.component = component;
        this.page = 0;
        this.index = 0;
    }

    public PageComponent(int x, int y) {
        super(x, y);
        this.page = 0;
        this.index = 0;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        this.component.draw(mouseX, mouseY);
    }
}
