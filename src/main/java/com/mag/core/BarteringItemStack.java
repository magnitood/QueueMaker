package com.mag.core;

import com.mag.core.BarteringItems;
import lombok.Getter;

/**
 * Wrapper for BarteringItems for a specific number of times
 */
public class BarteringItemStack {
    @Getter private final BarteringItems barteringItems;
    @Getter final int count;

    public BarteringItemStack(BarteringItems barteringItems, int count) {
        this.barteringItems = barteringItems;
        this.count = count;
    }
}
