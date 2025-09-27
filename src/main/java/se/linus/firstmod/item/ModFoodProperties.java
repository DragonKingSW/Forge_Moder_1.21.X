package se.linus.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CHARRED_FLESH = new FoodProperties.Builder().nutrition(1).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 1000), 0.20f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000), 0.20f).fast().build();
}
