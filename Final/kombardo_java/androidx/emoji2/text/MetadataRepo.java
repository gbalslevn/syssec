package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final Node mRootNode = new Node(DEFAULT_ROOT_SIZE);
    private final Typeface mTypeface;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Node {
        private final SparseArray<Node> mChildren;
        private TypefaceEmojiRasterizer mData;

        private Node() {
            this(1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Node get(int i5) {
            SparseArray<Node> sparseArray = this.mChildren;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final TypefaceEmojiRasterizer getData() {
            return this.mData;
        }

        void put(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i5, int i6) {
            Node node = get(typefaceEmojiRasterizer.getCodepointAt(i5));
            if (node == null) {
                node = new Node();
                this.mChildren.put(typefaceEmojiRasterizer.getCodepointAt(i5), node);
            }
            if (i6 > i5) {
                node.put(typefaceEmojiRasterizer, i5 + 1, i6);
            } else {
                node.mData = typefaceEmojiRasterizer;
            }
        }

        Node(int i5) {
            this.mChildren = new SparseArray<>(i5);
        }
    }

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        this.mEmojiCharArray = new char[metadataList.listLength() * 2];
        constructIndex(metadataList);
    }

    private void constructIndex(MetadataList metadataList) {
        int listLength = metadataList.listLength();
        for (int i5 = 0; i5 < listLength; i5++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i5);
            Character.toChars(typefaceEmojiRasterizer.getId(), this.mEmojiCharArray, i5 * 2);
            put(typefaceEmojiRasterizer);
        }
    }

    public static MetadataRepo create(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            TraceCompat.beginSection(S_TRACE_CREATE_REPO);
            return new MetadataRepo(typeface, MetadataListReader.read(byteBuffer));
        } finally {
            TraceCompat.endSection();
        }
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node getRootNode() {
        return this.mRootNode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface getTypeface() {
        return this.mTypeface;
    }

    void put(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        Preconditions.checkNotNull(typefaceEmojiRasterizer, "emoji metadata cannot be null");
        Preconditions.checkArgument(typefaceEmojiRasterizer.getCodepointsLength() > 0, "invalid metadata codepoint length");
        this.mRootNode.put(typefaceEmojiRasterizer, 0, typefaceEmojiRasterizer.getCodepointsLength() - 1);
    }
}
