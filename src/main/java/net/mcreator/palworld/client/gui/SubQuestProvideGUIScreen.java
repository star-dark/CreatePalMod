package net.mcreator.palworld.client.gui;

public class SubQuestProvideGUIScreen extends AbstractContainerScreen<SubQuestProvideGUIMenu> {

	private final static HashMap<String, Object> guistate = SubQuestProvideGUIMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_surag;
	Button button_geojeol;
	Button button_dadgi;
	Button button_bosanghoegdeug;

	public SubQuestProvideGUIScreen(SubQuestProvideGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 122;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/sub_quest_provide_gui.png");

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

		if (

		IsNotMainQuestCompleteProcedure.execute(entity)

		) {
			guiGraphics.blit(ResourceLocation.parse("palworld:textures/screens/bang.png"), this.leftPos + 18, this.topPos + 17, 0, 0, 16, 16, 16, 16);
		}
		if (

		IsMainQuestCompleteProcedure.execute(entity)

		) {
			guiGraphics.blit(ResourceLocation.parse("palworld:textures/screens/question.png"), this.leftPos + 18, this.topPos + 19, 0, 0, 16, 16, 16, 16);
		}

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
		guiGraphics.drawString(this.font,

				BringQuestContentsProcedure.execute(entity), 46, 22, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.sub_quest_provide_gui.label_bosang"), 33, 45, -12829636, false);
		guiGraphics.drawString(this.font,

				BringQuestRewardProcedure.execute(entity), 66, 46, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		button_surag = Button.builder(Component.translatable("gui.palworld.sub_quest_provide_gui.button_surag"), e -> {
			if (

			AcceptApearProcedure.execute(entity)

			) {
				PacketDistributor.sendToServer(new SubQuestProvideGUIButtonMessage(0, x, y, z));
				SubQuestProvideGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 82, 35, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible =

						AcceptApearProcedure.execute(entity)

				;
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});

		guistate.put("button:button_surag", button_surag);
		this.addRenderableWidget(button_surag);

		button_geojeol = Button.builder(Component.translatable("gui.palworld.sub_quest_provide_gui.button_geojeol"), e -> {
			if (

			AcceptApearProcedure.execute(entity)

			) {
				PacketDistributor.sendToServer(new SubQuestProvideGUIButtonMessage(1, x, y, z));
				SubQuestProvideGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 82, 35, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible =

						AcceptApearProcedure.execute(entity)

				;
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});

		guistate.put("button:button_geojeol", button_geojeol);
		this.addRenderableWidget(button_geojeol);

		button_dadgi = Button.builder(Component.translatable("gui.palworld.sub_quest_provide_gui.button_dadgi"), e -> {
			if (

			QuestTapCloseButtonAppearProcedure.execute(entity)

			) {
				PacketDistributor.sendToServer(new SubQuestProvideGUIButtonMessage(2, x, y, z));
				SubQuestProvideGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 82, 103, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible =

						QuestTapCloseButtonAppearProcedure.execute(entity)

				;
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});

		guistate.put("button:button_dadgi", button_dadgi);
		this.addRenderableWidget(button_dadgi);

		button_bosanghoegdeug = Button.builder(Component.translatable("gui.palworld.sub_quest_provide_gui.button_bosanghoegdeug"), e -> {
			if (

			RewardButtonAppearProcedure.execute(entity)

			) {
				PacketDistributor.sendToServer(new SubQuestProvideGUIButtonMessage(3, x, y, z));
				SubQuestProvideGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 36, this.topPos + 82, 103, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible =

						RewardButtonAppearProcedure.execute(entity)

				;
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});

		guistate.put("button:button_bosanghoegdeug", button_bosanghoegdeug);
		this.addRenderableWidget(button_bosanghoegdeug);

	}

}
