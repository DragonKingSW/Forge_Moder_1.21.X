package se.linus.firstmod.item;

import se.linus.firstmod.FirstMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import se.linus.firstmod.item.custom.FlameWandItem;
import se.linus.firstmod.item.custom.FuelItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);

    public static final RegistryObject<Item> SACRITE = ITEMS.register("sacrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SACRITE = ITEMS.register("raw_sacrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> INFLAMITE = ITEMS.register("inflamite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLAME_WAND = ITEMS.register("flame_wand",
            () -> new FlameWandItem(new Item.Properties().durability(32)));
    public static final RegistryObject<Item> FIREBARK = ITEMS.register("firebark",
            () -> new FuelItem(new Item.Properties(), 10));

    public static final RegistryObject<Item> CHARRED_FLESH = ITEMS.register("charred_flesh",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CHARRED_FLESH)));

    public static void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
