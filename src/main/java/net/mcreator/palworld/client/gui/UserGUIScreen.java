package net.mcreator.palworld.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.palworld.world.inventory.UserGUIMenu;
import net.mcreator.palworld.network.UserGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class UserGUIScreen extends AbstractContainerScreen<UserGUIMenu> {
	private final static HashMap<String, Object> guistate = UserGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_quest_tap;
	ImageButton imagebutton_money_tap;

	public UserGUIScreen(UserGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 143;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palworld:textures/screens/user_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.user_gui.label_kweseuteu"), 35, 92, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.user_gui.label_don"), 124, 91, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_quest_tap = new ImageButton(this.leftPos + 28, this.topPos + 58, 176, 143, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/quest_tap.png"), ResourceLocation.parse("palworld:textures/screens/quest_tap_on.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new UserGUIButtonMessage(0, x, y, z));
						UserGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_quest_tap", imagebutton_quest_tap);
		this.addRenderableWidget(imagebutton_quest_tap);
		imagebutton_money_tap = new ImageButton(this.leftPos + 110, this.topPos + 58, 176, 166, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/money_tap.png"), ResourceLocation.parse("palworld:textures/screens/money_tapon.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new UserGUIButtonMessage(1, x, y, z));
						UserGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_money_tap", imagebutton_money_tap);
		this.addRenderableWidget(imagebutton_money_tap);
	}
}
