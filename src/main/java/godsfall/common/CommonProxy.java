package godsfall.common;

import godsfall.main.Config;
import godsfall.main.Tags;
import cpw.mods.fml.common.event.*;
import godsfall.main.GodsFall;

public class CommonProxy {

    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event) {
        Config.syncronizeConfiguration(event.getSuggestedConfigurationFile());

        GodsFall.info(Config.greeting);
        GodsFall.info("I am " + Tags.MODNAME + " at version " + Tags.VERSION + " and group name " + Tags.GROUPNAME);
    }

    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void init(FMLInitializationEvent event) {

    }

    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event) {

    }

    public void serverAboutToStart(FMLServerAboutToStartEvent event) {

    }

    // register server commands in this event handler
    public void serverStarting(FMLServerStartingEvent event) {

    }

    public void serverStarted(FMLServerStartedEvent event) {

    }

    public void serverStopping(FMLServerStoppingEvent event) {

    }

    public void serverStopped(FMLServerStoppedEvent event) {

    }
}
