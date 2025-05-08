package dk.molslinjen.ui.views.shared.components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.info.InfoAlert;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.shared.components.InfoDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/info/InfoAlert;", "infoAlert", "Lkotlin/Function0;", BuildConfig.FLAVOR, "dismiss", "InfoDialog", "(Ldk/molslinjen/domain/model/info/InfoAlert;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class InfoDialogKt {
    public static final void InfoDialog(final InfoAlert infoAlert, final Function0<Unit> dismiss, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(infoAlert, "infoAlert");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Composer startRestartGroup = composer.startRestartGroup(1724712645);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(infoAlert) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(dismiss) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1724712645, i6, -1, "dk.molslinjen.ui.views.shared.components.InfoDialog (InfoDialog.kt:28)");
            }
            String nullIfEmpty = StringExtensionsKt.nullIfEmpty(infoAlert.getButtonText());
            startRestartGroup.startReplaceGroup(-1314097949);
            if (nullIfEmpty == null) {
                nullIfEmpty = StringResources_androidKt.stringResource(R.string.infoAlert_defaultButtonTitle, startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            CustomDialogKt.CustomDialog(new SimpleButtonData(nullIfEmpty, false, false, dismiss, 6, null), null, null, dismiss, false, ComposableLambdaKt.rememberComposableLambda(-1063680576, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.components.InfoDialogKt$InfoDialog$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope CustomDialog, Composer composer2, int i7) {
                    Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
                    if ((i7 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1063680576, i7, -1, "dk.molslinjen.ui.views.shared.components.InfoDialog.<anonymous> (InfoDialog.kt:37)");
                    }
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    InfoAlert infoAlert2 = InfoAlert.this;
                    Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, fillMaxWidth$default);
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
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    InfoAlert.IconType iconType = infoAlert2.getIconType();
                    composer2.startReplaceGroup(1744257927);
                    if (iconType != null) {
                        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(iconType == InfoAlert.IconType.Warning ? R.drawable.icon_info_dialog_warning : R.drawable.icon_info_dialog_celebration, composer2, 0), Accessibility.INSTANCE.getSkip(), columnScopeInstance.align(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(41)), companion2.getCenterHorizontally()), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer2, 3072, 0);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer2, 6);
                    }
                    composer2.endReplaceGroup();
                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    String title = infoAlert2.getTitle();
                    TextStyle paragraphBold = TypographyKt.getParagraphBold();
                    TextAlign.Companion companion4 = TextAlign.INSTANCE;
                    TextKt.m940Text4IGK_g(title, fillMaxWidth$default2, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, composer2, 48, 1572864, 65020);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), composer2, 6);
                    TextKt.m940Text4IGK_g(infoAlert2.getDescription(), SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion4.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 48, 1572864, 65020);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 << 6) & 7168) | 221184, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: w4.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoDialog$lambda$0;
                    InfoDialog$lambda$0 = InfoDialogKt.InfoDialog$lambda$0(InfoAlert.this, dismiss, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoDialog$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoDialog$lambda$0(InfoAlert infoAlert, Function0 function0, int i5, Composer composer, int i6) {
        InfoDialog(infoAlert, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
