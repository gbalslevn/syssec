package io.noties.markwon.image.destination;

/* loaded from: classes2.dex */
public abstract class ImageDestinationProcessor {

    /* loaded from: classes2.dex */
    private static class NoOp extends ImageDestinationProcessor {
        private NoOp() {
        }

        @Override // io.noties.markwon.image.destination.ImageDestinationProcessor
        public String process(String str) {
            return str;
        }
    }

    public static ImageDestinationProcessor noOp() {
        return new NoOp();
    }

    public abstract String process(String str);
}
