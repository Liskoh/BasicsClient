package me.liskoh.client.example.uis;

import me.liskoh.client.api.actions.pagination.BackPageAction;
import me.liskoh.client.api.actions.pagination.NextPageAction;
import me.liskoh.client.api.colors.HexaColor;
import me.liskoh.client.api.components.Component;
import me.liskoh.client.api.components.ComponentPriority;
import me.liskoh.client.api.resources.ResourcePath;
import me.liskoh.client.api.components.buttons.HoveredButton;
import me.liskoh.client.api.components.scrollbars.ColoredScrollBar;
import me.liskoh.client.api.components.scrollbars.ScrollBarDirection;
import me.liskoh.client.api.uis.PaginationUI;
import me.liskoh.client.example.uis.auctions.actions.AuctionSellAction;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ExamplePaginationUI extends PaginationUI {

    private ColoredScrollBar scrollbar;
    private int scroll;


    @Override
    public void createUI() {
//        System.out.println("----------------------");

        this.setComponentsPerPage(6);

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

        this.scrollbar = new ColoredScrollBar(this.getDividedWidth(), this.getDividedHeight());
        this.scrollbar.setSize(10, 30);
        this.scrollbar.setColor(HexaColor.BLUE);
        this.scrollbar.setVisible(true);
        this.addComponent(scrollbar);


        this.rangePage();
    }

    @Override
    public void setCurrentComponentPosition() {

        Component component = this.getCurrentPageComponents().get(this.getCurrentIndex());
//        System.out.println(this.getCurrentIndex());

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
//        this.getPageInformationText(this.getDividedWidth(), this.getDividedHeight()).draw(mouseX, mouseY);

        int direction = Mouse.getDWheel();

//        if (direction > 0) {
//            this.scrollbar.move(ScrollBarDirection.HIGH);
//        } else {
//            this.scrollbar.move(ScrollBarDirection.LOW);
//        }

        int yay = Mouse.getDWheel();


    }

    @Override
    public void handleMouseInput() {

//        int direction = Mouse.get
        int direction = Integer.signum(Mouse.getEventDWheel());
        if (direction == 1) {
            this.scrollbar.move(ScrollBarDirection.HIGH);
        } else if (direction == -1){
            this.scrollbar.move(ScrollBarDirection.LOW);
        }

        System.out.println(direction);



        super.handleMouseInput();
    }

    @Override
    protected void onClick(int mouseX, int mouseY, int mouseButton) {

    }

    @Override
    protected void onKeyTyped(char c, int key) {
        if (key == Keyboard.KEY_E) {
            new NextPageAction(this).call();
            this.scrollbar.move(ScrollBarDirection.HIGH);
        } else if (key == Keyboard.KEY_Q) {
            new BackPageAction(this).call();
            this.scrollbar.move(ScrollBarDirection.LOW);
        }
    }
}
