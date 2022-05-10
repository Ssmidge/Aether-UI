package net.prismclient.aether.ui.style

import net.prismclient.aether.ui.animation.UIAnimation
import net.prismclient.aether.ui.component.UIComponent
import net.prismclient.aether.ui.renderer.UIRenderer
import net.prismclient.aether.ui.renderer.builder.UIRendererDSL
import net.prismclient.aether.ui.style.util.UIFontFamily

object UIProvider {
    lateinit var renderer: UIRenderer

    val styles = HashMap<String, UIStyleSheet>()
    val fonts = HashMap<String, UIFontFamily>()
    val animations = HashMap<String, UIAnimation<*>>()
    val activeAnimations = ArrayList<UIAnimation<*>>()

    /**
     * Initializes the UIProvider
     *
     * @param renderer The rendering api used to rendering content onto the screen
     */
    fun initialize(renderer: UIRenderer) {
        this.renderer = renderer
        UIRendererDSL(renderer)
    }

    /**
     * Adds a [UIFontFamily] into the fonts arraylist. If fonts are loaded by a
     * string instead of a UIFontType, it will automatically be loaded into memory.
     * If it was loaded with a UIFontType, load must be explicitly called.
     *
     * @see UIFontFamily
     */
    fun addFont(fontFamily: UIFontFamily) {
        if (fonts[fontFamily.familyName] == null) {
            fonts[fontFamily.familyName] = fontFamily
        }
    }

    fun addStyle(style: UIStyleSheet) {
        styles[style.name] = style
    }

    @JvmOverloads
    fun getStyle(styleName: String, original: Boolean = false): UIStyleSheet {
        val style = styles[styleName] ?: throw NullPointerException("Not found")
        return if (original) style else style.copy()
    }

    fun registerAnimation(animation: UIAnimation<*>) {
        animations[animation.name] = animation
    }

    // TODO: Priorities
    fun dispatchAnimation(animationName: String, component: UIComponent<*>) {
        component.animation = animations[animationName]!!.copy()
        component.animation!!.start(component)
        activeAnimations.add(component.animation!!)
    }
}