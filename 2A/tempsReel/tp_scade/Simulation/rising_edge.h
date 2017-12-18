/* $*************** KCG Version 6.1.3 (build i6) ****************
** Command: s2c613 -config G:/Documents/2A/S8/tp_scade/Simulation\kcg_s2c_config.txt
** Generation date: 2017-02-15T10:42:58
*************************************************************$ */
#ifndef _rising_edge_H_
#define _rising_edge_H_

#include "kcg_types.h"

/* ========================  input structure  ====================== */
typedef struct { kcg_bool /* rising_edge::x */ x; } inC_rising_edge;

/* ========================  context type  ========================= */
typedef struct {
  /* ---------------------------  outputs  --------------------------- */
  kcg_bool /* rising_edge::y */ y;
  /* -----------------------  no local probes  ----------------------- */
  /* -------------------- initialization variables  ------------------ */
  kcg_bool init;
  /* ----------------------- local memories  ------------------------- */
  kcg_bool /* rising_edge::_L6 */ _L6;
  /* -------------------- no sub nodes' contexts  -------------------- */
  /* ----------------- no clocks of observable data ------------------ */
  /* -------------------- (-debug) no assertions  -------------------- */
  /* ------------------- (-debug) local variables -------------------- */
  kcg_bool /* rising_edge::_L2 */ _L2;
  kcg_bool /* rising_edge::_L3 */ _L3;
  kcg_bool /* rising_edge::_L4 */ _L4;
  kcg_bool /* rising_edge::_L5 */ _L5;
} outC_rising_edge;

/* ===========  node initialization and cycle functions  =========== */
/* rising_edge */
extern void rising_edge(inC_rising_edge *inC, outC_rising_edge *outC);

extern void rising_edge_reset(outC_rising_edge *outC);

#endif /* _rising_edge_H_ */
/* $*************** KCG Version 6.1.3 (build i6) ****************
** rising_edge.h
** Generation date: 2017-02-15T10:42:58
*************************************************************$ */

