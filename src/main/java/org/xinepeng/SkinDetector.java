package org.xinepeng;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

import static org.xinepeng.OpenCV.ColorDetector;
import static org.xinepeng.SkinRequest.UUIDGrabber;
public class SkinDetector implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.isOp()) {
            try {
                commandSender.sendMessage(ColorDetector(UUIDGrabber(strings[0])));
                return true;
            } catch (IOException e) {
                commandSender.sendMessage("§c§l[SkinDetector] §c§lError: §c§l" + e.getMessage());

            }


        }
        return false;

    }
}
