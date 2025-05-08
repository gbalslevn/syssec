package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SettingsJsonParser {
    private final CurrentTimeProvider currentTimeProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.currentTimeProvider = currentTimeProvider;
    }

    private static SettingsJsonTransform getJsonTransformForVersion(int i5) {
        if (i5 == 3) {
            return new SettingsV3JsonTransform();
        }
        Logger.getLogger().e("Could not determine SettingsJsonTransform for settings version " + i5 + ". Using default settings values.");
        return new DefaultSettingsJsonTransform();
    }

    public Settings parseSettingsJson(JSONObject jSONObject) {
        return getJsonTransformForVersion(jSONObject.getInt("settings_version")).buildFromJson(this.currentTimeProvider, jSONObject);
    }
}
