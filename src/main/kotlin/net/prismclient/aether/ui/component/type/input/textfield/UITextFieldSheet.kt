package net.prismclient.aether.ui.component.type.input.textfield

import net.prismclient.aether.ui.component.type.input.textfield.caret.UICaret
import net.prismclient.aether.ui.style.UIStyleSheet
import net.prismclient.aether.ui.util.UIColor
import net.prismclient.aether.ui.util.extensions.*

/**
 * The corresponding style sheet for text fields. It contains basic styling information
 * such as the placeholder color. It also contains caret controls.
 *
 * @author sen
 * @since 5/11/2022
 */
class UITextFieldSheet(name: String) : UIStyleSheet(name) {
    /**
     * The caret shape which is drawn to display the caret.
     */
    var caret: UICaret = UICaret().apply {
        this.width = px(2)
        this.height = em(1)
    }

    /**
     * The rate at which the caret blinks at. 0 = never
     */
    var blinkRate: Long = 500L

    /**
     * The color of the text when the text field is not focused
     */
    var placeholderColor: UIColor? = null

    /**
     * Creates a caret DSL block.
     */
    inline fun caret(block: UICaret.() -> Unit) {
        block.invoke(caret)
    }

    override fun copy(): UITextFieldSheet = UITextFieldSheet(name).also {
        it.apply(this)
        it.caret = caret.copy()
        it.blinkRate = blinkRate
        it.placeholderColor = placeholderColor
    }
}