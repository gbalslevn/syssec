package dk.molslinjen.ui.views.screens.booking.ticketType;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.booking.TicketDescriptionItem;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTermsListKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a'\u0010\b\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketDescriptionItem;", "descriptionItems", "Landroidx/compose/ui/graphics/Color;", "highlightColor", BuildConfig.FLAVOR, "TicketTermsList-bMF-p3s", "(Ljava/util/List;Landroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;I)V", "TicketTermsList", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketTermsListKt {
    /* renamed from: TicketTermsList-bMF-p3s, reason: not valid java name */
    public static final void m3473TicketTermsListbMFp3s(final List<TicketDescriptionItem> descriptionItems, final Color color, Composer composer, final int i5) {
        Composer composer2;
        int i6;
        Intrinsics.checkNotNullParameter(descriptionItems, "descriptionItems");
        Composer startRestartGroup = composer.startRestartGroup(1073984843);
        int i7 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(descriptionItems) ? 4 : 2) | i5 : i5;
        int i8 = 16;
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(color) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1073984843, i7, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTermsList (TicketTermsList.kt:24)");
            }
            for (TicketDescriptionItem ticketDescriptionItem : descriptionItems) {
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                float m2599constructorimpl = Dp.m2599constructorimpl(i8);
                if (ticketDescriptionItem.getIconUrl() == null) {
                    startRestartGroup.startReplaceGroup(705081870);
                    SpacerKt.Spacer(SizeKt.m331size3ABfNKs(companion, m2599constructorimpl), startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                    i6 = 8;
                } else {
                    startRestartGroup.startReplaceGroup(705176420);
                    Composer composer3 = startRestartGroup;
                    i6 = 8;
                    IconKt.m857Iconww6aTOc(SingletonAsyncImagePainterKt.m2744rememberAsyncImagePainter19ie5dc(ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(ticketDescriptionItem.getIconUrl(), null, Dp.m2597boximpl(Dp.m2599constructorimpl(8)), startRestartGroup, 3456, 2), null, null, null, 0, composer3, 0, 30), Accessibility.INSTANCE.getSkip(), PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(SizeKt.m331size3ABfNKs(rowScopeInstance.alignByBaseline(companion), m2599constructorimpl), color != null ? color.getValue() : Color.INSTANCE.m1501getUnspecified0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(3)), 0L, composer3, 0, 8);
                    startRestartGroup.endReplaceGroup();
                }
                Composer composer4 = startRestartGroup;
                TextKt.m940Text4IGK_g(ticketDescriptionItem.getDescription(), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(i6), 0.0f, 0.0f, 0.0f, 14, null), AppColor.INSTANCE.m3254getBrandBlack20d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer4, 432, 1572864, 65528);
                composer4.endNode();
                i8 = 16;
                startRestartGroup = composer4;
            }
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketTermsList_bMF_p3s$lambda$1;
                    TicketTermsList_bMF_p3s$lambda$1 = TicketTermsListKt.TicketTermsList_bMF_p3s$lambda$1(descriptionItems, color, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketTermsList_bMF_p3s$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTermsList_bMF_p3s$lambda$1(List list, Color color, int i5, Composer composer, int i6) {
        m3473TicketTermsListbMFp3s(list, color, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
