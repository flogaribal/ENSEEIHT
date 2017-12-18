from monosat import *

bv1 = BitVector(4) # vecteur de 4 bits
bv2 = BitVector(4)
bv3 = BitVector(4)
bv4 = BitVector(4)

Assert(bv1 == 0)
Assert(bv2 == 2)
Assert(bv3 == 6)
Assert(Not(Equal(bv1, bv4)))

result = Solve()

if result:
    print("SAT")
    print("bv1 = {0}".format(bv1.value()))
    print("bv2 = {0}".format(bv2.value()))
    print("bv3 = {0}".format(bv3.value()))
    print("bv4 = {0}".format(bv4.value()))
else:
    print("UNSAT")
