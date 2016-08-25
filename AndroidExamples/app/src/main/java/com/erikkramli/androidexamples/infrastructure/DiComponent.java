package com.erikkramli.androidexamples.infrastructure;

public interface DiComponent<TARGET> {
    void satisfy(TARGET target);
}
