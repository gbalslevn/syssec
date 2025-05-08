package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J,\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0018J6\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u001aJ@\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u001cJJ\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaImpl;", "Landroidx/compose/runtime/internal/ComposableLambda;", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "tracked", BuildConfig.FLAVOR, "block", "<init>", "(IZLjava/lang/Object;)V", BuildConfig.FLAVOR, "trackWrite", "()V", "Landroidx/compose/runtime/Composer;", "composer", "trackRead", "(Landroidx/compose/runtime/Composer;)V", "update", "(Ljava/lang/Object;)V", "c", "changed", "invoke", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "p1", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "p2", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "p3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "p4", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "I", "getKey", "()I", "Z", "_block", "Ljava/lang/Object;", "Landroidx/compose/runtime/RecomposeScope;", "scope", "Landroidx/compose/runtime/RecomposeScope;", BuildConfig.FLAVOR, "scopes", "Ljava/util/List;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableLambdaImpl implements ComposableLambda {
    private Object _block;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public ComposableLambdaImpl(int i5, boolean z5, Object obj) {
        this.key = i5;
        this.tracked = z5;
        this._block = obj;
    }

    private final void trackRead(Composer composer) {
        RecomposeScope recomposeScope;
        if (!this.tracked || (recomposeScope = composer.getRecomposeScope()) == null) {
            return;
        }
        composer.recordUsed(recomposeScope);
        if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
            this.scope = recomposeScope;
            return;
        }
        List<RecomposeScope> list = this.scopes;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.scopes = arrayList;
            arrayList.add(recomposeScope);
            return;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (ComposableLambdaKt.replacableWith(list.get(i5), recomposeScope)) {
                list.set(i5, recomposeScope);
                return;
            }
        }
        list.add(recomposeScope);
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope recomposeScope = this.scope;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
                this.scope = null;
            }
            List<RecomposeScope> list = this.scopes;
            if (list != null) {
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    list.get(i5).invalidate();
                }
                list.clear();
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Composer composer, Integer num) {
        return invoke(composer, num.intValue());
    }

    public final void update(Object block) {
        if (Intrinsics.areEqual(this._block, block)) {
            return;
        }
        boolean z5 = this._block == null;
        this._block = block;
        if (z5) {
            return;
        }
        trackWrite();
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Composer composer, Integer num) {
        return invoke(obj, composer, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Composer composer, Integer num) {
        return invoke(obj, obj2, composer, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, composer, num.intValue());
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Composer composer, Integer num) {
        return invoke(obj, obj2, obj3, obj4, composer, num.intValue());
    }

    public Object invoke(Composer c5, int changed) {
        Composer startRestartGroup = c5.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        int differentBits = changed | (startRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(0) : ComposableLambdaKt.sameBits(0));
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 2)).invoke(startRestartGroup, Integer.valueOf(differentBits));
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
            endRestartGroup.updateScope((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this, 2));
        }
        return invoke;
    }

    public Object invoke(final Object p12, Composer c5, final int changed) {
        Composer startRestartGroup = c5.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        int differentBits = startRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(1) : ComposableLambdaKt.sameBits(1);
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 3)).invoke(p12, startRestartGroup, Integer.valueOf(differentBits | changed));
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ComposableLambdaImpl.this.invoke(p12, composer, RecomposeScopeImplKt.updateChangedFlags(changed) | 1);
                }
            });
        }
        return invoke;
    }

    public Object invoke(final Object p12, final Object p22, Composer c5, final int changed) {
        Composer startRestartGroup = c5.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        int differentBits = startRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(2) : ComposableLambdaKt.sameBits(2);
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function4<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function4) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 4)).invoke(p12, p22, startRestartGroup, Integer.valueOf(differentBits | changed));
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ComposableLambdaImpl.this.invoke(p12, p22, composer, RecomposeScopeImplKt.updateChangedFlags(changed) | 1);
                }
            });
        }
        return invoke;
    }

    public Object invoke(final Object p12, final Object p22, final Object p32, Composer c5, final int changed) {
        Composer startRestartGroup = c5.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        int differentBits = startRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(3) : ComposableLambdaKt.sameBits(3);
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function5<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function5) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 5)).invoke(p12, p22, p32, startRestartGroup, Integer.valueOf(differentBits | changed));
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ComposableLambdaImpl.this.invoke(p12, p22, p32, composer, RecomposeScopeImplKt.updateChangedFlags(changed) | 1);
                }
            });
        }
        return invoke;
    }

    public Object invoke(final Object p12, final Object p22, final Object p32, final Object p42, Composer c5, final int changed) {
        Composer startRestartGroup = c5.startRestartGroup(this.key);
        trackRead(startRestartGroup);
        int differentBits = startRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(4) : ComposableLambdaKt.sameBits(4);
        Object obj = this._block;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function6<@[ParameterName(name = 'p1')] kotlin.Any?, @[ParameterName(name = 'p2')] kotlin.Any?, @[ParameterName(name = 'p3')] kotlin.Any?, @[ParameterName(name = 'p4')] kotlin.Any?, @[ParameterName(name = 'c')] androidx.compose.runtime.Composer, @[ParameterName(name = 'changed')] kotlin.Int, kotlin.Any?>");
        Object invoke = ((Function6) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 6)).invoke(p12, p22, p32, p42, startRestartGroup, Integer.valueOf(differentBits | changed));
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    ComposableLambdaImpl.this.invoke(p12, p22, p32, p42, composer, RecomposeScopeImplKt.updateChangedFlags(changed) | 1);
                }
            });
        }
        return invoke;
    }
}
