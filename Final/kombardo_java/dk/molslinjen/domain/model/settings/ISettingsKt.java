package dk.molslinjen.domain.model.settings;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0002\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0003H\u0002\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0003H\u0002*\n\u0010\u0007\"\u00020\u00032\u00020\u0003¨\u0006\b"}, d2 = {"toBooleanKey", "Landroidx/datastore/preferences/core/Preferences$Key;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toIntKey", BuildConfig.FLAVOR, "toStringKey", "JsonData", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ISettingsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences.Key<Boolean> toBooleanKey(String str) {
        return PreferencesKeys.booleanKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences.Key<Integer> toIntKey(String str) {
        return PreferencesKeys.intKey(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences.Key<String> toStringKey(String str) {
        return PreferencesKeys.stringKey(str);
    }
}
