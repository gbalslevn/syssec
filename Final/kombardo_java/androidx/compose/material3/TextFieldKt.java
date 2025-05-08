package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a·\u0002\u0010%\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&\u001aÁ\u0001\u00100\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0006\u0010/\u001a\u00020.H\u0001¢\u0006\u0004\b0\u00101\u001a\u001b\u00103\u001a\u00020\u001c*\u00020\u001c2\u0006\u00102\u001a\u00020\u001cH\u0002¢\u0006\u0004\b3\u00104\u001aR\u0010@\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001ar\u0010L\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020*2\u0006\u0010=\u001a\u00020<2\u0006\u0010I\u001a\u00020*2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a¡\u0001\u0010\\\u001a\u00020\u0003*\u00020M2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020P2\b\u0010R\u001a\u0004\u0018\u00010P2\b\u0010S\u001a\u0004\u0018\u00010P2\b\u0010T\u001a\u0004\u0018\u00010P2\b\u0010U\u001a\u0004\u0018\u00010P2\b\u0010V\u001a\u0004\u0018\u00010P2\b\u0010W\u001a\u0004\u0018\u00010P2\u0006\u0010X\u001a\u00020P2\b\u0010Y\u001a\u0004\u0018\u00010P2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u001c2\u0006\u0010[\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020*2\u0006\u0010I\u001a\u00020*H\u0002¢\u0006\u0004\b\\\u0010]\u001a\u0087\u0001\u0010_\u001a\u00020\u0003*\u00020M2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020P2\b\u0010S\u001a\u0004\u0018\u00010P2\b\u0010T\u001a\u0004\u0018\u00010P2\b\u0010U\u001a\u0004\u0018\u00010P2\b\u0010V\u001a\u0004\u0018\u00010P2\b\u0010W\u001a\u0004\u0018\u00010P2\u0006\u0010X\u001a\u00020P2\b\u0010Y\u001a\u0004\u0018\u00010P2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010I\u001a\u00020*2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b_\u0010`\u001a!\u0010d\u001a\u00020\u0005*\u00020\u00052\f\u0010c\u001a\b\u0012\u0004\u0012\u00020b0aH\u0000¢\u0006\u0004\bd\u0010e\"\u001a\u0010g\u001a\u00020f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k"}, d2 = {BuildConfig.FLAVOR, "value", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "enabled", "readOnly", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "Lkotlin/Function0;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "singleLine", BuildConfig.FLAVOR, "maxLines", "minLines", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/material3/TextFieldColors;", "colors", "TextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "textField", "leading", "trailing", BuildConfig.FLAVOR, "animationProgress", "container", "supporting", "Landroidx/compose/foundation/layout/PaddingValues;", "paddingValues", "TextFieldLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "from", "substractConstraintSafely", "(II)I", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "Landroidx/compose/ui/unit/Constraints;", "constraints", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "calculateWidth", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateHeight", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "Landroidx/compose/ui/layout/Placeable;", "textfieldPlaceable", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithLabel", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;IILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ZIIFF)V", "textPlaceable", "placeWithoutLabel", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;IILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "indicatorBorder", "drawIndicatorLine", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/State;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/Dp;", "TextFieldWithLabelVerticalPadding", "F", "getTextFieldWithLabelVerticalPadding", "()F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldKt {
    private static final float TextFieldWithLabelVerticalPadding = Dp.m2599constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:101:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z5, boolean z6, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z7, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z8, int i5, int i6, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i7, final int i8, final int i9, final int i10) {
        int i11;
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
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Modifier modifier2;
        boolean z9;
        TextStyle textStyle2;
        Function2<? super Composer, ? super Integer, Unit> function28;
        boolean z10;
        int i32;
        Shape shape2;
        TextFieldColors textFieldColors2;
        int i33;
        boolean z11;
        VisualTransformation visualTransformation2;
        KeyboardOptions keyboardOptions2;
        MutableInteractionSource mutableInteractionSource2;
        KeyboardActions keyboardActions2;
        boolean z12;
        int i34;
        int i35;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        int i36;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Function2<? super Composer, ? super Integer, Unit> function216;
        MutableInteractionSource mutableInteractionSource3;
        long m2298getColor0d7_KjU;
        final boolean z13;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final TextFieldColors textFieldColors3;
        final VisualTransformation visualTransformation3;
        final TextStyle textStyle3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i37;
        final int i38;
        final MutableInteractionSource mutableInteractionSource4;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final boolean z15;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final boolean z16;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        ScopeUpdateScope endRestartGroup;
        int i39;
        Composer startRestartGroup = composer.startRestartGroup(-676242365);
        if ((i10 & 1) != 0) {
            i11 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i11 = (startRestartGroup.changed(str) ? 4 : 2) | i7;
        } else {
            i11 = i7;
        }
        if ((i10 & 2) != 0) {
            i11 |= 48;
        } else if ((i7 & 48) == 0) {
            i11 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i12 = i10 & 4;
            if (i12 == 0) {
                i11 |= 384;
            } else if ((i7 & 384) == 0) {
                i11 |= startRestartGroup.changed(modifier) ? 256 : 128;
                i13 = i10 & 8;
                if (i13 != 0) {
                    i11 |= 3072;
                } else if ((i7 & 3072) == 0) {
                    i11 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i14 = i10 & 16;
                    if (i14 == 0) {
                        i11 |= 24576;
                    } else if ((i7 & 24576) == 0) {
                        i11 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        if ((i7 & 196608) == 0) {
                            i11 |= ((i10 & 32) == 0 && startRestartGroup.changed(textStyle)) ? 131072 : 65536;
                        }
                        i15 = i10 & 64;
                        if (i15 != 0) {
                            i11 |= 1572864;
                        } else if ((i7 & 1572864) == 0) {
                            i11 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                        }
                        i16 = i10 & 128;
                        if (i16 != 0) {
                            i11 |= 12582912;
                        } else if ((i7 & 12582912) == 0) {
                            i11 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        }
                        i17 = i10 & 256;
                        if (i17 != 0) {
                            i11 |= 100663296;
                        } else if ((i7 & 100663296) == 0) {
                            i11 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        }
                        i18 = i10 & 512;
                        if (i18 != 0) {
                            i11 |= 805306368;
                        } else if ((i7 & 805306368) == 0) {
                            i11 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                        }
                        i19 = i10 & 1024;
                        if (i19 != 0) {
                            i20 = i8 | 6;
                        } else if ((i8 & 6) == 0) {
                            i20 = i8 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i20 = i8;
                        }
                        i21 = i10 & 2048;
                        if (i21 != 0) {
                            i20 |= 48;
                        } else if ((i8 & 48) == 0) {
                            i20 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                        }
                        int i40 = i20;
                        i22 = i10 & 4096;
                        if (i22 != 0) {
                            i40 |= 384;
                        } else if ((i8 & 384) == 0) {
                            i40 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                            i23 = i10 & 8192;
                            if (i23 == 0) {
                                i40 |= 3072;
                            } else if ((i8 & 3072) == 0) {
                                i40 |= startRestartGroup.changed(z7) ? 2048 : 1024;
                                i24 = i10 & 16384;
                                if (i24 != 0) {
                                    i40 |= 24576;
                                    i25 = i24;
                                } else {
                                    i25 = i24;
                                    if ((i8 & 24576) == 0) {
                                        i40 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                        i26 = i10 & 32768;
                                        if (i26 == 0) {
                                            i40 |= 196608;
                                        } else if ((i8 & 196608) == 0) {
                                            i40 |= startRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                        }
                                        i27 = i10 & 65536;
                                        if (i27 == 0) {
                                            i40 |= 1572864;
                                        } else if ((i8 & 1572864) == 0) {
                                            i40 |= startRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                        }
                                        i28 = i10 & 131072;
                                        if (i28 == 0) {
                                            i40 |= 12582912;
                                        } else if ((i8 & 12582912) == 0) {
                                            i40 |= startRestartGroup.changed(z8) ? 8388608 : 4194304;
                                        }
                                        if ((i8 & 100663296) == 0) {
                                            i40 |= ((i10 & 262144) == 0 && startRestartGroup.changed(i5)) ? 67108864 : 33554432;
                                        }
                                        i29 = i10 & 524288;
                                        if (i29 == 0) {
                                            i40 |= 805306368;
                                        } else if ((i8 & 805306368) == 0) {
                                            i40 |= startRestartGroup.changed(i6) ? 536870912 : 268435456;
                                        }
                                        i30 = i10 & 1048576;
                                        if (i30 == 0) {
                                            i31 = i9 | 6;
                                        } else if ((i9 & 6) == 0) {
                                            i31 = i9 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                        } else {
                                            i31 = i9;
                                        }
                                        if ((i9 & 48) == 0) {
                                            i31 |= ((i10 & 2097152) == 0 && startRestartGroup.changed(shape)) ? 32 : 16;
                                        }
                                        if ((i9 & 384) == 0) {
                                            if ((i10 & 4194304) == 0 && startRestartGroup.changed(textFieldColors)) {
                                                i39 = 256;
                                                i31 |= i39;
                                            }
                                            i39 = 128;
                                            i31 |= i39;
                                        }
                                        int i41 = i31;
                                        if ((i11 & 306783379) != 306783378 && (306783379 & i40) == 306783378 && (i41 & 147) == 146 && startRestartGroup.getSkipping()) {
                                            startRestartGroup.skipToGroupEnd();
                                            modifier3 = modifier;
                                            z16 = z5;
                                            z13 = z6;
                                            textStyle3 = textStyle;
                                            function217 = function2;
                                            function223 = function22;
                                            function222 = function23;
                                            function220 = function24;
                                            function221 = function25;
                                            function219 = function26;
                                            function218 = function27;
                                            z15 = z7;
                                            visualTransformation3 = visualTransformation;
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActions3 = keyboardActions;
                                            z14 = z8;
                                            i37 = i5;
                                            i38 = i6;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape3 = shape;
                                            textFieldColors3 = textFieldColors;
                                        } else {
                                            startRestartGroup.startDefaults();
                                            if ((i7 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                modifier2 = i12 == 0 ? Modifier.INSTANCE : modifier;
                                                z9 = i13 == 0 ? true : z5;
                                                boolean z17 = i14 == 0 ? false : z6;
                                                if ((i10 & 32) == 0) {
                                                    textStyle2 = (TextStyle) startRestartGroup.consume(TextKt.getLocalTextStyle());
                                                    i11 &= -458753;
                                                } else {
                                                    textStyle2 = textStyle;
                                                }
                                                Function2<? super Composer, ? super Integer, Unit> function224 = i15 == 0 ? null : function2;
                                                function28 = i16 == 0 ? null : function22;
                                                Function2<? super Composer, ? super Integer, Unit> function225 = i17 == 0 ? null : function23;
                                                Function2<? super Composer, ? super Integer, Unit> function226 = i18 == 0 ? null : function24;
                                                Function2<? super Composer, ? super Integer, Unit> function227 = i19 == 0 ? null : function25;
                                                Function2<? super Composer, ? super Integer, Unit> function228 = i21 == 0 ? null : function26;
                                                Function2<? super Composer, ? super Integer, Unit> function229 = i22 == 0 ? null : function27;
                                                z10 = i23 == 0 ? false : z7;
                                                VisualTransformation none = i25 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                KeyboardOptions keyboardOptions4 = i26 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                KeyboardActions keyboardActions4 = i27 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                                boolean z18 = i28 == 0 ? false : z8;
                                                if ((i10 & 262144) == 0) {
                                                    i32 = z18 ? 1 : Integer.MAX_VALUE;
                                                    i40 &= -234881025;
                                                } else {
                                                    i32 = i5;
                                                }
                                                int i42 = i29 == 0 ? 1 : i6;
                                                MutableInteractionSource mutableInteractionSource5 = i30 == 0 ? mutableInteractionSource : null;
                                                Function2<? super Composer, ? super Integer, Unit> function230 = function225;
                                                Shape shape4 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                                                if ((i10 & 4194304) == 0) {
                                                    shape2 = shape4;
                                                    textFieldColors2 = TextFieldDefaults.INSTANCE.colors(startRestartGroup, 6);
                                                } else {
                                                    shape2 = shape4;
                                                    textFieldColors2 = textFieldColors;
                                                }
                                                i33 = i11;
                                                z11 = z17;
                                                visualTransformation2 = none;
                                                keyboardOptions2 = keyboardOptions4;
                                                mutableInteractionSource2 = mutableInteractionSource5;
                                                keyboardActions2 = keyboardActions4;
                                                z12 = z18;
                                                i34 = i32;
                                                i35 = i42;
                                                function29 = function226;
                                                function210 = function224;
                                                Function2<? super Composer, ? super Integer, Unit> function231 = function227;
                                                function211 = function230;
                                                function212 = function229;
                                                i36 = i40;
                                                function213 = function228;
                                                function214 = function231;
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i10 & 32) != 0) {
                                                    i11 &= -458753;
                                                }
                                                if ((262144 & i10) != 0) {
                                                    i40 &= -234881025;
                                                }
                                                modifier2 = modifier;
                                                z9 = z5;
                                                z11 = z6;
                                                textStyle2 = textStyle;
                                                function210 = function2;
                                                function28 = function22;
                                                function211 = function23;
                                                function214 = function25;
                                                function212 = function27;
                                                z10 = z7;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions2 = keyboardActions;
                                                z12 = z8;
                                                i34 = i5;
                                                i35 = i6;
                                                mutableInteractionSource2 = mutableInteractionSource;
                                                shape2 = shape;
                                                textFieldColors2 = textFieldColors;
                                                i33 = i11;
                                                i36 = i40;
                                                function29 = function24;
                                                function213 = function26;
                                            }
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                function215 = function214;
                                                function216 = function213;
                                            } else {
                                                function216 = function213;
                                                function215 = function214;
                                                ComposerKt.traceEventStart(-676242365, i33, i36, "androidx.compose.material3.TextField (TextField.kt:219)");
                                            }
                                            startRestartGroup.startReplaceGroup(-508515290);
                                            if (mutableInteractionSource2 != null) {
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            startRestartGroup.startReplaceGroup(-508509180);
                                            m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                                            if (m2298getColor0d7_KjU == 16) {
                                                m2298getColor0d7_KjU = textFieldColors2.m922textColorXeAY9LY$material3_release(z9, z10, FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource3, startRestartGroup, 0).getValue().booleanValue());
                                            }
                                            long j5 = m2298getColor0d7_KjU;
                                            startRestartGroup.endReplaceGroup();
                                            final TextStyle merge = textStyle2.merge(new TextStyle(j5, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
                                            final Modifier modifier4 = modifier2;
                                            final boolean z19 = z10;
                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                            final boolean z20 = z9;
                                            final boolean z21 = z11;
                                            final KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                            final KeyboardActions keyboardActions5 = keyboardActions2;
                                            final boolean z22 = z12;
                                            final int i43 = i34;
                                            final int i44 = i35;
                                            final VisualTransformation visualTransformation4 = visualTransformation2;
                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                                            final Function2<? super Composer, ? super Integer, Unit> function232 = function210;
                                            final Function2<? super Composer, ? super Integer, Unit> function233 = function28;
                                            final Function2<? super Composer, ? super Integer, Unit> function234 = function211;
                                            final Function2<? super Composer, ? super Integer, Unit> function235 = function29;
                                            final Function2<? super Composer, ? super Integer, Unit> function236 = function215;
                                            final Function2<? super Composer, ? super Integer, Unit> function237 = function216;
                                            final Function2<? super Composer, ? super Integer, Unit> function238 = function212;
                                            final Shape shape5 = shape2;
                                            boolean z23 = z11;
                                            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                    invoke(composer2, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i45) {
                                                    if ((i45 & 3) == 2 && composer2.getSkipping()) {
                                                        composer2.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                                                    }
                                                    Modifier modifier5 = Modifier.this;
                                                    boolean z24 = z19;
                                                    Strings.Companion companion = Strings.INSTANCE;
                                                    Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                                    Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                                                    SolidColor solidColor = new SolidColor(textFieldColors4.m914cursorColorvNxB06k$material3_release(z19), null);
                                                    final String str2 = str;
                                                    Function1<String, Unit> function12 = function1;
                                                    final boolean z25 = z20;
                                                    boolean z26 = z21;
                                                    TextStyle textStyle4 = merge;
                                                    KeyboardOptions keyboardOptions6 = keyboardOptions5;
                                                    KeyboardActions keyboardActions6 = keyboardActions5;
                                                    final boolean z27 = z22;
                                                    int i46 = i43;
                                                    int i47 = i44;
                                                    final VisualTransformation visualTransformation5 = visualTransformation4;
                                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                    final boolean z28 = z19;
                                                    final Function2<Composer, Integer, Unit> function239 = function232;
                                                    final Function2<Composer, Integer, Unit> function240 = function233;
                                                    final Function2<Composer, Integer, Unit> function241 = function234;
                                                    final Function2<Composer, Integer, Unit> function242 = function235;
                                                    final Function2<Composer, Integer, Unit> function243 = function236;
                                                    final Function2<Composer, Integer, Unit> function244 = function237;
                                                    final Function2<Composer, Integer, Unit> function245 = function238;
                                                    final Shape shape6 = shape5;
                                                    final TextFieldColors textFieldColors5 = textFieldColors4;
                                                    BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                                                            int i49;
                                                            if ((i48 & 6) == 0) {
                                                                i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                                                            } else {
                                                                i49 = i48;
                                                            }
                                                            if ((i49 & 19) == 18 && composer3.getSkipping()) {
                                                                composer3.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                                            }
                                                            TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function239, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, composer2, 54), composer2, 0, 196608, 4096);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            z13 = z23;
                                            function217 = function210;
                                            textFieldColors3 = textFieldColors2;
                                            visualTransformation3 = visualTransformation2;
                                            textStyle3 = textStyle2;
                                            keyboardOptions3 = keyboardOptions2;
                                            keyboardActions3 = keyboardActions2;
                                            z14 = z12;
                                            i37 = i34;
                                            i38 = i35;
                                            mutableInteractionSource4 = mutableInteractionSource2;
                                            shape3 = shape2;
                                            function218 = function212;
                                            function219 = function216;
                                            z15 = z10;
                                            function220 = function29;
                                            z16 = z9;
                                            function221 = function215;
                                            Function2<? super Composer, ? super Integer, Unit> function239 = function28;
                                            function222 = function211;
                                            modifier3 = modifier2;
                                            function223 = function239;
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$2
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                    invoke(composer2, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i45) {
                                                    TextFieldKt.TextField(str, function1, modifier3, z16, z13, textStyle3, function217, function223, function222, function220, function221, function219, function218, z15, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i37, i38, mutableInteractionSource4, shape3, textFieldColors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), RecomposeScopeImplKt.updateChangedFlags(i8), RecomposeScopeImplKt.updateChangedFlags(i9), i10);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i26 = i10 & 32768;
                                if (i26 == 0) {
                                }
                                i27 = i10 & 65536;
                                if (i27 == 0) {
                                }
                                i28 = i10 & 131072;
                                if (i28 == 0) {
                                }
                                if ((i8 & 100663296) == 0) {
                                }
                                i29 = i10 & 524288;
                                if (i29 == 0) {
                                }
                                i30 = i10 & 1048576;
                                if (i30 == 0) {
                                }
                                if ((i9 & 48) == 0) {
                                }
                                if ((i9 & 384) == 0) {
                                }
                                int i412 = i31;
                                if ((i11 & 306783379) != 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i7 & 1) != 0) {
                                }
                                if (i12 == 0) {
                                }
                                if (i13 == 0) {
                                }
                                if (i14 == 0) {
                                }
                                if ((i10 & 32) == 0) {
                                }
                                if (i15 == 0) {
                                }
                                if (i16 == 0) {
                                }
                                if (i17 == 0) {
                                }
                                if (i18 == 0) {
                                }
                                if (i19 == 0) {
                                }
                                if (i21 == 0) {
                                }
                                if (i22 == 0) {
                                }
                                if (i23 == 0) {
                                }
                                if (i25 == 0) {
                                }
                                if (i26 == 0) {
                                }
                                if (i27 == 0) {
                                }
                                if (i28 == 0) {
                                }
                                if ((i10 & 262144) == 0) {
                                }
                                if (i29 == 0) {
                                }
                                if (i30 == 0) {
                                }
                                Function2<? super Composer, ? super Integer, Unit> function2302 = function225;
                                Shape shape42 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                                if ((i10 & 4194304) == 0) {
                                }
                                i33 = i11;
                                z11 = z17;
                                visualTransformation2 = none;
                                keyboardOptions2 = keyboardOptions4;
                                mutableInteractionSource2 = mutableInteractionSource5;
                                keyboardActions2 = keyboardActions4;
                                z12 = z18;
                                i34 = i32;
                                i35 = i42;
                                function29 = function226;
                                function210 = function224;
                                Function2<? super Composer, ? super Integer, Unit> function2312 = function227;
                                function211 = function2302;
                                function212 = function229;
                                i36 = i40;
                                function213 = function228;
                                function214 = function2312;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.startReplaceGroup(-508515290);
                                if (mutableInteractionSource2 != null) {
                                }
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.startReplaceGroup(-508509180);
                                m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                                if (m2298getColor0d7_KjU == 16) {
                                }
                                long j52 = m2298getColor0d7_KjU;
                                startRestartGroup.endReplaceGroup();
                                final TextStyle merge2 = textStyle2.merge(new TextStyle(j52, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
                                final Modifier modifier42 = modifier2;
                                final boolean z192 = z10;
                                final TextFieldColors textFieldColors42 = textFieldColors2;
                                final boolean z202 = z9;
                                final boolean z212 = z11;
                                final KeyboardOptions keyboardOptions52 = keyboardOptions2;
                                final KeyboardActions keyboardActions52 = keyboardActions2;
                                final boolean z222 = z12;
                                final int i432 = i34;
                                final int i442 = i35;
                                final VisualTransformation visualTransformation42 = visualTransformation2;
                                final MutableInteractionSource mutableInteractionSource62 = mutableInteractionSource3;
                                final Function2<? super Composer, ? super Integer, Unit> function2322 = function210;
                                final Function2<? super Composer, ? super Integer, Unit> function2332 = function28;
                                final Function2<? super Composer, ? super Integer, Unit> function2342 = function211;
                                final Function2<? super Composer, ? super Integer, Unit> function2352 = function29;
                                final Function2<? super Composer, ? super Integer, Unit> function2362 = function215;
                                final Function2<? super Composer, ? super Integer, Unit> function2372 = function216;
                                final Function2<? super Composer, ? super Integer, Unit> function2382 = function212;
                                final Shape shape52 = shape2;
                                boolean z232 = z11;
                                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i45) {
                                        if ((i45 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                                        }
                                        Modifier modifier5 = Modifier.this;
                                        boolean z24 = z192;
                                        Strings.Companion companion = Strings.INSTANCE;
                                        Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                        Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                                        SolidColor solidColor = new SolidColor(textFieldColors42.m914cursorColorvNxB06k$material3_release(z192), null);
                                        final String str2 = str;
                                        Function1<String, Unit> function12 = function1;
                                        final boolean z25 = z202;
                                        boolean z26 = z212;
                                        TextStyle textStyle4 = merge2;
                                        KeyboardOptions keyboardOptions6 = keyboardOptions52;
                                        KeyboardActions keyboardActions6 = keyboardActions52;
                                        final boolean z27 = z222;
                                        int i46 = i432;
                                        int i47 = i442;
                                        final VisualTransformation visualTransformation5 = visualTransformation42;
                                        final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource62;
                                        final boolean z28 = z192;
                                        final Function2<? super Composer, ? super Integer, Unit> function2392 = function2322;
                                        final Function2<? super Composer, ? super Integer, Unit> function240 = function2332;
                                        final Function2<? super Composer, ? super Integer, Unit> function241 = function2342;
                                        final Function2<? super Composer, ? super Integer, Unit> function242 = function2352;
                                        final Function2<? super Composer, ? super Integer, Unit> function243 = function2362;
                                        final Function2<? super Composer, ? super Integer, Unit> function244 = function2372;
                                        final Function2<? super Composer, ? super Integer, Unit> function245 = function2382;
                                        final Shape shape6 = shape52;
                                        final TextFieldColors textFieldColors5 = textFieldColors42;
                                        BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                                                invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                                                int i49;
                                                if ((i48 & 6) == 0) {
                                                    i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                                                } else {
                                                    i49 = i48;
                                                }
                                                if ((i49 & 19) == 18 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                                }
                                                TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function2392, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54), composer2, 0, 196608, 4096);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                z13 = z232;
                                function217 = function210;
                                textFieldColors3 = textFieldColors2;
                                visualTransformation3 = visualTransformation2;
                                textStyle3 = textStyle2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                z14 = z12;
                                i37 = i34;
                                i38 = i35;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                shape3 = shape2;
                                function218 = function212;
                                function219 = function216;
                                z15 = z10;
                                function220 = function29;
                                z16 = z9;
                                function221 = function215;
                                Function2<? super Composer, ? super Integer, Unit> function2392 = function28;
                                function222 = function211;
                                modifier3 = modifier2;
                                function223 = function2392;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i24 = i10 & 16384;
                            if (i24 != 0) {
                            }
                            i26 = i10 & 32768;
                            if (i26 == 0) {
                            }
                            i27 = i10 & 65536;
                            if (i27 == 0) {
                            }
                            i28 = i10 & 131072;
                            if (i28 == 0) {
                            }
                            if ((i8 & 100663296) == 0) {
                            }
                            i29 = i10 & 524288;
                            if (i29 == 0) {
                            }
                            i30 = i10 & 1048576;
                            if (i30 == 0) {
                            }
                            if ((i9 & 48) == 0) {
                            }
                            if ((i9 & 384) == 0) {
                            }
                            int i4122 = i31;
                            if ((i11 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i7 & 1) != 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            if (i14 == 0) {
                            }
                            if ((i10 & 32) == 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (i17 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i19 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i23 == 0) {
                            }
                            if (i25 == 0) {
                            }
                            if (i26 == 0) {
                            }
                            if (i27 == 0) {
                            }
                            if (i28 == 0) {
                            }
                            if ((i10 & 262144) == 0) {
                            }
                            if (i29 == 0) {
                            }
                            if (i30 == 0) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function23022 = function225;
                            Shape shape422 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                            if ((i10 & 4194304) == 0) {
                            }
                            i33 = i11;
                            z11 = z17;
                            visualTransformation2 = none;
                            keyboardOptions2 = keyboardOptions4;
                            mutableInteractionSource2 = mutableInteractionSource5;
                            keyboardActions2 = keyboardActions4;
                            z12 = z18;
                            i34 = i32;
                            i35 = i42;
                            function29 = function226;
                            function210 = function224;
                            Function2<? super Composer, ? super Integer, Unit> function23122 = function227;
                            function211 = function23022;
                            function212 = function229;
                            i36 = i40;
                            function213 = function228;
                            function214 = function23122;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.startReplaceGroup(-508515290);
                            if (mutableInteractionSource2 != null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.startReplaceGroup(-508509180);
                            m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                            if (m2298getColor0d7_KjU == 16) {
                            }
                            long j522 = m2298getColor0d7_KjU;
                            startRestartGroup.endReplaceGroup();
                            final TextStyle merge22 = textStyle2.merge(new TextStyle(j522, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
                            final Modifier modifier422 = modifier2;
                            final boolean z1922 = z10;
                            final TextFieldColors textFieldColors422 = textFieldColors2;
                            final boolean z2022 = z9;
                            final boolean z2122 = z11;
                            final KeyboardOptions keyboardOptions522 = keyboardOptions2;
                            final KeyboardActions keyboardActions522 = keyboardActions2;
                            final boolean z2222 = z12;
                            final int i4322 = i34;
                            final int i4422 = i35;
                            final VisualTransformation visualTransformation422 = visualTransformation2;
                            final MutableInteractionSource mutableInteractionSource622 = mutableInteractionSource3;
                            final Function2<? super Composer, ? super Integer, Unit> function23222 = function210;
                            final Function2<? super Composer, ? super Integer, Unit> function23322 = function28;
                            final Function2<? super Composer, ? super Integer, Unit> function23422 = function211;
                            final Function2<? super Composer, ? super Integer, Unit> function23522 = function29;
                            final Function2<? super Composer, ? super Integer, Unit> function23622 = function215;
                            final Function2<? super Composer, ? super Integer, Unit> function23722 = function216;
                            final Function2<? super Composer, ? super Integer, Unit> function23822 = function212;
                            final Shape shape522 = shape2;
                            boolean z2322 = z11;
                            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i45) {
                                    if ((i45 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                                    }
                                    Modifier modifier5 = Modifier.this;
                                    boolean z24 = z1922;
                                    Strings.Companion companion = Strings.INSTANCE;
                                    Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                                    SolidColor solidColor = new SolidColor(textFieldColors422.m914cursorColorvNxB06k$material3_release(z1922), null);
                                    final String str2 = str;
                                    Function1<String, Unit> function12 = function1;
                                    final boolean z25 = z2022;
                                    boolean z26 = z2122;
                                    TextStyle textStyle4 = merge22;
                                    KeyboardOptions keyboardOptions6 = keyboardOptions522;
                                    KeyboardActions keyboardActions6 = keyboardActions522;
                                    final boolean z27 = z2222;
                                    int i46 = i4322;
                                    int i47 = i4422;
                                    final VisualTransformation visualTransformation5 = visualTransformation422;
                                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource622;
                                    final boolean z28 = z1922;
                                    final Function2<? super Composer, ? super Integer, Unit> function23922 = function23222;
                                    final Function2<? super Composer, ? super Integer, Unit> function240 = function23322;
                                    final Function2<? super Composer, ? super Integer, Unit> function241 = function23422;
                                    final Function2<? super Composer, ? super Integer, Unit> function242 = function23522;
                                    final Function2<? super Composer, ? super Integer, Unit> function243 = function23622;
                                    final Function2<? super Composer, ? super Integer, Unit> function244 = function23722;
                                    final Function2<? super Composer, ? super Integer, Unit> function245 = function23822;
                                    final Shape shape6 = shape522;
                                    final TextFieldColors textFieldColors5 = textFieldColors422;
                                    BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                                            int i49;
                                            if ((i48 & 6) == 0) {
                                                i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                                            } else {
                                                i49 = i48;
                                            }
                                            if ((i49 & 19) == 18 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                            }
                                            TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function23922, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer2, 54), composer2, 0, 196608, 4096);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z13 = z2322;
                            function217 = function210;
                            textFieldColors3 = textFieldColors2;
                            visualTransformation3 = visualTransformation2;
                            textStyle3 = textStyle2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            z14 = z12;
                            i37 = i34;
                            i38 = i35;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            shape3 = shape2;
                            function218 = function212;
                            function219 = function216;
                            z15 = z10;
                            function220 = function29;
                            z16 = z9;
                            function221 = function215;
                            Function2<? super Composer, ? super Integer, Unit> function23922 = function28;
                            function222 = function211;
                            modifier3 = modifier2;
                            function223 = function23922;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i23 = i10 & 8192;
                        if (i23 == 0) {
                        }
                        i24 = i10 & 16384;
                        if (i24 != 0) {
                        }
                        i26 = i10 & 32768;
                        if (i26 == 0) {
                        }
                        i27 = i10 & 65536;
                        if (i27 == 0) {
                        }
                        i28 = i10 & 131072;
                        if (i28 == 0) {
                        }
                        if ((i8 & 100663296) == 0) {
                        }
                        i29 = i10 & 524288;
                        if (i29 == 0) {
                        }
                        i30 = i10 & 1048576;
                        if (i30 == 0) {
                        }
                        if ((i9 & 48) == 0) {
                        }
                        if ((i9 & 384) == 0) {
                        }
                        int i41222 = i31;
                        if ((i11 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i7 & 1) != 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if ((i10 & 32) == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if (i25 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if ((i10 & 262144) == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i30 == 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function230222 = function225;
                        Shape shape4222 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                        if ((i10 & 4194304) == 0) {
                        }
                        i33 = i11;
                        z11 = z17;
                        visualTransformation2 = none;
                        keyboardOptions2 = keyboardOptions4;
                        mutableInteractionSource2 = mutableInteractionSource5;
                        keyboardActions2 = keyboardActions4;
                        z12 = z18;
                        i34 = i32;
                        i35 = i42;
                        function29 = function226;
                        function210 = function224;
                        Function2<? super Composer, ? super Integer, Unit> function231222 = function227;
                        function211 = function230222;
                        function212 = function229;
                        i36 = i40;
                        function213 = function228;
                        function214 = function231222;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceGroup(-508515290);
                        if (mutableInteractionSource2 != null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-508509180);
                        m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                        if (m2298getColor0d7_KjU == 16) {
                        }
                        long j5222 = m2298getColor0d7_KjU;
                        startRestartGroup.endReplaceGroup();
                        final TextStyle merge222 = textStyle2.merge(new TextStyle(j5222, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
                        final Modifier modifier4222 = modifier2;
                        final boolean z19222 = z10;
                        final TextFieldColors textFieldColors4222 = textFieldColors2;
                        final boolean z20222 = z9;
                        final boolean z21222 = z11;
                        final KeyboardOptions keyboardOptions5222 = keyboardOptions2;
                        final KeyboardActions keyboardActions5222 = keyboardActions2;
                        final boolean z22222 = z12;
                        final int i43222 = i34;
                        final int i44222 = i35;
                        final VisualTransformation visualTransformation4222 = visualTransformation2;
                        final MutableInteractionSource mutableInteractionSource6222 = mutableInteractionSource3;
                        final Function2<? super Composer, ? super Integer, Unit> function232222 = function210;
                        final Function2<? super Composer, ? super Integer, Unit> function233222 = function28;
                        final Function2<? super Composer, ? super Integer, Unit> function234222 = function211;
                        final Function2<? super Composer, ? super Integer, Unit> function235222 = function29;
                        final Function2<? super Composer, ? super Integer, Unit> function236222 = function215;
                        final Function2<? super Composer, ? super Integer, Unit> function237222 = function216;
                        final Function2<? super Composer, ? super Integer, Unit> function238222 = function212;
                        final Shape shape5222 = shape2;
                        boolean z23222 = z11;
                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i45) {
                                if ((i45 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                                }
                                Modifier modifier5 = Modifier.this;
                                boolean z24 = z19222;
                                Strings.Companion companion = Strings.INSTANCE;
                                Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                                SolidColor solidColor = new SolidColor(textFieldColors4222.m914cursorColorvNxB06k$material3_release(z19222), null);
                                final String str2 = str;
                                Function1<String, Unit> function12 = function1;
                                final boolean z25 = z20222;
                                boolean z26 = z21222;
                                TextStyle textStyle4 = merge222;
                                KeyboardOptions keyboardOptions6 = keyboardOptions5222;
                                KeyboardActions keyboardActions6 = keyboardActions5222;
                                final boolean z27 = z22222;
                                int i46 = i43222;
                                int i47 = i44222;
                                final VisualTransformation visualTransformation5 = visualTransformation4222;
                                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6222;
                                final boolean z28 = z19222;
                                final Function2<? super Composer, ? super Integer, Unit> function239222 = function232222;
                                final Function2<? super Composer, ? super Integer, Unit> function240 = function233222;
                                final Function2<? super Composer, ? super Integer, Unit> function241 = function234222;
                                final Function2<? super Composer, ? super Integer, Unit> function242 = function235222;
                                final Function2<? super Composer, ? super Integer, Unit> function243 = function236222;
                                final Function2<? super Composer, ? super Integer, Unit> function244 = function237222;
                                final Function2<? super Composer, ? super Integer, Unit> function245 = function238222;
                                final Shape shape6 = shape5222;
                                final TextFieldColors textFieldColors5 = textFieldColors4222;
                                BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                                        invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                                        int i49;
                                        if ((i48 & 6) == 0) {
                                            i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                                        } else {
                                            i49 = i48;
                                        }
                                        if ((i49 & 19) == 18 && composer3.getSkipping()) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                        }
                                        TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function239222, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, 0, 196608, 4096);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z13 = z23222;
                        function217 = function210;
                        textFieldColors3 = textFieldColors2;
                        visualTransformation3 = visualTransformation2;
                        textStyle3 = textStyle2;
                        keyboardOptions3 = keyboardOptions2;
                        keyboardActions3 = keyboardActions2;
                        z14 = z12;
                        i37 = i34;
                        i38 = i35;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        shape3 = shape2;
                        function218 = function212;
                        function219 = function216;
                        z15 = z10;
                        function220 = function29;
                        z16 = z9;
                        function221 = function215;
                        Function2<? super Composer, ? super Integer, Unit> function239222 = function28;
                        function222 = function211;
                        modifier3 = modifier2;
                        function223 = function239222;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i7 & 196608) == 0) {
                    }
                    i15 = i10 & 64;
                    if (i15 != 0) {
                    }
                    i16 = i10 & 128;
                    if (i16 != 0) {
                    }
                    i17 = i10 & 256;
                    if (i17 != 0) {
                    }
                    i18 = i10 & 512;
                    if (i18 != 0) {
                    }
                    i19 = i10 & 1024;
                    if (i19 != 0) {
                    }
                    i21 = i10 & 2048;
                    if (i21 != 0) {
                    }
                    int i402 = i20;
                    i22 = i10 & 4096;
                    if (i22 != 0) {
                    }
                    i23 = i10 & 8192;
                    if (i23 == 0) {
                    }
                    i24 = i10 & 16384;
                    if (i24 != 0) {
                    }
                    i26 = i10 & 32768;
                    if (i26 == 0) {
                    }
                    i27 = i10 & 65536;
                    if (i27 == 0) {
                    }
                    i28 = i10 & 131072;
                    if (i28 == 0) {
                    }
                    if ((i8 & 100663296) == 0) {
                    }
                    i29 = i10 & 524288;
                    if (i29 == 0) {
                    }
                    i30 = i10 & 1048576;
                    if (i30 == 0) {
                    }
                    if ((i9 & 48) == 0) {
                    }
                    if ((i9 & 384) == 0) {
                    }
                    int i412222 = i31;
                    if ((i11 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i7 & 1) != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if ((i10 & 32) == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if (i25 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if ((i10 & 262144) == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i30 == 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function2302222 = function225;
                    Shape shape42222 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                    if ((i10 & 4194304) == 0) {
                    }
                    i33 = i11;
                    z11 = z17;
                    visualTransformation2 = none;
                    keyboardOptions2 = keyboardOptions4;
                    mutableInteractionSource2 = mutableInteractionSource5;
                    keyboardActions2 = keyboardActions4;
                    z12 = z18;
                    i34 = i32;
                    i35 = i42;
                    function29 = function226;
                    function210 = function224;
                    Function2<? super Composer, ? super Integer, Unit> function2312222 = function227;
                    function211 = function2302222;
                    function212 = function229;
                    i36 = i402;
                    function213 = function228;
                    function214 = function2312222;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(-508515290);
                    if (mutableInteractionSource2 != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-508509180);
                    m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                    if (m2298getColor0d7_KjU == 16) {
                    }
                    long j52222 = m2298getColor0d7_KjU;
                    startRestartGroup.endReplaceGroup();
                    final TextStyle merge2222 = textStyle2.merge(new TextStyle(j52222, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
                    final Modifier modifier42222 = modifier2;
                    final boolean z192222 = z10;
                    final TextFieldColors textFieldColors42222 = textFieldColors2;
                    final boolean z202222 = z9;
                    final boolean z212222 = z11;
                    final KeyboardOptions keyboardOptions52222 = keyboardOptions2;
                    final KeyboardActions keyboardActions52222 = keyboardActions2;
                    final boolean z222222 = z12;
                    final int i432222 = i34;
                    final int i442222 = i35;
                    final VisualTransformation visualTransformation42222 = visualTransformation2;
                    final MutableInteractionSource mutableInteractionSource62222 = mutableInteractionSource3;
                    final Function2<? super Composer, ? super Integer, Unit> function2322222 = function210;
                    final Function2<? super Composer, ? super Integer, Unit> function2332222 = function28;
                    final Function2<? super Composer, ? super Integer, Unit> function2342222 = function211;
                    final Function2<? super Composer, ? super Integer, Unit> function2352222 = function29;
                    final Function2<? super Composer, ? super Integer, Unit> function2362222 = function215;
                    final Function2<? super Composer, ? super Integer, Unit> function2372222 = function216;
                    final Function2<? super Composer, ? super Integer, Unit> function2382222 = function212;
                    final Shape shape52222 = shape2;
                    boolean z232222 = z11;
                    CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i45) {
                            if ((i45 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                            }
                            Modifier modifier5 = Modifier.this;
                            boolean z24 = z192222;
                            Strings.Companion companion = Strings.INSTANCE;
                            Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                            SolidColor solidColor = new SolidColor(textFieldColors42222.m914cursorColorvNxB06k$material3_release(z192222), null);
                            final String str2 = str;
                            Function1<String, Unit> function12 = function1;
                            final boolean z25 = z202222;
                            boolean z26 = z212222;
                            TextStyle textStyle4 = merge2222;
                            KeyboardOptions keyboardOptions6 = keyboardOptions52222;
                            KeyboardActions keyboardActions6 = keyboardActions52222;
                            final boolean z27 = z222222;
                            int i46 = i432222;
                            int i47 = i442222;
                            final VisualTransformation visualTransformation5 = visualTransformation42222;
                            final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource62222;
                            final boolean z28 = z192222;
                            final Function2<? super Composer, ? super Integer, Unit> function2392222 = function2322222;
                            final Function2<? super Composer, ? super Integer, Unit> function240 = function2332222;
                            final Function2<? super Composer, ? super Integer, Unit> function241 = function2342222;
                            final Function2<? super Composer, ? super Integer, Unit> function242 = function2352222;
                            final Function2<? super Composer, ? super Integer, Unit> function243 = function2362222;
                            final Function2<? super Composer, ? super Integer, Unit> function244 = function2372222;
                            final Function2<? super Composer, ? super Integer, Unit> function245 = function2382222;
                            final Shape shape6 = shape52222;
                            final TextFieldColors textFieldColors5 = textFieldColors42222;
                            BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                                    int i49;
                                    if ((i48 & 6) == 0) {
                                        i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                                    } else {
                                        i49 = i48;
                                    }
                                    if ((i49 & 19) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                    }
                                    TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function2392222, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 0, 196608, 4096);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z13 = z232222;
                    function217 = function210;
                    textFieldColors3 = textFieldColors2;
                    visualTransformation3 = visualTransformation2;
                    textStyle3 = textStyle2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions3 = keyboardActions2;
                    z14 = z12;
                    i37 = i34;
                    i38 = i35;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    shape3 = shape2;
                    function218 = function212;
                    function219 = function216;
                    z15 = z10;
                    function220 = function29;
                    z16 = z9;
                    function221 = function215;
                    Function2<? super Composer, ? super Integer, Unit> function2392222 = function28;
                    function222 = function211;
                    modifier3 = modifier2;
                    function223 = function2392222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i14 = i10 & 16;
                if (i14 == 0) {
                }
                if ((i7 & 196608) == 0) {
                }
                i15 = i10 & 64;
                if (i15 != 0) {
                }
                i16 = i10 & 128;
                if (i16 != 0) {
                }
                i17 = i10 & 256;
                if (i17 != 0) {
                }
                i18 = i10 & 512;
                if (i18 != 0) {
                }
                i19 = i10 & 1024;
                if (i19 != 0) {
                }
                i21 = i10 & 2048;
                if (i21 != 0) {
                }
                int i4022 = i20;
                i22 = i10 & 4096;
                if (i22 != 0) {
                }
                i23 = i10 & 8192;
                if (i23 == 0) {
                }
                i24 = i10 & 16384;
                if (i24 != 0) {
                }
                i26 = i10 & 32768;
                if (i26 == 0) {
                }
                i27 = i10 & 65536;
                if (i27 == 0) {
                }
                i28 = i10 & 131072;
                if (i28 == 0) {
                }
                if ((i8 & 100663296) == 0) {
                }
                i29 = i10 & 524288;
                if (i29 == 0) {
                }
                i30 = i10 & 1048576;
                if (i30 == 0) {
                }
                if ((i9 & 48) == 0) {
                }
                if ((i9 & 384) == 0) {
                }
                int i4122222 = i31;
                if ((i11 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i7 & 1) != 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if ((i10 & 32) == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (i21 == 0) {
                }
                if (i22 == 0) {
                }
                if (i23 == 0) {
                }
                if (i25 == 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i28 == 0) {
                }
                if ((i10 & 262144) == 0) {
                }
                if (i29 == 0) {
                }
                if (i30 == 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function23022222 = function225;
                Shape shape422222 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
                if ((i10 & 4194304) == 0) {
                }
                i33 = i11;
                z11 = z17;
                visualTransformation2 = none;
                keyboardOptions2 = keyboardOptions4;
                mutableInteractionSource2 = mutableInteractionSource5;
                keyboardActions2 = keyboardActions4;
                z12 = z18;
                i34 = i32;
                i35 = i42;
                function29 = function226;
                function210 = function224;
                Function2<? super Composer, ? super Integer, Unit> function23122222 = function227;
                function211 = function23022222;
                function212 = function229;
                i36 = i4022;
                function213 = function228;
                function214 = function23122222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-508515290);
                if (mutableInteractionSource2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-508509180);
                m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                if (m2298getColor0d7_KjU == 16) {
                }
                long j522222 = m2298getColor0d7_KjU;
                startRestartGroup.endReplaceGroup();
                final TextStyle merge22222 = textStyle2.merge(new TextStyle(j522222, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
                final Modifier modifier422222 = modifier2;
                final boolean z1922222 = z10;
                final TextFieldColors textFieldColors422222 = textFieldColors2;
                final boolean z2022222 = z9;
                final boolean z2122222 = z11;
                final KeyboardOptions keyboardOptions522222 = keyboardOptions2;
                final KeyboardActions keyboardActions522222 = keyboardActions2;
                final boolean z2222222 = z12;
                final int i4322222 = i34;
                final int i4422222 = i35;
                final VisualTransformation visualTransformation422222 = visualTransformation2;
                final MutableInteractionSource mutableInteractionSource622222 = mutableInteractionSource3;
                final Function2<? super Composer, ? super Integer, Unit> function23222222 = function210;
                final Function2<? super Composer, ? super Integer, Unit> function23322222 = function28;
                final Function2<? super Composer, ? super Integer, Unit> function23422222 = function211;
                final Function2<? super Composer, ? super Integer, Unit> function23522222 = function29;
                final Function2<? super Composer, ? super Integer, Unit> function23622222 = function215;
                final Function2<? super Composer, ? super Integer, Unit> function23722222 = function216;
                final Function2<? super Composer, ? super Integer, Unit> function23822222 = function212;
                final Shape shape522222 = shape2;
                boolean z2322222 = z11;
                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i45) {
                        if ((i45 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                        }
                        Modifier modifier5 = Modifier.this;
                        boolean z24 = z1922222;
                        Strings.Companion companion = Strings.INSTANCE;
                        Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                        SolidColor solidColor = new SolidColor(textFieldColors422222.m914cursorColorvNxB06k$material3_release(z1922222), null);
                        final String str2 = str;
                        Function1<String, Unit> function12 = function1;
                        final boolean z25 = z2022222;
                        boolean z26 = z2122222;
                        TextStyle textStyle4 = merge22222;
                        KeyboardOptions keyboardOptions6 = keyboardOptions522222;
                        KeyboardActions keyboardActions6 = keyboardActions522222;
                        final boolean z27 = z2222222;
                        int i46 = i4322222;
                        int i47 = i4422222;
                        final VisualTransformation visualTransformation5 = visualTransformation422222;
                        final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource622222;
                        final boolean z28 = z1922222;
                        final Function2<? super Composer, ? super Integer, Unit> function23922222 = function23222222;
                        final Function2<? super Composer, ? super Integer, Unit> function240 = function23322222;
                        final Function2<? super Composer, ? super Integer, Unit> function241 = function23422222;
                        final Function2<? super Composer, ? super Integer, Unit> function242 = function23522222;
                        final Function2<? super Composer, ? super Integer, Unit> function243 = function23622222;
                        final Function2<? super Composer, ? super Integer, Unit> function244 = function23722222;
                        final Function2<? super Composer, ? super Integer, Unit> function245 = function23822222;
                        final Shape shape6 = shape522222;
                        final TextFieldColors textFieldColors5 = textFieldColors422222;
                        BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                                invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                                int i49;
                                if ((i48 & 6) == 0) {
                                    i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                                } else {
                                    i49 = i48;
                                }
                                if ((i49 & 19) == 18 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                                }
                                TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function23922222, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 0, 196608, 4096);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                z13 = z2322222;
                function217 = function210;
                textFieldColors3 = textFieldColors2;
                visualTransformation3 = visualTransformation2;
                textStyle3 = textStyle2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions3 = keyboardActions2;
                z14 = z12;
                i37 = i34;
                i38 = i35;
                mutableInteractionSource4 = mutableInteractionSource2;
                shape3 = shape2;
                function218 = function212;
                function219 = function216;
                z15 = z10;
                function220 = function29;
                z16 = z9;
                function221 = function215;
                Function2<? super Composer, ? super Integer, Unit> function23922222 = function28;
                function222 = function211;
                modifier3 = modifier2;
                function223 = function23922222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i13 = i10 & 8;
            if (i13 != 0) {
            }
            i14 = i10 & 16;
            if (i14 == 0) {
            }
            if ((i7 & 196608) == 0) {
            }
            i15 = i10 & 64;
            if (i15 != 0) {
            }
            i16 = i10 & 128;
            if (i16 != 0) {
            }
            i17 = i10 & 256;
            if (i17 != 0) {
            }
            i18 = i10 & 512;
            if (i18 != 0) {
            }
            i19 = i10 & 1024;
            if (i19 != 0) {
            }
            i21 = i10 & 2048;
            if (i21 != 0) {
            }
            int i40222 = i20;
            i22 = i10 & 4096;
            if (i22 != 0) {
            }
            i23 = i10 & 8192;
            if (i23 == 0) {
            }
            i24 = i10 & 16384;
            if (i24 != 0) {
            }
            i26 = i10 & 32768;
            if (i26 == 0) {
            }
            i27 = i10 & 65536;
            if (i27 == 0) {
            }
            i28 = i10 & 131072;
            if (i28 == 0) {
            }
            if ((i8 & 100663296) == 0) {
            }
            i29 = i10 & 524288;
            if (i29 == 0) {
            }
            i30 = i10 & 1048576;
            if (i30 == 0) {
            }
            if ((i9 & 48) == 0) {
            }
            if ((i9 & 384) == 0) {
            }
            int i41222222 = i31;
            if ((i11 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i7 & 1) != 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if ((i10 & 32) == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (i21 == 0) {
            }
            if (i22 == 0) {
            }
            if (i23 == 0) {
            }
            if (i25 == 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i28 == 0) {
            }
            if ((i10 & 262144) == 0) {
            }
            if (i29 == 0) {
            }
            if (i30 == 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function230222222 = function225;
            Shape shape4222222 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
            if ((i10 & 4194304) == 0) {
            }
            i33 = i11;
            z11 = z17;
            visualTransformation2 = none;
            keyboardOptions2 = keyboardOptions4;
            mutableInteractionSource2 = mutableInteractionSource5;
            keyboardActions2 = keyboardActions4;
            z12 = z18;
            i34 = i32;
            i35 = i42;
            function29 = function226;
            function210 = function224;
            Function2<? super Composer, ? super Integer, Unit> function231222222 = function227;
            function211 = function230222222;
            function212 = function229;
            i36 = i40222;
            function213 = function228;
            function214 = function231222222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-508515290);
            if (mutableInteractionSource2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-508509180);
            m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
            if (m2298getColor0d7_KjU == 16) {
            }
            long j5222222 = m2298getColor0d7_KjU;
            startRestartGroup.endReplaceGroup();
            final TextStyle merge222222 = textStyle2.merge(new TextStyle(j5222222, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
            final Modifier modifier4222222 = modifier2;
            final boolean z19222222 = z10;
            final TextFieldColors textFieldColors4222222 = textFieldColors2;
            final boolean z20222222 = z9;
            final boolean z21222222 = z11;
            final KeyboardOptions keyboardOptions5222222 = keyboardOptions2;
            final KeyboardActions keyboardActions5222222 = keyboardActions2;
            final boolean z22222222 = z12;
            final int i43222222 = i34;
            final int i44222222 = i35;
            final VisualTransformation visualTransformation4222222 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource6222222 = mutableInteractionSource3;
            final Function2<? super Composer, ? super Integer, Unit> function232222222 = function210;
            final Function2<? super Composer, ? super Integer, Unit> function233222222 = function28;
            final Function2<? super Composer, ? super Integer, Unit> function234222222 = function211;
            final Function2<? super Composer, ? super Integer, Unit> function235222222 = function29;
            final Function2<? super Composer, ? super Integer, Unit> function236222222 = function215;
            final Function2<? super Composer, ? super Integer, Unit> function237222222 = function216;
            final Function2<? super Composer, ? super Integer, Unit> function238222222 = function212;
            final Shape shape5222222 = shape2;
            boolean z23222222 = z11;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i45) {
                    if ((i45 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                    }
                    Modifier modifier5 = Modifier.this;
                    boolean z24 = z19222222;
                    Strings.Companion companion = Strings.INSTANCE;
                    Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                    SolidColor solidColor = new SolidColor(textFieldColors4222222.m914cursorColorvNxB06k$material3_release(z19222222), null);
                    final String str2 = str;
                    Function1<String, Unit> function12 = function1;
                    final boolean z25 = z20222222;
                    boolean z26 = z21222222;
                    TextStyle textStyle4 = merge222222;
                    KeyboardOptions keyboardOptions6 = keyboardOptions5222222;
                    KeyboardActions keyboardActions6 = keyboardActions5222222;
                    final boolean z27 = z22222222;
                    int i46 = i43222222;
                    int i47 = i44222222;
                    final VisualTransformation visualTransformation5 = visualTransformation4222222;
                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6222222;
                    final boolean z28 = z19222222;
                    final Function2<? super Composer, ? super Integer, Unit> function239222222 = function232222222;
                    final Function2<? super Composer, ? super Integer, Unit> function240 = function233222222;
                    final Function2<? super Composer, ? super Integer, Unit> function241 = function234222222;
                    final Function2<? super Composer, ? super Integer, Unit> function242 = function235222222;
                    final Function2<? super Composer, ? super Integer, Unit> function243 = function236222222;
                    final Function2<? super Composer, ? super Integer, Unit> function244 = function237222222;
                    final Function2<? super Composer, ? super Integer, Unit> function245 = function238222222;
                    final Shape shape6 = shape5222222;
                    final TextFieldColors textFieldColors5 = textFieldColors4222222;
                    BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                            int i49;
                            if ((i48 & 6) == 0) {
                                i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                            } else {
                                i49 = i48;
                            }
                            if ((i49 & 19) == 18 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                            }
                            TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function239222222, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 0, 196608, 4096);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            z13 = z23222222;
            function217 = function210;
            textFieldColors3 = textFieldColors2;
            visualTransformation3 = visualTransformation2;
            textStyle3 = textStyle2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            z14 = z12;
            i37 = i34;
            i38 = i35;
            mutableInteractionSource4 = mutableInteractionSource2;
            shape3 = shape2;
            function218 = function212;
            function219 = function216;
            z15 = z10;
            function220 = function29;
            z16 = z9;
            function221 = function215;
            Function2<? super Composer, ? super Integer, Unit> function239222222 = function28;
            function222 = function211;
            modifier3 = modifier2;
            function223 = function239222222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i12 = i10 & 4;
        if (i12 == 0) {
        }
        i13 = i10 & 8;
        if (i13 != 0) {
        }
        i14 = i10 & 16;
        if (i14 == 0) {
        }
        if ((i7 & 196608) == 0) {
        }
        i15 = i10 & 64;
        if (i15 != 0) {
        }
        i16 = i10 & 128;
        if (i16 != 0) {
        }
        i17 = i10 & 256;
        if (i17 != 0) {
        }
        i18 = i10 & 512;
        if (i18 != 0) {
        }
        i19 = i10 & 1024;
        if (i19 != 0) {
        }
        i21 = i10 & 2048;
        if (i21 != 0) {
        }
        int i402222 = i20;
        i22 = i10 & 4096;
        if (i22 != 0) {
        }
        i23 = i10 & 8192;
        if (i23 == 0) {
        }
        i24 = i10 & 16384;
        if (i24 != 0) {
        }
        i26 = i10 & 32768;
        if (i26 == 0) {
        }
        i27 = i10 & 65536;
        if (i27 == 0) {
        }
        i28 = i10 & 131072;
        if (i28 == 0) {
        }
        if ((i8 & 100663296) == 0) {
        }
        i29 = i10 & 524288;
        if (i29 == 0) {
        }
        i30 = i10 & 1048576;
        if (i30 == 0) {
        }
        if ((i9 & 48) == 0) {
        }
        if ((i9 & 384) == 0) {
        }
        int i412222222 = i31;
        if ((i11 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i7 & 1) != 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if ((i10 & 32) == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (i21 == 0) {
        }
        if (i22 == 0) {
        }
        if (i23 == 0) {
        }
        if (i25 == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i28 == 0) {
        }
        if ((i10 & 262144) == 0) {
        }
        if (i29 == 0) {
        }
        if (i30 == 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function2302222222 = function225;
        Shape shape42222222 = (i10 & 2097152) == 0 ? TextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6) : shape;
        if ((i10 & 4194304) == 0) {
        }
        i33 = i11;
        z11 = z17;
        visualTransformation2 = none;
        keyboardOptions2 = keyboardOptions4;
        mutableInteractionSource2 = mutableInteractionSource5;
        keyboardActions2 = keyboardActions4;
        z12 = z18;
        i34 = i32;
        i35 = i42;
        function29 = function226;
        function210 = function224;
        Function2<? super Composer, ? super Integer, Unit> function2312222222 = function227;
        function211 = function2302222222;
        function212 = function229;
        i36 = i402222;
        function213 = function228;
        function214 = function2312222222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-508515290);
        if (mutableInteractionSource2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-508509180);
        m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
        if (m2298getColor0d7_KjU == 16) {
        }
        long j52222222 = m2298getColor0d7_KjU;
        startRestartGroup.endReplaceGroup();
        final TextStyle merge2222222 = textStyle2.merge(new TextStyle(j52222222, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null));
        final Modifier modifier42222222 = modifier2;
        final boolean z192222222 = z10;
        final TextFieldColors textFieldColors42222222 = textFieldColors2;
        final boolean z202222222 = z9;
        final boolean z212222222 = z11;
        final KeyboardOptions keyboardOptions52222222 = keyboardOptions2;
        final KeyboardActions keyboardActions52222222 = keyboardActions2;
        final boolean z222222222 = z12;
        final int i432222222 = i34;
        final int i442222222 = i35;
        final VisualTransformation visualTransformation42222222 = visualTransformation2;
        final MutableInteractionSource mutableInteractionSource62222222 = mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function2322222222 = function210;
        final Function2<? super Composer, ? super Integer, Unit> function2332222222 = function28;
        final Function2<? super Composer, ? super Integer, Unit> function2342222222 = function211;
        final Function2<? super Composer, ? super Integer, Unit> function2352222222 = function29;
        final Function2<? super Composer, ? super Integer, Unit> function2362222222 = function215;
        final Function2<? super Composer, ? super Integer, Unit> function2372222222 = function216;
        final Function2<? super Composer, ? super Integer, Unit> function2382222222 = function212;
        final Shape shape52222222 = shape2;
        boolean z232222222 = z11;
        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1859145987, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i45) {
                if ((i45 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1859145987, i45, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:231)");
                }
                Modifier modifier5 = Modifier.this;
                boolean z24 = z192222222;
                Strings.Companion companion = Strings.INSTANCE;
                Modifier defaultErrorSemantics = TextFieldImplKt.defaultErrorSemantics(modifier5, z24, Strings_androidKt.m996getString2EP1pXo(Strings.m995constructorimpl(androidx.compose.ui.R$string.default_error_message), composer2, 0));
                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                Modifier m323defaultMinSizeVpY3zN4 = SizeKt.m323defaultMinSizeVpY3zN4(defaultErrorSemantics, textFieldDefaults.m932getMinWidthD9Ej5fM(), textFieldDefaults.m931getMinHeightD9Ej5fM());
                SolidColor solidColor = new SolidColor(textFieldColors42222222.m914cursorColorvNxB06k$material3_release(z192222222), null);
                final String str2 = str;
                Function1<String, Unit> function12 = function1;
                final boolean z25 = z202222222;
                boolean z26 = z212222222;
                TextStyle textStyle4 = merge2222222;
                KeyboardOptions keyboardOptions6 = keyboardOptions52222222;
                KeyboardActions keyboardActions6 = keyboardActions52222222;
                final boolean z27 = z222222222;
                int i46 = i432222222;
                int i47 = i442222222;
                final VisualTransformation visualTransformation5 = visualTransformation42222222;
                final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource62222222;
                final boolean z28 = z192222222;
                final Function2<? super Composer, ? super Integer, Unit> function2392222222 = function2322222222;
                final Function2<? super Composer, ? super Integer, Unit> function240 = function2332222222;
                final Function2<? super Composer, ? super Integer, Unit> function241 = function2342222222;
                final Function2<? super Composer, ? super Integer, Unit> function242 = function2352222222;
                final Function2<? super Composer, ? super Integer, Unit> function243 = function2362222222;
                final Function2<? super Composer, ? super Integer, Unit> function244 = function2372222222;
                final Function2<? super Composer, ? super Integer, Unit> function245 = function2382222222;
                final Shape shape6 = shape52222222;
                final TextFieldColors textFieldColors5 = textFieldColors42222222;
                BasicTextFieldKt.BasicTextField(str2, function12, m323defaultMinSizeVpY3zN4, z25, z26, textStyle4, keyboardOptions6, keyboardActions6, z27, i46, i47, visualTransformation5, null, mutableInteractionSource7, solidColor, ComposableLambdaKt.rememberComposableLambda(-288211827, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextField$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function246, Composer composer3, Integer num) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) function246, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function246, Composer composer3, int i48) {
                        int i49;
                        if ((i48 & 6) == 0) {
                            i49 = i48 | (composer3.changedInstance(function246) ? 4 : 2);
                        } else {
                            i49 = i48;
                        }
                        if ((i49 & 19) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-288211827, i49, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:255)");
                        }
                        TextFieldDefaults.INSTANCE.DecorationBox(str2, function246, z25, z27, visualTransformation5, mutableInteractionSource7, z28, function2392222222, function240, function241, function242, function243, function244, function245, shape6, textFieldColors5, null, null, composer3, (i49 << 3) & 112, 100663296, 196608);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 0, 196608, 4096);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        z13 = z232222222;
        function217 = function210;
        textFieldColors3 = textFieldColors2;
        visualTransformation3 = visualTransformation2;
        textStyle3 = textStyle2;
        keyboardOptions3 = keyboardOptions2;
        keyboardActions3 = keyboardActions2;
        z14 = z12;
        i37 = i34;
        i38 = i35;
        mutableInteractionSource4 = mutableInteractionSource2;
        shape3 = shape2;
        function218 = function212;
        function219 = function216;
        z15 = z10;
        function220 = function29;
        z16 = z9;
        function221 = function215;
        Function2<? super Composer, ? super Integer, Unit> function2392222222 = function28;
        function222 = function211;
        modifier3 = modifier2;
        function223 = function2392222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final boolean z5, final float f5, final Function2<? super Composer, ? super Integer, Unit> function27, final Function2<? super Composer, ? super Integer, Unit> function28, final PaddingValues paddingValues, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        PaddingValues paddingValues2;
        int i9;
        float f6;
        Composer startRestartGroup = composer.startRestartGroup(-1830307184);
        if ((i5 & 6) == 0) {
            i7 = i5 | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 67108864 : 33554432;
        }
        if ((805306368 & i5) == 0) {
            i7 |= startRestartGroup.changed(f5) ? 536870912 : 268435456;
        }
        int i10 = i7;
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function27) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function28) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            paddingValues2 = paddingValues;
            i8 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
        } else {
            paddingValues2 = paddingValues;
        }
        int i11 = i8;
        if ((i10 & 306783379) == 306783378 && (i11 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1830307184, i10, i11, "androidx.compose.material3.TextFieldLayout (TextField.kt:453)");
            }
            boolean z6 = ((1879048192 & i10) == 536870912) | ((234881024 & i10) == 67108864) | ((i11 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z5, f5, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, textFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            function27.invoke(startRestartGroup, Integer.valueOf(i11 & 14));
            startRestartGroup.startReplaceGroup(1341517187);
            if (function23 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function23.invoke(startRestartGroup, Integer.valueOf((i10 >> 12) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341526310);
            if (function24 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, then2);
                Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                function24.invoke(startRestartGroup, Integer.valueOf((i10 >> 15) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function23 != null) {
                i9 = 0;
                calculateStartPadding = Dp.m2599constructorimpl(RangesKt.coerceAtLeast(Dp.m2599constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m2599constructorimpl(0)));
            } else {
                i9 = 0;
            }
            if (function24 != null) {
                calculateEndPadding = Dp.m2599constructorimpl(RangesKt.coerceAtLeast(Dp.m2599constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m2599constructorimpl(i9)));
            }
            startRestartGroup.startReplaceGroup(1341556924);
            if (function25 != null) {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), calculateStartPadding, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor4 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                function25.invoke(startRestartGroup, Integer.valueOf((i10 >> 18) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341568890);
            if (function26 != null) {
                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, calculateEndPadding, 0.0f, 10, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
                Function0<ComposeUiNode> constructor5 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl5 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl5, maybeCachedBoxMeasurePolicy4, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                function26.invoke(startRestartGroup, Integer.valueOf((i10 >> 21) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1341581092);
            if (function22 != null) {
                Modifier m315paddingqDBjuR0$default3 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "Label"), DpKt.m2611lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f5), 0.0f, 2, null), null, false, 3, null), calculateStartPadding, 0.0f, calculateEndPadding, 0.0f, 10, null);
                MeasurePolicy maybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier6 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default3);
                Function0<ComposeUiNode> constructor6 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor6);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl6 = Updater.m1226constructorimpl(startRestartGroup);
                f6 = calculateStartPadding;
                Updater.m1227setimpl(m1226constructorimpl6, maybeCachedBoxMeasurePolicy5, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl6, currentCompositionLocalMap6, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl6.getInserting() || !Intrinsics.areEqual(m1226constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                    m1226constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                    m1226constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                }
                Updater.m1227setimpl(m1226constructorimpl6, materializeModifier6, companion.getSetModifier());
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                function22.invoke(startRestartGroup, Integer.valueOf((i10 >> 6) & 14));
                startRestartGroup.endNode();
            } else {
                f6 = calculateStartPadding;
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(companion2, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            float m2599constructorimpl = function25 == null ? f6 : Dp.m2599constructorimpl(0);
            if (function26 != null) {
                calculateEndPadding = Dp.m2599constructorimpl(0);
            }
            Modifier m315paddingqDBjuR0$default4 = PaddingKt.m315paddingqDBjuR0$default(wrapContentHeight$default, m2599constructorimpl, 0.0f, calculateEndPadding, 0.0f, 10, null);
            startRestartGroup.startReplaceGroup(1341611627);
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(m315paddingqDBjuR0$default4), startRestartGroup, Integer.valueOf((i10 >> 6) & 112));
            }
            startRestartGroup.endReplaceGroup();
            Modifier then3 = LayoutIdKt.layoutId(companion2, "TextField").then(m315paddingqDBjuR0$default4);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), true);
            int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier7 = ComposedModifierKt.materializeModifier(startRestartGroup, then3);
            Function0<ComposeUiNode> constructor7 = companion.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor7);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl7 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl7, maybeCachedBoxMeasurePolicy6, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl7, currentCompositionLocalMap7, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl7.getInserting() || !Intrinsics.areEqual(m1226constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                m1226constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                m1226constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
            }
            Updater.m1227setimpl(m1226constructorimpl7, materializeModifier7, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
            function2.invoke(startRestartGroup, Integer.valueOf((i10 >> 3) & 14));
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(1341622624);
            if (function28 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m327heightInVpY3zN4$default(LayoutIdKt.layoutId(companion2, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m926supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                MeasurePolicy maybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier8 = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
                Function0<ComposeUiNode> constructor8 = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m1226constructorimpl8 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl8, maybeCachedBoxMeasurePolicy7, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl8, currentCompositionLocalMap8, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = companion.getSetCompositeKeyHash();
                if (m1226constructorimpl8.getInserting() || !Intrinsics.areEqual(m1226constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    m1226constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    m1226constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                Updater.m1227setimpl(m1226constructorimpl8, materializeModifier8, companion.getSetModifier());
                function28.invoke(startRestartGroup, Integer.valueOf((i11 >> 3) & 14));
                startRestartGroup.endNode();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldKt$TextFieldLayout$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i12) {
                    TextFieldKt.TextFieldLayout(Modifier.this, function2, function22, function3, function23, function24, function25, function26, z5, f5, function27, function28, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m938calculateHeightmKXJcVc(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f5, long j5, float f6, PaddingValues paddingValues) {
        boolean z5 = i6 > 0;
        float m2599constructorimpl = Dp.m2599constructorimpl(paddingValues.getTop() + paddingValues.getBottom()) * f6;
        if (z5) {
            m2599constructorimpl = MathHelpersKt.lerp(Dp.m2599constructorimpl(TextFieldImplKt.getTextFieldPadding() * 2) * f6, m2599constructorimpl, f5);
        }
        return Math.max(Constraints.m2579getMinHeightimpl(j5), Math.max(i7, Math.max(i8, MathKt.roundToInt(m2599constructorimpl + MathHelpersKt.lerp(0, i6, f5) + ComparisonsKt.maxOf(i5, i11, i9, i10, MathHelpersKt.lerp(i6, 0, f5))))) + i12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    public static final int m939calculateWidthyeHjK3Y(int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j5) {
        int i12 = i7 + i8;
        return Math.max(i5 + Math.max(i9 + i12, Math.max(i11 + i12, i10)) + i6, Constraints.m2580getMinWidthimpl(j5));
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final State<BorderStroke> state) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TextFieldKt$drawIndicatorLine$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                float mo212toPx0680j_4 = contentDrawScope.mo212toPx0680j_4(state.getValue().getWidth());
                float m1375getHeightimpl = Size.m1375getHeightimpl(contentDrawScope.mo1703getSizeNHjbRc()) - (mo212toPx0680j_4 / 2);
                DrawScope.m1693drawLine1RTmtNc$default(contentDrawScope, state.getValue().getBrush(), OffsetKt.Offset(0.0f, m1375getHeightimpl), OffsetKt.Offset(Size.m1377getWidthimpl(contentDrawScope.mo1703getSizeNHjbRc()), m1375getHeightimpl), mo212toPx0680j_4, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getTextFieldWithLabelVerticalPadding() {
        return TextFieldWithLabelVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i5, int i6, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, boolean z5, int i7, int i8, float f5, float f6) {
        Placeable.PlacementScope.m1968place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m2648getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i6 - TextFieldImplKt.heightOrZero(placeable9);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), (z5 ? Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), heightOrZero) : MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f6)) - MathKt.roundToInt((r1 - i7) * f5), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, TextFieldImplKt.widthOrZero(placeable4), i8, 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable4) + TextFieldImplKt.widthOrZero(placeable6);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, i8, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero, i8, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i5 - TextFieldImplKt.widthOrZero(placeable5)) - placeable7.getWidth(), i8, 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i5 - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i5, int i6, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, boolean z5, float f5, PaddingValues paddingValues) {
        Placeable.PlacementScope.m1968place70tqf50$default(placementScope, placeable7, IntOffset.INSTANCE.m2648getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i6 - TextFieldImplKt.heightOrZero(placeable8);
        int roundToInt = MathKt.roundToInt(paddingValues.getTop() * f5);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable5), 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable3) + TextFieldImplKt.widthOrZero(placeable5);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, widthOrZero, placeWithoutLabel$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable2), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, (i5 - TextFieldImplKt.widthOrZero(placeable4)) - placeable6.getWidth(), placeWithoutLabel$calculateVerticalPosition(z5, heightOrZero, roundToInt, placeable6), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i5 - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(boolean z5, int i5, int i6, Placeable placeable) {
        return z5 ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i5) : i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int i5, int i6) {
        return i5 == Integer.MAX_VALUE ? i5 : i5 - i6;
    }
}
