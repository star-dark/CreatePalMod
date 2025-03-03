// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltiger<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "tiger"), "main");
	private final ModelPart legs;
	private final ModelPart left;
	private final ModelPart leftback;
	private final ModelPart right;
	private final ModelPart rightback;
	private final ModelPart tail;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart ears;
	private final ModelPart tail2;

	public Modeltiger(ModelPart root) {
		this.legs = root.getChild("legs");
		this.left = this.legs.getChild("left");
		this.leftback = this.legs.getChild("leftback");
		this.right = this.legs.getChild("right");
		this.rightback = this.legs.getChild("rightback");
		this.tail = root.getChild("tail");
		this.bone = root.getChild("bone");
		this.bone2 = this.bone.getChild("bone2");
		this.ears = this.bone.getChild("ears");
		this.tail2 = root.getChild("tail2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create(),
				PartPose.offset(2.5F, 18.5F, -7.5F));

		PartDefinition left = legs.addOrReplaceChild("left", CubeListBuilder.create().texOffs(29, 34).addBox(-2.0F,
				-11.0F, -1.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -4.5F, -0.5F));

		PartDefinition leftback = legs.addOrReplaceChild("leftback", CubeListBuilder.create().texOffs(0, 48)
				.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, -4.5F, 17.5F));

		PartDefinition right = legs.addOrReplaceChild("right",
				CubeListBuilder.create().texOffs(29, 34).mirror()
						.addBox(-1.0F, -21.0F, -1.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-7.5F, 5.5F, -0.5F));

		PartDefinition rightback = legs.addOrReplaceChild("rightback",
				CubeListBuilder.create().texOffs(0, 48).mirror()
						.addBox(-8.5F, -5.5F, 14.5F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(46, 34).addBox(
				-1.0F, -1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 4.0F, 14.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(43, 13)
						.addBox(8.0F, -27.0F, -19.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(5.0F, -29.0F, -10.0F, 10.0F, 11.0F, 22.0F, new CubeDeformation(0.0F)).texOffs(0, 34)
						.addBox(6.0F, -30.0F, -16.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-11.0F, 32.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(9, 15)
				.addBox(-5.0F, -11.0F, -31.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(9, 15).mirror()
				.addBox(5.0F, -11.0F, -31.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(9.0F, -18.0F, 16.0F));

		PartDefinition ears = bone.addOrReplaceChild("ears",
				CubeListBuilder.create().texOffs(0, 15).mirror()
						.addBox(1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 15).addBox(8.0F, -8.0F, 1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, -24.0F, -14.0F));

		PartDefinition tail2 = partdefinition.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(43, 0)
				.addBox(-1.6055F, -1.0F, -1.9391F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 12.0F, 15.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.left.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.rightback.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leftback.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}