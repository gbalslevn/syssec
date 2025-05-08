package com.google.protobuf;

/* loaded from: classes2.dex */
abstract class UnknownFieldSchema<T, B> {
    private static volatile int recursionLimit = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T getFromMessage(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getSerializedSize(T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getSerializedSizeAsMessageSet(T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void makeImmutable(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T merge(T t5, T t6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setToMessage(Object obj, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeAsMessageSetTo(T t5, Writer writer);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeTo(T t5, Writer writer);
}
