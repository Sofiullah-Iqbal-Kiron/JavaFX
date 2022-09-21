from manim import *

import numpy as np


class myScene(Scene):
	def construct(self):
		a = Text('', fill_opacity=1.0, color='null', font_size=1, font='Arial Rounded MT Bold', weight='MEDIUM')
		self.add(a)