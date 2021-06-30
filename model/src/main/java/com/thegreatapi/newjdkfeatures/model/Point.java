package com.thegreatapi.newjdkfeatures.model;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@ParametersAreNonnullByDefault
public final class Point {

    @Nonnull
    private final Integer x;

    @Nonnull
    private final Integer y;

    public Point(Integer x, Integer y) {
        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
    }

    @Nonnull
    @SuppressWarnings("unused")
    public Integer getX() {
        return x;
    }

    @Nonnull
    @SuppressWarnings("unused")
    public Integer getY() {
        return y;
    }
}