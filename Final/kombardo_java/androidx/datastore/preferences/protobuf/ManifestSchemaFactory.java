package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = new MessageInfoFactory() { // from class: androidx.datastore.preferences.protobuf.ManifestSchemaFactory.1
        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };
    private final MessageInfoFactory messageInfoFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.datastore.preferences.protobuf.ManifestSchemaFactory$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$ProtoSyntax;

        static {
            int[] iArr = new int[ProtoSyntax.values().length];
            $SwitchMap$com$google$protobuf$ProtoSyntax = iArr;
            try {
                iArr[ProtoSyntax.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.factories = messageInfoFactoryArr;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private static boolean allowExtensions(MessageInfo messageInfo) {
        return AnonymousClass2.$SwitchMap$com$google$protobuf$ProtoSyntax[messageInfo.getSyntax().ordinal()] != 1;
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory());
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        if (Protobuf.assumeLiteRuntime) {
            return EMPTY_FACTORY;
        }
        try {
            return (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return EMPTY_FACTORY;
        }
    }

    private static <T> Schema<T> newSchema(Class<T> cls, MessageInfo messageInfo) {
        if (useLiteRuntime(cls)) {
            return MessageSchema.newSchema(cls, messageInfo, NewInstanceSchemas.lite(), ListFieldSchemas.lite(), SchemaUtil.unknownFieldSetLiteSchema(), allowExtensions(messageInfo) ? ExtensionSchemas.lite() : null, MapFieldSchemas.lite());
        }
        return MessageSchema.newSchema(cls, messageInfo, NewInstanceSchemas.full(), ListFieldSchemas.full(), SchemaUtil.unknownFieldSetFullSchema(), allowExtensions(messageInfo) ? ExtensionSchemas.full() : null, MapFieldSchemas.full());
    }

    private static boolean useLiteRuntime(Class<?> cls) {
        return Protobuf.assumeLiteRuntime || GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.SchemaFactory
    public <T> Schema<T> createSchema(Class<T> cls) {
        SchemaUtil.requireGeneratedMessage(cls);
        MessageInfo messageInfoFor = this.messageInfoFactory.messageInfoFor(cls);
        return messageInfoFor.isMessageSetWireFormat() ? useLiteRuntime(cls) ? MessageSetSchema.newSchema(SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.lite(), messageInfoFor.getDefaultInstance()) : MessageSetSchema.newSchema(SchemaUtil.unknownFieldSetFullSchema(), ExtensionSchemas.full(), messageInfoFor.getDefaultInstance()) : newSchema(cls, messageInfoFor);
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.checkNotNull(messageInfoFactory, "messageInfoFactory");
    }
}
