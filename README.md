# JSpecAtDeath

A lightweight Paper/Spigot plugin that instantly switches a player to **Spectator mode** upon death.  
Perfect for hardcore, one-life, or “ghost mode” servers.

**Server core:** Paper / Spigot  
**Supported versions:** 1.16.5 – 1.21.10  
**Java:** 16+

### Features
- On player death → instantly switches to **Spectator** mode.
- Fully configurable:
    - Messages (with color codes)
    - Death/respawn sounds
- No external dependencies.

### Commands & Permissions
| Command                  | Description                              | Permission               | Default |
|--------------------------|------------------------------------------|--------------------------|---------|
| `/jsadreturn [nickname]` | Return player to Survival mode        | `jspecatdeath.return`    | op      |
| `/jsadreload`            | Reload config & messages                 | `jspecatdeath.reload`    | op      |

### Installation
1. Drop `JSpecAtDeath.jar` into your `plugins/` folder.
2. Restart or reload the server.
3. (Optional) Edit `plugins/JSpecAtDeath/config.yml` to your liking.

### Default config.yml
```yaml

#    ░░░░░██╗░██████╗██████╗░███████╗░█████╗░░█████╗░████████╗██████╗░███████╗░█████╗░████████╗██╗░░██╗
#    ░░░░░██║██╔════╝██╔══██╗██╔════╝██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██║░░██║
#    ░░░░░██║╚█████╗░██████╔╝█████╗░░██║░░╚═╝███████║░░░██║░░░██║░░██║█████╗░░███████║░░░██║░░░███████║
#    ██╗░░██║░╚═══██╗██╔═══╝░██╔══╝░░██║░░██╗██╔══██║░░░██║░░░██║░░██║██╔══╝░░██╔══██║░░░██║░░░██╔══██║
#    ╚█████╔╝██████╔╝██║░░░░░███████╗╚█████╔╝██║░░██║░░░██║░░░██████╔╝███████╗██║░░██║░░░██║░░░██║░░██║
#    ░╚════╝░╚═════╝░╚═╝░░░░░╚══════╝░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═════╝░╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝

prefix: "&8[&bJSAD&8] "

sounds:
  return:
    sound: "entity.player.levelup"
    volume: 1.0
    pitch: 1.0
  death:
    sound: "entity.wither.spawn"
    volume: 1.0
    pitch: 1.0

messages:
  no-permission: "&fYou &cdon't have &fpermission"
  reloaded: "&fPlugin successfully &areloaded"

  usage:
    reload: "&fUsage: &b/jsadreload"
    return: "&fUsage: &b/jsadreturn [nickname]"

  not-found: "&fPlayer &cnot found! &fMaybe he &coffline?.."
  not-spectator: "&fPlayer &b%player% &fis &cnot in &fspectator mode"
  returned: "&fYou are back to &asurvival &fmode! We &bwish &fyou new &aachievements &fand fewer &cdeaths!"
  returned-player: "&fYou returned &b%player% &fto &asurvival &fmode!"
  death-notice:
    - " "
    - "  &b&n|&r  &fYou &cdied!"
    - "  &b|  &fYou are now in &bspectator &fmode."
    - " "
    - "  &b&n|&r  &fTo continue your survival, purchase a"
    - "  &b|  &frebirth on our website: &bhttps://yoursite.com"
    - " "
```