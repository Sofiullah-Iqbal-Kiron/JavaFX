from manim import *

import numpy as np


class myScene(Scene):
	def construct(self):
		a1 = Square(side_length=1.90, color="#4d3399")
		self.add(a1)