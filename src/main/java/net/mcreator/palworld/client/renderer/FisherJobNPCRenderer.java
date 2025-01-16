
package net.mcreator.palworld.client.renderer;

public class FisherJobNPCRenderer extends HumanoidMobRenderer<FisherJobNPCEntity, HumanoidModel<FisherJobNPCEntity>> {

	public FisherJobNPCRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(FisherJobNPCEntity entity) {
		return ResourceLocation.parse("palworld:textures/entities/fishertexture.png");
	}

}
