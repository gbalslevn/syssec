package dk.molslinjen.ui.views.screens.booking.departures.rows;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.view.compose.ActivityResultRegistryKt;
import androidx.view.compose.ManagedActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import com.google.accompanist.permissions.PermissionState;
import com.google.accompanist.permissions.PermissionStateKt;
import com.google.accompanist.permissions.PermissionsUtilKt;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarborOnRoute;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.extensions.PermissionExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationViewKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001aK\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aM\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\u0016H\u0003¢\u0006\u0004\b\u000b\u0010\u0019\u001a+\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a9\u0010\u001e\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003¢\u0006\u0004\b\u001e\u0010\u001f\u001a)\u0010\"\u001a\u00020\u0005*\u00020\u00172\u0006\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0003¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "travelTime", "Lkotlin/Function0;", BuildConfig.FLAVOR, "permissionGranted", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Landroid/content/Context;", "showDirections", "TimeToLocationView", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "publicTransportationTime", "walkingTime", "departingHarborName", "NearestLocationView", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "missingPermissionText", BuildConfig.FLAVOR, "dataReady", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "content", "(Landroidx/compose/ui/Modifier;IZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NearestLocationGuide", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "siteName", "time", "TimeToLocationGuide", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "requestText", "requestPermission", "MissingPermission", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TimeToLocationViewKt {
    private static final void MissingPermission(final RowScope rowScope, String str, Function0<Unit> function0, Composer composer, int i5) {
        int i6;
        Composer composer2;
        final int i7;
        final Function0<Unit> function02;
        final String str2;
        Composer startRestartGroup = composer.startRestartGroup(-2103213716);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i8 = i6;
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            str2 = str;
            composer2 = startRestartGroup;
            i7 = i5;
            function02 = function0;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2103213716, i8, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.MissingPermission (TimeToLocationView.kt:216)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            composer2 = startRestartGroup;
            i7 = i5;
            function02 = function0;
            str2 = str;
            TextKt.m940Text4IGK_g(str, RowScope.weight$default(rowScope, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, (i8 >> 3) & 14, 1572864, 65532);
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            composer2.startReplaceGroup(515699176);
            boolean z5 = (i8 & 896) == 256;
            Object rememberedValue = composer2.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: M2.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MissingPermission$lambda$19$lambda$18;
                        MissingPermission$lambda$19$lambda$18 = TimeToLocationViewKt.MissingPermission$lambda$19$lambda$18(Function0.this);
                        return MissingPermission$lambda$19$lambda$18;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_allowPermissions, composer2, 6), ClickableKt.m122clickableXHw0xAI$default(fillMaxHeight$default, false, null, null, (Function0) rememberedValue, 7, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 0, 1572864, 65020);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M2.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MissingPermission$lambda$20;
                    MissingPermission$lambda$20 = TimeToLocationViewKt.MissingPermission$lambda$20(RowScope.this, str2, function02, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return MissingPermission$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MissingPermission$lambda$19$lambda$18(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MissingPermission$lambda$20(RowScope rowScope, String str, Function0 function0, int i5, Composer composer, int i6) {
        MissingPermission(rowScope, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NearestLocationGuide(final String str, final String str2, final String str3, Composer composer, final int i5) {
        int i6;
        String str4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1971036992);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1971036992, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.NearestLocationGuide (TimeToLocationView.kt:147)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_nearestStop, new Object[]{str}, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(2), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 48, 1572864, 65532);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (str3 != null && str2 != null) {
                startRestartGroup.startReplaceGroup(933395449);
                str4 = StringResources_androidKt.stringResource(R.string.departures_walkingAndPublicTransportationTime, new Object[]{str3, str2}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else if (str3 != null) {
                startRestartGroup.startReplaceGroup(933400968);
                str4 = StringResources_androidKt.stringResource(R.string.departures_walkingTime, new Object[]{str3}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else if (str2 != null) {
                startRestartGroup.startReplaceGroup(933405410);
                str4 = StringResources_androidKt.stringResource(R.string.departures_publicTransportationTime, new Object[]{str2}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1129090986);
                startRestartGroup.endReplaceGroup();
                str4 = null;
            }
            String str5 = str4;
            startRestartGroup.startReplaceGroup(933410339);
            if (str5 == null) {
                composer2 = startRestartGroup;
            } else {
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(str5, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NearestLocationGuide$lambda$14;
                    NearestLocationGuide$lambda$14 = TimeToLocationViewKt.NearestLocationGuide$lambda$14(str, str2, str3, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return NearestLocationGuide$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NearestLocationGuide$lambda$14(String str, String str2, String str3, int i5, Composer composer, int i6) {
        NearestLocationGuide(str, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void NearestLocationView(Modifier modifier, final String str, final String str2, final String str3, final Function0<Unit> permissionGranted, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(permissionGranted, "permissionGranted");
        Composer startRestartGroup = composer.startRestartGroup(-505507250);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(str3) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(permissionGranted) ? 16384 : 8192;
        }
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-505507250, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.NearestLocationView (TimeToLocationView.kt:81)");
            }
            TimeToLocationView(modifier3, R.string.departures_allowLocationPermission_kombardo, (str3 == null || (str == null && str2 == null)) ? false : true, permissionGranted, ComposableLambdaKt.rememberComposableLambda(239028979, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationViewKt$NearestLocationView$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TimeToLocationView, Composer composer2, int i9) {
                    Intrinsics.checkNotNullParameter(TimeToLocationView, "$this$TimeToLocationView");
                    if ((i9 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(239028979, i9, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.NearestLocationView.<anonymous> (TimeToLocationView.kt:88)");
                    }
                    String str4 = str3;
                    if (str4 == null) {
                        str4 = BuildConfig.FLAVOR;
                    }
                    TimeToLocationViewKt.NearestLocationGuide(str4, str, str2, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i7 & 14) | 24624 | ((i7 >> 3) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: M2.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NearestLocationView$lambda$2;
                    NearestLocationView$lambda$2 = TimeToLocationViewKt.NearestLocationView$lambda$2(Modifier.this, str, str2, str3, permissionGranted, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return NearestLocationView$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NearestLocationView$lambda$2(Modifier modifier, String str, String str2, String str3, Function0 function0, int i5, int i6, Composer composer, int i7) {
        NearestLocationView(modifier, str, str2, str3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimeToLocationGuide(final RowScope rowScope, final String str, final String str2, final String str3, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        String stringResource;
        Composer startRestartGroup = composer.startRestartGroup(-364778058);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(str3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-364778058, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationGuide (TimeToLocationView.kt:180)");
            }
            if (Feature.OnlyWalkingPassengers.isEnabled()) {
                startRestartGroup.startReplaceGroup(-816634748);
                stringResource = StringResources_androidKt.stringResource(R.string.departures_walkNowInfo, new Object[]{str2, str3}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-816534215);
                stringResource = StringResources_androidKt.stringResource(R.string.departures_driveNowInfo, new Object[]{str, str2, str3}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            String str4 = stringResource;
            List listOf = CollectionsKt.listOf(new AnnotatedString.Range(new SpanStyle(0L, 0L, TypographyKt.getSubBold().getFontWeight(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65531, null), StringsKt.indexOf$default((CharSequence) str4, str3, 0, false, 6, (Object) null) - 4, str4.length()));
            Modifier.Companion companion = Modifier.INSTANCE;
            TextKt.m941TextIbK3jfQ(new AnnotatedString(str4, listOf, null, 4, null), RowScope.weight$default(rowScope, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getSub(), startRestartGroup, 0, 12582912, 131068);
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(-1688887121);
            boolean z5 = (57344 & i6) == 16384;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: M2.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TimeToLocationGuide$lambda$16$lambda$15;
                        TimeToLocationGuide$lambda$16$lambda$15 = TimeToLocationViewKt.TimeToLocationGuide$lambda$16$lambda$15(Function0.this);
                        return TimeToLocationGuide$lambda$16$lambda$15;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_getDirections, startRestartGroup, 6), ClickableKt.m122clickableXHw0xAI$default(fillMaxHeight$default, false, null, null, (Function0) rememberedValue, 7, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65020);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M2.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeToLocationGuide$lambda$17;
                    TimeToLocationGuide$lambda$17 = TimeToLocationViewKt.TimeToLocationGuide$lambda$17(RowScope.this, str, str2, str3, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeToLocationGuide$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeToLocationGuide$lambda$16$lambda$15(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeToLocationGuide$lambda$17(RowScope rowScope, String str, String str2, String str3, Function0 function0, int i5, Composer composer, int i6) {
        TimeToLocationGuide(rowScope, str, str2, str3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TimeToLocationView(Modifier modifier, final TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute, final Function0<Unit> permissionGranted, final Function2<? super String, ? super Context, Unit> showDirections, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(permissionGranted, "permissionGranted");
        Intrinsics.checkNotNullParameter(showDirections, "showDirections");
        Composer startRestartGroup = composer.startRestartGroup(1578567849);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(travelTimeToNearestHarborOnRoute) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(permissionGranted) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(showDirections) ? 2048 : 1024;
        }
        int i9 = i7;
        if ((i9 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1578567849, i9, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationView (TimeToLocationView.kt:48)");
            }
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            String siteName = travelTimeToNearestHarborOnRoute != null ? travelTimeToNearestHarborOnRoute.getSiteName() : null;
            String harborName = travelTimeToNearestHarborOnRoute != null ? travelTimeToNearestHarborOnRoute.getHarborName() : null;
            String directionsDestination = travelTimeToNearestHarborOnRoute != null ? travelTimeToNearestHarborOnRoute.getDirectionsDestination() : null;
            LocalTime plusHours = travelTimeToNearestHarborOnRoute != null ? LocalTime.now().plusMinutes(travelTimeToNearestHarborOnRoute.getTravelTimeMinutes()).plusHours(travelTimeToNearestHarborOnRoute.getTravelTimeHours()) : null;
            TimeToLocationView(modifier3, R.string.departures_allowLocationPermission_molslinjen, (siteName == null || plusHours == null) ? false : true, permissionGranted, ComposableLambdaKt.rememberComposableLambda(-2146789084, true, new TimeToLocationViewKt$TimeToLocationView$1(siteName, harborName, plusHours, showDirections, directionsDestination, context), startRestartGroup, 54), startRestartGroup, (i9 & 14) | 24624 | ((i9 << 3) & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: M2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeToLocationView$lambda$1;
                    TimeToLocationView$lambda$1 = TimeToLocationViewKt.TimeToLocationView$lambda$1(Modifier.this, travelTimeToNearestHarborOnRoute, permissionGranted, showDirections, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeToLocationView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeToLocationView$lambda$1(Modifier modifier, TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute, Function0 function0, Function2 function2, int i5, int i6, Composer composer, int i7) {
        TimeToLocationView(modifier, travelTimeToNearestHarborOnRoute, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeToLocationView$lambda$10(Modifier modifier, int i5, boolean z5, Function0 function0, Function3 function3, int i6, int i7, Composer composer, int i8) {
        TimeToLocationView(modifier, i5, z5, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState TimeToLocationView$lambda$4$lambda$3() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeToLocationView$lambda$6$lambda$5(String str, Function0 function0, MutableState mutableState, Context context, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it.get(str), Boolean.TRUE)) {
            function0.invoke();
        } else {
            LocalTime localTime = (LocalTime) mutableState.getValue();
            if (localTime != null && localTime.isAfter(Constants.Permissions.INSTANCE.getMaxResponseCheckupTimePermanentlyDeclined())) {
                PermissionExtensionsKt.openAppSettings(context);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeToLocationView$lambda$9$lambda$8$lambda$7(MutableState mutableState, ManagedActivityResultLauncher managedActivityResultLauncher, String str) {
        mutableState.setValue(LocalTime.now());
        managedActivityResultLauncher.launch(new String[]{str});
        return Unit.INSTANCE;
    }

    private static final void TimeToLocationView(Modifier modifier, final int i5, final boolean z5, final Function0<Unit> function0, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(-1512693208);
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
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i7 & 16) != 0) {
            i8 |= 24576;
        } else if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        int i10 = i8;
        if ((i10 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            Modifier modifier4 = i9 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1512693208, i10, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.TimeToLocationView (TimeToLocationView.kt:103)");
            }
            final String str = "android.permission.ACCESS_FINE_LOCATION";
            PermissionState rememberPermissionState = PermissionStateKt.rememberPermissionState("android.permission.ACCESS_FINE_LOCATION", null, startRestartGroup, 6, 2);
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(-467389338);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: M2.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState TimeToLocationView$lambda$4$lambda$3;
                        TimeToLocationView$lambda$4$lambda$3 = TimeToLocationViewKt.TimeToLocationView$lambda$4$lambda$3();
                        return TimeToLocationView$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier5 = modifier4;
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ActivityResultContracts$RequestMultiplePermissions activityResultContracts$RequestMultiplePermissions = new ActivityResultContracts$RequestMultiplePermissions();
            startRestartGroup.startReplaceGroup(-467383247);
            boolean changed = ((i10 & 7168) == 2048) | startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(context);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: M2.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TimeToLocationView$lambda$6$lambda$5;
                        TimeToLocationView$lambda$6$lambda$5 = TimeToLocationViewKt.TimeToLocationView$lambda$6$lambda$5(str, function0, mutableState, context, (Map) obj);
                        return TimeToLocationView$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(activityResultContracts$RequestMultiplePermissions, (Function1) rememberedValue2, startRestartGroup, 0);
            if (!PermissionsUtilKt.isGranted(rememberPermissionState.getStatus()) || z5) {
                float f5 = 16;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
                Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                modifier3 = modifier5;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_directions, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null), Dp.m2599constructorimpl(f5)), null, null, 0.0f, null, startRestartGroup, 384, 120);
                if (!PermissionsUtilKt.isGranted(rememberPermissionState.getStatus())) {
                    startRestartGroup.startReplaceGroup(-1988822036);
                    String stringResource = StringResources_androidKt.stringResource(i5, startRestartGroup, (i10 >> 3) & 14);
                    startRestartGroup.startReplaceGroup(-1988818241);
                    boolean changed2 = startRestartGroup.changed(mutableState) | startRestartGroup.changedInstance(rememberLauncherForActivityResult);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new Function0() { // from class: M2.i
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit TimeToLocationView$lambda$9$lambda$8$lambda$7;
                                TimeToLocationView$lambda$9$lambda$8$lambda$7 = TimeToLocationViewKt.TimeToLocationView$lambda$9$lambda$8$lambda$7(MutableState.this, rememberLauncherForActivityResult, str);
                                return TimeToLocationView$lambda$9$lambda$8$lambda$7;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    MissingPermission(rowScopeInstance, stringResource, (Function0) rememberedValue3, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1988811958);
                    function3.invoke(rowScopeInstance, startRestartGroup, Integer.valueOf(6 | ((i10 >> 9) & 112)));
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endNode();
            } else {
                modifier3 = modifier5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: M2.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimeToLocationView$lambda$10;
                    TimeToLocationView$lambda$10 = TimeToLocationViewKt.TimeToLocationView$lambda$10(Modifier.this, i5, z5, function0, function3, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return TimeToLocationView$lambda$10;
                }
            });
        }
    }
}
