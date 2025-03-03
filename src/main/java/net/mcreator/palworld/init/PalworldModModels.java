
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.palworld.client.model.Modeltiger;
import net.mcreator.palworld.client.model.Modelnasunhwan;
import net.mcreator.palworld.client.model.Modelkunai_Converted;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PalworldModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelnasunhwan.LAYER_LOCATION, Modelnasunhwan::createBodyLayer);
		event.registerLayerDefinition(Modelkunai_Converted.LAYER_LOCATION, Modelkunai_Converted::createBodyLayer);
		event.registerLayerDefinition(Modeltiger.LAYER_LOCATION, Modeltiger::createBodyLayer);
	}
}
