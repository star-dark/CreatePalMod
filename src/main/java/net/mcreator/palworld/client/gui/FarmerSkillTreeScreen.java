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

import net.mcreator.palworld.world.inventory.FarmerSkillTreeMenu;
import net.mcreator.palworld.procedures.ToghnessPointProcedure;
import net.mcreator.palworld.procedures.SweepDamagePointProcedure;
import net.mcreator.palworld.procedures.ShieldBoomberPointProcedure;
import net.mcreator.palworld.procedures.ScalePointProcedure;
import net.mcreator.palworld.procedures.ReflectionPointProcedure;
import net.mcreator.palworld.procedures.RecoverUpToolTipProcedure;
import net.mcreator.palworld.procedures.RecoverUpPointProcedure;
import net.mcreator.palworld.procedures.RangeUpToolTipProcedure;
import net.mcreator.palworld.procedures.RangeUpPointProcedure;
import net.mcreator.palworld.procedures.KnockBackResistancePointProcedure;
import net.mcreator.palworld.procedures.HealthUpPointProcedure;
import net.mcreator.palworld.procedures.FoodFighterPointProcedure;
import net.mcreator.palworld.procedures.DoubleJumpToolTipProcedure;
import net.mcreator.palworld.procedures.DoubleJumpPointProcedure;
import net.mcreator.palworld.procedures.DefenseUpPointProcedure;
import net.mcreator.palworld.procedures.CurrentSkillPointsProcedure;
import net.mcreator.palworld.procedures.AttackUpPointProcedure;
import net.mcreator.palworld.network.FarmerSkillTreeButtonMessage;

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
	ImageButton imagebutton_bangeoryeog;
	ImageButton imagebutton_ceryeogjaesaeng;
	ImageButton imagebutton_pupa;
	ImageButton imagebutton_bansa;
	ImageButton imagebutton_deobeuljeompeu;
	ImageButton imagebutton_swildeubumbeo;
	ImageButton imagebutton_keojyeora;
	ImageButton imagebutton_bangeogangdo;
	ImageButton imagebutton_neogbaegjeohang;
	ImageButton imagebutton_hwibsseulgi;

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

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 56 && mouseX < leftPos + 80 && mouseY > topPos + 56 && mouseY < topPos + 80)
			guiGraphics.renderTooltip(font, Component.literal(RangeUpToolTipProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 197 && mouseX < leftPos + 221 && mouseY > topPos + 56 && mouseY < topPos + 80)
			guiGraphics.renderTooltip(font, Component.literal(RecoverUpToolTipProcedure.execute(entity)), mouseX, mouseY);
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palworld.farmer_skill_tree.tooltip_gonggyeogryeog_1jeungga"), mouseX, mouseY);
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 88 && mouseY < topPos + 112)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palworld.farmer_skill_tree.tooltip_ceryeog_1jeungga"), mouseX, mouseY);
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 139 && mouseY < topPos + 163)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palworld.farmer_skill_tree.tooltip_bangeoryeog_1jeungga"), mouseX, mouseY);
		if (mouseX > leftPos + 197 && mouseX < leftPos + 221 && mouseY > topPos + 114 && mouseY < topPos + 138)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palworld.farmer_skill_tree.tooltip_eumsigseobcwisi_heubsuhoegdeug"), mouseX, mouseY);
		if (mouseX > leftPos + 149 && mouseX < leftPos + 173 && mouseY > topPos + 88 && mouseY < topPos + 112)
			guiGraphics.renderTooltip(font, Component.literal(DoubleJumpToolTipProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palworld:textures/screens/seukilteurigui.png"), this.leftPos + -13, this.topPos + 0, 0, 0, 330, 193, 330, 193);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_10lv"), 56, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_15lv"), 103, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_20lv"), 151, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_25lv"), 199, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_30lv"), 247, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_gonggyeogryeog_jeungga"), 17, 61, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_nameun_pointeu"), 212, 178, -12829636, false);
		guiGraphics.drawString(this.font,

				CurrentSkillPointsProcedure.execute(entity), 261, 178, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_10"), 24, 73, -12829636, false);
		guiGraphics.drawString(this.font,

				AttackUpPointProcedure.execute(entity), 10, 72, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_101"), 25, 120, -12829636, false);
		guiGraphics.drawString(this.font,

				HealthUpPointProcedure.execute(entity), 10, 121, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_ceryeogjeungga"), 14, 114, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_bangeoryeog"), 18, 164, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_102"), 25, 175, -12829636, false);
		guiGraphics.drawString(this.font,

				DefenseUpPointProcedure.execute(entity), 11, 174, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_sageorijeungga"), 54, 82, -1, false);
		guiGraphics.drawString(this.font,

				RangeUpPointProcedure.execute(entity), 55, 90, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_5"), -68, -23, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_103"), 65, 91, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_ceryeogjaesaeng"), 198, 80, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_51"), 209, 87, -12829636, false);
		guiGraphics.drawString(this.font,

				RecoverUpPointProcedure.execute(entity), 195, 86, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_pudeupaiteo"), 196, 139, -16776961, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_52"), 210, 148, -12829636, false);
		guiGraphics.drawString(this.font,

				FoodFighterPointProcedure.execute(entity), 196, 148, -16776961, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_54"), 256, 121, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_bansa"), 248, 114, -16776961, false);
		guiGraphics.drawString(this.font,

				ReflectionPointProcedure.execute(entity), 244, 120, -16776961, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_deobeuljeompeu"), 150, 112, -10092442, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_1"), 161, 121, -12829636, false);
		guiGraphics.drawString(this.font,

				DoubleJumpPointProcedure.execute(entity), 149, 121, -10092442, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_swildeubumbeo"), 245, 60, -13421569, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_55"), 256, 67, -12829636, false);
		guiGraphics.drawString(this.font,

				ShieldBoomberPointProcedure.execute(entity), 246, 66, -13421569, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_idongsogdo"), 56, 139, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_4"), 66, 145, -12829636, false);
		guiGraphics.drawString(this.font,

				ScalePointProcedure.execute(entity), 55, 144, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_bangeogangdo"), 103, 163, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_53"), 114, 172, -12829636, false);
		guiGraphics.drawString(this.font,

				ToghnessPointProcedure.execute(entity), 101, 170, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_neogbaegjeohang"), 103, 112, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_56"), 113, 119, -12829636, false);
		guiGraphics.drawString(this.font,

				KnockBackResistancePointProcedure.execute(entity), 102, 118, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_hwibsseulgi"), 106, 60, -1, false);
		guiGraphics.drawString(this.font,

				SweepDamagePointProcedure.execute(entity), 101, 66, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.farmer_skill_tree.label_57"), 114, 68, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_ceryeogjeungga = new ImageButton(this.leftPos + 12, this.topPos + 88, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/ceryeogjeungga.png"), ResourceLocation.parse("palworld:textures/screens/ceryeogjeungga.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(0, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_ceryeogjeungga", imagebutton_ceryeogjeungga);
		this.addRenderableWidget(imagebutton_ceryeogjeungga);
		imagebutton_rangeup = new ImageButton(this.leftPos + 55, this.topPos + 56, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/rangeup.png"), ResourceLocation.parse("palworld:textures/screens/rangeup.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(1, x, y, z));
				FarmerSkillTreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
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
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(2, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_gonggyeogryeog", imagebutton_gonggyeogryeog);
		this.addRenderableWidget(imagebutton_gonggyeogryeog);
		imagebutton_bangeoryeog = new ImageButton(this.leftPos + 12, this.topPos + 139, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/bangeoryeog.png"), ResourceLocation.parse("palworld:textures/screens/bangeoryeog.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(3, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_bangeoryeog", imagebutton_bangeoryeog);
		this.addRenderableWidget(imagebutton_bangeoryeog);
		imagebutton_ceryeogjaesaeng = new ImageButton(this.leftPos + 197, this.topPos + 56, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/ceryeogjaesaeng.png"), ResourceLocation.parse("palworld:textures/screens/ceryeogjaesaeng.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(4, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_ceryeogjaesaeng", imagebutton_ceryeogjaesaeng);
		this.addRenderableWidget(imagebutton_ceryeogjaesaeng);
		imagebutton_pupa = new ImageButton(this.leftPos + 196, this.topPos + 114, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/pupa.png"), ResourceLocation.parse("palworld:textures/screens/pupa.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(5, x, y, z));
				FarmerSkillTreeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_pupa", imagebutton_pupa);
		this.addRenderableWidget(imagebutton_pupa);
		imagebutton_bansa = new ImageButton(this.leftPos + 246, this.topPos + 88, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/bansa.png"), ResourceLocation.parse("palworld:textures/screens/bansa.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(6, x, y, z));
				FarmerSkillTreeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_bansa", imagebutton_bansa);
		this.addRenderableWidget(imagebutton_bansa);
		imagebutton_deobeuljeompeu = new ImageButton(this.leftPos + 149, this.topPos + 88, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/deobeuljeompeu.png"), ResourceLocation.parse("palworld:textures/screens/deobeuljeompeu.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(7, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_deobeuljeompeu", imagebutton_deobeuljeompeu);
		this.addRenderableWidget(imagebutton_deobeuljeompeu);
		imagebutton_swildeubumbeo = new ImageButton(this.leftPos + 244, this.topPos + 35, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/swildeubumbeo.png"), ResourceLocation.parse("palworld:textures/screens/swildeubumbeo.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(8, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_swildeubumbeo", imagebutton_swildeubumbeo);
		this.addRenderableWidget(imagebutton_swildeubumbeo);
		imagebutton_keojyeora = new ImageButton(this.leftPos + 55, this.topPos + 114, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/keojyeora.png"), ResourceLocation.parse("palworld:textures/screens/keojyeora.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(9, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_keojyeora", imagebutton_keojyeora);
		this.addRenderableWidget(imagebutton_keojyeora);
		imagebutton_bangeogangdo = new ImageButton(this.leftPos + 101, this.topPos + 139, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/bangeogangdo.png"), ResourceLocation.parse("palworld:textures/screens/bangeogangdo.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(10, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_bangeogangdo", imagebutton_bangeogangdo);
		this.addRenderableWidget(imagebutton_bangeogangdo);
		imagebutton_neogbaegjeohang = new ImageButton(this.leftPos + 101, this.topPos + 88, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/neogbaegjeohang.png"), ResourceLocation.parse("palworld:textures/screens/neogbaegjeohang.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(11, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_neogbaegjeohang", imagebutton_neogbaegjeohang);
		this.addRenderableWidget(imagebutton_neogbaegjeohang);
		imagebutton_hwibsseulgi = new ImageButton(this.leftPos + 101, this.topPos + 35, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/hwibsseulgi.png"), ResourceLocation.parse("palworld:textures/screens/hwibsseulgi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FarmerSkillTreeButtonMessage(12, x, y, z));
						FarmerSkillTreeButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_hwibsseulgi", imagebutton_hwibsseulgi);
		this.addRenderableWidget(imagebutton_hwibsseulgi);
	}
}
