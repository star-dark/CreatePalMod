
package net.mcreator.palworld.client.renderer;

public class PigRenderer extends MobRenderer<PigEntity, PigModel<PigEntity>> {

	public PigRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel(context.bakeLayer(ModelLayers.PIG)), 0.5f);

		this.addLayer(new RenderLayer<PigEntity, PigModel<PigEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("palworld:textures/entities/pig.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, PigEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PigEntity entity) {
		return ResourceLocation.parse("palworld:textures/entities/pig.png");
	}

}
