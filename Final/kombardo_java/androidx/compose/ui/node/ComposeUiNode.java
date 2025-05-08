package androidx.compose.ui.node;

import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\ba\u0018\u0000 .2\u00020\u0001:\u0001.R\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u00020\u00148&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010%\u001a\u00020 8&@&X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010,\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006/À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/ComposeUiNode;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measurePolicy", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "modifier", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "viewConfiguration", "Landroidx/compose/runtime/CompositionLocalMap;", "getCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "setCompositionLocalMap", "(Landroidx/compose/runtime/CompositionLocalMap;)V", "compositionLocalMap", BuildConfig.FLAVOR, "getCompositeKeyHash", "()I", "setCompositeKeyHash", "(I)V", "getCompositeKeyHash$annotations", "()V", "compositeKeyHash", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ComposeUiNode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR)\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R)\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R)\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R)\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R)\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R)\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000e0\f8\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R2\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0\f8GX\u0087\u0004¢\u0006\u0012\n\u0004\b#\u0010\u0010\u0012\u0004\b%\u0010\u0003\u001a\u0004\b$\u0010\u0012¨\u0006&"}, d2 = {"Landroidx/compose/ui/node/ComposeUiNode$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlin/Function0;", "Landroidx/compose/ui/node/ComposeUiNode;", "Constructor", "Lkotlin/jvm/functions/Function0;", "getConstructor", "()Lkotlin/jvm/functions/Function0;", "VirtualConstructor", "getVirtualConstructor", "Lkotlin/Function2;", "Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "SetModifier", "Lkotlin/jvm/functions/Function2;", "getSetModifier", "()Lkotlin/jvm/functions/Function2;", "Landroidx/compose/ui/unit/Density;", "SetDensity", "getSetDensity", "Landroidx/compose/runtime/CompositionLocalMap;", "SetResolvedCompositionLocals", "getSetResolvedCompositionLocals", "Landroidx/compose/ui/layout/MeasurePolicy;", "SetMeasurePolicy", "getSetMeasurePolicy", "Landroidx/compose/ui/unit/LayoutDirection;", "SetLayoutDirection", "getSetLayoutDirection", "Landroidx/compose/ui/platform/ViewConfiguration;", "SetViewConfiguration", "getSetViewConfiguration", BuildConfig.FLAVOR, "SetCompositeKeyHash", "getSetCompositeKeyHash", "getSetCompositeKeyHash$annotations", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function0<ComposeUiNode> Constructor = LayoutNode.INSTANCE.getConstructor$ui_release();
        private static final Function0<ComposeUiNode> VirtualConstructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$VirtualConstructor$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LayoutNode invoke() {
                return new LayoutNode(true, 0, 2, null);
            }
        };
        private static final Function2<ComposeUiNode, Modifier, Unit> SetModifier = new Function2<ComposeUiNode, Modifier, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, Modifier modifier) {
                invoke2(composeUiNode, modifier);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, Modifier modifier) {
                composeUiNode.setModifier(modifier);
            }
        };
        private static final Function2<ComposeUiNode, Density, Unit> SetDensity = new Function2<ComposeUiNode, Density, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetDensity$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, Density density) {
                invoke2(composeUiNode, density);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, Density density) {
                composeUiNode.setDensity(density);
            }
        };
        private static final Function2<ComposeUiNode, CompositionLocalMap, Unit> SetResolvedCompositionLocals = new Function2<ComposeUiNode, CompositionLocalMap, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, CompositionLocalMap compositionLocalMap) {
                invoke2(composeUiNode, compositionLocalMap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, CompositionLocalMap compositionLocalMap) {
                composeUiNode.setCompositionLocalMap(compositionLocalMap);
            }
        };
        private static final Function2<ComposeUiNode, MeasurePolicy, Unit> SetMeasurePolicy = new Function2<ComposeUiNode, MeasurePolicy, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, MeasurePolicy measurePolicy) {
                invoke2(composeUiNode, measurePolicy);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, MeasurePolicy measurePolicy) {
                composeUiNode.setMeasurePolicy(measurePolicy);
            }
        };
        private static final Function2<ComposeUiNode, LayoutDirection, Unit> SetLayoutDirection = new Function2<ComposeUiNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetLayoutDirection$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, LayoutDirection layoutDirection) {
                invoke2(composeUiNode, layoutDirection);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, LayoutDirection layoutDirection) {
                composeUiNode.setLayoutDirection(layoutDirection);
            }
        };
        private static final Function2<ComposeUiNode, ViewConfiguration, Unit> SetViewConfiguration = new Function2<ComposeUiNode, ViewConfiguration, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetViewConfiguration$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, ViewConfiguration viewConfiguration) {
                invoke2(composeUiNode, viewConfiguration);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ComposeUiNode composeUiNode, ViewConfiguration viewConfiguration) {
                composeUiNode.setViewConfiguration(viewConfiguration);
            }
        };
        private static final Function2<ComposeUiNode, Integer, Unit> SetCompositeKeyHash = new Function2<ComposeUiNode, Integer, Unit>() { // from class: androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ComposeUiNode composeUiNode, Integer num) {
                invoke(composeUiNode, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ComposeUiNode composeUiNode, int i5) {
                composeUiNode.setCompositeKeyHash(i5);
            }
        };

        private Companion() {
        }

        public final Function0<ComposeUiNode> getConstructor() {
            return Constructor;
        }

        public final Function2<ComposeUiNode, Integer, Unit> getSetCompositeKeyHash() {
            return SetCompositeKeyHash;
        }

        public final Function2<ComposeUiNode, Density, Unit> getSetDensity() {
            return SetDensity;
        }

        public final Function2<ComposeUiNode, LayoutDirection, Unit> getSetLayoutDirection() {
            return SetLayoutDirection;
        }

        public final Function2<ComposeUiNode, MeasurePolicy, Unit> getSetMeasurePolicy() {
            return SetMeasurePolicy;
        }

        public final Function2<ComposeUiNode, Modifier, Unit> getSetModifier() {
            return SetModifier;
        }

        public final Function2<ComposeUiNode, CompositionLocalMap, Unit> getSetResolvedCompositionLocals() {
            return SetResolvedCompositionLocals;
        }

        public final Function2<ComposeUiNode, ViewConfiguration, Unit> getSetViewConfiguration() {
            return SetViewConfiguration;
        }

        public final Function0<ComposeUiNode> getVirtualConstructor() {
            return VirtualConstructor;
        }
    }

    void setCompositeKeyHash(int i5);

    void setCompositionLocalMap(CompositionLocalMap compositionLocalMap);

    void setDensity(Density density);

    void setLayoutDirection(LayoutDirection layoutDirection);

    void setMeasurePolicy(MeasurePolicy measurePolicy);

    void setModifier(Modifier modifier);

    void setViewConfiguration(ViewConfiguration viewConfiguration);
}
