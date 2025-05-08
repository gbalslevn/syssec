package dagger.hilt.android.internal.builders;

import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;

/* loaded from: classes2.dex */
public interface ActivityRetainedComponentBuilder {
    ActivityRetainedComponent build();

    ActivityRetainedComponentBuilder savedStateHandleHolder(SavedStateHandleHolder savedStateHandleHolder);
}
