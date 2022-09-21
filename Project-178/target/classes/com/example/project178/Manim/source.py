from manim import *

import numpy as np


class myScene(Scene):
	def construct(self):
		l = Text('kiron', fill_opacity=1.0, color='null', font_size=72, font='Segoe UI Emoji', weight='ULTRABOLD')
		self.add(l)