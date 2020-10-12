package me.liskoh.client.api.components.backgrounds;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.others.Render2DUtils;

@Getter @Setter
public class Background extends Component {

    public Background(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        Render2DUtils.renderImage(this.getResource(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), 1);

    }
}
