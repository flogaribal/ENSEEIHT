/* $*************** KCG Version 6.1.3 (build i6) ****************
** Command: s2c613 -config G:/Documents/2A/S8/tp_scade/Simulation\kcg_s2c_config.txt
** Generation date: 2017-02-15T10:42:58
*************************************************************$ */

#include "kcg_consts.h"
#include "kcg_sensors.h"
#include "rising_edge.h"

void rising_edge_reset(outC_rising_edge *outC)
{
  outC->init = kcg_true;
}

/* rising_edge */
void rising_edge(inC_rising_edge *inC, outC_rising_edge *outC)
{
  outC->_L4 = outC->_L6;
  outC->_L6 = inC->x;
  outC->_L3 = !outC->_L4;
  outC->_L2 = outC->_L3 & outC->_L6;
  if (outC->init) {
    outC->_L5 = outC->_L6;
  }
  else {
    outC->_L5 = outC->_L2;
  }
  outC->y = outC->_L5;
  outC->init = kcg_false;
}

/* $*************** KCG Version 6.1.3 (build i6) ****************
** rising_edge.c
** Generation date: 2017-02-15T10:42:58
*************************************************************$ */

