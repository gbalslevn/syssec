package androidx.view.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.view.result.ActivityResultRegistry;
import androidx.view.result.ActivityResultRegistryOwner;
import androidx.view.result.contract.ActivityResultContract;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", BuildConfig.FLAVOR, "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ActivityResultRegistryKt {
    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(ActivityResultContract<I, O> activityResultContract, Function1<? super O, Unit> function1, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1408504823, i5, -1, "androidx.activity.compose.rememberLauncherForActivityResult (ActivityResultRegistry.kt:82)");
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(activityResultContract, composer, i5 & 14);
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i5 >> 3) & 14);
        String str = (String) RememberSaveableKt.rememberSaveable(new Object[0], null, null, new Function0<String>() { // from class: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return UUID.randomUUID().toString();
            }
        }, composer, 3072, 6);
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
        }
        ActivityResultRegistry activityResultRegistry = current.getActivityResultRegistry();
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new ActivityResultLauncherHolder();
            composer.updateRememberedValue(rememberedValue);
        }
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) rememberedValue;
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new ManagedActivityResultLauncher(activityResultLauncherHolder, rememberUpdatedState);
            composer.updateRememberedValue(rememberedValue2);
        }
        ManagedActivityResultLauncher<I, O> managedActivityResultLauncher = (ManagedActivityResultLauncher) rememberedValue2;
        boolean changedInstance = composer.changedInstance(activityResultLauncherHolder) | composer.changedInstance(activityResultRegistry) | composer.changed(str) | composer.changedInstance(activityResultContract) | composer.changed(rememberUpdatedState2);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == companion.getEmpty()) {
            Object activityResultRegistryKt$rememberLauncherForActivityResult$1$1 = new ActivityResultRegistryKt$rememberLauncherForActivityResult$1$1(activityResultLauncherHolder, activityResultRegistry, str, activityResultContract, rememberUpdatedState2);
            composer.updateRememberedValue(activityResultRegistryKt$rememberLauncherForActivityResult$1$1);
            rememberedValue3 = activityResultRegistryKt$rememberLauncherForActivityResult$1$1;
        }
        EffectsKt.DisposableEffect(activityResultRegistry, str, activityResultContract, (Function1) rememberedValue3, composer, (i5 << 6) & 896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return managedActivityResultLauncher;
    }
}
