package kotlin.reflect;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00012\u00020\u0004J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H'¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/KClass;", BuildConfig.FLAVOR, "T", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KClassifier;", "value", BuildConfig.FLAVOR, "isInstance", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "getSimpleName", "()Ljava/lang/String;", "simpleName", "getQualifiedName", "qualifiedName", "isValue", "()Z", "isValue$annotations", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KClass<T> extends KDeclarationContainer, KClassifier {
    String getQualifiedName();

    String getSimpleName();

    boolean isInstance(Object value);

    boolean isValue();
}
