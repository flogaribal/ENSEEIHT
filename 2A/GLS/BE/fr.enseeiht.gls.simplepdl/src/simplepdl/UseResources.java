/**
 */
package simplepdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Resources</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link simplepdl.UseResources#getWeight <em>Weight</em>}</li>
 *   <li>{@link simplepdl.UseResources#getUsedResource <em>Used Resource</em>}</li>
 *   <li>{@link simplepdl.UseResources#getAssociatedWD <em>Associated WD</em>}</li>
 * </ul>
 *
 * @see simplepdl.SimplepdlPackage#getUseResources()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='correctWeight positiveWeight'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot correctWeight='self.weight <= self.usedResource.quantity' positiveWeight='self.weight >= 0'"
 * @generated
 */
public interface UseResources extends EObject {
	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see simplepdl.SimplepdlPackage#getUseResources_Weight()
	 * @model default="1"
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link simplepdl.UseResources#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

	/**
	 * Returns the value of the '<em><b>Used Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Resource</em>' reference.
	 * @see #setUsedResource(Resource)
	 * @see simplepdl.SimplepdlPackage#getUseResources_UsedResource()
	 * @model required="true"
	 * @generated
	 */
	Resource getUsedResource();

	/**
	 * Sets the value of the '{@link simplepdl.UseResources#getUsedResource <em>Used Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Resource</em>' reference.
	 * @see #getUsedResource()
	 * @generated
	 */
	void setUsedResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Associated WD</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated WD</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated WD</em>' reference.
	 * @see #setAssociatedWD(WorkDefinition)
	 * @see simplepdl.SimplepdlPackage#getUseResources_AssociatedWD()
	 * @model required="true"
	 * @generated
	 */
	WorkDefinition getAssociatedWD();

	/**
	 * Sets the value of the '{@link simplepdl.UseResources#getAssociatedWD <em>Associated WD</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated WD</em>' reference.
	 * @see #getAssociatedWD()
	 * @generated
	 */
	void setAssociatedWD(WorkDefinition value);

} // UseResources
