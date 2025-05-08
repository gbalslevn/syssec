package com.google.android.play.core.install;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* loaded from: classes.dex */
public class InstallException extends ApiException {
    public InstallException(int i5) {
        super(new Status(i5, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i5), com.google.android.play.core.install.model.zza.zza(i5))));
        if (i5 == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }
}
