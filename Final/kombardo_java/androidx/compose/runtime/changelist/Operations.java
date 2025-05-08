package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import com.adjust.sdk.Constants;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\b\u0000\u0018\u0000 C2\u00020\u0001:\u0003CDEB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000fJ\u001e\u0010\u0019\u001a\u00020\u00042\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000fJ\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001cJ\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u0003J\u0017\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0010H\u0007¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b\"\u0010!J\u0015\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0000¢\u0006\u0004\b$\u0010%J)\u0010,\u001a\u00020\t2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0017¢\u0006\u0004\b/\u00100R\u001e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0010018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00105R\u001e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00105R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00105R\u0011\u0010B\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b@\u0010A\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"Landroidx/compose/runtime/changelist/Operations;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "<init>", "()V", BuildConfig.FLAVOR, "currentSize", "requiredSize", "determineNewSize", "(II)I", BuildConfig.FLAVOR, "ensureIntArgsSizeAtLeast", "(I)V", "ensureObjectArgsSizeAtLeast", "paramCount", "createExpectedArgMask", "(I)I", "Landroidx/compose/runtime/changelist/Operation;", "peekOperation", "()Landroidx/compose/runtime/changelist/Operation;", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", "topIntIndexOf-w8GmfQM", "topIntIndexOf", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "topObjectIndexOf-31yXWZQ", "topObjectIndexOf", BuildConfig.FLAVOR, "isEmpty", "()Z", "isNotEmpty", "clear", "operation", "pushOp", "(Landroidx/compose/runtime/changelist/Operation;)V", Constants.PUSH, "other", "popInto", "(Landroidx/compose/runtime/changelist/Operations;)V", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "executeAndFlushAllPendingOperations", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "opCodes", "[Landroidx/compose/runtime/changelist/Operation;", "opCodesSize", "I", BuildConfig.FLAVOR, "intArgs", "[I", "intArgsSize", BuildConfig.FLAVOR, "objectArgs", "[Ljava/lang/Object;", "objectArgsSize", "pushedIntMask", "pushedObjectMask", "getSize", "()I", "size", "Companion", "OpIterator", "WriteScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Operations extends OperationsDebugStringFormattable {
    private static final int MaxResizeAmount = 1024;
    private int intArgsSize;
    private int objectArgsSize;
    private int opCodesSize;
    private int pushedIntMask;
    private int pushedObjectMask;
    public static final int $stable = 8;
    private Operation[] opCodes = new Operation[16];
    private int[] intArgs = new int[16];
    private Object[] objectArgs = new Object[16];

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "(Landroidx/compose/runtime/changelist/Operations;)V", "intIdx", BuildConfig.FLAVOR, "objIdx", "opIdx", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation", "()Landroidx/compose/runtime/changelist/Operation;", "getInt", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getInt-w8GmfQM", "(I)I", "getObject", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "getObject-31yXWZQ", "(I)Ljava/lang/Object;", "next", BuildConfig.FLAVOR, "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class OpIterator implements OperationArgContainer {
        private int intIdx;
        private int objIdx;
        private int opIdx;

        public OpIterator() {
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        /* renamed from: getInt-w8GmfQM */
        public int mo1234getIntw8GmfQM(int parameter) {
            return Operations.this.intArgs[this.intIdx + parameter];
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        /* renamed from: getObject-31yXWZQ */
        public <T> T mo1235getObject31yXWZQ(int parameter) {
            return (T) Operations.this.objectArgs[this.objIdx + parameter];
        }

        public final Operation getOperation() {
            Operation operation = Operations.this.opCodes[this.opIdx];
            Intrinsics.checkNotNull(operation);
            return operation;
        }

        public final boolean next() {
            if (this.opIdx >= Operations.this.opCodesSize) {
                return false;
            }
            Operation operation = getOperation();
            this.intIdx += operation.getInts();
            this.objIdx += operation.getObjects();
            int i5 = this.opIdx + 1;
            this.opIdx = i5;
            return i5 < Operations.this.opCodesSize;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\t\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0088\u0001\u0003\u0092\u0001\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/changelist/Operations$WriteScope;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/Operations;", "stack", "constructor-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operations;", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "setInt-A6tL2VI", "(Landroidx/compose/runtime/changelist/Operations;II)V", "setInt", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "setObject-DKhxnng", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;)V", "setObject", "Landroidx/compose/runtime/changelist/Operation;", "getOperation-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operation;", "operation", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class WriteScope {
        /* renamed from: constructor-impl, reason: not valid java name */
        public static Operations m1240constructorimpl(Operations operations) {
            return operations;
        }

        /* renamed from: getOperation-impl, reason: not valid java name */
        public static final Operation m1241getOperationimpl(Operations operations) {
            return operations.peekOperation();
        }

        /* renamed from: setInt-A6tL2VI, reason: not valid java name */
        public static final void m1242setIntA6tL2VI(Operations operations, int i5, int i6) {
            int i7 = 1 << i5;
            if (!((operations.pushedIntMask & i7) == 0)) {
                PreconditionsKt.throwIllegalStateException("Already pushed argument " + m1241getOperationimpl(operations).mo1228intParamNamew8GmfQM(i5));
            }
            operations.pushedIntMask |= i7;
            operations.intArgs[operations.m1238topIntIndexOfw8GmfQM(i5)] = i6;
        }

        /* renamed from: setObject-DKhxnng, reason: not valid java name */
        public static final <T> void m1243setObjectDKhxnng(Operations operations, int i5, T t5) {
            int i6 = 1 << i5;
            if (!((operations.pushedObjectMask & i6) == 0)) {
                PreconditionsKt.throwIllegalStateException("Already pushed argument " + m1241getOperationimpl(operations).mo1229objectParamName31yXWZQ(i5));
            }
            operations.pushedObjectMask |= i6;
            operations.objectArgs[operations.m1239topObjectIndexOf31yXWZQ(i5)] = t5;
        }
    }

    public static final /* synthetic */ int access$createExpectedArgMask(Operations operations, int i5) {
        return operations.createExpectedArgMask(i5);
    }

    public static final /* synthetic */ int access$getPushedIntMask$p(Operations operations) {
        return operations.pushedIntMask;
    }

    public static final /* synthetic */ int access$getPushedObjectMask$p(Operations operations) {
        return operations.pushedObjectMask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int createExpectedArgMask(int paramCount) {
        if (paramCount == 0) {
            return 0;
        }
        return (-1) >>> (32 - paramCount);
    }

    private final int determineNewSize(int currentSize, int requiredSize) {
        return RangesKt.coerceAtLeast(currentSize + RangesKt.coerceAtMost(currentSize, MaxResizeAmount), requiredSize);
    }

    private final void ensureIntArgsSizeAtLeast(int requiredSize) {
        int[] iArr = this.intArgs;
        int length = iArr.length;
        if (requiredSize > length) {
            int[] copyOf = Arrays.copyOf(iArr, determineNewSize(length, requiredSize));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.intArgs = copyOf;
        }
    }

    private final void ensureObjectArgsSizeAtLeast(int requiredSize) {
        Object[] objArr = this.objectArgs;
        int length = objArr.length;
        if (requiredSize > length) {
            Object[] copyOf = Arrays.copyOf(objArr, determineNewSize(length, requiredSize));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.objectArgs = copyOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Operation peekOperation() {
        Operation operation = this.opCodes[this.opCodesSize - 1];
        Intrinsics.checkNotNull(operation);
        return operation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: topIntIndexOf-w8GmfQM, reason: not valid java name */
    public final int m1238topIntIndexOfw8GmfQM(int parameter) {
        return (this.intArgsSize - peekOperation().getInts()) + parameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: topObjectIndexOf-31yXWZQ, reason: not valid java name */
    public final int m1239topObjectIndexOf31yXWZQ(int parameter) {
        return (this.objectArgsSize - peekOperation().getObjects()) + parameter;
    }

    public final void clear() {
        this.opCodesSize = 0;
        this.intArgsSize = 0;
        ArraysKt.fill(this.objectArgs, (Object) null, 0, this.objectArgsSize);
        this.objectArgsSize = 0;
    }

    public final void executeAndFlushAllPendingOperations(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        if (isNotEmpty()) {
            OpIterator opIterator = new OpIterator();
            do {
                opIterator.getOperation().execute(opIterator, applier, slots, rememberManager);
            } while (opIterator.next());
        }
        clear();
    }

    /* renamed from: getSize, reason: from getter */
    public final int getOpCodesSize() {
        return this.opCodesSize;
    }

    public final boolean isEmpty() {
        return getOpCodesSize() == 0;
    }

    public final boolean isNotEmpty() {
        return getOpCodesSize() != 0;
    }

    public final void popInto(Operations other) {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot pop(), because the stack is empty.");
        }
        Operation[] operationArr = this.opCodes;
        int i5 = this.opCodesSize - 1;
        this.opCodesSize = i5;
        Operation operation = operationArr[i5];
        Intrinsics.checkNotNull(operation);
        this.opCodes[this.opCodesSize] = null;
        other.pushOp(operation);
        int i6 = this.objectArgsSize;
        int i7 = other.objectArgsSize;
        int objects = operation.getObjects();
        for (int i8 = 0; i8 < objects; i8++) {
            i7--;
            i6--;
            Object[] objArr = other.objectArgs;
            Object[] objArr2 = this.objectArgs;
            objArr[i7] = objArr2[i6];
            objArr2[i6] = null;
        }
        int i9 = this.intArgsSize;
        int i10 = other.intArgsSize;
        int ints = operation.getInts();
        for (int i11 = 0; i11 < ints; i11++) {
            i10--;
            i9--;
            int[] iArr = other.intArgs;
            int[] iArr2 = this.intArgs;
            iArr[i10] = iArr2[i9];
            iArr2[i9] = 0;
        }
        this.objectArgsSize -= operation.getObjects();
        this.intArgsSize -= operation.getInts();
    }

    public final void push(Operation operation) {
        if (!(operation.getInts() == 0 && operation.getObjects() == 0)) {
            PreconditionsKt.throwIllegalArgumentException("Cannot push " + operation + " without arguments because it expects " + operation.getInts() + " ints and " + operation.getObjects() + " objects.");
        }
        pushOp(operation);
    }

    public final void pushOp(Operation operation) {
        this.pushedIntMask = 0;
        this.pushedObjectMask = 0;
        int i5 = this.opCodesSize;
        if (i5 == this.opCodes.length) {
            Object[] copyOf = Arrays.copyOf(this.opCodes, this.opCodesSize + RangesKt.coerceAtMost(i5, MaxResizeAmount));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.opCodes = (Operation[]) copyOf;
        }
        ensureIntArgsSizeAtLeast(this.intArgsSize + operation.getInts());
        ensureObjectArgsSizeAtLeast(this.objectArgsSize + operation.getObjects());
        Operation[] operationArr = this.opCodes;
        int i6 = this.opCodesSize;
        this.opCodesSize = i6 + 1;
        operationArr[i6] = operation;
        this.intArgsSize += operation.getInts();
        this.objectArgsSize += operation.getObjects();
    }

    @Deprecated
    public String toString() {
        return super.toString();
    }
}
