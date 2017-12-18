node metronome_bool
  (r1: bool;
  r2: bool;
  r3: bool;
  r4: bool)
returns
  (tic: bool;
  tac: bool;
  toc: bool;
  tut: bool);

let
  tic = (((r1 or (r2 and (pre tac))) or (r3 and (pre toc))) or (r4 and (pre tut
  )));
  tac = ((not r1) and (pre tic));
  toc = (((not r1) and (not r2)) and (pre tac));
  tut = ((((not r1) and (not r2)) and (not r3)) and (pre toc));
tel

