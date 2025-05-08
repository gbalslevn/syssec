package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.Builder;
import androidx.datastore.preferences.protobuf.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();

    /* loaded from: classes.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            if (messagetype.isMutable()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.instance = newMutableInstance();
        }

        private static <MessageType> void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            Protobuf.getInstance().schemaFor((Protobuf) messagetype).mergeFrom(messagetype, messagetype2);
        }

        private MessageType newMutableInstance() {
            return (MessageType) this.defaultInstance.newMutableInstance();
        }

        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.instance.isMutable()) {
                return;
            }
            copyOnWriteInternal();
        }

        protected void copyOnWriteInternal() {
            MessageType newMutableInstance = newMutableInstance();
            mergeFromInstance(newMutableInstance, this.instance);
            this.instance = newMutableInstance;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLite.Builder
        public MessageType buildPartial() {
            if (!this.instance.isMutable()) {
                return this.instance;
            }
            this.instance.makeImmutable();
            return this.instance;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BuilderType m2722clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.instance = buildPartial();
            return buildertype;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }
    }

    /* loaded from: classes.dex */
    protected static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {
        private final T defaultInstance;

        public DefaultInstanceBasedParser(T t5) {
            this.defaultInstance = t5;
        }
    }

    /* loaded from: classes.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {
    }

    /* loaded from: classes.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t5) {
        if (t5 == null || t5.isInitialized()) {
            return t5;
        }
        throw t5.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t5);
    }

    private int computeSerializedSize(Schema<?> schema) {
        return schema == null ? Protobuf.getInstance().schemaFor((Protobuf) this).getSerializedSize(this) : schema.getSerializedSize(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) UnsafeUtil.allocateInstance(cls)).getDefaultInstanceForType();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object newMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        return new RawMessageInfo(messageLite, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t5, InputStream inputStream) {
        return (T) checkMessageInitialized(parsePartialFrom(t5, CodedInputStream.newInstance(inputStream), ExtensionRegistryLite.getEmptyRegistry()));
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t5, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        T t6 = (T) t5.newMutableInstance();
        try {
            Schema schemaFor = Protobuf.getInstance().schemaFor((Protobuf) t6);
            schemaFor.mergeFrom(t6, CodedInputStreamReader.forCodedInput(codedInputStream), extensionRegistryLite);
            schemaFor.makeImmutable(t6);
            return t6;
        } catch (InvalidProtocolBufferException e5) {
            e = e5;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException(e);
            }
            throw e.setUnfinishedMessage(t6);
        } catch (UninitializedMessageException e6) {
            throw e6.asInvalidProtocolBufferException().setUnfinishedMessage(t6);
        } catch (IOException e7) {
            if (e7.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e7.getCause());
            }
            throw new InvalidProtocolBufferException(e7).setUnfinishedMessage(t6);
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e8.getCause());
            }
            throw e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t5) {
        t5.markImmutable();
        defaultInstanceMap.put(cls, t5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object buildMessageInfo() {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    int computeHashCode() {
        return Protobuf.getInstance().schemaFor((Protobuf) this).hashCode(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    protected abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Protobuf.getInstance().schemaFor((Protobuf) this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractMessageLite
    int getSerializedSize(Schema schema) {
        if (isMutable()) {
            int computeSerializedSize = computeSerializedSize(schema);
            if (computeSerializedSize >= 0) {
                return computeSerializedSize;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + computeSerializedSize);
        }
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
        }
        int computeSerializedSize2 = computeSerializedSize(schema);
        setMemoizedSerializedSize(computeSerializedSize2);
        return computeSerializedSize2;
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeImmutable() {
        Protobuf.getInstance().schemaFor((Protobuf) this).makeImmutable(this);
        markImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageType newMutableInstance() {
        return (MessageType) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    void setMemoizedHashCode(int i5) {
        this.memoizedHashCode = i5;
    }

    void setMemoizedSerializedSize(int i5) {
        if (i5 >= 0) {
            this.memoizedSerializedSize = (i5 & Integer.MAX_VALUE) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i5);
        }
    }

    public String toString() {
        return MessageLiteToString.toString(this, super.toString());
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        Protobuf.getInstance().schemaFor((Protobuf) this).writeTo(this, CodedOutputStreamWriter.forCodedOutput(codedOutputStream));
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t5, boolean z5) {
        byte byteValue = ((Byte) t5.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = Protobuf.getInstance().schemaFor((Protobuf) t5).isInitialized(t5);
        if (z5) {
            t5.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? t5 : null);
        }
        return isInitialized;
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLiteOrBuilder
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    @Override // androidx.datastore.preferences.protobuf.MessageLite
    public int getSerializedSize() {
        return getSerializedSize(null);
    }
}
