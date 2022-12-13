import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

data = pd.DataFrame(np.random.randn(1000, 4), columns=list("ABCD"))
data = data.cumsum()

ax = data.plot.scatter(x='A', y='B', color='Blue', label='class 1')
data.plot.scatter(x='C', y='D', color='Green', label='class 2', ax=ax)
plt.show()
