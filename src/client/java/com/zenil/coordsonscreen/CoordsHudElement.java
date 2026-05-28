package com.zenil.coordsonscreen;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.ChatFormatting;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public final class CoordsHudElement implements HudElement {

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        CoordsConfig config = CoordsConfig.get();
        if (!config.showMainCoords) return;

        ResourceKey<Level> dim = mc.level.dimension();
        BlockPos pos = mc.player.blockPosition();
        MutableComponent line = buildLine(dim, pos.getX(), pos.getY(), pos.getZ(), config);
        if (line == null) return;

        Font font = mc.font;
        int textWidth = font.width(line);
        int textHeight = font.lineHeight;
        int screenW = graphics.guiWidth();
        int screenH = graphics.guiHeight();
        int px = config.xPadding;
        int py = config.yPadding;

        // Counter-scale by the GUI scale so the chosen size is a fixed on-screen
        // size: physical height = textHeight * guiScale * scale stays constant.
        int guiScale = Math.max(1, mc.getWindow().getGuiScale());
        float scale = config.fontSizePercent / (50f * guiScale);
        float scaledWidth = textWidth * scale;
        float scaledHeight = textHeight * scale;

        float drawX = switch (config.position) {
            case TOP_LEFT, BOTTOM_LEFT -> px;
            case TOP_RIGHT, BOTTOM_RIGHT -> screenW - scaledWidth - px;
        };
        float drawY = switch (config.position) {
            case TOP_LEFT, TOP_RIGHT -> py;
            case BOTTOM_LEFT, BOTTOM_RIGHT -> screenH - scaledHeight - py;
        };

        graphics.pose().pushMatrix();
        graphics.pose().translate(drawX, drawY);
        graphics.pose().scale(scale, scale);
        graphics.text(font, line, 0, 0, 0xFFFFFFFF, true);
        graphics.pose().popMatrix();
    }

    private static MutableComponent buildLine(
            ResourceKey<Level> dim, int x, int y, int z, CoordsConfig config) {

        if (dim.equals(Level.OVERWORLD)) {
            MutableComponent main = Component.empty()
                .append(Component.literal("Overworld ").withStyle(ChatFormatting.GREEN))
                .append(coordText(x, y, z));
            if (!config.showAltCoords) return main;
            return main
                .append(Component.literal(" ["))
                .append(Component.literal("Nether ").withStyle(ChatFormatting.RED))
                .append(coordText(x / 8, y, z / 8))
                .append(Component.literal("]"));

        } else if (dim.equals(Level.NETHER)) {
            MutableComponent main = Component.empty()
                .append(Component.literal("Nether ").withStyle(ChatFormatting.RED))
                .append(coordText(x, y, z));
            if (!config.showAltCoords) return main;
            return main
                .append(Component.literal(" ["))
                .append(Component.literal("Overworld ").withStyle(ChatFormatting.GREEN))
                .append(coordText(x * 8, y, z * 8))
                .append(Component.literal("]"));

        } else if (dim.equals(Level.END)) {
            return Component.empty()
                .append(Component.literal("End ").withStyle(ChatFormatting.DARK_PURPLE))
                .append(coordText(x, y, z));
        }

        return Component.empty().append(coordText(x, y, z));
    }

    private static Component coordText(int x, int y, int z) {
        return Component.literal("X: %d, Y: %d, Z: %d".formatted(x, y, z));
    }
}
