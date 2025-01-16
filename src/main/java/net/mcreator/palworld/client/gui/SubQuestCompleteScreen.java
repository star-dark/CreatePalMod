package net.mcreator.palworld.client.gui;

public class SubQuestCompleteScreen extends AbstractContainerScreen<SubQuestCompleteMenu> {

	private final static HashMap<String, Object> guistate = SubQuestCompleteMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public SubQuestCompleteScreen(SubQuestCompleteMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 122;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/sub_quest_complete.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}

		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.sub_quest_complete.label_bosang"), 18, 44, -12829636, false);
		guiGraphics.drawString(this.font,

				CooltimeContentsProcedure.execute(entity), 69, 45, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

	}

}
