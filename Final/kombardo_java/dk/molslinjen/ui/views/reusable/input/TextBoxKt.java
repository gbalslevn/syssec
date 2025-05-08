package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.TextBoxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a©\u0001\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "value", "label", "contentDescription", BuildConfig.FLAVOR, "enabled", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "focused", "showError", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "inputColor", "defaultBorder", "leadingContent", "trailingContent", "TextBox-NpQZenA", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;ZZJJJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextBox", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TextBoxKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0538  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d8  */
    /* renamed from: TextBox-NpQZenA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3414TextBoxNpQZenA(Modifier modifier, final String str, String str2, String str3, boolean z5, final Function0<Unit> onClick, boolean z6, boolean z7, long j5, long j6, long j7, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i5, final int i6, final int i7) {
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
        String str4;
        boolean z8;
        long m3264getGrey10d7_KjU;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int i19;
        long j8;
        BorderStroke m117BorderStrokecXLIe8U;
        BorderStroke m117BorderStrokecXLIe8U2;
        boolean z9;
        Object rememberedValue;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        boolean z10;
        Object rememberedValue2;
        final String str5;
        final boolean z11;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        final String str6;
        final boolean z12;
        final boolean z13;
        final long j9;
        final long j10;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(143171276);
        int i20 = i7 & 1;
        if (i20 != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = i5 | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i21 = i8;
        int i22 = i7 & 4;
        if (i22 != 0) {
            i21 |= 384;
        } else if ((i5 & 384) == 0) {
            i21 |= startRestartGroup.changed(str2) ? 256 : 128;
            i9 = i7 & 8;
            if (i9 == 0) {
                i21 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i21 |= startRestartGroup.changed(str3) ? 2048 : 1024;
                i10 = i7 & 16;
                if (i10 != 0) {
                    i21 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i21 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                    if ((i7 & 32) == 0) {
                        i21 |= 196608;
                    } else if ((i5 & 196608) == 0) {
                        i21 |= startRestartGroup.changedInstance(onClick) ? 131072 : 65536;
                    }
                    i11 = i7 & 64;
                    if (i11 == 0) {
                        i21 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i21 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                    }
                    i12 = i7 & 128;
                    if (i12 == 0) {
                        i21 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i21 |= startRestartGroup.changed(z7) ? 8388608 : 4194304;
                    }
                    i13 = i7 & 256;
                    if (i13 == 0) {
                        i21 |= 100663296;
                    } else if ((100663296 & i5) == 0) {
                        i21 |= startRestartGroup.changed(j5) ? 67108864 : 33554432;
                    }
                    i14 = i7 & 512;
                    if (i14 == 0) {
                        i21 |= 805306368;
                    } else if ((i5 & 805306368) == 0) {
                        i21 |= startRestartGroup.changed(j6) ? 536870912 : 268435456;
                    }
                    i15 = 1024 & i7;
                    if (i15 == 0) {
                        i16 = i6 | 6;
                    } else if ((i6 & 6) == 0) {
                        i16 = i6 | (startRestartGroup.changed(j7) ? 4 : 2);
                    } else {
                        i16 = i6;
                    }
                    i17 = i7 & 2048;
                    if (i17 == 0) {
                        i16 |= 48;
                    } else if ((i6 & 48) == 0) {
                        i16 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
                    }
                    int i23 = i16;
                    i18 = i7 & 4096;
                    if (i18 == 0) {
                        i23 |= 384;
                    } else if ((i6 & 384) == 0) {
                        i23 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
                        if ((i21 & 306783379) != 306783378 && (i23 & 147) == 146 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            str6 = str2;
                            str5 = str3;
                            z12 = z5;
                            z13 = z6;
                            z11 = z7;
                            j9 = j5;
                            m3264getGrey10d7_KjU = j6;
                            j10 = j7;
                            function25 = function2;
                            function26 = function22;
                        } else {
                            Modifier modifier3 = i20 != 0 ? Modifier.INSTANCE : modifier;
                            str4 = i22 != 0 ? null : str2;
                            String str7 = i9 != 0 ? null : str3;
                            boolean z14 = i10 != 0 ? true : z5;
                            boolean z15 = i11 != 0 ? false : z6;
                            z8 = i12 != 0 ? false : z7;
                            long m3281getWhite0d7_KjU = i13 != 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j5;
                            m3264getGrey10d7_KjU = i14 != 0 ? AppColor.INSTANCE.m3264getGrey10d7_KjU() : j6;
                            long m3267getGrey40d7_KjU = i15 != 0 ? AppColor.INSTANCE.m3267getGrey40d7_KjU() : j7;
                            function23 = i17 != 0 ? null : function2;
                            function24 = i18 != 0 ? null : function22;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(143171276, i21, i23, "dk.molslinjen.ui.views.reusable.input.TextBox (TextBox.kt:43)");
                            }
                            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(modifier3, m3281getWhite0d7_KjU, null, 2, null);
                            Arrangement arrangement = Arrangement.INSTANCE;
                            Arrangement.Vertical top = arrangement.getTop();
                            Alignment.Companion companion = Alignment.INSTANCE;
                            Modifier modifier4 = modifier3;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            startRestartGroup.startReplaceGroup(-773831338);
                            if (str4 != null) {
                                TextKt.m940Text4IGK_g(str4, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
                                Unit unit = Unit.INSTANCE;
                            }
                            startRestartGroup.endReplaceGroup();
                            if (z8) {
                                m117BorderStrokecXLIe8U2 = BorderStrokeKt.m117BorderStrokecXLIe8U(Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3272getSignalRed0d7_KjU());
                            } else if (z15) {
                                m117BorderStrokecXLIe8U2 = BorderStrokeKt.m117BorderStrokecXLIe8U(Dp.m2599constructorimpl(2), AppColor.INSTANCE.m3253getBrandBlack10d7_KjU());
                            } else {
                                i19 = 1;
                                j8 = m3267getGrey40d7_KjU;
                                m117BorderStrokecXLIe8U = BorderStrokeKt.m117BorderStrokecXLIe8U(Dp.m2599constructorimpl(1), j8);
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                boolean z16 = z8;
                                long j11 = j8;
                                Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.border(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m327heightInVpY3zN4$default(companion3, Dp.m2599constructorimpl(44), 0.0f, 2, null), 0.0f, i19, null), ThemeShapesKt.getThemeShapes().getMedium()), m117BorderStrokecXLIe8U, ThemeShapesKt.getThemeShapes().getMedium()), !z14 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
                                startRestartGroup.startReplaceGroup(-773806303);
                                z9 = (458752 & i21) != 131072;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function0() { // from class: c2.y
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            Unit TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                                            TextBox_NpQZenA$lambda$6$lambda$2$lambda$1 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$2$lambda$1(Function0.this);
                                            return TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceGroup();
                                float f5 = 16;
                                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default2, z14, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(8));
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), startRestartGroup, 48);
                                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
                                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                                if (startRestartGroup.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.useNode();
                                } else {
                                    startRestartGroup.createNode(constructor2);
                                }
                                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                startRestartGroup.startReplaceGroup(1643290520);
                                if (function23 != null) {
                                    function23.invoke(startRestartGroup, Integer.valueOf((i23 >> 3) & 14));
                                    SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                }
                                startRestartGroup.endReplaceGroup();
                                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                                startRestartGroup.startReplaceGroup(1643298526);
                                z10 = ((i21 & 7168) != 2048) | ((i21 & 112) != 32);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!z10 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    str5 = str7;
                                    rememberedValue2 = new Function1() { // from class: c2.z
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            Unit TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                                            TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3(str5, str, (SemanticsPropertyReceiver) obj);
                                            return TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                } else {
                                    str5 = str7;
                                }
                                startRestartGroup.endReplaceGroup();
                                TextKt.m940Text4IGK_g(str != null ? BuildConfig.FLAVOR : str, SemanticsModifierKt.semantics$default(weight$default, false, (Function1) rememberedValue2, 1, null), m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, (i21 >> 21) & 896, 1572864, 65528);
                                startRestartGroup.startReplaceGroup(1643306458);
                                if (function24 != null) {
                                    SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                                    function24.invoke(startRestartGroup, Integer.valueOf((i23 >> 6) & 14));
                                }
                                startRestartGroup.endReplaceGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z11 = z16;
                                function25 = function23;
                                function26 = function24;
                                str6 = str4;
                                z12 = z14;
                                z13 = z15;
                                j9 = m3281getWhite0d7_KjU;
                                j10 = j11;
                                modifier2 = modifier4;
                            }
                            m117BorderStrokecXLIe8U = m117BorderStrokecXLIe8U2;
                            j8 = m3267getGrey40d7_KjU;
                            i19 = 1;
                            Modifier.Companion companion32 = Modifier.INSTANCE;
                            boolean z162 = z8;
                            long j112 = j8;
                            Modifier m104backgroundbw27NRU$default22 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.border(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m327heightInVpY3zN4$default(companion32, Dp.m2599constructorimpl(44), 0.0f, 2, null), 0.0f, i19, null), ThemeShapesKt.getThemeShapes().getMedium()), m117BorderStrokecXLIe8U, ThemeShapesKt.getThemeShapes().getMedium()), !z14 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
                            startRestartGroup.startReplaceGroup(-773806303);
                            if ((458752 & i21) != 131072) {
                            }
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z9) {
                            }
                            rememberedValue = new Function0() { // from class: c2.y
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                                    TextBox_NpQZenA$lambda$6$lambda$2$lambda$1 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$2$lambda$1(Function0.this);
                                    return TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            startRestartGroup.endReplaceGroup();
                            float f52 = 16;
                            Modifier m312paddingVpY3zN42 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default22, z14, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(8));
                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), startRestartGroup, 48);
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN42);
                            Function0<ComposeUiNode> constructor22 = companion2.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion2.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion2.getSetCompositeKeyHash();
                            if (!m1226constructorimpl2.getInserting()) {
                            }
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion2.getSetModifier());
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            startRestartGroup.startReplaceGroup(1643290520);
                            if (function23 != null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            Modifier weight$default2 = RowScope.weight$default(rowScopeInstance2, companion32, 1.0f, false, 2, null);
                            startRestartGroup.startReplaceGroup(1643298526);
                            z10 = ((i21 & 7168) != 2048) | ((i21 & 112) != 32);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (z10) {
                            }
                            str5 = str7;
                            rememberedValue2 = new Function1() { // from class: c2.z
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    Unit TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                                    TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3(str5, str, (SemanticsPropertyReceiver) obj);
                                    return TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            startRestartGroup.endReplaceGroup();
                            TextKt.m940Text4IGK_g(str != null ? BuildConfig.FLAVOR : str, SemanticsModifierKt.semantics$default(weight$default2, false, (Function1) rememberedValue2, 1, null), m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, (i21 >> 21) & 896, 1572864, 65528);
                            startRestartGroup.startReplaceGroup(1643306458);
                            if (function24 != null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.endNode();
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z11 = z162;
                            function25 = function23;
                            function26 = function24;
                            str6 = str4;
                            z12 = z14;
                            z13 = z15;
                            j9 = m3281getWhite0d7_KjU;
                            j10 = j112;
                            modifier2 = modifier4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final String str8 = str5;
                            final long j12 = m3264getGrey10d7_KjU;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function25;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function26;
                            endRestartGroup.updateScope(new Function2() { // from class: c2.A
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit TextBox_NpQZenA$lambda$7;
                                    TextBox_NpQZenA$lambda$7 = TextBoxKt.TextBox_NpQZenA$lambda$7(Modifier.this, str, str6, str8, z12, onClick, z13, z11, j9, j12, j10, function27, function28, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    return TextBox_NpQZenA$lambda$7;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i21 & 306783379) != 306783378) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
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
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier m104backgroundbw27NRU$default3 = BackgroundKt.m104backgroundbw27NRU$default(modifier3, m3281getWhite0d7_KjU, null, 2, null);
                    Arrangement arrangement2 = Arrangement.INSTANCE;
                    Arrangement.Vertical top2 = arrangement2.getTop();
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    Modifier modifier42 = modifier3;
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion4.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default3);
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor3 = companion22.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion22.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3, companion22.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion22.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier3, companion22.getSetModifier());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(-773831338);
                    if (str4 != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    if (z8) {
                    }
                    m117BorderStrokecXLIe8U = m117BorderStrokecXLIe8U2;
                    j8 = m3267getGrey40d7_KjU;
                    i19 = 1;
                    Modifier.Companion companion322 = Modifier.INSTANCE;
                    boolean z1622 = z8;
                    long j1122 = j8;
                    Modifier m104backgroundbw27NRU$default222 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.border(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m327heightInVpY3zN4$default(companion322, Dp.m2599constructorimpl(44), 0.0f, 2, null), 0.0f, i19, null), ThemeShapesKt.getThemeShapes().getMedium()), m117BorderStrokecXLIe8U, ThemeShapesKt.getThemeShapes().getMedium()), !z14 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
                    startRestartGroup.startReplaceGroup(-773806303);
                    if ((458752 & i21) != 131072) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z9) {
                    }
                    rememberedValue = new Function0() { // from class: c2.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                            TextBox_NpQZenA$lambda$6$lambda$2$lambda$1 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$2$lambda$1(Function0.this);
                            return TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceGroup();
                    float f522 = 16;
                    Modifier m312paddingVpY3zN422 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default222, z14, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f522), Dp.m2599constructorimpl(8));
                    MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion4.getCenterVertically(), startRestartGroup, 48);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN422);
                    Function0<ComposeUiNode> constructor222 = companion22.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22, companion22.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion22.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion22.getSetCompositeKeyHash();
                    if (!m1226constructorimpl2.getInserting()) {
                    }
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion22.getSetModifier());
                    RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceGroup(1643290520);
                    if (function23 != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier weight$default22 = RowScope.weight$default(rowScopeInstance22, companion322, 1.0f, false, 2, null);
                    startRestartGroup.startReplaceGroup(1643298526);
                    z10 = ((i21 & 7168) != 2048) | ((i21 & 112) != 32);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (z10) {
                    }
                    str5 = str7;
                    rememberedValue2 = new Function1() { // from class: c2.z
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                            TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3(str5, str, (SemanticsPropertyReceiver) obj);
                            return TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceGroup();
                    TextKt.m940Text4IGK_g(str != null ? BuildConfig.FLAVOR : str, SemanticsModifierKt.semantics$default(weight$default22, false, (Function1) rememberedValue2, 1, null), m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, (i21 >> 21) & 896, 1572864, 65528);
                    startRestartGroup.startReplaceGroup(1643306458);
                    if (function24 != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z11 = z1622;
                    function25 = function23;
                    function26 = function24;
                    str6 = str4;
                    z12 = z14;
                    z13 = z15;
                    j9 = m3281getWhite0d7_KjU;
                    j10 = j1122;
                    modifier2 = modifier42;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i7 & 32) == 0) {
                }
                i11 = i7 & 64;
                if (i11 == 0) {
                }
                i12 = i7 & 128;
                if (i12 == 0) {
                }
                i13 = i7 & 256;
                if (i13 == 0) {
                }
                i14 = i7 & 512;
                if (i14 == 0) {
                }
                i15 = 1024 & i7;
                if (i15 == 0) {
                }
                i17 = i7 & 2048;
                if (i17 == 0) {
                }
                int i232 = i16;
                i18 = i7 & 4096;
                if (i18 == 0) {
                }
                if ((i21 & 306783379) != 306783378) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
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
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier m104backgroundbw27NRU$default32 = BackgroundKt.m104backgroundbw27NRU$default(modifier3, m3281getWhite0d7_KjU, null, 2, null);
                Arrangement arrangement22 = Arrangement.INSTANCE;
                Arrangement.Vertical top22 = arrangement22.getTop();
                Alignment.Companion companion42 = Alignment.INSTANCE;
                Modifier modifier422 = modifier3;
                MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(top22, companion42.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default32);
                ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor32 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap32, companion222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash32);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier32, companion222.getSetModifier());
                ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-773831338);
                if (str4 != null) {
                }
                startRestartGroup.endReplaceGroup();
                if (z8) {
                }
                m117BorderStrokecXLIe8U = m117BorderStrokecXLIe8U2;
                j8 = m3267getGrey40d7_KjU;
                i19 = 1;
                Modifier.Companion companion3222 = Modifier.INSTANCE;
                boolean z16222 = z8;
                long j11222 = j8;
                Modifier m104backgroundbw27NRU$default2222 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.border(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m327heightInVpY3zN4$default(companion3222, Dp.m2599constructorimpl(44), 0.0f, 2, null), 0.0f, i19, null), ThemeShapesKt.getThemeShapes().getMedium()), m117BorderStrokecXLIe8U, ThemeShapesKt.getThemeShapes().getMedium()), !z14 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
                startRestartGroup.startReplaceGroup(-773806303);
                if ((458752 & i21) != 131072) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z9) {
                }
                rememberedValue = new Function0() { // from class: c2.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                        TextBox_NpQZenA$lambda$6$lambda$2$lambda$1 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$2$lambda$1(Function0.this);
                        return TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                float f5222 = 16;
                Modifier m312paddingVpY3zN4222 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default2222, z14, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f5222), Dp.m2599constructorimpl(8));
                MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(arrangement22.getStart(), companion42.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4222);
                Function0<ComposeUiNode> constructor2222 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy222, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222, companion222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting()) {
                }
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222, companion222.getSetModifier());
                RowScopeInstance rowScopeInstance222 = RowScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(1643290520);
                if (function23 != null) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier weight$default222 = RowScope.weight$default(rowScopeInstance222, companion3222, 1.0f, false, 2, null);
                startRestartGroup.startReplaceGroup(1643298526);
                z10 = ((i21 & 7168) != 2048) | ((i21 & 112) != 32);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (z10) {
                }
                str5 = str7;
                rememberedValue2 = new Function1() { // from class: c2.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                        TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3(str5, str, (SemanticsPropertyReceiver) obj);
                        return TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceGroup();
                TextKt.m940Text4IGK_g(str != null ? BuildConfig.FLAVOR : str, SemanticsModifierKt.semantics$default(weight$default222, false, (Function1) rememberedValue2, 1, null), m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, (i21 >> 21) & 896, 1572864, 65528);
                startRestartGroup.startReplaceGroup(1643306458);
                if (function24 != null) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                z11 = z16222;
                function25 = function23;
                function26 = function24;
                str6 = str4;
                z12 = z14;
                z13 = z15;
                j9 = m3281getWhite0d7_KjU;
                j10 = j11222;
                modifier2 = modifier422;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i10 = i7 & 16;
            if (i10 != 0) {
            }
            if ((i7 & 32) == 0) {
            }
            i11 = i7 & 64;
            if (i11 == 0) {
            }
            i12 = i7 & 128;
            if (i12 == 0) {
            }
            i13 = i7 & 256;
            if (i13 == 0) {
            }
            i14 = i7 & 512;
            if (i14 == 0) {
            }
            i15 = 1024 & i7;
            if (i15 == 0) {
            }
            i17 = i7 & 2048;
            if (i17 == 0) {
            }
            int i2322 = i16;
            i18 = i7 & 4096;
            if (i18 == 0) {
            }
            if ((i21 & 306783379) != 306783378) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
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
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier m104backgroundbw27NRU$default322 = BackgroundKt.m104backgroundbw27NRU$default(modifier3, m3281getWhite0d7_KjU, null, 2, null);
            Arrangement arrangement222 = Arrangement.INSTANCE;
            Arrangement.Vertical top222 = arrangement222.getTop();
            Alignment.Companion companion422 = Alignment.INSTANCE;
            Modifier modifier4222 = modifier3;
            MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(top222, companion422.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default322);
            ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor322 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap322, companion2222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash322);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier322, companion2222.getSetModifier());
            ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-773831338);
            if (str4 != null) {
            }
            startRestartGroup.endReplaceGroup();
            if (z8) {
            }
            m117BorderStrokecXLIe8U = m117BorderStrokecXLIe8U2;
            j8 = m3267getGrey40d7_KjU;
            i19 = 1;
            Modifier.Companion companion32222 = Modifier.INSTANCE;
            boolean z162222 = z8;
            long j112222 = j8;
            Modifier m104backgroundbw27NRU$default22222 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.border(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m327heightInVpY3zN4$default(companion32222, Dp.m2599constructorimpl(44), 0.0f, 2, null), 0.0f, i19, null), ThemeShapesKt.getThemeShapes().getMedium()), m117BorderStrokecXLIe8U, ThemeShapesKt.getThemeShapes().getMedium()), !z14 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            startRestartGroup.startReplaceGroup(-773806303);
            if ((458752 & i21) != 131072) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z9) {
            }
            rememberedValue = new Function0() { // from class: c2.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                    TextBox_NpQZenA$lambda$6$lambda$2$lambda$1 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$2$lambda$1(Function0.this);
                    return TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            float f52222 = 16;
            Modifier m312paddingVpY3zN42222 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default22222, z14, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f52222), Dp.m2599constructorimpl(8));
            MeasurePolicy rowMeasurePolicy2222 = RowKt.rowMeasurePolicy(arrangement222.getStart(), companion422.getCenterVertically(), startRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN42222);
            Function0<ComposeUiNode> constructor22222 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22222, companion2222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22222, companion2222.getSetModifier());
            RowScopeInstance rowScopeInstance2222 = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1643290520);
            if (function23 != null) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier weight$default2222 = RowScope.weight$default(rowScopeInstance2222, companion32222, 1.0f, false, 2, null);
            startRestartGroup.startReplaceGroup(1643298526);
            z10 = ((i21 & 7168) != 2048) | ((i21 & 112) != 32);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (z10) {
            }
            str5 = str7;
            rememberedValue2 = new Function1() { // from class: c2.z
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                    TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3(str5, str, (SemanticsPropertyReceiver) obj);
                    return TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g(str != null ? BuildConfig.FLAVOR : str, SemanticsModifierKt.semantics$default(weight$default2222, false, (Function1) rememberedValue2, 1, null), m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, (i21 >> 21) & 896, 1572864, 65528);
            startRestartGroup.startReplaceGroup(1643306458);
            if (function24 != null) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            z11 = z162222;
            function25 = function23;
            function26 = function24;
            str6 = str4;
            z12 = z14;
            z13 = z15;
            j9 = m3281getWhite0d7_KjU;
            j10 = j112222;
            modifier2 = modifier4222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i9 = i7 & 8;
        if (i9 == 0) {
        }
        i10 = i7 & 16;
        if (i10 != 0) {
        }
        if ((i7 & 32) == 0) {
        }
        i11 = i7 & 64;
        if (i11 == 0) {
        }
        i12 = i7 & 128;
        if (i12 == 0) {
        }
        i13 = i7 & 256;
        if (i13 == 0) {
        }
        i14 = i7 & 512;
        if (i14 == 0) {
        }
        i15 = 1024 & i7;
        if (i15 == 0) {
        }
        i17 = i7 & 2048;
        if (i17 == 0) {
        }
        int i23222 = i16;
        i18 = i7 & 4096;
        if (i18 == 0) {
        }
        if ((i21 & 306783379) != 306783378) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
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
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m104backgroundbw27NRU$default3222 = BackgroundKt.m104backgroundbw27NRU$default(modifier3, m3281getWhite0d7_KjU, null, 2, null);
        Arrangement arrangement2222 = Arrangement.INSTANCE;
        Arrangement.Vertical top2222 = arrangement2222.getTop();
        Alignment.Companion companion4222 = Alignment.INSTANCE;
        Modifier modifier42222 = modifier3;
        MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(top2222, companion4222.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default3222);
        ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor3222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap3222, companion22222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash3222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier3222, companion22222.getSetModifier());
        ColumnScopeInstance columnScopeInstance2222 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-773831338);
        if (str4 != null) {
        }
        startRestartGroup.endReplaceGroup();
        if (z8) {
        }
        m117BorderStrokecXLIe8U = m117BorderStrokecXLIe8U2;
        j8 = m3267getGrey40d7_KjU;
        i19 = 1;
        Modifier.Companion companion322222 = Modifier.INSTANCE;
        boolean z1622222 = z8;
        long j1122222 = j8;
        Modifier m104backgroundbw27NRU$default222222 = BackgroundKt.m104backgroundbw27NRU$default(BorderKt.border(ClipKt.clip(SizeKt.fillMaxWidth$default(SizeKt.m327heightInVpY3zN4$default(companion322222, Dp.m2599constructorimpl(44), 0.0f, 2, null), 0.0f, i19, null), ThemeShapesKt.getThemeShapes().getMedium()), m117BorderStrokecXLIe8U, ThemeShapesKt.getThemeShapes().getMedium()), !z14 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
        startRestartGroup.startReplaceGroup(-773806303);
        if ((458752 & i21) != 131072) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z9) {
        }
        rememberedValue = new Function0() { // from class: c2.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
                TextBox_NpQZenA$lambda$6$lambda$2$lambda$1 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$2$lambda$1(Function0.this);
                return TextBox_NpQZenA$lambda$6$lambda$2$lambda$1;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        float f522222 = 16;
        Modifier m312paddingVpY3zN422222 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default222222, z14, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f522222), Dp.m2599constructorimpl(8));
        MeasurePolicy rowMeasurePolicy22222 = RowKt.rowMeasurePolicy(arrangement2222.getStart(), companion4222.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222222 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN422222);
        Function0<ComposeUiNode> constructor222222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222222, companion22222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222222, companion22222.getSetModifier());
        RowScopeInstance rowScopeInstance22222 = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(1643290520);
        if (function23 != null) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier weight$default22222 = RowScope.weight$default(rowScopeInstance22222, companion322222, 1.0f, false, 2, null);
        startRestartGroup.startReplaceGroup(1643298526);
        z10 = ((i21 & 7168) != 2048) | ((i21 & 112) != 32);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (z10) {
        }
        str5 = str7;
        rememberedValue2 = new Function1() { // from class: c2.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
                TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3 = TextBoxKt.TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3(str5, str, (SemanticsPropertyReceiver) obj);
                return TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        TextKt.m940Text4IGK_g(str != null ? BuildConfig.FLAVOR : str, SemanticsModifierKt.semantics$default(weight$default22222, false, (Function1) rememberedValue2, 1, null), m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, (i21 >> 21) & 896, 1572864, 65528);
        startRestartGroup.startReplaceGroup(1643306458);
        if (function24 != null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z11 = z1622222;
        function25 = function23;
        function26 = function24;
        str6 = str4;
        z12 = z14;
        z13 = z15;
        j9 = m3281getWhite0d7_KjU;
        j10 = j1122222;
        modifier2 = modifier42222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextBox_NpQZenA$lambda$6$lambda$2$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextBox_NpQZenA$lambda$6$lambda$5$lambda$4$lambda$3(String str, String str2, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        if (str == null) {
            str = str2 == null ? BuildConfig.FLAVOR : str2;
        }
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextBox_NpQZenA$lambda$7(Modifier modifier, String str, String str2, String str3, boolean z5, Function0 function0, boolean z6, boolean z7, long j5, long j6, long j7, Function2 function2, Function2 function22, int i5, int i6, int i7, Composer composer, int i8) {
        m3414TextBoxNpQZenA(modifier, str, str2, str3, z5, function0, z6, z7, j5, j6, j7, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }
}
