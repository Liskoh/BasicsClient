package me.liskoh.client.api.resources;

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

    RANKING_BACKGROUND("uis/ranking/background.png"),
    RANKING_BRONZE_LOGO("uis/ranking/bronze.png"),
    RANKING_SILVER_LOGO("uis/ranking/silver.png"),
    RANKING_GOLD_LOGO("uis/ranking/gold.png"),
    RANKING_HEROS_LOGO("uis/ranking/heros.png"),
    RANKING_LEGENDARY_LOGO("uis/ranking/legendary.png"),
    RANKING_CHAMPION_LOGO("uis/ranking/champion.png"),
    RANKING_SLOT("uis/ranking/slot.png"),
    RANKING_SLOT_HOVER("uis/ranking/slot_hover.png"),
    BUTTON_CLOSE("uis/ranking/button_close.png"),
    BUTTON_LEFT("uis/ranking/button_left.png"),
    BUTTON_RIGHT("uis/ranking/button_right.png"),

    ;

    private String path;

    ResourcePath(String path) {
        this.path = path;
    }

    public ResourceLocation getResource() {
        return new ResourceLocation(this.path);
    }

}
