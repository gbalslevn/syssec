package com.ramcosta.composedestinations.result;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.ramcosta.composedestinations.result.NavResult;
import com.ramcosta.composedestinations.result.OpenResultRecipient;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"onResult", BuildConfig.FLAVOR, "R", "Lcom/ramcosta/composedestinations/result/OpenResultRecipient;", "onCancelled", "Lkotlin/Function0;", "onValue", "Lkotlin/Function1;", "(Lcom/ramcosta/composedestinations/result/OpenResultRecipient;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OpenResultRecipientKt {
    public static final <R> void onResult(final OpenResultRecipient<R> openResultRecipient, final Function0<Unit> function0, final Function1<? super R, Unit> onValue, Composer composer, final int i5, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(openResultRecipient, "<this>");
        Intrinsics.checkNotNullParameter(onValue, "onValue");
        Composer startRestartGroup = composer.startRestartGroup(2093725632);
        if ((Integer.MIN_VALUE & i6) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(openResultRecipient) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i6 & 2) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onValue) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                startRestartGroup.startReplaceGroup(115390541);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: h1.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                function0 = (Function0) rememberedValue;
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2093725632, i7, -1, "com.ramcosta.composedestinations.result.onResult (OpenResultRecipient.kt:72)");
            }
            startRestartGroup.startReplaceGroup(115393143);
            boolean z5 = ((i7 & 896) == 256) | ((i7 & 112) == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: h1.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit onResult$lambda$3$lambda$2;
                        onResult$lambda$3$lambda$2 = OpenResultRecipientKt.onResult$lambda$3$lambda$2(Function0.this, onValue, (NavResult) obj);
                        return onResult$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            openResultRecipient.onNavResult((Function1) rememberedValue2, startRestartGroup, (i7 << 3) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Function0<Unit> function02 = function0;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h1.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onResult$lambda$4;
                    onResult$lambda$4 = OpenResultRecipientKt.onResult$lambda$4(OpenResultRecipient.this, function02, onValue, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return onResult$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResult$lambda$3$lambda$2(Function0 function0, Function1 function1, NavResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it, NavResult.Canceled.INSTANCE)) {
            function0.invoke();
        } else {
            if (!(it instanceof NavResult.Value)) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(((NavResult.Value) it).getValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResult$lambda$4(OpenResultRecipient openResultRecipient, Function0 function0, Function1 function1, int i5, int i6, Composer composer, int i7) {
        onResult(openResultRecipient, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
