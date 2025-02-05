package net.mcreator.palworld.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;

public class ElderWandEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		double i = 0;
		double r = 0;
		double s = 0;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double z1 = 0;
		double y1 = 0;
		double z2 = 0;
		double x1 = 0;
		double y2 = 0;
		double x2 = 0;
		double dc = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("kill") <= 0) {
			{
				final String _tagName = "kill";
				final double _tagValue = 30;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "killr";
				final double _tagValue = 4;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "killa";
				final double _tagValue = (entity.getYRot());
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "killb";
				final double _tagValue = (entity.getXRot());
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "killx";
				final double _tagValue = x;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "killy";
				final double _tagValue = y;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			{
				final String _tagName = "killz";
				final double _tagValue = z;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
			r = 1;
			s = 2;
			a = entity.getYRot();
			b = entity.getXRot();
			c = 0;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.END_ROD, (x + 2 * entity.getLookAngle().x), (y + 1.5 + entity.getLookAngle().y), (z + 2 * entity.getLookAngle().z), 20, 1, 1, 1, 0);
			for (int index0 = 0; index0 < 60; index0++) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD,
							(x - (r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a)) + s * Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b - 90)) * Math.sin(Math.toRadians(a))
									+ s * Math.sin(Math.toRadians(c)) * Math.sin(Math.toRadians(a - 90)))),
							((y + 1.5) - (r * Math.sin(Math.toRadians(b)) + s * Math.cos(Math.toRadians(c)) * Math.sin(Math.toRadians(b - 90)))), (z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a))
									+ s * Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b - 90)) * Math.cos(Math.toRadians(a)) + s * Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(a - 90))),
							1, 0.01, 0.01, 0.01, 0);
				c = c + 6;
			}
			c = 0;
			dc = 10;
			i = 50;
			for (int index1 = 0; index1 < (int) dc; index1++) {
				x1 = x - (r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a)) + s * Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b - 90)) * Math.sin(Math.toRadians(a))
						+ s * Math.sin(Math.toRadians(c)) * Math.sin(Math.toRadians(a - 90)));
				x2 = x - (r * Math.cos(Math.toRadians(b)) * Math.sin(Math.toRadians(a)) + s * Math.cos(Math.toRadians(c + 720 / dc)) * Math.cos(Math.toRadians(b - 90)) * Math.sin(Math.toRadians(a))
						+ s * Math.sin(Math.toRadians(c + 720 / dc)) * Math.sin(Math.toRadians(a - 90)));
				y1 = (y + 1.5) - (r * Math.sin(Math.toRadians(b)) + s * Math.cos(Math.toRadians(c)) * Math.sin(Math.toRadians(b - 90)));
				y2 = (y + 1.5) - (r * Math.sin(Math.toRadians(b)) + s * Math.cos(Math.toRadians(c + 720 / dc)) * Math.sin(Math.toRadians(b - 90)));
				z1 = z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a)) + s * Math.cos(Math.toRadians(c)) * Math.cos(Math.toRadians(b - 90)) * Math.cos(Math.toRadians(a))
						+ s * Math.sin(Math.toRadians(c)) * Math.cos(Math.toRadians(a - 90));
				z2 = z + r * Math.cos(Math.toRadians(b)) * Math.cos(Math.toRadians(a)) + s * Math.cos(Math.toRadians(c + 720 / dc)) * Math.cos(Math.toRadians(b - 90)) * Math.cos(Math.toRadians(a))
						+ s * Math.sin(Math.toRadians(c + 720 / dc)) * Math.cos(Math.toRadians(a - 90));
				dx = (x2 - x1) / i;
				dy = (y2 - y1) / i;
				dz = (z2 - z1) / i;
				for (int index2 = 0; index2 < (int) i; index2++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.END_ROD, x1, y1, z1, 1, 0.01, 0.01, 0.01, 0);
					x1 = x1 + dx;
					y1 = y1 + dy;
					z1 = z1 + dz;
				}
				c = c + 360 / dc;
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 200);
		}
	}
}
