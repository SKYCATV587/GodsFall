package godsfall.main;

import godsfall.loader.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tabs extends CreativeTabs {
    public Tabs(String name){
        super(name);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }

}

