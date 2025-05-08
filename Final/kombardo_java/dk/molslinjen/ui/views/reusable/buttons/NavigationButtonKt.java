package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"NavigationButton", BuildConfig.FLAVOR, "type", "Ldk/molslinjen/ui/views/reusable/buttons/NavigationButtonType;", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function0;", "(Ldk/molslinjen/ui/views/reusable/buttons/NavigationButtonType;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NavigationButtonKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NavigationButtonType.values().length];
            try {
                iArr[NavigationButtonType.Back.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavigationButtonType.Close.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationButton(final NavigationButtonType type, Modifier modifier, final Function0<Unit> onClick, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        Modifier modifier3;
        boolean z5;
        Object rememberedValue;
        int i8;
        int i9;
        int i10;
        int i11;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1557786769);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(type) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
            }
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                modifier3 = i12 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1557786769, i7, -1, "dk.molslinjen.ui.views.reusable.buttons.NavigationButton (NavigationButton.kt:16)");
                }
                Modifier clip = ClipKt.clip(SizeKt.m331size3ABfNKs(modifier3, Dp.m2599constructorimpl(30)), RoundedCornerShapeKt.getCircleShape());
                startRestartGroup.startReplaceGroup(767180197);
                z5 = (i7 & 896) != 256;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: Z1.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit NavigationButton$lambda$1$lambda$0;
                            NavigationButton$lambda$1$lambda$0 = NavigationButtonKt.NavigationButton$lambda$1$lambda$0(Function0.this);
                            return NavigationButton$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue, 7, null);
                int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                i8 = iArr[type.ordinal()];
                if (i8 != 1) {
                    i9 = R.drawable.icon_back_small;
                } else {
                    if (i8 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i9 = R.drawable.icon_close_circled;
                }
                Painter painterResource = PainterResources_androidKt.painterResource(i9, startRestartGroup, 0);
                i10 = iArr[type.ordinal()];
                if (i10 != 1) {
                    i11 = R.string.accessibilityLabel_back;
                } else {
                    if (i10 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i11 = R.string.button_close;
                }
                IconKt.m857Iconww6aTOc(painterResource, StringResources_androidKt.stringResource(i11, startRestartGroup, 0), m122clickableXHw0xAI$default, Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3072, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                endRestartGroup.updateScope(new Function2() { // from class: Z1.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit NavigationButton$lambda$2;
                        NavigationButton$lambda$2 = NavigationButtonKt.NavigationButton$lambda$2(NavigationButtonType.this, modifier4, onClick, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return NavigationButton$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i6 & 4) == 0) {
        }
        if ((i7 & 147) == 146) {
        }
        if (i12 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier clip2 = ClipKt.clip(SizeKt.m331size3ABfNKs(modifier3, Dp.m2599constructorimpl(30)), RoundedCornerShapeKt.getCircleShape());
        startRestartGroup.startReplaceGroup(767180197);
        if ((i7 & 896) != 256) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue = new Function0() { // from class: Z1.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit NavigationButton$lambda$1$lambda$0;
                NavigationButton$lambda$1$lambda$0 = NavigationButtonKt.NavigationButton$lambda$1$lambda$0(Function0.this);
                return NavigationButton$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(clip2, false, null, null, (Function0) rememberedValue, 7, null);
        int[] iArr2 = WhenMappings.$EnumSwitchMapping$0;
        i8 = iArr2[type.ordinal()];
        if (i8 != 1) {
        }
        Painter painterResource2 = PainterResources_androidKt.painterResource(i9, startRestartGroup, 0);
        i10 = iArr2[type.ordinal()];
        if (i10 != 1) {
        }
        IconKt.m857Iconww6aTOc(painterResource2, StringResources_androidKt.stringResource(i11, startRestartGroup, 0), m122clickableXHw0xAI$default2, Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3072, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationButton$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationButton$lambda$2(NavigationButtonType navigationButtonType, Modifier modifier, Function0 function0, int i5, int i6, Composer composer, int i7) {
        NavigationButton(navigationButtonType, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
