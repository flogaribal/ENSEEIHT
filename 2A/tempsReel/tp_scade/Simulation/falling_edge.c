/* $*************** KCG Version 6.1.3 (build i6) ****************
** Command: s2c613 -config G:/Documents/2A/S8/tp_scade/Simulation\kcg_s2c_config.txt
** Generation date: 2017-02-15T10:57:38
*************************************************************$ */

#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "falling_edge.h"

void falling_edge_reset(outC_falling_edge *outC)
{
  outC->init = kcg_true;
}

/* falling_edge */
void falling_edge(inC_falling_edge *inC, outC_falling_edge *outC)
{
  outC->_L3 = outC->_L6;
  outC->_L6 = inC->x;
  outC->_L7 = !outC->_L6;
  outC->_L4 = outC->_L3 & outC->_L7;
  if (outC->init) {
    outC->_L2 = outC->_L7;
  }
  else {
    outC->_L2 = outC->_L4;
  }
  outC->y = outC->_L2;
  outC->init = kcg_false;
}

/* $*************** KCG Version 6.1.3 (build i6) ****************
** falling_edge.c
** Generation date: 2017-02-15T10:57:38
*************************************************************$ */

