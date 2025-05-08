package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0012\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\t\u0010\nR#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/ComposedModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", BuildConfig.FLAVOR, "inspectorInfo", "Landroidx/compose/ui/Modifier;", "factory", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "getFactory", "()Lkotlin/jvm/functions/Function3;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class ComposedModifier extends InspectorValueInfo implements Modifier.Element {
    private final Function3<Modifier, Composer, Integer, Modifier> factory;

    /* JADX WARN: Multi-variable type inference failed */
    public ComposedModifier(Function1<? super InspectorInfo, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> function3) {
        super(function1);
        this.factory = function3;
    }

    public final Function3<Modifier, Composer, Integer, Modifier> getFactory() {
        return this.factory;
    }
}
