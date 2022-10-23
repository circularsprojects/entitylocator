# Entitylocator
[![Gradlew Build](https://github.com/circularsprojects/entitylocator/actions/workflows/gradle.yml/badge.svg)](https://github.com/circularsprojects/entitylocator/actions/workflows/gradle.yml)\
Entitylocator is a simple mod designed to make it easier to find minecraft bases by analysing entity counts and the F3+shift pie chart.

You can find the latest development build in `Actions -> Latest workflow run -> Artifacts -> entitylocator-dev`
## How to use
You can enable or disable the mod by typing in ;;start or ;;stop in chat.\
Other messages containing ;; (e.g. ;;help) will not be handled and will just be sent as a regular chat message.

You can also check for ender chests, enchanting tables and shulker boxes by having the F3 pie chart menu open (F3+shift) while the mod is active (haven't made it able to check it without the pie chart open yet)
## Current features:
- Tests if entity count is above 100, and if so sends a message to the client.
- Tests if certain blocks appear in the F3 pie chart, and if so sends a message to the client.
- [Unfinished] Configurable options
