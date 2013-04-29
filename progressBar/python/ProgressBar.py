# coding: utf-8

import sys
import math

class ProgressBar(object):
	def __init__ (self, capacity, size):
		"""
		Initialize the progress bar.
		capacity: maximum capacity of bar, e.g., what is 100%
		size: length of the bar, e.g., how many characters it's made up of
		"""
		self._capacity = capacity
		self._size = size
		self.update(0)

	def update (self, value):
		"""
		update the progress bar with a new value.
		value: updated progress
		"""
		marks = math.floor((value/self._capacity) * self._size)
		line = "["
		line += "#" * marks
		line += " " * (self._size - marks)
		line += "] " + str(value) + "/" + str(self._capacity) + "\r"
		sys.stdout.write(line)

	def finish (self):
		"""
		puts the cursor on a new line; call when done with updating the bar
		"""
		print()
