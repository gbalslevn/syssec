package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.ui.views.reusable.buttons.BaseButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a»\u0001\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00132\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006!²\u0006\u000e\u0010 \u001a\u0004\u0018\u00010\u001f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "text", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "onClickDisabled", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle;", "style", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;", "buttonConfig", BuildConfig.FLAVOR, "isLoading", "enabled", "Landroidx/compose/foundation/BorderStroke;", "border", "Landroidx/compose/ui/graphics/Shape;", "shape", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "leftContent", "rightContent", "clearFocusOnClick", "autoShrinkText", "BaseButton", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/buttons/ButtonStyle;Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;ZZLandroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ZZLandroidx/compose/runtime/Composer;III)V", BuildConfig.FLAVOR, "iconRes", "getBaseButtonIconComposable", "(Ljava/lang/Integer;)Lkotlin/jvm/functions/Function3;", "Lcom/airbnb/lottie/LottieComposition;", "spinnerAnimation", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BaseButton(final Modifier modifier, final String text, final Function0<Unit> onClick, final Function0<Unit> function0, final ButtonStyle style, final ButtonConfig buttonConfig, boolean z5, boolean z6, BorderStroke borderStroke, Shape shape, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, boolean z7, boolean z8, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Shape shape2;
        boolean z9;
        BorderStroke borderStroke2;
        boolean z10;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        boolean z11;
        Shape shape3;
        boolean z12;
        Composer composer2;
        final boolean z13;
        final boolean z14;
        final BorderStroke borderStroke3;
        final Shape shape4;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function35;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function36;
        final boolean z15;
        final boolean z16;
        ScopeUpdateScope endRestartGroup;
        int i17;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(buttonConfig, "buttonConfig");
        Composer startRestartGroup = composer.startRestartGroup(2073274008);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
            if ((i7 & 16) == 0) {
                i8 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i8 |= startRestartGroup.changed(style) ? 16384 : 8192;
            }
            if ((i7 & 32) == 0) {
                i8 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i8 |= startRestartGroup.changed(buttonConfig) ? 131072 : 65536;
            }
            i9 = i7 & 64;
            if (i9 == 0) {
                i8 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i8 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
            }
            i10 = i7 & 128;
            if (i10 == 0) {
                i8 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i8 |= startRestartGroup.changed(z6) ? 8388608 : 4194304;
            }
            i11 = i7 & 256;
            if (i11 == 0) {
                i8 |= 100663296;
            } else if ((i5 & 100663296) == 0) {
                i8 |= startRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
            }
            if ((i5 & 805306368) == 0) {
                if ((i7 & 512) == 0 && startRestartGroup.changed(shape)) {
                    i17 = 536870912;
                    i8 |= i17;
                }
                i17 = 268435456;
                i8 |= i17;
            }
            i12 = i7 & 1024;
            if (i12 == 0) {
                i13 = i6 | 6;
            } else if ((i6 & 6) == 0) {
                i13 = i6 | (startRestartGroup.changedInstance(function3) ? 4 : 2);
            } else {
                i13 = i6;
            }
            i14 = i7 & 2048;
            if (i14 == 0) {
                i13 |= 48;
            } else if ((i6 & 48) == 0) {
                i13 |= startRestartGroup.changedInstance(function32) ? 32 : 16;
            }
            int i18 = i13;
            i15 = i7 & 4096;
            if (i15 == 0) {
                i18 |= 384;
            } else if ((i6 & 384) == 0) {
                i18 |= startRestartGroup.changed(z7) ? 256 : 128;
                i16 = i7 & 8192;
                if (i16 != 0) {
                    i18 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i18 |= startRestartGroup.changed(z8) ? 2048 : 1024;
                    if ((i8 & 306783379) != 306783378 && (i18 & 1171) == 1170 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        z14 = z6;
                        borderStroke3 = borderStroke;
                        shape4 = shape;
                        function35 = function3;
                        function36 = function32;
                        z15 = z7;
                        z16 = z8;
                        composer2 = startRestartGroup;
                        z13 = z5;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            boolean z17 = i9 == 0 ? false : z5;
                            boolean z18 = i10 == 0 ? true : z6;
                            BorderStroke borderStroke4 = i11 == 0 ? null : borderStroke;
                            if ((i7 & 512) == 0) {
                                shape2 = ButtonDefaults.INSTANCE.getShape(startRestartGroup, ButtonDefaults.$stable);
                                i8 &= -1879048193;
                            } else {
                                shape2 = shape;
                            }
                            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function37 = i12 == 0 ? null : function3;
                            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function38 = i14 == 0 ? null : function32;
                            boolean z19 = i15 == 0 ? true : z7;
                            if (i16 == 0) {
                                borderStroke2 = borderStroke4;
                                z10 = z17;
                                function33 = function37;
                                function34 = function38;
                                z11 = z18;
                                shape3 = shape2;
                                z12 = z19;
                                z9 = true;
                            } else {
                                z9 = z8;
                                borderStroke2 = borderStroke4;
                                z10 = z17;
                                function33 = function37;
                                function34 = function38;
                                z11 = z18;
                                shape3 = shape2;
                                z12 = z19;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i7 & 512) != 0) {
                                i8 &= -1879048193;
                            }
                            z10 = z5;
                            z11 = z6;
                            borderStroke2 = borderStroke;
                            shape3 = shape;
                            function33 = function3;
                            function34 = function32;
                            z12 = z7;
                            z9 = z8;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2073274008, i8, i18, "dk.molslinjen.ui.views.reusable.buttons.BaseButton (BaseButton.kt:52)");
                        }
                        composer2 = startRestartGroup;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(style.getRipple())}, ComposableLambdaKt.rememberComposableLambda(-1556362792, true, new BaseButtonKt$BaseButton$1(modifier, buttonConfig, z11, function0, style, z12, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()), z10, onClick, shape3, borderStroke2, function33, text, z9, function34), composer2, 54), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z13 = z10;
                        z14 = z11;
                        borderStroke3 = borderStroke2;
                        shape4 = shape3;
                        function35 = function33;
                        function36 = function34;
                        z15 = z12;
                        z16 = z9;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: Z1.a
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit BaseButton$lambda$0;
                                BaseButton$lambda$0 = BaseButtonKt.BaseButton$lambda$0(Modifier.this, text, onClick, function0, style, buttonConfig, z13, z14, borderStroke3, shape4, function35, function36, z15, z16, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return BaseButton$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i8 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if ((i7 & 512) == 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(style.getRipple())}, ComposableLambdaKt.rememberComposableLambda(-1556362792, true, new BaseButtonKt$BaseButton$1(modifier, buttonConfig, z11, function0, style, z12, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()), z10, onClick, shape3, borderStroke2, function33, text, z9, function34), composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                z13 = z10;
                z14 = z11;
                borderStroke3 = borderStroke2;
                shape4 = shape3;
                function35 = function33;
                function36 = function34;
                z15 = z12;
                z16 = z9;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i16 = i7 & 8192;
            if (i16 != 0) {
            }
            if ((i8 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if ((i7 & 512) == 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(style.getRipple())}, ComposableLambdaKt.rememberComposableLambda(-1556362792, true, new BaseButtonKt$BaseButton$1(modifier, buttonConfig, z11, function0, style, z12, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()), z10, onClick, shape3, borderStroke2, function33, text, z9, function34), composer2, 54), composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            z13 = z10;
            z14 = z11;
            borderStroke3 = borderStroke2;
            shape4 = shape3;
            function35 = function33;
            function36 = function34;
            z15 = z12;
            z16 = z9;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i7 & 16) == 0) {
        }
        if ((i7 & 32) == 0) {
        }
        i9 = i7 & 64;
        if (i9 == 0) {
        }
        i10 = i7 & 128;
        if (i10 == 0) {
        }
        i11 = i7 & 256;
        if (i11 == 0) {
        }
        if ((i5 & 805306368) == 0) {
        }
        i12 = i7 & 1024;
        if (i12 == 0) {
        }
        i14 = i7 & 2048;
        if (i14 == 0) {
        }
        int i182 = i13;
        i15 = i7 & 4096;
        if (i15 == 0) {
        }
        i16 = i7 & 8192;
        if (i16 != 0) {
        }
        if ((i8 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if ((i7 & 512) == 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(style.getRipple())}, ComposableLambdaKt.rememberComposableLambda(-1556362792, true, new BaseButtonKt$BaseButton$1(modifier, buttonConfig, z11, function0, style, z12, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()), z10, onClick, shape3, borderStroke2, function33, text, z9, function34), composer2, 54), composer2, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        z13 = z10;
        z14 = z11;
        borderStroke3 = borderStroke2;
        shape4 = shape3;
        function35 = function33;
        function36 = function34;
        z15 = z12;
        z16 = z9;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BaseButton$lambda$0(Modifier modifier, String str, Function0 function0, Function0 function02, ButtonStyle buttonStyle, ButtonConfig buttonConfig, boolean z5, boolean z6, BorderStroke borderStroke, Shape shape, Function3 function3, Function3 function32, boolean z7, boolean z8, int i5, int i6, int i7, Composer composer, int i8) {
        BaseButton(modifier, str, function0, function02, buttonStyle, buttonConfig, z5, z6, borderStroke, shape, function3, function32, z7, z8, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }

    public static final Function3<RowScope, Composer, Integer, Unit> getBaseButtonIconComposable(final Integer num) {
        if (num != null) {
            return ComposableLambdaKt.composableLambdaInstance(-2147095286, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.buttons.BaseButtonKt$getBaseButtonIconComposable$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num2) {
                    invoke(rowScope, composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope let, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(let, "$this$let");
                    if ((i5 & 6) == 0) {
                        i5 |= composer.changed(let) ? 4 : 2;
                    }
                    if ((i5 & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2147095286, i5, -1, "dk.molslinjen.ui.views.reusable.buttons.getBaseButtonIconComposable.<anonymous>.<anonymous> (BaseButton.kt:109)");
                    }
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(num.intValue(), composer, 0), Accessibility.INSTANCE.getSkip(), let.align(SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(14)), Alignment.INSTANCE.getCenterVertically()), 0L, composer, 0, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
        }
        return null;
    }
}
