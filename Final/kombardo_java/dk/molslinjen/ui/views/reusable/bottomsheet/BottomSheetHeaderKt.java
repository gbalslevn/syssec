package dk.molslinjen.ui.views.reusable.bottomsheet;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetHeaderKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aU\u0010\u000e\u001a\u00020\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aC\u0010\u0019\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", Constants.IntentExtra.PushTitle, "Ldk/molslinjen/ui/views/reusable/bottomsheet/BottomSheetTitleStyle;", "titleStyle", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onBackAction", "onCloseAction", "BottomSheetHeader-uKGX-YA", "(Landroidx/compose/ui/text/AnnotatedString;Ldk/molslinjen/ui/views/reusable/bottomsheet/BottomSheetTitleStyle;JFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "BottomSheetHeader", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/ui/Modifier;", "modifier", "style", "missingIconSpacing", BuildConfig.FLAVOR, "isShowingBackAction", "isShowingCloseAction", "TitleView-WH-ejsw", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Ldk/molslinjen/ui/views/reusable/bottomsheet/BottomSheetTitleStyle;FZZLandroidx/compose/runtime/Composer;I)V", "TitleView", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BottomSheetHeaderKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetTitleStyle.values().length];
            try {
                iArr[BottomSheetTitleStyle.Standard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomSheetTitleStyle.Stepper.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0069  */
    /* renamed from: BottomSheetHeader-uKGX-YA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3400BottomSheetHeaderuKGXYA(final AnnotatedString annotatedString, final BottomSheetTitleStyle titleStyle, long j5, float f5, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i5, final int i6) {
        int i7;
        long j6;
        int i8;
        float f6;
        int i9;
        Object rememberedValue;
        Composer composer2;
        final long j7;
        final float f7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(titleStyle, "titleStyle");
        Composer startRestartGroup = composer.startRestartGroup(-2146646400);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(titleStyle) ? 32 : 16;
        }
        int i10 = i6 & 4;
        if (i10 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            j6 = j5;
            i7 |= startRestartGroup.changed(j6) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                f6 = f5;
                i7 |= startRestartGroup.changed(f6) ? 2048 : 1024;
                if ((i6 & 16) != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
                }
                if ((i6 & 32) != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
                }
                i9 = i7;
                if ((74899 & i9) == 74898 || !startRestartGroup.getSkipping()) {
                    long m3281getWhite0d7_KjU = i10 != 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j6;
                    float m2599constructorimpl = i8 != 0 ? Dp.m2599constructorimpl(0) : f6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2146646400, i9, -1, "dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetHeader (BottomSheetHeader.kt:42)");
                    }
                    float m2599constructorimpl2 = Dp.m2599constructorimpl(30);
                    float m2599constructorimpl3 = Dp.m2599constructorimpl(16);
                    Modifier zIndex = ZIndexModifierKt.zIndex(Modifier.INSTANCE, 2.0f);
                    boolean z5 = titleStyle == BottomSheetTitleStyle.Standard;
                    startRestartGroup.startReplaceGroup(-1640986447);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1() { // from class: Y1.l
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Modifier BottomSheetHeader_uKGX_YA$lambda$2$lambda$1;
                                BottomSheetHeader_uKGX_YA$lambda$2$lambda$1 = BottomSheetHeaderKt.BottomSheetHeader_uKGX_YA$lambda$2$lambda$1((Modifier) obj);
                                return BottomSheetHeader_uKGX_YA$lambda$2$lambda$1;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                    SurfaceKt.m900SurfaceT9BRK9s(ModifierExtensionsKt.applyIf(zIndex, z5, (Function1) rememberedValue), null, 0L, 0L, 0.0f, m2599constructorimpl, null, ComposableLambdaKt.rememberComposableLambda(702065755, true, new BottomSheetHeaderKt$BottomSheetHeader$2(m3281getWhite0d7_KjU, m2599constructorimpl2, function0, function02, m2599constructorimpl3, annotatedString, titleStyle), startRestartGroup, 54), composer2, (458752 & (i9 << 6)) | 12582912, 94);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j7 = m3281getWhite0d7_KjU;
                    f7 = m2599constructorimpl;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    j7 = j6;
                    f7 = f6;
                    composer2 = startRestartGroup;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: Y1.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BottomSheetHeader_uKGX_YA$lambda$3;
                            BottomSheetHeader_uKGX_YA$lambda$3 = BottomSheetHeaderKt.BottomSheetHeader_uKGX_YA$lambda$3(AnnotatedString.this, titleStyle, j7, f7, function0, function02, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return BottomSheetHeader_uKGX_YA$lambda$3;
                        }
                    });
                    return;
                }
                return;
            }
            f6 = f5;
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            i9 = i7;
            if ((74899 & i9) == 74898) {
            }
            if (i10 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            float m2599constructorimpl22 = Dp.m2599constructorimpl(30);
            float m2599constructorimpl32 = Dp.m2599constructorimpl(16);
            Modifier zIndex2 = ZIndexModifierKt.zIndex(Modifier.INSTANCE, 2.0f);
            if (titleStyle == BottomSheetTitleStyle.Standard) {
            }
            startRestartGroup.startReplaceGroup(-1640986447);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            SurfaceKt.m900SurfaceT9BRK9s(ModifierExtensionsKt.applyIf(zIndex2, z5, (Function1) rememberedValue), null, 0L, 0L, 0.0f, m2599constructorimpl, null, ComposableLambdaKt.rememberComposableLambda(702065755, true, new BottomSheetHeaderKt$BottomSheetHeader$2(m3281getWhite0d7_KjU, m2599constructorimpl22, function0, function02, m2599constructorimpl32, annotatedString, titleStyle), startRestartGroup, 54), composer2, (458752 & (i9 << 6)) | 12582912, 94);
            if (ComposerKt.isTraceInProgress()) {
            }
            j7 = m3281getWhite0d7_KjU;
            f7 = m2599constructorimpl;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        j6 = j5;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        f6 = f5;
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        i9 = i7;
        if ((74899 & i9) == 74898) {
        }
        if (i10 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float m2599constructorimpl222 = Dp.m2599constructorimpl(30);
        float m2599constructorimpl322 = Dp.m2599constructorimpl(16);
        Modifier zIndex22 = ZIndexModifierKt.zIndex(Modifier.INSTANCE, 2.0f);
        if (titleStyle == BottomSheetTitleStyle.Standard) {
        }
        startRestartGroup.startReplaceGroup(-1640986447);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        composer2 = startRestartGroup;
        SurfaceKt.m900SurfaceT9BRK9s(ModifierExtensionsKt.applyIf(zIndex22, z5, (Function1) rememberedValue), null, 0L, 0L, 0.0f, m2599constructorimpl, null, ComposableLambdaKt.rememberComposableLambda(702065755, true, new BottomSheetHeaderKt$BottomSheetHeader$2(m3281getWhite0d7_KjU, m2599constructorimpl222, function0, function02, m2599constructorimpl322, annotatedString, titleStyle), startRestartGroup, 54), composer2, (458752 & (i9 << 6)) | 12582912, 94);
        if (ComposerKt.isTraceInProgress()) {
        }
        j7 = m3281getWhite0d7_KjU;
        f7 = m2599constructorimpl;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier BottomSheetHeader_uKGX_YA$lambda$2$lambda$1(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SemanticsModifierKt.semantics$default(applyIf, false, new Function1() { // from class: Y1.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit BottomSheetHeader_uKGX_YA$lambda$2$lambda$1$lambda$0;
                BottomSheetHeader_uKGX_YA$lambda$2$lambda$1$lambda$0 = BottomSheetHeaderKt.BottomSheetHeader_uKGX_YA$lambda$2$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                return BottomSheetHeader_uKGX_YA$lambda$2$lambda$1$lambda$0;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetHeader_uKGX_YA$lambda$2$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -100.0f);
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetHeader_uKGX_YA$lambda$3(AnnotatedString annotatedString, BottomSheetTitleStyle bottomSheetTitleStyle, long j5, float f5, Function0 function0, Function0 function02, int i5, int i6, Composer composer, int i7) {
        m3400BottomSheetHeaderuKGXYA(annotatedString, bottomSheetTitleStyle, j5, f5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TitleView-WH-ejsw, reason: not valid java name */
    public static final void m3401TitleViewWHejsw(final RowScope rowScope, final Modifier modifier, final AnnotatedString annotatedString, final BottomSheetTitleStyle bottomSheetTitleStyle, final float f5, final boolean z5, final boolean z6, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-2037913670);
        if ((i5 & 48) == 0) {
            i6 = (startRestartGroup.changed(modifier) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(annotatedString) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(bottomSheetTitleStyle) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(f5) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
        }
        if ((599185 & i6) == 599184 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2037913670, i6, -1, "dk.molslinjen.ui.views.reusable.bottomsheet.TitleView (BottomSheetHeader.kt:114)");
            }
            int i7 = WhenMappings.$EnumSwitchMapping$0[bottomSheetTitleStyle.ordinal()];
            if (i7 == 1) {
                startRestartGroup.startReplaceGroup(-109386337);
                composer2 = startRestartGroup;
                TextKt.m941TextIbK3jfQ(annotatedString, modifier, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getH2Bold(), composer2, ((i6 >> 6) & 14) | (i6 & 112), 12582912, 131068);
                composer2.endReplaceGroup();
            } else {
                if (i7 != 2) {
                    startRestartGroup.startReplaceGroup(-1527550468);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(-109231275);
                TextKt.m941TextIbK3jfQ(annotatedString, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, z5 ? Dp.m2599constructorimpl(0) : f5, 0.0f, z6 ? Dp.m2599constructorimpl(0) : f5, 0.0f, 10, null).then(modifier), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, TypographyKt.getParagraphSmall(), startRestartGroup, ((i6 >> 6) & 14) | 384, 12582912, 130552);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Y1.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TitleView_WH_ejsw$lambda$4;
                    TitleView_WH_ejsw$lambda$4 = BottomSheetHeaderKt.TitleView_WH_ejsw$lambda$4(RowScope.this, modifier, annotatedString, bottomSheetTitleStyle, f5, z5, z6, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TitleView_WH_ejsw$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitleView_WH_ejsw$lambda$4(RowScope rowScope, Modifier modifier, AnnotatedString annotatedString, BottomSheetTitleStyle bottomSheetTitleStyle, float f5, boolean z5, boolean z6, int i5, Composer composer, int i6) {
        m3401TitleViewWHejsw(rowScope, modifier, annotatedString, bottomSheetTitleStyle, f5, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
