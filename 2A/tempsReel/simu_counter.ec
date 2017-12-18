node simu_counter
  (RAZ: bool)
returns
  (Top: bool);

var
  V50_cpt: int;

let
  Top = (V50_cpt = 3);
  V50_cpt = (0 -> (if RAZ then 0 else ((pre V50_cpt) + 1)));
tel

