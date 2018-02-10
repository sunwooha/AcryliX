package com.defano.jmonet.canvas;

import com.defano.jmonet.canvas.observable.ChangeSetObserver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents one or more changes that should be applied to the canvas atomically.
 *
 * This is useful for "packaging" multiple changes together. For example, selecting and moving a portion of the canvas
 * is represented by a two-change, {@link ChangeSet}; first, the deletion of the selected image
 * from the canvas, followed by the addition of that selected image back to the canvas in its new location.
 */
public class ChangeSet {

    private final List<ChangeSetObserver> observers = new ArrayList<>();
    private final List<BufferedImage> images = new ArrayList<>();
    private final List<AlphaComposite> composites = new ArrayList<>();

    public ChangeSet(BufferedImage image) {
        addChange(image, AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }

    public ChangeSet(BufferedImage image, AlphaComposite composite) {
        addChange(image, composite);
    }

    /**
     * Add a change to this ChangeSet.
     *
     * When producing an image from a ChangeSet, each change image is drawn atop the previous using the
     * {@link AlphaComposite} associated with the change.
     *
     * @param image The image associated with this change.
     * @param composite The compositing mode to use when drawing it.
     */
    public void addChange(BufferedImage image, AlphaComposite composite) {
        images.add(image);
        composites.add(composite);

        fireChangeSetObservers();
    }

    /**
     * The number of changes in this ChangeSet; never less than 1.
     * @return The size of the ChangeSet
     */
    public int size() {
        return images.size();
    }

    /**
     * Gets the image associated with the change at the specified index.
     *
     * @param change The change index, a value between 0 and less than {@link #size()}
     * @return The associated image.
     */
    public BufferedImage getImage(int change) {
        return images.get(change);
    }

    /**
     * Gets the composite mode associated with the change at the specified index.
     *
     * @param change The change index, a value between 0 and less than {@link #size()}
     * @return The associated composite mode.
     */
    public AlphaComposite getComposite(int change) {
        return composites.get(change);
    }

    /**
     * Adds an observer to this ChangeSet to notify listeners of new changes added to it.
     * @param observer The observer to be added.
     */
    public void addChangeSetObserver(ChangeSetObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer of this ChangeSet.
     * @param observer The observer to remove.
     * @return True if the observer exists and was removed; false otherwise.
     */
    public boolean removeChangeSetObserver(ChangeSetObserver observer) {
        return observers.remove(observer);
    }

    /**
     * Gets the size of the image produced by the ChangeSet.
     * @return The dimension of the image.
     */
    public Dimension getImageSize() {
        int width = 0;
        int height = 0;

        for (BufferedImage thisImage : images) {
            if (thisImage.getWidth() > width) {
                width = thisImage.getWidth();
            }

            if (thisImage.getHeight() > height) {
                height = thisImage.getHeight();
            }
        }

        return new Dimension(width, height);
    }

    private void fireChangeSetObservers() {
        for (ChangeSetObserver observer : observers) {
            observer.onChangeSetModified(this);
        }
    }
}
