package com.ramcosta.composedestinations.wrapper;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.ramcosta.composedestinations.scope.DestinationScope;
import com.ramcosta.composedestinations.wrapper.DestinationWrapperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a-\u0010\u0006\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a9\u0010\u0006\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\"\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\n\u001a=\u0010\r\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00002\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ramcosta/composedestinations/scope/DestinationScope;", "Lcom/ramcosta/composedestinations/wrapper/DestinationWrapper;", "wrapper", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "Wrap", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;Lcom/ramcosta/composedestinations/wrapper/DestinationWrapper;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "wrappers", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;[Lcom/ramcosta/composedestinations/wrapper/DestinationWrapper;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "idx", "WrapRecursively", "(Lcom/ramcosta/composedestinations/scope/DestinationScope;[Lcom/ramcosta/composedestinations/wrapper/DestinationWrapper;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationWrapperKt {
    public static final void Wrap(final DestinationScope<?> destinationScope, final DestinationWrapper wrapper, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-575996620);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(destinationScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(wrapper) : startRestartGroup.changedInstance(wrapper) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-575996620, i6, -1, "com.ramcosta.composedestinations.wrapper.Wrap (DestinationWrapper.kt:61)");
            }
            wrapper.Wrap(destinationScope, ComposableLambdaKt.rememberComposableLambda(-1102108252, true, new Function2<Composer, Integer, Unit>() { // from class: com.ramcosta.composedestinations.wrapper.DestinationWrapperKt$Wrap$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1102108252, i7, -1, "com.ramcosta.composedestinations.wrapper.Wrap.<anonymous>.<anonymous> (DestinationWrapper.kt:63)");
                    }
                    content.invoke(composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i6 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k1.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Wrap$lambda$1;
                    Wrap$lambda$1 = DestinationWrapperKt.Wrap$lambda$1(DestinationScope.this, wrapper, content, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Wrap$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Wrap$lambda$1(DestinationScope destinationScope, DestinationWrapper destinationWrapper, Function2 function2, int i5, Composer composer, int i6) {
        Wrap((DestinationScope<?>) destinationScope, destinationWrapper, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Wrap$lambda$2(DestinationScope destinationScope, DestinationWrapper[] destinationWrapperArr, Function2 function2, int i5, Composer composer, int i6) {
        Wrap((DestinationScope<?>) destinationScope, (DestinationWrapper[]) Arrays.copyOf(destinationWrapperArr, destinationWrapperArr.length), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WrapRecursively(final DestinationScope<?> destinationScope, final DestinationWrapper[] destinationWrapperArr, final int i5, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1275298510);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(destinationScope) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(destinationWrapperArr) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1275298510, i7, -1, "com.ramcosta.composedestinations.wrapper.WrapRecursively (DestinationWrapper.kt:89)");
            }
            destinationWrapperArr[i5].Wrap(destinationScope, ComposableLambdaKt.rememberComposableLambda(-1806806210, true, new Function2<Composer, Integer, Unit>() { // from class: com.ramcosta.composedestinations.wrapper.DestinationWrapperKt$WrapRecursively$1$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    if ((i8 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1806806210, i8, -1, "com.ramcosta.composedestinations.wrapper.WrapRecursively.<anonymous>.<anonymous> (DestinationWrapper.kt:92)");
                    }
                    if (i5 < ArraysKt.getLastIndex(destinationWrapperArr)) {
                        composer2.startReplaceGroup(375388769);
                        DestinationWrapperKt.WrapRecursively(destinationScope, destinationWrapperArr, i5 + 1, function2, composer2, 0);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(375468067);
                        function2.invoke(composer2, 0);
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i7 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k1.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit WrapRecursively$lambda$4;
                    WrapRecursively$lambda$4 = DestinationWrapperKt.WrapRecursively$lambda$4(DestinationScope.this, destinationWrapperArr, i5, function2, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return WrapRecursively$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrapRecursively$lambda$4(DestinationScope destinationScope, DestinationWrapper[] destinationWrapperArr, int i5, Function2 function2, int i6, Composer composer, int i7) {
        WrapRecursively(destinationScope, destinationWrapperArr, i5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    public static final void Wrap(final DestinationScope<?> destinationScope, final DestinationWrapper[] wrappers, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i5) {
        Intrinsics.checkNotNullParameter(destinationScope, "<this>");
        Intrinsics.checkNotNullParameter(wrappers, "wrappers");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(64633352);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changed(destinationScope) ? 4 : 2) | i5 : i5;
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        startRestartGroup.startMovableGroup(229294186, Integer.valueOf(wrappers.length));
        for (DestinationWrapper destinationWrapper : wrappers) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(destinationWrapper) : startRestartGroup.changedInstance(destinationWrapper) ? 32 : 0;
        }
        startRestartGroup.endMovableGroup();
        if ((i6 & 112) == 0) {
            i6 |= 16;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(64633352, i6, -1, "com.ramcosta.composedestinations.wrapper.Wrap (DestinationWrapper.kt:76)");
            }
            if (wrappers.length == 0) {
                startRestartGroup.startReplaceGroup(-1481710974);
                content.invoke(startRestartGroup, Integer.valueOf((i6 >> 6) & 14));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1481679354);
                WrapRecursively(destinationScope, wrappers, 0, content, startRestartGroup, (i6 & 14) | 384 | (i6 & 112) | ((i6 << 3) & 7168));
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Wrap$lambda$2;
                    Wrap$lambda$2 = DestinationWrapperKt.Wrap$lambda$2(DestinationScope.this, wrappers, content, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Wrap$lambda$2;
                }
            });
        }
    }
}
