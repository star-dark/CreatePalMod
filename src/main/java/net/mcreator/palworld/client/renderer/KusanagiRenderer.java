package net.mcreator.palworld.client.renderer;

import com.mojang.math.Axis;

public class KusanagiRenderer extends EntityRenderer<KusanagiEntity> {

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/entities/kunai.png");

	private final Modelkunai_Converted model;

	public KusanagiRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelkunai_Converted(context.bakeLayer(Modelkunai_Converted.LAYER_LOCATION));
	}

	@Override
	public void render(KusanagiEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();

		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(KusanagiEntity entity) {
		return texture;
	}

}
