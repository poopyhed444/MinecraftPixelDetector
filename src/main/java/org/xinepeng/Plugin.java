package org.xinepeng;

import org.bukkit.plugin.java.JavaPlugin;
public class Plugin extends JavaPlugin {
  @Override

  public void onEnable() {
    this.getCommand("skindetect").setExecutor(new SkinDetector());
    getLogger().info("SkinDetector has been enabled!");

    }
  @Override

  public void onDisable() {
    getLogger().info("SkinDetector has been disabled!");

    }

}