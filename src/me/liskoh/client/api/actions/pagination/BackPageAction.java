package me.liskoh.client.api.actions.pagination;

import me.liskoh.client.api.actions.types.ClickAction;
import me.liskoh.client.api.uis.PaginationUI;

public class BackPageAction extends ClickAction {

    private PaginationUI ui;

    public BackPageAction(PaginationUI ui) {
        this.ui = ui;
    }

    @Override
    public void call() {
        if (ui.getCurrentPage() > 1)
            ui.setCurrentPage(ui.getCurrentPage() - 1);
    }
}
