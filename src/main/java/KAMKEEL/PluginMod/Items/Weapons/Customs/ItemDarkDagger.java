package KAMKEEL.PluginMod.Items.Weapons.Customs;

import KAMKEEL.PluginMod.Items.ItemTransform;
import KAMKEEL.PluginMod.Items.ModItems;
import KAMKEEL.PluginMod.Items.Weapons.ItemDagger;
import KAMKEEL.PluginMod.Items.Weapons.ItemReversable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDarkDagger extends ItemDagger implements ItemReversable, ItemTransform {

    private Item broke;
    private Item transformState;

    public ItemDarkDagger(int par1, ToolMaterial tool, Item broken) {
        super(par1, tool, broken);
        this.setMaxDamage(100000);
        this.setTransformItem(ModItems.DarkDaggerEnergized);
    }

    public ItemDarkDagger(int par1, ToolMaterial tool, Item broken, Item transform) {
        super(par1, tool, broken);
        this.setMaxDamage(100000);
        this.setTransformItem(transform);
    }

    @Override
    public boolean hitEntity(ItemStack item, EntityLivingBase entity, EntityLivingBase player)
    {
        if (player instanceof EntityPlayer){
            //The Entity Is A Player.
            EntityPlayer theplay = (EntityPlayer) player;
            item.damageItem(1, player);
            double maxDmgAllow = item.getMaxDamage() * 0.99975;
            if(item.getItemDamage() >= maxDmgAllow){
                int slot = theplay.inventory.currentItem;
                ItemStack stack = new ItemStack(broke, 1);
                stack.setTagCompound(item.getTagCompound());
                theplay.inventory.setInventorySlotContents(slot, stack);
            }
        }
        return true;
    }

    @Override
    public Item getTransformItem() {
        return transformState;
    }

    @Override
    public void setTransformItem(Item item) {
        transformState = item;
    }
}