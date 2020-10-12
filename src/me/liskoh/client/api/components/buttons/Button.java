package me.liskoh.client.api.components.buttons;

import lombok.Getter;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.texts.Text;

@Getter
public abstract class Button extends Component {

    private Text text;

    public Button(int x, int y) {
        super(x, y);
        this.text = null;
    }

    public Component setText(String str, float scale) {
        this.text = new Text((int) (getX() / scale), (int) (getY() / scale), str);
        this.text.setScale(scale);
        this.text.setSize(this.getWidth(), this.getHeight());

        this.text.setX(this.getX() + (this.getWidth() - this.text.getRenderer().getStringWidth(this.text.getText())) / 2);
        this.text.setY(this.getY() + (this.getHeight() - 8) / 2);
        return this;
    }

    public void drawText(int mouseX, int mouseY) {
        if (null == this.text)
            return;

        if (null == this.text.getHoverText()) {
            this.text.draw(mouseX, mouseY);
            return;
        }

        if (!isWithin(mouseX, mouseY))
            this.text.draw(mouseX, mouseY);
        else
            this.text.drawHover(mouseX, mouseY);
    }

}
