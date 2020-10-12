package me.liskoh.client.api.uis;

import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.ComponentPriority;
import me.liskoh.client.api.components.ResourcePath;
import me.liskoh.client.api.components.buttons.HoveredButton;
import me.liskoh.client.example.uis.auctions.actions.AuctionSellAction;
import org.lwjgl.input.Keyboard;

public class ExamplePageUI extends PageUI {


    public ExamplePageUI() {
        super(6);
    }

    @Override
    public void createUI() {
        System.out.println("----------------------");
        for (int i = 0; i <= 12; i++) {
            HoveredButton button = new HoveredButton(0, 0);
            button.setSize(1658 / 15, 558 / 15);
            button.setResource(ResourcePath.AUCTION_CONFIRM_BUTTON);
            button.setPriority(ComponentPriority.BUTTON);
            button.addAction(new AuctionSellAction());
            button.setVisible(true);
            button.setPagination(true);
            this.addComponent(button);
        }

        this.rangePage();
    }

    @Override
    public void setCurrentComponentPosition() {

        Component component = this.getCurrentPageComponents().get(this.getCurrentIndex());
        System.out.println(this.getCurrentIndex());

        int y = 0;
        int x = 0;

        int data = this.getCurrentIndex();

        if (data == 0 || data == 3) {
            y = 70;
        } else if (data == 1 || data == 4) {
            y = 15;
        } else if (data == 2 || data == 5) {
            y = -40;
        }

        if (data <= 2)
            x = 160;
        else
            x = 0;

        component.setX(this.getDividedWidth() / 2 - x);
        component.setY(this.getDividedHeight() / 2 - y);

        if (component instanceof HoveredButton) {

            HoveredButton button = (HoveredButton) component;

        }
    }

    @Override
    public void drawUI(int mouseX, int mouseY, float tick) {
        this.drawPage(mouseX, mouseY);
        this.getPageInformationText(this.getDividedWidth(), this.getDividedHeight()).draw(mouseX,mouseY);
    }


    @Override
    protected void onClick(int mouseX, int mouseY, int mouseButton) {

    }

    @Override
    protected void onKeyTiped(char c, int key) {
            if (key == Keyboard.KEY_E)
            {
                this.setCurrentPage(this.getCurrentPage() + 1);
            }
    }
}
