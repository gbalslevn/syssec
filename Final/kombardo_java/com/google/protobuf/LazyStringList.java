package com.google.protobuf;

import java.util.List;

/* loaded from: classes2.dex */
public interface LazyStringList extends List {
    void add(ByteString byteString);

    Object getRaw(int i5);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();
}
