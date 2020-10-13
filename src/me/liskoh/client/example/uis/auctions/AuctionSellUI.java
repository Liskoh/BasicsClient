package me.liskoh.client.example.uis.auctions;

import lombok.Getter;
import me.liskoh.client.api.components.ComponentPriority;
import me.liskoh.client.api.resources.ResourcePath;
import me.liskoh.client.api.components.backgrounds.TexturedBackground;
import me.liskoh.client.api.components.boxes.TextBox;
import me.liskoh.client.api.components.buttons.HoveredButton;
import me.liskoh.client.api.components.items.ItemStackComponent;
import me.liskoh.client.api.components.texts.Text;
import me.liskoh.client.api.uis.UI;
import me.liskoh.client.example.actions.CloseUIAction;
import me.liskoh.client.example.uis.auctions.actions.AuctionSellAction;
import net.minecraft.item.ItemStack;

@Getter
public class AuctionSellUI extends UI {

    private ItemStack stack;
    private TextBox box;

    public AuctionSellUI(ItemStack stack) {
        this.stack = stack;
    }

    @Override
    public void createUI() {

        TexturedBackground background = new TexturedBackground(this.getDividedWidth() - 250, this.getDividedHeight() - 150);
        background.setSize(1450 / 3, 709 / 3);
        background.setResource(ResourcePath.AUCTION_BACKGROUND);
        background.setPriority(ComponentPriority.BACKGROUND);
        background.setVisible(true);
        this.addComponent(background);

        HoveredButton confirmButton = new HoveredButton(this.getDividedWidth() - 200, this.getDividedHeight() + 60);
        confirmButton.setSize(1658 / 15, 558 / 15);
        confirmButton.setResource(ResourcePath.AUCTION_CONFIRM_BUTTON);
        confirmButton.setPriority(ComponentPriority.BUTTON);
        confirmButton.addAction(new AuctionSellAction());
//        confirmButton.setText("�cCONFIRMER",1.0F);
//        confirmButton.getText().setHoverText("�cCONFIRMER");
        confirmButton.setVisible(true);
        this.addComponent(confirmButton);

        HoveredButton denyButton = new HoveredButton(this.getDividedWidth() + 70, this.getDividedHeight() + 60);
        denyButton.setSize(1658 / 15, 558 / 15);
        denyButton.setResource(ResourcePath.AUCTION_DENY_BUTTON);
        denyButton.setPriority(ComponentPriority.BUTTON);
        denyButton.addAction(new CloseUIAction());
        denyButton.setVisible(true);
        this.addComponent(denyButton);


        TexturedBackground slot = new TexturedBackground(this.getDividedWidth() - 210, this.getDividedHeight() - 70);
        slot.setSize(1269 / 10, 1268 / 10);
        slot.setResource(ResourcePath.AUCTION_SLOT);
        slot.setPriority(ComponentPriority.BACKGROUND);
        slot.setVisible(true);
        this.addComponent(slot);

        ItemStackComponent item = new ItemStackComponent(this.getDividedWidth() - 172, this.getDividedHeight() - 30);
        item.setItem(this.stack);
        item.setScale(3.0F);
        item.setVisible(true);
        this.addComponent(item);

        TexturedBackground priceSlot = new TexturedBackground(this.getDividedWidth() - 60, this.getDividedHeight() - 38);
        priceSlot.setSize(3536 / 15, 936 / 15);
        priceSlot.setResource(ResourcePath.AUCTION_PRICE_SLOT);
        priceSlot.setPriority(ComponentPriority.BACKGROUND);
        priceSlot.setVisible(true);
        this.addComponent(priceSlot);

        this.box = new TextBox(this.getDividedWidth() - 45, this.getDividedHeight() - 17, 200, 20);
        this.box.setScale(1.0F);
        this.box.setSize(200, 300);
        this.box.setDefaultText("50");
        this.box.setVisible(true);
    }

    @Override
    public void drawUI(int mouseX, int mouseY, float tick) {
        this.box.draw(mouseX, mouseY);
        Text text = new Text(this.getDividedWidth() + 300 ,this.getDividedHeight() , "HELLO WORLD");
        text.setScale(3.0F);
        text.draw(mouseX,mouseY);
    }

    @Override
    protected void onClick(int mouseX, int mouseY, int mouseButton) {
         this.box.getTextField().mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void onKeyTyped(char c, int key) {
        this.box.getTextField().textboxKeyTyped(c, key);
    }
}
