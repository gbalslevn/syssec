package dagger.hilt.android.internal.managers;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.viewmodel.CreationExtras;

/* loaded from: classes2.dex */
public final class SavedStateHandleHolder {
    private CreationExtras extras;
    private SavedStateHandle handle;
    private final boolean nonComponentActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateHandleHolder(CreationExtras creationExtras) {
        this.nonComponentActivity = creationExtras == null;
        this.extras = creationExtras;
    }

    public void clear() {
        this.extras = null;
    }

    public boolean isInvalid() {
        return this.handle == null && this.extras == null;
    }

    public void setExtras(CreationExtras creationExtras) {
        if (this.handle != null) {
            return;
        }
        this.extras = creationExtras;
    }
}
