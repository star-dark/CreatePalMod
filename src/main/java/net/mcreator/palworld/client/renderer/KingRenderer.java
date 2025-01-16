
package net.mcreator.palworld.client.renderer;

public class KingRenderer extends HumanoidMobRenderer<KingEntity, HumanoidModel<KingEntity>> {

	public KingRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

		this.addLayer(new RenderLayer<KingEntity, HumanoidModel<KingEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("palworld:textures/entities/king.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KingEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(KingEntity entity) {
		return ResourceLocation.parse("palworld:textures/entities/king.png");
	}

}
