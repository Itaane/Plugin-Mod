package KAMKEEL.PluginMod.Items.Weapons.Customs.Debug;

import KAMKEEL.PluginMod.Items.ItemCustomTransparent;
import KAMKEEL.PluginMod.Items.ModItems;
import KAMKEEL.PluginMod.Items.Weapons.ItemReversable;
import KAMKEEL.PluginMod.Items.Weapons.ItemWeaponBroken;
import net.minecraft.item.Item;
import org.lwjgl.opengl.GL11;

public class ItemDebugDaggerBroken extends ItemWeaponBroken implements ItemReversable, ItemCustomTransparent {

    public ItemDebugDaggerBroken(int par1, ToolMaterial tool) {
        super(par1, tool);
    }

    @Override
    public void renderSpecial() {
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(0.14F, 0.22f, 0.06f);
    }

    @Override
    public Item getReverseState() {
        return ModItems.DebugDaggerReversedBroken;
    }

    @Override
    public void setReverseState(Item item) {}
}

