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

import net.mcreator.palworld.world.inventory.FisherSkillTreeMenu;
import net.mcreator.palworld.procedures.TridentPointProcedure;
import net.mcreator.palworld.procedures.SpeedPointProcedure;
import net.mcreator.palworld.procedures.SnowmanPointProcedure;
import net.mcreator.palworld.procedures.NuclearPunchPointProcedure;
import net.mcreator.palworld.procedures.JumpPointProcedure;
import net.mcreator.palworld.procedures.InvisiblePointProcedure;
import net.mcreator.palworld.procedures.InvincivilityPointProcedure;
import net.mcreator.palworld.procedures.HoverPointProcedure;
import net.mcreator.palworld.procedures.HornPlayerPointProcedure;
import net.mcreator.palworld.procedures.HealthUpPointProcedure;
import net.mcreator.palworld.procedures.FishmanPointProcedure;
import net.mcreator.palworld.procedures.DefenseUpPointProcedure;
import net.mcreator.palworld.procedures.CurrentSkillPointsProcedure;
import net.mcreator.palworld.procedures.AttackUpPointProcedure;
import net.mcreator.palworld.procedures.ArcherPointProcedure;
import net.mcreator.palworld.network.FisherSkillTreeButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FisherSkillTreeScreen extends AbstractContainerScreen<FisherSkillTreeMenu> {
	private final static HashMap<String, Object> guistate = FisherSkillTreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_ceryeogjeungga;
	ImageButton imagebutton_gonggyeogryeog;
	ImageButton imagebutton_bangeoryeog;
	ImageButton imagebutton_eoin;
	ImageButton imagebutton_tumyeonghwa;
	ImageButton imagebutton_aceo;
	ImageButton imagebutton_hover;
	ImageButton imagebutton_isog;
	ImageButton imagebutton_jeompeuganghwa;
	ImageButton imagebutton_bbubumbbu;
	ImageButton imagebutton_samjicanggeuraeb;
	ImageButton imagebutton_nunsaram;
	ImageButton imagebutton_sasin;
	ImageButton imagebutton_haegpeonci;

	public FisherSkillTreeScreen(FisherSkillTreeMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 35 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palworld.fisher_skill_tree.tooltip_gonggyeogryeog_1jeungga"), mouseX, mouseY);
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 88 && mouseY < topPos + 112)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palworld.fisher_skill_tree.tooltip_ceryeog_1jeungga"), mouseX, mouseY);
		if (mouseX > leftPos + 13 && mouseX < leftPos + 37 && mouseY > topPos + 139 && mouseY < topPos + 163)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palworld.fisher_skill_tree.tooltip_bangeoryeog_1jeungga"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palworld:textures/screens/seukilteurigui.png"), this.leftPos + -13, this.topPos + -1, 0, 0, 330, 193, 330, 193);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_10lv"), 56, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_15lv"), 103, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_20lv"), 151, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_25lv"), 199, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_30lv"), 247, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_gonggyeogryeog_jeungga"), 17, 61, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_nameun_pointeu"), 212, 178, -12829636, false);
		guiGraphics.drawString(this.font,

				CurrentSkillPointsProcedure.execute(entity), 261, 178, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_10"), 24, 73, -12829636, false);
		guiGraphics.drawString(this.font,

				AttackUpPointProcedure.execute(entity), 10, 72, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_101"), 25, 120, -12829636, false);
		guiGraphics.drawString(this.font,

				HealthUpPointProcedure.execute(entity), 10, 121, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_ceryeogjeungga"), 14, 114, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_bangeoryeog"), 18, 164, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_102"), 25, 175, -12829636, false);
		guiGraphics.drawString(this.font,

				DefenseUpPointProcedure.execute(entity), 11, 174, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_sageorijeungga"), 58, 81, -1, false);
		guiGraphics.drawString(this.font,

				ArcherPointProcedure.execute(entity), 55, 90, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_5"), -68, -23, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_103"), 65, 91, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_ceryeogjaesaeng"), 198, 80, -16776961, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_51"), 209, 87, -12829636, false);
		guiGraphics.drawString(this.font,

				HornPlayerPointProcedure.execute(entity), 195, 86, -16776961, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_pudeupaiteo"), 196, 139, -16776961, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_52"), 210, 148, -12829636, false);
		guiGraphics.drawString(this.font,

				TridentPointProcedure.execute(entity), 196, 148, -16776961, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_54"), 256, 121, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_bansa"), 249, 114, -256, false);
		guiGraphics.drawString(this.font,

				InvincivilityPointProcedure.execute(entity), 244, 120, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_deobeuljeompeu"), 150, 112, -10092442, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_1"), 161, 121, -12829636, false);
		guiGraphics.drawString(this.font,

				HoverPointProcedure.execute(entity), 149, 121, -10092442, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_swildeubumbeo"), 247, 60, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_55"), 256, 67, -12829636, false);
		guiGraphics.drawString(this.font,

				NuclearPunchPointProcedure.execute(entity), 246, 66, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_idongsogdo"), 59, 138, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_4"), 66, 145, -12829636, false);
		guiGraphics.drawString(this.font,

				InvisiblePointProcedure.execute(entity), 55, 144, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_bangeogangdo"), 103, 163, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_53"), 114, 172, -12829636, false);
		guiGraphics.drawString(this.font,

				SpeedPointProcedure.execute(entity), 101, 170, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_neogbaegjeohang"), 103, 112, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_56"), 113, 119, -12829636, false);
		guiGraphics.drawString(this.font,

				FishmanPointProcedure.execute(entity), 102, 118, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_hwibsseulgi"), 105, 60, -1, false);
		guiGraphics.drawString(this.font,

				JumpPointProcedure.execute(entity), 101, 66, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_57"), 114, 68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_beoseokeo"), 248, 165, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palworld.fisher_skill_tree.label_58"), 256, 171, -12829636, false);
		guiGraphics.drawString(this.font,

				SnowmanPointProcedure.execute(entity), 242, 170, -256, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_ceryeogjeungga = new ImageButton(this.leftPos + 12, this.topPos + 88, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/ceryeogjeungga.png"), ResourceLocation.parse("palworld:textures/screens/ceryeogjeungga.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(0, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_ceryeogjeungga", imagebutton_ceryeogjeungga);
		this.addRenderableWidget(imagebutton_ceryeogjeungga);
		imagebutton_gonggyeogryeog = new ImageButton(this.leftPos + 12, this.topPos + 35, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/gonggyeogryeog.png"), ResourceLocation.parse("palworld:textures/screens/gonggyeogryeog.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(1, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(2, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_bangeoryeog", imagebutton_bangeoryeog);
		this.addRenderableWidget(imagebutton_bangeoryeog);
		imagebutton_eoin = new ImageButton(this.leftPos + 101, this.topPos + 88, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/eoin.png"), ResourceLocation.parse("palworld:textures/screens/eoin.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(3, x, y, z));
				FisherSkillTreeButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_eoin", imagebutton_eoin);
		this.addRenderableWidget(imagebutton_eoin);
		imagebutton_tumyeonghwa = new ImageButton(this.leftPos + 55, this.topPos + 114, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/tumyeonghwa.png"), ResourceLocation.parse("palworld:textures/screens/tumyeonghwa.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(4, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_tumyeonghwa", imagebutton_tumyeonghwa);
		this.addRenderableWidget(imagebutton_tumyeonghwa);
		imagebutton_aceo = new ImageButton(this.leftPos + 55, this.topPos + 56, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/aceo.png"), ResourceLocation.parse("palworld:textures/screens/aceo.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(5, x, y, z));
				FisherSkillTreeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_aceo", imagebutton_aceo);
		this.addRenderableWidget(imagebutton_aceo);
		imagebutton_hover = new ImageButton(this.leftPos + 149, this.topPos + 88, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/hover.png"), ResourceLocation.parse("palworld:textures/screens/hover.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(6, x, y, z));
				FisherSkillTreeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_hover", imagebutton_hover);
		this.addRenderableWidget(imagebutton_hover);
		imagebutton_isog = new ImageButton(this.leftPos + 101, this.topPos + 139, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/isog.png"), ResourceLocation.parse("palworld:textures/screens/isog.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(7, x, y, z));
				FisherSkillTreeButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_isog", imagebutton_isog);
		this.addRenderableWidget(imagebutton_isog);
		imagebutton_jeompeuganghwa = new ImageButton(this.leftPos + 101, this.topPos + 35, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/jeompeuganghwa.png"), ResourceLocation.parse("palworld:textures/screens/jeompeuganghwa.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(8, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_jeompeuganghwa", imagebutton_jeompeuganghwa);
		this.addRenderableWidget(imagebutton_jeompeuganghwa);
		imagebutton_bbubumbbu = new ImageButton(this.leftPos + 196, this.topPos + 56, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/bbubumbbu.png"), ResourceLocation.parse("palworld:textures/screens/bbubumbbu.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(9, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_bbubumbbu", imagebutton_bbubumbbu);
		this.addRenderableWidget(imagebutton_bbubumbbu);
		imagebutton_samjicanggeuraeb = new ImageButton(this.leftPos + 196, this.topPos + 114, 25, 25,
				new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/samjicanggeuraeb.png"), ResourceLocation.parse("palworld:textures/screens/samjicanggeuraeb.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(10, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_samjicanggeuraeb", imagebutton_samjicanggeuraeb);
		this.addRenderableWidget(imagebutton_samjicanggeuraeb);
		imagebutton_nunsaram = new ImageButton(this.leftPos + 245, this.topPos + 139, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/nunsaram.png"), ResourceLocation.parse("palworld:textures/screens/nunsaram.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(11, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_nunsaram", imagebutton_nunsaram);
		this.addRenderableWidget(imagebutton_nunsaram);
		imagebutton_sasin = new ImageButton(this.leftPos + 245, this.topPos + 88, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/sasin.png"), ResourceLocation.parse("palworld:textures/screens/sasin.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(12, x, y, z));
				FisherSkillTreeButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_sasin", imagebutton_sasin);
		this.addRenderableWidget(imagebutton_sasin);
		imagebutton_haegpeonci = new ImageButton(this.leftPos + 245, this.topPos + 35, 25, 25, new WidgetSprites(ResourceLocation.parse("palworld:textures/screens/haegpeonci.png"), ResourceLocation.parse("palworld:textures/screens/haegpeonci.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new FisherSkillTreeButtonMessage(13, x, y, z));
						FisherSkillTreeButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_haegpeonci", imagebutton_haegpeonci);
		this.addRenderableWidget(imagebutton_haegpeonci);
	}
}
