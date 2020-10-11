package me.liskoh.client.api.commands;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;

@Getter @Setter
public abstract class BasicsCommand {

    private String command;

    public BasicsCommand(String command) {
        this.command = command;
    }

    public abstract void perform(EntityClientPlayerMP sender, String command, String[] args);

}
