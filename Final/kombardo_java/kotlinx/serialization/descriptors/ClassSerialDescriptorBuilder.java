package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\u001b\u0012\u0004\b \u0010\u001a\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u001dR&\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001dR \u0010+\u001a\b\u0012\u0004\u0012\u00020\f0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u001d¨\u0006-"}, d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "serialName", "<init>", "(Ljava/lang/String;)V", "elementName", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "annotations", BuildConfig.FLAVOR, "isOptional", BuildConfig.FLAVOR, "element", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/util/List;Z)V", "Ljava/lang/String;", "getSerialName", "()Ljava/lang/String;", "isNullable", "Z", "()Z", "setNullable", "(Z)V", "isNullable$annotations", "()V", "Ljava/util/List;", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "getAnnotations$annotations", BuildConfig.FLAVOR, "elementNames", "getElementNames$kotlinx_serialization_core", BuildConfig.FLAVOR, "uniqueNames", "Ljava/util/Set;", "elementDescriptors", "getElementDescriptors$kotlinx_serialization_core", "elementAnnotations", "getElementAnnotations$kotlinx_serialization_core", "elementOptionality", "getElementOptionality$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClassSerialDescriptorBuilder {
    private List<? extends Annotation> annotations;
    private final List<List<Annotation>> elementAnnotations;
    private final List<SerialDescriptor> elementDescriptors;
    private final List<String> elementNames;
    private final List<Boolean> elementOptionality;
    private boolean isNullable;
    private final String serialName;
    private final Set<String> uniqueNames;

    public ClassSerialDescriptorBuilder(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.serialName = serialName;
        this.annotations = CollectionsKt.emptyList();
        this.elementNames = new ArrayList();
        this.uniqueNames = new HashSet();
        this.elementDescriptors = new ArrayList();
        this.elementAnnotations = new ArrayList();
        this.elementOptionality = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor, List list, boolean z5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i5 & 8) != 0) {
            z5 = false;
        }
        classSerialDescriptorBuilder.element(str, serialDescriptor, list, z5);
    }

    public final void element(String elementName, SerialDescriptor descriptor, List<? extends Annotation> annotations, boolean isOptional) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.uniqueNames.add(elementName)) {
            this.elementNames.add(elementName);
            this.elementDescriptors.add(descriptor);
            this.elementAnnotations.add(annotations);
            this.elementOptionality.add(Boolean.valueOf(isOptional));
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered in " + this.serialName).toString());
    }

    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public final List<List<Annotation>> getElementAnnotations$kotlinx_serialization_core() {
        return this.elementAnnotations;
    }

    public final List<SerialDescriptor> getElementDescriptors$kotlinx_serialization_core() {
        return this.elementDescriptors;
    }

    public final List<String> getElementNames$kotlinx_serialization_core() {
        return this.elementNames;
    }

    public final List<Boolean> getElementOptionality$kotlinx_serialization_core() {
        return this.elementOptionality;
    }

    public final void setAnnotations(List<? extends Annotation> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.annotations = list;
    }
}
