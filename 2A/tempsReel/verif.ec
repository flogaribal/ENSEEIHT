node verif
  (X: bool)
returns
  (Y: bool);

var
  V36_X: bool;
  V47_X: bool;

let
  Y = (((X -> (X and (not (pre X)))) = ((not V36_X) -> ((not V36_X) and (pre 
  V36_X)))) and ((V47_X -> (V47_X and (not (pre V47_X)))) = ((not X) -> ((not X
  ) and (pre X)))));
  V36_X = (not X);
  V47_X = (not X);
tel

