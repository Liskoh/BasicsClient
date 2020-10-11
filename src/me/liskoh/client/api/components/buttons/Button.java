package me.liskoh.client.api.components.buttons;

import lombok.Getter;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.texts.Text;

@Getter
public abstract class Button extends Component {

    private Text text;

    public Button(int x, int y) {
        super(x, y);
    }

    public Component setText(String str, float scale) {
        this.text = new Text(getX(), getY(), 10, str);
        return this;
    }

}
