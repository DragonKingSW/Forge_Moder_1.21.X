package se.linus.firstmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import se.linus.firstmod.FirstMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import se.linus.firstmod.item.custom.FlameWandItem;
import se.linus.firstmod.item.custom.FuelItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> SACRITE = ITEMS.register("sacrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SACRITE = ITEMS.register("raw_sacrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INFLAMITE = ITEMS.register("inflamite",
            () -> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.firstmod.inflamite"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
    public static final RegistryObject<Item> FLAME_WAND = ITEMS.register("flame_wand",
            () -> new FlameWandItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> FIREBARK = ITEMS.register("firebark",
            () -> new FuelItem(new Item.Properties(), 10));

    public static final RegistryObject<Item> SACRITE_SWORD =ITEMS.register("sacrite_sword",
            () -> new SwordItem(ModToolTiers.SACRITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.SACRITE,3,-2.4f))));
    public static final RegistryObject<Item> SACRITE_PICKAXE =ITEMS.register("sacrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SACRITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SACRITE,1,-2.8f))));
    public static final RegistryObject<Item> SACRITE_SHOVEL =ITEMS.register("sacrite_shovel",
            () -> new ShovelItem(ModToolTiers.SACRITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.SACRITE,1.5f,-3.0f))));
    public static final RegistryObject<Item> SACRITE_AXE =ITEMS.register("sacrite_axe",
            () -> new AxeItem(ModToolTiers.SACRITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.SACRITE,6,-3.2f))));
    public static final RegistryObject<Item> SACRITE_HOE =ITEMS.register("sacrite_hoe",
            () -> new HoeItem(ModToolTiers.SACRITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.SACRITE,0,-3.0f))));

    public static final RegistryObject<Item> CHARRED_FLESH = ITEMS.register("charred_flesh",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHARRED_FLESH)));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
