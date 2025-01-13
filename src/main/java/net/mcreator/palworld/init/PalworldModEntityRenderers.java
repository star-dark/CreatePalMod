
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.palworld.client.renderer.QueenRenderer;
import net.mcreator.palworld.client.renderer.PigRenderer;
import net.mcreator.palworld.client.renderer.MinerJobNPCRenderer;
import net.mcreator.palworld.client.renderer.KingRenderer;
import net.mcreator.palworld.client.renderer.FisherJobNPCRenderer;
import net.mcreator.palworld.client.renderer.FarmerJobNPCRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PalworldModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PalworldModEntities.FARMER_JOB_NPC.get(), FarmerJobNPCRenderer::new);
		event.registerEntityRenderer(PalworldModEntities.MINER_JOB_NPC.get(), MinerJobNPCRenderer::new);
		event.registerEntityRenderer(PalworldModEntities.FISHER_JOB_NPC.get(), FisherJobNPCRenderer::new);
		event.registerEntityRenderer(PalworldModEntities.KING.get(), KingRenderer::new);
		event.registerEntityRenderer(PalworldModEntities.PIG.get(), PigRenderer::new);
		event.registerEntityRenderer(PalworldModEntities.QUEEN.get(), QueenRenderer::new);
	}
}
