// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelkunai_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "kunai_converted"), "main");
	private final ModelPart group2;
	private final ModelPart group3;
	private final ModelPart group;

	public Modelkunai_Converted(ModelPart root) {
		this.group2 = root.getChild("group2");
		this.group3 = this.group2.getChild("group3");
		this.group = this.group2.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group2 = partdefinition.addOrReplaceChild("group2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition group3 = group2.addOrReplaceChild("group3",
				CubeListBuilder.create().texOffs(0, 21)
						.addBox(-3.0F, -3.0F, 3.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 8)
						.addBox(-4.0F, -3.0F, 2.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -4.0F, 0.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 14)
						.addBox(-4.0F, -4.0F, -1.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 14)
						.addBox(-4.0F, -3.0F, -2.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 0)
						.addBox(-3.0F, -3.0F, -4.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(12, 19)
						.addBox(-3.0F, -2.0F, -5.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 23)
						.addBox(-2.0F, -2.0F, -7.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 5.0F, -1.0F));

		PartDefinition group = group2.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(0, 8)
						.addBox(-3.0F, -2.0F, 2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(22, 19)
						.addBox(-2.0F, -2.0F, 6.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 5.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		group2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}