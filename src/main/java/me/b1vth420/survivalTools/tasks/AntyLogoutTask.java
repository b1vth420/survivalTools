package me.b1vth420.survivalTools.tasks;

import me.b1vth420.survivalTools.managers.AntyLogoutManager;
import me.b1vth420.survivalTools.objects.Combat;
import me.b1vth420.survivalTools.utils.ChatUtil;
import me.b1vth420.survivalTools.utils.DataUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AntyLogoutTask implements Runnable {

    @Override
    public void run() {
        for(UUID uuid : AntyLogoutManager.getCombats().keySet()) {
            Combat c = AntyLogoutManager.getCombat(uuid);
            Player p = Bukkit.getPlayer(uuid);
            if(AntyLogoutManager.isInCombat(uuid)) {
                if(p != null)
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatUtil.chat("&cAntyLogout: " + DataUtil.secondsToString(c.getLastAttackTime()))));
            } else {
                if(p != null) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatUtil.chat("&aMozesz sie juz wylogowac!")));
                    AntyLogoutManager.removeCombat(uuid);
            }
                }
        }
    }
}