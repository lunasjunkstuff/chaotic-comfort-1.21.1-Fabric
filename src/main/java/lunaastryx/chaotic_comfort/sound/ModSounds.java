package lunaastryx.chaotic_comfort.sound;

import lunaastryx.chaotic_comfort.ChaoticComfort;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    /*public static final SoundEvent POMMES_ROT_WEISS = registerSoundEvent("pommes_rot_weiss");
    public static final RegistryKey<JukeboxSong> POMMES_ROT_WEISS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(ChaoticComfort.MOD_ID, "pommes_rot_weiss"));
*/

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(ChaoticComfort.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ChaoticComfort.LOGGER.info("Registering Mod Sounds for " + ChaoticComfort.MOD_ID);
    }
}
