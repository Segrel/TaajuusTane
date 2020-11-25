import sys
import numpy as np
import matplotlib.pyplot as plt

mittaukset = np.genfromtxt(sys.argv[1], delimiter=",", names=True)
plt.plot(mittaukset["pituus"], mittaukset["mediaanikesto"], marker='o')
plt.xlabel("Syötteen pituus (näytettä)")
plt.ylabel("Muunnoksen mediaanikesto (ms)")
plt.show()
