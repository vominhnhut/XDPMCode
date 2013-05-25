package xdpm.nhom11.angrybirdsproject.resourcemanager;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;

import xdpm.nhom11.angrybirdsproject.manager.Game;

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
	public static Music title_theme;

	public static void StopAll() {
		level_start_military.stop();
		level_failed_piglets.stop();
		redbird_flying.stop();
		redbird_select.stop();
		redbird_collision.stop();
		bluebird_flying.stop();
		bluebird_select.stop();
		bluebird_collision.stop();
		yellowbird_flying.stop();
		yellowbird_select.stop();
		yellowbird_collision.stop();
		ice_collision.stop();
		ice_damage.stop();
		ice_destroyed.stop();
		rock_collision.stop();
		rock_damage.stop();
		rock_destroyed.stop();
		wood_collision.stop();
		wood_damage.stop();
		wood_destroyed.stop();
		pig_collision.stop();
		pig_damage.stop();
		pig_destroyed.stop();

	}

	public static void LoadSoundEffect() {
		try {
			level_start_military = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/level_start_military.mp3");
			level_failed_piglets = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/level_failed_piglets.mp3");
			redbird_flying = SoundFactory
					.createSoundFromAsset(
							Game.getInstance().engine.getSoundManager(),
							Game.getInstance().activity,
							"audio/sfx/redbird_flying.wav");
			redbird_collision = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/redbird_collision.wav");
			redbird_select = SoundFactory
					.createSoundFromAsset(
							Game.getInstance().engine.getSoundManager(),
							Game.getInstance().activity,
							"audio/sfx/redbird_select.wav");
			bluebird_flying = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/bluebird_flying.wav");
			bluebird_collision = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/bluebird_collision.wav");
			bluebird_select = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/bluebird_select.wav");
			yellowbird_flying = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/yellowbird_flying.wav");
			yellowbird_collision = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/yellowbird_collision.wav");
			yellowbird_select = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity,
					"audio/sfx/yellowbird_select.wav");
			ice_collision = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/ice_collision.wav");
			ice_damage = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/ice_damage.wav");
			ice_destroyed = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/ice_destroyed.wav");
			rock_collision = SoundFactory
					.createSoundFromAsset(
							Game.getInstance().engine.getSoundManager(),
							Game.getInstance().activity,
							"audio/sfx/rock_collision.wav");
			rock_damage = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/rock_damage.wav");
			rock_destroyed = SoundFactory
					.createSoundFromAsset(
							Game.getInstance().engine.getSoundManager(),
							Game.getInstance().activity,
							"audio/sfx/rock_destroyed.wav");
			wood_collision = SoundFactory
					.createSoundFromAsset(
							Game.getInstance().engine.getSoundManager(),
							Game.getInstance().activity,
							"audio/sfx/wood_collision.wav");
			wood_damage = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/wood_damage.wav");
			wood_destroyed = SoundFactory
					.createSoundFromAsset(
							Game.getInstance().engine.getSoundManager(),
							Game.getInstance().activity,
							"audio/sfx/wood_destroyed.wav");
			pig_collision = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/pig_collision.wav");
			pig_damage = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/pig_damage.wav");
			pig_destroyed = SoundFactory.createSoundFromAsset(
					Game.getInstance().engine.getSoundManager(),
					Game.getInstance().activity, "audio/sfx/pig_destroyed.wav");
			title_theme = MusicFactory.createMusicFromAsset(
					Game.getInstance().engine.getMusicManager(),
					Game.getInstance().activity, "audio/music/title_theme.mp3");
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
