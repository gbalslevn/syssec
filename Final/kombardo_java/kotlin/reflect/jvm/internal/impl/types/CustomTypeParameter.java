package kotlin.reflect.jvm.internal.impl.types;

/* loaded from: classes3.dex */
public interface CustomTypeParameter {
    boolean isTypeParameter();

    KotlinType substitutionResult(KotlinType kotlinType);
}
