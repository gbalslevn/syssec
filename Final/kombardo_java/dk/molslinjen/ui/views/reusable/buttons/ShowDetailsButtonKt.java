package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aC\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "showText", "hideText", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", BuildConfig.FLAVOR, "isExpanded", "ShowDetailsButton", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ShowDetailsButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ShowDetailsButton(Modifier modifier, String str, String str2, final Function0<Unit> onClick, final boolean z5, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        String str3;
        String str4;
        String str5;
        Modifier modifier3;
        String str6;
        String stringResource;
        Composer composer2;
        final Modifier modifier4;
        final String str7;
        final String str8;
        int i8;
        int i9;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1079553725);
        int i10 = i6 & 1;
        if (i10 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            if ((i6 & 2) == 0) {
                str3 = str;
                if (startRestartGroup.changed(str3)) {
                    i9 = 32;
                    i7 |= i9;
                }
            } else {
                str3 = str;
            }
            i9 = 16;
            i7 |= i9;
        } else {
            str3 = str;
        }
        if ((i5 & 384) == 0) {
            if ((i6 & 4) == 0) {
                str4 = str2;
                if (startRestartGroup.changed(str4)) {
                    i8 = 256;
                    i7 |= i8;
                }
            } else {
                str4 = str2;
            }
            i8 = 128;
            i7 |= i8;
        } else {
            str4 = str2;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 16384 : 8192;
        }
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            str7 = str3;
            str8 = str4;
            composer2 = startRestartGroup;
        } else {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                Modifier modifier5 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i6 & 2) != 0) {
                    str5 = StringResources_androidKt.stringResource(R.string.button_showDetails, startRestartGroup, 6);
                    i7 &= -113;
                } else {
                    str5 = str3;
                }
                if ((i6 & 4) != 0) {
                    i7 &= -897;
                    modifier3 = modifier5;
                    str6 = str5;
                    stringResource = StringResources_androidKt.stringResource(R.string.button_hideDetails, startRestartGroup, 6);
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1079553725, i7, -1, "dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButton (ShowDetailsButton.kt:21)");
                    }
                    final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(!z5 ? 0.0f : 180.0f, null, 0.0f, null, null, startRestartGroup, 0, 30);
                    composer2 = startRestartGroup;
                    TertiaryButtonKt.TertiaryButton(modifier3, !z5 ? stringResource : str6, onClick, null, ComposableLambdaKt.rememberComposableLambda(-946444070, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButtonKt$ShowDetailsButton$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                            invoke(rowScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TertiaryButton, Composer composer3, int i11) {
                            Intrinsics.checkNotNullParameter(TertiaryButton, "$this$TertiaryButton");
                            if ((i11 & 6) == 0) {
                                i11 |= composer3.changed(TertiaryButton) ? 4 : 2;
                            }
                            if ((i11 & 19) == 18 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-946444070, i11, -1, "dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButton.<anonymous> (ShowDetailsButton.kt:29)");
                            }
                            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_chevron_up, composer3, 6), Accessibility.INSTANCE.getSkip(), RotateKt.rotate(TertiaryButton.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()), animateFloatAsState.getValue().floatValue()), 0L, composer3, 0, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i7 & 14) | 24576 | ((i7 >> 3) & 896), 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                    str7 = str6;
                    str8 = stringResource;
                } else {
                    modifier3 = modifier5;
                    str6 = str5;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i6 & 2) != 0) {
                    i7 &= -113;
                }
                if ((i6 & 4) != 0) {
                    i7 &= -897;
                }
                modifier3 = modifier2;
                str6 = str3;
            }
            stringResource = str4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!z5 ? 0.0f : 180.0f, null, 0.0f, null, null, startRestartGroup, 0, 30);
            if (!z5) {
            }
            composer2 = startRestartGroup;
            TertiaryButtonKt.TertiaryButton(modifier3, !z5 ? stringResource : str6, onClick, null, ComposableLambdaKt.rememberComposableLambda(-946444070, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButtonKt$ShowDetailsButton$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                    invoke(rowScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TertiaryButton, Composer composer3, int i11) {
                    Intrinsics.checkNotNullParameter(TertiaryButton, "$this$TertiaryButton");
                    if ((i11 & 6) == 0) {
                        i11 |= composer3.changed(TertiaryButton) ? 4 : 2;
                    }
                    if ((i11 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-946444070, i11, -1, "dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButton.<anonymous> (ShowDetailsButton.kt:29)");
                    }
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_chevron_up, composer3, 6), Accessibility.INSTANCE.getSkip(), RotateKt.rotate(TertiaryButton.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterVertically()), animateFloatAsState2.getValue().floatValue()), 0L, composer3, 0, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i7 & 14) | 24576 | ((i7 >> 3) & 896), 8);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            str7 = str6;
            str8 = stringResource;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z1.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShowDetailsButton$lambda$0;
                    ShowDetailsButton$lambda$0 = ShowDetailsButtonKt.ShowDetailsButton$lambda$0(Modifier.this, str7, str8, onClick, z5, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ShowDetailsButton$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowDetailsButton$lambda$0(Modifier modifier, String str, String str2, Function0 function0, boolean z5, int i5, int i6, Composer composer, int i7) {
        ShowDetailsButton(modifier, str, str2, function0, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
