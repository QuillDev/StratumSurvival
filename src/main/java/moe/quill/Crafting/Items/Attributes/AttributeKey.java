package moe.quill.Crafting.Items.Attributes;

import moe.quill.Utils.Annotations.Keyable;

@Keyable
public enum AttributeKey {

    /**
     * WEAPON SPECIFIC ATTRIBUTES
     */
    //Blunt Weapon Attributes
    BLUNT_WEAPON_CHAIN_ATTRIBUTE,
    BLUNT_WEAPON_CRIT_ATTRIBUTE,
    BLUNT_WEAPON_DAWNBLADE_ATTRIBUTE,
    BLUNT_WEAPON_DUSKBLADE_ATTRIBUTE,
    BLUNT_WEAPON_EVOKER_STRIKE_ATTRIBUTE,
    BLUNT_WEAPON_FEINT_ATTRIBUTE,
    BLUNT_WEAPON_FLAME_ATTRIBUTE,
    BLUNT_WEAPON_FLAT_DAMAGE_ATTRIBUTE,
    BLUNT_WEAPON_HOOK_ATTRIBUTE,
    BLUNT_WEAPON_LIFE_STEAL_ATTRIBUTE,
    BLUNT_WEAPON_PERCENT_DAMAGE_ATTRIBUTE,
    BLUNT_WEAPON_SPEED_STEAL_ATTRIBUTE,

    //Bow Weapon Attributes
    BOW_WEAPON_DAMAGE_ATTRIBUTE,

    /**
     * CATEGORY BASED ATTRIBUTES
     */
    //On Death Attributes
    ON_DEATH_DROP_DIAMOND_ATTRIBUTE,
    ON_DEATH_DROP_EMERALD_ATTRIBUTE,
    ON_DEATH_DROP_GOLD_ATTRIBUTE,
    ON_DEATH_DROP_IRON_ATTRIBUTE,
    ON_DEATH_LIFE_POOL_ATTRIBUTE,
    ON_DEATH_SPEED_POOL_ATTRIBUTE,
    ON_DEATH_STRENGTH_POOL_ATTRIBUTE,
    ON_DEATH_WHISPER_ATTRIBUTE,

    //Use Attributes
    USE_CLOAKING_ATTRIBUTE,
    USE_JUMP_BOOST_ATTRIBUTE,
    USE_SET_DAY_ATTRIBUTE,
    USE_SET_NIGHT_ATTRIBUTE,
    USE_SHADOW_DODGE_ATTRIBUTE,
    USE_SLOW_FIELD_ATTRIBUTE,
    /**
     * TOOL ATTRIBUTES
     */
    //Pickaxe Attrbutes
    PICKAXE_DOUBLE_DROP_ATTRIBUTE,
    PICKAXE_SHARD_MINER_ATTRIBUTE,
    PICKAXE_VEIN_MINER_ATTRIBUTE,


}