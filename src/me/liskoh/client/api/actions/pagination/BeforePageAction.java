package me.liskoh.client.api.actions.pagination;

import me.liskoh.client.api.actions.types.ClickAction;
import me.liskoh.client.api.uis.PageUI;

public class BeforePageAction extends ClickAction {

    private PageUI ui;

    public BeforePageAction(PageUI ui) {
        this.ui = ui;
    }

    @Override
    public void call() {
        if (ui.getCurrentPage() > 1)
            ui.setCurrentPage(ui.getCurrentPage() - 1);
    }
}
