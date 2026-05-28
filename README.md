# CoordsOnScreen

A client-side Fabric mod for Minecraft 26.1.2 that renders colored coordinates on the HUD.

- Shows your current position, color-coded by dimension (Overworld green, Nether red, End purple).
- In the Overworld/Nether it also shows the equivalent coordinates in the other dimension.
- Configurable corner, padding, and per-line toggles via a Cloth Config screen (accessible through ModMenu).

## Building

Run `./gradlew build`; the mod jar is produced in `build/libs/`.

## Dependencies

- Fabric API
- Cloth Config
- ModMenu (optional — only needed to open the in-game settings screen)

## License

Available under the MIT license.
