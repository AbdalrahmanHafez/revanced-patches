package app.revanced.patches.windyapp.misc.unlockpro.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object CheckProFingerprint : MethodFingerprint(
    "I",
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass.endsWith("RawUserData;") && methodDef.name == "isPro"
    }
)
