package godsfall.items;

import godsfall.blocks.regularBlock.TEBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.util.GT_LanguageManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import godsfall.main.GodsFall;
import godsfall.main.Tags;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

import java.util.Arrays;
import java.util.List;

//import static goodgenerator.loader.Loaders.essentiaCell;
//import static goodgenerator.loader.Loaders.yottaFluidTankCell;
import static godsfall.main.CharExchanger.tierName;

public class ItemBlocks extends ItemBlock {
    private final String mNoMobsToolTip = GT_LanguageManager.addStringLocalization("gt.nomobspawnsonthisblock", "Mobs cannot Spawn on this Block");
    private final String mNoTileEntityToolTip = GT_LanguageManager.addStringLocalization("gt.notileentityinthisblock", "This is NOT a TileEntity!");


    public ItemBlocks(Block block){
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.setCreativeTab(godsfall.main.Tags.GF);
    }

    @Override
    public int getMetadata(int aMeta) {
        return aMeta;
    }

    @Override
    public String getUnlocalizedName(ItemStack aStack) {
        return this.field_150939_a.getUnlocalizedName() + "." + this.getDamage(aStack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int pass) {
        return this.field_150939_a.getIcon(0, stack.getItemDamage());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return this.getIcon(stack, renderPass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_) {
        return this.field_150939_a.getIcon(0, p_77618_2_);
    }


}
