package godsfall.items;

import godsfall.main.Tags;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items extends Item {

    @SideOnly(Side.CLIENT)
    protected IIcon[] texture;
    private String tex;
    private String[] textureNames;
    private String Name;
    private List<String> tooltips = new ArrayList<>();

    public Items(String name, CreativeTabs Tab){
        this.setUnlocalizedName(name);
        this.setCreativeTab(Tab);
        this.tex = name;
        this.Name = name;
    }

    public Items(String name, CreativeTabs Tab, String[] textures){
        this.setUnlocalizedName(name);
        this.setCreativeTab(Tab);
        this.setHasSubtypes(true);
        this.textureNames = textures;
        this.Name = name;
    }

    public Items(String name, String tooltip, CreativeTabs Tab) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(Tab);
        this.tex = name;
        this.tooltips.add(tooltip);
        this.Name = name;
    }

    public Items(String name, String[] tooltip, CreativeTabs Tab) {
        this.setUnlocalizedName(name);
        this.setCreativeTab(Tab);
        this.tex = name;
        this.tooltips = Arrays.asList(tooltip);
        this.Name = name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        if (this.texture == null || this.texture.length < 1) {
            return this.itemIcon;
        }
        else {
            return meta < this.texture.length ? this.texture[meta] : this.texture[0];
        }
    }

    @Override
    public int getMetadata(int aMeta) {
        return aMeta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        if (this.textureNames == null || this.textureNames.length < 1) {
            this.itemIcon = iconRegister.registerIcon(Tags.MODID + ":" + this.tex);
        }
        else {
            this.texture = new IIcon[this.textureNames.length];
            for (int i = 0; i < this.textureNames.length; ++i) {
                this.texture[i] = iconRegister.registerIcon(this.textureNames[i]);
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack p_77667_1_) {
        if (this.textureNames == null || this.textureNames.length < 1){
            return "item." + this.Name;
        }
        else {
            return "item." + this.Name + "." + p_77667_1_.getItemDamage();
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("unchecked")
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        if (this.texture == null || this.texture.length < 1) {
            list.add(new ItemStack(item, 1, 0));
        }
        else {
            for (int i = 0; i < this.texture.length; ++i) {
                list.add(new ItemStack(item, 1, i));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings({"unchecked"})
    public void addInformation(ItemStack p_94086_1_, EntityPlayer p_94086_2_, List p_94086_3_, boolean p_94086_4_) {
        if (tooltips.size() > 0) {
            p_94086_3_.addAll(tooltips);
        }
    }

}
