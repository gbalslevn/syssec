package defpackage;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"LMolslinjenSharedHelper;", BuildConfig.FLAVOR, "()V", "setup", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MolslinjenSharedHelper {
    public static final MolslinjenSharedHelper INSTANCE = new MolslinjenSharedHelper();

    private MolslinjenSharedHelper() {
    }

    public final void setup() {
        System.loadLibrary("molslinjen_shared");
    }
}
