import sys
from monosat import *


###### DEF DISPLAY FUNCTION

def print_color_map():
	from colorama import Fore, Back, Style
	
	for i in range(GRID_SIZE):
		print( "\ni:%2d | " % i, end="" )
		
		for j in range(GRID_SIZE):
			node = nodes[i,j]
			# background color
			color_idx = color[node].value()
			bcolor = Back.RESET
		
			if color_idx == 0:
				bcolor = Back.RED
		
			elif color_idx == 1:
				bcolor = Back.GREEN
		
			elif color_idx == 2:
				bcolor = Back.BLUE
		
			else : # color_idx == 3
				bcolor = Back.YELLOW
		
			print( Fore.BLACK + bcolor + " " , end="" )
		
		print( Style.RESET_ALL, end="" )





####### CONST
RED 		= 0
GREEN 	= 1
BLUE 		= 2
YELLOW 	= 3

####### BOOT ARGUMENTS 



# Check if there is a minimum length given for the path
if len(sys.argv) != 5:
	print ("Usage error: maze-fgaribal <grid_size> <col_entry> <col_exit> <min_path_length>")
	print ("grid_size: int without constraints")
	print ("col_entry: int between 0 and grid_size-1")
	print ("col_exit: int between 0 and grid_size-1")
	print ("min_path_length: ")
	
	sys.exit(1)

else: 
	# Get CLI arguments
	GRID_SIZE 			= int(sys.argv[1]) 
	COL_ENTRY 			= int(sys.argv[2]) 
	COL_EXIT 				= int(sys.argv[3]) 
	MIN_PATH_LENGTH = int(sys.argv[4])

assert(0 <= COL_ENTRY and COL_ENTRY <= GRID_SIZE-1)
assert(0 <= COL_EXIT and COL_EXIT <= GRID_SIZE-1)
assert(0 <= MIN_PATH_LENGTH and MIN_PATH_LENGTH <= GRID_SIZE**2)

print("The grid size will be " + str(GRID_SIZE))
print("The maze entrance will be in (0," + str(COL_ENTRY) + ")")
print("The maze exit will be in (" + str(GRID_SIZE-1) + ", " + str(COL_EXIT) + ")")
print("Le chemin sera d'une longueur minimum de " + str(MIN_PATH_LENGTH))


####### INIT VARIABLES
graph = Graph()

nodes = {(i, j): graph.addNode() for i in range(GRID_SIZE) for j in range(GRID_SIZE)}

color = {nodes[i,j]: BitVector(2) for i in range(GRID_SIZE) for j in range(GRID_SIZE)}

edges = dict()

for i in range(GRID_SIZE):
	for j in range(GRID_SIZE):
		n 			= nodes[i,j]
		color_n = color[n]


		if i != GRID_SIZE-1:
			### Edges between current node and south node
			n_south = nodes[i+1,j]
			
			edge_to_south 	= graph.addEdge(n, n_south, 1)
			edge_from_south = graph.addEdge(n_south, n, 1)

			edges[n,n_south] = edge_to_south
			edges[n_south,n] = edge_from_south
		
			# Color constraints: Respect the color order

				# SOUTH
			color_south = color[n_south]
				# To south
			color_condition_to_south = Or(And(color_n == 0, color_south == 1),\
																		And(color_n == 1, color_south == 2),\
																		And(color_n == 2, color_south == 3),\
																		And(color_n == 3, color_south == 0))
			Assert(Implies(edge_to_south, color_condition_to_south))

				# From south
			color_condition_from_south = Or(And(color_south == 0, color_n == 1),\
																			And(color_south == 1, color_n == 2),\
																			And(color_south == 2, color_n == 3),\
																			And(color_south == 3, color_n == 0))
			Assert(Implies(edge_from_south, color_condition_from_south))

			# Color constraint: Not the same color between two nodes
			Assert(Not(Equal(color[n], color[n_south])))



		if j != GRID_SIZE-1:
			### Edges between current node and east node
			n_east = nodes[i,j+1]

			edge_to_east 		= graph.addEdge(n, n_east, 1)
			edge_from_east 	= graph.addEdge(n_east, n, 1)

			edges[n,n_east] = edge_to_east
			edges[n_east,n] = edge_from_east

			# Color constraints: Respect the color order
				# EAST
			color_east = color[n_east]
				# To east
			color_condition_to_east = Or(	And(color_n == 0, color_east == 1),\
																		And(color_n == 1, color_east == 2),\
																		And(color_n == 2, color_east == 3),\
																		And(color_n == 3, color_east == 0))
			Assert(Implies(edge_to_east, color_condition_to_east))

				# From east
			color_condition_from_east = Or(	And(color_east == 0, color_n == 1),\
																			And(color_east == 1, color_n == 2),\
																			And(color_east == 2, color_n == 3),\
																			And(color_east == 3, color_n == 0))
			Assert(Implies(edge_from_east, color_condition_from_east))

			
			# Color constraint: Not the same color between two nodes
			Assert(Not(Equal(color[n], color[n_east])))




# ENTRY NODE
entry_node = nodes[0,COL_ENTRY]
color_entry_node = color[entry_node]
Assert(color_entry_node == 0)

# CONSTRAINT PATH BETWEEN ENTRY AND EXIT NODE
exit_node = nodes[GRID_SIZE-1, COL_EXIT]
Assert(graph.reaches(entry_node,exit_node))

# CONSTRAINT MIN PATH LENGTH
Assert(Not(graph.distance_leq(entry_node, exit_node, MIN_PATH_LENGTH)))

# CONSTRAINT ONLY ONE PATH BETWEEN FIRST LINE AND LAST LINE
for j1 in range(GRID_SIZE):
	for j2 in range(GRID_SIZE):
		if j1 != COL_ENTRY:
			n_depart = nodes[0,j1]
			n_arrivee = nodes[GRID_SIZE-1,j2]
			Assert(Not(graph.reaches(n_depart, n_arrivee)))




result = Solve()
if result:
	print("SAT")	
	print_color_map()
else:
	print("UNSAT")

# REPONSES 
# Si nous n'avions pas à disposition un prédicat d'atteignabilité il nous aurait fallu exprimer 
# tous les chemins possibles en un union de toutes les intersection des arrêtes à prendre pour arriver 
# du départ à l'arrivée.
# Le nombre de clause à générer serait très grand car il peut y avoir de très nombreuses possibilités. 
#	  
# Ex \/(/\(e1,e2,e3))
#       