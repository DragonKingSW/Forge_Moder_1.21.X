package se.linus.firstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import se.linus.firstmod.FirstMod;
import se.linus.firstmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FIRST_MOD_TAB = CREATIVE_MODE_TABS.register("first_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SACRITE.get()))
                    .title(Component.translatable("creativetab.firstmod"))
                    .displayItems((itemDisplayParameters, output) -> {
                       output.accept(ModItems.SACRITE.get());
                       output.accept(ModItems.RAW_SACRITE.get());

                       output.accept(ModItems.INFLAMITE.get());
                       output.accept(ModItems.FLAME_WAND.get());
                       output.accept(ModItems.FIREBARK.get());

                       output.accept(ModBlocks.SACRITE_BLOCK.get());
                       output.accept(ModBlocks.SACRITE_ORE.get());
                       output.accept(ModBlocks.DEEPSLATE_SACRITE_ORE.get());

                       output.accept(ModBlocks.INFLAMITE_ORE.get());
                       output.accept(ModBlocks.DEEPSLATE_INFLAMITE_ORE.get());
                       output.accept(ModBlocks.FIREBARK_BLOCK.get());

                       output.accept(ModBlocks.CHARSTONE.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
