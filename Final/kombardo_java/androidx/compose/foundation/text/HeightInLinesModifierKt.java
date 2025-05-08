package androidx.compose.foundation.text;

import android.support.v4.media.session.a;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a/\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\r²\u0006\f\u0010\f\u001a\u00020\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/text/TextStyle;", "textStyle", BuildConfig.FLAVOR, "minLines", "maxLines", "heightInLines", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;II)Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "validateMinMaxLines", "(II)V", BuildConfig.FLAVOR, "typeface", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class HeightInLinesModifierKt {
    public static final Modifier heightInLines(Modifier modifier, final TextStyle textStyle, final int i5, final int i6) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i7) {
                composer.startReplaceGroup(408240218);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408240218, i7, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:59)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(i5, i6);
                if (i5 == 1 && i6 == Integer.MAX_VALUE) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return companion;
                }
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                boolean changed = composer.changed(textStyle) | composer.changed(layoutDirection);
                TextStyle textStyle2 = textStyle;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = TextStyleKt.resolveDefaults(textStyle2, layoutDirection);
                    composer.updateRememberedValue(rememberedValue);
                }
                TextStyle textStyle3 = (TextStyle) rememberedValue;
                boolean changed2 = composer.changed(resolver) | composer.changed(textStyle3);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    FontFamily fontFamily = textStyle3.getFontFamily();
                    FontWeight fontWeight = textStyle3.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.INSTANCE.getNormal();
                    }
                    FontStyle m2300getFontStyle4Lr2A7w = textStyle3.m2300getFontStyle4Lr2A7w();
                    int value = m2300getFontStyle4Lr2A7w != null ? m2300getFontStyle4Lr2A7w.getValue() : FontStyle.INSTANCE.m2344getNormal_LCdwA();
                    FontSynthesis m2301getFontSynthesisZQGJjVo = textStyle3.m2301getFontSynthesisZQGJjVo();
                    rememberedValue2 = resolver.mo2325resolveDPcqOEQ(fontFamily, fontWeight, value, m2301getFontSynthesisZQGJjVo != null ? m2301getFontSynthesisZQGJjVo.getValue() : FontSynthesis.INSTANCE.m2354getAllGVVA2EU());
                    composer.updateRememberedValue(rememberedValue2);
                }
                State state = (State) rememberedValue2;
                boolean changed3 = composer.changed(state.getValue()) | composer.changed(density) | composer.changed(resolver) | composer.changed(textStyle) | composer.changed(layoutDirection);
                Object rememberedValue3 = composer.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = Integer.valueOf(IntSize.m2660getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle3, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                    composer.updateRememberedValue(rememberedValue3);
                }
                int intValue = ((Number) rememberedValue3).intValue();
                boolean changed4 = composer.changed(layoutDirection) | composer.changed(density) | composer.changed(resolver) | composer.changed(textStyle) | composer.changed(state.getValue());
                Object rememberedValue4 = composer.rememberedValue();
                if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = Integer.valueOf(IntSize.m2660getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle3, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
                    composer.updateRememberedValue(rememberedValue4);
                }
                int intValue2 = ((Number) rememberedValue4).intValue() - intValue;
                int i8 = i5;
                Integer valueOf = i8 == 1 ? null : Integer.valueOf(((i8 - 1) * intValue2) + intValue);
                int i9 = i6;
                Integer valueOf2 = i9 != Integer.MAX_VALUE ? Integer.valueOf(intValue + (intValue2 * (i9 - 1))) : null;
                Modifier m326heightInVpY3zN4 = SizeKt.m326heightInVpY3zN4(Modifier.INSTANCE, valueOf != null ? density.mo209toDpu2uoSUM(valueOf.intValue()) : Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM(), valueOf2 != null ? density.mo209toDpu2uoSUM(valueOf2.intValue()) : Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m326heightInVpY3zN4;
            }
        });
    }

    public static final void validateMinMaxLines(int i5, int i6) {
        if (i5 <= 0 || i6 <= 0) {
            throw new IllegalArgumentException(("both minLines " + i5 + " and maxLines " + i6 + " must be greater than zero").toString());
        }
        if (i5 <= i6) {
            return;
        }
        throw new IllegalArgumentException(("minLines " + i5 + " must be less than or equal to maxLines " + i6).toString());
    }
}
