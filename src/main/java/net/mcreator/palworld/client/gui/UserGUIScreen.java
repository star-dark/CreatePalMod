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
	ImageButton imagebutton_money_tapon;
	ImageButton imagebutton_quest_tap_on;
	ImageButton imagebutton_skilltree;

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.user_gui.label_kweseuteu"), 32, 84, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.user_gui.label_don"), 89, 84, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.user_gui.label_seukilteuri"), 131, 84, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_money_tapon = new ImageButton(this.leftPos + 75, this.topPos + 43, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/money_tapon.png"), ResourceLocation.parse("palworld:textures/screens/money_tapon2.png")), e -> {
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
		guistate.put("button:imagebutton_money_tapon", imagebutton_money_tapon);
		this.addRenderableWidget(imagebutton_money_tapon);
		imagebutton_quest_tap_on = new ImageButton(this.leftPos + 23, this.topPos + 43, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/quest_tap_on.png"), ResourceLocation.parse("palworld:textures/screens/quest_tapon2.png")), e -> {
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
		guistate.put("button:imagebutton_quest_tap_on", imagebutton_quest_tap_on);
		this.addRenderableWidget(imagebutton_quest_tap_on);
		imagebutton_skilltree = new ImageButton(this.leftPos + 126, this.topPos + 43, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/skilltree.png"), ResourceLocation.parse("palworld:textures/screens/skilltreetapon.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_skilltree", imagebutton_skilltree);
		this.addRenderableWidget(imagebutton_skilltree);
	}
}
