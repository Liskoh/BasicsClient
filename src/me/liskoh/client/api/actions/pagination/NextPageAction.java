package me.liskoh.client.api.actions.pagination;

import me.liskoh.client.api.actions.types.ClickAction;
import me.liskoh.client.api.uis.PageUI;

public class NextPageAction extends ClickAction {

    private PageUI ui;

    public NextPageAction(PageUI ui) {
        this.ui = ui;
    }

    @Override
    public void call() {
        if (ui.getCurrentPage() < ui.getMaxPage())
            ui.setCurrentPage(ui.getCurrentPage() + 1);
    }
}
