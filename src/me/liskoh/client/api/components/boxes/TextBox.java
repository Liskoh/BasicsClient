package me.liskoh.client.api.components.boxes;

import joptsimple.internal.Strings;
import lombok.Getter;
import lombok.Setter;
import me.liskoh.client.api.components.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

@Getter
public class TextBox extends Component {

    private GuiTextField textField;
    private FontRenderer renderer;

    public TextBox(int x, int y, int width, int height) {
        super(x, y);
        this.renderer = Minecraft.getMinecraft().fontRenderer;
        this.textField = new GuiTextField(this.renderer, this.getX(), this.getY(), width, height);
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        this.drawTextBox();
    }

    public TextBox setDefaultText(String text) {
        this.textField.setText(text);
        return this;
    }

    public boolean textboxKeyTyped(char typedChar, int keyCode) {
        return this.textField.textboxKeyTyped(typedChar, keyCode);
    }

    public void drawTextBox() {
        String password = this.textField.getText();
        this.textField.drawUIBox();
        replaceText(password);
    }

    private void replaceText(String newText) {
        int cursorPosition = this.textField.func_146198_h();
        int selectionEnd = this.textField.func_146186_n();
        this.textField.setText(newText);
        this.textField.func_146190_e(cursorPosition);
        this.textField.func_146199_i(selectionEnd);
    }
}
