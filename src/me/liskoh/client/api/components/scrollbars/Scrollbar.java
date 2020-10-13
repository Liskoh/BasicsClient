package me.liskoh.client.api.components.scrollbars;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;

@Getter
public abstract class Scrollbar extends Component {

    private int minusPosition;

    public Scrollbar(int x, int y) {
        super(x, y);
        this.minusPosition = x;
    }

    public Scrollbar setMinusPosition(int minus) {
        this.minusPosition = minus;
        return this;
    }


    public void move(ScrollBarDirection direction) {
        if (direction == ScrollBarDirection.HIGH)
            this.setY(this.getY() + 5);
        else
            this.setY(this.getY() - 5);
    }
}
