package app.revanced.patches.twitter.misc.hook.patch.ads.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.patch.annotations.DependsOn
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.twitter.misc.hook.json.patch.JsonHookPatch
import app.revanced.patches.twitter.misc.hook.patch.BaseHookPatchPatch
import app.revanced.patches.twitter.misc.hook.patch.ads.annotations.HideAdsCompatibility

@Patch
@Name("Hide ads")
@DependsOn([JsonHookPatch::class])
@Description("Hides ads.")
@HideAdsCompatibility
class HideAdsPatch : BaseHookPatchPatch("Lapp/revanced/twitter/patches/hook/patch/ads/AdsHook;")