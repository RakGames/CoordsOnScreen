package com.zenil.coordsonscreen;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "coordsonscreen")
public class CoordsConfig implements ConfigData {

    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
    public HudPosition position = HudPosition.TOP_LEFT;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 200)
    public int xPadding = 5;

    @ConfigEntry.BoundedDiscrete(min = 0, max = 200)
    public int yPadding = 5;

    public boolean showMainCoords = true;
    public boolean showAltCoords = true;

    public enum HudPosition {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    public static CoordsConfig get() {
        return AutoConfig.getConfigHolder(CoordsConfig.class).getConfig();
    }

    public static ConfigHolder<CoordsConfig> holder() {
        return AutoConfig.getConfigHolder(CoordsConfig.class);
    }
}
