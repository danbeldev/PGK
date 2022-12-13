package ru.pgk63.feature_main.screen.enums

import ru.pgk63.core_ui.R
import ru.pgk63.core_ui.icon.ResIcons

internal enum class DrawerContent(val nameId:Int, val iconId:Int) {
    PROFILE(nameId = R.string.profile, iconId = ResIcons.profile),
    SCHEDULE(nameId = R.string.schedule, iconId = ResIcons.schedule),
    GUIDE(nameId = R.string.guide, iconId = ResIcons.guide),
    GROUPS(nameId = R.string.groups, iconId = ResIcons.groups),
    JOURNAL(nameId = R.string.journal, iconId = ResIcons.journal),
    RAPORTICHKA(nameId = R.string.raportichka, iconId = ResIcons.raportichka),
    SETTINGS(nameId = R.string.settings, iconId = ResIcons.settings),
    HELP(nameId = R.string.help, iconId = ResIcons.help)
}