---- MODULE MC ----
EXTENDS run_tas_pile, TLC

\* CONSTANT definitions @modelParameterConstants:0D
const_149552979285910000 == 
{ "a", "b", "c", "d" }
----

\* CONSTANT definitions @modelParameterConstants:1N
const_149552979286911000 == 
5
----

\* SPECIFICATION definition @modelBehaviorSpec:0
spec_149552979287912000 ==
Spec
----
\* PROPERTY definition @modelCorrectnessProperties:0
prop_149552979288913000 ==
RaffinementOk
----
=============================================================================
\* Modification History
\* Created Tue May 23 10:56:32 CEST 2017 by fgaribal
