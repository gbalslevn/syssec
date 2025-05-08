package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.PlatformMagnifierFactory;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager_androidKt$textFieldMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ TextFieldSelectionManager $manager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager_androidKt$textFieldMagnifier$1(TextFieldSelectionManager textFieldSelectionManager) {
        super(3);
        this.$manager = textFieldSelectionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invoke$lambda$1(MutableState<IntSize> mutableState) {
        return mutableState.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<IntSize> mutableState, long j5) {
        mutableState.setValue(IntSize.m2656boximpl(j5));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
        return invoke(modifier, composer, num.intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i5) {
        composer.startReplaceGroup(1980580247);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1980580247, i5, -1, "androidx.compose.foundation.text.selection.textFieldMagnifier.<anonymous> (TextFieldSelectionManager.android.kt:48)");
        }
        final Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m2656boximpl(IntSize.INSTANCE.m2665getZeroYbymL2g()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        boolean changedInstance = composer.changedInstance(this.$manager);
        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0<Offset>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m1328boximpl(m650invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m650invokeF1C5BW0() {
                    long invoke$lambda$1;
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    invoke$lambda$1 = TextFieldSelectionManager_androidKt$textFieldMagnifier$1.invoke$lambda$1(mutableState);
                    return TextFieldSelectionManagerKt.m649calculateSelectionMagnifierCenterAndroidO0kMr_c(textFieldSelectionManager2, invoke$lambda$1);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        Function0 function0 = (Function0) rememberedValue2;
        boolean changed = composer.changed(density);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function1<Function0<? extends Offset>, Modifier>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Modifier invoke(Function0<? extends Offset> function02) {
                    return invoke2((Function0<Offset>) function02);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Modifier invoke2(final Function0<Offset> function02) {
                    Modifier m143magnifierjPUL71Q;
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    Function1<Density, Offset> function1 = new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Offset invoke(Density density2) {
                            return Offset.m1328boximpl(m651invoketuRUvjQ(density2));
                        }

                        /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
                        public final long m651invoketuRUvjQ(Density density2) {
                            return function02.invoke().getPackedValue();
                        }
                    };
                    final Density density2 = Density.this;
                    final MutableState<IntSize> mutableState2 = mutableState;
                    m143magnifierjPUL71Q = Magnifier_androidKt.m143magnifierjPUL71Q(companion2, function1, (r23 & 2) != 0 ? null : null, (r23 & 4) != 0 ? null : new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$textFieldMagnifier$1$2$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DpSize dpSize) {
                            m652invokeEaSLcWc(dpSize.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-EaSLcWc, reason: not valid java name */
                        public final void m652invokeEaSLcWc(long j5) {
                            MutableState<IntSize> mutableState3 = mutableState2;
                            Density density3 = Density.this;
                            TextFieldSelectionManager_androidKt$textFieldMagnifier$1.invoke$lambda$2(mutableState3, IntSizeKt.IntSize(density3.mo206roundToPx0680j_4(DpSize.m2626getWidthD9Ej5fM(j5)), density3.mo206roundToPx0680j_4(DpSize.m2625getHeightD9Ej5fM(j5))));
                        }
                    }, (r23 & 8) != 0 ? Float.NaN : 0.0f, (r23 & 16) != 0 ? false : true, (r23 & 32) != 0 ? DpSize.INSTANCE.m2630getUnspecifiedMYxV2XQ() : 0L, (r23 & 64) != 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : 0.0f, (r23 & 128) != 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : 0.0f, (r23 & 256) != 0, (r23 & 512) == 0 ? PlatformMagnifierFactory.INSTANCE.getForCurrentPlatform() : null);
                    return m143magnifierjPUL71Q;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        Modifier animatedSelectionMagnifier = SelectionMagnifierKt.animatedSelectionMagnifier(modifier, function0, (Function1) rememberedValue3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return animatedSelectionMagnifier;
    }
}
