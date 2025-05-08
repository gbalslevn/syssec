package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public abstract class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i5, Class cls, String str, String str2, int i6) {
        super(i5, CallableReference.NO_RECEIVER, cls, str, str2, i6);
    }

    public FunctionReferenceImpl(int i5, Object obj, Class cls, String str, String str2, int i6) {
        super(i5, obj, cls, str, str2, i6);
    }
}
