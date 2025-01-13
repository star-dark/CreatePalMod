package net.mcreator.palworld.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.palworld.world.inventory.FarmerSkillTreeMenu;
import net.mcreator.palworld.procedures.CurrentSkillPointsProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FarmerSkillTreeScreen extends AbstractContainerScreen<FarmerSkillTreeMenu> {
	private final static HashMap<String, Object> guistate = FarmerSkillTreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_ceryeogjeungga;
	ImageButton imagebutton_rangeup;
	ImageButton imagebutton_gonggyeogryeog;

	public FarmerSkillTreeScreen(FarmerSkillTreeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 292;
		this.imageHeight = 194;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/farmer_skill_tree.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_5lv"), 15, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_10lv"), 56, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_15lv"), 103, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_20lv"), 151, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_25lv"), 199, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_30lv"), 247, 10, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_gonggyeogryeog_jeungga"), 10, 62, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_nameun_pointeu"), 219, 177, -12829636, false);
		guiGraphics.drawString(this.font,

				CurrentSkillPointsProcedure.execute(entity), 262, 177, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_ceryeogjeungga = new ImageButton(this.leftPos + 12, this.topPos + 91, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/ceryeogjeungga.png"), ResourceLocation.parse("palworld:textures/screens/ceryeogjeungga.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_ceryeogjeungga", imagebutton_ceryeogjeungga);
		this.addRenderableWidget(imagebutton_ceryeogjeungga);
		imagebutton_rangeup = new ImageButton(this.leftPos + 102, this.topPos + 64, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/rangeup.png"), ResourceLocation.parse("palworld:textures/screens/rangeup.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_rangeup", imagebutton_rangeup);
		this.addRenderableWidget(imagebutton_rangeup);
		imagebutton_gonggyeogryeog = new ImageButton(this.leftPos + 12, this.topPos + 35, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/gonggyeogryeog.png"), ResourceLocation.parse("palworld:textures/screens/gonggyeogryeog.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_gonggyeogryeog", imagebutton_gonggyeogryeog);
		this.addRenderableWidget(imagebutton_gonggyeogryeog);
	}
}
