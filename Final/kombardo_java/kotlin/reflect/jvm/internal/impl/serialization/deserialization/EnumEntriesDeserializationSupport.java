package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* loaded from: classes3.dex */
public interface EnumEntriesDeserializationSupport {

    /* loaded from: classes3.dex */
    public static final class Default implements EnumEntriesDeserializationSupport {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport
        public Boolean canSynthesizeEnumEntries() {
            return null;
        }
    }

    Boolean canSynthesizeEnumEntries();
}
