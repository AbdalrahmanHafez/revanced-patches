package app.revanced.patches.candylinkvpn.patch

import app.revanced.extensions.toErrorResult
import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.candylinkvpn.annotations.UnlockProCompatibility
import app.revanced.patches.candylinkvpn.fingerprints.IsPremiumPurchasedFingerprint

@Patch
@Name("Unlock pro")
@Description("Unlocks premium features.")
@UnlockProCompatibility
class UnlockProPatch : BytecodePatch(
    listOf(IsPremiumPurchasedFingerprint)
) {
    override fun execute(context: BytecodeContext): PatchResult {
        IsPremiumPurchasedFingerprint.result?.mutableMethod?.addInstructions(
            0,
            """
               const/4 v0, 0x1
               return v0
            """
        ) ?: return IsPremiumPurchasedFingerprint.toErrorResult()

        return PatchResultSuccess()
    }
}