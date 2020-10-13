package me.liskoh.client.api.commands;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayerMP;

@Getter @Setter
public abstract class AbstractCommand {

    private String command;

    public AbstractCommand(String command) {
        this.command = command;
    }

    public abstract void perform(EntityClientPlayerMP sender, String command, String[] args);

}
