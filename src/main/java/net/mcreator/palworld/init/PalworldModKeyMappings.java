
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.palworld.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.palworld.network.TransformMessage;
import net.mcreator.palworld.network.ShiftScaleDownMessage;
import net.mcreator.palworld.network.OpenQuestGUIMessage;
import net.mcreator.palworld.network.InvisibleMessage;
import net.mcreator.palworld.network.DoubleJumpKeyMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PalworldModKeyMappings {
	public static final KeyMapping OPEN_QUEST_GUI = new KeyMapping("key.palworld.open_quest_gui", GLFW.GLFW_KEY_R, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenQuestGUIMessage(0, 0));
				OpenQuestGUIMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DOUBLE_JUMP_KEY = new KeyMapping("key.palworld.double_jump_key", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new DoubleJumpKeyMessage(0, 0));
				DoubleJumpKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHIFT_SCALE_DOWN = new KeyMapping("key.palworld.shift_scale_down", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ShiftScaleDownMessage(0, 0));
				ShiftScaleDownMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				SHIFT_SCALE_DOWN_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SHIFT_SCALE_DOWN_LASTPRESS);
				PacketDistributor.sendToServer(new ShiftScaleDownMessage(1, dt));
				ShiftScaleDownMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping INVISIBLE = new KeyMapping("key.palworld.invisible", GLFW.GLFW_KEY_LEFT_SHIFT, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new InvisibleMessage(0, 0));
				InvisibleMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				INVISIBLE_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - INVISIBLE_LASTPRESS);
				PacketDistributor.sendToServer(new InvisibleMessage(1, dt));
				InvisibleMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TRANSFORM = new KeyMapping("key.palworld.transform", GLFW.GLFW_KEY_Y, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TRANSFORM_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TRANSFORM_LASTPRESS);
				PacketDistributor.sendToServer(new TransformMessage(1, dt));
				TransformMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long SHIFT_SCALE_DOWN_LASTPRESS = 0;
	private static long INVISIBLE_LASTPRESS = 0;
	private static long TRANSFORM_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_QUEST_GUI);
		event.register(DOUBLE_JUMP_KEY);
		event.register(SHIFT_SCALE_DOWN);
		event.register(INVISIBLE);
		event.register(TRANSFORM);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				OPEN_QUEST_GUI.consumeClick();
				DOUBLE_JUMP_KEY.consumeClick();
				SHIFT_SCALE_DOWN.consumeClick();
				INVISIBLE.consumeClick();
				TRANSFORM.consumeClick();
			}
		}
	}
}
