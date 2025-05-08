package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/viewmodel/ViewModelProviderImpl;", BuildConfig.FLAVOR, "Landroidx/lifecycle/ViewModelStore;", "store", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "<init>", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "Landroidx/lifecycle/ViewModel;", "T", "Lkotlin/reflect/KClass;", "modelClass", BuildConfig.FLAVOR, "key", "getViewModel$lifecycle_viewmodel_release", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "getViewModel", "Landroidx/lifecycle/ViewModelStore;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewModelProviderImpl {
    private final CreationExtras extras;
    private final ViewModelProvider.Factory factory;
    private final ViewModelStore store;

    public ViewModelProviderImpl(ViewModelStore store, ViewModelProvider.Factory factory, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.store = store;
        this.factory = factory;
        this.extras = extras;
    }

    public static /* synthetic */ ViewModel getViewModel$lifecycle_viewmodel_release$default(ViewModelProviderImpl viewModelProviderImpl, KClass kClass, String str, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel_release(kClass);
        }
        return viewModelProviderImpl.getViewModel$lifecycle_viewmodel_release(kClass, str);
    }

    public final <T extends ViewModel> T getViewModel$lifecycle_viewmodel_release(KClass<T> modelClass, String key) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(key, "key");
        T t5 = (T) this.store.get(key);
        if (!modelClass.isInstance(t5)) {
            MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.extras);
            mutableCreationExtras.set(ViewModelProviders.ViewModelKey.INSTANCE, key);
            T t6 = (T) ViewModelProviderImpl_androidKt.createViewModel(this.factory, modelClass, mutableCreationExtras);
            this.store.put(key, t6);
            return t6;
        }
        Object obj = this.factory;
        if (obj instanceof ViewModelProvider.OnRequeryFactory) {
            Intrinsics.checkNotNull(t5);
            ((ViewModelProvider.OnRequeryFactory) obj).onRequery(t5);
        }
        Intrinsics.checkNotNull(t5, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
        return t5;
    }
}
