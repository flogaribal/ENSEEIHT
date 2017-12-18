"""A simple module to pretty-print 9x9 Sudoku grids. There are
currently two pretty-printers: one for console, one for Tk.
"""

from tkinter import Frame
from tkinter import Label

N = 9


class Sudoku_Viewer(Frame):
    """
    A simple class to display a Sudoku grid as a Tk frame.
    """
    def __init__(self, vars):
        """
        Create a Tk grid to represent a Sudoku grid.

        Keyword Arguments:
        vars -- a dictionary containing the Sudoku values. The keys are tuples
                (i, j) where i is the row and j the column of the cell, the
                values are strings representing the values.
        """
        self.vars = vars
        Frame.__init__(self)
        self.grid()
        self._create_labels()

    def _create_labels(self):
        for row in range(N):
            for col in range(N):
                Label(self,
                      text=self.vars[(row, col)],
                      bg="white",
                      width=2,
                      fg="black",
                      relief="solid",
                      borderwidth=1,
                      font=("Helvetica", 18)).grid(row=row, column=col)


def console_pp(vars):
    """
    A simple Sudoku pretty-printer for console.

    Keyword Arguments:
    vars -- a dictionary containing the Sudoku values. The keys are tuples
            (i, j) where i is the row and j the column of the cell, the values
            are strings representing the values.
    """
    for row in range(0, N):
        for col in range(0, N):
            print(vars[(row, col)], end=" ")
        print()


def tk_pp(vars):
    """
    A simple Sudoku pretty-printer for Tk.

    Keyword Arguments:
    vars -- a dictionary containing the Sudoku values. The keys are tuples
            (i, j) where i is the row and j the column of the cell, the values
            are strings representing the values.
    """
    main = Sudoku_Viewer(vars)
    main.master.title('Sudoku')
    main.mainloop()
