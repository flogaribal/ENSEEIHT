/**
 */
package simplepdl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import simplepdl.Resource;
import simplepdl.SimplepdlPackage;
import simplepdl.UseResources;
import simplepdl.WorkDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Resources</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link simplepdl.impl.UseResourcesImpl#getWeight <em>Weight</em>}</li>
 *   <li>{@link simplepdl.impl.UseResourcesImpl#getUsedResource <em>Used Resource</em>}</li>
 *   <li>{@link simplepdl.impl.UseResourcesImpl#getAssociatedWD <em>Associated WD</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UseResourcesImpl extends MinimalEObjectImpl.Container implements UseResources {
	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final int WEIGHT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected int weight = WEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsedResource() <em>Used Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedResource()
	 * @generated
	 * @ordered
	 */
	protected Resource usedResource;

	/**
	 * The cached value of the '{@link #getAssociatedWD() <em>Associated WD</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedWD()
	 * @generated
	 * @ordered
	 */
	protected WorkDefinition associatedWD;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseResourcesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SimplepdlPackage.Literals.USE_RESOURCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(int newWeight) {
		int oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USE_RESOURCES__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getUsedResource() {
		if (usedResource != null && usedResource.eIsProxy()) {
			InternalEObject oldUsedResource = (InternalEObject)usedResource;
			usedResource = (Resource)eResolveProxy(oldUsedResource);
			if (usedResource != oldUsedResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplepdlPackage.USE_RESOURCES__USED_RESOURCE, oldUsedResource, usedResource));
			}
		}
		return usedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetUsedResource() {
		return usedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedResource(Resource newUsedResource) {
		Resource oldUsedResource = usedResource;
		usedResource = newUsedResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USE_RESOURCES__USED_RESOURCE, oldUsedResource, usedResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkDefinition getAssociatedWD() {
		if (associatedWD != null && associatedWD.eIsProxy()) {
			InternalEObject oldAssociatedWD = (InternalEObject)associatedWD;
			associatedWD = (WorkDefinition)eResolveProxy(oldAssociatedWD);
			if (associatedWD != oldAssociatedWD) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SimplepdlPackage.USE_RESOURCES__ASSOCIATED_WD, oldAssociatedWD, associatedWD));
			}
		}
		return associatedWD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkDefinition basicGetAssociatedWD() {
		return associatedWD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedWD(WorkDefinition newAssociatedWD) {
		WorkDefinition oldAssociatedWD = associatedWD;
		associatedWD = newAssociatedWD;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SimplepdlPackage.USE_RESOURCES__ASSOCIATED_WD, oldAssociatedWD, associatedWD));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SimplepdlPackage.USE_RESOURCES__WEIGHT:
				return getWeight();
			case SimplepdlPackage.USE_RESOURCES__USED_RESOURCE:
				if (resolve) return getUsedResource();
				return basicGetUsedResource();
			case SimplepdlPackage.USE_RESOURCES__ASSOCIATED_WD:
				if (resolve) return getAssociatedWD();
				return basicGetAssociatedWD();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SimplepdlPackage.USE_RESOURCES__WEIGHT:
				setWeight((Integer)newValue);
				return;
			case SimplepdlPackage.USE_RESOURCES__USED_RESOURCE:
				setUsedResource((Resource)newValue);
				return;
			case SimplepdlPackage.USE_RESOURCES__ASSOCIATED_WD:
				setAssociatedWD((WorkDefinition)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case SimplepdlPackage.USE_RESOURCES__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
				return;
			case SimplepdlPackage.USE_RESOURCES__USED_RESOURCE:
				setUsedResource((Resource)null);
				return;
			case SimplepdlPackage.USE_RESOURCES__ASSOCIATED_WD:
				setAssociatedWD((WorkDefinition)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SimplepdlPackage.USE_RESOURCES__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
			case SimplepdlPackage.USE_RESOURCES__USED_RESOURCE:
				return usedResource != null;
			case SimplepdlPackage.USE_RESOURCES__ASSOCIATED_WD:
				return associatedWD != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

} //UseResourcesImpl
