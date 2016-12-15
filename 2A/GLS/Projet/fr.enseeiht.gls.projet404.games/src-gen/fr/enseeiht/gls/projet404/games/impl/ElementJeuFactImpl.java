/**
 * generated by Xtext 2.10.0
 */
package fr.enseeiht.gls.projet404.games.impl;

import fr.enseeiht.gls.projet404.games.Condition;
import fr.enseeiht.gls.projet404.games.ElementJeuFact;
import fr.enseeiht.gls.projet404.games.GamesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Jeu Fact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.ElementJeuFactImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.ElementJeuFactImpl#getVisible <em>Visible</em>}</li>
 *   <li>{@link fr.enseeiht.gls.projet404.games.impl.ElementJeuFactImpl#getCond <em>Cond</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementJeuFactImpl extends MinimalEObjectImpl.Container implements ElementJeuFact
{
  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getVisible() <em>Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisible()
   * @generated
   * @ordered
   */
  protected static final int VISIBLE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getVisible() <em>Visible</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVisible()
   * @generated
   * @ordered
   */
  protected int visible = VISIBLE_EDEFAULT;

  /**
   * The cached value of the '{@link #getCond() <em>Cond</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCond()
   * @generated
   * @ordered
   */
  protected EList<Condition> cond;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementJeuFactImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GamesPackage.Literals.ELEMENT_JEU_FACT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GamesPackage.ELEMENT_JEU_FACT__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getVisible()
  {
    return visible;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVisible(int newVisible)
  {
    int oldVisible = visible;
    visible = newVisible;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GamesPackage.ELEMENT_JEU_FACT__VISIBLE, oldVisible, visible));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Condition> getCond()
  {
    if (cond == null)
    {
      cond = new EObjectContainmentEList<Condition>(Condition.class, this, GamesPackage.ELEMENT_JEU_FACT__COND);
    }
    return cond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GamesPackage.ELEMENT_JEU_FACT__COND:
        return ((InternalEList<?>)getCond()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GamesPackage.ELEMENT_JEU_FACT__DESCRIPTION:
        return getDescription();
      case GamesPackage.ELEMENT_JEU_FACT__VISIBLE:
        return getVisible();
      case GamesPackage.ELEMENT_JEU_FACT__COND:
        return getCond();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GamesPackage.ELEMENT_JEU_FACT__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case GamesPackage.ELEMENT_JEU_FACT__VISIBLE:
        setVisible((Integer)newValue);
        return;
      case GamesPackage.ELEMENT_JEU_FACT__COND:
        getCond().clear();
        getCond().addAll((Collection<? extends Condition>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GamesPackage.ELEMENT_JEU_FACT__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case GamesPackage.ELEMENT_JEU_FACT__VISIBLE:
        setVisible(VISIBLE_EDEFAULT);
        return;
      case GamesPackage.ELEMENT_JEU_FACT__COND:
        getCond().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GamesPackage.ELEMENT_JEU_FACT__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case GamesPackage.ELEMENT_JEU_FACT__VISIBLE:
        return visible != VISIBLE_EDEFAULT;
      case GamesPackage.ELEMENT_JEU_FACT__COND:
        return cond != null && !cond.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (description: ");
    result.append(description);
    result.append(", visible: ");
    result.append(visible);
    result.append(')');
    return result.toString();
  }

} //ElementJeuFactImpl
