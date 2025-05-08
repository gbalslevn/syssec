package dagger.hilt.android.internal.builders;

import androidx.lifecycle.SavedStateHandle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.components.ViewModelComponent;

/* loaded from: classes2.dex */
public interface ViewModelComponentBuilder {
    ViewModelComponent build();

    ViewModelComponentBuilder savedStateHandle(SavedStateHandle savedStateHandle);

    ViewModelComponentBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle);
}
