package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.ui.views.reusable.buttons.ButtonStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ButtonWithPriceKt$ButtonWithPrice$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ButtonConfig $buttonConfig;
    final /* synthetic */ ButtonStyle.Primary $buttonStyle;
    final /* synthetic */ boolean $clearFocusOnClick;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Function0<Unit> $onClickDisabled;
    final /* synthetic */ PriceTotal $priceTotal;
    final /* synthetic */ String $quantityText;
    final /* synthetic */ String $text;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ButtonWithPriceKt$ButtonWithPrice$3(boolean z5, FocusManager focusManager, boolean z6, Function0<Unit> function0, Function0<Unit> function02, Modifier modifier, ButtonConfig buttonConfig, ButtonStyle.Primary primary, PriceTotal priceTotal, String str, String str2) {
        this.$clearFocusOnClick = z5;
        this.$focusManager = focusManager;
        this.$enabled = z6;
        this.$onClick = function0;
        this.$onClickDisabled = function02;
        this.$modifier = modifier;
        this.$buttonConfig = buttonConfig;
        this.$buttonStyle = primary;
        this.$priceTotal = priceTotal;
        this.$quantityText = str;
        this.$text = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(boolean z5, FocusManager focusManager, boolean z6, Function0 function0, Function0 function02) {
        if (z5) {
            FocusManager.clearFocus$default(focusManager, false, 1, null);
        }
        if (z6) {
            function0.invoke();
        } else if (function02 != null) {
            function02.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v8 ??, still in use, count: 1, list:
          (r1v8 ?? I:java.lang.Object) from 0x006c: INVOKE (r20v0 ?? I:androidx.compose.runtime.Composer), (r1v8 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:9)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    public final void invoke(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v8 ??, still in use, count: 1, list:
          (r1v8 ?? I:java.lang.Object) from 0x006c: INVOKE (r20v0 ?? I:androidx.compose.runtime.Composer), (r1v8 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:9)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r20v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
}
