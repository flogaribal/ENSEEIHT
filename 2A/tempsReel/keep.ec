node keep
  (X: bool;
  RAZ: bool)
returns
  (Y: bool);

let
  Y = (false -> (X or ((pre Y) and (not RAZ))));
tel

