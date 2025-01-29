
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.palworld.item.SkyshatterItem;
import net.mcreator.palworld.item.MjolnirItem;
import net.mcreator.palworld.item.HeavenItem;
import net.mcreator.palworld.item.GloryGoldGhostItem;
import net.mcreator.palworld.item.DainsleifItem;
import net.mcreator.palworld.item.BurfSwordItem;
import net.mcreator.palworld.item.BangobuItem;
import net.mcreator.palworld.item.BalmungItem;
import net.mcreator.palworld.item.AvalonOfMerlinItem;
import net.mcreator.palworld.item.AstraBookItem;
import net.mcreator.palworld.item.AmanomurakumonotsurugiItem;
import net.mcreator.palworld.item.AegisItem;
import net.mcreator.palworld.PalworldMod;

public class PalworldModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PalworldMod.MODID);
	public static final DeferredItem<Item> BURF_SWORD = REGISTRY.register("burf_sword", BurfSwordItem::new);
	public static final DeferredItem<Item> SKYSHATTER = REGISTRY.register("skyshatter", SkyshatterItem::new);
	public static final DeferredItem<Item> MJOLNIR = REGISTRY.register("mjolnir", MjolnirItem::new);
	public static final DeferredItem<Item> DAINSLEIF = REGISTRY.register("dainsleif", DainsleifItem::new);
	public static final DeferredItem<Item> BALMUNG = REGISTRY.register("balmung", BalmungItem::new);
	public static final DeferredItem<Item> BANGOBU = REGISTRY.register("bangobu", BangobuItem::new);
	public static final DeferredItem<Item> AMANOMURAKUMONOTSURUGI = REGISTRY.register("amanomurakumonotsurugi", AmanomurakumonotsurugiItem::new);
	public static final DeferredItem<Item> AEGIS = REGISTRY.register("aegis", AegisItem::new);
	public static final DeferredItem<Item> GLORY_GOLD_GHOST = REGISTRY.register("glory_gold_ghost", GloryGoldGhostItem::new);
	public static final DeferredItem<Item> ASTRA_BOOK = REGISTRY.register("astra_book", AstraBookItem::new);
	public static final DeferredItem<Item> AVALON_OF_MERLIN = REGISTRY.register("avalon_of_merlin", AvalonOfMerlinItem::new);
	public static final DeferredItem<Item> HEAVEN = REGISTRY.register("heaven", HeavenItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
