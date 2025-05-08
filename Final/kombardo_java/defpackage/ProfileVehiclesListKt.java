package defpackage;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.extensions.DoubleExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.CircledBorderIconKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.swipe.SwipeToDeleteKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ay\u0010\f\u001a\u00020\u0006*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\f\u0010\r\u001aU\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicles", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "navigateToEdit", "triggerDeleteFlow", "onSelection", "Lkotlin/Function0;", "onDisabledClick", "profileVehiclesList", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "vehicle", "ProfileVehicleRow", "(Ldk/molslinjen/domain/model/account/UserVehicle;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ProfileVehiclesListKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0498  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProfileVehicleRow(final UserVehicle userVehicle, final Function1<? super String, Unit> function1, final Function1<? super UserVehicle, Unit> function12, Function0<Unit> function0, Composer composer, final int i5, final int i6) {
        int i7;
        Function0<Unit> function02;
        final Function0<Unit> function03;
        boolean changedInstance;
        Object rememberedValue;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Function0<Unit> function04;
        Composer composer2;
        Object rememberedValue2;
        Composer.Companion companion;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        Object rememberedValue3;
        String formattedModelName;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        TextStyle m2295copyp1EtxEg;
        Object rememberedValue4;
        int currentCompositeKeyHash4;
        Composer m1226constructorimpl4;
        Double heightInMeters;
        Double lengthInMeters;
        final UserVehicle userVehicle2;
        boolean z5;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(280247478);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(userVehicle) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        int i8 = i6 & 8;
        if (i8 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
            if ((i7 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                function03 = i8 == 0 ? null : function02;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(280247478, i7, -1, "ProfileVehicleRow (ProfileVehiclesList.kt:83)");
                }
                Modifier.Companion companion2 = Modifier.INSTANCE;
                AppColor appColor = AppColor.INSTANCE;
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(companion2, appColor.m3281getWhite0d7_KjU(), null, 2, null);
                boolean z6 = function12 == null || function03 != null;
                startRestartGroup.startReplaceGroup(1985206600);
                changedInstance = ((i7 & 896) != 256) | startRestartGroup.changedInstance(userVehicle) | ((i7 & 7168) != 2048);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Modifier ProfileVehicleRow$lambda$6$lambda$5;
                            ProfileVehicleRow$lambda$6$lambda$5 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$6$lambda$5(Function1.this, function03, userVehicle, (Modifier) obj);
                            return ProfileVehicleRow$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                float f5 = 24;
                float f6 = 16;
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ModifierExtensionsKt.applyIf(m104backgroundbw27NRU$default, z6, (Function1) rememberedValue), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion3.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i9 = i7;
                function04 = function03;
                composer2 = startRestartGroup;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_car, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 11, null), Dp.m2599constructorimpl(f5)), appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
                composer2.startReplaceGroup(-1756585647);
                rememberedValue2 = composer2.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ProfileVehicleRow$lambda$24$lambda$8$lambda$7;
                            ProfileVehicleRow$lambda$24$lambda$8$lambda$7 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$24$lambda$8$lambda$7((SemanticsPropertyReceiver) obj);
                            return ProfileVehicleRow$lambda$24$lambda$8$lambda$7;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue2, 1, null), 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(4)), companion3.getStart(), composer2, 6);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.useNode();
                } else {
                    composer2.createNode(constructor2);
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2.startReplaceGroup(249749326);
                rememberedValue3 = composer2.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ProfileVehicleRow$lambda$24$lambda$20$lambda$10$lambda$9;
                            ProfileVehicleRow$lambda$24$lambda$20$lambda$10$lambda$9 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$24$lambda$20$lambda$10$lambda$9((SemanticsPropertyReceiver) obj);
                            return ProfileVehicleRow$lambda$24$lambda$20$lambda$10$lambda$9;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                TextKt.m940Text4IGK_g(userVehicle.getDisplayName(), SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue3, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65532);
                formattedModelName = userVehicle.getFormattedModelName();
                composer2.startReplaceGroup(249754632);
                if (formattedModelName != null) {
                    composer2.startReplaceGroup(-892561555);
                    Object rememberedValue5 = composer2.rememberedValue();
                    if (rememberedValue5 == companion.getEmpty()) {
                        rememberedValue5 = new Function1() { // from class: e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit ProfileVehicleRow$lambda$24$lambda$20$lambda$13$lambda$12$lambda$11;
                                ProfileVehicleRow$lambda$24$lambda$20$lambda$13$lambda$12$lambda$11 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$24$lambda$20$lambda$13$lambda$12$lambda$11((SemanticsPropertyReceiver) obj);
                                return ProfileVehicleRow$lambda$24$lambda$20$lambda$13$lambda$12$lambda$11;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5);
                    }
                    composer2.endReplaceGroup();
                    TextKt.m940Text4IGK_g(formattedModelName, SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue5, 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), composer2, 0);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.useNode();
                } else {
                    composer2.createNode(constructor3);
                }
                m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                m2295copyp1EtxEg = r39.m2295copyp1EtxEg((r48 & 1) != 0 ? r39.spanStyle.m2255getColor0d7_KjU() : appColor.m3264getGrey10d7_KjU(), (r48 & 2) != 0 ? r39.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r39.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r39.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r39.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r39.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r39.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r39.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r39.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r39.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r39.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r39.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r39.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r39.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r39.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r39.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r39.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r39.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r39.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r39.platformStyle : null, (r48 & 1048576) != 0 ? r39.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r39.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r39.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
                composer2.startReplaceGroup(-892548020);
                rememberedValue4 = composer2.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit ProfileVehicleRow$lambda$24$lambda$20$lambda$19$lambda$15$lambda$14;
                            ProfileVehicleRow$lambda$24$lambda$20$lambda$19$lambda$15$lambda$14 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$24$lambda$20$lambda$19$lambda$15$lambda$14((SemanticsPropertyReceiver) obj);
                            return ProfileVehicleRow$lambda$24$lambda$20$lambda$19$lambda$15$lambda$14;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceGroup();
                TextKt.m940Text4IGK_g(userVehicle.getLicensePlate(), RowScope.weight$default(rowScopeInstance, SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue4, 1, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 0, 0, 65532);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(8)), composer2, 6);
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 2.0f, false, 2, null);
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), composer2, 0);
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, weight$default);
                Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.useNode();
                } else {
                    composer2.createNode(constructor4);
                }
                m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy3, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
                heightInMeters = userVehicle.getHeightInMeters();
                composer2.startReplaceGroup(371184026);
                if (heightInMeters != null) {
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_vehicles_row_vehicleHeight, new Object[]{DoubleExtensionsKt.format(heightInMeters.doubleValue(), 2)}, composer2, 6), RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 0, 0, 65020);
                    Unit unit2 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                lengthInMeters = userVehicle.getLengthInMeters();
                composer2.startReplaceGroup(371196954);
                if (lengthInMeters != null) {
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_vehicles_row_vehicleLength, new Object[]{DoubleExtensionsKt.format(lengthInMeters.doubleValue(), 2)}, composer2, 6), RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 0, 0, 65020);
                    Unit unit3 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
                composer2.endNode();
                composer2.startReplaceGroup(-1756518120);
                if (function1 == null) {
                    composer2.startReplaceGroup(249812755);
                    if ((i9 & 112) == 32) {
                        z5 = true;
                        userVehicle2 = userVehicle;
                    } else {
                        userVehicle2 = userVehicle;
                        z5 = false;
                    }
                    boolean changedInstance2 = composer2.changedInstance(userVehicle2) | z5;
                    Object rememberedValue6 = composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue6 == companion.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProfileVehicleRow$lambda$24$lambda$23$lambda$22$lambda$21;
                                ProfileVehicleRow$lambda$24$lambda$23$lambda$22$lambda$21 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$24$lambda$23$lambda$22$lambda$21(Function1.this, userVehicle2);
                                return ProfileVehicleRow$lambda$24$lambda$23$lambda$22$lambda$21;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue6);
                    }
                    composer2.endReplaceGroup();
                    CircledBorderIconKt.m3385CircledBorderIconkaRa2wg(null, R.drawable.icon_edit, (Function0) rememberedValue6, 0.0f, 0.0f, 0L, 0L, 0L, null, composer2, 48, 505);
                    Unit unit4 = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                function04 = function02;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Function0<Unit> function05 = function04;
                endRestartGroup.updateScope(new Function2() { // from class: h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ProfileVehicleRow$lambda$25;
                        ProfileVehicleRow$lambda$25 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$25(UserVehicle.this, function1, function12, function05, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return ProfileVehicleRow$lambda$25;
                    }
                });
                return;
            }
            return;
        }
        function02 = function0;
        if ((i7 & 1171) == 1170) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion22 = Modifier.INSTANCE;
        AppColor appColor2 = AppColor.INSTANCE;
        Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(companion22, appColor2.m3281getWhite0d7_KjU(), null, 2, null);
        if (function12 == null) {
        }
        startRestartGroup.startReplaceGroup(1985206600);
        changedInstance = ((i7 & 896) != 256) | startRestartGroup.changedInstance(userVehicle) | ((i7 & 7168) != 2048);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function1() { // from class: b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Modifier ProfileVehicleRow$lambda$6$lambda$5;
                ProfileVehicleRow$lambda$6$lambda$5 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$6$lambda$5(Function1.this, function03, userVehicle, (Modifier) obj);
                return ProfileVehicleRow$lambda$6$lambda$5;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        float f52 = 24;
        float f62 = 16;
        Modifier m312paddingVpY3zN42 = PaddingKt.m312paddingVpY3zN4(ModifierExtensionsKt.applyIf(m104backgroundbw27NRU$default2, z6, (Function1) rememberedValue), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(f62));
        Alignment.Companion companion32 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically2 = companion32.getCenterVertically();
        Arrangement arrangement2 = Arrangement.INSTANCE;
        MeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically2, startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN42);
        ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor5 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy4, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap5, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier5, companion42.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        int i92 = i7;
        function04 = function03;
        composer2 = startRestartGroup;
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_car, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, 0.0f, Dp.m2599constructorimpl(f62), 0.0f, 11, null), Dp.m2599constructorimpl(f52)), appColor2.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
        composer2.startReplaceGroup(-1756585647);
        rememberedValue2 = composer2.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
        }
        composer2.endReplaceGroup();
        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance2, SemanticsModifierKt.semantics$default(companion22, false, (Function1) rememberedValue2, 1, null), 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 11, null);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.m265spacedBy0680j_4(Dp.m2599constructorimpl(4)), companion32.getStart(), composer2, 6);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default2);
        Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
        if (composer2.getApplier() == null) {
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        composer2.startReplaceGroup(249749326);
        rememberedValue3 = composer2.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        composer2.endReplaceGroup();
        TextKt.m940Text4IGK_g(userVehicle.getDisplayName(), SemanticsModifierKt.semantics$default(companion22, false, (Function1) rememberedValue3, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65532);
        formattedModelName = userVehicle.getFormattedModelName();
        composer2.startReplaceGroup(249754632);
        if (formattedModelName != null) {
        }
        composer2.endReplaceGroup();
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion22, 0.0f, 1, null);
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion32.getTop(), composer2, 0);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap32 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default2);
        Function0<ComposeUiNode> constructor32 = companion42.getConstructor();
        if (composer2.getApplier() == null) {
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
        Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy22, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion42.getSetModifier());
        m2295copyp1EtxEg = r39.m2295copyp1EtxEg((r48 & 1) != 0 ? r39.spanStyle.m2255getColor0d7_KjU() : appColor2.m3264getGrey10d7_KjU(), (r48 & 2) != 0 ? r39.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r39.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r39.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r39.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r39.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r39.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r39.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r39.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r39.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r39.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r39.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r39.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r39.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r39.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r39.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r39.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r39.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r39.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r39.platformStyle : null, (r48 & 1048576) != 0 ? r39.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r39.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r39.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
        composer2.startReplaceGroup(-892548020);
        rememberedValue4 = composer2.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        composer2.endReplaceGroup();
        TextKt.m940Text4IGK_g(userVehicle.getLicensePlate(), RowScope.weight$default(rowScopeInstance2, SemanticsModifierKt.semantics$default(companion22, false, (Function1) rememberedValue4, 1, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 0, 0, 65532);
        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion22, Dp.m2599constructorimpl(8)), composer2, 6);
        Modifier weight$default2 = RowScope.weight$default(rowScopeInstance2, companion22, 2.0f, false, 2, null);
        MeasurePolicy rowMeasurePolicy32 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion32.getTop(), composer2, 0);
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap42 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(composer2, weight$default2);
        Function0<ComposeUiNode> constructor42 = companion42.getConstructor();
        if (composer2.getApplier() == null) {
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
        }
        m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
        Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy32, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap42, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl4.getInserting()) {
        }
        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier42, companion42.getSetModifier());
        heightInMeters = userVehicle.getHeightInMeters();
        composer2.startReplaceGroup(371184026);
        if (heightInMeters != null) {
        }
        composer2.endReplaceGroup();
        lengthInMeters = userVehicle.getLengthInMeters();
        composer2.startReplaceGroup(371196954);
        if (lengthInMeters != null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        composer2.endNode();
        composer2.endNode();
        composer2.startReplaceGroup(-1756518120);
        if (function1 == null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$24$lambda$20$lambda$10$lambda$9(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -30.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$24$lambda$20$lambda$13$lambda$12$lambda$11(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$24$lambda$20$lambda$19$lambda$15$lambda$14(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$24$lambda$23$lambda$22$lambda$21(Function1 function1, UserVehicle userVehicle) {
        function1.invoke(userVehicle.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$24$lambda$8$lambda$7(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$25(UserVehicle userVehicle, Function1 function1, Function1 function12, Function0 function0, int i5, int i6, Composer composer, int i7) {
        ProfileVehicleRow(userVehicle, function1, function12, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier ProfileVehicleRow$lambda$6$lambda$5(final Function1 function1, final Function0 function0, final UserVehicle userVehicle, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return function1 != null ? ClickableKt.m122clickableXHw0xAI$default(applyIf, false, null, null, new Function0() { // from class: i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ProfileVehicleRow$lambda$6$lambda$5$lambda$3;
                ProfileVehicleRow$lambda$6$lambda$5$lambda$3 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$6$lambda$5$lambda$3(Function1.this, userVehicle);
                return ProfileVehicleRow$lambda$6$lambda$5$lambda$3;
            }
        }, 7, null) : function0 != null ? ClickableKt.m122clickableXHw0xAI$default(applyIf, false, null, null, new Function0() { // from class: j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit ProfileVehicleRow$lambda$6$lambda$5$lambda$4;
                ProfileVehicleRow$lambda$6$lambda$5$lambda$4 = ProfileVehiclesListKt.ProfileVehicleRow$lambda$6$lambda$5$lambda$4(Function0.this);
                return ProfileVehicleRow$lambda$6$lambda$5$lambda$4;
            }
        }, 7, null) : Modifier.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$6$lambda$5$lambda$3(Function1 function1, UserVehicle userVehicle) {
        function1.invoke(userVehicle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleRow$lambda$6$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void profileVehiclesList(LazyListScope lazyListScope, final List<UserVehicle> vehicles, final Function1<? super String, Unit> function1, final Function1<? super UserVehicle, Unit> function12, final Function1<? super UserVehicle, Unit> function13, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(vehicles, "vehicles");
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$ProfileVehiclesListKt.INSTANCE.m2getLambda1$app_kombardoProd(), 3, null);
        final Function1 function14 = new Function1() { // from class: k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object profileVehiclesList$lambda$0;
                profileVehiclesList$lambda$0 = ProfileVehiclesListKt.profileVehiclesList$lambda$0((UserVehicle) obj);
                return profileVehiclesList$lambda$0;
            }
        };
        final T t5 = new Function1() { // from class: ProfileVehiclesListKt$profileVehiclesList$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(UserVehicle userVehicle) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((UserVehicle) obj);
            }
        };
        lazyListScope.items(vehicles.size(), new Function1<Integer, Object>() { // from class: ProfileVehiclesListKt$profileVehiclesList$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(vehicles.get(i5));
            }
        }, new Function1<Integer, Object>() { // from class: ProfileVehiclesListKt$profileVehiclesList$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(vehicles.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: ProfileVehiclesListKt$profileVehiclesList$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                final UserVehicle userVehicle = (UserVehicle) vehicles.get(i5);
                composer.startReplaceGroup(-591994569);
                if (function12 != null) {
                    composer.startReplaceGroup(-591973056);
                    composer.startReplaceGroup(-988925781);
                    boolean changed = composer.changed(function12) | composer.changedInstance(userVehicle);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final Function1 function15 = function12;
                        rememberedValue = new Function0<Unit>() { // from class: ProfileVehiclesListKt$profileVehiclesList$2$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function15.invoke(userVehicle);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    final Function1 function16 = function1;
                    final Function1 function17 = function13;
                    final Function0 function02 = function0;
                    SwipeToDeleteKt.SwipeToDelete((Function0) rememberedValue, false, ComposableLambdaKt.rememberComposableLambda(-1229881423, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: ProfileVehiclesListKt$profileVehiclesList$2$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope SwipeToDelete, Composer composer2, int i8) {
                            Intrinsics.checkNotNullParameter(SwipeToDelete, "$this$SwipeToDelete");
                            if ((i8 & 17) == 16 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1229881423, i8, -1, "profileVehiclesList.<anonymous>.<anonymous> (ProfileVehiclesList.kt:58)");
                            }
                            ProfileVehiclesListKt.ProfileVehicleRow(UserVehicle.this, function16, function17, function02, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer, 54), composer, 384, 2);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-591601428);
                    ProfileVehiclesListKt.ProfileVehicleRow(userVehicle, function1, function13, function0, composer, 0, 0);
                    composer.endReplaceGroup();
                }
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object profileVehiclesList$lambda$0(UserVehicle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }
}
