
package net.mcreator.palworld.client.renderer;

public class FarmerJobNPCRenderer extends HumanoidMobRenderer<FarmerJobNPCEntity, HumanoidModel<FarmerJobNPCEntity>> {

	public FarmerJobNPCRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

	}

	@Override
	public ResourceLocation getTextureLocation(FarmerJobNPCEntity entity) {
		return ResourceLocation.parse("palworld:textures/entities/farmertexture.png");
	}

}
