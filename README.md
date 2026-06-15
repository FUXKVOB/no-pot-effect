# No Pot Effect

Убирает визуальные эффекты, мешающие в PvP: растяжение экрана от зелий, тошноту (портал) и тряску при ударах. Полностью настраивается.

## Возможности

- 🚫 **FOV distortion** — убирает растяжение/сужение экрана от зелий скорости и замедления
- 🤢 **Nausea** — убирает эффект тошноты/портала
- 💥 **Hurt tilt** — убирает тряску экрана при получении урона
- ⚙️ Всё отключается через `config/no-pot-effect.json`

## Установка

1. Скачай `.jar` из [релизов](https://github.com/FUXKVOB/no-pot-effect/releases) или с [Modrinth](https://modrinth.com/mod/no-pot-effect)
2. Кинуть в `.minecraft/mods/`
3. Запустить игру

## Требования

- Minecraft 1.21.11
- Fabric Loader 0.14+
- Fabric API

## Конфиг

После первого запуска появляется `config/no-pot-effect.json`:

```json
{
  "disableFov": true,
  "disableNausea": true,
  "disableHurtTilt": true
}
```

Поставь `false` любому параметру, чтобы включить эффект обратно.

## Сборка

```bash
./gradlew build
```

## Лицензия

MIT
