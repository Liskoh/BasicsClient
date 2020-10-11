package me.liskoh.client.api.components;

import lombok.Getter;
import net.minecraft.util.ResourceLocation;

@Getter
public enum ResourcePath {

    AUCTION_BACKGROUND("uis/auctions/background.png"),
    AUCTION_CONFIRM_BUTTON("uis/auctions/accept.png"),
    AUCTION_DENY_BUTTON("uis/auctions/deny.png"),
    AUCTION_CLOSE_BUTTON("uis/auctions/close.png"),
    AUCTION_SLOT("uis/auctions/slot.png"),
    AUCTION_PRICE_SLOT("uis/auctions/price.png"),

    ;

    private String path;

    ResourcePath(String path) {
        this.path = path;
    }

    public ResourceLocation getResource() {
        return new ResourceLocation(this.path);
    }

}
