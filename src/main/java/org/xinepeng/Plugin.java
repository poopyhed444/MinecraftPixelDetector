package org.xinepeng;

import org.bukkit.plugin.java.JavaPlugin;
public class Plugin extends JavaPlugin{
  public void onEnable() {
    this.getCommand("skindetect").setExecutor(new SkinDetector());
    getLogger().info("SkinDetector has been enabled!");

    }
    public void onDisable() {
    getLogger().info("SkinDetector has been disabled!");

    }

}