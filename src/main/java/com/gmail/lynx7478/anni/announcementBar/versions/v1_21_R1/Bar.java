package com.gmail.lynx7478.anni.announcementBar.versions.v1_21_R1;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class Bar implements com.gmail.lynx7478.anni.announcementBar.Bar
{
    @Override
    public void sendToPlayer(final Player player, final String message, final float percentOfTotal)
    {
        // LOL it's one line now!
        //TODO: Make colour and formatting customisable.
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(cleanMessage(ChatColor.GOLD+message)));
    }

    private static String cleanMessage(String message)
    {
        if (message.length() > 64)
            message = message.substring(0, 63);

        return message;
    }
}
