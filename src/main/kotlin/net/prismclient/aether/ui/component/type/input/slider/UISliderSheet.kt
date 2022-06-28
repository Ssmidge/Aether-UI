package net.prismclient.aether.ui.component.type.input.slider

import net.prismclient.aether.ui.style.UIStyleSheet
import net.prismclient.aether.ui.util.extensions.px
import net.prismclient.aether.ui.util.extensions.rel
import net.prismclient.aether.ui.util.radiusOf

class UISliderSheet(name: String) : UIStyleSheet(name) {
    var sliderControl: UISliderShape = UISliderShape().also {
        it.color = -1
        it.width = px(40)
        it.height = rel(1)
        it.radius = radiusOf(2.5f)
    }
}