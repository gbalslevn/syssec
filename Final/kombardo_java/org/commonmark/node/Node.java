package org.commonmark.node;

import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public abstract class Node {
    private Node parent = null;
    private Node firstChild = null;
    private Node lastChild = null;
    private Node prev = null;
    private Node next = null;

    public abstract void accept(Visitor visitor);

    public void appendChild(Node node) {
        node.unlink();
        node.setParent(this);
        Node node2 = this.lastChild;
        if (node2 == null) {
            this.firstChild = node;
            this.lastChild = node;
        } else {
            node2.next = node;
            node.prev = node2;
            this.lastChild = node;
        }
    }

    public Node getFirstChild() {
        return this.firstChild;
    }

    public Node getLastChild() {
        return this.lastChild;
    }

    public Node getNext() {
        return this.next;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getPrevious() {
        return this.prev;
    }

    public void insertAfter(Node node) {
        node.unlink();
        Node node2 = this.next;
        node.next = node2;
        if (node2 != null) {
            node2.prev = node;
        }
        node.prev = this;
        this.next = node;
        Node node3 = this.parent;
        node.parent = node3;
        if (node.next == null) {
            node3.lastChild = node;
        }
    }

    public void insertBefore(Node node) {
        node.unlink();
        Node node2 = this.prev;
        node.prev = node2;
        if (node2 != null) {
            node2.next = node;
        }
        node.next = this;
        this.prev = node;
        Node node3 = this.parent;
        node.parent = node3;
        if (node.prev == null) {
            node3.firstChild = node;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setParent(Node node) {
        this.parent = node;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + toStringAttributes() + "}";
    }

    protected String toStringAttributes() {
        return BuildConfig.FLAVOR;
    }

    public void unlink() {
        Node node = this.prev;
        if (node != null) {
            node.next = this.next;
        } else {
            Node node2 = this.parent;
            if (node2 != null) {
                node2.firstChild = this.next;
            }
        }
        Node node3 = this.next;
        if (node3 != null) {
            node3.prev = node;
        } else {
            Node node4 = this.parent;
            if (node4 != null) {
                node4.lastChild = node;
            }
        }
        this.parent = null;
        this.next = null;
        this.prev = null;
    }
}
