package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B§\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b/\u0010.R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b0\u0010.R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b1\u0010.R\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b2\u0010.R\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b3\u0010.R\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b4\u0010.R\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b5\u0010.R\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b6\u0010.R\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b7\u0010.R\u001d\u0010\r\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b8\u0010.R\u001d\u0010\u000e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010,\u001a\u0004\b9\u0010.R\u001d\u0010\u000f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b:\u0010.R\u001d\u0010\u0010\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b;\u0010.R\u001d\u0010\u0011\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b<\u0010.R\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b=\u0010.R\u001d\u0010\u0013\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b>\u0010.R\u001d\u0010\u0014\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b?\u0010.R\u001d\u0010\u0015\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b@\u0010.R\u001d\u0010\u0016\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\bA\u0010.R\u001d\u0010\u0017\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\bB\u0010.R\u001d\u0010\u0018\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\bC\u0010.R\u001d\u0010\u0019\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0019\u0010,\u001a\u0004\bD\u0010.R\u001d\u0010\u001a\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\bE\u0010.R\u001d\u0010\u001b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\bF\u0010.R\u001d\u0010\u001c\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\bG\u0010.R\u001d\u0010\u001d\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\bH\u0010.R\u001d\u0010\u001e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\bI\u0010.R\u001d\u0010\u001f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\bJ\u0010.R\u001d\u0010 \u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b \u0010,\u001a\u0004\bK\u0010.R\u001d\u0010!\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b!\u0010,\u001a\u0004\bL\u0010.R\u001d\u0010\"\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\"\u0010,\u001a\u0004\bM\u0010.R\u001d\u0010#\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b#\u0010,\u001a\u0004\bN\u0010.R\u001d\u0010$\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b$\u0010,\u001a\u0004\bO\u0010.R\u001d\u0010%\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b%\u0010,\u001a\u0004\bP\u0010.R\u001d\u0010&\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b&\u0010,\u001a\u0004\bQ\u0010.R$\u0010S\u001a\u0004\u0018\u00010R8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001a\u0004\u0018\u00010R8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010T\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR$\u0010\\\u001a\u0004\u0018\u00010R8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\\\u0010T\u001a\u0004\b]\u0010V\"\u0004\b^\u0010XR$\u0010_\u001a\u0004\u0018\u00010R8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b_\u0010T\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR$\u0010b\u001a\u0004\u0018\u00010R8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bb\u0010T\u001a\u0004\bc\u0010V\"\u0004\bd\u0010XR$\u0010f\u001a\u0004\u0018\u00010e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010l\u001a\u0004\u0018\u00010e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bl\u0010g\u001a\u0004\bm\u0010i\"\u0004\bn\u0010kR$\u0010o\u001a\u0004\u0018\u00010e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bo\u0010g\u001a\u0004\bp\u0010i\"\u0004\bq\u0010kR$\u0010s\u001a\u0004\u0018\u00010r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010y\u001a\u0004\u0018\u00010r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\by\u0010t\u001a\u0004\bz\u0010v\"\u0004\b{\u0010xR$\u0010|\u001a\u0004\u0018\u00010r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b|\u0010t\u001a\u0004\b}\u0010v\"\u0004\b~\u0010xR&\u0010\u007f\u001a\u0004\u0018\u00010r8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010t\u001a\u0005\b\u0080\u0001\u0010v\"\u0005\b\u0081\u0001\u0010xR,\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u0084\u0001\u001a\u0006\b\u008a\u0001\u0010\u0086\u0001\"\u0006\b\u008b\u0001\u0010\u0088\u0001R,\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0082\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u0084\u0001\u001a\u0006\b\u008d\u0001\u0010\u0086\u0001\"\u0006\b\u008e\u0001\u0010\u0088\u0001R4\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u0090\u0001\u0010\u0091\u0001\u0012\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R4\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u0098\u0001\u0010\u0091\u0001\u0012\u0006\b\u009b\u0001\u0010\u0097\u0001\u001a\u0006\b\u0099\u0001\u0010\u0093\u0001\"\u0006\b\u009a\u0001\u0010\u0095\u0001R4\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u009c\u0001\u0010\u0091\u0001\u0012\u0006\b\u009f\u0001\u0010\u0097\u0001\u001a\u0006\b\u009d\u0001\u0010\u0093\u0001\"\u0006\b\u009e\u0001\u0010\u0095\u0001R4\u0010 \u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b \u0001\u0010\u0091\u0001\u0012\u0006\b£\u0001\u0010\u0097\u0001\u001a\u0006\b¡\u0001\u0010\u0093\u0001\"\u0006\b¢\u0001\u0010\u0095\u0001R,\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R4\u0010¬\u0001\u001a\u0005\u0018\u00010«\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b¬\u0001\u0010\u00ad\u0001\u0012\u0006\b²\u0001\u0010\u0097\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R,\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R,\u0010»\u0001\u001a\u0005\u0018\u00010º\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R,\u0010Á\u0001\u001a\u0005\u0018\u00010³\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÁ\u0001\u0010µ\u0001\u001a\u0006\bÂ\u0001\u0010·\u0001\"\u0006\bÃ\u0001\u0010¹\u0001R,\u0010Ä\u0001\u001a\u0005\u0018\u00010º\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010¼\u0001\u001a\u0006\bÅ\u0001\u0010¾\u0001\"\u0006\bÆ\u0001\u0010À\u0001R,\u0010Ç\u0001\u001a\u0005\u0018\u00010³\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010µ\u0001\u001a\u0006\bÈ\u0001\u0010·\u0001\"\u0006\bÉ\u0001\u0010¹\u0001R,\u0010Ê\u0001\u001a\u0005\u0018\u00010º\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010¼\u0001\u001a\u0006\bË\u0001\u0010¾\u0001\"\u0006\bÌ\u0001\u0010À\u0001R,\u0010Í\u0001\u001a\u0005\u0018\u00010³\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010µ\u0001\u001a\u0006\bÎ\u0001\u0010·\u0001\"\u0006\bÏ\u0001\u0010¹\u0001R,\u0010Ð\u0001\u001a\u0005\u0018\u00010º\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÐ\u0001\u0010¼\u0001\u001a\u0006\bÑ\u0001\u0010¾\u0001\"\u0006\bÒ\u0001\u0010À\u0001R,\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R,\u0010Û\u0001\u001a\u0005\u0018\u00010Ú\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R,\u0010â\u0001\u001a\u0005\u0018\u00010á\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bâ\u0001\u0010ã\u0001\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R,\u0010é\u0001\u001a\u0005\u0018\u00010è\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bé\u0001\u0010ê\u0001\u001a\u0006\bë\u0001\u0010ì\u0001\"\u0006\bí\u0001\u0010î\u0001R,\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bð\u0001\u0010ñ\u0001\u001a\u0006\bò\u0001\u0010ó\u0001\"\u0006\bô\u0001\u0010õ\u0001R4\u0010÷\u0001\u001a\u0005\u0018\u00010ö\u00018\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b÷\u0001\u0010ø\u0001\u0012\u0006\bý\u0001\u0010\u0097\u0001\u001a\u0006\bù\u0001\u0010ú\u0001\"\u0006\bû\u0001\u0010ü\u0001R,\u0010ÿ\u0001\u001a\u0005\u0018\u00010þ\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÿ\u0001\u0010\u0080\u0002\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002\"\u0006\b\u0083\u0002\u0010\u0084\u0002R,\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0085\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0086\u0002\u0010\u0087\u0002\u001a\u0006\b\u0088\u0002\u0010\u0089\u0002\"\u0006\b\u008a\u0002\u0010\u008b\u0002R,\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u008c\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008d\u0002\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R,\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u008c\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0093\u0002\u0010\u008e\u0002\u001a\u0006\b\u0094\u0002\u0010\u0090\u0002\"\u0006\b\u0095\u0002\u0010\u0092\u0002R4\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0096\u00028\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u0097\u0002\u0010\u0098\u0002\u0012\u0006\b\u009d\u0002\u0010\u0097\u0001\u001a\u0006\b\u0099\u0002\u0010\u009a\u0002\"\u0006\b\u009b\u0002\u0010\u009c\u0002R4\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u009e\u00028\u0000@\u0000X\u0080\u000e¢\u0006 \n\u0006\b\u009f\u0002\u0010 \u0002\u0012\u0006\b¥\u0002\u0010\u0097\u0001\u001a\u0006\b¡\u0002\u0010¢\u0002\"\u0006\b£\u0002\u0010¤\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¦\u0002"}, d2 = {"Landroidx/compose/material3/ColorScheme;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceDim", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "J", "getPrimary-0d7_KjU", "()J", "getOnPrimary-0d7_KjU", "getPrimaryContainer-0d7_KjU", "getOnPrimaryContainer-0d7_KjU", "getInversePrimary-0d7_KjU", "getSecondary-0d7_KjU", "getOnSecondary-0d7_KjU", "getSecondaryContainer-0d7_KjU", "getOnSecondaryContainer-0d7_KjU", "getTertiary-0d7_KjU", "getOnTertiary-0d7_KjU", "getTertiaryContainer-0d7_KjU", "getOnTertiaryContainer-0d7_KjU", "getBackground-0d7_KjU", "getOnBackground-0d7_KjU", "getSurface-0d7_KjU", "getOnSurface-0d7_KjU", "getSurfaceVariant-0d7_KjU", "getOnSurfaceVariant-0d7_KjU", "getSurfaceTint-0d7_KjU", "getInverseSurface-0d7_KjU", "getInverseOnSurface-0d7_KjU", "getError-0d7_KjU", "getOnError-0d7_KjU", "getErrorContainer-0d7_KjU", "getOnErrorContainer-0d7_KjU", "getOutline-0d7_KjU", "getOutlineVariant-0d7_KjU", "getScrim-0d7_KjU", "getSurfaceBright-0d7_KjU", "getSurfaceDim-0d7_KjU", "getSurfaceContainer-0d7_KjU", "getSurfaceContainerHigh-0d7_KjU", "getSurfaceContainerHighest-0d7_KjU", "getSurfaceContainerLow-0d7_KjU", "getSurfaceContainerLowest-0d7_KjU", "Landroidx/compose/material3/ButtonColors;", "defaultButtonColorsCached", "Landroidx/compose/material3/ButtonColors;", "getDefaultButtonColorsCached$material3_release", "()Landroidx/compose/material3/ButtonColors;", "setDefaultButtonColorsCached$material3_release", "(Landroidx/compose/material3/ButtonColors;)V", "defaultElevatedButtonColorsCached", "getDefaultElevatedButtonColorsCached$material3_release", "setDefaultElevatedButtonColorsCached$material3_release", "defaultFilledTonalButtonColorsCached", "getDefaultFilledTonalButtonColorsCached$material3_release", "setDefaultFilledTonalButtonColorsCached$material3_release", "defaultOutlinedButtonColorsCached", "getDefaultOutlinedButtonColorsCached$material3_release", "setDefaultOutlinedButtonColorsCached$material3_release", "defaultTextButtonColorsCached", "getDefaultTextButtonColorsCached$material3_release", "setDefaultTextButtonColorsCached$material3_release", "Landroidx/compose/material3/CardColors;", "defaultCardColorsCached", "Landroidx/compose/material3/CardColors;", "getDefaultCardColorsCached$material3_release", "()Landroidx/compose/material3/CardColors;", "setDefaultCardColorsCached$material3_release", "(Landroidx/compose/material3/CardColors;)V", "defaultElevatedCardColorsCached", "getDefaultElevatedCardColorsCached$material3_release", "setDefaultElevatedCardColorsCached$material3_release", "defaultOutlinedCardColorsCached", "getDefaultOutlinedCardColorsCached$material3_release", "setDefaultOutlinedCardColorsCached$material3_release", "Landroidx/compose/material3/ChipColors;", "defaultAssistChipColorsCached", "Landroidx/compose/material3/ChipColors;", "getDefaultAssistChipColorsCached$material3_release", "()Landroidx/compose/material3/ChipColors;", "setDefaultAssistChipColorsCached$material3_release", "(Landroidx/compose/material3/ChipColors;)V", "defaultElevatedAssistChipColorsCached", "getDefaultElevatedAssistChipColorsCached$material3_release", "setDefaultElevatedAssistChipColorsCached$material3_release", "defaultSuggestionChipColorsCached", "getDefaultSuggestionChipColorsCached$material3_release", "setDefaultSuggestionChipColorsCached$material3_release", "defaultElevatedSuggestionChipColorsCached", "getDefaultElevatedSuggestionChipColorsCached$material3_release", "setDefaultElevatedSuggestionChipColorsCached$material3_release", "Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColorsCached", "Landroidx/compose/material3/SelectableChipColors;", "getDefaultFilterChipColorsCached$material3_release", "()Landroidx/compose/material3/SelectableChipColors;", "setDefaultFilterChipColorsCached$material3_release", "(Landroidx/compose/material3/SelectableChipColors;)V", "defaultElevatedFilterChipColorsCached", "getDefaultElevatedFilterChipColorsCached$material3_release", "setDefaultElevatedFilterChipColorsCached$material3_release", "defaultInputChipColorsCached", "getDefaultInputChipColorsCached$material3_release", "setDefaultInputChipColorsCached$material3_release", "Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColorsCached", "Landroidx/compose/material3/TopAppBarColors;", "getDefaultTopAppBarColorsCached$material3_release", "()Landroidx/compose/material3/TopAppBarColors;", "setDefaultTopAppBarColorsCached$material3_release", "(Landroidx/compose/material3/TopAppBarColors;)V", "getDefaultTopAppBarColorsCached$material3_release$annotations", "()V", "defaultCenterAlignedTopAppBarColorsCached", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release", "setDefaultCenterAlignedTopAppBarColorsCached$material3_release", "getDefaultCenterAlignedTopAppBarColorsCached$material3_release$annotations", "defaultMediumTopAppBarColorsCached", "getDefaultMediumTopAppBarColorsCached$material3_release", "setDefaultMediumTopAppBarColorsCached$material3_release", "getDefaultMediumTopAppBarColorsCached$material3_release$annotations", "defaultLargeTopAppBarColorsCached", "getDefaultLargeTopAppBarColorsCached$material3_release", "setDefaultLargeTopAppBarColorsCached$material3_release", "getDefaultLargeTopAppBarColorsCached$material3_release$annotations", "Landroidx/compose/material3/CheckboxColors;", "defaultCheckboxColorsCached", "Landroidx/compose/material3/CheckboxColors;", "getDefaultCheckboxColorsCached$material3_release", "()Landroidx/compose/material3/CheckboxColors;", "setDefaultCheckboxColorsCached$material3_release", "(Landroidx/compose/material3/CheckboxColors;)V", "Landroidx/compose/material3/DatePickerColors;", "defaultDatePickerColorsCached", "Landroidx/compose/material3/DatePickerColors;", "getDefaultDatePickerColorsCached$material3_release", "()Landroidx/compose/material3/DatePickerColors;", "setDefaultDatePickerColorsCached$material3_release", "(Landroidx/compose/material3/DatePickerColors;)V", "getDefaultDatePickerColorsCached$material3_release$annotations", "Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColorsCached", "Landroidx/compose/material3/IconButtonColors;", "getDefaultIconButtonColorsCached$material3_release", "()Landroidx/compose/material3/IconButtonColors;", "setDefaultIconButtonColorsCached$material3_release", "(Landroidx/compose/material3/IconButtonColors;)V", "Landroidx/compose/material3/IconToggleButtonColors;", "defaultIconToggleButtonColorsCached", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultIconToggleButtonColorsCached$material3_release", "()Landroidx/compose/material3/IconToggleButtonColors;", "setDefaultIconToggleButtonColorsCached$material3_release", "(Landroidx/compose/material3/IconToggleButtonColors;)V", "defaultFilledIconButtonColorsCached", "getDefaultFilledIconButtonColorsCached$material3_release", "setDefaultFilledIconButtonColorsCached$material3_release", "defaultFilledIconToggleButtonColorsCached", "getDefaultFilledIconToggleButtonColorsCached$material3_release", "setDefaultFilledIconToggleButtonColorsCached$material3_release", "defaultFilledTonalIconButtonColorsCached", "getDefaultFilledTonalIconButtonColorsCached$material3_release", "setDefaultFilledTonalIconButtonColorsCached$material3_release", "defaultFilledTonalIconToggleButtonColorsCached", "getDefaultFilledTonalIconToggleButtonColorsCached$material3_release", "setDefaultFilledTonalIconToggleButtonColorsCached$material3_release", "defaultOutlinedIconButtonColorsCached", "getDefaultOutlinedIconButtonColorsCached$material3_release", "setDefaultOutlinedIconButtonColorsCached$material3_release", "defaultOutlinedIconToggleButtonColorsCached", "getDefaultOutlinedIconToggleButtonColorsCached$material3_release", "setDefaultOutlinedIconToggleButtonColorsCached$material3_release", "Landroidx/compose/material3/MenuItemColors;", "defaultMenuItemColorsCached", "Landroidx/compose/material3/MenuItemColors;", "getDefaultMenuItemColorsCached$material3_release", "()Landroidx/compose/material3/MenuItemColors;", "setDefaultMenuItemColorsCached$material3_release", "(Landroidx/compose/material3/MenuItemColors;)V", "Landroidx/compose/material3/NavigationBarItemColors;", "defaultNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationBarItemColors;", "getDefaultNavigationBarItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationBarItemColors;", "setDefaultNavigationBarItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationBarItemColors;)V", "Landroidx/compose/material3/NavigationRailItemColors;", "defaultNavigationRailItemColorsCached", "Landroidx/compose/material3/NavigationRailItemColors;", "getDefaultNavigationRailItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationRailItemColors;", "setDefaultNavigationRailItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationRailItemColors;)V", "Landroidx/compose/material3/NavigationItemColors;", "defaultExpressiveNavigationBarItemColorsCached", "Landroidx/compose/material3/NavigationItemColors;", "getDefaultExpressiveNavigationBarItemColorsCached$material3_release", "()Landroidx/compose/material3/NavigationItemColors;", "setDefaultExpressiveNavigationBarItemColorsCached$material3_release", "(Landroidx/compose/material3/NavigationItemColors;)V", "Landroidx/compose/material3/RadioButtonColors;", "defaultRadioButtonColorsCached", "Landroidx/compose/material3/RadioButtonColors;", "getDefaultRadioButtonColorsCached$material3_release", "()Landroidx/compose/material3/RadioButtonColors;", "setDefaultRadioButtonColorsCached$material3_release", "(Landroidx/compose/material3/RadioButtonColors;)V", "Landroidx/compose/material3/SegmentedButtonColors;", "defaultSegmentedButtonColorsCached", "Landroidx/compose/material3/SegmentedButtonColors;", "getDefaultSegmentedButtonColorsCached$material3_release", "()Landroidx/compose/material3/SegmentedButtonColors;", "setDefaultSegmentedButtonColorsCached$material3_release", "(Landroidx/compose/material3/SegmentedButtonColors;)V", "getDefaultSegmentedButtonColorsCached$material3_release$annotations", "Landroidx/compose/material3/SliderColors;", "defaultSliderColorsCached", "Landroidx/compose/material3/SliderColors;", "getDefaultSliderColorsCached$material3_release", "()Landroidx/compose/material3/SliderColors;", "setDefaultSliderColorsCached$material3_release", "(Landroidx/compose/material3/SliderColors;)V", "Landroidx/compose/material3/SwitchColors;", "defaultSwitchColorsCached", "Landroidx/compose/material3/SwitchColors;", "getDefaultSwitchColorsCached$material3_release", "()Landroidx/compose/material3/SwitchColors;", "setDefaultSwitchColorsCached$material3_release", "(Landroidx/compose/material3/SwitchColors;)V", "Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColorsCached", "Landroidx/compose/material3/TextFieldColors;", "getDefaultOutlinedTextFieldColorsCached$material3_release", "()Landroidx/compose/material3/TextFieldColors;", "setDefaultOutlinedTextFieldColorsCached$material3_release", "(Landroidx/compose/material3/TextFieldColors;)V", "defaultTextFieldColorsCached", "getDefaultTextFieldColorsCached$material3_release", "setDefaultTextFieldColorsCached$material3_release", "Landroidx/compose/material3/TimePickerColors;", "defaultTimePickerColorsCached", "Landroidx/compose/material3/TimePickerColors;", "getDefaultTimePickerColorsCached$material3_release", "()Landroidx/compose/material3/TimePickerColors;", "setDefaultTimePickerColorsCached$material3_release", "(Landroidx/compose/material3/TimePickerColors;)V", "getDefaultTimePickerColorsCached$material3_release$annotations", "Landroidx/compose/material3/RichTooltipColors;", "defaultRichTooltipColorsCached", "Landroidx/compose/material3/RichTooltipColors;", "getDefaultRichTooltipColorsCached$material3_release", "()Landroidx/compose/material3/RichTooltipColors;", "setDefaultRichTooltipColorsCached$material3_release", "(Landroidx/compose/material3/RichTooltipColors;)V", "getDefaultRichTooltipColorsCached$material3_release$annotations", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorScheme {
    private final long background;
    private ChipColors defaultAssistChipColorsCached;
    private ButtonColors defaultButtonColorsCached;
    private CardColors defaultCardColorsCached;
    private TopAppBarColors defaultCenterAlignedTopAppBarColorsCached;
    private CheckboxColors defaultCheckboxColorsCached;
    private DatePickerColors defaultDatePickerColorsCached;
    private ChipColors defaultElevatedAssistChipColorsCached;
    private ButtonColors defaultElevatedButtonColorsCached;
    private CardColors defaultElevatedCardColorsCached;
    private SelectableChipColors defaultElevatedFilterChipColorsCached;
    private ChipColors defaultElevatedSuggestionChipColorsCached;
    private NavigationItemColors defaultExpressiveNavigationBarItemColorsCached;
    private IconButtonColors defaultFilledIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledIconToggleButtonColorsCached;
    private ButtonColors defaultFilledTonalButtonColorsCached;
    private IconButtonColors defaultFilledTonalIconButtonColorsCached;
    private IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached;
    private SelectableChipColors defaultFilterChipColorsCached;
    private IconButtonColors defaultIconButtonColorsCached;
    private IconToggleButtonColors defaultIconToggleButtonColorsCached;
    private SelectableChipColors defaultInputChipColorsCached;
    private TopAppBarColors defaultLargeTopAppBarColorsCached;
    private TopAppBarColors defaultMediumTopAppBarColorsCached;
    private MenuItemColors defaultMenuItemColorsCached;
    private NavigationBarItemColors defaultNavigationBarItemColorsCached;
    private NavigationRailItemColors defaultNavigationRailItemColorsCached;
    private ButtonColors defaultOutlinedButtonColorsCached;
    private CardColors defaultOutlinedCardColorsCached;
    private IconButtonColors defaultOutlinedIconButtonColorsCached;
    private IconToggleButtonColors defaultOutlinedIconToggleButtonColorsCached;
    private TextFieldColors defaultOutlinedTextFieldColorsCached;
    private RadioButtonColors defaultRadioButtonColorsCached;
    private RichTooltipColors defaultRichTooltipColorsCached;
    private SegmentedButtonColors defaultSegmentedButtonColorsCached;
    private SliderColors defaultSliderColorsCached;
    private ChipColors defaultSuggestionChipColorsCached;
    private SwitchColors defaultSwitchColorsCached;
    private ButtonColors defaultTextButtonColorsCached;
    private TextFieldColors defaultTextFieldColorsCached;
    private TimePickerColors defaultTimePickerColorsCached;
    private TopAppBarColors defaultTopAppBarColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;

    public /* synthetic */ ColorScheme(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40);
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getBackground() {
        return this.background;
    }

    /* renamed from: getDefaultButtonColorsCached$material3_release, reason: from getter */
    public final ButtonColors getDefaultButtonColorsCached() {
        return this.defaultButtonColorsCached;
    }

    /* renamed from: getDefaultCenterAlignedTopAppBarColorsCached$material3_release, reason: from getter */
    public final TopAppBarColors getDefaultCenterAlignedTopAppBarColorsCached() {
        return this.defaultCenterAlignedTopAppBarColorsCached;
    }

    /* renamed from: getDefaultIconButtonColorsCached$material3_release, reason: from getter */
    public final IconButtonColors getDefaultIconButtonColorsCached() {
        return this.defaultIconButtonColorsCached;
    }

    /* renamed from: getDefaultInputChipColorsCached$material3_release, reason: from getter */
    public final SelectableChipColors getDefaultInputChipColorsCached() {
        return this.defaultInputChipColorsCached;
    }

    /* renamed from: getDefaultNavigationBarItemColorsCached$material3_release, reason: from getter */
    public final NavigationBarItemColors getDefaultNavigationBarItemColorsCached() {
        return this.defaultNavigationBarItemColorsCached;
    }

    /* renamed from: getDefaultSwitchColorsCached$material3_release, reason: from getter */
    public final SwitchColors getDefaultSwitchColorsCached() {
        return this.defaultSwitchColorsCached;
    }

    /* renamed from: getDefaultTextButtonColorsCached$material3_release, reason: from getter */
    public final ButtonColors getDefaultTextButtonColorsCached() {
        return this.defaultTextButtonColorsCached;
    }

    /* renamed from: getDefaultTextFieldColorsCached$material3_release, reason: from getter */
    public final TextFieldColors getDefaultTextFieldColorsCached() {
        return this.defaultTextFieldColorsCached;
    }

    /* renamed from: getDefaultTopAppBarColorsCached$material3_release, reason: from getter */
    public final TopAppBarColors getDefaultTopAppBarColorsCached() {
        return this.defaultTopAppBarColorsCached;
    }

    /* renamed from: getError-0d7_KjU, reason: not valid java name and from getter */
    public final long getError() {
        return this.error;
    }

    /* renamed from: getErrorContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getErrorContainer() {
        return this.errorContainer;
    }

    /* renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    /* renamed from: getInversePrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getInversePrimary() {
        return this.inversePrimary;
    }

    /* renamed from: getInverseSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getInverseSurface() {
        return this.inverseSurface;
    }

    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnBackground() {
        return this.onBackground;
    }

    /* renamed from: getOnError-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnError() {
        return this.onError;
    }

    /* renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnErrorContainer() {
        return this.onErrorContainer;
    }

    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnPrimary() {
        return this.onPrimary;
    }

    /* renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSecondary() {
        return this.onSecondary;
    }

    /* renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSurface() {
        return this.onSurface;
    }

    /* renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    /* renamed from: getOnTertiary-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnTertiary() {
        return this.onTertiary;
    }

    /* renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    /* renamed from: getOutline-0d7_KjU, reason: not valid java name and from getter */
    public final long getOutline() {
        return this.outline;
    }

    /* renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getOutlineVariant() {
        return this.outlineVariant;
    }

    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimary() {
        return this.primary;
    }

    /* renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getPrimaryContainer() {
        return this.primaryContainer;
    }

    /* renamed from: getScrim-0d7_KjU, reason: not valid java name and from getter */
    public final long getScrim() {
        return this.scrim;
    }

    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondary() {
        return this.secondary;
    }

    /* renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondaryContainer() {
        return this.secondaryContainer;
    }

    /* renamed from: getSurface-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurface() {
        return this.surface;
    }

    /* renamed from: getSurfaceBright-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceBright() {
        return this.surfaceBright;
    }

    /* renamed from: getSurfaceContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainer() {
        return this.surfaceContainer;
    }

    /* renamed from: getSurfaceContainerHigh-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerHigh() {
        return this.surfaceContainerHigh;
    }

    /* renamed from: getSurfaceContainerHighest-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerHighest() {
        return this.surfaceContainerHighest;
    }

    /* renamed from: getSurfaceContainerLow-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerLow() {
        return this.surfaceContainerLow;
    }

    /* renamed from: getSurfaceContainerLowest-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceContainerLowest() {
        return this.surfaceContainerLowest;
    }

    /* renamed from: getSurfaceDim-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceDim() {
        return this.surfaceDim;
    }

    /* renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceTint() {
        return this.surfaceTint;
    }

    /* renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name and from getter */
    public final long getSurfaceVariant() {
        return this.surfaceVariant;
    }

    /* renamed from: getTertiary-0d7_KjU, reason: not valid java name and from getter */
    public final long getTertiary() {
        return this.tertiary;
    }

    /* renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name and from getter */
    public final long getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public final void setDefaultButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultButtonColorsCached = buttonColors;
    }

    public final void setDefaultCenterAlignedTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultCenterAlignedTopAppBarColorsCached = topAppBarColors;
    }

    public final void setDefaultIconButtonColorsCached$material3_release(IconButtonColors iconButtonColors) {
        this.defaultIconButtonColorsCached = iconButtonColors;
    }

    public final void setDefaultInputChipColorsCached$material3_release(SelectableChipColors selectableChipColors) {
        this.defaultInputChipColorsCached = selectableChipColors;
    }

    public final void setDefaultNavigationBarItemColorsCached$material3_release(NavigationBarItemColors navigationBarItemColors) {
        this.defaultNavigationBarItemColorsCached = navigationBarItemColors;
    }

    public final void setDefaultSwitchColorsCached$material3_release(SwitchColors switchColors) {
        this.defaultSwitchColorsCached = switchColors;
    }

    public final void setDefaultTextButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultTextButtonColorsCached = buttonColors;
    }

    public final void setDefaultTextFieldColorsCached$material3_release(TextFieldColors textFieldColors) {
        this.defaultTextFieldColorsCached = textFieldColors;
    }

    public final void setDefaultTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultTopAppBarColorsCached = topAppBarColors;
    }

    public String toString() {
        return "ColorScheme(primary=" + ((Object) Color.m1494toStringimpl(this.primary)) + "onPrimary=" + ((Object) Color.m1494toStringimpl(this.onPrimary)) + "primaryContainer=" + ((Object) Color.m1494toStringimpl(this.primaryContainer)) + "onPrimaryContainer=" + ((Object) Color.m1494toStringimpl(this.onPrimaryContainer)) + "inversePrimary=" + ((Object) Color.m1494toStringimpl(this.inversePrimary)) + "secondary=" + ((Object) Color.m1494toStringimpl(this.secondary)) + "onSecondary=" + ((Object) Color.m1494toStringimpl(this.onSecondary)) + "secondaryContainer=" + ((Object) Color.m1494toStringimpl(this.secondaryContainer)) + "onSecondaryContainer=" + ((Object) Color.m1494toStringimpl(this.onSecondaryContainer)) + "tertiary=" + ((Object) Color.m1494toStringimpl(this.tertiary)) + "onTertiary=" + ((Object) Color.m1494toStringimpl(this.onTertiary)) + "tertiaryContainer=" + ((Object) Color.m1494toStringimpl(this.tertiaryContainer)) + "onTertiaryContainer=" + ((Object) Color.m1494toStringimpl(this.onTertiaryContainer)) + "background=" + ((Object) Color.m1494toStringimpl(this.background)) + "onBackground=" + ((Object) Color.m1494toStringimpl(this.onBackground)) + "surface=" + ((Object) Color.m1494toStringimpl(this.surface)) + "onSurface=" + ((Object) Color.m1494toStringimpl(this.onSurface)) + "surfaceVariant=" + ((Object) Color.m1494toStringimpl(this.surfaceVariant)) + "onSurfaceVariant=" + ((Object) Color.m1494toStringimpl(this.onSurfaceVariant)) + "surfaceTint=" + ((Object) Color.m1494toStringimpl(this.surfaceTint)) + "inverseSurface=" + ((Object) Color.m1494toStringimpl(this.inverseSurface)) + "inverseOnSurface=" + ((Object) Color.m1494toStringimpl(this.inverseOnSurface)) + "error=" + ((Object) Color.m1494toStringimpl(this.error)) + "onError=" + ((Object) Color.m1494toStringimpl(this.onError)) + "errorContainer=" + ((Object) Color.m1494toStringimpl(this.errorContainer)) + "onErrorContainer=" + ((Object) Color.m1494toStringimpl(this.onErrorContainer)) + "outline=" + ((Object) Color.m1494toStringimpl(this.outline)) + "outlineVariant=" + ((Object) Color.m1494toStringimpl(this.outlineVariant)) + "scrim=" + ((Object) Color.m1494toStringimpl(this.scrim)) + "surfaceBright=" + ((Object) Color.m1494toStringimpl(this.surfaceBright)) + "surfaceDim=" + ((Object) Color.m1494toStringimpl(this.surfaceDim)) + "surfaceContainer=" + ((Object) Color.m1494toStringimpl(this.surfaceContainer)) + "surfaceContainerHigh=" + ((Object) Color.m1494toStringimpl(this.surfaceContainerHigh)) + "surfaceContainerHighest=" + ((Object) Color.m1494toStringimpl(this.surfaceContainerHighest)) + "surfaceContainerLow=" + ((Object) Color.m1494toStringimpl(this.surfaceContainerLow)) + "surfaceContainerLowest=" + ((Object) Color.m1494toStringimpl(this.surfaceContainerLowest)) + ')';
    }

    private ColorScheme(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40) {
        this.primary = j5;
        this.onPrimary = j6;
        this.primaryContainer = j7;
        this.onPrimaryContainer = j8;
        this.inversePrimary = j9;
        this.secondary = j10;
        this.onSecondary = j11;
        this.secondaryContainer = j12;
        this.onSecondaryContainer = j13;
        this.tertiary = j14;
        this.onTertiary = j15;
        this.tertiaryContainer = j16;
        this.onTertiaryContainer = j17;
        this.background = j18;
        this.onBackground = j19;
        this.surface = j20;
        this.onSurface = j21;
        this.surfaceVariant = j22;
        this.onSurfaceVariant = j23;
        this.surfaceTint = j24;
        this.inverseSurface = j25;
        this.inverseOnSurface = j26;
        this.error = j27;
        this.onError = j28;
        this.errorContainer = j29;
        this.onErrorContainer = j30;
        this.outline = j31;
        this.outlineVariant = j32;
        this.scrim = j33;
        this.surfaceBright = j34;
        this.surfaceDim = j35;
        this.surfaceContainer = j36;
        this.surfaceContainerHigh = j37;
        this.surfaceContainerHighest = j38;
        this.surfaceContainerLow = j39;
        this.surfaceContainerLowest = j40;
    }
}
