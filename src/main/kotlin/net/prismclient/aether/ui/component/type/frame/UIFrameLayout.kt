package net.prismclient.aether.ui.component.type.frame

import net.prismclient.aether.ui.component.type.layout.UIFrame
import net.prismclient.aether.ui.component.type.layout.UIFrameSheet
import net.prismclient.aether.ui.component.util.interfaces.UILayout

/**
 * [UIFrameLayout] extends [UIFrame], and implements [UILayout]. It is an abstract class which all layouts extend. Most
 * layouts will extend the [UIContainer] class as it has scrollbars, however, certain layouts may extend this class instead.
 *
 * @author sen
 * @since 1.3
 */
abstract class UIFrameLayout<T : UIFrameSheet> : UIFrame<T>(), UILayout {
    override fun update() {
        super.update()
        updateLayout()
    }
}