node falling_edge
  (X: bool)
returns
  (Y: bool);

let
  Y = ((not X) -> ((not X) and (pre X)));
tel

