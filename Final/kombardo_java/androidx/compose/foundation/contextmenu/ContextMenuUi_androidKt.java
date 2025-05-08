package androidx.compose.foundation.contextmenu;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\u001aC\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001aK\u0010\n\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000e\u001a5\u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0007H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aW\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001f\u001a\u00020\f2\b\b\u0003\u0010\u001d\u001a\u00020\u001c2\b\b\u0003\u0010\u001e\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 \u001a2\u0010'\u001a\u00020\u0017*\u00020!2\b\b\u0001\u0010\"\u001a\u00020\u001c2\b\b\u0001\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a)\u0010)\u001a\u0004\u0018\u00010(*\u00020!2\b\b\u0001\u0010\"\u001a\u00020\u001c2\b\b\u0001\u0010#\u001a\u00020\u001cH\u0002¢\u0006\u0004\b)\u0010*\u001a \u0010-\u001a\u00020\u0017*\u0004\u0018\u00010(2\u0006\u0010$\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a \u0010/\u001a\u00020\u0017*\u0004\u0018\u00010(2\u0006\u0010$\u001a\u00020\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010,\"\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102\"\u0014\u00104\u001a\u0002038\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\" \u00106\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b6\u00107\u0012\u0004\b:\u0010;\u001a\u0004\b8\u00109\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"Landroidx/compose/ui/window/PopupPositionProvider;", "popupPositionProvider", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onDismiss", "Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "contextMenuBuilderBlock", "ContextMenuPopup", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "colors", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "content", "ContextMenuColumn", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/ui/graphics/Color;", "leadingIcon", "onClick", "ContextMenuItem", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "backgroundStyleId", "foregroundStyleId", "computeContextMenuColors", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "Landroid/content/Context;", "resId", "attrId", "defaultColor", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColor", "Landroid/content/res/ColorStateList;", "resolveColorStateList", "(Landroid/content/Context;II)Landroid/content/res/ColorStateList;", "enabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "enabledColor", "disabledColor-4WTKRHQ", "disabledColor", "Landroidx/compose/ui/window/PopupProperties;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", BuildConfig.FLAVOR, "DisabledAlpha", "F", "DefaultContextMenuColors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "getDefaultContextMenuColors$annotations", "()V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ContextMenuUi_androidKt {
    private static final ContextMenuColors DefaultContextMenuColors;
    private static final PopupProperties DefaultPopupProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
    private static final float DisabledAlpha = 0.38f;

    static {
        Color.Companion companion = Color.INSTANCE;
        DefaultContextMenuColors = new ContextMenuColors(companion.m1502getWhite0d7_KjU(), companion.m1496getBlack0d7_KjU(), companion.m1496getBlack0d7_KjU(), Color.m1485copywmQWz5c$default(companion.m1496getBlack0d7_KjU(), DisabledAlpha, 0.0f, 0.0f, 0.0f, 14, null), Color.m1485copywmQWz5c$default(companion.m1496getBlack0d7_KjU(), DisabledAlpha, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuColumn(final ContextMenuColors contextMenuColors, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        Modifier modifier3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-921259293);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(contextMenuColors) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
            }
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-921259293, i7, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumn (ContextMenuUi.android.kt:144)");
                }
                ContextMenuSpec contextMenuSpec = ContextMenuSpec.INSTANCE;
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(IntrinsicKt.width(BackgroundKt.m104backgroundbw27NRU$default(ShadowKt.m1270shadows4CzXII$default(modifier3, contextMenuSpec.m162getMenuContainerElevationD9Ej5fM(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(contextMenuSpec.m158getCornerRadiusD9Ej5fM()), false, 0L, 0L, 28, null), contextMenuColors.getBackgroundColor(), null, 2, null), IntrinsicSize.Max), 0.0f, contextMenuSpec.m163getVerticalPaddingD9Ej5fM(), 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
                int i9 = (i7 << 3) & 7168;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                function3.invoke(ColumnScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
                startRestartGroup.endNode();
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
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuColumn$1
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

                    public final void invoke(Composer composer2, int i10) {
                        ContextMenuUi_androidKt.ContextMenuColumn(ContextMenuColors.this, modifier4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
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
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ContextMenuSpec contextMenuSpec2 = ContextMenuSpec.INSTANCE;
        Modifier verticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(IntrinsicKt.width(BackgroundKt.m104backgroundbw27NRU$default(ShadowKt.m1270shadows4CzXII$default(modifier3, contextMenuSpec2.m162getMenuContainerElevationD9Ej5fM(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(contextMenuSpec2.m158getCornerRadiusD9Ej5fM()), false, 0L, 0L, 28, null), contextMenuColors.getBackgroundColor(), null, 2, null), IntrinsicSize.Max), 0.0f, contextMenuSpec2.m163getVerticalPaddingD9Ej5fM(), 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
        int i92 = (i7 << 3) & 7168;
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default2);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
        function3.invoke(ColumnScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i92 >> 6) & 112) | 6));
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00a3  */
    @SuppressLint({"ComposableLambdaParameterPosition"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuItem(final String str, final boolean z5, final ContextMenuColors contextMenuColors, Modifier modifier, Function3<? super Color, ? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        Function3<? super Color, ? super Composer, ? super Integer, Unit> function32;
        int i9;
        boolean z6;
        Object rememberedValue;
        Function3<? super Color, ? super Composer, ? super Integer, Unit> function33;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        final Function3<? super Color, ? super Composer, ? super Integer, Unit> function34;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(791018367);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(contextMenuColors) ? 256 : 128;
        }
        int i10 = i6 & 8;
        if (i10 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                function32 = function3;
                i7 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                if ((i6 & 32) != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
                }
                i9 = i7;
                if ((74899 & i9) == 74898 || !startRestartGroup.getSkipping()) {
                    Modifier modifier4 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                    if (i8 != 0) {
                        function32 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(791018367, i9, -1, "androidx.compose.foundation.contextmenu.ContextMenuItem (ContextMenuUi.android.kt:181)");
                    }
                    ContextMenuSpec contextMenuSpec = ContextMenuSpec.INSTANCE;
                    Alignment.Vertical labelVerticalTextAlignment = contextMenuSpec.getLabelVerticalTextAlignment();
                    Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(contextMenuSpec.m159getHorizontalPaddingD9Ej5fM());
                    z6 = ((i9 & 112) == 32) | ((458752 & i9) == 131072);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0<Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                if (z5) {
                                    function0.invoke();
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    function33 = function32;
                    Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.m334sizeInqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m122clickableXHw0xAI$default(modifier4, z5, str, null, (Function0) rememberedValue, 4, null), 0.0f, 1, null), contextMenuSpec.m157getContainerWidthMinD9Ej5fM(), contextMenuSpec.m161getListItemHeightD9Ej5fM(), contextMenuSpec.m156getContainerWidthMaxD9Ej5fM(), contextMenuSpec.m161getListItemHeightD9Ej5fM()), contextMenuSpec.m159getHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, labelVerticalTextAlignment, startRestartGroup, 54);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    if (function33 == null) {
                        startRestartGroup.startReplaceGroup(554568909);
                    } else {
                        startRestartGroup.startReplaceGroup(554568910);
                        Modifier m330requiredSizeInqDBjuR0$default = SizeKt.m330requiredSizeInqDBjuR0$default(Modifier.INSTANCE, contextMenuSpec.m160getIconSizeD9Ej5fM(), 0.0f, contextMenuSpec.m160getIconSizeD9Ej5fM(), contextMenuSpec.m160getIconSizeD9Ej5fM(), 2, null);
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m330requiredSizeInqDBjuR0$default);
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
                        function33.invoke(Color.m1481boximpl(z5 ? contextMenuColors.getIconColor() : contextMenuColors.getDisabledIconColor()), startRestartGroup, 0);
                        startRestartGroup.endNode();
                    }
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                    BasicTextKt.m465BasicTextVhcvRP8(str, rowScopeInstance.weight(Modifier.INSTANCE, 1.0f, true), contextMenuSpec.m164textStyle8_81llA(z5 ? contextMenuColors.getTextColor() : contextMenuColors.getDisabledTextColor()), null, 0, false, 1, 0, null, composer2, (i9 & 14) | 1572864, 440);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function34 = function33;
                    modifier3 = modifier4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function34 = function32;
                    composer2 = startRestartGroup;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11) {
                            ContextMenuUi_androidKt.ContextMenuItem(str, z5, contextMenuColors, modifier3, function34, function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                        }
                    });
                    return;
                }
                return;
            }
            function32 = function3;
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
            ContextMenuSpec contextMenuSpec2 = ContextMenuSpec.INSTANCE;
            Alignment.Vertical labelVerticalTextAlignment2 = contextMenuSpec2.getLabelVerticalTextAlignment();
            Arrangement.HorizontalOrVertical m265spacedBy0680j_42 = Arrangement.INSTANCE.m265spacedBy0680j_4(contextMenuSpec2.m159getHorizontalPaddingD9Ej5fM());
            z6 = ((i9 & 112) == 32) | ((458752 & i9) == 131072);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z6) {
            }
            rememberedValue = new Function0<Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (z5) {
                        function0.invoke();
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            function33 = function32;
            Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(SizeKt.m334sizeInqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m122clickableXHw0xAI$default(modifier4, z5, str, null, (Function0) rememberedValue, 4, null), 0.0f, 1, null), contextMenuSpec2.m157getContainerWidthMinD9Ej5fM(), contextMenuSpec2.m161getListItemHeightD9Ej5fM(), contextMenuSpec2.m156getContainerWidthMaxD9Ej5fM(), contextMenuSpec2.m161getListItemHeightD9Ej5fM()), contextMenuSpec2.m159getHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(m265spacedBy0680j_42, labelVerticalTextAlignment2, startRestartGroup, 54);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            if (function33 == null) {
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BasicTextKt.m465BasicTextVhcvRP8(str, rowScopeInstance2.weight(Modifier.INSTANCE, 1.0f, true), contextMenuSpec2.m164textStyle8_81llA(z5 ? contextMenuColors.getTextColor() : contextMenuColors.getDisabledTextColor()), null, 0, false, 1, 0, null, composer2, (i9 & 14) | 1572864, 440);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function34 = function33;
            modifier3 = modifier4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        function32 = function3;
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
        ContextMenuSpec contextMenuSpec22 = ContextMenuSpec.INSTANCE;
        Alignment.Vertical labelVerticalTextAlignment22 = contextMenuSpec22.getLabelVerticalTextAlignment();
        Arrangement.HorizontalOrVertical m265spacedBy0680j_422 = Arrangement.INSTANCE.m265spacedBy0680j_4(contextMenuSpec22.m159getHorizontalPaddingD9Ej5fM());
        z6 = ((i9 & 112) == 32) | ((458752 & i9) == 131072);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z6) {
        }
        rememberedValue = new Function0<Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuItem$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (z5) {
                    function0.invoke();
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        function33 = function32;
        Modifier m313paddingVpY3zN4$default22 = PaddingKt.m313paddingVpY3zN4$default(SizeKt.m334sizeInqDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.m122clickableXHw0xAI$default(modifier4, z5, str, null, (Function0) rememberedValue, 4, null), 0.0f, 1, null), contextMenuSpec22.m157getContainerWidthMinD9Ej5fM(), contextMenuSpec22.m161getListItemHeightD9Ej5fM(), contextMenuSpec22.m156getContainerWidthMaxD9Ej5fM(), contextMenuSpec22.m161getListItemHeightD9Ej5fM()), contextMenuSpec22.m159getHorizontalPaddingD9Ej5fM(), 0.0f, 2, null);
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(m265spacedBy0680j_422, labelVerticalTextAlignment22, startRestartGroup, 54);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default22);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor32 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy22, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion22.getSetModifier());
        RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
        if (function33 == null) {
        }
        startRestartGroup.endReplaceGroup();
        composer2 = startRestartGroup;
        BasicTextKt.m465BasicTextVhcvRP8(str, rowScopeInstance22.weight(Modifier.INSTANCE, 1.0f, true), contextMenuSpec22.m164textStyle8_81llA(z5 ? contextMenuColors.getTextColor() : contextMenuColors.getDisabledTextColor()), null, 0, false, 1, 0, null, composer2, (i9 & 14) | 1572864, 440);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function34 = function33;
        modifier3 = modifier4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void ContextMenuPopup(final PopupPositionProvider popupPositionProvider, final Function0<Unit> function0, Modifier modifier, final Function1<? super ContextMenuScope, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(712057293);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(712057293, i7, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:103)");
            }
            ContextMenuPopup(popupPositionProvider, function0, modifier, computeContextMenuColors(0, 0, startRestartGroup, 0, 3), function1, startRestartGroup, (i7 & 1022) | ((i7 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$1
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

                public final void invoke(Composer composer2, int i9) {
                    ContextMenuUi_androidKt.ContextMenuPopup(PopupPositionProvider.this, function0, modifier2, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    public static final ContextMenuColors computeContextMenuColors(int i5, int i6, Composer composer, int i7, int i8) {
        int i9 = (i8 & 1) != 0 ? R.style.Widget.PopupMenu : i5;
        int i10 = (i8 & 2) != 0 ? R.style.TextAppearance.Widget.PopupMenu.Large : i6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1689505294, i7, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:354)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        boolean changed = composer.changed((Configuration) composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration())) | composer.changed(context);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            ContextMenuColors contextMenuColors = DefaultContextMenuColors;
            long m168resolveColorg2O1Hgs = m168resolveColorg2O1Hgs(context, i9, R.attr.colorBackground, contextMenuColors.getBackgroundColor());
            ColorStateList resolveColorStateList = resolveColorStateList(context, i10, R.attr.textColorPrimary);
            long m167enabledColor4WTKRHQ = m167enabledColor4WTKRHQ(resolveColorStateList, contextMenuColors.getTextColor());
            long m166disabledColor4WTKRHQ = m166disabledColor4WTKRHQ(resolveColorStateList, contextMenuColors.getDisabledTextColor());
            rememberedValue = new ContextMenuColors(m168resolveColorg2O1Hgs, m167enabledColor4WTKRHQ, m167enabledColor4WTKRHQ, m166disabledColor4WTKRHQ, m166disabledColor4WTKRHQ, null);
            composer.updateRememberedValue(rememberedValue);
        }
        ContextMenuColors contextMenuColors2 = (ContextMenuColors) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return contextMenuColors2;
    }

    /* renamed from: disabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m166disabledColor4WTKRHQ(ColorStateList colorStateList, long j5) {
        int m1508toArgb8_81llA = ColorKt.m1508toArgb8_81llA(j5);
        Integer valueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{-16842910}, m1508toArgb8_81llA)) : null;
        return (valueOf == null || valueOf.intValue() == m1508toArgb8_81llA) ? j5 : ColorKt.Color(valueOf.intValue());
    }

    /* renamed from: enabledColor-4WTKRHQ, reason: not valid java name */
    private static final long m167enabledColor4WTKRHQ(ColorStateList colorStateList, long j5) {
        int m1508toArgb8_81llA = ColorKt.m1508toArgb8_81llA(j5);
        Integer valueOf = colorStateList != null ? Integer.valueOf(colorStateList.getColorForState(new int[]{R.attr.state_enabled}, m1508toArgb8_81llA)) : null;
        return (valueOf == null || valueOf.intValue() == m1508toArgb8_81llA) ? j5 : ColorKt.Color(valueOf.intValue());
    }

    /* renamed from: resolveColor-g2O1Hgs, reason: not valid java name */
    private static final long m168resolveColorg2O1Hgs(Context context, int i5, int i6, long j5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5, new int[]{i6});
        int m1508toArgb8_81llA = ColorKt.m1508toArgb8_81llA(j5);
        int color = obtainStyledAttributes.getColor(0, m1508toArgb8_81llA);
        obtainStyledAttributes.recycle();
        return color == m1508toArgb8_81llA ? j5 : ColorKt.Color(color);
    }

    private static final ColorStateList resolveColorStateList(Context context, int i5, int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i5, new int[]{i6});
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
        obtainStyledAttributes.recycle();
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ContextMenuPopup(final PopupPositionProvider popupPositionProvider, final Function0<Unit> function0, Modifier modifier, final ContextMenuColors contextMenuColors, final Function1<? super ContextMenuScope, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1447189339);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i6 & 8) == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changed(contextMenuColors) ? 2048 : 1024;
            }
            if ((i6 & 16) == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
            }
            if ((i7 & 9363) != 9362 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                final Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1447189339, i7, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:121)");
                }
                AndroidPopup_androidKt.Popup(popupPositionProvider, function0, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(795909757, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$2
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

                    public final void invoke(Composer composer2, int i9) {
                        if ((i9 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(795909757, i9, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous> (ContextMenuUi.android.kt:127)");
                        }
                        final ContextMenuColors contextMenuColors2 = ContextMenuColors.this;
                        Modifier modifier5 = modifier4;
                        final Function1<ContextMenuScope, Unit> function12 = function1;
                        ContextMenuUi_androidKt.ContextMenuColumn(contextMenuColors2, modifier5, ComposableLambdaKt.rememberComposableLambda(1156688164, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                                invoke(columnScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope columnScope, Composer composer3, int i10) {
                                if ((i10 & 17) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1156688164, i10, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous>.<anonymous> (ContextMenuUi.android.kt:128)");
                                }
                                Object rememberedValue = composer3.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new ContextMenuScope();
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                ContextMenuScope contextMenuScope = (ContextMenuScope) rememberedValue;
                                Function1<ContextMenuScope, Unit> function13 = function12;
                                ContextMenuColors contextMenuColors3 = contextMenuColors2;
                                contextMenuScope.clear$foundation_release();
                                function13.invoke(contextMenuScope);
                                contextMenuScope.Content$foundation_release(contextMenuColors3, composer3, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 384, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i7 & 14) | 3456 | (i7 & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$3
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

                    public final void invoke(Composer composer2, int i9) {
                        ContextMenuUi_androidKt.ContextMenuPopup(PopupPositionProvider.this, function0, modifier3, contextMenuColors, function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i6 & 8) == 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if ((i7 & 9363) != 9362) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        AndroidPopup_androidKt.Popup(popupPositionProvider, function0, DefaultPopupProperties, ComposableLambdaKt.rememberComposableLambda(795909757, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$2
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

            public final void invoke(Composer composer2, int i9) {
                if ((i9 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(795909757, i9, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous> (ContextMenuUi.android.kt:127)");
                }
                final ContextMenuColors contextMenuColors2 = ContextMenuColors.this;
                Modifier modifier5 = modifier4;
                final Function1<? super ContextMenuScope, Unit> function12 = function1;
                ContextMenuUi_androidKt.ContextMenuColumn(contextMenuColors2, modifier5, ComposableLambdaKt.rememberComposableLambda(1156688164, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuUi_androidKt$ContextMenuPopup$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                        invoke(columnScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ColumnScope columnScope, Composer composer3, int i10) {
                        if ((i10 & 17) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1156688164, i10, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup.<anonymous>.<anonymous> (ContextMenuUi.android.kt:128)");
                        }
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new ContextMenuScope();
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        ContextMenuScope contextMenuScope = (ContextMenuScope) rememberedValue;
                        Function1<ContextMenuScope, Unit> function13 = function12;
                        ContextMenuColors contextMenuColors3 = contextMenuColors2;
                        contextMenuScope.clear$foundation_release();
                        function13.invoke(contextMenuScope);
                        contextMenuScope.Content$foundation_release(contextMenuColors3, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 384, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i7 & 14) | 3456 | (i7 & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
