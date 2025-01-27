package net.mcreator.palworld.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.palworld.entity.LazerEntity;

public class LazerModel extends GeoModel<LazerEntity> {
	@Override
	public ResourceLocation getAnimationResource(LazerEntity entity) {
		return ResourceLocation.parse("palworld:animations/lazer.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LazerEntity entity) {
		return ResourceLocation.parse("palworld:geo/lazer.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LazerEntity entity) {
		return ResourceLocation.parse("palworld:textures/entities/" + entity.getTexture() + ".png");
	}

}
