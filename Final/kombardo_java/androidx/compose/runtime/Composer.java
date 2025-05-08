package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 y2\u00020\u0001:\u0001yJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H'¢\u0006\u0004\b\n\u0010\bJ!\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H'¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H'¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H'¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H'¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H'¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0004H'¢\u0006\u0004\b\u001c\u0010\bJ#\u0010 \u001a\u00020\u0004\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH'¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0004H'¢\u0006\u0004\b\"\u0010\bJ\u000f\u0010#\u001a\u00020\u0004H'¢\u0006\u0004\b#\u0010\bJ!\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b$\u0010\rJ\u000f\u0010%\u001a\u00020\u0004H'¢\u0006\u0004\b%\u0010\bJ\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0002H'¢\u0006\u0004\b'\u0010\u0006J=\u0010,\u001a\u00020\u0004\"\u0004\b\u0000\u0010(\"\u0004\b\u0001\u0010\u001d2\u0006\u0010)\u001a\u00028\u00002\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040*H'¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b0\u00101J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\u0018\u00102J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u0018\u00103J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0018\u00104J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010)\u001a\u000205H\u0017¢\u0006\u0004\b\u0018\u00106J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010)\u001a\u000207H\u0017¢\u0006\u0004\b\u0018\u00108J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010)\u001a\u000209H\u0017¢\u0006\u0004\b\u0018\u0010:J\u0019\u0010;\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0017¢\u0006\u0004\b;\u00102J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<H'¢\u0006\u0004\b>\u0010?J\u001d\u0010A\u001a\u00020\u00042\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH'¢\u0006\u0004\bA\u0010!J#\u0010C\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000BH'¢\u0006\u0004\bC\u0010DJ#\u0010H\u001a\u00020\u00042\u0012\u0010G\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030F0EH'¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0004H'¢\u0006\u0004\bJ\u0010\bJ\u001b\u0010K\u001a\u00020\u00042\n\u0010)\u001a\u0006\u0012\u0002\b\u00030FH'¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u0004H'¢\u0006\u0004\bM\u0010\bJ\u000f\u0010N\u001a\u00020\u0004H&¢\u0006\u0004\bN\u0010\bJ\u000f\u0010P\u001a\u00020OH'¢\u0006\u0004\bP\u0010QR\u001e\u0010V\u001a\u0006\u0012\u0002\b\u00030R8&X§\u0004¢\u0006\f\u0012\u0004\bU\u0010\b\u001a\u0004\bS\u0010TR\u001a\u0010Z\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\bY\u0010\b\u001a\u0004\bW\u0010XR\u001a\u0010]\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\\\u0010\b\u001a\u0004\b[\u0010XR\u001a\u0010`\u001a\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b_\u0010\b\u001a\u0004\b^\u0010XR\u001c\u0010d\u001a\u0004\u0018\u00010<8&X§\u0004¢\u0006\f\u0012\u0004\bc\u0010\b\u001a\u0004\ba\u0010bR\u001a\u0010h\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bg\u0010\b\u001a\u0004\be\u0010fR\u001a\u0010k\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bj\u0010\b\u001a\u0004\bi\u0010fR\u0014\u0010o\u001a\u00020l8&X¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8&X¦\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u001a\u0010x\u001a\u00020t8gX§\u0004¢\u0006\f\u0012\u0004\bw\u0010\b\u001a\u0004\bu\u0010v\u0082\u0001\u0001zø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006{À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/Composer;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "startReplaceableGroup", "(I)V", "endReplaceableGroup", "()V", "startReplaceGroup", "endReplaceGroup", "dataKey", "startMovableGroup", "(ILjava/lang/Object;)V", "endMovableGroup", "startDefaults", "endDefaults", "startRestartGroup", "(I)Landroidx/compose/runtime/Composer;", "Landroidx/compose/runtime/ScopeUpdateScope;", "endRestartGroup", "()Landroidx/compose/runtime/ScopeUpdateScope;", "skipToGroupEnd", BuildConfig.FLAVOR, "changed", "deactivateToEndGroup", "(Z)V", "startNode", "startReusableNode", "T", "Lkotlin/Function0;", "factory", "createNode", "(Lkotlin/jvm/functions/Function0;)V", "useNode", "endNode", "startReusableGroup", "endReusableGroup", "marker", "endToMarker", "V", "value", "Lkotlin/Function2;", "block", "apply", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "rememberedValue", "()Ljava/lang/Object;", "updateRememberedValue", "(Ljava/lang/Object;)V", "(Ljava/lang/Object;)Z", "(Z)Z", "(I)Z", BuildConfig.FLAVOR, "(F)Z", BuildConfig.FLAVOR, "(J)Z", BuildConfig.FLAVOR, "(D)Z", "changedInstance", "Landroidx/compose/runtime/RecomposeScope;", "scope", "recordUsed", "(Landroidx/compose/runtime/RecomposeScope;)V", "effect", "recordSideEffect", "Landroidx/compose/runtime/CompositionLocal;", "consume", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/ProvidedValue;", "values", "startProviders", "([Landroidx/compose/runtime/ProvidedValue;)V", "endProviders", "startProvider", "(Landroidx/compose/runtime/ProvidedValue;)V", "endProvider", "collectParameterInformation", "Landroidx/compose/runtime/CompositionContext;", "buildContext", "()Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/Applier;", "getApplier", "()Landroidx/compose/runtime/Applier;", "getApplier$annotations", "applier", "getInserting", "()Z", "getInserting$annotations", "inserting", "getSkipping", "getSkipping$annotations", "skipping", "getDefaultsInvalid", "getDefaultsInvalid$annotations", "defaultsInvalid", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope$annotations", "recomposeScope", "getCompoundKeyHash", "()I", "getCompoundKeyHash$annotations", "compoundKeyHash", "getCurrentMarker", "getCurrentMarker$annotations", "currentMarker", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentCompositionLocalMap", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionData", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "applyCoroutineContext", "Companion", "Landroidx/compose/runtime/ComposerImpl;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Composer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/Composer$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Empty", "Ljava/lang/Object;", "getEmpty", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Object Empty = new Object() { // from class: androidx.compose.runtime.Composer$Companion$Empty$1
            public String toString() {
                return "Empty";
            }
        };

        private Companion() {
        }

        public final Object getEmpty() {
            return Empty;
        }
    }

    <V, T> void apply(V value, Function2<? super T, ? super V, Unit> block);

    CompositionContext buildContext();

    boolean changed(double value);

    boolean changed(float value);

    boolean changed(int value);

    boolean changed(long value);

    boolean changed(Object value);

    boolean changed(boolean value);

    boolean changedInstance(Object value);

    void collectParameterInformation();

    <T> T consume(CompositionLocal<T> key);

    <T> void createNode(Function0<? extends T> factory);

    void deactivateToEndGroup(boolean changed);

    void endDefaults();

    void endMovableGroup();

    void endNode();

    void endProvider();

    void endProviders();

    void endReplaceGroup();

    void endReplaceableGroup();

    ScopeUpdateScope endRestartGroup();

    void endReusableGroup();

    void endToMarker(int marker);

    Applier<?> getApplier();

    CoroutineContext getApplyCoroutineContext();

    CompositionData getCompositionData();

    int getCompoundKeyHash();

    CompositionLocalMap getCurrentCompositionLocalMap();

    int getCurrentMarker();

    boolean getDefaultsInvalid();

    boolean getInserting();

    RecomposeScope getRecomposeScope();

    boolean getSkipping();

    void recordSideEffect(Function0<Unit> effect);

    void recordUsed(RecomposeScope scope);

    Object rememberedValue();

    void skipToGroupEnd();

    void startDefaults();

    void startMovableGroup(int key, Object dataKey);

    void startNode();

    void startProvider(ProvidedValue<?> value);

    void startProviders(ProvidedValue<?>[] values);

    void startReplaceGroup(int key);

    void startReplaceableGroup(int key);

    Composer startRestartGroup(int key);

    void startReusableGroup(int key, Object dataKey);

    void startReusableNode();

    void updateRememberedValue(Object value);

    void useNode();
}
