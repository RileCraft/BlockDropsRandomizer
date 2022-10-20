# Block Drops Randomizer [BDR] 1.13.X - 1.19.X
Lightweight plugin for changing the way of block drops. This plugin also comes with very simple config and lot of room for customization as per the user's need.

# Features:
- Very simple config with commented instructions.
- Ability to preFix drops for any block.
- Ability to drop multiple items and multiple items of them.
- Simple commands or config line to disable certain aspects of the behaviours of the block drops.

# Permissions:
* **BDR.***         - Access to all the commands below.
* **BDR.reload** - **/bdr reload** -- Reloads the config files of the plugin.
* **BDR.shuffle** - **/bdr shuffle** -- Considering randomizeEachDrop is set to false, this will reset all the drops of the blocks which were set by the plugin. FixedList is not affected in any way.
* **BDR.toggle** - **/bdr toggle** - Enables/Disables the plugin.

# Configuration Example:
```yml
# Blocks Drops Randomizer Configuration File.
# Author: RileCraft :D
# Version: 1.0.1

BDR:
  enabled: true #Enables/Disables the plugin.
  blacklistedBlocks:
   - BEDROCK # Blacklists Bedrock from being added in random shuffle. FixedList ignores this.
  randomizeEachDrop: false # Whether to drop something random each time you break the same block or have a fixed item that will drop always when you break that block.
  allowExplosionDrops: false # Whether to also randomize or fix item drops if the block is broken by a explosion.

  FixedList:
    items: # You can have to use the format below.
      STONE: # MUST BE IN CAPITALS!
          - DIRT:2
          - COBBLESTONE:1 # Mining Stone will always drop 2 dirt and 1 cobblestone.
```

**This is my first ever plugin so hope you enjoy it :)**
