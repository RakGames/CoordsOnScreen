package com.zenil.coordsonscreen;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

/**
 * A curated, hand-picked color for each vanilla biome so the biome name on the
 * HUD reads in a tone that fits the biome (oceans blue/teal, beaches sandy,
 * deserts tan, etc.) rather than the generic grass color, which is wrong for
 * non-grassy biomes. Modded biomes are not in this map; callers fall back to
 * the biome's grass color for those.
 */
public final class BiomeColors {

    private BiomeColors() {}

    private static final Map<ResourceKey<Biome>, Integer> PALETTE = new HashMap<>();

    /** Returns the curated color for a biome, or {@code null} if not curated. */
    public static Integer curated(ResourceKey<Biome> key) {
        return PALETTE.get(key);
    }

    private static void put(ResourceKey<Biome> key, int rgb) {
        PALETTE.put(key, rgb);
    }

    static {
        // Plains / grassland
        put(Biomes.PLAINS, 0x91BD59);
        put(Biomes.SUNFLOWER_PLAINS, 0xD7CC4A);
        put(Biomes.MEADOW, 0x83BB6D);

        // Forests
        put(Biomes.FOREST, 0x79C05A);
        put(Biomes.FLOWER_FOREST, 0xD17BE0);
        put(Biomes.BIRCH_FOREST, 0x96BB6B);
        put(Biomes.OLD_GROWTH_BIRCH_FOREST, 0xA3C470);
        put(Biomes.DARK_FOREST, 0x4F7A36);
        put(Biomes.PALE_GARDEN, 0xB6BBA1);
        put(Biomes.WINDSWEPT_FOREST, 0x6F9C5A);

        // Taigas
        put(Biomes.TAIGA, 0x5E7848);
        put(Biomes.SNOWY_TAIGA, 0xC2E0D6);
        put(Biomes.OLD_GROWTH_PINE_TAIGA, 0x5C7A3E);
        put(Biomes.OLD_GROWTH_SPRUCE_TAIGA, 0x5E7B45);

        // Jungles
        put(Biomes.JUNGLE, 0x59C93C);
        put(Biomes.SPARSE_JUNGLE, 0x64C73F);
        put(Biomes.BAMBOO_JUNGLE, 0x9BD22E);

        // Savanna
        put(Biomes.SAVANNA, 0xBFB755);
        put(Biomes.SAVANNA_PLATEAU, 0xC2BE66);
        put(Biomes.WINDSWEPT_SAVANNA, 0xC1B85A);

        // Desert / badlands
        put(Biomes.DESERT, 0xE6D7A0);
        put(Biomes.BADLANDS, 0xD06D3B);
        put(Biomes.ERODED_BADLANDS, 0xCF6A35);
        put(Biomes.WOODED_BADLANDS, 0xC59B5F);

        // Cherry
        put(Biomes.CHERRY_GROVE, 0xFFB7D5);

        // Hills / windswept
        put(Biomes.WINDSWEPT_HILLS, 0x8FA17A);
        put(Biomes.WINDSWEPT_GRAVELLY_HILLS, 0x9AA088);

        // Mountains / peaks
        put(Biomes.GROVE, 0xC7D7E0);
        put(Biomes.SNOWY_SLOPES, 0xDCE9EF);
        put(Biomes.FROZEN_PEAKS, 0xC7E0EE);
        put(Biomes.JAGGED_PEAKS, 0xD3E3EC);
        put(Biomes.STONY_PEAKS, 0x9AA0A6);

        // Snowy / icy
        put(Biomes.SNOWY_PLAINS, 0xE3ECEC);
        put(Biomes.ICE_SPIKES, 0xB7DDF0);

        // Swamps
        put(Biomes.SWAMP, 0x6A7039);
        put(Biomes.MANGROVE_SWAMP, 0x5A8042);

        // Rivers
        put(Biomes.RIVER, 0x3F76E4);
        put(Biomes.FROZEN_RIVER, 0x9DC2EC);

        // Beaches / shores
        put(Biomes.BEACH, 0xE6D9A8);
        put(Biomes.SNOWY_BEACH, 0xE4E8DC);
        put(Biomes.STONY_SHORE, 0xA0A2A0);

        // Oceans (water-toned)
        put(Biomes.WARM_OCEAN, 0x43D5EE);
        put(Biomes.LUKEWARM_OCEAN, 0x45ADF2);
        put(Biomes.DEEP_LUKEWARM_OCEAN, 0x3A8BD6);
        put(Biomes.OCEAN, 0x3F76E4);
        put(Biomes.DEEP_OCEAN, 0x2C5BBF);
        put(Biomes.COLD_OCEAN, 0x3D57D6);
        put(Biomes.DEEP_COLD_OCEAN, 0x2C44B0);
        put(Biomes.FROZEN_OCEAN, 0x9DB6E8);
        put(Biomes.DEEP_FROZEN_OCEAN, 0x6E8CCB);

        // Mushroom
        put(Biomes.MUSHROOM_FIELDS, 0xC586B8);

        // Caves
        put(Biomes.DRIPSTONE_CAVES, 0x9C7A5A);
        put(Biomes.LUSH_CAVES, 0x68B33B);
        put(Biomes.DEEP_DARK, 0x1C6E78);

        // Nether
        put(Biomes.NETHER_WASTES, 0x9E3D2E);
        put(Biomes.CRIMSON_FOREST, 0xC23A2B);
        put(Biomes.WARPED_FOREST, 0x2BB3A0);
        put(Biomes.SOUL_SAND_VALLEY, 0x5AA6A0);
        put(Biomes.BASALT_DELTAS, 0x6A6A70);

        // End (not normally shown, but covered for completeness)
        put(Biomes.THE_END, 0xD8D8A0);
        put(Biomes.END_HIGHLANDS, 0xDADAA2);
        put(Biomes.END_MIDLANDS, 0xD2D29A);
        put(Biomes.SMALL_END_ISLANDS, 0xCACA92);
        put(Biomes.END_BARRENS, 0xC2C28A);

        // Misc
        put(Biomes.THE_VOID, 0x3A3A3A);
    }
}
