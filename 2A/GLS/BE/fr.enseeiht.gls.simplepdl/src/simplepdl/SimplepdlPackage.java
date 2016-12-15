/**
 */
package simplepdl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see simplepdl.SimplepdlFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface SimplepdlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simplepdl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://simplepdl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simplepdl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimplepdlPackage eINSTANCE = simplepdl.impl.SimplepdlPackageImpl.init();

	/**
	 * The meta object id for the '{@link simplepdl.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.impl.ProcessImpl
	 * @see simplepdl.impl.SimplepdlPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Process Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PROCESS_ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link simplepdl.impl.ProcessElementImpl <em>Process Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.impl.ProcessElementImpl
	 * @see simplepdl.impl.SimplepdlPackageImpl#getProcessElement()
	 * @generated
	 */
	int PROCESS_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ELEMENT__PROCESS = 0;

	/**
	 * The number of structural features of the '<em>Process Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Process Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link simplepdl.impl.WorkDefinitionImpl <em>Work Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.impl.WorkDefinitionImpl
	 * @see simplepdl.impl.SimplepdlPackageImpl#getWorkDefinition()
	 * @generated
	 */
	int WORK_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_DEFINITION__PROCESS = PROCESS_ELEMENT__PROCESS;

	/**
	 * The feature id for the '<em><b>Links To Predecessors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_DEFINITION__LINKS_TO_PREDECESSORS = PROCESS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Links To Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_DEFINITION__LINKS_TO_SUCCESSORS = PROCESS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_DEFINITION__NAME = PROCESS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_DEFINITION__USES = PROCESS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Work Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_DEFINITION_FEATURE_COUNT = PROCESS_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Work Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_DEFINITION_OPERATION_COUNT = PROCESS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link simplepdl.impl.WorkSequenceImpl <em>Work Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.impl.WorkSequenceImpl
	 * @see simplepdl.impl.SimplepdlPackageImpl#getWorkSequence()
	 * @generated
	 */
	int WORK_SEQUENCE = 3;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_SEQUENCE__PROCESS = PROCESS_ELEMENT__PROCESS;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_SEQUENCE__LINK_TYPE = PROCESS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_SEQUENCE__PREDECESSOR = PROCESS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_SEQUENCE__SUCCESSOR = PROCESS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Work Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_SEQUENCE_FEATURE_COUNT = PROCESS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Work Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_SEQUENCE_OPERATION_COUNT = PROCESS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link simplepdl.impl.GuidanceImpl <em>Guidance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.impl.GuidanceImpl
	 * @see simplepdl.impl.SimplepdlPackageImpl#getGuidance()
	 * @generated
	 */
	int GUIDANCE = 4;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE__PROCESS = PROCESS_ELEMENT__PROCESS;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE__ELEMENT = PROCESS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE__TEXT = PROCESS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Guidance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE_FEATURE_COUNT = PROCESS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Guidance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUIDANCE_OPERATION_COUNT = PROCESS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link simplepdl.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.impl.ResourceImpl
	 * @see simplepdl.impl.SimplepdlPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PROCESS = PROCESS_ELEMENT__PROCESS;

	/**
	 * The feature id for the '<em><b>Quantity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__QUANTITY = PROCESS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = PROCESS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = PROCESS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = PROCESS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link simplepdl.impl.UseResourcesImpl <em>Use Resources</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.impl.UseResourcesImpl
	 * @see simplepdl.impl.SimplepdlPackageImpl#getUseResources()
	 * @generated
	 */
	int USE_RESOURCES = 6;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_RESOURCES__WEIGHT = 0;

	/**
	 * The feature id for the '<em><b>Used Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_RESOURCES__USED_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Associated WD</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_RESOURCES__ASSOCIATED_WD = 2;

	/**
	 * The number of structural features of the '<em>Use Resources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_RESOURCES_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Use Resources</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_RESOURCES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link simplepdl.WorkSequenceType <em>Work Sequence Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see simplepdl.WorkSequenceType
	 * @see simplepdl.impl.SimplepdlPackageImpl#getWorkSequenceType()
	 * @generated
	 */
	int WORK_SEQUENCE_TYPE = 7;


	/**
	 * Returns the meta object for class '{@link simplepdl.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see simplepdl.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the attribute '{@link simplepdl.Process#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simplepdl.Process#getName()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link simplepdl.Process#getProcessElements <em>Process Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Process Elements</em>'.
	 * @see simplepdl.Process#getProcessElements()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_ProcessElements();

	/**
	 * Returns the meta object for class '{@link simplepdl.ProcessElement <em>Process Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Element</em>'.
	 * @see simplepdl.ProcessElement
	 * @generated
	 */
	EClass getProcessElement();

	/**
	 * Returns the meta object for the reference '{@link simplepdl.ProcessElement#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process</em>'.
	 * @see simplepdl.ProcessElement#getProcess()
	 * @see #getProcessElement()
	 * @generated
	 */
	EReference getProcessElement_Process();

	/**
	 * Returns the meta object for class '{@link simplepdl.WorkDefinition <em>Work Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Definition</em>'.
	 * @see simplepdl.WorkDefinition
	 * @generated
	 */
	EClass getWorkDefinition();

	/**
	 * Returns the meta object for the reference list '{@link simplepdl.WorkDefinition#getLinksToPredecessors <em>Links To Predecessors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links To Predecessors</em>'.
	 * @see simplepdl.WorkDefinition#getLinksToPredecessors()
	 * @see #getWorkDefinition()
	 * @generated
	 */
	EReference getWorkDefinition_LinksToPredecessors();

	/**
	 * Returns the meta object for the reference list '{@link simplepdl.WorkDefinition#getLinksToSuccessors <em>Links To Successors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Links To Successors</em>'.
	 * @see simplepdl.WorkDefinition#getLinksToSuccessors()
	 * @see #getWorkDefinition()
	 * @generated
	 */
	EReference getWorkDefinition_LinksToSuccessors();

	/**
	 * Returns the meta object for the attribute '{@link simplepdl.WorkDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simplepdl.WorkDefinition#getName()
	 * @see #getWorkDefinition()
	 * @generated
	 */
	EAttribute getWorkDefinition_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link simplepdl.WorkDefinition#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uses</em>'.
	 * @see simplepdl.WorkDefinition#getUses()
	 * @see #getWorkDefinition()
	 * @generated
	 */
	EReference getWorkDefinition_Uses();

	/**
	 * Returns the meta object for class '{@link simplepdl.WorkSequence <em>Work Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Sequence</em>'.
	 * @see simplepdl.WorkSequence
	 * @generated
	 */
	EClass getWorkSequence();

	/**
	 * Returns the meta object for the attribute '{@link simplepdl.WorkSequence#getLinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Type</em>'.
	 * @see simplepdl.WorkSequence#getLinkType()
	 * @see #getWorkSequence()
	 * @generated
	 */
	EAttribute getWorkSequence_LinkType();

	/**
	 * Returns the meta object for the reference '{@link simplepdl.WorkSequence#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see simplepdl.WorkSequence#getPredecessor()
	 * @see #getWorkSequence()
	 * @generated
	 */
	EReference getWorkSequence_Predecessor();

	/**
	 * Returns the meta object for the reference '{@link simplepdl.WorkSequence#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see simplepdl.WorkSequence#getSuccessor()
	 * @see #getWorkSequence()
	 * @generated
	 */
	EReference getWorkSequence_Successor();

	/**
	 * Returns the meta object for class '{@link simplepdl.Guidance <em>Guidance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guidance</em>'.
	 * @see simplepdl.Guidance
	 * @generated
	 */
	EClass getGuidance();

	/**
	 * Returns the meta object for the reference list '{@link simplepdl.Guidance#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element</em>'.
	 * @see simplepdl.Guidance#getElement()
	 * @see #getGuidance()
	 * @generated
	 */
	EReference getGuidance_Element();

	/**
	 * Returns the meta object for the attribute '{@link simplepdl.Guidance#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see simplepdl.Guidance#getText()
	 * @see #getGuidance()
	 * @generated
	 */
	EAttribute getGuidance_Text();

	/**
	 * Returns the meta object for class '{@link simplepdl.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see simplepdl.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link simplepdl.Resource#getQuantity <em>Quantity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quantity</em>'.
	 * @see simplepdl.Resource#getQuantity()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Quantity();

	/**
	 * Returns the meta object for the attribute '{@link simplepdl.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simplepdl.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for class '{@link simplepdl.UseResources <em>Use Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Resources</em>'.
	 * @see simplepdl.UseResources
	 * @generated
	 */
	EClass getUseResources();

	/**
	 * Returns the meta object for the attribute '{@link simplepdl.UseResources#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see simplepdl.UseResources#getWeight()
	 * @see #getUseResources()
	 * @generated
	 */
	EAttribute getUseResources_Weight();

	/**
	 * Returns the meta object for the reference '{@link simplepdl.UseResources#getUsedResource <em>Used Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used Resource</em>'.
	 * @see simplepdl.UseResources#getUsedResource()
	 * @see #getUseResources()
	 * @generated
	 */
	EReference getUseResources_UsedResource();

	/**
	 * Returns the meta object for the reference '{@link simplepdl.UseResources#getAssociatedWD <em>Associated WD</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated WD</em>'.
	 * @see simplepdl.UseResources#getAssociatedWD()
	 * @see #getUseResources()
	 * @generated
	 */
	EReference getUseResources_AssociatedWD();

	/**
	 * Returns the meta object for enum '{@link simplepdl.WorkSequenceType <em>Work Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Work Sequence Type</em>'.
	 * @see simplepdl.WorkSequenceType
	 * @generated
	 */
	EEnum getWorkSequenceType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimplepdlFactory getSimplepdlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link simplepdl.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.impl.ProcessImpl
		 * @see simplepdl.impl.SimplepdlPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__NAME = eINSTANCE.getProcess_Name();

		/**
		 * The meta object literal for the '<em><b>Process Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__PROCESS_ELEMENTS = eINSTANCE.getProcess_ProcessElements();

		/**
		 * The meta object literal for the '{@link simplepdl.impl.ProcessElementImpl <em>Process Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.impl.ProcessElementImpl
		 * @see simplepdl.impl.SimplepdlPackageImpl#getProcessElement()
		 * @generated
		 */
		EClass PROCESS_ELEMENT = eINSTANCE.getProcessElement();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_ELEMENT__PROCESS = eINSTANCE.getProcessElement_Process();

		/**
		 * The meta object literal for the '{@link simplepdl.impl.WorkDefinitionImpl <em>Work Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.impl.WorkDefinitionImpl
		 * @see simplepdl.impl.SimplepdlPackageImpl#getWorkDefinition()
		 * @generated
		 */
		EClass WORK_DEFINITION = eINSTANCE.getWorkDefinition();

		/**
		 * The meta object literal for the '<em><b>Links To Predecessors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_DEFINITION__LINKS_TO_PREDECESSORS = eINSTANCE.getWorkDefinition_LinksToPredecessors();

		/**
		 * The meta object literal for the '<em><b>Links To Successors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_DEFINITION__LINKS_TO_SUCCESSORS = eINSTANCE.getWorkDefinition_LinksToSuccessors();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_DEFINITION__NAME = eINSTANCE.getWorkDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_DEFINITION__USES = eINSTANCE.getWorkDefinition_Uses();

		/**
		 * The meta object literal for the '{@link simplepdl.impl.WorkSequenceImpl <em>Work Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.impl.WorkSequenceImpl
		 * @see simplepdl.impl.SimplepdlPackageImpl#getWorkSequence()
		 * @generated
		 */
		EClass WORK_SEQUENCE = eINSTANCE.getWorkSequence();

		/**
		 * The meta object literal for the '<em><b>Link Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_SEQUENCE__LINK_TYPE = eINSTANCE.getWorkSequence_LinkType();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_SEQUENCE__PREDECESSOR = eINSTANCE.getWorkSequence_Predecessor();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_SEQUENCE__SUCCESSOR = eINSTANCE.getWorkSequence_Successor();

		/**
		 * The meta object literal for the '{@link simplepdl.impl.GuidanceImpl <em>Guidance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.impl.GuidanceImpl
		 * @see simplepdl.impl.SimplepdlPackageImpl#getGuidance()
		 * @generated
		 */
		EClass GUIDANCE = eINSTANCE.getGuidance();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUIDANCE__ELEMENT = eINSTANCE.getGuidance_Element();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUIDANCE__TEXT = eINSTANCE.getGuidance_Text();

		/**
		 * The meta object literal for the '{@link simplepdl.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.impl.ResourceImpl
		 * @see simplepdl.impl.SimplepdlPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Quantity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__QUANTITY = eINSTANCE.getResource_Quantity();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '{@link simplepdl.impl.UseResourcesImpl <em>Use Resources</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.impl.UseResourcesImpl
		 * @see simplepdl.impl.SimplepdlPackageImpl#getUseResources()
		 * @generated
		 */
		EClass USE_RESOURCES = eINSTANCE.getUseResources();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_RESOURCES__WEIGHT = eINSTANCE.getUseResources_Weight();

		/**
		 * The meta object literal for the '<em><b>Used Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_RESOURCES__USED_RESOURCE = eINSTANCE.getUseResources_UsedResource();

		/**
		 * The meta object literal for the '<em><b>Associated WD</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_RESOURCES__ASSOCIATED_WD = eINSTANCE.getUseResources_AssociatedWD();

		/**
		 * The meta object literal for the '{@link simplepdl.WorkSequenceType <em>Work Sequence Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simplepdl.WorkSequenceType
		 * @see simplepdl.impl.SimplepdlPackageImpl#getWorkSequenceType()
		 * @generated
		 */
		EEnum WORK_SEQUENCE_TYPE = eINSTANCE.getWorkSequenceType();

	}

} //SimplepdlPackage
