package androidx.compose.material3.internal;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001aõ\u0001\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a0\u0010$\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a(\u0010$\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a#\u0010)\u001a\u00020'*\u00020'2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0002H\u0000¢\u0006\u0004\b)\u0010*\u001a#\u0010/\u001a\u00020'*\u00020'2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\b/\u00100\u001a\u0019\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u000101H\u0000¢\u0006\u0004\b4\u00105\u001a\u0019\u00106\u001a\u0002032\b\u00102\u001a\u0004\u0018\u000101H\u0000¢\u0006\u0004\b6\u00105\u001aH\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\"\u001a\u0010A\u001a\u00020@8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0014\u0010E\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010F\"\u0014\u0010G\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010F\"\u001a\u0010H\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u001a\u0010L\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010I\u001a\u0004\bM\u0010K\"\u001a\u0010N\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u001a\u0010P\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\bP\u0010I\u001a\u0004\bQ\u0010K\"\u001a\u0010R\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\bR\u0010I\u001a\u0004\bS\u0010K\"\u001a\u0010T\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\bT\u0010I\u001a\u0004\bU\u0010K\"\u001a\u0010V\u001a\u0002088\u0000X\u0080\u0004¢\u0006\f\n\u0004\bV\u0010I\u001a\u0004\bW\u0010K\"\u001a\u0010X\u001a\u00020'8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u001a\u0010`\u001a\u0004\u0018\u00010]*\u00020\\8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c²\u0006\f\u0010a\u001a\u00020\u00108\nX\u008a\u0084\u0002²\u0006\f\u0010b\u001a\u00020\u00108\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/internal/TextFieldType;", "type", BuildConfig.FLAVOR, "value", "Lkotlin/Function0;", BuildConfig.FLAVOR, "innerTextField", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", BuildConfig.FLAVOR, "singleLine", "enabled", "isError", "Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "Landroidx/compose/material3/TextFieldColors;", "colors", "container", "CommonDecorationBox", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "content", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Decoration", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "defaultErrorSemantics", "(Landroidx/compose/ui/Modifier;ZLjava/lang/String;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/ColorProducer;", "color", "Landroidx/compose/ui/graphics/Shape;", "shape", "textFieldBackground", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/Placeable;", "placeable", BuildConfig.FLAVOR, "widthOrZero", "(Landroidx/compose/ui/layout/Placeable;)I", "heightOrZero", "focused", "Landroidx/compose/ui/unit/Dp;", "focusedBorderThickness", "unfocusedBorderThickness", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateBorderStrokeAsState", "Landroidx/compose/ui/unit/Constraints;", "ZeroConstraints", "J", "getZeroConstraints", "()J", "PlaceholderAnimationDuration", "I", "PlaceholderAnimationDelayOrDuration", "TextFieldPadding", "F", "getTextFieldPadding", "()F", "HorizontalIconPadding", "getHorizontalIconPadding", "SupportingTopPadding", "getSupportingTopPadding", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "MinTextLineHeight", "getMinTextLineHeight", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", BuildConfig.FLAVOR, "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "layoutId", "showPlaceholder", "showPrefixSuffix", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldImplKt {
    private static final Modifier IconDefaultSizeModifier;
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    private static final float TextFieldPadding;
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float HorizontalIconPadding = Dp.m2599constructorimpl(12);
    private static final float SupportingTopPadding = Dp.m2599constructorimpl(4);
    private static final float PrefixSuffixTextPadding = Dp.m2599constructorimpl(2);
    private static final float MinTextLineHeight = Dp.m2599constructorimpl(24);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            try {
                iArr[TextFieldType.Filled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldType.Outlined.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        float f5 = 16;
        TextFieldPadding = Dp.m2599constructorimpl(f5);
        MinFocusedLabelLineHeight = Dp.m2599constructorimpl(f5);
        MinSupportingTextLineHeight = Dp.m2599constructorimpl(f5);
        float f6 = 48;
        IconDefaultSizeModifier = SizeKt.m323defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6));
    }

    /* JADX WARN: Code restructure failed: missing block: B:342:0x04f7, code lost:
    
        if (r1 != false) goto L342;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x04ad, code lost:
    
        if (r1 != false) goto L323;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0573  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x075a  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x079e  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0847  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x087a  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x08aa  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x08d4  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x091f  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0a1b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x09c8  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x08dc  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0a2f  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CommonDecorationBox(final TextFieldType textFieldType, final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, boolean z5, boolean z6, boolean z7, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
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
        boolean z8;
        boolean z9;
        Object filter;
        long m916labelColorXeAY9LY$material3_release;
        final TextStyle bodyLarge;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        boolean z10;
        long m2298getColor0d7_KjU;
        long m2298getColor0d7_KjU2;
        long j5;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        boolean z11;
        Function2<? super Composer, ? super Integer, Unit> function215;
        int[] iArr;
        int i21;
        float f5;
        boolean z12;
        boolean z13;
        int i22;
        float f6;
        int i23;
        float f7;
        boolean z14;
        int i24;
        float f8;
        int i25;
        float f9;
        int i26;
        float f10;
        boolean changed;
        Object rememberedValue;
        InputPhase inputPhase;
        boolean changed2;
        Object rememberedValue2;
        int i27;
        ComposableLambda rememberComposableLambda;
        Object rememberedValue3;
        Composer.Companion companion;
        ComposableLambda composableLambda;
        Object rememberedValue4;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        ComposableLambda rememberComposableLambda2;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        int i28;
        int i29;
        ComposableLambda rememberComposableLambda3;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        int i30;
        ComposableLambda rememberComposableLambda4;
        int i31;
        Function2<? super Composer, ? super Integer, Unit> function219;
        boolean z15;
        Function2<? super Composer, ? super Integer, Unit> function220;
        final boolean z16;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final Function2<? super Composer, ? super Integer, Unit> function224;
        final Function2<? super Composer, ? super Integer, Unit> function225;
        ScopeUpdateScope endRestartGroup;
        int i32;
        Composer startRestartGroup = composer.startRestartGroup(1514469103);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = i5 | (startRestartGroup.changed(textFieldType) ? 4 : 2);
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i33 = i8;
        if ((i7 & 4) != 0) {
            i33 |= 384;
        } else if ((i5 & 384) == 0) {
            i33 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
            if ((i7 & 8) == 0) {
                i33 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i33 |= startRestartGroup.changed(visualTransformation) ? 2048 : 1024;
            }
            if ((i7 & 16) == 0) {
                i33 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i33 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
            }
            i9 = i7 & 32;
            if (i9 == 0) {
                i33 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i33 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
            }
            i10 = i7 & 64;
            if (i10 == 0) {
                i33 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i33 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
            }
            i11 = i7 & 128;
            if (i11 == 0) {
                i33 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i33 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
            }
            i12 = i7 & 256;
            if (i12 == 0) {
                i33 |= 100663296;
            } else if ((i5 & 100663296) == 0) {
                i33 |= startRestartGroup.changedInstance(function26) ? 67108864 : 33554432;
            }
            i13 = i7 & 512;
            if (i13 == 0) {
                i32 = (i5 & 805306368) == 0 ? startRestartGroup.changedInstance(function27) ? 536870912 : 268435456 : 805306368;
                i14 = i7 & 1024;
                if (i14 != 0) {
                    i15 = i6 | 6;
                } else if ((i6 & 6) == 0) {
                    i15 = i6 | (startRestartGroup.changedInstance(function28) ? 4 : 2);
                } else {
                    i15 = i6;
                }
                i16 = i7 & 2048;
                if (i16 != 0) {
                    i15 |= 48;
                } else if ((i6 & 48) == 0) {
                    i15 |= startRestartGroup.changed(z5) ? 32 : 16;
                }
                i17 = i15;
                i18 = i7 & 4096;
                if (i18 != 0) {
                    i17 |= 384;
                    i19 = i18;
                } else {
                    i19 = i18;
                    if ((i6 & 384) == 0) {
                        i17 |= startRestartGroup.changed(z6) ? 256 : 128;
                    }
                }
                i20 = i7 & 8192;
                if (i20 != 0) {
                    i17 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i17 |= startRestartGroup.changed(z7) ? 2048 : 1024;
                }
                if ((i7 & 16384) != 0) {
                    i17 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    i17 |= startRestartGroup.changed(interactionSource) ? 16384 : 8192;
                }
                if ((32768 & i7) != 0) {
                    i17 |= 196608;
                } else if ((i6 & 196608) == 0) {
                    i17 |= startRestartGroup.changed(paddingValues) ? 131072 : 65536;
                }
                if ((65536 & i7) != 0) {
                    i17 |= 1572864;
                } else if ((i6 & 1572864) == 0) {
                    i17 |= startRestartGroup.changed(textFieldColors) ? 1048576 : 524288;
                }
                if ((131072 & i7) != 0) {
                    i17 |= 12582912;
                } else if ((i6 & 12582912) == 0) {
                    i17 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                }
                if ((306783379 & i33) != 306783378 && (4793491 & i17) == 4793490 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    function225 = function23;
                    function224 = function24;
                    function223 = function25;
                    function221 = function26;
                    function222 = function27;
                    function218 = function28;
                    z8 = z5;
                    z15 = z6;
                    z16 = z7;
                } else {
                    Function2<? super Composer, ? super Integer, Unit> function226 = i9 != 0 ? null : function23;
                    Function2<? super Composer, ? super Integer, Unit> function227 = i10 != 0 ? null : function24;
                    Function2<? super Composer, ? super Integer, Unit> function228 = i11 != 0 ? null : function25;
                    Function2<? super Composer, ? super Integer, Unit> function229 = i12 != 0 ? null : function26;
                    Function2<? super Composer, ? super Integer, Unit> function230 = i13 != 0 ? null : function27;
                    Function2<? super Composer, ? super Integer, Unit> function231 = i14 != 0 ? null : function28;
                    z8 = i16 != 0 ? false : z5;
                    boolean z17 = i19 != 0 ? true : z6;
                    boolean z18 = i20 != 0 ? false : z7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1514469103, i33, i17, "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:96)");
                    }
                    int i34 = i33;
                    z9 = ((i33 & 7168) == 2048) | ((i33 & 112) == 32);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!z9 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        filter = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
                        startRestartGroup.updateRememberedValue(filter);
                    } else {
                        filter = rememberedValue5;
                    }
                    String text = ((TransformedText) filter).getText().getText();
                    boolean booleanValue = FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 12) & 14).getValue().booleanValue();
                    InputPhase inputPhase2 = booleanValue ? InputPhase.Focused : text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                    m916labelColorXeAY9LY$material3_release = textFieldColors.m916labelColorXeAY9LY$material3_release(z17, z18, booleanValue);
                    int i35 = i17;
                    Typography typography = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    bodyLarge = typography.getBodyLarge();
                    final TextStyle bodySmall = typography.getBodySmall();
                    function210 = function229;
                    function211 = function231;
                    long m2298getColor0d7_KjU3 = bodyLarge.m2298getColor0d7_KjU();
                    Color.Companion companion2 = Color.INSTANCE;
                    function212 = function230;
                    z10 = !(Color.m1487equalsimpl0(m2298getColor0d7_KjU3, companion2.m1501getUnspecified0d7_KjU()) || Color.m1487equalsimpl0(bodySmall.m2298getColor0d7_KjU(), companion2.m1501getUnspecified0d7_KjU())) || (!Color.m1487equalsimpl0(bodyLarge.m2298getColor0d7_KjU(), companion2.m1501getUnspecified0d7_KjU()) && Color.m1487equalsimpl0(bodySmall.m2298getColor0d7_KjU(), companion2.m1501getUnspecified0d7_KjU()));
                    m2298getColor0d7_KjU = bodySmall.m2298getColor0d7_KjU();
                    if (z10 && m2298getColor0d7_KjU == 16) {
                        m2298getColor0d7_KjU = m916labelColorXeAY9LY$material3_release;
                    }
                    m2298getColor0d7_KjU2 = bodyLarge.m2298getColor0d7_KjU();
                    if (z10 && m2298getColor0d7_KjU2 == 16) {
                        m2298getColor0d7_KjU2 = m916labelColorXeAY9LY$material3_release;
                    }
                    j5 = m2298getColor0d7_KjU;
                    boolean z19 = function22 != null;
                    Transition updateTransition = TransitionKt.updateTransition(inputPhase2, "TextFieldInputState", startRestartGroup, 48, 0);
                    TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 textFieldImplKt$TextFieldTransitionScope$labelProgress$1 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelProgress$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                            composer2.startReplaceGroup(1276209157);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1276209157, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:354)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return tween$default;
                        }
                    };
                    FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                    InputPhase inputPhase3 = (InputPhase) updateTransition.getCurrentState();
                    function213 = function228;
                    startRestartGroup.startReplaceGroup(-2036730335);
                    if (ComposerKt.isTraceInProgress()) {
                        function215 = function227;
                        function214 = function226;
                        z11 = z17;
                        ComposerKt.traceEventStart(-2036730335, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
                    } else {
                        function214 = function226;
                        z11 = z17;
                        function215 = function227;
                    }
                    iArr = WhenMappings.$EnumSwitchMapping$1;
                    i21 = iArr[inputPhase3.ordinal()];
                    if (i21 != 1) {
                        if (i21 == 2) {
                            f5 = 0.0f;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceGroup();
                            Float valueOf = Float.valueOf(f5);
                            InputPhase inputPhase4 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceGroup(-2036730335);
                            if (ComposerKt.isTraceInProgress()) {
                                z12 = z18;
                                z13 = booleanValue;
                            } else {
                                z12 = z18;
                                z13 = booleanValue;
                                ComposerKt.traceEventStart(-2036730335, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:356)");
                            }
                            i22 = iArr[inputPhase4.ordinal()];
                            if (i22 != 1) {
                                if (i22 == 2) {
                                    f6 = 0.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke((TextFieldImplKt$TextFieldTransitionScope$labelProgress$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, 196608);
                                    TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                            return invoke(segment, composer2, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                            FiniteAnimationSpec<Float> tween;
                                            composer2.startReplaceGroup(-1154662212);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1154662212, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:367)");
                                            }
                                            InputPhase inputPhase5 = InputPhase.Focused;
                                            InputPhase inputPhase6 = InputPhase.UnfocusedEmpty;
                                            if (segment.isTransitioningTo(inputPhase5, inputPhase6)) {
                                                tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                                            } else if (!segment.isTransitioningTo(inputPhase6, inputPhase5) && !segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase6)) {
                                                tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                                            } else {
                                                tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer2.endReplaceGroup();
                                            return tween;
                                        }
                                    };
                                    TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                                    InputPhase inputPhase5 = (InputPhase) updateTransition.getCurrentState();
                                    startRestartGroup.startReplaceGroup(1435837472);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1435837472, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
                                    }
                                    i23 = iArr[inputPhase5.ordinal()];
                                    if (i23 != 1) {
                                        if (i23 != 2) {
                                            if (i23 != 3) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                        }
                                        f7 = 0.0f;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        Float valueOf2 = Float.valueOf(f7);
                                        InputPhase inputPhase6 = (InputPhase) updateTransition.getTargetState();
                                        startRestartGroup.startReplaceGroup(1435837472);
                                        if (ComposerKt.isTraceInProgress()) {
                                            z14 = z10;
                                        } else {
                                            z14 = z10;
                                            ComposerKt.traceEventStart(1435837472, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:386)");
                                        }
                                        i24 = iArr[inputPhase6.ordinal()];
                                        if (i24 != 1) {
                                            if (i24 != 2) {
                                                if (i24 != 3) {
                                                    throw new NoWhenBranchMatchedException();
                                                }
                                            }
                                            f8 = 0.0f;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f8), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke((TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, 196608);
                                            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                    return invoke(segment, composer2, num.intValue());
                                                }

                                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                    composer2.startReplaceGroup(-1868044898);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1868044898, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:396)");
                                                    }
                                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    composer2.endReplaceGroup();
                                                    return tween$default;
                                                }
                                            };
                                            TwoWayConverter<Float, AnimationVector1D> vectorConverter3 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                                            InputPhase inputPhase7 = (InputPhase) updateTransition.getCurrentState();
                                            startRestartGroup.startReplaceGroup(1128033978);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1128033978, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
                                            }
                                            i25 = iArr[inputPhase7.ordinal()];
                                            if (i25 != 1) {
                                                if (i25 != 2) {
                                                    if (i25 != 3) {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                } else if (z19) {
                                                    f9 = 0.0f;
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    Float valueOf3 = Float.valueOf(f9);
                                                    InputPhase inputPhase8 = (InputPhase) updateTransition.getTargetState();
                                                    startRestartGroup.startReplaceGroup(1128033978);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1128033978, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:398)");
                                                    }
                                                    i26 = iArr[inputPhase8.ordinal()];
                                                    if (i26 != 1) {
                                                        if (i26 != 2) {
                                                            if (i26 != 3) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                        } else if (z19) {
                                                            f10 = 0.0f;
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            final State createTransitionAnimation3 = TransitionKt.createTransitionAnimation(updateTransition, valueOf3, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3, "PrefixSuffixOpacity", startRestartGroup, 196608);
                                                            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                                    return invoke(segment, composer2, num.intValue());
                                                                }

                                                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                                    composer2.startReplaceGroup(1528582156);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                                                                    }
                                                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                    composer2.endReplaceGroup();
                                                                    return tween$default;
                                                                }
                                                            };
                                                            InputPhase inputPhase9 = (InputPhase) updateTransition.getTargetState();
                                                            startRestartGroup.startReplaceGroup(-107432127);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-107432127, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
                                                            }
                                                            long j6 = iArr[inputPhase9.ordinal()] == 1 ? j5 : m2298getColor0d7_KjU2;
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            ColorSpace m1490getColorSpaceimpl = Color.m1490getColorSpaceimpl(j6);
                                                            changed = startRestartGroup.changed(m1490getColorSpaceimpl);
                                                            rememberedValue = startRestartGroup.rememberedValue();
                                                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl);
                                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                                            }
                                                            TwoWayConverter twoWayConverter = (TwoWayConverter) rememberedValue;
                                                            InputPhase inputPhase10 = (InputPhase) updateTransition.getCurrentState();
                                                            startRestartGroup.startReplaceGroup(-107432127);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-107432127, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
                                                            }
                                                            long j7 = iArr[inputPhase10.ordinal()] == 1 ? j5 : m2298getColor0d7_KjU2;
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            Color m1481boximpl = Color.m1481boximpl(j7);
                                                            inputPhase = (InputPhase) updateTransition.getTargetState();
                                                            startRestartGroup.startReplaceGroup(-107432127);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-107432127, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:410)");
                                                            }
                                                            if (iArr[inputPhase.ordinal()] == 1) {
                                                                m2298getColor0d7_KjU2 = j5;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            final State createTransitionAnimation4 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter, "LabelTextStyleColor", startRestartGroup, 196608);
                                                            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$1 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                                    return invoke(segment, composer2, num.intValue());
                                                                }

                                                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                                    composer2.startReplaceGroup(-543659263);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                                                                    }
                                                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                    composer2.endReplaceGroup();
                                                                    return tween$default;
                                                                }
                                                            };
                                                            startRestartGroup.startReplaceGroup(1023351670);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1023351670, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            ColorSpace m1490getColorSpaceimpl2 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
                                                            changed2 = startRestartGroup.changed(m1490getColorSpaceimpl2);
                                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                                            if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl2);
                                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                                            }
                                                            TwoWayConverter twoWayConverter2 = (TwoWayConverter) rememberedValue2;
                                                            startRestartGroup.startReplaceGroup(1023351670);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1023351670, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            Color m1481boximpl2 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
                                                            startRestartGroup.startReplaceGroup(1023351670);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                i27 = 0;
                                                                ComposerKt.traceEventStart(1023351670, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:421)");
                                                            } else {
                                                                i27 = 0;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            final State createTransitionAnimation5 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl2, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$1.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter2, "LabelContentColor", startRestartGroup, 196608);
                                                            final float floatValue = ((Number) createTransitionAnimation.getValue()).floatValue();
                                                            startRestartGroup.startReplaceGroup(-156998101);
                                                            if (function22 == null) {
                                                                rememberComposableLambda = null;
                                                            } else {
                                                                final boolean z20 = z14;
                                                                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1236585568, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                                                    public final void invoke(Composer composer2, int i36) {
                                                                        if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                            composer2.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1236585568, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:139)");
                                                                        }
                                                                        TextStyle lerp = TextStyleKt.lerp(TextStyle.this, bodySmall, floatValue);
                                                                        boolean z21 = z20;
                                                                        State<Color> state = createTransitionAnimation4;
                                                                        if (z21) {
                                                                            lerp = lerp.m2295copyp1EtxEg((r48 & 1) != 0 ? lerp.spanStyle.m2255getColor0d7_KjU() : state.getValue().getValue(), (r48 & 2) != 0 ? lerp.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? lerp.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? lerp.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? lerp.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? lerp.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? lerp.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? lerp.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? lerp.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? lerp.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? lerp.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? lerp.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? lerp.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? lerp.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? lerp.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? lerp.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? lerp.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? lerp.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? lerp.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? lerp.platformStyle : null, (r48 & 1048576) != 0 ? lerp.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? lerp.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? lerp.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? lerp.paragraphStyle.getTextMotion() : null);
                                                                        }
                                                                        TextFieldImplKt.m997Decoration3JVO9M(createTransitionAnimation5.getValue().getValue(), lerp, function22, composer2, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, startRestartGroup, 54);
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            boolean z21 = z11;
                                                            boolean z22 = z12;
                                                            boolean z23 = z13;
                                                            final long m918placeholderColorXeAY9LY$material3_release = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z21, z22, z23);
                                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                                            companion = Composer.INSTANCE;
                                                            if (rememberedValue3 == companion.getEmpty()) {
                                                                rememberedValue3 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$showPlaceholder$2$1
                                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        return Boolean.valueOf(createTransitionAnimation2.getValue().floatValue() > 0.0f);
                                                                    }
                                                                });
                                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                                            }
                                                            State state = (State) rememberedValue3;
                                                            startRestartGroup.startReplaceGroup(-156965270);
                                                            if (function214 == null && text.length() == 0 && CommonDecorationBox$lambda$15$lambda$7(state)) {
                                                                final Function2<? super Composer, ? super Integer, Unit> function232 = function214;
                                                                composableLambda = ComposableLambdaKt.rememberComposableLambda(-660524084, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer2, Integer num) {
                                                                        invoke(modifier, composer2, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Modifier modifier, Composer composer2, int i36) {
                                                                        if ((i36 & 6) == 0) {
                                                                            i36 |= composer2.changed(modifier) ? 4 : 2;
                                                                        }
                                                                        if ((i36 & 19) == 18 && composer2.getSkipping()) {
                                                                            composer2.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-660524084, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:161)");
                                                                        }
                                                                        boolean changed3 = composer2.changed(createTransitionAnimation2);
                                                                        final State<Float> state2 = createTransitionAnimation2;
                                                                        Object rememberedValue6 = composer2.rememberedValue();
                                                                        if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                                            rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1$1$1
                                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                                                                    invoke2(graphicsLayerScope);
                                                                                    return Unit.INSTANCE;
                                                                                }

                                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                                                                    graphicsLayerScope.setAlpha(state2.getValue().floatValue());
                                                                                }
                                                                            };
                                                                            composer2.updateRememberedValue(rememberedValue6);
                                                                        }
                                                                        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) rememberedValue6);
                                                                        long j8 = m918placeholderColorXeAY9LY$material3_release;
                                                                        TextStyle textStyle = bodyLarge;
                                                                        Function2<Composer, Integer, Unit> function233 = function232;
                                                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, graphicsLayer);
                                                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                                        if (composer2.getApplier() == null) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        composer2.startReusableNode();
                                                                        if (composer2.getInserting()) {
                                                                            composer2.createNode(constructor);
                                                                        } else {
                                                                            composer2.useNode();
                                                                        }
                                                                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                                                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                                                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                                                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                        }
                                                                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                        TextFieldImplKt.m997Decoration3JVO9M(j8, textStyle, function233, composer2, 0);
                                                                        composer2.endNode();
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, startRestartGroup, 54);
                                                            } else {
                                                                composableLambda = null;
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            final long m919prefixColorXeAY9LY$material3_release = textFieldColors.m919prefixColorXeAY9LY$material3_release(z21, z22, z23);
                                                            rememberedValue4 = startRestartGroup.rememberedValue();
                                                            if (rememberedValue4 == companion.getEmpty()) {
                                                                rememberedValue4 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$showPrefixSuffix$2$1
                                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        return Boolean.valueOf(createTransitionAnimation3.getValue().floatValue() > 0.0f);
                                                                    }
                                                                });
                                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                                            }
                                                            State state2 = (State) rememberedValue4;
                                                            startRestartGroup.startReplaceGroup(-156940524);
                                                            ComposableLambda rememberComposableLambda5 = (function210 == null && CommonDecorationBox$lambda$15$lambda$9(state2)) ? ComposableLambdaKt.rememberComposableLambda(274398694, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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

                                                                public final void invoke(Composer composer2, int i36) {
                                                                    if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                        composer2.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(274398694, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:178)");
                                                                    }
                                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                    boolean changed3 = composer2.changed(createTransitionAnimation3);
                                                                    final State<Float> state3 = createTransitionAnimation3;
                                                                    Object rememberedValue6 = composer2.rememberedValue();
                                                                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1$1$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                                                                invoke2(graphicsLayerScope);
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                                                                graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                                                            }
                                                                        };
                                                                        composer2.updateRememberedValue(rememberedValue6);
                                                                    }
                                                                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) rememberedValue6);
                                                                    long j8 = m919prefixColorXeAY9LY$material3_release;
                                                                    TextStyle textStyle = bodyLarge;
                                                                    Function2<Composer, Integer, Unit> function233 = function210;
                                                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, graphicsLayer);
                                                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                                    if (composer2.getApplier() == null) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer2.startReusableNode();
                                                                    if (composer2.getInserting()) {
                                                                        composer2.createNode(constructor);
                                                                    } else {
                                                                        composer2.useNode();
                                                                    }
                                                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                                                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                                                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                    }
                                                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                    TextFieldImplKt.m997Decoration3JVO9M(j8, textStyle, function233, composer2, 0);
                                                                    composer2.endNode();
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, startRestartGroup, 54) : null;
                                                            startRestartGroup.endReplaceGroup();
                                                            final long m920suffixColorXeAY9LY$material3_release = textFieldColors.m920suffixColorXeAY9LY$material3_release(z21, z22, z23);
                                                            startRestartGroup.startReplaceGroup(-156921964);
                                                            ComposableLambda rememberComposableLambda6 = (function212 == null && CommonDecorationBox$lambda$15$lambda$9(state2)) ? ComposableLambdaKt.rememberComposableLambda(-1526229403, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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

                                                                public final void invoke(Composer composer2, int i36) {
                                                                    if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                        composer2.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1526229403, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:192)");
                                                                    }
                                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                    boolean changed3 = composer2.changed(createTransitionAnimation3);
                                                                    final State<Float> state3 = createTransitionAnimation3;
                                                                    Object rememberedValue6 = composer2.rememberedValue();
                                                                    if (changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue6 = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1$1$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                                                                invoke2(graphicsLayerScope);
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                                                                graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                                                            }
                                                                        };
                                                                        composer2.updateRememberedValue(rememberedValue6);
                                                                    }
                                                                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) rememberedValue6);
                                                                    long j8 = m920suffixColorXeAY9LY$material3_release;
                                                                    TextStyle textStyle = bodyLarge;
                                                                    Function2<Composer, Integer, Unit> function233 = function212;
                                                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, graphicsLayer);
                                                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                                    if (composer2.getApplier() == null) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer2.startReusableNode();
                                                                    if (composer2.getInserting()) {
                                                                        composer2.createNode(constructor);
                                                                    } else {
                                                                        composer2.useNode();
                                                                    }
                                                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                                                    Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                                                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                    }
                                                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                    TextFieldImplKt.m997Decoration3JVO9M(j8, textStyle, function233, composer2, 0);
                                                                    composer2.endNode();
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, startRestartGroup, 54) : null;
                                                            startRestartGroup.endReplaceGroup();
                                                            final long m917leadingIconColorXeAY9LY$material3_release = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z21, z22, z23);
                                                            startRestartGroup.startReplaceGroup(-156902962);
                                                            if (function215 == null) {
                                                                function216 = function215;
                                                                rememberComposableLambda2 = null;
                                                            } else {
                                                                function216 = function215;
                                                                rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-130107406, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                                                    public final void invoke(Composer composer2, int i36) {
                                                                        if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                            composer2.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-130107406, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:205)");
                                                                        }
                                                                        TextFieldImplKt.m998DecorationIv8Zu3U(m917leadingIconColorXeAY9LY$material3_release, function216, composer2, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, startRestartGroup, 54);
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            final long m923trailingIconColorXeAY9LY$material3_release = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z21, z22, z23);
                                                            startRestartGroup.startReplaceGroup(-156893937);
                                                            if (function213 == null) {
                                                                function217 = function213;
                                                                i28 = 1;
                                                                i29 = 54;
                                                                rememberComposableLambda3 = null;
                                                            } else {
                                                                function217 = function213;
                                                                i28 = 1;
                                                                i29 = 54;
                                                                rememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(2079816678, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                                                    public final void invoke(Composer composer2, int i36) {
                                                                        if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                            composer2.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(2079816678, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:211)");
                                                                        }
                                                                        TextFieldImplKt.m998DecorationIv8Zu3U(m923trailingIconColorXeAY9LY$material3_release, function217, composer2, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, startRestartGroup, 54);
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            final long m921supportingTextColorXeAY9LY$material3_release = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z21, z22, z23);
                                                            startRestartGroup.startReplaceGroup(-156884470);
                                                            if (function211 == null) {
                                                                i30 = i28;
                                                                function218 = function211;
                                                                rememberComposableLambda4 = null;
                                                            } else {
                                                                function218 = function211;
                                                                i30 = 1;
                                                                rememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(1263707005, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                                                    public final void invoke(Composer composer2, int i36) {
                                                                        if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                            composer2.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1263707005, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:218)");
                                                                        }
                                                                        TextFieldImplKt.m997Decoration3JVO9M(m921supportingTextColorXeAY9LY$material3_release, bodySmall, function218, composer2, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, startRestartGroup, i29);
                                                            }
                                                            startRestartGroup.endReplaceGroup();
                                                            i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                                            if (i31 == i30) {
                                                                function219 = function216;
                                                                z15 = z21;
                                                                function220 = function217;
                                                                startRestartGroup.startReplaceGroup(-568105095);
                                                                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2, rememberComposableLambda, composableLambda, rememberComposableLambda2, rememberComposableLambda3, rememberComposableLambda5, rememberComposableLambda6, z8, floatValue, ComposableLambdaKt.rememberComposableLambda(1750327932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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

                                                                    public final void invoke(Composer composer2, int i36) {
                                                                        if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                            composer2.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1750327932, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:229)");
                                                                        }
                                                                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "Container");
                                                                        Function2<Composer, Integer, Unit> function233 = function29;
                                                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, layoutId);
                                                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                                        if (composer2.getApplier() == null) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        composer2.startReusableNode();
                                                                        if (composer2.getInserting()) {
                                                                            composer2.createNode(constructor);
                                                                        } else {
                                                                            composer2.useNode();
                                                                        }
                                                                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                                                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                                                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                                                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                        }
                                                                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                        function233.invoke(composer2, 0);
                                                                        composer2.endNode();
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, startRestartGroup, 54), rememberComposableLambda4, paddingValues, startRestartGroup, ((i34 >> 3) & 112) | 6 | ((i35 << 21) & 234881024), ((i35 >> 9) & 896) | 6);
                                                                startRestartGroup.endReplaceGroup();
                                                                Unit unit = Unit.INSTANCE;
                                                            } else if (i31 != 2) {
                                                                startRestartGroup.startReplaceGroup(-565271199);
                                                                startRestartGroup.endReplaceGroup();
                                                                Unit unit2 = Unit.INSTANCE;
                                                                function219 = function216;
                                                                z15 = z21;
                                                                function220 = function217;
                                                            } else {
                                                                startRestartGroup.startReplaceGroup(-567018607);
                                                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                                                if (rememberedValue6 == companion.getEmpty()) {
                                                                    rememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1370boximpl(Size.INSTANCE.m1384getZeroNHjbRc()), null, 2, null);
                                                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                                                }
                                                                final MutableState mutableState = (MutableState) rememberedValue6;
                                                                function219 = function216;
                                                                z15 = z21;
                                                                function220 = function217;
                                                                ComposableLambda rememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(157291737, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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

                                                                    public final void invoke(Composer composer2, int i36) {
                                                                        if ((i36 & 3) == 2 && composer2.getSkipping()) {
                                                                            composer2.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(157291737, i36, -1, "androidx.compose.material3.internal.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:255)");
                                                                        }
                                                                        Modifier outlineCutout = OutlinedTextFieldKt.outlineCutout(LayoutIdKt.layoutId(Modifier.INSTANCE, "Container"), new MutablePropertyReference0Impl(mutableState) { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1.1
                                                                            @Override // kotlin.reflect.KProperty0
                                                                            public Object get() {
                                                                                return ((MutableState) this.receiver).getValue();
                                                                            }
                                                                        }, paddingValues);
                                                                        Function2<Composer, Integer, Unit> function233 = function29;
                                                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, outlineCutout);
                                                                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                                                        Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                                                        if (composer2.getApplier() == null) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        composer2.startReusableNode();
                                                                        if (composer2.getInserting()) {
                                                                            composer2.createNode(constructor);
                                                                        } else {
                                                                            composer2.useNode();
                                                                        }
                                                                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                                                        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                                                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                                                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                        }
                                                                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                        function233.invoke(composer2, 0);
                                                                        composer2.endNode();
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, startRestartGroup, 54);
                                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                boolean changed3 = startRestartGroup.changed(floatValue);
                                                                Object rememberedValue7 = startRestartGroup.rememberedValue();
                                                                if (changed3 || rememberedValue7 == companion.getEmpty()) {
                                                                    rememberedValue7 = new Function1<Size, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                                            m1002invokeuvyYCjk(size.getPackedValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                                        public final void m1002invokeuvyYCjk(long j8) {
                                                                            float m1377getWidthimpl = Size.m1377getWidthimpl(j8) * floatValue;
                                                                            float m1375getHeightimpl = Size.m1375getHeightimpl(j8) * floatValue;
                                                                            if (Size.m1377getWidthimpl(mutableState.getValue().getPackedValue()) == m1377getWidthimpl && Size.m1375getHeightimpl(mutableState.getValue().getPackedValue()) == m1375getHeightimpl) {
                                                                                return;
                                                                            }
                                                                            mutableState.setValue(Size.m1370boximpl(androidx.compose.ui.geometry.SizeKt.Size(m1377getWidthimpl, m1375getHeightimpl)));
                                                                        }
                                                                    };
                                                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                                                }
                                                                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion3, function2, composableLambda, rememberComposableLambda, rememberComposableLambda2, rememberComposableLambda3, rememberComposableLambda5, rememberComposableLambda6, z8, floatValue, (Function1) rememberedValue7, rememberComposableLambda7, rememberComposableLambda4, paddingValues, startRestartGroup, ((i34 >> 3) & 112) | 6 | ((i35 << 21) & 234881024), ((i35 >> 6) & 7168) | 48);
                                                                startRestartGroup.endReplaceGroup();
                                                                Unit unit3 = Unit.INSTANCE;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            z16 = z22;
                                                            function221 = function210;
                                                            function222 = function212;
                                                            function223 = function220;
                                                            function224 = function219;
                                                            function225 = function214;
                                                        }
                                                    }
                                                    f10 = 1.0f;
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    final State<Float> createTransitionAnimation32 = TransitionKt.createTransitionAnimation(updateTransition, valueOf3, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3, "PrefixSuffixOpacity", startRestartGroup, 196608);
                                                    TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                            return invoke(segment, composer2, num.intValue());
                                                        }

                                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                            composer2.startReplaceGroup(1528582156);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                                                            }
                                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            composer2.endReplaceGroup();
                                                            return tween$default;
                                                        }
                                                    };
                                                    InputPhase inputPhase92 = (InputPhase) updateTransition.getTargetState();
                                                    startRestartGroup.startReplaceGroup(-107432127);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    if (iArr[inputPhase92.ordinal()] == 1) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    ColorSpace m1490getColorSpaceimpl3 = Color.m1490getColorSpaceimpl(j6);
                                                    changed = startRestartGroup.changed(m1490getColorSpaceimpl3);
                                                    rememberedValue = startRestartGroup.rememberedValue();
                                                    if (!changed) {
                                                    }
                                                    rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl3);
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                    TwoWayConverter twoWayConverter3 = (TwoWayConverter) rememberedValue;
                                                    InputPhase inputPhase102 = (InputPhase) updateTransition.getCurrentState();
                                                    startRestartGroup.startReplaceGroup(-107432127);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    if (iArr[inputPhase102.ordinal()] == 1) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    Color m1481boximpl3 = Color.m1481boximpl(j7);
                                                    inputPhase = (InputPhase) updateTransition.getTargetState();
                                                    startRestartGroup.startReplaceGroup(-107432127);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    if (iArr[inputPhase.ordinal()] == 1) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    final State<Color> createTransitionAnimation42 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl3, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter3, "LabelTextStyleColor", startRestartGroup, 196608);
                                                    TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$12 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                            return invoke(segment, composer2, num.intValue());
                                                        }

                                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                            composer2.startReplaceGroup(-543659263);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                                                            }
                                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                            composer2.endReplaceGroup();
                                                            return tween$default;
                                                        }
                                                    };
                                                    startRestartGroup.startReplaceGroup(1023351670);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    ColorSpace m1490getColorSpaceimpl22 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
                                                    changed2 = startRestartGroup.changed(m1490getColorSpaceimpl22);
                                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                                    if (!changed2) {
                                                    }
                                                    rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl22);
                                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                                    TwoWayConverter twoWayConverter22 = (TwoWayConverter) rememberedValue2;
                                                    startRestartGroup.startReplaceGroup(1023351670);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    Color m1481boximpl22 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
                                                    startRestartGroup.startReplaceGroup(1023351670);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    final State<Color> createTransitionAnimation52 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl22, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$12.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter22, "LabelContentColor", startRestartGroup, 196608);
                                                    final float floatValue2 = ((Number) createTransitionAnimation.getValue()).floatValue();
                                                    startRestartGroup.startReplaceGroup(-156998101);
                                                    if (function22 == null) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    boolean z212 = z11;
                                                    boolean z222 = z12;
                                                    boolean z232 = z13;
                                                    final long m918placeholderColorXeAY9LY$material3_release2 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z212, z222, z232);
                                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                                    companion = Composer.INSTANCE;
                                                    if (rememberedValue3 == companion.getEmpty()) {
                                                    }
                                                    State state3 = (State) rememberedValue3;
                                                    startRestartGroup.startReplaceGroup(-156965270);
                                                    if (function214 == null) {
                                                    }
                                                    composableLambda = null;
                                                    startRestartGroup.endReplaceGroup();
                                                    final long m919prefixColorXeAY9LY$material3_release2 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z212, z222, z232);
                                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                                    if (rememberedValue4 == companion.getEmpty()) {
                                                    }
                                                    State state22 = (State) rememberedValue4;
                                                    startRestartGroup.startReplaceGroup(-156940524);
                                                    if (function210 == null) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    final long m920suffixColorXeAY9LY$material3_release2 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z212, z222, z232);
                                                    startRestartGroup.startReplaceGroup(-156921964);
                                                    if (function212 == null) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    final long m917leadingIconColorXeAY9LY$material3_release2 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z212, z222, z232);
                                                    startRestartGroup.startReplaceGroup(-156902962);
                                                    if (function215 == null) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    final long m923trailingIconColorXeAY9LY$material3_release2 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z212, z222, z232);
                                                    startRestartGroup.startReplaceGroup(-156893937);
                                                    if (function213 == null) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    final long m921supportingTextColorXeAY9LY$material3_release2 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z212, z222, z232);
                                                    startRestartGroup.startReplaceGroup(-156884470);
                                                    if (function211 == null) {
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                                    if (i31 == i30) {
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    z16 = z222;
                                                    function221 = function210;
                                                    function222 = function212;
                                                    function223 = function220;
                                                    function224 = function219;
                                                    function225 = function214;
                                                }
                                            }
                                            f9 = 1.0f;
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Float valueOf32 = Float.valueOf(f9);
                                            InputPhase inputPhase82 = (InputPhase) updateTransition.getTargetState();
                                            startRestartGroup.startReplaceGroup(1128033978);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            i26 = iArr[inputPhase82.ordinal()];
                                            if (i26 != 1) {
                                            }
                                            f10 = 1.0f;
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final State<Float> createTransitionAnimation322 = TransitionKt.createTransitionAnimation(updateTransition, valueOf32, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3, "PrefixSuffixOpacity", startRestartGroup, 196608);
                                            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                    return invoke(segment, composer2, num.intValue());
                                                }

                                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                    composer2.startReplaceGroup(1528582156);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                                                    }
                                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    composer2.endReplaceGroup();
                                                    return tween$default;
                                                }
                                            };
                                            InputPhase inputPhase922 = (InputPhase) updateTransition.getTargetState();
                                            startRestartGroup.startReplaceGroup(-107432127);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (iArr[inputPhase922.ordinal()] == 1) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            ColorSpace m1490getColorSpaceimpl32 = Color.m1490getColorSpaceimpl(j6);
                                            changed = startRestartGroup.changed(m1490getColorSpaceimpl32);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            if (!changed) {
                                            }
                                            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl32);
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                            TwoWayConverter twoWayConverter32 = (TwoWayConverter) rememberedValue;
                                            InputPhase inputPhase1022 = (InputPhase) updateTransition.getCurrentState();
                                            startRestartGroup.startReplaceGroup(-107432127);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (iArr[inputPhase1022.ordinal()] == 1) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Color m1481boximpl32 = Color.m1481boximpl(j7);
                                            inputPhase = (InputPhase) updateTransition.getTargetState();
                                            startRestartGroup.startReplaceGroup(-107432127);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (iArr[inputPhase.ordinal()] == 1) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final State<Color> createTransitionAnimation422 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl32, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter32, "LabelTextStyleColor", startRestartGroup, 196608);
                                            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$122 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                    return invoke(segment, composer2, num.intValue());
                                                }

                                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                    composer2.startReplaceGroup(-543659263);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                                                    }
                                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    composer2.endReplaceGroup();
                                                    return tween$default;
                                                }
                                            };
                                            startRestartGroup.startReplaceGroup(1023351670);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            ColorSpace m1490getColorSpaceimpl222 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
                                            changed2 = startRestartGroup.changed(m1490getColorSpaceimpl222);
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (!changed2) {
                                            }
                                            rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl222);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                            TwoWayConverter twoWayConverter222 = (TwoWayConverter) rememberedValue2;
                                            startRestartGroup.startReplaceGroup(1023351670);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            Color m1481boximpl222 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
                                            startRestartGroup.startReplaceGroup(1023351670);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final State<Color> createTransitionAnimation522 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl222, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$122.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter222, "LabelContentColor", startRestartGroup, 196608);
                                            final float floatValue22 = ((Number) createTransitionAnimation.getValue()).floatValue();
                                            startRestartGroup.startReplaceGroup(-156998101);
                                            if (function22 == null) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            boolean z2122 = z11;
                                            boolean z2222 = z12;
                                            boolean z2322 = z13;
                                            final long m918placeholderColorXeAY9LY$material3_release22 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z2122, z2222, z2322);
                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                            companion = Composer.INSTANCE;
                                            if (rememberedValue3 == companion.getEmpty()) {
                                            }
                                            State state32 = (State) rememberedValue3;
                                            startRestartGroup.startReplaceGroup(-156965270);
                                            if (function214 == null) {
                                            }
                                            composableLambda = null;
                                            startRestartGroup.endReplaceGroup();
                                            final long m919prefixColorXeAY9LY$material3_release22 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z2122, z2222, z2322);
                                            rememberedValue4 = startRestartGroup.rememberedValue();
                                            if (rememberedValue4 == companion.getEmpty()) {
                                            }
                                            State state222 = (State) rememberedValue4;
                                            startRestartGroup.startReplaceGroup(-156940524);
                                            if (function210 == null) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final long m920suffixColorXeAY9LY$material3_release22 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z2122, z2222, z2322);
                                            startRestartGroup.startReplaceGroup(-156921964);
                                            if (function212 == null) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final long m917leadingIconColorXeAY9LY$material3_release22 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z2122, z2222, z2322);
                                            startRestartGroup.startReplaceGroup(-156902962);
                                            if (function215 == null) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final long m923trailingIconColorXeAY9LY$material3_release22 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z2122, z2222, z2322);
                                            startRestartGroup.startReplaceGroup(-156893937);
                                            if (function213 == null) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            final long m921supportingTextColorXeAY9LY$material3_release22 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z2122, z2222, z2322);
                                            startRestartGroup.startReplaceGroup(-156884470);
                                            if (function211 == null) {
                                            }
                                            startRestartGroup.endReplaceGroup();
                                            i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                            if (i31 == i30) {
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            z16 = z2222;
                                            function221 = function210;
                                            function222 = function212;
                                            function223 = function220;
                                            function224 = function219;
                                            function225 = function214;
                                        }
                                        f8 = 1.0f;
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final State<Float> createTransitionAnimation22 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f8), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke((TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, 196608);
                                        TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$12 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                return invoke(segment, composer2, num.intValue());
                                            }

                                            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                composer2.startReplaceGroup(-1868044898);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1868044898, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:396)");
                                                }
                                                TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                composer2.endReplaceGroup();
                                                return tween$default;
                                            }
                                        };
                                        TwoWayConverter<Float, AnimationVector1D> vectorConverter32 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                                        InputPhase inputPhase72 = (InputPhase) updateTransition.getCurrentState();
                                        startRestartGroup.startReplaceGroup(1128033978);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        i25 = iArr[inputPhase72.ordinal()];
                                        if (i25 != 1) {
                                        }
                                        f9 = 1.0f;
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        Float valueOf322 = Float.valueOf(f9);
                                        InputPhase inputPhase822 = (InputPhase) updateTransition.getTargetState();
                                        startRestartGroup.startReplaceGroup(1128033978);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        i26 = iArr[inputPhase822.ordinal()];
                                        if (i26 != 1) {
                                        }
                                        f10 = 1.0f;
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final State<Float> createTransitionAnimation3222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf322, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$12.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter32, "PrefixSuffixOpacity", startRestartGroup, 196608);
                                        TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                return invoke(segment, composer2, num.intValue());
                                            }

                                            public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                composer2.startReplaceGroup(1528582156);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                                                }
                                                TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                composer2.endReplaceGroup();
                                                return tween$default;
                                            }
                                        };
                                        InputPhase inputPhase9222 = (InputPhase) updateTransition.getTargetState();
                                        startRestartGroup.startReplaceGroup(-107432127);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (iArr[inputPhase9222.ordinal()] == 1) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        ColorSpace m1490getColorSpaceimpl322 = Color.m1490getColorSpaceimpl(j6);
                                        changed = startRestartGroup.changed(m1490getColorSpaceimpl322);
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (!changed) {
                                        }
                                        rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl322);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                        TwoWayConverter twoWayConverter322 = (TwoWayConverter) rememberedValue;
                                        InputPhase inputPhase10222 = (InputPhase) updateTransition.getCurrentState();
                                        startRestartGroup.startReplaceGroup(-107432127);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (iArr[inputPhase10222.ordinal()] == 1) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        Color m1481boximpl322 = Color.m1481boximpl(j7);
                                        inputPhase = (InputPhase) updateTransition.getTargetState();
                                        startRestartGroup.startReplaceGroup(-107432127);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (iArr[inputPhase.ordinal()] == 1) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final State<Color> createTransitionAnimation4222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl322, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter322, "LabelTextStyleColor", startRestartGroup, 196608);
                                        TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$1222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                                return invoke(segment, composer2, num.intValue());
                                            }

                                            public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                                composer2.startReplaceGroup(-543659263);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                                                }
                                                TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                composer2.endReplaceGroup();
                                                return tween$default;
                                            }
                                        };
                                        startRestartGroup.startReplaceGroup(1023351670);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        ColorSpace m1490getColorSpaceimpl2222 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
                                        changed2 = startRestartGroup.changed(m1490getColorSpaceimpl2222);
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (!changed2) {
                                        }
                                        rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl2222);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                        TwoWayConverter twoWayConverter2222 = (TwoWayConverter) rememberedValue2;
                                        startRestartGroup.startReplaceGroup(1023351670);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        Color m1481boximpl2222 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
                                        startRestartGroup.startReplaceGroup(1023351670);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final State<Color> createTransitionAnimation5222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl2222, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$1222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter2222, "LabelContentColor", startRestartGroup, 196608);
                                        final float floatValue222 = ((Number) createTransitionAnimation.getValue()).floatValue();
                                        startRestartGroup.startReplaceGroup(-156998101);
                                        if (function22 == null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        boolean z21222 = z11;
                                        boolean z22222 = z12;
                                        boolean z23222 = z13;
                                        final long m918placeholderColorXeAY9LY$material3_release222 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z21222, z22222, z23222);
                                        rememberedValue3 = startRestartGroup.rememberedValue();
                                        companion = Composer.INSTANCE;
                                        if (rememberedValue3 == companion.getEmpty()) {
                                        }
                                        State state322 = (State) rememberedValue3;
                                        startRestartGroup.startReplaceGroup(-156965270);
                                        if (function214 == null) {
                                        }
                                        composableLambda = null;
                                        startRestartGroup.endReplaceGroup();
                                        final long m919prefixColorXeAY9LY$material3_release222 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z21222, z22222, z23222);
                                        rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (rememberedValue4 == companion.getEmpty()) {
                                        }
                                        State state2222 = (State) rememberedValue4;
                                        startRestartGroup.startReplaceGroup(-156940524);
                                        if (function210 == null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final long m920suffixColorXeAY9LY$material3_release222 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z21222, z22222, z23222);
                                        startRestartGroup.startReplaceGroup(-156921964);
                                        if (function212 == null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final long m917leadingIconColorXeAY9LY$material3_release222 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z21222, z22222, z23222);
                                        startRestartGroup.startReplaceGroup(-156902962);
                                        if (function215 == null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final long m923trailingIconColorXeAY9LY$material3_release222 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z21222, z22222, z23222);
                                        startRestartGroup.startReplaceGroup(-156893937);
                                        if (function213 == null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final long m921supportingTextColorXeAY9LY$material3_release222 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z21222, z22222, z23222);
                                        startRestartGroup.startReplaceGroup(-156884470);
                                        if (function211 == null) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                        if (i31 == i30) {
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        z16 = z22222;
                                        function221 = function210;
                                        function222 = function212;
                                        function223 = function220;
                                        function224 = function219;
                                        function225 = function214;
                                    }
                                    f7 = 1.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Float valueOf22 = Float.valueOf(f7);
                                    InputPhase inputPhase62 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceGroup(1435837472);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    i24 = iArr[inputPhase62.ordinal()];
                                    if (i24 != 1) {
                                    }
                                    f8 = 1.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final State<Float> createTransitionAnimation222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf22, Float.valueOf(f8), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1.invoke((TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2, "PlaceholderOpacity", startRestartGroup, 196608);
                                    TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$122 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                            return invoke(segment, composer2, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                            composer2.startReplaceGroup(-1868044898);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1868044898, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:396)");
                                            }
                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer2.endReplaceGroup();
                                            return tween$default;
                                        }
                                    };
                                    TwoWayConverter<Float, AnimationVector1D> vectorConverter322 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                                    InputPhase inputPhase722 = (InputPhase) updateTransition.getCurrentState();
                                    startRestartGroup.startReplaceGroup(1128033978);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    i25 = iArr[inputPhase722.ordinal()];
                                    if (i25 != 1) {
                                    }
                                    f9 = 1.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Float valueOf3222 = Float.valueOf(f9);
                                    InputPhase inputPhase8222 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceGroup(1128033978);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    i26 = iArr[inputPhase8222.ordinal()];
                                    if (i26 != 1) {
                                    }
                                    f10 = 1.0f;
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final State<Float> createTransitionAnimation32222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf3222, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$122.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter322, "PrefixSuffixOpacity", startRestartGroup, 196608);
                                    TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                            return invoke(segment, composer2, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                            composer2.startReplaceGroup(1528582156);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                                            }
                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer2.endReplaceGroup();
                                            return tween$default;
                                        }
                                    };
                                    InputPhase inputPhase92222 = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceGroup(-107432127);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (iArr[inputPhase92222.ordinal()] == 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    ColorSpace m1490getColorSpaceimpl3222 = Color.m1490getColorSpaceimpl(j6);
                                    changed = startRestartGroup.changed(m1490getColorSpaceimpl3222);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changed) {
                                    }
                                    rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl3222);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                    TwoWayConverter twoWayConverter3222 = (TwoWayConverter) rememberedValue;
                                    InputPhase inputPhase102222 = (InputPhase) updateTransition.getCurrentState();
                                    startRestartGroup.startReplaceGroup(-107432127);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (iArr[inputPhase102222.ordinal()] == 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Color m1481boximpl3222 = Color.m1481boximpl(j7);
                                    inputPhase = (InputPhase) updateTransition.getTargetState();
                                    startRestartGroup.startReplaceGroup(-107432127);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (iArr[inputPhase.ordinal()] == 1) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final State<Color> createTransitionAnimation42222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl3222, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter3222, "LabelTextStyleColor", startRestartGroup, 196608);
                                    TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$12222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                            return invoke(segment, composer2, num.intValue());
                                        }

                                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                            composer2.startReplaceGroup(-543659263);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                                            }
                                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer2.endReplaceGroup();
                                            return tween$default;
                                        }
                                    };
                                    startRestartGroup.startReplaceGroup(1023351670);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    ColorSpace m1490getColorSpaceimpl22222 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
                                    changed2 = startRestartGroup.changed(m1490getColorSpaceimpl22222);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (!changed2) {
                                    }
                                    rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl22222);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                    TwoWayConverter twoWayConverter22222 = (TwoWayConverter) rememberedValue2;
                                    startRestartGroup.startReplaceGroup(1023351670);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Color m1481boximpl22222 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
                                    startRestartGroup.startReplaceGroup(1023351670);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final State<Color> createTransitionAnimation52222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl22222, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$12222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter22222, "LabelContentColor", startRestartGroup, 196608);
                                    final float floatValue2222 = ((Number) createTransitionAnimation.getValue()).floatValue();
                                    startRestartGroup.startReplaceGroup(-156998101);
                                    if (function22 == null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    boolean z212222 = z11;
                                    boolean z222222 = z12;
                                    boolean z232222 = z13;
                                    final long m918placeholderColorXeAY9LY$material3_release2222 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z212222, z222222, z232222);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue3 == companion.getEmpty()) {
                                    }
                                    State state3222 = (State) rememberedValue3;
                                    startRestartGroup.startReplaceGroup(-156965270);
                                    if (function214 == null) {
                                    }
                                    composableLambda = null;
                                    startRestartGroup.endReplaceGroup();
                                    final long m919prefixColorXeAY9LY$material3_release2222 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z212222, z222222, z232222);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (rememberedValue4 == companion.getEmpty()) {
                                    }
                                    State state22222 = (State) rememberedValue4;
                                    startRestartGroup.startReplaceGroup(-156940524);
                                    if (function210 == null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final long m920suffixColorXeAY9LY$material3_release2222 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z212222, z222222, z232222);
                                    startRestartGroup.startReplaceGroup(-156921964);
                                    if (function212 == null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final long m917leadingIconColorXeAY9LY$material3_release2222 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z212222, z222222, z232222);
                                    startRestartGroup.startReplaceGroup(-156902962);
                                    if (function215 == null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final long m923trailingIconColorXeAY9LY$material3_release2222 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z212222, z222222, z232222);
                                    startRestartGroup.startReplaceGroup(-156893937);
                                    if (function213 == null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    final long m921supportingTextColorXeAY9LY$material3_release2222 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z212222, z222222, z232222);
                                    startRestartGroup.startReplaceGroup(-156884470);
                                    if (function211 == null) {
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                    if (i31 == i30) {
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    z16 = z222222;
                                    function221 = function210;
                                    function222 = function212;
                                    function223 = function220;
                                    function224 = function219;
                                    function225 = function214;
                                } else if (i22 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                            f6 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            State createTransitionAnimation6 = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke((TextFieldImplKt$TextFieldTransitionScope$labelProgress$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, 196608);
                            TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$12 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                    FiniteAnimationSpec<Float> tween;
                                    composer2.startReplaceGroup(-1154662212);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1154662212, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:367)");
                                    }
                                    InputPhase inputPhase52 = InputPhase.Focused;
                                    InputPhase inputPhase63 = InputPhase.UnfocusedEmpty;
                                    if (segment.isTransitioningTo(inputPhase52, inputPhase63)) {
                                        tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                                    } else if (!segment.isTransitioningTo(inputPhase63, inputPhase52) && !segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase63)) {
                                        tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                                    } else {
                                        tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceGroup();
                                    return tween;
                                }
                            };
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                            InputPhase inputPhase52 = (InputPhase) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceGroup(1435837472);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i23 = iArr[inputPhase52.ordinal()];
                            if (i23 != 1) {
                            }
                            f7 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Float valueOf222 = Float.valueOf(f7);
                            InputPhase inputPhase622 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceGroup(1435837472);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i24 = iArr[inputPhase622.ordinal()];
                            if (i24 != 1) {
                            }
                            f8 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final State<Float> createTransitionAnimation2222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf222, Float.valueOf(f8), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$12.invoke((TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter22, "PlaceholderOpacity", startRestartGroup, 196608);
                            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                    composer2.startReplaceGroup(-1868044898);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1868044898, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:396)");
                                    }
                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceGroup();
                                    return tween$default;
                                }
                            };
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter3222 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                            InputPhase inputPhase7222 = (InputPhase) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceGroup(1128033978);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i25 = iArr[inputPhase7222.ordinal()];
                            if (i25 != 1) {
                            }
                            f9 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Float valueOf32222 = Float.valueOf(f9);
                            InputPhase inputPhase82222 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceGroup(1128033978);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i26 = iArr[inputPhase82222.ordinal()];
                            if (i26 != 1) {
                            }
                            f10 = 1.0f;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final State<Float> createTransitionAnimation322222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf32222, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1222.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3222, "PrefixSuffixOpacity", startRestartGroup, 196608);
                            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                    composer2.startReplaceGroup(1528582156);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                                    }
                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceGroup();
                                    return tween$default;
                                }
                            };
                            InputPhase inputPhase922222 = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceGroup(-107432127);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (iArr[inputPhase922222.ordinal()] == 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            ColorSpace m1490getColorSpaceimpl32222 = Color.m1490getColorSpaceimpl(j6);
                            changed = startRestartGroup.changed(m1490getColorSpaceimpl32222);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl32222);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            TwoWayConverter twoWayConverter32222 = (TwoWayConverter) rememberedValue;
                            InputPhase inputPhase1022222 = (InputPhase) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceGroup(-107432127);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (iArr[inputPhase1022222.ordinal()] == 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Color m1481boximpl32222 = Color.m1481boximpl(j7);
                            inputPhase = (InputPhase) updateTransition.getTargetState();
                            startRestartGroup.startReplaceGroup(-107432127);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (iArr[inputPhase.ordinal()] == 1) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final State<Color> createTransitionAnimation422222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl32222, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter32222, "LabelTextStyleColor", startRestartGroup, 196608);
                            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$122222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                                    return invoke(segment, composer2, num.intValue());
                                }

                                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                                    composer2.startReplaceGroup(-543659263);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                                    }
                                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceGroup();
                                    return tween$default;
                                }
                            };
                            startRestartGroup.startReplaceGroup(1023351670);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            ColorSpace m1490getColorSpaceimpl222222 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
                            changed2 = startRestartGroup.changed(m1490getColorSpaceimpl222222);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed2) {
                            }
                            rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl222222);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            TwoWayConverter twoWayConverter222222 = (TwoWayConverter) rememberedValue2;
                            startRestartGroup.startReplaceGroup(1023351670);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Color m1481boximpl222222 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
                            startRestartGroup.startReplaceGroup(1023351670);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final State<Color> createTransitionAnimation522222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl222222, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$122222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter222222, "LabelContentColor", startRestartGroup, 196608);
                            final float floatValue22222 = ((Number) createTransitionAnimation6.getValue()).floatValue();
                            startRestartGroup.startReplaceGroup(-156998101);
                            if (function22 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            boolean z2122222 = z11;
                            boolean z2222222 = z12;
                            boolean z2322222 = z13;
                            final long m918placeholderColorXeAY9LY$material3_release22222 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z2122222, z2222222, z2322222);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue3 == companion.getEmpty()) {
                            }
                            State state32222 = (State) rememberedValue3;
                            startRestartGroup.startReplaceGroup(-156965270);
                            if (function214 == null) {
                            }
                            composableLambda = null;
                            startRestartGroup.endReplaceGroup();
                            final long m919prefixColorXeAY9LY$material3_release22222 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z2122222, z2222222, z2322222);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == companion.getEmpty()) {
                            }
                            State state222222 = (State) rememberedValue4;
                            startRestartGroup.startReplaceGroup(-156940524);
                            if (function210 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final long m920suffixColorXeAY9LY$material3_release22222 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z2122222, z2222222, z2322222);
                            startRestartGroup.startReplaceGroup(-156921964);
                            if (function212 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final long m917leadingIconColorXeAY9LY$material3_release22222 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z2122222, z2222222, z2322222);
                            startRestartGroup.startReplaceGroup(-156902962);
                            if (function215 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final long m923trailingIconColorXeAY9LY$material3_release22222 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z2122222, z2222222, z2322222);
                            startRestartGroup.startReplaceGroup(-156893937);
                            if (function213 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            final long m921supportingTextColorXeAY9LY$material3_release22222 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z2122222, z2222222, z2322222);
                            startRestartGroup.startReplaceGroup(-156884470);
                            if (function211 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                            if (i31 == i30) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z16 = z2222222;
                            function221 = function210;
                            function222 = function212;
                            function223 = function220;
                            function224 = function219;
                            function225 = function214;
                        } else if (i21 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    f5 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Float valueOf4 = Float.valueOf(f5);
                    InputPhase inputPhase42 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceGroup(-2036730335);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i22 = iArr[inputPhase42.ordinal()];
                    if (i22 != 1) {
                    }
                    f6 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    State createTransitionAnimation62 = TransitionKt.createTransitionAnimation(updateTransition, valueOf4, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$labelProgress$1.invoke((TextFieldImplKt$TextFieldTransitionScope$labelProgress$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter, "LabelProgress", startRestartGroup, 196608);
                    TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$122 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                            FiniteAnimationSpec<Float> tween;
                            composer2.startReplaceGroup(-1154662212);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1154662212, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:367)");
                            }
                            InputPhase inputPhase522 = InputPhase.Focused;
                            InputPhase inputPhase63 = InputPhase.UnfocusedEmpty;
                            if (segment.isTransitioningTo(inputPhase522, inputPhase63)) {
                                tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                            } else if (!segment.isTransitioningTo(inputPhase63, inputPhase522) && !segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase63)) {
                                tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                            } else {
                                tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return tween;
                        }
                    };
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                    InputPhase inputPhase522 = (InputPhase) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceGroup(1435837472);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i23 = iArr[inputPhase522.ordinal()];
                    if (i23 != 1) {
                    }
                    f7 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Float valueOf2222 = Float.valueOf(f7);
                    InputPhase inputPhase6222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceGroup(1435837472);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i24 = iArr[inputPhase6222.ordinal()];
                    if (i24 != 1) {
                    }
                    f8 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final State<Float> createTransitionAnimation22222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2222, Float.valueOf(f8), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$122.invoke((TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter222, "PlaceholderOpacity", startRestartGroup, 196608);
                    TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$12222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                            composer2.startReplaceGroup(-1868044898);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1868044898, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:396)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return tween$default;
                        }
                    };
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter32222 = VectorConvertersKt.getVectorConverter(floatCompanionObject);
                    InputPhase inputPhase72222 = (InputPhase) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceGroup(1128033978);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i25 = iArr[inputPhase72222.ordinal()];
                    if (i25 != 1) {
                    }
                    f9 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Float valueOf322222 = Float.valueOf(f9);
                    InputPhase inputPhase822222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceGroup(1128033978);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i26 = iArr[inputPhase822222.ordinal()];
                    if (i26 != 1) {
                    }
                    f10 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final State<Float> createTransitionAnimation3222222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf322222, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$12222.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter32222, "PrefixSuffixOpacity", startRestartGroup, 196608);
                    TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                            composer2.startReplaceGroup(1528582156);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return tween$default;
                        }
                    };
                    InputPhase inputPhase9222222 = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceGroup(-107432127);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (iArr[inputPhase9222222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    ColorSpace m1490getColorSpaceimpl322222 = Color.m1490getColorSpaceimpl(j6);
                    changed = startRestartGroup.changed(m1490getColorSpaceimpl322222);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl322222);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    TwoWayConverter twoWayConverter322222 = (TwoWayConverter) rememberedValue;
                    InputPhase inputPhase10222222 = (InputPhase) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceGroup(-107432127);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (iArr[inputPhase10222222.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Color m1481boximpl322222 = Color.m1481boximpl(j7);
                    inputPhase = (InputPhase) updateTransition.getTargetState();
                    startRestartGroup.startReplaceGroup(-107432127);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (iArr[inputPhase.ordinal()] == 1) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final State<Color> createTransitionAnimation4222222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl322222, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1222222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter322222, "LabelTextStyleColor", startRestartGroup, 196608);
                    TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$1222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                            return invoke(segment, composer2, num.intValue());
                        }

                        public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                            composer2.startReplaceGroup(-543659263);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                            }
                            TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return tween$default;
                        }
                    };
                    startRestartGroup.startReplaceGroup(1023351670);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    ColorSpace m1490getColorSpaceimpl2222222 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
                    changed2 = startRestartGroup.changed(m1490getColorSpaceimpl2222222);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion2).invoke(m1490getColorSpaceimpl2222222);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    TwoWayConverter twoWayConverter2222222 = (TwoWayConverter) rememberedValue2;
                    startRestartGroup.startReplaceGroup(1023351670);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Color m1481boximpl2222222 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
                    startRestartGroup.startReplaceGroup(1023351670);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final State<Color> createTransitionAnimation5222222 = TransitionKt.createTransitionAnimation(updateTransition, m1481boximpl2222222, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$1222222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter2222222, "LabelContentColor", startRestartGroup, 196608);
                    final float floatValue222222 = ((Number) createTransitionAnimation62.getValue()).floatValue();
                    startRestartGroup.startReplaceGroup(-156998101);
                    if (function22 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    boolean z21222222 = z11;
                    boolean z22222222 = z12;
                    boolean z23222222 = z13;
                    final long m918placeholderColorXeAY9LY$material3_release222222 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z21222222, z22222222, z23222222);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    State state322222 = (State) rememberedValue3;
                    startRestartGroup.startReplaceGroup(-156965270);
                    if (function214 == null) {
                    }
                    composableLambda = null;
                    startRestartGroup.endReplaceGroup();
                    final long m919prefixColorXeAY9LY$material3_release222222 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z21222222, z22222222, z23222222);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                    }
                    State state2222222 = (State) rememberedValue4;
                    startRestartGroup.startReplaceGroup(-156940524);
                    if (function210 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final long m920suffixColorXeAY9LY$material3_release222222 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z21222222, z22222222, z23222222);
                    startRestartGroup.startReplaceGroup(-156921964);
                    if (function212 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final long m917leadingIconColorXeAY9LY$material3_release222222 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z21222222, z22222222, z23222222);
                    startRestartGroup.startReplaceGroup(-156902962);
                    if (function215 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final long m923trailingIconColorXeAY9LY$material3_release222222 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z21222222, z22222222, z23222222);
                    startRestartGroup.startReplaceGroup(-156893937);
                    if (function213 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    final long m921supportingTextColorXeAY9LY$material3_release222222 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z21222222, z22222222, z23222222);
                    startRestartGroup.startReplaceGroup(-156884470);
                    if (function211 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                    if (i31 == i30) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z16 = z22222222;
                    function221 = function210;
                    function222 = function212;
                    function223 = function220;
                    function224 = function219;
                    function225 = function214;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final boolean z24 = z8;
                    final boolean z25 = z15;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$4
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

                        public final void invoke(Composer composer2, int i36) {
                            TextFieldImplKt.CommonDecorationBox(TextFieldType.this, str, function2, visualTransformation, function22, function225, function224, function223, function221, function222, function218, z24, z25, z16, interactionSource, paddingValues, textFieldColors, function29, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
                        }
                    });
                    return;
                }
                return;
            }
            i33 |= i32;
            i14 = i7 & 1024;
            if (i14 != 0) {
            }
            i16 = i7 & 2048;
            if (i16 != 0) {
            }
            i17 = i15;
            i18 = i7 & 4096;
            if (i18 != 0) {
            }
            i20 = i7 & 8192;
            if (i20 != 0) {
            }
            if ((i7 & 16384) != 0) {
            }
            if ((32768 & i7) != 0) {
            }
            if ((65536 & i7) != 0) {
            }
            if ((131072 & i7) != 0) {
            }
            if ((306783379 & i33) != 306783378) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i16 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i342 = i33;
            z9 = ((i33 & 7168) == 2048) | ((i33 & 112) == 32);
            Object rememberedValue52 = startRestartGroup.rememberedValue();
            if (z9) {
            }
            filter = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
            startRestartGroup.updateRememberedValue(filter);
            String text2 = ((TransformedText) filter).getText().getText();
            boolean booleanValue2 = FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 12) & 14).getValue().booleanValue();
            InputPhase inputPhase22 = booleanValue2 ? InputPhase.Focused : text2.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            m916labelColorXeAY9LY$material3_release = textFieldColors.m916labelColorXeAY9LY$material3_release(z17, z18, booleanValue2);
            int i352 = i17;
            Typography typography2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
            bodyLarge = typography2.getBodyLarge();
            final TextStyle bodySmall2 = typography2.getBodySmall();
            function210 = function229;
            function211 = function231;
            long m2298getColor0d7_KjU32 = bodyLarge.m2298getColor0d7_KjU();
            Color.Companion companion22 = Color.INSTANCE;
            function212 = function230;
            if (Color.m1487equalsimpl0(m2298getColor0d7_KjU32, companion22.m1501getUnspecified0d7_KjU())) {
            }
            m2298getColor0d7_KjU = bodySmall2.m2298getColor0d7_KjU();
            if (z10) {
                m2298getColor0d7_KjU = m916labelColorXeAY9LY$material3_release;
            }
            m2298getColor0d7_KjU2 = bodyLarge.m2298getColor0d7_KjU();
            if (z10) {
                m2298getColor0d7_KjU2 = m916labelColorXeAY9LY$material3_release;
            }
            j5 = m2298getColor0d7_KjU;
            if (function22 != null) {
            }
            Transition updateTransition2 = TransitionKt.updateTransition(inputPhase22, "TextFieldInputState", startRestartGroup, 48, 0);
            TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 textFieldImplKt$TextFieldTransitionScope$labelProgress$12 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelProgress$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                    composer2.startReplaceGroup(1276209157);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1276209157, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:354)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
            TwoWayConverter<Float, AnimationVector1D> vectorConverter4 = VectorConvertersKt.getVectorConverter(floatCompanionObject2);
            InputPhase inputPhase32 = (InputPhase) updateTransition2.getCurrentState();
            function213 = function228;
            startRestartGroup.startReplaceGroup(-2036730335);
            if (ComposerKt.isTraceInProgress()) {
            }
            iArr = WhenMappings.$EnumSwitchMapping$1;
            i21 = iArr[inputPhase32.ordinal()];
            if (i21 != 1) {
            }
            f5 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf42 = Float.valueOf(f5);
            InputPhase inputPhase422 = (InputPhase) updateTransition2.getTargetState();
            startRestartGroup.startReplaceGroup(-2036730335);
            if (ComposerKt.isTraceInProgress()) {
            }
            i22 = iArr[inputPhase422.ordinal()];
            if (i22 != 1) {
            }
            f6 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            State createTransitionAnimation622 = TransitionKt.createTransitionAnimation(updateTransition2, valueOf42, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$labelProgress$12.invoke((TextFieldImplKt$TextFieldTransitionScope$labelProgress$1) updateTransition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter4, "LabelProgress", startRestartGroup, 196608);
            TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                    FiniteAnimationSpec<Float> tween;
                    composer2.startReplaceGroup(-1154662212);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1154662212, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:367)");
                    }
                    InputPhase inputPhase5222 = InputPhase.Focused;
                    InputPhase inputPhase63 = InputPhase.UnfocusedEmpty;
                    if (segment.isTransitioningTo(inputPhase5222, inputPhase63)) {
                        tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                    } else if (!segment.isTransitioningTo(inputPhase63, inputPhase5222) && !segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase63)) {
                        tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    } else {
                        tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween;
                }
            };
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2222 = VectorConvertersKt.getVectorConverter(floatCompanionObject2);
            InputPhase inputPhase5222 = (InputPhase) updateTransition2.getCurrentState();
            startRestartGroup.startReplaceGroup(1435837472);
            if (ComposerKt.isTraceInProgress()) {
            }
            i23 = iArr[inputPhase5222.ordinal()];
            if (i23 != 1) {
            }
            f7 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf22222 = Float.valueOf(f7);
            InputPhase inputPhase62222 = (InputPhase) updateTransition2.getTargetState();
            startRestartGroup.startReplaceGroup(1435837472);
            if (ComposerKt.isTraceInProgress()) {
            }
            i24 = iArr[inputPhase62222.ordinal()];
            if (i24 != 1) {
            }
            f8 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            final State<Float> createTransitionAnimation222222 = TransitionKt.createTransitionAnimation(updateTransition2, valueOf22222, Float.valueOf(f8), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1222.invoke((TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1) updateTransition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter2222, "PlaceholderOpacity", startRestartGroup, 196608);
            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$122222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                    composer2.startReplaceGroup(-1868044898);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1868044898, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:396)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            TwoWayConverter<Float, AnimationVector1D> vectorConverter322222 = VectorConvertersKt.getVectorConverter(floatCompanionObject2);
            InputPhase inputPhase722222 = (InputPhase) updateTransition2.getCurrentState();
            startRestartGroup.startReplaceGroup(1128033978);
            if (ComposerKt.isTraceInProgress()) {
            }
            i25 = iArr[inputPhase722222.ordinal()];
            if (i25 != 1) {
            }
            f9 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            Float valueOf3222222 = Float.valueOf(f9);
            InputPhase inputPhase8222222 = (InputPhase) updateTransition2.getTargetState();
            startRestartGroup.startReplaceGroup(1128033978);
            if (ComposerKt.isTraceInProgress()) {
            }
            i26 = iArr[inputPhase8222222.ordinal()];
            if (i26 != 1) {
            }
            f10 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            final State<Float> createTransitionAnimation32222222 = TransitionKt.createTransitionAnimation(updateTransition2, valueOf3222222, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$122222.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter322222, "PrefixSuffixOpacity", startRestartGroup, 196608);
            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                    composer2.startReplaceGroup(1528582156);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            InputPhase inputPhase92222222 = (InputPhase) updateTransition2.getTargetState();
            startRestartGroup.startReplaceGroup(-107432127);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (iArr[inputPhase92222222.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            ColorSpace m1490getColorSpaceimpl3222222 = Color.m1490getColorSpaceimpl(j6);
            changed = startRestartGroup.changed(m1490getColorSpaceimpl3222222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion22).invoke(m1490getColorSpaceimpl3222222);
            startRestartGroup.updateRememberedValue(rememberedValue);
            TwoWayConverter twoWayConverter3222222 = (TwoWayConverter) rememberedValue;
            InputPhase inputPhase102222222 = (InputPhase) updateTransition2.getCurrentState();
            startRestartGroup.startReplaceGroup(-107432127);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (iArr[inputPhase102222222.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            Color m1481boximpl3222222 = Color.m1481boximpl(j7);
            inputPhase = (InputPhase) updateTransition2.getTargetState();
            startRestartGroup.startReplaceGroup(-107432127);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (iArr[inputPhase.ordinal()] == 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            final State<Color> createTransitionAnimation42222222 = TransitionKt.createTransitionAnimation(updateTransition2, m1481boximpl3222222, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$12222222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter3222222, "LabelTextStyleColor", startRestartGroup, 196608);
            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$12222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                    composer2.startReplaceGroup(-543659263);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                    }
                    TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return tween$default;
                }
            };
            startRestartGroup.startReplaceGroup(1023351670);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            ColorSpace m1490getColorSpaceimpl22222222 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
            changed2 = startRestartGroup.changed(m1490getColorSpaceimpl22222222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion22).invoke(m1490getColorSpaceimpl22222222);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            TwoWayConverter twoWayConverter22222222 = (TwoWayConverter) rememberedValue2;
            startRestartGroup.startReplaceGroup(1023351670);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            Color m1481boximpl22222222 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
            startRestartGroup.startReplaceGroup(1023351670);
            if (ComposerKt.isTraceInProgress()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceGroup();
            final State<Color> createTransitionAnimation52222222 = TransitionKt.createTransitionAnimation(updateTransition2, m1481boximpl22222222, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$12222222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition2.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter22222222, "LabelContentColor", startRestartGroup, 196608);
            final float floatValue2222222 = ((Number) createTransitionAnimation622.getValue()).floatValue();
            startRestartGroup.startReplaceGroup(-156998101);
            if (function22 == null) {
            }
            startRestartGroup.endReplaceGroup();
            boolean z212222222 = z11;
            boolean z222222222 = z12;
            boolean z232222222 = z13;
            final long m918placeholderColorXeAY9LY$material3_release2222222 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z212222222, z222222222, z232222222);
            rememberedValue3 = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue3 == companion.getEmpty()) {
            }
            State state3222222 = (State) rememberedValue3;
            startRestartGroup.startReplaceGroup(-156965270);
            if (function214 == null) {
            }
            composableLambda = null;
            startRestartGroup.endReplaceGroup();
            final long m919prefixColorXeAY9LY$material3_release2222222 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z212222222, z222222222, z232222222);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
            }
            State state22222222 = (State) rememberedValue4;
            startRestartGroup.startReplaceGroup(-156940524);
            if (function210 == null) {
            }
            startRestartGroup.endReplaceGroup();
            final long m920suffixColorXeAY9LY$material3_release2222222 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z212222222, z222222222, z232222222);
            startRestartGroup.startReplaceGroup(-156921964);
            if (function212 == null) {
            }
            startRestartGroup.endReplaceGroup();
            final long m917leadingIconColorXeAY9LY$material3_release2222222 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z212222222, z222222222, z232222222);
            startRestartGroup.startReplaceGroup(-156902962);
            if (function215 == null) {
            }
            startRestartGroup.endReplaceGroup();
            final long m923trailingIconColorXeAY9LY$material3_release2222222 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z212222222, z222222222, z232222222);
            startRestartGroup.startReplaceGroup(-156893937);
            if (function213 == null) {
            }
            startRestartGroup.endReplaceGroup();
            final long m921supportingTextColorXeAY9LY$material3_release2222222 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z212222222, z222222222, z232222222);
            startRestartGroup.startReplaceGroup(-156884470);
            if (function211 == null) {
            }
            startRestartGroup.endReplaceGroup();
            i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
            if (i31 == i30) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            z16 = z222222222;
            function221 = function210;
            function222 = function212;
            function223 = function220;
            function224 = function219;
            function225 = function214;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i7 & 8) == 0) {
        }
        if ((i7 & 16) == 0) {
        }
        i9 = i7 & 32;
        if (i9 == 0) {
        }
        i10 = i7 & 64;
        if (i10 == 0) {
        }
        i11 = i7 & 128;
        if (i11 == 0) {
        }
        i12 = i7 & 256;
        if (i12 == 0) {
        }
        i13 = i7 & 512;
        if (i13 == 0) {
        }
        i33 |= i32;
        i14 = i7 & 1024;
        if (i14 != 0) {
        }
        i16 = i7 & 2048;
        if (i16 != 0) {
        }
        i17 = i15;
        i18 = i7 & 4096;
        if (i18 != 0) {
        }
        i20 = i7 & 8192;
        if (i20 != 0) {
        }
        if ((i7 & 16384) != 0) {
        }
        if ((32768 & i7) != 0) {
        }
        if ((65536 & i7) != 0) {
        }
        if ((131072 & i7) != 0) {
        }
        if ((306783379 & i33) != 306783378) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i16 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i3422 = i33;
        z9 = ((i33 & 7168) == 2048) | ((i33 & 112) == 32);
        Object rememberedValue522 = startRestartGroup.rememberedValue();
        if (z9) {
        }
        filter = visualTransformation.filter(new AnnotatedString(str, null, null, 6, null));
        startRestartGroup.updateRememberedValue(filter);
        String text22 = ((TransformedText) filter).getText().getText();
        boolean booleanValue22 = FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i17 >> 12) & 14).getValue().booleanValue();
        InputPhase inputPhase222 = booleanValue22 ? InputPhase.Focused : text22.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
        m916labelColorXeAY9LY$material3_release = textFieldColors.m916labelColorXeAY9LY$material3_release(z17, z18, booleanValue22);
        int i3522 = i17;
        Typography typography22 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
        bodyLarge = typography22.getBodyLarge();
        final TextStyle bodySmall22 = typography22.getBodySmall();
        function210 = function229;
        function211 = function231;
        long m2298getColor0d7_KjU322 = bodyLarge.m2298getColor0d7_KjU();
        Color.Companion companion222 = Color.INSTANCE;
        function212 = function230;
        if (Color.m1487equalsimpl0(m2298getColor0d7_KjU322, companion222.m1501getUnspecified0d7_KjU())) {
        }
        m2298getColor0d7_KjU = bodySmall22.m2298getColor0d7_KjU();
        if (z10) {
        }
        m2298getColor0d7_KjU2 = bodyLarge.m2298getColor0d7_KjU();
        if (z10) {
        }
        j5 = m2298getColor0d7_KjU;
        if (function22 != null) {
        }
        Transition updateTransition22 = TransitionKt.updateTransition(inputPhase222, "TextFieldInputState", startRestartGroup, 48, 0);
        TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 textFieldImplKt$TextFieldTransitionScope$labelProgress$122 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelProgress$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }

            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                composer2.startReplaceGroup(1276209157);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1276209157, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:354)");
                }
                TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return tween$default;
            }
        };
        FloatCompanionObject floatCompanionObject22 = FloatCompanionObject.INSTANCE;
        TwoWayConverter<Float, AnimationVector1D> vectorConverter42 = VectorConvertersKt.getVectorConverter(floatCompanionObject22);
        InputPhase inputPhase322 = (InputPhase) updateTransition22.getCurrentState();
        function213 = function228;
        startRestartGroup.startReplaceGroup(-2036730335);
        if (ComposerKt.isTraceInProgress()) {
        }
        iArr = WhenMappings.$EnumSwitchMapping$1;
        i21 = iArr[inputPhase322.ordinal()];
        if (i21 != 1) {
        }
        f5 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        Float valueOf422 = Float.valueOf(f5);
        InputPhase inputPhase4222 = (InputPhase) updateTransition22.getTargetState();
        startRestartGroup.startReplaceGroup(-2036730335);
        if (ComposerKt.isTraceInProgress()) {
        }
        i22 = iArr[inputPhase4222.ordinal()];
        if (i22 != 1) {
        }
        f6 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        State createTransitionAnimation6222 = TransitionKt.createTransitionAnimation(updateTransition22, valueOf422, Float.valueOf(f6), textFieldImplKt$TextFieldTransitionScope$labelProgress$122.invoke((TextFieldImplKt$TextFieldTransitionScope$labelProgress$1) updateTransition22.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter42, "LabelProgress", startRestartGroup, 196608);
        TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$12222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }

            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                FiniteAnimationSpec<Float> tween;
                composer2.startReplaceGroup(-1154662212);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1154662212, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:367)");
                }
                InputPhase inputPhase52222 = InputPhase.Focused;
                InputPhase inputPhase63 = InputPhase.UnfocusedEmpty;
                if (segment.isTransitioningTo(inputPhase52222, inputPhase63)) {
                    tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
                } else if (!segment.isTransitioningTo(inputPhase63, inputPhase52222) && !segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, inputPhase63)) {
                    tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                } else {
                    tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return tween;
            }
        };
        TwoWayConverter<Float, AnimationVector1D> vectorConverter22222 = VectorConvertersKt.getVectorConverter(floatCompanionObject22);
        InputPhase inputPhase52222 = (InputPhase) updateTransition22.getCurrentState();
        startRestartGroup.startReplaceGroup(1435837472);
        if (ComposerKt.isTraceInProgress()) {
        }
        i23 = iArr[inputPhase52222.ordinal()];
        if (i23 != 1) {
        }
        f7 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        Float valueOf222222 = Float.valueOf(f7);
        InputPhase inputPhase622222 = (InputPhase) updateTransition22.getTargetState();
        startRestartGroup.startReplaceGroup(1435837472);
        if (ComposerKt.isTraceInProgress()) {
        }
        i24 = iArr[inputPhase622222.ordinal()];
        if (i24 != 1) {
        }
        f8 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        final State<Float> createTransitionAnimation2222222 = TransitionKt.createTransitionAnimation(updateTransition22, valueOf222222, Float.valueOf(f8), textFieldImplKt$TextFieldTransitionScope$placeholderOpacity$12222.invoke((TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1) updateTransition22.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter22222, "PlaceholderOpacity", startRestartGroup, 196608);
        TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }

            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                composer2.startReplaceGroup(-1868044898);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1868044898, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:396)");
                }
                TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return tween$default;
            }
        };
        TwoWayConverter<Float, AnimationVector1D> vectorConverter3222222 = VectorConvertersKt.getVectorConverter(floatCompanionObject22);
        InputPhase inputPhase7222222 = (InputPhase) updateTransition22.getCurrentState();
        startRestartGroup.startReplaceGroup(1128033978);
        if (ComposerKt.isTraceInProgress()) {
        }
        i25 = iArr[inputPhase7222222.ordinal()];
        if (i25 != 1) {
        }
        f9 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        Float valueOf32222222 = Float.valueOf(f9);
        InputPhase inputPhase82222222 = (InputPhase) updateTransition22.getTargetState();
        startRestartGroup.startReplaceGroup(1128033978);
        if (ComposerKt.isTraceInProgress()) {
        }
        i26 = iArr[inputPhase82222222.ordinal()];
        if (i26 != 1) {
        }
        f10 = 1.0f;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        final State<Float> createTransitionAnimation322222222 = TransitionKt.createTransitionAnimation(updateTransition22, valueOf32222222, Float.valueOf(f10), textFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1222222.invoke((TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1) updateTransition22.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), vectorConverter3222222, "PrefixSuffixOpacity", startRestartGroup, 196608);
        TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }

            public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                composer2.startReplaceGroup(1528582156);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1528582156, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:407)");
                }
                TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return tween$default;
            }
        };
        InputPhase inputPhase922222222 = (InputPhase) updateTransition22.getTargetState();
        startRestartGroup.startReplaceGroup(-107432127);
        if (ComposerKt.isTraceInProgress()) {
        }
        if (iArr[inputPhase922222222.ordinal()] == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        ColorSpace m1490getColorSpaceimpl32222222 = Color.m1490getColorSpaceimpl(j6);
        changed = startRestartGroup.changed(m1490getColorSpaceimpl32222222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion222).invoke(m1490getColorSpaceimpl32222222);
        startRestartGroup.updateRememberedValue(rememberedValue);
        TwoWayConverter twoWayConverter32222222 = (TwoWayConverter) rememberedValue;
        InputPhase inputPhase1022222222 = (InputPhase) updateTransition22.getCurrentState();
        startRestartGroup.startReplaceGroup(-107432127);
        if (ComposerKt.isTraceInProgress()) {
        }
        if (iArr[inputPhase1022222222.ordinal()] == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        Color m1481boximpl32222222 = Color.m1481boximpl(j7);
        inputPhase = (InputPhase) updateTransition22.getTargetState();
        startRestartGroup.startReplaceGroup(-107432127);
        if (ComposerKt.isTraceInProgress()) {
        }
        if (iArr[inputPhase.ordinal()] == 1) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        final State<Color> createTransitionAnimation422222222 = TransitionKt.createTransitionAnimation(updateTransition22, m1481boximpl32222222, Color.m1481boximpl(m2298getColor0d7_KjU2), textFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$122222222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1) updateTransition22.getSegment(), (Transition.Segment) startRestartGroup, (Composer) 0), twoWayConverter32222222, "LabelTextStyleColor", startRestartGroup, 196608);
        TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 textFieldImplKt$TextFieldTransitionScope$labelContentColor$122222222 = new Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Color>>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }

            public final FiniteAnimationSpec<Color> invoke(Transition.Segment<InputPhase> segment, Composer composer2, int i36) {
                composer2.startReplaceGroup(-543659263);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-543659263, i36, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:419)");
                }
                TweenSpec tween$default = AnimationSpecKt.tween$default(150, 0, null, 6, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return tween$default;
            }
        };
        startRestartGroup.startReplaceGroup(1023351670);
        if (ComposerKt.isTraceInProgress()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        ColorSpace m1490getColorSpaceimpl222222222 = Color.m1490getColorSpaceimpl(m916labelColorXeAY9LY$material3_release);
        changed2 = startRestartGroup.changed(m1490getColorSpaceimpl222222222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue2 = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(companion222).invoke(m1490getColorSpaceimpl222222222);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        TwoWayConverter twoWayConverter222222222 = (TwoWayConverter) rememberedValue2;
        startRestartGroup.startReplaceGroup(1023351670);
        if (ComposerKt.isTraceInProgress()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        Color m1481boximpl222222222 = Color.m1481boximpl(m916labelColorXeAY9LY$material3_release);
        startRestartGroup.startReplaceGroup(1023351670);
        if (ComposerKt.isTraceInProgress()) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.endReplaceGroup();
        final State<Color> createTransitionAnimation522222222 = TransitionKt.createTransitionAnimation(updateTransition22, m1481boximpl222222222, Color.m1481boximpl(m916labelColorXeAY9LY$material3_release), textFieldImplKt$TextFieldTransitionScope$labelContentColor$122222222.invoke((TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1) updateTransition22.getSegment(), (Transition.Segment) startRestartGroup, (Composer) Integer.valueOf(i27)), twoWayConverter222222222, "LabelContentColor", startRestartGroup, 196608);
        final float floatValue22222222 = ((Number) createTransitionAnimation6222.getValue()).floatValue();
        startRestartGroup.startReplaceGroup(-156998101);
        if (function22 == null) {
        }
        startRestartGroup.endReplaceGroup();
        boolean z2122222222 = z11;
        boolean z2222222222 = z12;
        boolean z2322222222 = z13;
        final long m918placeholderColorXeAY9LY$material3_release22222222 = textFieldColors.m918placeholderColorXeAY9LY$material3_release(z2122222222, z2222222222, z2322222222);
        rememberedValue3 = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue3 == companion.getEmpty()) {
        }
        State state32222222 = (State) rememberedValue3;
        startRestartGroup.startReplaceGroup(-156965270);
        if (function214 == null) {
        }
        composableLambda = null;
        startRestartGroup.endReplaceGroup();
        final long m919prefixColorXeAY9LY$material3_release22222222 = textFieldColors.m919prefixColorXeAY9LY$material3_release(z2122222222, z2222222222, z2322222222);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        State state222222222 = (State) rememberedValue4;
        startRestartGroup.startReplaceGroup(-156940524);
        if (function210 == null) {
        }
        startRestartGroup.endReplaceGroup();
        final long m920suffixColorXeAY9LY$material3_release22222222 = textFieldColors.m920suffixColorXeAY9LY$material3_release(z2122222222, z2222222222, z2322222222);
        startRestartGroup.startReplaceGroup(-156921964);
        if (function212 == null) {
        }
        startRestartGroup.endReplaceGroup();
        final long m917leadingIconColorXeAY9LY$material3_release22222222 = textFieldColors.m917leadingIconColorXeAY9LY$material3_release(z2122222222, z2222222222, z2322222222);
        startRestartGroup.startReplaceGroup(-156902962);
        if (function215 == null) {
        }
        startRestartGroup.endReplaceGroup();
        final long m923trailingIconColorXeAY9LY$material3_release22222222 = textFieldColors.m923trailingIconColorXeAY9LY$material3_release(z2122222222, z2222222222, z2322222222);
        startRestartGroup.startReplaceGroup(-156893937);
        if (function213 == null) {
        }
        startRestartGroup.endReplaceGroup();
        final long m921supportingTextColorXeAY9LY$material3_release22222222 = textFieldColors.m921supportingTextColorXeAY9LY$material3_release(z2122222222, z2222222222, z2322222222);
        startRestartGroup.startReplaceGroup(-156884470);
        if (function211 == null) {
        }
        startRestartGroup.endReplaceGroup();
        i31 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
        if (i31 == i30) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        z16 = z2222222222;
        function221 = function210;
        function222 = function212;
        function223 = function220;
        function224 = function219;
        function225 = function214;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean CommonDecorationBox$lambda$15$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Decoration-3J-VO9M, reason: not valid java name */
    public static final void m997Decoration3JVO9M(final long j5, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1208685580);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(j5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1208685580, i6, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:298)");
            }
            ProvideContentColorTextStyleKt.m994ProvideContentColorTextStyle3JVO9M(j5, textStyle, function2, startRestartGroup, i6 & 1022);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$1
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

                public final void invoke(Composer composer2, int i7) {
                    TextFieldImplKt.m997Decoration3JVO9M(j5, textStyle, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Decoration-Iv8Zu3U, reason: not valid java name */
    public static final void m998DecorationIv8Zu3U(final long j5, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(660142980);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(j5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(660142980, i6, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:303)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m1481boximpl(j5)), function2, startRestartGroup, (i6 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$Decoration$2
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

                public final void invoke(Composer composer2, int i7) {
                    TextFieldImplKt.m998DecorationIv8Zu3U(j5, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m1001animateBorderStrokeAsStateNuRrP5Q(boolean z5, boolean z6, boolean z7, TextFieldColors textFieldColors, float f5, float f6, Composer composer, int i5) {
        State<Color> rememberUpdatedState;
        State<Dp> rememberUpdatedState2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2047013045, i5, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:441)");
        }
        long m915indicatorColorXeAY9LY$material3_release = textFieldColors.m915indicatorColorXeAY9LY$material3_release(z5, z6, z7);
        if (z5) {
            composer.startReplaceGroup(1023053998);
            rememberUpdatedState = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(m915indicatorColorXeAY9LY$material3_release, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, composer, 48, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1023165505);
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1481boximpl(m915indicatorColorXeAY9LY$material3_release), composer, 0);
            composer.endReplaceGroup();
        }
        State<Color> state = rememberUpdatedState;
        if (z5) {
            composer.startReplaceGroup(1023269417);
            rememberUpdatedState2 = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(z7 ? f5 : f6, AnimationSpecKt.tween$default(150, 0, null, 6, null), null, null, composer, 48, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1023478388);
            rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Dp.m2597boximpl(f6), composer, (i5 >> 15) & 14);
            composer.endReplaceGroup();
        }
        State<BorderStroke> rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.m117BorderStrokecXLIe8U(rememberUpdatedState2.getValue().getValue(), state.getValue().getValue()), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return rememberUpdatedState3;
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z5, final String str) {
        return z5 ? SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$defaultErrorSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
            }
        }, 1, null) : modifier;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Modifier textFieldBackground(Modifier modifier, final ColorProducer colorProducer, final Shape shape) {
        return DrawModifierKt.drawWithCache(modifier, new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$textFieldBackground$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                final Outline mo131createOutlinePq9zytI = Shape.this.mo131createOutlinePq9zytI(cacheDrawScope.m1261getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                final ColorProducer colorProducer2 = colorProducer;
                return cacheDrawScope.onDrawBehind(new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.internal.TextFieldImplKt$textFieldBackground$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawScope) {
                        OutlineKt.m1568drawOutlinewDX37Ww(drawScope, Outline.this, colorProducer2.mo687invoke0d7_KjU(), (r17 & 4) != 0 ? 1.0f : 0.0f, (r17 & 8) != 0 ? Fill.INSTANCE : null, (r17 & 16) != 0 ? null : null, (r17 & 32) != 0 ? DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU() : 0);
                    }
                });
            }
        });
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }
}
