package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a½\u0001\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aq\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00132\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\rH\u0003¢\u0006\u0004\b\"\u0010#\u001a/\u0010$\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b$\u0010%\u001a7\u0010)\u001a\u00020\u000e2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0001\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\tH\u0003¢\u0006\u0004\b)\u0010*¨\u0006.²\u0006\u000e\u0010+\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010-\u001a\u00020,8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "count", "minFirstStep", "minLimit", "maxLimit", "Ldk/molslinjen/ui/views/reusable/input/PluralText;", "text", BuildConfig.FLAVOR, "label", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "price", "Lkotlin/Function1;", BuildConfig.FLAVOR, "decreaseOnClick", "increaseOnClick", "Ldk/molslinjen/ui/views/reusable/input/NumberSelectorHeight;", "tickerHeight", BuildConfig.FLAVOR, "fillMaxWidth", "fixedSize", "enabled", "editableWithKeyboard", "NumberSelector", "(Landroidx/compose/ui/Modifier;IIIILdk/molslinjen/ui/views/reusable/input/PluralText;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/NumberSelectorHeight;ZZZZLandroidx/compose/runtime/Composer;III)V", "value", "postfix", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "onQuantityChanged", "Lkotlin/Function0;", "onImeKeyAction", "onFocusChanged", "NumberSelectorTextField", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "getValidCount", "(IIII)I", "onClick", "icon", "accessibilityLabel", "IncrementalButton", "(Lkotlin/jvm/functions/Function0;ZILjava/lang/String;Landroidx/compose/runtime/Composer;I)V", "focused", "Ldk/molslinjen/ui/views/reusable/input/NumberSelectorTextFocusedState;", "textThatJustGotFocus", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NumberSelectorKt {
    private static final void IncrementalButton(final Function0<Unit> function0, final boolean z5, final int i5, final String str, Composer composer, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-200352517);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        int i8 = i7;
        if ((i8 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-200352517, i8, -1, "dk.molslinjen.ui.views.reusable.input.IncrementalButton (NumberSelector.kt:320)");
            }
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(1884713902);
            boolean z6 = (i8 & 7168) == 2048;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: c2.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit IncrementalButton$lambda$25$lambda$24;
                        IncrementalButton$lambda$25$lambda$24 = NumberSelectorKt.IncrementalButton$lambda$25$lambda$24(str, (SemanticsPropertyReceiver) obj);
                        return IncrementalButton$lambda$25$lambda$24;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(fillMaxHeight$default, false, (Function1) rememberedValue, 1, null);
            IconButtonDefaults iconButtonDefaults = IconButtonDefaults.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            IconButtonKt.IconButton(function0, semantics$default, z5, iconButtonDefaults.m856iconButtonColorsro_MJ88(0L, appColor.m3264getGrey10d7_KjU(), 0L, appColor.m3268getGrey50d7_KjU(), startRestartGroup, (IconButtonDefaults.$stable << 12) | 3120, 5), null, ComposableLambdaKt.rememberComposableLambda(-922277890, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.NumberSelectorKt$IncrementalButton$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    if ((i9 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-922277890, i9, -1, "dk.molslinjen.ui.views.reusable.input.IncrementalButton.<anonymous> (NumberSelector.kt:332)");
                    }
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, composer2, 0), Accessibility.INSTANCE.getSkip(), (Modifier) null, 0L, composer2, 0, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i8 & 14) | 196608 | ((i8 << 3) & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: c2.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IncrementalButton$lambda$26;
                    IncrementalButton$lambda$26 = NumberSelectorKt.IncrementalButton$lambda$26(Function0.this, z5, i5, str, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return IncrementalButton$lambda$26;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IncrementalButton$lambda$25$lambda$24(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IncrementalButton$lambda$26(Function0 function0, boolean z5, int i5, String str, int i6, Composer composer, int i7) {
        IncrementalButton(function0, z5, i5, str, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0566 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x07c7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x07d7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x07f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x07c1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05ca  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x026e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NumberSelector(Modifier modifier, final int i5, int i6, int i7, int i8, PluralText pluralText, String str, PriceWithCurrency priceWithCurrency, final Function1<? super Integer, Unit> decreaseOnClick, final Function1<? super Integer, Unit> increaseOnClick, NumberSelectorHeight numberSelectorHeight, boolean z5, boolean z6, boolean z7, boolean z8, Composer composer, final int i9, final int i10, final int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        String str2;
        NumberSelectorHeight numberSelectorHeight2;
        boolean z9;
        boolean z10;
        boolean z11;
        final FocusManager focusManager;
        Object rememberedValue;
        Composer.Companion companion;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        final int i24;
        boolean changedInstance;
        Object rememberedValue2;
        String text;
        String str3;
        int i25;
        int i26;
        long j5;
        final FocusManager focusManager2;
        int i27;
        int i28;
        Modifier modifier2;
        int i29;
        final Function1<? super Integer, Unit> function1;
        int i30;
        float f5;
        final int i31;
        int i32;
        Object rememberedValue3;
        final int i33;
        final int i34;
        final PluralText pluralText2;
        final int i35;
        final String str4;
        final Modifier modifier3;
        final PriceWithCurrency priceWithCurrency2;
        final boolean z12;
        final boolean z13;
        final boolean z14;
        final Function1<? super Integer, Unit> function12;
        final int i36;
        ScopeUpdateScope endRestartGroup;
        int i37;
        int i38;
        Intrinsics.checkNotNullParameter(decreaseOnClick, "decreaseOnClick");
        Intrinsics.checkNotNullParameter(increaseOnClick, "increaseOnClick");
        Composer startRestartGroup = composer.startRestartGroup(1548148915);
        int i39 = i11 & 1;
        if (i39 != 0) {
            i12 = i9 | 6;
        } else if ((i9 & 6) == 0) {
            i12 = i9 | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i12 = i9;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i9 & 48) == 0) {
            i12 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        int i40 = i12;
        int i41 = i11 & 4;
        if (i41 != 0) {
            i40 |= 384;
        } else if ((i9 & 384) == 0) {
            i40 |= startRestartGroup.changed(i6) ? 256 : 128;
            i13 = i11 & 8;
            if (i13 == 0) {
                i40 |= 3072;
            } else if ((i9 & 3072) == 0) {
                i40 |= startRestartGroup.changed(i7) ? 2048 : 1024;
                i14 = i11 & 16;
                if (i14 != 0) {
                    i40 |= 24576;
                } else if ((i9 & 24576) == 0) {
                    i40 |= startRestartGroup.changed(i8) ? 16384 : 8192;
                    i15 = i11 & 32;
                    if (i15 == 0) {
                        i40 |= 196608;
                    } else if ((196608 & i9) == 0) {
                        i40 |= startRestartGroup.changed(pluralText) ? 131072 : 65536;
                        i16 = i11 & 64;
                        if (i16 != 0) {
                            i40 |= 1572864;
                        } else if ((1572864 & i9) == 0) {
                            i40 |= startRestartGroup.changed(str) ? 1048576 : 524288;
                            i17 = i11 & 128;
                            if (i17 == 0) {
                                i40 |= 12582912;
                            } else if ((i9 & 12582912) == 0) {
                                i40 |= startRestartGroup.changedInstance(priceWithCurrency) ? 8388608 : 4194304;
                            }
                            if ((i11 & 256) == 0) {
                                i38 = (100663296 & i9) == 0 ? startRestartGroup.changedInstance(decreaseOnClick) ? 67108864 : 33554432 : 100663296;
                                if ((i11 & 512) == 0) {
                                    i37 = (805306368 & i9) == 0 ? startRestartGroup.changedInstance(increaseOnClick) ? 536870912 : 268435456 : 805306368;
                                    i18 = i11 & 1024;
                                    if (i18 == 0) {
                                        i19 = i10 | 6;
                                    } else if ((i10 & 6) == 0) {
                                        i19 = i10 | (startRestartGroup.changed(numberSelectorHeight) ? 4 : 2);
                                    } else {
                                        i19 = i10;
                                    }
                                    i20 = i11 & 2048;
                                    if (i20 == 0) {
                                        i19 |= 48;
                                    } else if ((i10 & 48) == 0) {
                                        i19 |= startRestartGroup.changed(z5) ? 32 : 16;
                                    }
                                    int i42 = i19;
                                    i21 = i11 & 4096;
                                    if (i21 == 0) {
                                        i42 |= 384;
                                    } else if ((i10 & 384) == 0) {
                                        i42 |= startRestartGroup.changed(z6) ? 256 : 128;
                                    }
                                    i22 = i11 & 8192;
                                    if (i22 == 0) {
                                        i42 |= 3072;
                                    } else if ((i10 & 3072) == 0) {
                                        i42 |= startRestartGroup.changed(z7) ? 2048 : 1024;
                                    }
                                    i23 = i11 & 16384;
                                    if (i23 == 0) {
                                        i42 |= 24576;
                                    } else if ((i10 & 24576) == 0) {
                                        i42 |= startRestartGroup.changed(z8) ? 16384 : 8192;
                                        if ((i40 & 306783379) != 306783378 && (i42 & 9363) == 9362 && startRestartGroup.getSkipping()) {
                                            startRestartGroup.skipToGroupEnd();
                                            modifier3 = modifier;
                                            i34 = i6;
                                            i35 = i7;
                                            i33 = i8;
                                            pluralText2 = pluralText;
                                            str4 = str;
                                            priceWithCurrency2 = priceWithCurrency;
                                            numberSelectorHeight2 = numberSelectorHeight;
                                            z12 = z5;
                                            z10 = z7;
                                            z14 = z8;
                                            z13 = z6;
                                        } else {
                                            Modifier modifier4 = i39 != 0 ? Modifier.INSTANCE : modifier;
                                            final int i43 = i41 != 0 ? 1 : i6;
                                            int i44 = i13 != 0 ? 0 : i7;
                                            int i45 = i14 != 0 ? Integer.MAX_VALUE : i8;
                                            PluralText pluralText3 = i15 != 0 ? null : pluralText;
                                            str2 = i16 != 0 ? null : str;
                                            PriceWithCurrency priceWithCurrency3 = i17 != 0 ? null : priceWithCurrency;
                                            numberSelectorHeight2 = i18 != 0 ? NumberSelectorHeight.Small : numberSelectorHeight;
                                            z9 = i20 != 0 ? false : z5;
                                            boolean z15 = i21 != 0 ? false : z6;
                                            z10 = i22 != 0 ? true : z7;
                                            z11 = i23 != 0 ? true : z8;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1548148915, i40, i42, "dk.molslinjen.ui.views.reusable.input.NumberSelector (NumberSelector.kt:77)");
                                            }
                                            focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                            startRestartGroup.startReplaceGroup(-1324499277);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            companion = Composer.INSTANCE;
                                            if (rememberedValue == companion.getEmpty()) {
                                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            final MutableState mutableState = (MutableState) rememberedValue;
                                            startRestartGroup.endReplaceGroup();
                                            long m3253getBrandBlack10d7_KjU = NumberSelector$lambda$1(mutableState) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                                            Arrangement arrangement = Arrangement.INSTANCE;
                                            Arrangement.Vertical top = arrangement.getTop();
                                            Alignment.Companion companion2 = Alignment.INSTANCE;
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
                                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                            int i46 = i42;
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                            Modifier modifier5 = modifier4;
                                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                            if (startRestartGroup.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                                            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            startRestartGroup.startReplaceGroup(786723537);
                                            if (str2 != null) {
                                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion4, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null);
                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
                                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                                                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                                if (startRestartGroup.getApplier() == null) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                startRestartGroup.startReusableNode();
                                                if (startRestartGroup.getInserting()) {
                                                    startRestartGroup.createNode(constructor2);
                                                } else {
                                                    startRestartGroup.useNode();
                                                }
                                                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                                                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                                                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                                                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash2);
                                                }
                                                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier2, companion3.getSetModifier());
                                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                TextKt.m940Text4IGK_g(str2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65534);
                                                startRestartGroup.startReplaceGroup(1924675509);
                                                if (priceWithCurrency3 != null) {
                                                    PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency3, PaddingKt.m315paddingqDBjuR0$default(companion4, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), (PriceViewType) null, false, TypographyKt.getSubBold(), (TextAlign) null, 0, 0L, startRestartGroup, 24624, 236);
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                startRestartGroup.endNode();
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Modifier modifier6 = Modifier.INSTANCE;
                                            Modifier m324defaultMinSizeVpY3zN4$default = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier6, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
                                            float m2599constructorimpl = Dp.m2599constructorimpl(1);
                                            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                                            int i47 = MaterialTheme.$stable;
                                            Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default, m2599constructorimpl, m3253getBrandBlack10d7_KjU, materialTheme.getShapes(startRestartGroup, i47).getMedium());
                                            AppColor appColor = AppColor.INSTANCE;
                                            Modifier clip = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU, z10 ? appColor.m3281getWhite0d7_KjU() : appColor.m3269getGrey60d7_KjU(), materialTheme.getShapes(startRestartGroup, i47).getMedium()), materialTheme.getShapes(startRestartGroup, i47).getMedium());
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getCenterVertically(), startRestartGroup, 54);
                                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, clip);
                                            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                            if (startRestartGroup.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            startRestartGroup.startReusableNode();
                                            if (startRestartGroup.getInserting()) {
                                                startRestartGroup.createNode(constructor3);
                                            } else {
                                                startRestartGroup.useNode();
                                            }
                                            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                                            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                                            if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash3);
                                            }
                                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier3, companion3.getSetModifier());
                                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                            i24 = i5 == i43 ? i43 : 1;
                                            startRestartGroup.startReplaceGroup(-758387692);
                                            int i48 = i40 & 112;
                                            changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i48 == 32) | startRestartGroup.changed(i24);
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (!changedInstance || rememberedValue2 == companion.getEmpty()) {
                                                rememberedValue2 = new Function0() { // from class: c2.h
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                                        NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                                                        return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            Function0 function0 = (Function0) rememberedValue2;
                                            startRestartGroup.endReplaceGroup();
                                            final int i49 = i44;
                                            IncrementalButton(function0, i5 <= i49 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
                                            VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU, 0.0f, null, startRestartGroup, 0, 13);
                                            if (z9) {
                                                modifier6 = RowScope.weight$default(rowScopeInstance2, modifier6, 1.0f, false, 2, null);
                                            } else if (z15) {
                                                modifier6 = SizeKt.m336width3ABfNKs(modifier6, Dp.m2599constructorimpl(48));
                                            }
                                            startRestartGroup.startReplaceGroup(-758368195);
                                            PluralText pluralText4 = pluralText3;
                                            text = pluralText4 == null ? null : pluralText4.getText(i5, startRestartGroup, ((i40 >> 3) & 14) | ((i40 >> 12) & 112));
                                            startRestartGroup.endReplaceGroup();
                                            if (text != null) {
                                                str3 = " " + text;
                                            } else {
                                                str3 = null;
                                            }
                                            if (z11) {
                                                startRestartGroup.startReplaceGroup(-2034476131);
                                                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.m324defaultMinSizeVpY3zN4$default(modifier6, Dp.m2599constructorimpl(numberSelectorHeight2.getValue() / 2), 0.0f, 2, null), z15 ? Dp.m2599constructorimpl(0) : Dp.m2599constructorimpl(16), 0.0f, 2, null);
                                                TextStyle paragraph = TypographyKt.getParagraph();
                                                startRestartGroup.startReplaceGroup(-758352732);
                                                boolean z16 = ((1879048192 & i40) == 536870912) | ((i40 & 896) == 256) | ((i40 & 7168) == 2048) | ((57344 & i40) == 16384);
                                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                                if (z16 || rememberedValue4 == companion.getEmpty()) {
                                                    function12 = increaseOnClick;
                                                    i36 = i45;
                                                    rememberedValue4 = new Function1() { // from class: c2.i
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            Unit NumberSelector$lambda$18$lambda$17$lambda$10$lambda$9;
                                                            NumberSelector$lambda$18$lambda$17$lambda$10$lambda$9 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$10$lambda$9(Function1.this, i43, i49, i36, ((Integer) obj).intValue());
                                                            return NumberSelector$lambda$18$lambda$17$lambda$10$lambda$9;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                                } else {
                                                    function12 = increaseOnClick;
                                                    i36 = i45;
                                                }
                                                Function1 function13 = (Function1) rememberedValue4;
                                                startRestartGroup.endReplaceGroup();
                                                startRestartGroup.startReplaceGroup(-758339848);
                                                boolean changedInstance2 = startRestartGroup.changedInstance(focusManager);
                                                int i50 = i36;
                                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                                if (changedInstance2 || rememberedValue5 == companion.getEmpty()) {
                                                    rememberedValue5 = new Function0() { // from class: c2.j
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            Unit NumberSelector$lambda$18$lambda$17$lambda$12$lambda$11;
                                                            NumberSelector$lambda$18$lambda$17$lambda$12$lambda$11 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$12$lambda$11(FocusManager.this);
                                                            return NumberSelector$lambda$18$lambda$17$lambda$12$lambda$11;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                                }
                                                Function0 function02 = (Function0) rememberedValue5;
                                                startRestartGroup.endReplaceGroup();
                                                startRestartGroup.startReplaceGroup(-758335009);
                                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                                int i51 = i40;
                                                if (rememberedValue6 == companion.getEmpty()) {
                                                    rememberedValue6 = new Function1() { // from class: c2.k
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj) {
                                                            Unit NumberSelector$lambda$18$lambda$17$lambda$14$lambda$13;
                                                            NumberSelector$lambda$18$lambda$17$lambda$14$lambda$13 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$14$lambda$13(MutableState.this, ((Boolean) obj).booleanValue());
                                                            return NumberSelector$lambda$18$lambda$17$lambda$14$lambda$13;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                i29 = 1;
                                                i28 = i50;
                                                i25 = i51;
                                                j5 = m3253getBrandBlack10d7_KjU;
                                                i26 = i43;
                                                focusManager2 = focusManager;
                                                i27 = i49;
                                                modifier2 = modifier5;
                                                function1 = function12;
                                                NumberSelectorTextField(m313paddingVpY3zN4$default, i5, str3, paragraph, z10, function13, function02, (Function1) rememberedValue6, startRestartGroup, 12585984 | i48 | ((i46 << 3) & 57344), 0);
                                                startRestartGroup.endReplaceGroup();
                                                startRestartGroup = startRestartGroup;
                                                i30 = 0;
                                            } else {
                                                i25 = i40;
                                                i26 = i43;
                                                j5 = m3253getBrandBlack10d7_KjU;
                                                focusManager2 = focusManager;
                                                i27 = i49;
                                                i28 = i45;
                                                modifier2 = modifier5;
                                                i29 = 1;
                                                function1 = increaseOnClick;
                                                startRestartGroup.startReplaceGroup(-2033417419);
                                                if (str3 == null) {
                                                    str3 = BuildConfig.FLAVOR;
                                                }
                                                String str5 = i5 + str3;
                                                Modifier m324defaultMinSizeVpY3zN4$default2 = SizeKt.m324defaultMinSizeVpY3zN4$default(modifier6, Dp.m2599constructorimpl(numberSelectorHeight2.getValue() / 2), 0.0f, 2, null);
                                                if (z15) {
                                                    i30 = 0;
                                                    f5 = 0;
                                                } else {
                                                    i30 = 0;
                                                    f5 = 16;
                                                }
                                                Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(m324defaultMinSizeVpY3zN4$default2, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                                                int m2528getCentere0LSkKk = TextAlign.INSTANCE.m2528getCentere0LSkKk();
                                                TextStyle paragraph2 = TypographyKt.getParagraph();
                                                AppColor appColor2 = AppColor.INSTANCE;
                                                TextKt.m940Text4IGK_g(str5, m313paddingVpY3zN4$default2, z10 ? appColor2.m3253getBrandBlack10d7_KjU() : appColor2.m3266getGrey30d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(m2528getCentere0LSkKk), 0L, 0, false, 1, 0, null, paragraph2, startRestartGroup, 0, 1575936, 56824);
                                                startRestartGroup.endReplaceGroup();
                                            }
                                            VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
                                            int i52 = i26;
                                            i31 = i5 < i52 ? i52 : i29;
                                            startRestartGroup.startReplaceGroup(-758305548);
                                            i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i48 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                            if (i32 == 0 || rememberedValue3 == companion.getEmpty()) {
                                                rememberedValue3 = new Function0() { // from class: c2.l
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                                        NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                                                        return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                            }
                                            Function0 function03 = (Function0) rememberedValue3;
                                            startRestartGroup.endReplaceGroup();
                                            i33 = i28;
                                            if (i31 + i5 <= i33 && z10) {
                                                i30 = i29;
                                            }
                                            IncrementalButton(function03, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
                                            startRestartGroup.endNode();
                                            startRestartGroup.endNode();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            i34 = i52;
                                            pluralText2 = pluralText4;
                                            i35 = i27;
                                            str4 = str2;
                                            modifier3 = modifier2;
                                            priceWithCurrency2 = priceWithCurrency3;
                                            z12 = z9;
                                            z13 = z15;
                                            z14 = z11;
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            final NumberSelectorHeight numberSelectorHeight3 = numberSelectorHeight2;
                                            final boolean z17 = z10;
                                            endRestartGroup.updateScope(new Function2() { // from class: c2.m
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj, Object obj2) {
                                                    Unit NumberSelector$lambda$19;
                                                    NumberSelector$lambda$19 = NumberSelectorKt.NumberSelector$lambda$19(Modifier.this, i5, i34, i35, i33, pluralText2, str4, priceWithCurrency2, decreaseOnClick, increaseOnClick, numberSelectorHeight3, z12, z13, z17, z14, i9, i10, i11, (Composer) obj, ((Integer) obj2).intValue());
                                                    return NumberSelector$lambda$19;
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    if ((i40 & 306783379) != 306783378) {
                                    }
                                    if (i39 != 0) {
                                    }
                                    if (i41 != 0) {
                                    }
                                    if (i13 != 0) {
                                    }
                                    if (i14 != 0) {
                                    }
                                    if (i15 != 0) {
                                    }
                                    if (i16 != 0) {
                                    }
                                    if (i17 != 0) {
                                    }
                                    if (i18 != 0) {
                                    }
                                    if (i20 != 0) {
                                    }
                                    if (i21 != 0) {
                                    }
                                    if (i22 != 0) {
                                    }
                                    if (i23 != 0) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                    startRestartGroup.startReplaceGroup(-1324499277);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue == companion.getEmpty()) {
                                    }
                                    final MutableState mutableState2 = (MutableState) rememberedValue;
                                    startRestartGroup.endReplaceGroup();
                                    long m3253getBrandBlack10d7_KjU2 = NumberSelector$lambda$1(mutableState2) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                                    Arrangement arrangement2 = Arrangement.INSTANCE;
                                    Arrangement.Vertical top2 = arrangement2.getTop();
                                    Alignment.Companion companion22 = Alignment.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion22.getStart(), startRestartGroup, 0);
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                                    int i462 = i42;
                                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                                    ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                                    Modifier modifier52 = modifier4;
                                    Function0<ComposeUiNode> constructor4 = companion32.getConstructor();
                                    if (startRestartGroup.getApplier() == null) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion32.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion32.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion32.getSetCompositeKeyHash();
                                    if (!m1226constructorimpl.getInserting()) {
                                    }
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion32.getSetModifier());
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    startRestartGroup.startReplaceGroup(786723537);
                                    if (str2 != null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Modifier modifier62 = Modifier.INSTANCE;
                                    Modifier m324defaultMinSizeVpY3zN4$default3 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier62, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
                                    float m2599constructorimpl2 = Dp.m2599constructorimpl(1);
                                    MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                                    int i472 = MaterialTheme.$stable;
                                    Modifier m108borderxT4_qwU2 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default3, m2599constructorimpl2, m3253getBrandBlack10d7_KjU2, materialTheme2.getShapes(startRestartGroup, i472).getMedium());
                                    AppColor appColor3 = AppColor.INSTANCE;
                                    Modifier clip2 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU2, z10 ? appColor3.m3281getWhite0d7_KjU() : appColor3.m3269getGrey60d7_KjU(), materialTheme2.getShapes(startRestartGroup, i472).getMedium()), materialTheme2.getShapes(startRestartGroup, i472).getMedium());
                                    MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getSpaceBetween(), companion22.getCenterVertically(), startRestartGroup, 54);
                                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, clip2);
                                    Function0<ComposeUiNode> constructor32 = companion32.getConstructor();
                                    if (startRestartGroup.getApplier() == null) {
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                    }
                                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22, companion32.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap32, companion32.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion32.getSetCompositeKeyHash();
                                    if (!m1226constructorimpl2.getInserting()) {
                                    }
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash32);
                                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier32, companion32.getSetModifier());
                                    RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
                                    if (i5 == i43) {
                                    }
                                    startRestartGroup.startReplaceGroup(-758387692);
                                    int i482 = i40 & 112;
                                    changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i482 == 32) | startRestartGroup.changed(i24);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (!changedInstance) {
                                    }
                                    rememberedValue2 = new Function0() { // from class: c2.h
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                            NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                                            return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                    Function0 function04 = (Function0) rememberedValue2;
                                    startRestartGroup.endReplaceGroup();
                                    final int i492 = i44;
                                    IncrementalButton(function04, i5 <= i492 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
                                    VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU2, 0.0f, null, startRestartGroup, 0, 13);
                                    if (z9) {
                                    }
                                    startRestartGroup.startReplaceGroup(-758368195);
                                    PluralText pluralText42 = pluralText3;
                                    if (pluralText42 == null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    if (text != null) {
                                    }
                                    if (z11) {
                                    }
                                    VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
                                    int i522 = i26;
                                    if (i5 < i522) {
                                    }
                                    startRestartGroup.startReplaceGroup(-758305548);
                                    i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i482 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (i32 == 0) {
                                    }
                                    rememberedValue3 = new Function0() { // from class: c2.l
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                            NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                                            return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                    Function0 function032 = (Function0) rememberedValue3;
                                    startRestartGroup.endReplaceGroup();
                                    i33 = i28;
                                    if (i31 + i5 <= i33) {
                                        i30 = i29;
                                    }
                                    IncrementalButton(function032, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
                                    startRestartGroup.endNode();
                                    startRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    i34 = i522;
                                    pluralText2 = pluralText42;
                                    i35 = i27;
                                    str4 = str2;
                                    modifier3 = modifier2;
                                    priceWithCurrency2 = priceWithCurrency3;
                                    z12 = z9;
                                    z13 = z15;
                                    z14 = z11;
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                i40 |= i37;
                                i18 = i11 & 1024;
                                if (i18 == 0) {
                                }
                                i20 = i11 & 2048;
                                if (i20 == 0) {
                                }
                                int i422 = i19;
                                i21 = i11 & 4096;
                                if (i21 == 0) {
                                }
                                i22 = i11 & 8192;
                                if (i22 == 0) {
                                }
                                i23 = i11 & 16384;
                                if (i23 == 0) {
                                }
                                if ((i40 & 306783379) != 306783378) {
                                }
                                if (i39 != 0) {
                                }
                                if (i41 != 0) {
                                }
                                if (i13 != 0) {
                                }
                                if (i14 != 0) {
                                }
                                if (i15 != 0) {
                                }
                                if (i16 != 0) {
                                }
                                if (i17 != 0) {
                                }
                                if (i18 != 0) {
                                }
                                if (i20 != 0) {
                                }
                                if (i21 != 0) {
                                }
                                if (i22 != 0) {
                                }
                                if (i23 != 0) {
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                startRestartGroup.startReplaceGroup(-1324499277);
                                rememberedValue = startRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (rememberedValue == companion.getEmpty()) {
                                }
                                final MutableState mutableState22 = (MutableState) rememberedValue;
                                startRestartGroup.endReplaceGroup();
                                long m3253getBrandBlack10d7_KjU22 = NumberSelector$lambda$1(mutableState22) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                                Arrangement arrangement22 = Arrangement.INSTANCE;
                                Arrangement.Vertical top22 = arrangement22.getTop();
                                Alignment.Companion companion222 = Alignment.INSTANCE;
                                MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(top22, companion222.getStart(), startRestartGroup, 0);
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
                                int i4622 = i422;
                                Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                                ComposeUiNode.Companion companion322 = ComposeUiNode.INSTANCE;
                                Modifier modifier522 = modifier4;
                                Function0<ComposeUiNode> constructor42 = companion322.getConstructor();
                                if (startRestartGroup.getApplier() == null) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion322.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap42, companion322.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion322.getSetCompositeKeyHash();
                                if (!m1226constructorimpl.getInserting()) {
                                }
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash42);
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier42, companion322.getSetModifier());
                                ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
                                startRestartGroup.startReplaceGroup(786723537);
                                if (str2 != null) {
                                }
                                startRestartGroup.endReplaceGroup();
                                Modifier modifier622 = Modifier.INSTANCE;
                                Modifier m324defaultMinSizeVpY3zN4$default32 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier622, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
                                float m2599constructorimpl22 = Dp.m2599constructorimpl(1);
                                MaterialTheme materialTheme22 = MaterialTheme.INSTANCE;
                                int i4722 = MaterialTheme.$stable;
                                Modifier m108borderxT4_qwU22 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default32, m2599constructorimpl22, m3253getBrandBlack10d7_KjU22, materialTheme22.getShapes(startRestartGroup, i4722).getMedium());
                                AppColor appColor32 = AppColor.INSTANCE;
                                Modifier clip22 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU22, z10 ? appColor32.m3281getWhite0d7_KjU() : appColor32.m3269getGrey60d7_KjU(), materialTheme22.getShapes(startRestartGroup, i4722).getMedium()), materialTheme22.getShapes(startRestartGroup, i4722).getMedium());
                                MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(arrangement22.getSpaceBetween(), companion222.getCenterVertically(), startRestartGroup, 54);
                                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, clip22);
                                Function0<ComposeUiNode> constructor322 = companion322.getConstructor();
                                if (startRestartGroup.getApplier() == null) {
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                }
                                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy222, companion322.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap322, companion322.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion322.getSetCompositeKeyHash();
                                if (!m1226constructorimpl2.getInserting()) {
                                }
                                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash322);
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier322, companion322.getSetModifier());
                                RowScopeInstance rowScopeInstance222 = RowScopeInstance.INSTANCE;
                                if (i5 == i43) {
                                }
                                startRestartGroup.startReplaceGroup(-758387692);
                                int i4822 = i40 & 112;
                                changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i4822 == 32) | startRestartGroup.changed(i24);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changedInstance) {
                                }
                                rememberedValue2 = new Function0() { // from class: c2.h
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                        NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                                        return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                Function0 function042 = (Function0) rememberedValue2;
                                startRestartGroup.endReplaceGroup();
                                final int i4922 = i44;
                                IncrementalButton(function042, i5 <= i4922 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
                                VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU22, 0.0f, null, startRestartGroup, 0, 13);
                                if (z9) {
                                }
                                startRestartGroup.startReplaceGroup(-758368195);
                                PluralText pluralText422 = pluralText3;
                                if (pluralText422 == null) {
                                }
                                startRestartGroup.endReplaceGroup();
                                if (text != null) {
                                }
                                if (z11) {
                                }
                                VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
                                int i5222 = i26;
                                if (i5 < i5222) {
                                }
                                startRestartGroup.startReplaceGroup(-758305548);
                                i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i4822 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (i32 == 0) {
                                }
                                rememberedValue3 = new Function0() { // from class: c2.l
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                        NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                                        return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                Function0 function0322 = (Function0) rememberedValue3;
                                startRestartGroup.endReplaceGroup();
                                i33 = i28;
                                if (i31 + i5 <= i33) {
                                }
                                IncrementalButton(function0322, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
                                startRestartGroup.endNode();
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i34 = i5222;
                                pluralText2 = pluralText422;
                                i35 = i27;
                                str4 = str2;
                                modifier3 = modifier2;
                                priceWithCurrency2 = priceWithCurrency3;
                                z12 = z9;
                                z13 = z15;
                                z14 = z11;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            i40 |= i38;
                            if ((i11 & 512) == 0) {
                            }
                            i40 |= i37;
                            i18 = i11 & 1024;
                            if (i18 == 0) {
                            }
                            i20 = i11 & 2048;
                            if (i20 == 0) {
                            }
                            int i4222 = i19;
                            i21 = i11 & 4096;
                            if (i21 == 0) {
                            }
                            i22 = i11 & 8192;
                            if (i22 == 0) {
                            }
                            i23 = i11 & 16384;
                            if (i23 == 0) {
                            }
                            if ((i40 & 306783379) != 306783378) {
                            }
                            if (i39 != 0) {
                            }
                            if (i41 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i23 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                            startRestartGroup.startReplaceGroup(-1324499277);
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                            }
                            final MutableState mutableState222 = (MutableState) rememberedValue;
                            startRestartGroup.endReplaceGroup();
                            long m3253getBrandBlack10d7_KjU222 = NumberSelector$lambda$1(mutableState222) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                            Arrangement arrangement222 = Arrangement.INSTANCE;
                            Arrangement.Vertical top222 = arrangement222.getTop();
                            Alignment.Companion companion2222 = Alignment.INSTANCE;
                            MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(top222, companion2222.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
                            int i46222 = i4222;
                            Modifier materializeModifier422 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                            ComposeUiNode.Companion companion3222 = ComposeUiNode.INSTANCE;
                            Modifier modifier5222 = modifier4;
                            Function0<ComposeUiNode> constructor422 = companion3222.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion3222.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap422, companion3222.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422 = companion3222.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting()) {
                            }
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash422);
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier422, companion3222.getSetModifier());
                            ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
                            startRestartGroup.startReplaceGroup(786723537);
                            if (str2 != null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier modifier6222 = Modifier.INSTANCE;
                            Modifier m324defaultMinSizeVpY3zN4$default322 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier6222, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
                            float m2599constructorimpl222 = Dp.m2599constructorimpl(1);
                            MaterialTheme materialTheme222 = MaterialTheme.INSTANCE;
                            int i47222 = MaterialTheme.$stable;
                            Modifier m108borderxT4_qwU222 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default322, m2599constructorimpl222, m3253getBrandBlack10d7_KjU222, materialTheme222.getShapes(startRestartGroup, i47222).getMedium());
                            AppColor appColor322 = AppColor.INSTANCE;
                            Modifier clip222 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU222, z10 ? appColor322.m3281getWhite0d7_KjU() : appColor322.m3269getGrey60d7_KjU(), materialTheme222.getShapes(startRestartGroup, i47222).getMedium()), materialTheme222.getShapes(startRestartGroup, i47222).getMedium());
                            MeasurePolicy rowMeasurePolicy2222 = RowKt.rowMeasurePolicy(arrangement222.getSpaceBetween(), companion2222.getCenterVertically(), startRestartGroup, 54);
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, clip222);
                            Function0<ComposeUiNode> constructor3222 = companion3222.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2222, companion3222.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap3222, companion3222.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = companion3222.getSetCompositeKeyHash();
                            if (!m1226constructorimpl2.getInserting()) {
                            }
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash3222);
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier3222, companion3222.getSetModifier());
                            RowScopeInstance rowScopeInstance2222 = RowScopeInstance.INSTANCE;
                            if (i5 == i43) {
                            }
                            startRestartGroup.startReplaceGroup(-758387692);
                            int i48222 = i40 & 112;
                            changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i48222 == 32) | startRestartGroup.changed(i24);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                            }
                            rememberedValue2 = new Function0() { // from class: c2.h
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                    NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                                    return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            Function0 function0422 = (Function0) rememberedValue2;
                            startRestartGroup.endReplaceGroup();
                            final int i49222 = i44;
                            IncrementalButton(function0422, i5 <= i49222 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
                            VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU222, 0.0f, null, startRestartGroup, 0, 13);
                            if (z9) {
                            }
                            startRestartGroup.startReplaceGroup(-758368195);
                            PluralText pluralText4222 = pluralText3;
                            if (pluralText4222 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            if (text != null) {
                            }
                            if (z11) {
                            }
                            VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
                            int i52222 = i26;
                            if (i5 < i52222) {
                            }
                            startRestartGroup.startReplaceGroup(-758305548);
                            i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i48222 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (i32 == 0) {
                            }
                            rememberedValue3 = new Function0() { // from class: c2.l
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                    NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                                    return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                            Function0 function03222 = (Function0) rememberedValue3;
                            startRestartGroup.endReplaceGroup();
                            i33 = i28;
                            if (i31 + i5 <= i33) {
                            }
                            IncrementalButton(function03222, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
                            startRestartGroup.endNode();
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i34 = i52222;
                            pluralText2 = pluralText4222;
                            i35 = i27;
                            str4 = str2;
                            modifier3 = modifier2;
                            priceWithCurrency2 = priceWithCurrency3;
                            z12 = z9;
                            z13 = z15;
                            z14 = z11;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i17 = i11 & 128;
                        if (i17 == 0) {
                        }
                        if ((i11 & 256) == 0) {
                        }
                        i40 |= i38;
                        if ((i11 & 512) == 0) {
                        }
                        i40 |= i37;
                        i18 = i11 & 1024;
                        if (i18 == 0) {
                        }
                        i20 = i11 & 2048;
                        if (i20 == 0) {
                        }
                        int i42222 = i19;
                        i21 = i11 & 4096;
                        if (i21 == 0) {
                        }
                        i22 = i11 & 8192;
                        if (i22 == 0) {
                        }
                        i23 = i11 & 16384;
                        if (i23 == 0) {
                        }
                        if ((i40 & 306783379) != 306783378) {
                        }
                        if (i39 != 0) {
                        }
                        if (i41 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i23 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        startRestartGroup.startReplaceGroup(-1324499277);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        final MutableState mutableState2222 = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        long m3253getBrandBlack10d7_KjU2222 = NumberSelector$lambda$1(mutableState2222) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                        Arrangement arrangement2222 = Arrangement.INSTANCE;
                        Arrangement.Vertical top2222 = arrangement2222.getTop();
                        Alignment.Companion companion22222 = Alignment.INSTANCE;
                        MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(top2222, companion22222.getStart(), startRestartGroup, 0);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4222 = startRestartGroup.getCurrentCompositionLocalMap();
                        int i462222 = i42222;
                        Modifier materializeModifier4222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                        ComposeUiNode.Companion companion32222 = ComposeUiNode.INSTANCE;
                        Modifier modifier52222 = modifier4;
                        Function0<ComposeUiNode> constructor4222 = companion32222.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2222, companion32222.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4222, companion32222.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4222 = companion32222.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4222);
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4222, companion32222.getSetModifier());
                        ColumnScopeInstance columnScopeInstance2222 = ColumnScopeInstance.INSTANCE;
                        startRestartGroup.startReplaceGroup(786723537);
                        if (str2 != null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier modifier62222 = Modifier.INSTANCE;
                        Modifier m324defaultMinSizeVpY3zN4$default3222 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier62222, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
                        float m2599constructorimpl2222 = Dp.m2599constructorimpl(1);
                        MaterialTheme materialTheme2222 = MaterialTheme.INSTANCE;
                        int i472222 = MaterialTheme.$stable;
                        Modifier m108borderxT4_qwU2222 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default3222, m2599constructorimpl2222, m3253getBrandBlack10d7_KjU2222, materialTheme2222.getShapes(startRestartGroup, i472222).getMedium());
                        AppColor appColor3222 = AppColor.INSTANCE;
                        Modifier clip2222 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU2222, z10 ? appColor3222.m3281getWhite0d7_KjU() : appColor3222.m3269getGrey60d7_KjU(), materialTheme2222.getShapes(startRestartGroup, i472222).getMedium()), materialTheme2222.getShapes(startRestartGroup, i472222).getMedium());
                        MeasurePolicy rowMeasurePolicy22222 = RowKt.rowMeasurePolicy(arrangement2222.getSpaceBetween(), companion22222.getCenterVertically(), startRestartGroup, 54);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap32222 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier32222 = ComposedModifierKt.materializeModifier(startRestartGroup, clip2222);
                        Function0<ComposeUiNode> constructor32222 = companion32222.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22222, companion32222.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap32222, companion32222.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32222 = companion32222.getSetCompositeKeyHash();
                        if (!m1226constructorimpl2.getInserting()) {
                        }
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash32222);
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier32222, companion32222.getSetModifier());
                        RowScopeInstance rowScopeInstance22222 = RowScopeInstance.INSTANCE;
                        if (i5 == i43) {
                        }
                        startRestartGroup.startReplaceGroup(-758387692);
                        int i482222 = i40 & 112;
                        changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i482222 == 32) | startRestartGroup.changed(i24);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        rememberedValue2 = new Function0() { // from class: c2.h
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                                NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                                return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        Function0 function04222 = (Function0) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        final int i492222 = i44;
                        IncrementalButton(function04222, i5 <= i492222 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
                        VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU2222, 0.0f, null, startRestartGroup, 0, 13);
                        if (z9) {
                        }
                        startRestartGroup.startReplaceGroup(-758368195);
                        PluralText pluralText42222 = pluralText3;
                        if (pluralText42222 == null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        if (text != null) {
                        }
                        if (z11) {
                        }
                        VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
                        int i522222 = i26;
                        if (i5 < i522222) {
                        }
                        startRestartGroup.startReplaceGroup(-758305548);
                        i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i482222 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (i32 == 0) {
                        }
                        rememberedValue3 = new Function0() { // from class: c2.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                                NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                                return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        Function0 function032222 = (Function0) rememberedValue3;
                        startRestartGroup.endReplaceGroup();
                        i33 = i28;
                        if (i31 + i5 <= i33) {
                        }
                        IncrementalButton(function032222, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
                        startRestartGroup.endNode();
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i34 = i522222;
                        pluralText2 = pluralText42222;
                        i35 = i27;
                        str4 = str2;
                        modifier3 = modifier2;
                        priceWithCurrency2 = priceWithCurrency3;
                        z12 = z9;
                        z13 = z15;
                        z14 = z11;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i16 = i11 & 64;
                    if (i16 != 0) {
                    }
                    i17 = i11 & 128;
                    if (i17 == 0) {
                    }
                    if ((i11 & 256) == 0) {
                    }
                    i40 |= i38;
                    if ((i11 & 512) == 0) {
                    }
                    i40 |= i37;
                    i18 = i11 & 1024;
                    if (i18 == 0) {
                    }
                    i20 = i11 & 2048;
                    if (i20 == 0) {
                    }
                    int i422222 = i19;
                    i21 = i11 & 4096;
                    if (i21 == 0) {
                    }
                    i22 = i11 & 8192;
                    if (i22 == 0) {
                    }
                    i23 = i11 & 16384;
                    if (i23 == 0) {
                    }
                    if ((i40 & 306783379) != 306783378) {
                    }
                    if (i39 != 0) {
                    }
                    if (i41 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    startRestartGroup.startReplaceGroup(-1324499277);
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    final MutableState mutableState22222 = (MutableState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    long m3253getBrandBlack10d7_KjU22222 = NumberSelector$lambda$1(mutableState22222) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                    Arrangement arrangement22222 = Arrangement.INSTANCE;
                    Arrangement.Vertical top22222 = arrangement22222.getTop();
                    Alignment.Companion companion222222 = Alignment.INSTANCE;
                    MeasurePolicy columnMeasurePolicy22222 = ColumnKt.columnMeasurePolicy(top22222, companion222222.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap42222 = startRestartGroup.getCurrentCompositionLocalMap();
                    int i4622222 = i422222;
                    Modifier materializeModifier42222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                    ComposeUiNode.Companion companion322222 = ComposeUiNode.INSTANCE;
                    Modifier modifier522222 = modifier4;
                    Function0<ComposeUiNode> constructor42222 = companion322222.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22222, companion322222.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap42222, companion322222.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42222 = companion322222.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash42222);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier42222, companion322222.getSetModifier());
                    ColumnScopeInstance columnScopeInstance22222 = ColumnScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(786723537);
                    if (str2 != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier modifier622222 = Modifier.INSTANCE;
                    Modifier m324defaultMinSizeVpY3zN4$default32222 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier622222, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
                    float m2599constructorimpl22222 = Dp.m2599constructorimpl(1);
                    MaterialTheme materialTheme22222 = MaterialTheme.INSTANCE;
                    int i4722222 = MaterialTheme.$stable;
                    Modifier m108borderxT4_qwU22222 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default32222, m2599constructorimpl22222, m3253getBrandBlack10d7_KjU22222, materialTheme22222.getShapes(startRestartGroup, i4722222).getMedium());
                    AppColor appColor32222 = AppColor.INSTANCE;
                    Modifier clip22222 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU22222, z10 ? appColor32222.m3281getWhite0d7_KjU() : appColor32222.m3269getGrey60d7_KjU(), materialTheme22222.getShapes(startRestartGroup, i4722222).getMedium()), materialTheme22222.getShapes(startRestartGroup, i4722222).getMedium());
                    MeasurePolicy rowMeasurePolicy222222 = RowKt.rowMeasurePolicy(arrangement22222.getSpaceBetween(), companion222222.getCenterVertically(), startRestartGroup, 54);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap322222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier322222 = ComposedModifierKt.materializeModifier(startRestartGroup, clip22222);
                    Function0<ComposeUiNode> constructor322222 = companion322222.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy222222, companion322222.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap322222, companion322222.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322222 = companion322222.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting()) {
                    }
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash322222);
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier322222, companion322222.getSetModifier());
                    RowScopeInstance rowScopeInstance222222 = RowScopeInstance.INSTANCE;
                    if (i5 == i43) {
                    }
                    startRestartGroup.startReplaceGroup(-758387692);
                    int i4822222 = i40 & 112;
                    changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i4822222 == 32) | startRestartGroup.changed(i24);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue2 = new Function0() { // from class: c2.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                            NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                            return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    Function0 function042222 = (Function0) rememberedValue2;
                    startRestartGroup.endReplaceGroup();
                    final int i4922222 = i44;
                    IncrementalButton(function042222, i5 <= i4922222 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
                    VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU22222, 0.0f, null, startRestartGroup, 0, 13);
                    if (z9) {
                    }
                    startRestartGroup.startReplaceGroup(-758368195);
                    PluralText pluralText422222 = pluralText3;
                    if (pluralText422222 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    if (text != null) {
                    }
                    if (z11) {
                    }
                    VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
                    int i5222222 = i26;
                    if (i5 < i5222222) {
                    }
                    startRestartGroup.startReplaceGroup(-758305548);
                    i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i4822222 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (i32 == 0) {
                    }
                    rememberedValue3 = new Function0() { // from class: c2.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                            NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                            return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    Function0 function0322222 = (Function0) rememberedValue3;
                    startRestartGroup.endReplaceGroup();
                    i33 = i28;
                    if (i31 + i5 <= i33) {
                    }
                    IncrementalButton(function0322222, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
                    startRestartGroup.endNode();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i34 = i5222222;
                    pluralText2 = pluralText422222;
                    i35 = i27;
                    str4 = str2;
                    modifier3 = modifier2;
                    priceWithCurrency2 = priceWithCurrency3;
                    z12 = z9;
                    z13 = z15;
                    z14 = z11;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i15 = i11 & 32;
                if (i15 == 0) {
                }
                i16 = i11 & 64;
                if (i16 != 0) {
                }
                i17 = i11 & 128;
                if (i17 == 0) {
                }
                if ((i11 & 256) == 0) {
                }
                i40 |= i38;
                if ((i11 & 512) == 0) {
                }
                i40 |= i37;
                i18 = i11 & 1024;
                if (i18 == 0) {
                }
                i20 = i11 & 2048;
                if (i20 == 0) {
                }
                int i4222222 = i19;
                i21 = i11 & 4096;
                if (i21 == 0) {
                }
                i22 = i11 & 8192;
                if (i22 == 0) {
                }
                i23 = i11 & 16384;
                if (i23 == 0) {
                }
                if ((i40 & 306783379) != 306783378) {
                }
                if (i39 != 0) {
                }
                if (i41 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i20 != 0) {
                }
                if (i21 != 0) {
                }
                if (i22 != 0) {
                }
                if (i23 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                startRestartGroup.startReplaceGroup(-1324499277);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                final MutableState mutableState222222 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                long m3253getBrandBlack10d7_KjU222222 = NumberSelector$lambda$1(mutableState222222) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
                Arrangement arrangement222222 = Arrangement.INSTANCE;
                Arrangement.Vertical top222222 = arrangement222222.getTop();
                Alignment.Companion companion2222222 = Alignment.INSTANCE;
                MeasurePolicy columnMeasurePolicy222222 = ColumnKt.columnMeasurePolicy(top222222, companion2222222.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap422222 = startRestartGroup.getCurrentCompositionLocalMap();
                int i46222222 = i4222222;
                Modifier materializeModifier422222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                ComposeUiNode.Companion companion3222222 = ComposeUiNode.INSTANCE;
                Modifier modifier5222222 = modifier4;
                Function0<ComposeUiNode> constructor422222 = companion3222222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222222, companion3222222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap422222, companion3222222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422222 = companion3222222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash422222);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier422222, companion3222222.getSetModifier());
                ColumnScopeInstance columnScopeInstance222222 = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(786723537);
                if (str2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier6222222 = Modifier.INSTANCE;
                Modifier m324defaultMinSizeVpY3zN4$default322222 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier6222222, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
                float m2599constructorimpl222222 = Dp.m2599constructorimpl(1);
                MaterialTheme materialTheme222222 = MaterialTheme.INSTANCE;
                int i47222222 = MaterialTheme.$stable;
                Modifier m108borderxT4_qwU222222 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default322222, m2599constructorimpl222222, m3253getBrandBlack10d7_KjU222222, materialTheme222222.getShapes(startRestartGroup, i47222222).getMedium());
                AppColor appColor322222 = AppColor.INSTANCE;
                Modifier clip222222 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU222222, z10 ? appColor322222.m3281getWhite0d7_KjU() : appColor322222.m3269getGrey60d7_KjU(), materialTheme222222.getShapes(startRestartGroup, i47222222).getMedium()), materialTheme222222.getShapes(startRestartGroup, i47222222).getMedium());
                MeasurePolicy rowMeasurePolicy2222222 = RowKt.rowMeasurePolicy(arrangement222222.getSpaceBetween(), companion2222222.getCenterVertically(), startRestartGroup, 54);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3222222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3222222 = ComposedModifierKt.materializeModifier(startRestartGroup, clip222222);
                Function0<ComposeUiNode> constructor3222222 = companion3222222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2222222, companion3222222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap3222222, companion3222222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222222 = companion3222222.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting()) {
                }
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash3222222);
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier3222222, companion3222222.getSetModifier());
                RowScopeInstance rowScopeInstance2222222 = RowScopeInstance.INSTANCE;
                if (i5 == i43) {
                }
                startRestartGroup.startReplaceGroup(-758387692);
                int i48222222 = i40 & 112;
                changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i48222222 == 32) | startRestartGroup.changed(i24);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue2 = new Function0() { // from class: c2.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                        NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                        return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                Function0 function0422222 = (Function0) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                final int i49222222 = i44;
                IncrementalButton(function0422222, i5 <= i49222222 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
                VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU222222, 0.0f, null, startRestartGroup, 0, 13);
                if (z9) {
                }
                startRestartGroup.startReplaceGroup(-758368195);
                PluralText pluralText4222222 = pluralText3;
                if (pluralText4222222 == null) {
                }
                startRestartGroup.endReplaceGroup();
                if (text != null) {
                }
                if (z11) {
                }
                VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
                int i52222222 = i26;
                if (i5 < i52222222) {
                }
                startRestartGroup.startReplaceGroup(-758305548);
                i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i48222222 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (i32 == 0) {
                }
                rememberedValue3 = new Function0() { // from class: c2.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                        NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                        return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                Function0 function03222222 = (Function0) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                i33 = i28;
                if (i31 + i5 <= i33) {
                }
                IncrementalButton(function03222222, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                i34 = i52222222;
                pluralText2 = pluralText4222222;
                i35 = i27;
                str4 = str2;
                modifier3 = modifier2;
                priceWithCurrency2 = priceWithCurrency3;
                z12 = z9;
                z13 = z15;
                z14 = z11;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i14 = i11 & 16;
            if (i14 != 0) {
            }
            i15 = i11 & 32;
            if (i15 == 0) {
            }
            i16 = i11 & 64;
            if (i16 != 0) {
            }
            i17 = i11 & 128;
            if (i17 == 0) {
            }
            if ((i11 & 256) == 0) {
            }
            i40 |= i38;
            if ((i11 & 512) == 0) {
            }
            i40 |= i37;
            i18 = i11 & 1024;
            if (i18 == 0) {
            }
            i20 = i11 & 2048;
            if (i20 == 0) {
            }
            int i42222222 = i19;
            i21 = i11 & 4096;
            if (i21 == 0) {
            }
            i22 = i11 & 8192;
            if (i22 == 0) {
            }
            i23 = i11 & 16384;
            if (i23 == 0) {
            }
            if ((i40 & 306783379) != 306783378) {
            }
            if (i39 != 0) {
            }
            if (i41 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i20 != 0) {
            }
            if (i21 != 0) {
            }
            if (i22 != 0) {
            }
            if (i23 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            startRestartGroup.startReplaceGroup(-1324499277);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final MutableState mutableState2222222 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            long m3253getBrandBlack10d7_KjU2222222 = NumberSelector$lambda$1(mutableState2222222) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
            Arrangement arrangement2222222 = Arrangement.INSTANCE;
            Arrangement.Vertical top2222222 = arrangement2222222.getTop();
            Alignment.Companion companion22222222 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy2222222 = ColumnKt.columnMeasurePolicy(top2222222, companion22222222.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4222222 = startRestartGroup.getCurrentCompositionLocalMap();
            int i462222222 = i42222222;
            Modifier materializeModifier4222222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
            ComposeUiNode.Companion companion32222222 = ComposeUiNode.INSTANCE;
            Modifier modifier52222222 = modifier4;
            Function0<ComposeUiNode> constructor4222222 = companion32222222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2222222, companion32222222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4222222, companion32222222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4222222 = companion32222222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4222222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier4222222, companion32222222.getSetModifier());
            ColumnScopeInstance columnScopeInstance2222222 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(786723537);
            if (str2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier62222222 = Modifier.INSTANCE;
            Modifier m324defaultMinSizeVpY3zN4$default3222222 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier62222222, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
            float m2599constructorimpl2222222 = Dp.m2599constructorimpl(1);
            MaterialTheme materialTheme2222222 = MaterialTheme.INSTANCE;
            int i472222222 = MaterialTheme.$stable;
            Modifier m108borderxT4_qwU2222222 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default3222222, m2599constructorimpl2222222, m3253getBrandBlack10d7_KjU2222222, materialTheme2222222.getShapes(startRestartGroup, i472222222).getMedium());
            AppColor appColor3222222 = AppColor.INSTANCE;
            Modifier clip2222222 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU2222222, z10 ? appColor3222222.m3281getWhite0d7_KjU() : appColor3222222.m3269getGrey60d7_KjU(), materialTheme2222222.getShapes(startRestartGroup, i472222222).getMedium()), materialTheme2222222.getShapes(startRestartGroup, i472222222).getMedium());
            MeasurePolicy rowMeasurePolicy22222222 = RowKt.rowMeasurePolicy(arrangement2222222.getSpaceBetween(), companion22222222.getCenterVertically(), startRestartGroup, 54);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap32222222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier32222222 = ComposedModifierKt.materializeModifier(startRestartGroup, clip2222222);
            Function0<ComposeUiNode> constructor32222222 = companion32222222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22222222, companion32222222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap32222222, companion32222222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32222222 = companion32222222.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash32222222);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier32222222, companion32222222.getSetModifier());
            RowScopeInstance rowScopeInstance22222222 = RowScopeInstance.INSTANCE;
            if (i5 == i43) {
            }
            startRestartGroup.startReplaceGroup(-758387692);
            int i482222222 = i40 & 112;
            changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i482222222 == 32) | startRestartGroup.changed(i24);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue2 = new Function0() { // from class: c2.h
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                    NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                    return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            Function0 function04222222 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            final int i492222222 = i44;
            IncrementalButton(function04222222, i5 <= i492222222 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
            VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU2222222, 0.0f, null, startRestartGroup, 0, 13);
            if (z9) {
            }
            startRestartGroup.startReplaceGroup(-758368195);
            PluralText pluralText42222222 = pluralText3;
            if (pluralText42222222 == null) {
            }
            startRestartGroup.endReplaceGroup();
            if (text != null) {
            }
            if (z11) {
            }
            VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
            int i522222222 = i26;
            if (i5 < i522222222) {
            }
            startRestartGroup.startReplaceGroup(-758305548);
            i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i482222222 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (i32 == 0) {
            }
            rememberedValue3 = new Function0() { // from class: c2.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                    NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                    return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            Function0 function032222222 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            i33 = i28;
            if (i31 + i5 <= i33) {
            }
            IncrementalButton(function032222222, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            i34 = i522222222;
            pluralText2 = pluralText42222222;
            i35 = i27;
            str4 = str2;
            modifier3 = modifier2;
            priceWithCurrency2 = priceWithCurrency3;
            z12 = z9;
            z13 = z15;
            z14 = z11;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i13 = i11 & 8;
        if (i13 == 0) {
        }
        i14 = i11 & 16;
        if (i14 != 0) {
        }
        i15 = i11 & 32;
        if (i15 == 0) {
        }
        i16 = i11 & 64;
        if (i16 != 0) {
        }
        i17 = i11 & 128;
        if (i17 == 0) {
        }
        if ((i11 & 256) == 0) {
        }
        i40 |= i38;
        if ((i11 & 512) == 0) {
        }
        i40 |= i37;
        i18 = i11 & 1024;
        if (i18 == 0) {
        }
        i20 = i11 & 2048;
        if (i20 == 0) {
        }
        int i422222222 = i19;
        i21 = i11 & 4096;
        if (i21 == 0) {
        }
        i22 = i11 & 8192;
        if (i22 == 0) {
        }
        i23 = i11 & 16384;
        if (i23 == 0) {
        }
        if ((i40 & 306783379) != 306783378) {
        }
        if (i39 != 0) {
        }
        if (i41 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i20 != 0) {
        }
        if (i21 != 0) {
        }
        if (i22 != 0) {
        }
        if (i23 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        startRestartGroup.startReplaceGroup(-1324499277);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableState mutableState22222222 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        long m3253getBrandBlack10d7_KjU22222222 = NumberSelector$lambda$1(mutableState22222222) ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3267getGrey40d7_KjU();
        Arrangement arrangement22222222 = Arrangement.INSTANCE;
        Arrangement.Vertical top22222222 = arrangement22222222.getTop();
        Alignment.Companion companion222222222 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy22222222 = ColumnKt.columnMeasurePolicy(top22222222, companion222222222.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap42222222 = startRestartGroup.getCurrentCompositionLocalMap();
        int i4622222222 = i422222222;
        Modifier materializeModifier42222222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
        ComposeUiNode.Companion companion322222222 = ComposeUiNode.INSTANCE;
        Modifier modifier522222222 = modifier4;
        Function0<ComposeUiNode> constructor42222222 = companion322222222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22222222, companion322222222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap42222222, companion322222222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42222222 = companion322222222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash42222222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier42222222, companion322222222.getSetModifier());
        ColumnScopeInstance columnScopeInstance22222222 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(786723537);
        if (str2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier modifier622222222 = Modifier.INSTANCE;
        Modifier m324defaultMinSizeVpY3zN4$default32222222 = SizeKt.m324defaultMinSizeVpY3zN4$default(IntrinsicKt.height(modifier622222222, IntrinsicSize.Min), 0.0f, numberSelectorHeight2.getValue(), 1, null);
        float m2599constructorimpl22222222 = Dp.m2599constructorimpl(1);
        MaterialTheme materialTheme22222222 = MaterialTheme.INSTANCE;
        int i4722222222 = MaterialTheme.$stable;
        Modifier m108borderxT4_qwU22222222 = BorderKt.m108borderxT4_qwU(m324defaultMinSizeVpY3zN4$default32222222, m2599constructorimpl22222222, m3253getBrandBlack10d7_KjU22222222, materialTheme22222222.getShapes(startRestartGroup, i4722222222).getMedium());
        AppColor appColor32222222 = AppColor.INSTANCE;
        Modifier clip22222222 = ClipKt.clip(BackgroundKt.m103backgroundbw27NRU(m108borderxT4_qwU22222222, z10 ? appColor32222222.m3281getWhite0d7_KjU() : appColor32222222.m3269getGrey60d7_KjU(), materialTheme22222222.getShapes(startRestartGroup, i4722222222).getMedium()), materialTheme22222222.getShapes(startRestartGroup, i4722222222).getMedium());
        MeasurePolicy rowMeasurePolicy222222222 = RowKt.rowMeasurePolicy(arrangement22222222.getSpaceBetween(), companion222222222.getCenterVertically(), startRestartGroup, 54);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap322222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier322222222 = ComposedModifierKt.materializeModifier(startRestartGroup, clip22222222);
        Function0<ComposeUiNode> constructor322222222 = companion322222222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy222222222, companion322222222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap322222222, companion322222222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322222222 = companion322222222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash322222222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier322222222, companion322222222.getSetModifier());
        RowScopeInstance rowScopeInstance222222222 = RowScopeInstance.INSTANCE;
        if (i5 == i43) {
        }
        startRestartGroup.startReplaceGroup(-758387692);
        int i4822222222 = i40 & 112;
        changedInstance = startRestartGroup.changedInstance(focusManager) | ((234881024 & i40) == 67108864) | (i4822222222 == 32) | startRestartGroup.changed(i24);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue2 = new Function0() { // from class: c2.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
                NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager.this, decreaseOnClick, i5, i24);
                return NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        Function0 function042222222 = (Function0) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        final int i4922222222 = i44;
        IncrementalButton(function042222222, i5 <= i4922222222 && z10, R.drawable.icon_minus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_minus, startRestartGroup, 6), startRestartGroup, 384);
        VerticalDividerKt.m3394VerticalDividertZIQpXc(null, m3253getBrandBlack10d7_KjU22222222, 0.0f, null, startRestartGroup, 0, 13);
        if (z9) {
        }
        startRestartGroup.startReplaceGroup(-758368195);
        PluralText pluralText422222222 = pluralText3;
        if (pluralText422222222 == null) {
        }
        startRestartGroup.endReplaceGroup();
        if (text != null) {
        }
        if (z11) {
        }
        VerticalDividerKt.m3394VerticalDividertZIQpXc(null, j5, 0.0f, null, startRestartGroup, 0, 13);
        int i5222222222 = i26;
        if (i5 < i5222222222) {
        }
        startRestartGroup.startReplaceGroup(-758305548);
        i32 = (startRestartGroup.changedInstance(focusManager2) ? 1 : 0) | ((i25 & 1879048192) == 536870912 ? i29 : i30) | (i4822222222 == 32 ? i29 : i30) | (startRestartGroup.changed(i31) ? 1 : 0);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (i32 == 0) {
        }
        rememberedValue3 = new Function0() { // from class: c2.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
                NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15 = NumberSelectorKt.NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager.this, function1, i5, i31);
                return NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        Function0 function0322222222 = (Function0) rememberedValue3;
        startRestartGroup.endReplaceGroup();
        i33 = i28;
        if (i31 + i5 <= i33) {
        }
        IncrementalButton(function0322222222, i30, R.drawable.icon_plus, StringResources_androidKt.stringResource(R.string.accessibilityLabel_plus, startRestartGroup, 6), startRestartGroup, 384);
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        i34 = i5222222222;
        pluralText2 = pluralText422222222;
        i35 = i27;
        str4 = str2;
        modifier3 = modifier2;
        priceWithCurrency2 = priceWithCurrency3;
        z12 = z9;
        z13 = z15;
        z14 = z11;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final boolean NumberSelector$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberSelector$lambda$18$lambda$17$lambda$10$lambda$9(Function1 function1, int i5, int i6, int i7, int i8) {
        function1.invoke(Integer.valueOf(getValidCount(i8, i5, i6, i7)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberSelector$lambda$18$lambda$17$lambda$12$lambda$11(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberSelector$lambda$18$lambda$17$lambda$14$lambda$13(MutableState mutableState, boolean z5) {
        NumberSelector$lambda$2(mutableState, z5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberSelector$lambda$18$lambda$17$lambda$16$lambda$15(FocusManager focusManager, Function1 function1, int i5, int i6) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function1.invoke(Integer.valueOf(i5 + i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberSelector$lambda$18$lambda$17$lambda$7$lambda$6(FocusManager focusManager, Function1 function1, int i5, int i6) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function1.invoke(Integer.valueOf(i5 - i6));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberSelector$lambda$19(Modifier modifier, int i5, int i6, int i7, int i8, PluralText pluralText, String str, PriceWithCurrency priceWithCurrency, Function1 function1, Function1 function12, NumberSelectorHeight numberSelectorHeight, boolean z5, boolean z6, boolean z7, boolean z8, int i9, int i10, int i11, Composer composer, int i12) {
        NumberSelector(modifier, i5, i6, i7, i8, pluralText, str, priceWithCurrency, function1, function12, numberSelectorHeight, z5, z6, z7, z8, composer, RecomposeScopeImplKt.updateChangedFlags(i9 | 1), RecomposeScopeImplKt.updateChangedFlags(i10), i11);
        return Unit.INSTANCE;
    }

    private static final void NumberSelector$lambda$2(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void NumberSelectorTextField(Modifier modifier, final int i5, final String str, final TextStyle textStyle, final boolean z5, final Function1<? super Integer, Unit> function1, final Function0<Unit> function0, final Function1<? super Boolean, Unit> function12, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        Modifier modifier3;
        Object rememberedValue;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1975846633);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
            if ((i7 & 4) == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                i8 |= startRestartGroup.changed(str) ? 256 : 128;
                if ((i7 & 8) != 0) {
                    i8 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i8 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
                    if ((i7 & 16) == 0) {
                        i8 |= 24576;
                    } else if ((i6 & 24576) == 0) {
                        i8 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                    }
                    if ((i7 & 32) == 0) {
                        i8 |= 196608;
                    } else if ((i6 & 196608) == 0) {
                        i8 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
                    }
                    if ((i7 & 64) == 0) {
                        i8 |= 1572864;
                    } else if ((i6 & 1572864) == 0) {
                        i8 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
                    }
                    if ((i7 & 128) == 0) {
                        i8 |= 12582912;
                    } else if ((i6 & 12582912) == 0) {
                        i8 |= startRestartGroup.changedInstance(function12) ? 8388608 : 4194304;
                    }
                    if ((4793491 & i8) == 4793490 || !startRestartGroup.getSkipping()) {
                        modifier3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1975846633, i8, -1, "dk.molslinjen.ui.views.reusable.input.NumberSelectorTextField (NumberSelector.kt:205)");
                        }
                        startRestartGroup.startReplaceGroup(-454653236);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            LocalTime now = LocalTime.now();
                            Intrinsics.checkNotNullExpressionValue(now, "now(...)");
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new NumberSelectorTextFocusedState(BuildConfig.FLAVOR, now), null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        AppColor appColor = AppColor.INSTANCE;
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(new SelectionColors(appColor.m3280getTransparent0d7_KjU(), appColor.m3280getTransparent0d7_KjU(), null)), ComposableLambdaKt.rememberComposableLambda(-782250537, true, new NumberSelectorKt$NumberSelectorTextField$1(modifier3, function0, i5, function12, function1, z5, (MutableState) rememberedValue, textStyle, str), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
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
                        endRestartGroup.updateScope(new Function2() { // from class: c2.n
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit NumberSelectorTextField$lambda$23;
                                NumberSelectorTextField$lambda$23 = NumberSelectorKt.NumberSelectorTextField$lambda$23(Modifier.this, i5, str, textStyle, z5, function1, function0, function12, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                return NumberSelectorTextField$lambda$23;
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i7 & 16) == 0) {
                }
                if ((i7 & 32) == 0) {
                }
                if ((i7 & 64) == 0) {
                }
                if ((i7 & 128) == 0) {
                }
                if ((4793491 & i8) == 4793490) {
                }
                if (i9 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-454653236);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                AppColor appColor2 = AppColor.INSTANCE;
                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(new SelectionColors(appColor2.m3280getTransparent0d7_KjU(), appColor2.m3280getTransparent0d7_KjU(), null)), ComposableLambdaKt.rememberComposableLambda(-782250537, true, new NumberSelectorKt$NumberSelectorTextField$1(modifier3, function0, i5, function12, function1, z5, (MutableState) rememberedValue, textStyle, str), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i7 & 8) != 0) {
            }
            if ((i7 & 16) == 0) {
            }
            if ((i7 & 32) == 0) {
            }
            if ((i7 & 64) == 0) {
            }
            if ((i7 & 128) == 0) {
            }
            if ((4793491 & i8) == 4793490) {
            }
            if (i9 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-454653236);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            AppColor appColor22 = AppColor.INSTANCE;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(new SelectionColors(appColor22.m3280getTransparent0d7_KjU(), appColor22.m3280getTransparent0d7_KjU(), null)), ComposableLambdaKt.rememberComposableLambda(-782250537, true, new NumberSelectorKt$NumberSelectorTextField$1(modifier3, function0, i5, function12, function1, z5, (MutableState) rememberedValue, textStyle, str), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i7 & 4) == 0) {
        }
        if ((i7 & 8) != 0) {
        }
        if ((i7 & 16) == 0) {
        }
        if ((i7 & 32) == 0) {
        }
        if ((i7 & 64) == 0) {
        }
        if ((i7 & 128) == 0) {
        }
        if ((4793491 & i8) == 4793490) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-454653236);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        AppColor appColor222 = AppColor.INSTANCE;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(new SelectionColors(appColor222.m3280getTransparent0d7_KjU(), appColor222.m3280getTransparent0d7_KjU(), null)), ComposableLambdaKt.rememberComposableLambda(-782250537, true, new NumberSelectorKt$NumberSelectorTextField$1(modifier3, function0, i5, function12, function1, z5, (MutableState) rememberedValue, textStyle, str), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NumberSelectorTextFocusedState NumberSelectorTextField$lambda$21(MutableState<NumberSelectorTextFocusedState> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberSelectorTextField$lambda$23(Modifier modifier, int i5, String str, TextStyle textStyle, boolean z5, Function1 function1, Function0 function0, Function1 function12, int i6, int i7, Composer composer, int i8) {
        NumberSelectorTextField(modifier, i5, str, textStyle, z5, function1, function0, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final int getValidCount(int i5, int i6, int i7, int i8) {
        if (i5 >= i7) {
            if (i5 > i8) {
                return i8;
            }
            if (i5 <= i7 || i5 >= i6) {
                return i5;
            }
            if (i6 <= i8) {
                return i6;
            }
        }
        return i7;
    }
}
