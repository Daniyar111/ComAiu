package com.comaiu.daniyar.comalatoomobile.ui;

public interface LifeCycle<V> {

    void bind(V view);

    void unbind();
}
