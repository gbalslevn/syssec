package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 42\u00020\u0001:\u0003546B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0006H\u0007¢\u0006\u0004\b!\u0010\u001eR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R$\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020%8G@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00100\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u0010,\"\u0004\b2\u00103¨\u00067"}, d2 = {"Landroidx/savedstate/SavedStateRegistry;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "key", "Landroid/os/Bundle;", "consumeRestoredStateForKey", "(Ljava/lang/String;)Landroid/os/Bundle;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "provider", BuildConfig.FLAVOR, "registerSavedStateProvider", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "getSavedStateProvider", "(Ljava/lang/String;)Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "unregisterSavedStateProvider", "(Ljava/lang/String;)V", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "clazz", "runOnNextRecreation", "(Ljava/lang/Class;)V", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "performAttach$savedstate_release", "(Landroidx/lifecycle/Lifecycle;)V", "performAttach", "savedState", "performRestore$savedstate_release", "(Landroid/os/Bundle;)V", "performRestore", "outBundle", "performSave", "Landroidx/arch/core/internal/SafeIterableMap;", "components", "Landroidx/arch/core/internal/SafeIterableMap;", BuildConfig.FLAVOR, "attached", "Z", "restoredState", "Landroid/os/Bundle;", "<set-?>", "isRestored", "()Z", "Landroidx/savedstate/Recreator$SavedStateProvider;", "recreatorProvider", "Landroidx/savedstate/Recreator$SavedStateProvider;", "isAllowingSavingState", "isAllowingSavingState$savedstate_release", "setAllowingSavingState$savedstate_release", "(Z)V", "Companion", "AutoRecreated", "SavedStateProvider", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private final SafeIterableMap<String, SavedStateProvider> components = new SafeIterableMap<>();
    private boolean isAllowingSavingState = true;
    private boolean isRestored;
    private Recreator.SavedStateProvider recreatorProvider;
    private Bundle restoredState;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", BuildConfig.FLAVOR, "onRecreated", BuildConfig.FLAVOR, "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void onRecreated(SavedStateRegistryOwner owner);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$Companion;", BuildConfig.FLAVOR, "()V", "SAVED_COMPONENTS_KEY", BuildConfig.FLAVOR, "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", BuildConfig.FLAVOR, "saveState", "Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performAttach$lambda$4(SavedStateRegistry this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.isAllowingSavingState = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.isAllowingSavingState = false;
        }
    }

    public final Bundle consumeRestoredStateForKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.isRestored) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.restoredState;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.restoredState = null;
        }
        return bundle2;
    }

    public final SavedStateProvider getSavedStateProvider(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.components.iterator();
        while (it.hasNext()) {
            Map.Entry<String, SavedStateProvider> components = it.next();
            Intrinsics.checkNotNullExpressionValue(components, "components");
            String key2 = components.getKey();
            SavedStateProvider value = components.getValue();
            if (Intrinsics.areEqual(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final void performAttach$savedstate_release(Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (this.attached) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: N.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                SavedStateRegistry.performAttach$lambda$4(SavedStateRegistry.this, lifecycleOwner, event);
            }
        });
        this.attached = true;
    }

    public final void performRestore$savedstate_release(Bundle savedState) {
        if (!this.attached) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.isRestored) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.restoredState = savedState != null ? savedState.getBundle(SAVED_COMPONENTS_KEY) : null;
        this.isRestored = true;
    }

    public final void performSave(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap<String, SavedStateProvider>.IteratorWithAdditions iteratorWithAdditions = this.components.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "this.components.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry next = iteratorWithAdditions.next();
            bundle.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).saveState());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle(SAVED_COMPONENTS_KEY, bundle);
    }

    public final void registerSavedStateProvider(String key, SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (this.components.putIfAbsent(key, provider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void runOnNextRecreation(Class<? extends AutoRecreated> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!this.isAllowingSavingState) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.SavedStateProvider savedStateProvider = this.recreatorProvider;
        if (savedStateProvider == null) {
            savedStateProvider = new Recreator.SavedStateProvider(this);
        }
        this.recreatorProvider = savedStateProvider;
        try {
            clazz.getDeclaredConstructor(null);
            Recreator.SavedStateProvider savedStateProvider2 = this.recreatorProvider;
            if (savedStateProvider2 != null) {
                String name = clazz.getName();
                Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
                savedStateProvider2.add(name);
            }
        } catch (NoSuchMethodException e5) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
        }
    }

    public final void unregisterSavedStateProvider(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.components.remove(key);
    }
}
