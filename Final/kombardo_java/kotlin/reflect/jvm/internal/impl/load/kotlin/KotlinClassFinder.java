package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* loaded from: classes3.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* loaded from: classes3.dex */
    public static abstract class Result {

        /* loaded from: classes3.dex */
        public static final class KotlinClass extends Result {
            private final byte[] byteContent;
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass;
                this.byteContent = bArr;
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this(kotlinJvmBinaryClass, (i5 & 2) != 0 ? null : bArr);
            }
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            KotlinClass kotlinClass = this instanceof KotlinClass ? (KotlinClass) this : null;
            if (kotlinClass != null) {
                return kotlinClass.getKotlinJvmBinaryClass();
            }
            return null;
        }

        private Result() {
        }
    }

    Result findKotlinClassOrContent(JavaClass javaClass, JvmMetadataVersion jvmMetadataVersion);

    Result findKotlinClassOrContent(ClassId classId, JvmMetadataVersion jvmMetadataVersion);
}
