package me.liskoh.client.example.commands;

import me.liskoh.client.api.commands.AbstractCommand;
import net.minecraft.client.entity.EntityClientPlayerMP;

public class TestCommand extends AbstractCommand {

    public TestCommand(String command) {
        super(command);
    }

    @Override
    public void perform(EntityClientPlayerMP sender, String command, String[] args) {


        if(args.length < 1) {
            sender.sendChatMessage("The command is /test test");
            return;
        }

        if(args[0].equalsIgnoreCase("test")) {
            sender.sendChatMessage("Great!");
        }

    }
}
