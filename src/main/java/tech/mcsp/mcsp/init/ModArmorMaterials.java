package tech.mcsp.mcsp.init;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * Простой материал брони для кастомного шлема.
 */
public enum ModArmorMaterials implements ArmorMaterial {
    AIRFRAME("airframe", new int[]{13, 15, 16, 11}, new int[]{1, 3, 4, 1}, 10, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F),
    OPSCORE2("opscore2", new int[]{481, 555, 592, 407}, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F);

    private final String name;
    private final int[] durabilityForType;
    private final int[] defenseForType;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;

    ModArmorMaterials(String name, int[] durabilityForType, int[] defenseForType, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance) {
        this.name = name;
        this.durabilityForType = durabilityForType;
        this.defenseForType = defenseForType;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return this.durabilityForType[type.ordinal()];
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.defenseForType[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

