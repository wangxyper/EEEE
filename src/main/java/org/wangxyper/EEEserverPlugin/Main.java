package org.wangxyper.EEEserverPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.wangxyper.EEEserverPlugin.Commands.MNB;
import org.wangxyper.EEEserverPlugin.Commands.ReloadCommand;
import org.wangxyper.EEEserverPlugin.Listeners.BossBarListener;
import org.wangxyper.EEEserverPlugin.Listeners.PlayerListener;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        try{

            //装逼字幕
            this.getLogger().info(ChatColor.GREEN+" //////////////////////////////////////////////////////////////////////");
            this.getLogger().info(ChatColor.GREEN+" %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%%%");
            this.getLogger().info(ChatColor.GREEN+" %%         %%         %%         %%         %%         %%      %%");
            this.getLogger().info(ChatColor.GREEN+" %%         %%         %%         %%         %%         %%      %%");
            this.getLogger().info(ChatColor.GREEN+" %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%%%");
            this.getLogger().info(ChatColor.GREEN+" %%         %%         %%         %%               %%   %%");
            this.getLogger().info(ChatColor.GREEN+" %%         %%         %%         %%               %%   %%");
            this.getLogger().info(ChatColor.GREEN+" %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %% V1.1");
            this.getLogger().info(ChatColor.GREEN+" //////////////////////////////////////////////////////////////////////");
            //初始化
            this.saveDefaultConfig();
            Utils.getPLConfig = getConfig();
            Thread.sleep(3000);
            this.getLogger().info(ChatColor.LIGHT_PURPLE+"注册监听器......");
            Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
            Bukkit.getPluginManager().registerEvents(new BossBarListener(),this);
            this.getLogger().info(ChatColor.GREEN+"已注册");
            this.getLogger().info(ChatColor.LIGHT_PURPLE+"注册命令......");
            this.getCommand("reloadeeee").setExecutor(new ReloadCommand());
            this.getCommand("mnb").setExecutor(new MNB());
            this.getLogger().info(ChatColor.GREEN+"已注册");
            this.getLogger().info(ChatColor.LIGHT_PURPLE+"启用Boss栏为："+getConfig().getBoolean("EnableBossBar"));
            this.getLogger().info(ChatColor.LIGHT_PURPLE+"Boss栏更新时间："+getConfig().getBoolean("SleepTime"));
        }catch (Exception e){}
    }

    @Override
    public void onDisable() {
        //关闭时保存配置文件awa
      this.saveConfig();
    }

}
