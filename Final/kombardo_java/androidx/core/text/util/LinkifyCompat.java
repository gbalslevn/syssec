package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import androidx.core.text.util.LinkifyCompat;
import androidx.core.util.PatternsCompat;
import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class LinkifyCompat {
    private static final String[] EMPTY_STRING = new String[0];
    private static final Comparator<LinkSpec> COMPARATOR = new Comparator() { // from class: androidx.core.text.util.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int lambda$static$0;
            lambda$static$0 = LinkifyCompat.lambda$static$0((LinkifyCompat.LinkSpec) obj, (LinkifyCompat.LinkSpec) obj2);
            return lambda$static$0;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    public static boolean addLinks(Spannable spannable, int i5) {
        if (shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, i5);
        }
        if (i5 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i5 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i5 & 1) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i5 & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i5 & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.frameworkAddedSpan == null) {
                applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
            }
        }
        return true;
    }

    private static void applyLink(String str, int i5, int i6, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i5, i6, 33);
    }

    private static String findAddress(String str) {
        return Build.VERSION.SDK_INT >= 28 ? WebView.findAddress(str) : FindAddress.findAddress(str);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                if (group != null) {
                    LinkSpec linkSpec = new LinkSpec();
                    linkSpec.url = makeUrl(group, strArr, matcher, transformFilter);
                    linkSpec.start = start;
                    linkSpec.end = end;
                    arrayList.add(linkSpec);
                }
            }
        }
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int indexOf;
        String obj = spannable.toString();
        int i5 = 0;
        while (true) {
            try {
                String findAddress = findAddress(obj);
                if (findAddress != null && (indexOf = obj.indexOf(findAddress)) >= 0) {
                    LinkSpec linkSpec = new LinkSpec();
                    int length = findAddress.length() + indexOf;
                    linkSpec.start = indexOf + i5;
                    i5 += length;
                    linkSpec.end = i5;
                    obj = obj.substring(length);
                    try {
                        linkSpec.url = "geo:0,0?q=" + URLEncoder.encode(findAddress, Constants.ENCODING);
                        arrayList.add(linkSpec);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(LinkSpec linkSpec, LinkSpec linkSpec2) {
        int i5 = linkSpec.start;
        int i6 = linkSpec2.start;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        return Integer.compare(linkSpec2.end, linkSpec.end);
    }

    private static String makeUrl(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        boolean z5;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z5 = false;
                break;
            }
            String str2 = strArr[i5];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z5 = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i5++;
            }
        }
        if (z5 || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i5;
        int i6 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.frameworkAddedSpan = uRLSpan;
            linkSpec.start = spannable.getSpanStart(uRLSpan);
            linkSpec.end = spannable.getSpanEnd(uRLSpan);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i6 < size - 1) {
            LinkSpec linkSpec2 = arrayList.get(i6);
            int i7 = i6 + 1;
            LinkSpec linkSpec3 = arrayList.get(i7);
            int i8 = linkSpec2.start;
            int i9 = linkSpec3.start;
            if (i8 <= i9 && (i5 = linkSpec2.end) > i9) {
                int i10 = linkSpec3.end;
                int i11 = (i10 > i5 && i5 - i8 <= i10 - i9) ? i5 - i8 < i10 - i9 ? i6 : -1 : i7;
                if (i11 != -1) {
                    Object obj = arrayList.get(i11).frameworkAddedSpan;
                    if (obj != null) {
                        spannable.removeSpan(obj);
                    }
                    arrayList.remove(i11);
                    size--;
                }
            }
            i6 = i7;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
