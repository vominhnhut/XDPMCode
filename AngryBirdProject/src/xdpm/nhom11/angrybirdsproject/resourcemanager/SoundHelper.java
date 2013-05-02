package xdpm.nhom11.angrybirdsproject.resourcemanager;

import java.io.IOException;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;

public class SoundHelper {

	public static Sound level_start_military;
	public static Sound level_failed_piglets;

	public static Sound redbird_flying;
	public static Sound redbird_select;
	public static Sound redbird_collision;
	public static Sound bluebird_flying;
	public static Sound bluebird_select;
	public static Sound bluebird_collision;
	public static Sound yellowbird_flying;
	public static Sound yellowbird_select;
	public static Sound yellowbird_collision;
	public static Sound ice_collision;
	public static Sound ice_damage;
	public static Sound ice_destroyed;
	public static Sound rock_collision;
	public static Sound rock_damage;
	public static Sound rock_destroyed;
	public static Sound wood_collision;
	public static Sound wood_damage;
	public static Sound wood_destroyed;
	public static Sound pig_collision;
	public static Sound pig_damage;
	public static Sound pig_destroyed;

	
	public static void LoadSound() {
		try {
			level_start_military = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/level_start_military.mp3");
			level_failed_piglets = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/level_failed_piglets.mp3");
			redbird_flying = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/redbird_flying.wav");
			redbird_collision = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/redbird_collision.wav");
			redbird_select = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/redbird_select.wav");
			bluebird_flying = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/bluebird_flying.wav");
			bluebird_collision = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/bluebird_collision.wav");
			bluebird_select = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/bluebird_select.wav");
			yellowbird_flying = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/yellowbird_flying.wav");
			yellowbird_collision = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/yellowbird_collision.wav");
			yellowbird_select = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/yellowbird_select.wav");
			ice_collision = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/ice_collision.wav");
			ice_damage = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/ice_damage.wav");
			ice_destroyed = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/ice_destroyed.wav");
			rock_collision = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/rock_collision.wav");
			rock_damage = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/rock_damage.wav");
			rock_destroyed = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/rock_destroyed.wav");
			wood_collision = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/wood_collision.wav");
			wood_damage = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/wood_damage.wav");
			wood_destroyed = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/wood_destroyed.wav");
			pig_collision = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/pig_collision.wav");
			pig_damage = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/pig_damage.wav");
			pig_destroyed = SoundFactory.createSoundFromAsset(
					ResourcesManager.getInstance().engine.getSoundManager(),
					ResourcesManager.getInstance().activity,
					"audio/sfx/pig_destroyed.wav");
			//

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
