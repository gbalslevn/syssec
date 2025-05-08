package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.autofill.AutofillNode;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import dk.molslinjen.ui.views.reusable.input.AutofillBoxKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\t\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "Landroidx/compose/ui/autofill/AutofillType;", "autofillTypes", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onFill", "Landroidx/compose/ui/autofill/AutofillNode;", "content", "AutofillBox", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AutofillBoxKt {
    public static final void AutofillBox(final List<? extends AutofillType> autofillTypes, final Function1<? super String, Unit> onFill, final Function3<? super AutofillNode, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(autofillTypes, "autofillTypes");
        Intrinsics.checkNotNullParameter(onFill, "onFill");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1346002758);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(autofillTypes) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onFill) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1346002758, i6, -1, "dk.molslinjen.ui.views.reusable.input.AutofillBox (AutofillBox.kt:14)");
            }
            startRestartGroup.startReplaceGroup(-1822954695);
            if (autofillTypes.isEmpty()) {
                content.invoke(null, startRestartGroup, Integer.valueOf(((i6 >> 3) & 112) | 6));
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: c2.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AutofillBox$lambda$0;
                            AutofillBox$lambda$0 = AutofillBoxKt.AutofillBox$lambda$0(autofillTypes, onFill, content, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return AutofillBox$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            startRestartGroup.endReplaceGroup();
            final AutofillNode autofillNode = new AutofillNode(autofillTypes, null, onFill, 2, null);
            ((AutofillTree) startRestartGroup.consume(CompositionLocalsKt.getLocalAutofillTree())).plusAssign(autofillNode);
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(-1822932426);
            boolean changedInstance = startRestartGroup.changedInstance(autofillNode);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: c2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AutofillBox$lambda$2$lambda$1;
                        AutofillBox$lambda$2$lambda$1 = AutofillBoxKt.AutofillBox$lambda$2$lambda$1(AutofillNode.this, (LayoutCoordinates) obj);
                        return AutofillBox$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, onGloballyPositioned);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            content.invoke(autofillNode, startRestartGroup, Integer.valueOf(((i6 >> 3) & 112) | AutofillNode.$stable));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: c2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AutofillBox$lambda$4;
                    AutofillBox$lambda$4 = AutofillBoxKt.AutofillBox$lambda$4(autofillTypes, onFill, content, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AutofillBox$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutofillBox$lambda$0(List list, Function1 function1, Function3 function3, int i5, Composer composer, int i6) {
        AutofillBox(list, function1, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutofillBox$lambda$2$lambda$1(AutofillNode autofillNode, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        autofillNode.setBoundingBox(LayoutCoordinatesKt.boundsInWindow(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutofillBox$lambda$4(List list, Function1 function1, Function3 function3, int i5, Composer composer, int i6) {
        AutofillBox(list, function1, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
