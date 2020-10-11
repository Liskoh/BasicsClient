package me.liskoh.client.api.components.overlays;

import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Overlay extends Component {

    private List <String> array;

    public Overlay(int x, int y) {
        super(x, y);
        this.array = new ArrayList <>();
    }

    public Overlay setText(List <String> text) {
        this.array = text;
        return this;
    }

}
