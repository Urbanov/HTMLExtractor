package edu.pw.htmlextractor.app;

import com.google.common.collect.ImmutableSet;
import java.util.*;

public class Filter extends Observable {
    private ImmutableSet<String> tags;
    private ImmutableSet<String> attributes;
    private boolean enabled;

    public Filter() {
        this.tags = ImmutableSet.of("");
        this.attributes = ImmutableSet.of("");
        enabled = false;
    }

    public void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            super.setChanged();
        }
        this.notifyObservers();
    }

    public void setFilterData(ImmutableSet<String> tags, ImmutableSet<String> attributes) {
        if (!this.tags.equals(tags)) {
            this.tags = tags;
            super.setChanged();
        }
        if (!this.attributes.equals(attributes)) {
            this.attributes = attributes;
            super.setChanged();
        }
        this.notifyObservers();
    }

    public ImmutableSet<String> getTags() {
        return tags;
    }

    public ImmutableSet<String> getAttributes() {
        return attributes;
    }

    public boolean checkTag(String tag) {
        return !enabled || tags.contains(tag);
    }

    public boolean checkAttribute(String attribute) {
        return !enabled || attributes.contains(attribute);
    }
}
