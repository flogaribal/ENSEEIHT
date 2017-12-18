node verif_1
  (X: int)
returns
  (Y: bool);

var
  V47_tic: bool;
  V48_tac: bool;
  V49_toc: bool;
  V50_tut: bool;

let
  Y = (V47_tic and (((not V48_tac) and (not V49_toc)) and (not V50_tut)));
  V47_tic = (((true or (false and (pre V48_tac))) or (false and (pre V49_toc))) 
  or (false and (pre V50_tut)));
  V48_tac = ((not true) and (pre V47_tic));
  V49_toc = (((not true) and (not false)) and (pre V48_tac));
  V50_tut = ((((not true) and (not false)) and (not false)) and (pre V49_toc));
tel

